package sv.edu.utec.menuopciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.menuopciones.clases.BusquedaFragment;
import sv.edu.utec.menuopciones.clases.CamFragment;
import sv.edu.utec.menuopciones.clases.FavFragment;
import sv.edu.utec.menuopciones.clases.PrincipalFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNav=findViewById(R.id.btnNav);

        btnNav.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navaListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selecciono= null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    selecciono=new PrincipalFragment();
                    break;
                case R.id.nav_fav:
                    selecciono=new FavFragment();
                    break;
                case R.id.nav_cam:
                    selecciono=new CamFragment();
                    break;
                case R.id.nav_bus:
                    selecciono=new BusquedaFragment();
                    break;
            }

           // getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCont, selecciono).commit();
            return true;
        }
    };
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
                Toast.makeText(this, "Selecciono la opcion 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion3:
                Toast.makeText(this, "Selecciono la opcion 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion4:
                Toast.makeText(this, "Selecciono la opcion 4", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(items);
    }
}