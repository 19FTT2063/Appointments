package com.example.android.appointments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import java.math.BigDecimal;

import Config.Config;

public class PaymentPage extends AppCompatActivity {

    int cardNumber , expiryDate , cvcNumber;

    EditText cardnumber,expiry, cvc;

    Button btnPayNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        cardnumber = (EditText) findViewById(R.id.cardnumber);
        expiry = (EditText) findViewById(R.id.expiry);
        cvc = (EditText) findViewById(R.id.cvc);

        btnPayNow = (Button) findViewById(R.id.btnPayNow);

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cardNumber = Integer.valueOf(cardnumber.getText().toString());
//                expiryDate = Integer.valueOf(expiry.getText().toString());
//                cvcNumber = Integer.valueOf(cvc.getText().toString());
                openActivity3();

                showToast(cardNumber);
                showToast(expiryDate);
                showToast(cvcNumber);
            }
        });


        }

    private void showToast(int text){
        Toast.makeText(PaymentPage.this, text, Toast.LENGTH_SHORT).show();


    }
    private void openActivity3() {
        Intent intent = new Intent(this, QRCode.class);
        startActivity(intent);
    }
}