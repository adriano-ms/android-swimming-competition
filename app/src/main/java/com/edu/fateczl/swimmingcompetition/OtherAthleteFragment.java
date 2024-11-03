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

import com.edu.fateczl.swimmingcompetition.model.OtherAthlete;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Adriano M Sanchez
 */
public class OtherAthleteFragment extends Fragment {

    private static final SimpleDateFormat SDF  = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "br"));

    private View view;
    private EditText etNameOA;
    private EditText etBirthdateOA;
    private EditText etNeighborhoodOA;
    private EditText etGymOA;
    private EditText etRecordInSecondsOA;
    private Button btSaveOA;

    public OtherAthleteFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_other_athlete, container, false);
        etNameOA = view.findViewById(R.id.etNameOA);
        etBirthdateOA = view.findViewById(R.id.etBirthdateOA);
        etNeighborhoodOA = view.findViewById(R.id.etNeighborhoodOA);
        etGymOA = view.findViewById(R.id.etGymOA);
        etRecordInSecondsOA = view.findViewById(R.id.etRecordInSecondsOA);
        btSaveOA = view.findViewById(R.id.btSaveOA);
        btSaveOA.setOnClickListener(b -> save());
        return view;
    }

    public void save(){
        OtherAthlete athlete = new OtherAthlete();
        athlete.setName(etNameOA.getText().toString());
        try {
            athlete.setBirthdate(SDF.parse(etBirthdateOA.getText().toString()).toInstant());
        } catch (Exception e) {
            new AlertDialog.Builder(view.getContext()).setTitle(getString(R.string.alert_error_title)).setMessage(R.string.alert_invalid_date).show();
        }
        athlete.setNeighborhood(etNeighborhoodOA.getText().toString());
        athlete.setGym(etGymOA.getText().toString());
        athlete.setRecordInSeconds(Integer.parseInt(etRecordInSecondsOA.getText().toString()));
        Toast.makeText(view.getContext(), athlete.toString(), Toast.LENGTH_LONG).show();
    }
}