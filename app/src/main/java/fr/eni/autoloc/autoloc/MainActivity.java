package fr.eni.autoloc.autoloc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fr.eni.autoloc.autoloc.BLL.DBManager;
import fr.eni.autoloc.autoloc.BO.Agence;
import fr.eni.autoloc.autoloc.activity.ParkingActivity;
import fr.eni.autoloc.autoloc.util.Constante;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private DBManager dbManager;

    private String agentId;
    private String agentMdp;
    private Agence agence;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = DBManager.getInstance(MainActivity.this);

        // Cacher l'action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // Récupérer la liste des agences
        List<Agence> agenceList = dbManager.getAllAgence();


        // Remplir le spinner des agences
        Spinner spinner = findViewById(R.id.spinner_agence);
        //TODO Inserer la liste esous forme de table de charSequence
        ArrayAdapter<Agence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, agenceList);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Récupérer les informations de la précédente connexion
        getSessionInfo();
        //Initialiser les champs avec les infos de la dernière connexion
        ((EditText) findViewById(R.id.edit_id)).setText(agentId);
        ((EditText) findViewById(R.id.edit_mdp)).setText(agentMdp);
        if (agence.getId() > 0) {
            ((Spinner) findViewById(R.id.spinner_agence)).setSelection(adapter.getPosition(agence));
        }
    }

    private void getSessionInfo() {

        sharedPreferences = getBaseContext().getSharedPreferences(Constante.SESSION, MODE_PRIVATE);

        agentId = sharedPreferences.getString(Constante.AGENT_ID, "");
        agentMdp = sharedPreferences.getString(Constante.AGENT_MDP, "");
        agence.setId(sharedPreferences.getInt(Constante.AGENCE_ID, -1));
        agence.setNom(sharedPreferences.getString(Constante.AGENCE_NOM, ""));
    }

    private void setSessionInfo(String id, String mdp, int agence_id, String agence_nom) {

        sharedPreferences = getBaseContext().getSharedPreferences(Constante.SESSION, MODE_PRIVATE);

        sharedPreferences.edit()
                .putString(Constante.AGENT_ID, id)
                .putString(Constante.AGENT_MDP, mdp)
                .putInt(Constante.AGENT_ID, agence_id)
                .putString(Constante.AGENCE_NOM, agence_nom)
                .apply();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        agence = (Agence) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void seConnecter(View view) {

        agentId = String.valueOf(((EditText) findViewById(R.id.edit_id)).getText());
        agentMdp = String.valueOf(((EditText) findViewById(R.id.edit_mdp)).getText());
        agence = (Agence) ((Spinner) findViewById(R.id.spinner_agence)).getSelectedItem();
        Boolean memoriser = ((CheckBox) findViewById(R.id.ck_memoriser)).isChecked();

        if (dbManager.connexion(agentId, agentMdp)) {
            if (memoriser) {
                setSessionInfo(agentId, agentMdp, agence.getId(), agence.getNom());
            }

            Intent intent = new Intent(MainActivity.this, ParkingActivity.class);

            startActivity(intent);
        } else {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_auth_refuse,
                    (ViewGroup) findViewById(R.id.custom_toast_auth_refuse));

            TextView text = (TextView) layout.findViewById(R.id.text_custom_toast);
            text.setText("NOPE");

            Toast toast = new Toast(MainActivity.this);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }
    }
}
