package com.example.mainapplication.pages.home;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mainapplication.R;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.repository.Repository;
import com.example.mainapplication.data.repository.RepositoryCallback;
import com.example.mainapplication.data.repository.Result;
import com.example.mainapplication.objects.Person;

import java.util.Date;
import java.util.List;

public class HomeActivityCustomer extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_customer);
        TextView textView = findViewById(R.id.testText);

//        Date date = new Date();
//        date.setTime(100);
//        Person person = new Person();
//        person.setUsername("sarvinB");
//        person.setUser(Person.User.CUSTOMER);
//        person.setBirthday(date.toString());
//        person.setEmail("sarvin80.b@gmail.com");
//        person.setLastName("baghi");
//        person.setName("sarvin");
//        person.setPassword("12345");
//        person.setImage("www.image.com");
//        Customer customer = new Customer(person, 0, 0);

//        Repository.getInstance(getApplicationContext()).insertCustomer(customer, new RepositoryCallback<Void>() {
//            @Override
//            public void onComplete(Result<Void> result) {
//                if(result instanceof Result.Success)
//                {
//                    textView.setText("ok");
//                }
//                else if(result instanceof Result.Error)
//                {
//                    textView.setText(((Result.Error<Void>) result).exception.getLocalizedMessage());
//                    System.out.println(((Result.Error<Void>) result).exception.getLocalizedMessage());
//                }
//            }
//        });

//            Repository.getInstance(getApplicationContext()).getAllCustomers(new RepositoryCallback<List<Customer>>() {
//                @Override
//                public void onComplete(Result<List<Customer>> result) {
//                    if(result instanceof Result.Success)
//                    {
//                        String str = ((Result.Success<List<Customer>>) result).data.get(0).name;
//                        textView.setText(str);
//                    }
//                    else if(result instanceof Result.Error)
//                    {
//                        textView.setText(((Result.Error<List<Customer>>) result).exception.getLocalizedMessage());
//                    }
//                }
//            });
    }
}
