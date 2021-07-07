package com.example.mainapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class RegisterFragment extends Fragment implements AdapterView.OnItemSelectedListener
{

    String[] user = {"Admin", "Normal", "Seller"};
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.register_fragment, container, false);

        Spinner userSpinner = view.findViewById(R.id.user_spinner);
        EditText username = view.findViewById(R.id.UserName);
        EditText email = view.findViewById(R.id.EmailR);
        EditText password = view.findViewById(R.id.Password);
        EditText name = view.findViewById(R.id.Name);
        EditText lastname = view.findViewById(R.id.LastName);

        ArrayAdapter aa = new ArrayAdapter(view.getContext(), R.layout.support_simple_spinner_dropdown_item, user);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(aa);

            return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
    {
        Toast.makeText(getContext(), user[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        Toast.makeText(getContext(), "please take one of the users" , Toast.LENGTH_LONG).show();
    }
}
