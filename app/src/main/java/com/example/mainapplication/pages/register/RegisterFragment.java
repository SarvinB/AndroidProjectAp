package com.example.mainapplication.pages.register;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
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
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
//import com.github.dhaval2404.imagepicker.ImagePicker;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegisterFragment extends AppCompatActivity {
    ImageView image;
    Spinner userSpinner;
    EditText username;
    EditText email;
    EditText password;
    EditText name;
    EditText lastname;
    DatePicker datePicker;
    ScrollView scrollView;
    Button enter;
    Button button;
    Uri imageUri;
    String[] user = {"Customer", "Admin", "Seller"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_fragment);

        userSpinner = findViewById(R.id.registerS);
        username = findViewById(R.id.UserName);
        email = findViewById(R.id.EmailR);
        password = findViewById(R.id.PasswordR);
        name = findViewById(R.id.Name);
        lastname = findViewById(R.id.LastName);
        datePicker = findViewById(R.id.date_picker);
        scrollView = findViewById(R.id.scrollR);
        enter = findViewById(R.id.EnterB);
        image = findViewById(R.id.imageView);


        ArrayAdapter aa = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, user);
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
                        Repository.getInstance(RegisterFragment.this).getAllCustomers(new RepositoryCallback<List<Customer>>() {
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
                        Repository.getInstance(RegisterFragment.this).getAllAdmins(new RepositoryCallback<List<Admin>>() {
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
                        Repository.getInstance(RegisterFragment.this).getAllSellers(new RepositoryCallback<List<Seller>>() {
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


                if (c[0] == 0) {
                    Person person = new Person();
                    person.setName(name.getText().toString());
                    person.setUsername(username.getText().toString());
                    person.setEmail(email.getText().toString());
                    person.setPassword(password.getText().toString());
                    person.setLastName(lastname.getText().toString());
                    person.setImage(imageUri.toString());

                    if (datePicker != null) {
                        String coStr = Integer.toString(datePicker.getYear()) + Integer.toString(datePicker.getMonth())
                                + Integer.toString(datePicker.getDayOfMonth());
                        person.setBirthday(coStr);
                    }

                    //POINT: ADD IMAGE
                    switch (str) {
                        case "Customer": {
                            person.setUser(Person.User.CUSTOMER);
                            Customer customer = new Customer(person, 0, 0);
                            Repository.getInstance(RegisterFragment.this).insertCustomer(customer, new RepositoryCallback<Void>() {
                                @Override
                                public void onComplete(Result<Void> result) {
                                    if (result instanceof Result.Success) {
                                        System.out.println("ok");
                                    } else if (result instanceof Result.Error) {
                                        System.out.println(((Result.Error<Void>) result).exception.getLocalizedMessage());
                                    }
                                }
                            });

                            Intent intent = new Intent(RegisterFragment.this, HomeActivityCustomer.class);
                            intent.putExtra("username", customer.userName);
                            intent.putExtra("email", customer.email);
                            intent.putExtra("image", customer.image);
                            RegisterFragment.this.startActivity(intent);
                        }

                        case "Admin": {
                            person.setUser(Person.User.ADMIN);
                            Admin admin = new Admin(person, 0, 0, 0);
                            Repository.getInstance(RegisterFragment.this).insertAdmin(admin, new RepositoryCallback<Void>() {
                                @Override
                                public void onComplete(Result<Void> result) {
                                    if (result instanceof Result.Success) {
                                        System.out.println("ok");
                                    } else if (result instanceof Result.Error) {
                                        System.out.println(((Result.Error<Void>) result).exception.getLocalizedMessage());
                                    }
                                }
                            });
                            Intent intent = new Intent(RegisterFragment.this, HomeActivityAdmin.class);
                            intent.putExtra("username", admin.userName);
                            intent.putExtra("email", admin.email);
                            intent.putExtra("image", admin.image);
                            RegisterFragment.this.startActivity(intent);
                        }

                        case "Seller": {
                            person.setUser(Person.User.SELLER);
                            Seller seller = new Seller(person, 0, 0);
                            Repository.getInstance(RegisterFragment.this).insertSeller(seller, new RepositoryCallback<Void>() {
                                @Override
                                public void onComplete(Result<Void> result) {
                                    if (result instanceof Result.Success) {
                                        System.out.println("ok");
                                    } else if (result instanceof Result.Error) {
                                        System.out.println(((Result.Error<Void>) result).exception.getLocalizedMessage());
                                    }
                                }
                            });
                            Intent intent = new Intent(RegisterFragment.this, HomeActivitySeller.class);
                            intent.putExtra("username", seller.userName);
                            intent.putExtra("email", seller.email);
                            intent.putExtra("image", seller.image);
                            RegisterFragment.this.startActivity(intent);
                        }
                    }
                }
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, 2);
            }
        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 2 && resultCode == RESULT_OK && data != null)
//        {
//            imageUri = data.getData();
//            image.setImageURI(imageUri);
//        }
//    }


}