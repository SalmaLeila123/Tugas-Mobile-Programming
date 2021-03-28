package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    Button btnSave, btnDelete;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FormActivity.this);
                //title
                alertDialogBuilder.setTitle("Peringatan !! ");
                // message
                alertDialogBuilder.setMessage("Apakah Anda yakin Untuk Menghapus Data?")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Data Terhapus", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                //Create Dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                //show Dialog
                alertDialog.show();
            }
        });
        etPassword = findViewById(R.id.etPassword);
        etPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPassword.getText().toString().length()==0){
                    etPassword.setError("Password Tidak Boleh Kosong");
                }else {
                    Toast.makeText(FormActivity.this,"Password Berhasil",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}