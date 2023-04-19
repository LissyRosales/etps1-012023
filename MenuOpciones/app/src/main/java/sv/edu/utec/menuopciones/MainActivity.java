package sv.edu.utec.menuopciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNav=findViewById(R.id.btnNav);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_configuraciones,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem items){
        Intent intent= new Intent(this, Sumar.class);

        switch (items.getItemId()){
            case R.id.opcion1:
                Toast.makeText(this, "Selecciono la opcion 1", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            case R.id.opcion2:
                Toast.makeText(this, "Selecciono la opcion 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion3:
                Toast.makeText(this, "Selecciono la opcion 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion4:
                Toast.makeText(this, "Selecciono la opcion 1", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(items);
    }
}