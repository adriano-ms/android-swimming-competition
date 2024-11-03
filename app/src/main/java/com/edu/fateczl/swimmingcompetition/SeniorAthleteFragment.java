package com.edu.fateczl.swimmingcompetition;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.fateczl.swimmingcompetition.model.SeniorAthlete;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Adriano M Sanchez
 */
public class SeniorAthleteFragment extends Fragment {

    private static final SimpleDateFormat SDF  = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "br"));

    private View view;
    private EditText etNameSA;
    private EditText etBirthdateSA;
    private EditText etNeighborhoodSA;
    private CheckBox cbHeartDiseasesSA;
    private Button btSaveSA;

    public SeniorAthleteFragment(){
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_senior_athlete, container, false);
        etNameSA = view.findViewById(R.id.etNameSA);
        etBirthdateSA = view.findViewById(R.id.etBirthdateSA);
        etNeighborhoodSA = view.findViewById(R.id.etNeighborhoodSA);
        cbHeartDiseasesSA = view.findViewById(R.id.cbHeartDiseasesSA);
        btSaveSA = view.findViewById(R.id.btSaveSA);
        btSaveSA.setOnClickListener(b -> save());
        return view;
    }

    public void save(){
        SeniorAthlete athlete = new SeniorAthlete();
        athlete.setName(etNameSA.getText().toString());
        try {
            athlete.setBirthdate(SDF.parse(etBirthdateSA.getText().toString()).toInstant());
        } catch (Exception e) {
            new AlertDialog.Builder(view.getContext()).setTitle(getString(R.string.alert_error_title)).setMessage(R.string.alert_invalid_date).show();
        }
        athlete.setNeighborhood(etNeighborhoodSA.getText().toString());
        athlete.setHeartDisease(cbHeartDiseasesSA.isChecked());
        Toast.makeText(view.getContext(), athlete.toString(), Toast.LENGTH_LONG).show();
    }
}