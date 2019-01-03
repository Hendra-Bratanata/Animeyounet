package com.example.balar.animeyounet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailAnime extends AppCompatActivity {

    @BindView(R.id.dtJudul)
    TextView judul;
    @BindView(R.id.buttonfull)
    Button btnfull;
    @BindView(R.id.dtGambar)
    ImageView gambar;
    @BindView(R.id.dtTanggal)
    TextView tanggal;
    /*@BindView(R.id.dtGenre)
    TextView genre;*/

    @BindView(R.id.video)
    WebView video;

   public Anime detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_anime);

        ButterKnife.bind(this);
        detail = getIntent().getParcelableExtra("detail");
        btnfull.setVisibility(View.INVISIBLE);
btnfull.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(DetailAnime.this,FullscreenActivity.class);
        intent.putExtra("link",detail);
        startActivity(intent);
    }
});


        judul.setText(detail.getJudul());
        tanggal.setText(detail.getTanggal());
        Glide.with(this)
                .load(detail.getGambar())
                .into(gambar);

        video.loadUrl("file:///android_asset/video.html");
        video.getSettings().setJavaScriptEnabled(true);





//      untuk set webView saat diload pertamakali
        video.setWebViewClient(new WebViewClient(){

// method loadPageFinish untuk set semua asset yang ada sebelum selesai di tampilkan
            @Override
            public void onPageFinished(WebView view, String url) {
                String Google = detail.getVideo();//Masukan string video 1 disini
                String GDrive = detail.getVideo1();//Masukan string video 2 disini
                String YouDrive = detail.getVideo2();//Masukan string video 3 disini
//              panggil fungsi loadUrl lalu buat javascript untuk menganti atribute dari iframe dengan id iframe
//              berlaku juga untuk sytax html lain
                video.loadUrl("javascript:(function(){" +
                        "document.getElementById('Google').src ='"+ Google+"'})()");
                video.loadUrl("javascript:(function(){" +
                        "document.getElementById('GDrive').src ='"+ GDrive+"'})()");
                video.loadUrl("javascript:(function(){" +
                        "document.getElementById('YouDrive').src ='"+ YouDrive+"'})()");
                btnfull.setVisibility(View.VISIBLE);
            }
        });


    }

//
}
