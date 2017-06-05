package com.example.narino;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

//

public class DetMunicipio extends AppCompatActivity {
    String  mun, webUrl, alc, dir,tel,emai;
    TextView nombreMun,alcalde,direc,telef,email;
    Button boton;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_det_municipio);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        nombreMun = (TextView) findViewById(R.id.txtMun);
        alcalde = (TextView) findViewById(R.id.txtAlc);
        direc = (TextView) findViewById(R.id.txtDir);
        telef = (TextView) findViewById(R.id.txtTel);
        email = (TextView) findViewById(R.id.txtEma);


        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r3---sn-q4fl6n7e.googlevideo.com/Cj0LENy73wIaNAnhtiudAMlusBMYDSANFC3EqTRZMOCoAUIASARg28e_wpHpz89YigELTzg3cWQ3YmhpSjgM/D3A2520E53993182AE0ACB0AC2744C811A5FE87A.902387FF135AF55DE4FD08A0E374BDA979502A62/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        Bundle bundle = getIntent().getExtras();
        mun =  bundle.getString("mun");
        alc =  bundle.getString("alc");
        emai =  bundle.getString("email");
        dir =  bundle.getString("dir");
        tel =  bundle.getString("tel");
        webUrl =  bundle.getString("web");

        nombreMun.setText(mun);
        alcalde.setText(alc);
        direc.setText(dir);
        telef.setText(tel);
        email.setText(emai);


    }

public void web(View view){

    Intent intent = new Intent(this, Municipio.class);
    intent.putExtra("web", webUrl);
    startActivity(intent);
}

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }

}



