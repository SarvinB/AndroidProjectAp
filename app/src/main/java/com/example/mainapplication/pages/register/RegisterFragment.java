package com.example.mainapplication.pages.register;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mainapplication.R;
import com.example.mainapplication.data.entities.Admin;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.entities.Seller;
import com.example.mainapplication.data.repository.Repository;
import com.example.mainapplication.data.repository.RepositoryCallback;
import com.example.mainapplication.data.repository.Result;
import com.example.mainapplication.objects.Person;
import com.example.mainapplication.pages.home.HomeActivityAdmin;
import com.example.mainapplication.pages.home.HomeActivityCustomer;
import com.example.mainapplication.pages.home.HomeActivitySeller;
//import com.github.dhaval2404.imagepicker.ImagePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class RegisterFragment extends Fragment
{
    ImageButton gallery;
    ImageButton camera;
    Uri uri;
    Intent intent = new Intent();
    String[] user = {"Customer", "Admin", "Seller"};
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.register_fragment, container, false);
        Spinner userSpinner = view.findViewById(R.id.registerS);
        EditText username = view.findViewById(R.id.UserName);
        EditText email = view.findViewById(R.id.EmailR);
        EditText password = view.findViewById(R.id.PasswordR);
        EditText name = view.findViewById(R.id.Name);
        EditText lastname = view.findViewById(R.id.LastName);
        DatePicker datePicker = view.findViewById(R.id.date_picker);
        ScrollView scrollView = view.findViewById(R.id.scrollR);
        Button enter = view.findViewById(R.id.EnterB);
        gallery = view.findViewById(R.id.galleryB);
        camera = view.findViewById(R.id.cameraB);


        ArrayAdapter aa = new ArrayAdapter(view.getContext(), R.layout.support_simple_spinner_dropdown_item, user);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(aa);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = userSpinner.getSelectedItem().toString();
                EditText[] editTextList = {name, lastname, username, email, password};
                final int[] c = {0};
                for (int i = 0; i <= 4; i++) {
                    if (editTextList[i].length() == 0) {
                        editTextList[i].setError("This field must be full");
                        c[0] = 1;
                    }
                }

                switch (str) {
                    case "Customer": {
                        Repository.getInstance(getContext()).getAllCustomers(new RepositoryCallback<List<Customer>>() {
                            @Override
                            public void onComplete(Result<List<Customer>> result) {
                                if (result instanceof Result.Success) {
                                    for (int i = 0; i < ((Result.Success<List<Customer>>) result).data.size(); i++) {
                                        if (username.getText().toString().equals(((Result.Success<List<Customer>>) result).data.get(i).userName)) {
                                            c[0] = 1;
                                            username.setError("This username exist");
                                            break;
                                        }
                                    }
                                } else if (result instanceof Result.Error) {
                                    System.out.println("error");
                                }
                            }
                        });
                    }

                    case "Admin": {
                        Repository.getInstance(getContext()).getAllAdmins(new RepositoryCallback<List<Admin>>() {
                            @Override
                            public void onComplete(Result<List<Admin>> result) {
                                if (result instanceof Result.Success) {
                                    for (int i = 0; i < ((Result.Success<List<Admin>>) result).data.size(); i++) {
                                        if (username.getText().toString().equals(((Result.Success<List<Admin>>) result).data.get(i).userName)) {
                                            c[0] = 1;
                                            username.setError("This username exist");
                                            break;
                                        }
                                    }
                                } else if (result instanceof Result.Error) {
                                    System.out.println("error");
                                }
                            }
                        });
                    }

                    case "Seller": {
                        Repository.getInstance(getContext()).getAllSellers(new RepositoryCallback<List<Seller>>() {
                            @Override
                            public void onComplete(Result<List<Seller>> result) {
                                if (result instanceof Result.Success) {
                                    for (int i = 0; i < ((Result.Success<List<Seller>>) result).data.size(); i++) {
                                        if (username.getText().toString().equals(((Result.Success<List<Seller>>) result).data.get(i).userName)) {
                                            c[0] = 1;
                                            username.setError("This username exist");
                                            break;
                                        }
                                    }
                                } else if (result instanceof Result.Error) {
                                    System.out.println("error");
                                }
                            }
                        });
                    }
                }


                if(c[0] ==0)
                {
                    Person person = new Person();
                    person.setName(name.getText().toString());
                    person.setUsername(username.getText().toString());
                    person.setEmail(email.getText().toString());
                    person.setPassword(password.getText().toString());
                    person.setLastName(lastname.getText().toString());

                    if (datePicker != null)
                    {
                        String coStr = Integer.toString(datePicker.getYear())  + Integer.toString(datePicker.getMonth())
                                + Integer.toString(datePicker.getDayOfMonth());
                        person.setBirthday(coStr);
                    }

                    System.out.println(str);
                    //POINT: ADD IMAGE
                    switch (str)
                    {
                        case "Customer":
                        {
                            person.setUser(Person.User.CUSTOMER);
                            Customer customer = new Customer(person, 0, 0);
                            Repository.getInstance(getContext()).insertCustomer(customer, new RepositoryCallback<Void>() {
                                @Override
                                public void onComplete(Result<Void> result) {
                                    if(result instanceof Result.Success)
                                    {
                                        System.out.println("ok");
                                    }
                                    else if(result instanceof Result.Error)
                                    {
                                        System.out.println(((Result.Error<Void>) result).exception.getLocalizedMessage());
                                    }
                                }
                            });

                            Intent intent = new Intent();
                            intent.setClass(getActivity(), HomeActivityCustomer.class);
                            getActivity().startActivity(intent);
                        }

                        case "Admin": {
                            person.setUser(Person.User.ADMIN);
                            Admin admin = new Admin(person, 0, 0, 0);
                            Repository.getInstance(getContext()).insertAdmin(admin, new RepositoryCallback<Void>() {
                                @Override
                                public void onComplete(Result<Void> result) {
                                    if (result instanceof Result.Success) {
                                        System.out.println("ok");
                                    } else if (result instanceof Result.Error) {
                                        System.out.println(((Result.Error<Void>) result).exception.getLocalizedMessage());
                                    }
                                }
                            });
                            Intent intent = new Intent();
                            intent.setClass(getActivity(), HomeActivityAdmin.class);
                            getActivity().startActivity(intent);
                        }

                        case "Seller":
                        {
                            person.setUser(Person.User.SELLER);
                            Seller seller = new Seller(person, 0,0);
                            Repository.getInstance(getContext()).insertSeller(seller, new RepositoryCallback<Void>() {
                                @Override
                                public void onComplete(Result<Void> result) {
                                    if(result instanceof Result.Success)
                                    {
                                        System.out.println("ok");
                                    }
                                    else if(result instanceof Result.Error)
                                    {
                                        System.out.println(((Result.Error<Void>) result).exception.getLocalizedMessage());
                                    }
                                }
                            });
                            Intent intent = new Intent();
                            intent.setClass(getActivity(), HomeActivitySeller.class);
                            getActivity().startActivity(intent);
                        }
                    }
                }
            }
        });

//        gallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ImagePicker.with(getParentFragment())
//                        .crop()
//                        .galleryOnly()
//                        .start();
//            }
//        });
//
//
//        camera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ImagePicker.with(getParentFragment())
//                        .crop()
//                        .cameraOnly()
//                        .start();
//            }
//        });
        return view;
    }
}
