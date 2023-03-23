package sv.edu.utec.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView lista;
List<String> peliculas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista= findViewById(R.id.lsvPeliculas);

        peliculas = new ArrayList<String>();
        peliculas.add("Ex Maquina");
        peliculas.add("Extraordinarios");
        peliculas.add("Forma de Agua");
        peliculas.add("Interestelar");
        peliculas.add("Jumanji");
        peliculas.add("La Llegada");

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Selecciono"+parent.getItemAtPosition(position),)
            }
        });
    }
}