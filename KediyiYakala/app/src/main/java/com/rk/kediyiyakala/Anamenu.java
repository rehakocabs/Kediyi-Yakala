package com.rk.kediyiyakala;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class Anamenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anamenu);

        //AŞAGIDAKİ KODLAR UYGULAMAYI FULL EKRAN YAPMAYA YARAR.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


    }


     public void oyunStart(View view) {

        Intent oyunaGec = new Intent(getApplicationContext(),OyunEkrani.class);
        startActivity(oyunaGec);

    }
       public void nasil(View view) {
            //uyariDailog sınıfını direkt burada cagırıp Anamenumuze entegre ediyoruz.
           // Atıl Hocamızın öğrettiğinide kullanabiliriz. İkisi de aynı sonucu vermektedir.
           AlertDialog.Builder nasilya = UyariDialog.alertBuilder(Anamenu.this);
           nasilya.setTitle("\t\t\t\t\t\tNasıl Oynanır?");
           nasilya.setMessage("Yaramaz Kedimiz Ekranda Sürekli Yer Değiştirecektir." +
                   "\n\nBu Yaramaz Kedinin Üzerine Tıklayarak Skorunuzu Arttırmanız Gerekecek." +
                   "\n\nBakalım En Yüksek Skorunu Sürekli Geçebilecek Misin :)" +
                   "\n\nDikkat Et Kedimiz Gerçekten Çok Yaramaz!");
           nasilya.setPositiveButton("ANLADIM!", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {

                   //BURAYI BOŞ BIRAKIRSANIZ ANLADIM BUTONUNA BASILDIGINDA DİREKT
                   //ALERTDİALOG KAPANACAKTIR. BİRŞEYLER YAZMAK İSTERSENİZ SİZ BİLİRSİNİZ.

               }
           });
           nasilya.show();



    }



    public void puanver(View view) {


        AlertDialog.Builder uygulamayaGit = UyariDialog.alertBuilder(Anamenu.this);
        uygulamayaGit.setTitle("\t\t\t\t\t\tBİZİ PUANLA!");
        uygulamayaGit.setMessage("Uygulamamızı sevdiyseniz ve daha da geliştirmemizi istediginiz özellikleri yorum olarak yazmak için bizi puanlayın.");
        uygulamayaGit.setPositiveButton("PUANVER!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // getPackageName() KOMUTU İLE UYGULAMAMIZIN PAKET ADINI ALIYORUZ.
                // YANİ : COM.RK.KEDIYIYAKALA BUNU.

                final String uygulamaLink = getPackageName();
                try
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + uygulamaLink)));
                }
                catch (android.content.ActivityNotFoundException anfe) {
                    //boş kalabilir.
                    //Emulator üzerinde tıkladıgınızda google play marketi olmadıgı için ekran gelmez uygulama kilitlenir.
                    //ama herhangi bir telefon üzerinde denerseniz uygulama play store da yuklu olmadıgı için not found hatası alırsınız..
                    //hata almamak isterseniz aşagıda ki kodun basında ki "//" işaretini silmeniz yeterlidir.

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + uygulamaLink)));
                }

            }
        });

        uygulamayaGit.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Puan vererek bize destek ol :(",Toast.LENGTH_SHORT).show();
            }
        });
        uygulamayaGit.show();






    }

}
