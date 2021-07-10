package com.example.mainapplication.pages.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.mainapplication.pages.home.HomeActivityAdmin;
import com.example.mainapplication.pages.home.HomeActivityCustomer;
import com.example.mainapplication.pages.home.HomeActivitySeller;
import com.example.mainapplication.objects.Person;
import com.example.mainapplication.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginFragment extends Fragment
{

    GoogleSignInClient mGoogleSignInClient;
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(intent);
                        handleSignInResult(task);
                    }
                }
            });

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        AppCompatButton enter = view.findViewById(R.id.EnterB);
        AppCompatButton register = view.findViewById(R.id.RegisterB);
        EditText email = view.findViewById(R.id.Email);
        EditText password = view.findViewById(R.id.Password);
        TextView forget = view.findViewById(R.id.ForgetPW);
        TextView error = view.findViewById(R.id.ErrorText);
        SignInButton google = view.findViewById(R.id.sign_in_button);
        google.setSize(SignInButton.SIZE_STANDARD);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getActivity());
        updateUI(account);
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            updateUI(null);
        }
    }

    private void updateUI(GoogleSignInAccount acct) {
        if(acct != null)
        {
            Person person = new Person();
//            person.setName(acct.getDisplayName());

            //POINT: SETBIRTHDAY
            //person.setBirthday();
//            person.setEmail(acct.getEmail());
//            person.setLastName(acct.getFamilyName());
//            person.setImage(acct.getPhotoUrl().toString());

            //POINT: SET USER
            person.setUser(Person.User.CUSTOMER);
//            person.setUsername(acct.getGivenName());

            switch (person.getUser())
            {
                case CUSTOMER:
                {
                    Intent intent = new Intent(getContext(), HomeActivityCustomer.class);
                    startActivity(intent);
                    break;
                }

                case ADMIN:
                {
                    Intent intent = new Intent(getContext(), HomeActivityAdmin.class);
                    startActivity(intent);
                    break;
                }

                case SELLER:
                {
                    Intent intent = new Intent(getContext(), HomeActivitySeller.class);
                    startActivity(intent);
                    break;
                }
            }
            getActivity().finish();
        }
        else
        {
            Toast.makeText(getActivity(), "account not find!", Toast.LENGTH_SHORT).show();
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        mStartForResult.launch(signInIntent);
    }


}
