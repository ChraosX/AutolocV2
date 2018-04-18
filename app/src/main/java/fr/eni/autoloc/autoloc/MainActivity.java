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

import fr.eni.autoloc.autoloc.activity.ParkingActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String SESSION = "SESSION";
    private static final String AGENT_ID = "AGENT_ID";
    private static final String AGENT_MDP = "AGENT_MDP";
    private static final String AGENCE = "AGENCE";

    private String agentId;
    private String agentMdp;
    private String agence;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cacher l'action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // Récupérer la liste des agences
        //TODO Recuperer la lsite des agences

        // Remplir le spinner des agences
        Spinner spinner = findViewById(R.id.spinner_agence);
        //TODO Inserer la liste esous forme de table de charSequence
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.agences_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Récupérer les informations de la précédente connexion
        getSessionInfo();
        //Initialiser les champs avec les infos de la dernière connexion
        ((EditText)findViewById(R.id.edit_id)).setText(agentId);
        ((EditText)findViewById(R.id.edit_mdp)).setText(agentMdp);
        ((Spinner)findViewById(R.id.spinner_agence)).setSelection(adapter.getPosition(agence));
    }

    private void getSessionInfo() {

        sharedPreferences = getBaseContext().getSharedPreferences(SESSION,MODE_PRIVATE);

        agentId = sharedPreferences.getString(AGENT_ID,"");
        agentMdp = sharedPreferences.getString(AGENT_MDP,"");
        agence = sharedPreferences.getString(AGENCE, "");
    }

    private void setSessionInfo(String id ,String mdp, String agence) {

        sharedPreferences = getBaseContext().getSharedPreferences(SESSION, MODE_PRIVATE);

        sharedPreferences.edit()
                .putString(AGENT_ID, id)
                .putString(AGENT_MDP, mdp)
                .putString(AGENCE, agence)
                .apply();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        agence = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    public void seConnecter(View view) {

        agentId = String.valueOf(((EditText) findViewById(R.id.edit_id)).getText());
        agentMdp = String.valueOf(((EditText) findViewById(R.id.edit_mdp)).getText());
        agence = String.valueOf(((Spinner) findViewById(R.id.spinner_agence)).getSelectedItem());
        Boolean memoriser = ((CheckBox) findViewById(R.id.ck_memoriser)).isChecked();

        //TODO ajouter la méthode de vérification dans la bdd
        if ( /* il y a nu resultat */) {
            if (memoriser) {
                setSessionInfo(agentId, agentMdp, agence);
            }

            Intent intent = new Intent(MainActivity.this, ParkingActivity.class);

            startActivity(intent);
        }
        else {
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
