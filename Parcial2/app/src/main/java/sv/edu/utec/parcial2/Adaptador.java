package sv.edu.utec.parcial2;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {
    Context contexto;
    int layout;
    List<String> empleado;
    List<String> descrip;
    List<String> compa;
    int[]imagenes;

    public Adaptador(Context contexto, int layout, List<String> empleado, List<String> descrip, List<String> compa, int[] imagenes) {
        this.contexto = contexto;
        this.layout = layout;
        this.empleado = empleado;
        this.descrip = descrip;
        this.compa = compa;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return empleado.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =convertView;
        LayoutInflater layoutInflater= LayoutInflater.from(contexto);
        v=layoutInflater.inflate(R.layout.recursos,null);

        TextView txtEmplea = v.findViewById(R.id.tvNom);
        txtEmplea.setText(empleado.get(position));

        TextView txtCargo = v.findViewById(R.id.tvCargos);
        txtCargo.setText(descrip.get(position));

        TextView txtCompañia = v.findViewById(R.id.tvCompañia);
        txtCompañia.setText(compa.get(position));

        ImageView img =v.findViewById(R.id.imageView2);
        img.setImageResource(imagenes[position]);

        return v;
    }
}
