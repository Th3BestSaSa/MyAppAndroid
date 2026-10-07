package com.example.myapp;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TextView mCampotxt;
    private Button mBtnClikMe;
    private Button mBtnWeb;
    private Button mBtnLllamada;
    private Button mBtnCamara;
    private Button mBtnToast;
    private Button mBtnPrueba;
    private Button mBtnCyan;
    private Button mBtnTurquesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;
        });
        mCampotxt = findViewById(R.id.miCampoTexto);
        mCampotxt.setText("Hola, soy Celia Gandul");

        mBtnClikMe = findViewById(R.id.btn_click_me);
        mBtnClikMe.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent ejemplo = new Intent(MainActivity.this, TargetActivity.class);
                                              startActivity(ejemplo);
                                          }
                                      }

        );
        mBtnWeb = findViewById(R.id.btn_web);
        mBtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ejemplo = new Intent(Intent.ACTION_VIEW);
                ejemplo.setData(
                        Uri.parse(
                                "https://idocentic.website/"));
                startActivity(ejemplo);

            }
        });

        Button btnLlamar = findViewById(R.id.btn_Llamada);

        btnLlamar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            100
                    );

                } else {
                    Intent ejemplo = new Intent(Intent.ACTION_CALL);
                    ejemplo.setData(Uri.parse("tel:987654321"));
                    startActivity(ejemplo);
                }
            }
        });

        mBtnCamara = findViewById(R.id.btn_camara);
        mBtnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ejemplo = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(ejemplo);


            }
        });
        mBtnToast = findViewById(R.id.buttonToast);

        mBtnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "HOLA MUNDO", Toast.LENGTH_SHORT).show();

            }
        });

        mBtnPrueba = findViewById(R.id.btonPrueba);
        mBtnPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        LinearLayout mainLayout = findViewById(R.id.main);

        mBtnCyan = findViewById(R.id.btnCCyan);

        mBtnCyan.setOnClickListener(v -> {
            mainLayout.setBackgroundColor(Color.CYAN);
        });

      //  LinearLayout mainLayout = findViewById(R.id.main);

        mBtnTurquesa = findViewById(R.id.btnCTurquesa);

        mBtnTurquesa.setOnClickListener(v -> {
            mainLayout.setBackgroundColor(Color.parseColor("#40E0D0"));
        });

    }

}

