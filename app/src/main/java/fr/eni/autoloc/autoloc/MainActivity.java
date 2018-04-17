package fr.eni.autoloc.autoloc;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import fr.eni.autoloc.autoloc.BO.Agence;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String email;
    private String mdp;
    private String agence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cacher l'action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // Remplir le spinner des agences

        Spinner spinner = findViewById(R.id.spinnerAgence);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.agences_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        agence = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    public void seConnecter(View view) {

        email = String.valueOf(((EditText)findViewById(R.id.editId)).getText());
        mdp = String.valueOf(((EditText)findViewById(R.id.editMdp)).getText());

        // Method de connexion

        /*
        if ( appel method )
            se connecter
        else
            dialog
         */


    }
}
