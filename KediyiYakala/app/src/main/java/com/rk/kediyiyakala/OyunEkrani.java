package com.rk.kediyiyakala;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class OyunEkrani extends AppCompatActivity {


    TextView kalanZaman;
    TextView skorSayac;
    TextView zamanSayacx;
    ImageView kedicik;
    Handler handler;
    Runnable runnable;
    Button oyunBasla;
    int yuksekSkor;
    int skorKontrol;
    int skor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oyun_ekrani);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        kalanZaman = findViewById(R.id.kalanZaman);
        skorSayac = findViewById(R.id.skorSayac);
        zamanSayacx = findViewById(R.id.zamanSayac);
        oyunBasla = findViewById(R.id.oyunBasla);
        kedicik = findViewById(R.id.kedicik);
        yuksekSkor = -1;
        skor1=0;
        skorKontrol = 1;


    }

    public void startGame (View view) {

        skorSayac.setText("Skorun : 0");
        skor1 = 0;
        skorKontrol = 1;
        oyunBasla.setVisibility(View.GONE);
        zamanSayac();
        gameTime();
    }

    public void zamanSayac() {


        new CountDownTimer(15000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {
                zamanSayacx.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {

                skorAlarm();
                handler.removeCallbacks(runnable);
                final MediaPlayer skorEkran = MediaPlayer.create(OyunEkrani.this, R.raw.skor);
                skorEkran.start();
                skorKontrol =1;
                oyunBasla.setVisibility(View.VISIBLE);
            }


        }.start();


    }
        public void keditik(View view){

        if(skorKontrol == 1){

            skor1++;
            skorSayac.setText("Skorun : " + skor1);

        }

        }

    public void skorAlarm() {
        AlertDialog.Builder scoreAlert = UyariDialog.alertBuilder(OyunEkrani.this);
        scoreAlert.setTitle("\t\t\t\t\t\t\t\tOyun Bitti.");
        scoreAlert.setMessage("\n\n\t\t\t\t\t\t\t\tSkorun " + skor1);
        scoreAlert.show();
    }



    public void gameTime() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                int kedicimX = random.nextInt(500);
                int kedicimY = random.nextInt(700);
                kedicik.setX(kedicimX);
                kedicik.setY(kedicimY);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);
    }

}

