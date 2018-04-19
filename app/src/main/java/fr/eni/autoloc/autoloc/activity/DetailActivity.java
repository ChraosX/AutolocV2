package fr.eni.autoloc.autoloc.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import fr.eni.autoloc.autoloc.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageButton previous = findViewById(R.id.btn_previous);
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
        });
    }
}
