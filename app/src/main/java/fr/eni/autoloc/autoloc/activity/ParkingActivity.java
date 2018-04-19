package fr.eni.autoloc.autoloc.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.eni.autoloc.autoloc.BO.Vehicule;
import fr.eni.autoloc.autoloc.R;
import fr.eni.autoloc.autoloc.activity.fragment.DetailFragment;
import fr.eni.autoloc.autoloc.activity.fragment.ParkingFragment;

public class ParkingActivity extends AppCompatActivity implements ParkingFragment.OnListFragmentInteractionListener, DetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public void onListFragmentInteraction(Vehicule vehicule) {

        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detail);

        if (detailFragment != null && detailFragment.isInLayout()) {
            detailFragment.setContent(vehicule);
        }
        else {
            Intent intent = new Intent(ParkingActivity.this, DetailActivity.class);
            intent.putExtra("vehicule", vehicule);
            startActivity(intent);
        }
    }
}