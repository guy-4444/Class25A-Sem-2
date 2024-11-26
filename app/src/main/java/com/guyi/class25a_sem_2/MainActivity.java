package com.guyi.class25a_sem_2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.guyi.class25a_sem_2.databinding.ActivityMainBinding;
import com.guyi.countriesdata.CountriesUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ArrayList<String> names = CountriesUtil.getCountriesNames();

        ArrayAdapter<String> streetAdapter = new ArrayAdapter<String>(this, R.layout.list_single_line, names);
        AutoCompleteTextView view = (AutoCompleteTextView) binding.EDTCountry.getEditText();
        assert view != null;
        view.setAdapter(streetAdapter);

        ((MaterialAutoCompleteTextView) binding.EDTCountry.getEditText()).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("pttt", "position=" + position);
                binding.LBLTitle.setText(names.get(position));

                Toast.makeText(MainActivity.this, CountriesUtil.getCurrency(names.get(position)), Toast.LENGTH_SHORT).show();
            }
        });
    }
}