package slam24.hm.com.holamundo;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.params.ColorSpaceTransform;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener{
    TextView campo_texto;
    EditText ET;
    ImageView imagel;
    Button botonenviar, botonn, toastButton,buttonActiviti,botonlista,btnwebview;
    LinearLayout ln;
    SensorManager sm;
    Sensor s;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ln = (LinearLayout) findViewById(R.id.sensor);
        tv = (TextView) findViewById(R.id.texto);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);

        campo_texto = (TextView) findViewById(R.id.texto);
        ET = (EditText) findViewById(R.id.username);

        campo_texto.setText("HOLA DE NUEVO JOSE");
        ET.setText("HOLA DE NUEVO JOSE");
        botonenviar = (Button) findViewById(R.id.botonenv);
        botonn = (Button) findViewById(R.id.botonenv2);

        imagel = (ImageView) findViewById(R.id.imagenlogin);

        botonenviar.setOnClickListener(this);
        botonn.setOnClickListener(this);
        toastButton = (Button)findViewById(R.id.toast);
        toastButton.setOnClickListener(this);

        buttonActiviti = (Button) findViewById(R.id.activitytoactivity);
        buttonActiviti.setOnClickListener(this);

        botonlista = (Button) findViewById(R.id.activitynew);
        botonlista.setOnClickListener(this);

        btnwebview = (Button) findViewById(R.id.webv);
        btnwebview.setOnClickListener(this);

        setToolbar();

    }
    public void  setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        toolbar.setTitle("SLAM24");
        setSupportActionBar(toolbar);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activitytoactivity:
                Intent intent =  new Intent(MainActivity.this,Main2Activity.class);
                String dato1 = ET.getText().toString();
                intent.putExtra("Dato",dato1);
                startActivity(intent);
                break;
            case R.id.webv:
                Intent intenta = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intenta);
                break;
            case R.id.activitynew:
                Intent intent3 = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent3);
                break;
            case R.id.toast:
                Toast.makeText(getApplicationContext(),"Esto es toast",Toast.LENGTH_SHORT).show();
                break;
            case R.id.botonenv:
                String dato = ET.getText().toString();
                campo_texto.setText(dato);
                break;
            case R.id.botonenv2:
                campo_texto.setText("el otro boton");
                break;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        /*hacer cada vez que se cambiar el sensor*/
        String texto = String.valueOf(sensorEvent.values[0]);
        tv.setText(texto);
        float valor = Float.parseFloat(texto);
        if (valor == 0){
            ln.setBackgroundColor(Color.BLUE);
        }else {
            ln.setBackgroundColor(Color.YELLOW);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
