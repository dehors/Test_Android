package slam24.hm.com.holamundo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SLAM24 on 8/31/2016.
 */
public class bandasAdapter extends ArrayAdapter<bandas>{
    Context context;
    int LayoutResourceId;
    bandas data[] = null;
    public bandasAdapter(Context context, int LayoutResourceId, bandas[] data){
        super(context, LayoutResourceId, data);

        this.context = context;
        this.LayoutResourceId = LayoutResourceId;
        this.data = data;
    }
    public View getView(int position, View convertview, ViewGroup parent){
        View row = convertview;
        bandasHolder holder = null;
        if (row==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(LayoutResourceId,parent,false);
            holder = new bandasHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.img);
            holder.text = (TextView) row.findViewById(R.id.imgview);
            row.setTag(holder);
        }else{
            holder = (bandasHolder)row.getTag();
        }
        bandas bandas = data[position];
        holder.text.setText(bandas.title);
        holder.imagen.setImageResource(bandas.icon);
        return row;
    }
    static class bandasHolder{
        ImageView imagen;
        TextView text;
    }
}
