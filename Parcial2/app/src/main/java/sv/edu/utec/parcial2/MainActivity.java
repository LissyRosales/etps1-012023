package sv.edu.utec.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
ListView lista;

int[]img;
List<String> empleados;
List<String> descripcion;
List<String> compañia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=findViewById(R.id.lsvEmpleados);
        empleados = new ArrayList<String>();

        empleados = new ArrayList<String>();
        empleados.add("Alexander Pierrot");
        empleados.add("Carlos Lopez");
        empleados.add("Sara Bonz");
        empleados.add("Liliana Clarance");
        empleados.add("Benito Peralta");
        empleados.add("Juan Jaramillo");
        empleados.add("Christian Steps");
        empleados.add("Alexa Giraldo");
        empleados.add("Linda Munillo");
        empleados.add("Lizeth Astrada");

        descripcion = new ArrayList<String>();
        descripcion.add("CEO");
        descripcion.add("Asistente");
        descripcion.add("Directora de Marketing");
        descripcion.add("Diseñadora de Producto");
        descripcion.add("Supervisor de Ventas");
        descripcion.add("CEO");
        descripcion.add("CTO");
        descripcion.add("Lead Programmer");
        descripcion.add("Directora de Marketing");
        descripcion.add("CEO");

        int[] imagenes={
            R.drawable.photo_1,
            R.drawable.photo_2,
            R.drawable.photo_3,
            R.drawable.photo_4,
            R.drawable.photo_5,
            R.drawable.photo_6,
            R.drawable.photo_7,
            R.drawable.photo_8,
            R.drawable.photo_9,
            R.drawable.photo_10
        };

        compañia = new ArrayList<String>();
        compañia.add("Insures S.O");
        compañia.add("Hospital Blue");
        compañia.add("Electrical Parts Itd");
        compañia.add("Creativa App");
        compañia.add("Neumaticos Press");
        compañia.add("Banco Nacional");
        compañia.add("Cooperativa Verde");
        compañia.add("Frutosofy");
        compañia.add("Seguros Boliver");
        compañia.add("Concesionario Motolox");

        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1);
        Adaptador adaptador= new Adaptador (this, R.layout.recursos,empleados,descripcion,compañia,imagenes);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Seleccione"+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();

            }
        });

    }
}