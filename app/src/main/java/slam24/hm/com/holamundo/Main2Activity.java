package slam24.hm.com.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        texto = (TextView) findViewById(R.id.msg);

        if(extra!=null){
            String dato = extra.getString("Dato");
            texto.setText(dato);
        }
    }
}
