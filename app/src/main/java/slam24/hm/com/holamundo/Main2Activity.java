package slam24.hm.com.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView texto;
    ListView lv;
    String[] valores = new String[]{"holanda","nicaragua","brasil","costa  rica"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,valores);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Position"+ i,Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        texto = (TextView) findViewById(R.id.msg);

        if(extra!=null){
            String dato = extra.getString("Dato");
            texto.setText(dato);
        }
    }
}
