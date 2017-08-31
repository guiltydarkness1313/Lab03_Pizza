package com.shibuyaxpress.lab03_pizza;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class PresentacionActivity extends AppCompatActivity {
    private VideoView videoView;
    private Button pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        pedido=(Button)findViewById(R.id.btn_pedido);
        videoView=(VideoView)findViewById(R.id.video_1);

        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.pizza_intro));
        videoView.start();
    }

    public void Go(View view){
        Intent launcher=new Intent(PresentacionActivity.this,PedidoActivity.class);
        startActivity(launcher);
    }
}
