package com.shibuyaxpress.lab03_pizza;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.VideoView;

public class PedidoActivity extends AppCompatActivity {

    Spinner nombresPizza;
    RadioGroup grupoMasa;
    CheckBox boxqueso,boxjamon;
    EditText direccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        nombresPizza=(Spinner)findViewById(R.id.spinner_pizza);
        grupoMasa=(RadioGroup)findViewById(R.id.group_masa);
        boxqueso=(CheckBox)findViewById(R.id.check_queso);
        boxjamon=(CheckBox)findViewById(R.id.check_jamon);
        direccion=(EditText)findViewById(R.id.txt_direccion);


    }

    public void ObtenerDatosCompra(View view){
        String direccionpedido=direccion.getText().toString();
        if(direccionpedido.matches("")||direccionpedido.length()<8) {
            AlertDialog.Builder constructor = new AlertDialog.Builder(PedidoActivity.this);
            constructor.setTitle("Confirmación de Pedido");
            constructor.setMessage("Ingrese una dirección para poder proceder");
            constructor.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            constructor.show();
        }else {
            String pizzaPedida = String.valueOf(nombresPizza.getSelectedItem());

            String complemento = "";

            String[] complement = new String[2];

            if (boxqueso.isChecked()) {
                complement[0] = "extra queso";
            } else {
                complement[0] = "";
            }
            if (boxjamon.isChecked()) {
                complement[1] = "extra jamon";
            } else {
                complement[1] = "";
            }
            complemento = complement[0] + " " + complement[1];

            Pizza e1 = new Pizza();
            e1.setNombre(pizzaPedida);
            e1.setComplementos(complemento);
            e1.obtenerPrecio(e1);

            RadioButton radio = (RadioButton) findViewById(grupoMasa.getCheckedRadioButtonId());
            //checkea si el radio button esta marcado
            if (grupoMasa.getCheckedRadioButtonId() == R.id.rd_btn_1) {
                AlertDialog.Builder constructor = new AlertDialog.Builder(PedidoActivity.this);
                constructor.setTitle("Confirmación de Pedido");
                constructor.setMessage("Su pedido de " + pizzaPedida + " con " + (radio.getText()).toString().toLowerCase() + " a S/." + e1.getPrecio() + "+IGV esta en proceso de envio");
                constructor.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                constructor.show();
                EnviarPedido();
            }
            if (grupoMasa.getCheckedRadioButtonId() == R.id.rd_btn_2) {
                AlertDialog.Builder constructor = new AlertDialog.Builder(PedidoActivity.this);
                constructor.setTitle("Confirmación de Pedido");
                constructor.setMessage("Su pedido de " + pizzaPedida + " con " + (radio.getText()).toString().toLowerCase() + " a S/." + e1.getPrecio() + "+IGV esta en proceso de envio");
                constructor.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                constructor.show();
                EnviarPedido();
            }
            if (grupoMasa.getCheckedRadioButtonId() == R.id.rd_btn_3) {
                AlertDialog.Builder constructor = new AlertDialog.Builder(PedidoActivity.this);
                constructor.setTitle("Confirmación de Pedido");
                constructor.setMessage("Su pedido de " + pizzaPedida + " con " + (radio.getText()).toString().toLowerCase() + " a S/." + e1.getPrecio() + "+IGV esta en proceso de envio");
                constructor.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                constructor.show();
                EnviarPedido();
            }
        }
    }

    public void EnviarPedido(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                NotificationCompat.Builder notificacion=new NotificationCompat.Builder(PedidoActivity.this);
                notificacion.setContentTitle("Pizza Hut");
                notificacion.setContentText("Su pedido ya se esta enviando");
                notificacion.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setPriority(Notification.PRIORITY_MAX);
                notificacion.setDefaults(Notification.DEFAULT_SOUND);

                Intent notificationIntent = new Intent(PedidoActivity.this, PresentacionActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(PedidoActivity.this, 0, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                notificacion.setContentIntent(contentIntent);

                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, notificacion.build());
            }
        },10000);

    }
}
