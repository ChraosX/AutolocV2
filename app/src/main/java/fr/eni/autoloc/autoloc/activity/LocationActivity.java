package fr.eni.autoloc.autoloc.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import fr.eni.autoloc.autoloc.BLL.DBManager;
import fr.eni.autoloc.autoloc.BO.Location;
import fr.eni.autoloc.autoloc.R;

public class LocationActivity extends AppCompatActivity {

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        dbManager = DBManager.getInstance(LocationActivity.this);

        /*ImageButton previous = findViewById(R.id.btn_previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView photo = findViewById(R.id.photo);
                photo.setImageURI();
            }
        });

        ImageButton next = findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView photo = findViewById(R.id.photo);
                photo.setImageURI();
            }
        });*/
    }

    public void terminerLocation(View view) {

        //TODO Récuperer les données de location et crée l'isntance

        LocationTask locationTask = new LocationTask();

        /*locationTask.execute(location);*/
    }

    public void annulerLocation(View view) {
        finish();
    }



    private class LocationTask extends AsyncTask<Location, Void, Void> {


        @Override
        protected Void doInBackground(Location... locations) {

            //TODO Inserer en base la location

            return null;
        }
    }
}
