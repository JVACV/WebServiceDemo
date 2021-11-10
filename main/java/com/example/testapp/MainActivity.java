package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapp.app.MyApp;
import com.example.testapp.constants.Constants;
import com.example.testapp.data.DataProcessController;
import com.example.testapp.entity.RegisterResponseUser;
import com.example.testapp.entity.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
EditText phone,email,fname,lname,password,address,village,district;
Button sign_up;
User user=new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.editText_signup_email);
        phone=(EditText)findViewById(R.id.editText_signup_phone);
        fname=(EditText)findViewById(R.id.editText_signup_ftname);
        lname=(EditText)findViewById(R.id.editText_signup_ltname);
        address=(EditText)findViewById(R.id.editText_signup_address);
        password=(EditText)findViewById(R.id.editText_signup_password);
        village=(EditText)findViewById(R.id.editText_signup_village);
        district=(EditText)findViewById(R.id.editText_signup_district);
        sign_up=(Button)findViewById(R.id.button_signup_signup);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(phone.getText().toString()))
                {
                    phone.setError("Input Phone No");
                    return;
                }
                else if(TextUtils.isEmpty(password.getText().toString()))
                {
                    password.setError("Enter password");
                }
                else if (TextUtils.isEmpty(email.getText().toString().trim()))
                {
                    email.setError("input Email id");
                     if (!email.getText().toString().trim().matches("[a-zA-Z0-9._-]+[.]+[a-z]+"))
                     {
                         email.setError("invalid email address");
                     }
                     return;
                }
                else if (TextUtils.isEmpty(fname.getText().toString().trim()))
                {
                    fname.setError("input first name");
                    return;
                }
                else if (TextUtils.isEmpty(lname.getText().toString().trim()))
                {
                    lname.setError("input last name");
                    return;
                }
                else  if (TextUtils.isEmpty(village.getText().toString().trim()))
                {
                    village.setError("input village");
                    return;
                }
                else if (TextUtils.isEmpty(district.getText().toString()))
                {
                    district.setError("input district");
                    return;
                }
                else if (TextUtils.isEmpty(address.getText().toString()))
                {
                    address.setError("input address");
                    return;
                }
                else {
                    try
                    {
                        user.setUser_phone_no(phone.getText().toString());
                        user.setUser_email_id(email.getText().toString());
                        user.setPassword(password.getText().toString());
                        user.setUser_address(address.getText().toString());
                        user.setUser_district(district.getText().toString());
                        user.setUser_firstname(fname.getText().toString());
                        user.setUser_lastname(lname.getText().toString());
                        user.setUser_village(village.getText().toString());
                        getServerData(user);
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this, "Please Enter Data"+e, Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }
    public void getServerData(final User user) {

        final ProgressDialog ringProgressDialog=ProgressDialog.show(MainActivity.this,"Please Wait","Loading",true);
        ringProgressDialog.setCancelable(true);
        final Call<RegisterResponseUser> call= MyApp.getApiClient().register_user(user);
        call.enqueue(new Callback<RegisterResponseUser>() {
            @Override
            public void onResponse(Call<RegisterResponseUser> call, Response<RegisterResponseUser> response) {
                if (response.isSuccessful()) {
                    RegisterResponseUser registerRepsonseUser = response.body();
                    ringProgressDialog.dismiss();
                    if (registerRepsonseUser == null) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    } else if (Integer.parseInt(registerRepsonseUser.getStatus()) == 1) {
                        Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, login.class);
                        startActivity(i);
                    } else if (Integer.parseInt(registerRepsonseUser.getStatus()) == 2) {
                        Toast.makeText(MainActivity.this, "This Email is already exists", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Error in register try later", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, Constants.REST_ERROR_API_ERROR, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponseUser> call, Throwable t) {
                Toast.makeText(MainActivity.this,Constants.REST_ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                ringProgressDialog.dismiss();
            }
        });


    }
    }

