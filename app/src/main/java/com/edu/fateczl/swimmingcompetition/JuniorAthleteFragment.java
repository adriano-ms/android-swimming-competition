package com.edu.fateczl.swimmingcompetition;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.fateczl.swimmingcompetition.model.JuniorAthlete;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Adriano M Sanchez
 */
public class JuniorAthleteFragment extends Fragment {

    private static final SimpleDateFormat SDF  = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "br"));

    private View view;
    private EditText etNameJA;
    private EditText etBirthdateJA;
    private EditText etNeighborhoodJA;
    private EditText etYearsPracticingJA;
    private Button btSaveJA;

    public JuniorAthleteFragment(){
        super();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_junior_athlete, container, false);
        etNameJA = view.findViewById(R.id.etNameJA);
        etBirthdateJA = view.findViewById(R.id.etBirthdateJA);
        etNeighborhoodJA = view.findViewById(R.id.etNeighborhoodJA);
        etYearsPracticingJA = view.findViewById(R.id.etYearsPracticingJA);
        btSaveJA = view.findViewById(R.id.btSaveJA);
        btSaveJA.setOnClickListener(b -> save());
        return view;
    }

    public void save(){
        JuniorAthlete athlete = new JuniorAthlete();
        athlete.setName(etNameJA.getText().toString());
        try {
            athlete.setBirthdate(SDF.parse(etBirthdateJA.getText().toString()).toInstant());
        } catch (Exception e) {
            new AlertDialog.Builder(view.getContext()).setTitle(getString(R.string.alert_error_title)).setMessage(R.string.alert_invalid_date).show();
        }
        athlete.setNeighborhood(etNeighborhoodJA.getText().toString());
        athlete.setYearsPracticing(Integer.parseInt(etYearsPracticingJA.getText().toString()));
        Toast.makeText(view.getContext(), athlete.toString(), Toast.LENGTH_LONG).show();
    }
}