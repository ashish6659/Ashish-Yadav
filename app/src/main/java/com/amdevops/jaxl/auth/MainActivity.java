package com.amdevops.jaxl.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MainActivity extends AppCompatActivity {
    TextInputEditText editText;
    TextView mcount;
    Button button, confirmbtn;
    int code;
    String email="";
    PinView pinView;

    public  static String l1;
    public static String pass ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        l1=new String(Base64.decode(getString(R.string.ep),Base64.DEFAULT));
        pass= new String(Base64.decode(l1, Base64.DEFAULT));


        mcount=findViewById(R.id.otp_time);
        editText = findViewById(R.id.signup_Email);
        button = findViewById(R.id.signup_btn);
        pinView = findViewById(R.id.firstPinView);
        confirmbtn = findViewById(R.id.signup_confirm);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                code = random.nextInt(899999) + 100000;
                email=editText.getText().toString();

                sendmail();

            }
        });


        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputCode = pinView.getText().toString();
                if (inputCode.equals(String.valueOf(code))) {
                    setdata(email,code);
                    Intent intent = new Intent(MainActivity.this,NextActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                } else {
                    setdata("empty",code);
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });





        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    private void sendmail() {

        final String username="ashish_mc21014@srmcem.ac.in";
        Properties props=new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        Session session=Session.getInstance(props, new javax.mail.Authenticator(){


            @Override
            protected PasswordAuthentication getPasswordAuthentication(){

                return new PasswordAuthentication(username,pass);
            }


        });

        try{

            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Verify OTP");
            MimeMultipart multipart=new MimeMultipart();
            MimeBodyPart msgbody= new MimeBodyPart();
            msgbody.setContent("Your OTP is :"+"<h1>"+code+"<h1>","text/html");
            multipart.addBodyPart(msgbody);
            message.setContent(multipart);
            Transport.send(message);
            Toast.makeText(MainActivity.this, "Mail sent Successfully", Toast.LENGTH_SHORT).show();
            findViewById(R.id.LinearLayout_Email).setVisibility(View.GONE);
            findViewById(R.id.LinearLayout_PinView).setVisibility(View.VISIBLE);
            updateCount();
            editText.getText().clear();


        }catch (MessagingException e){
            Toast.makeText(MainActivity.this, "Error"+e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }
        catch(Exception e)
        {
            Toast.makeText(MainActivity.this, "Error"+e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }

    private void setdata(String email,int code) {

            SharedPreferences myPreferences
            = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
            SharedPreferences.Editor myEditor = myPreferences.edit();
			myEditor.putString("email",email);
			myEditor.putInt("code",code);
			myEditor.apply();
    }

    private void updateCount() {

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mcount.setText(""+millisUntilFinished / 1000);
                // logic to set the EditText could go here
            }

            public void onFinish() {
                Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                findViewById(R.id.LinearLayout_Email).setVisibility(View.VISIBLE);
                findViewById(R.id.LinearLayout_PinView).setVisibility(View.GONE);
            }

        }.start();

    }




}