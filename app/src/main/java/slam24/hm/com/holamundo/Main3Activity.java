package slam24.hm.com.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bandas bandas_array[] = new bandas[]{
                new bandas(R.drawable.ic_launcher,"coldplay"),
                new bandas(R.drawable.ic_launcher,"coldplay"),
                new bandas(R.drawable.ic_launcher,"coldplay"),
                new bandas(R.drawable.ic_launcher,"coldplay"),
                new bandas(R.drawable.ic_launcher,"coldplay"),
                new bandas(R.drawable.ic_launcher,"coldplay"),
                new bandas(R.drawable.ic_launcher,"coldplay"),
                new bandas(R.drawable.ic_launcher,"coldplay"),
        };
        bandasAdapter adapter = new bandasAdapter(this,R.layout.listview_item_row,bandas_array);
        lv = (ListView) findViewById(R.id.tv);
        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView v = (TextView)view.findViewById(R.id.imgview);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
