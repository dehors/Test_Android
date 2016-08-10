package slam24.hm.com.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView campo_texto;
    EditText ET;
    ImageView imagel;
    Button botonenviar, botonn, toastButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
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
}
