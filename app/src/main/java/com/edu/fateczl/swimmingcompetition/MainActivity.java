package com.edu.fateczl.swimmingcompetition;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

/**
 * @author Adriano M Sanchez
 */
public class MainActivity extends AppCompatActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle bundle = getIntent().getExtras();
        loadFragment(bundle);
    }

    private void loadFragment(Bundle bundle) {
        if(bundle != null && !bundle.isEmpty()) {
            switch (Objects.requireNonNull(bundle.getString("athleteType"))) {
                case "junior":
                    fragment = new JuniorAthleteFragment();
                    break;
                case "senior":
                    fragment = new SeniorAthleteFragment();
                    break;
                default:
                    fragment = new OtherAthleteFragment();
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, MainActivity.class);
        if(itemId == R.id.miJuniorAthlete){
            bundle.putString("athleteType","junior");
        }
        if(itemId == R.id.miSeniorAthlete){
            bundle.putString("athleteType","senior");
        }
        if(itemId == R.id.miOtherAthlete){
            bundle.putString("athleteType","other");
        }
        intent.putExtras(bundle);
        this.startActivity(intent);
        this.finish();
        return super.onOptionsItemSelected(item);
    }
}