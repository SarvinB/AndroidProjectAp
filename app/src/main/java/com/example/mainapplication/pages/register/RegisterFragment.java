package com.example.mainapplication.pages.register;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mainapplication.R;

import org.jetbrains.annotations.NotNull;

public class RegisterFragment extends Fragment
{
    String[] user = {"Normal", "Admin", "Seller"};
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.register_fragment, container, false);
        Spinner userSpinner = view.findViewById(R.id.user_spinner);
        EditText username = view.findViewById(R.id.UserName);
        EditText email = view.findViewById(R.id.EmailR);
        EditText password = view.findViewById(R.id.PasswordR);
        EditText name = view.findViewById(R.id.Name);
        EditText lastname = view.findViewById(R.id.LastName);
        DatePicker datePicker = view.findViewById(R.id.date_picker);
        ScrollView scrollView = view.findViewById(R.id.scrollR);
        Button enter = view.findViewById(R.id.EnterB);

        ArrayAdapter aa = new ArrayAdapter(view.getContext(), R.layout.support_simple_spinner_dropdown_item, user);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(aa);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText[] editTextList = {name, lastname, username, email, password};
                int c = 0;
                for (int i = 0; i <= 4; i++) {
                    if (editTextList[i].length() == 0) {
                        editTextList[i].setError("This field must be full");
                        c = 1;
                    }
                }


            }
        });

//        Person person = new Person();
//        person.setName(name.getText().toString());
//        person.setUsername(username.getText().toString());
//        person.setEmail(email.getText().toString());
//        person.setPassword(password.getText().toString());
//        person.setLastName(lastname.getText().toString());
//
//        String coStr = Integer.toString(datePicker.getYear())  + Integer.toString(datePicker.getMonth())
//                + Integer.toString(datePicker.getDayOfMonth());
//        person.setBirthday(coStr);
        return view;
    }

}
