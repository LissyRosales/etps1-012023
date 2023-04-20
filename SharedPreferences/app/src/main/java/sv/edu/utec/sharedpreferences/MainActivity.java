package sv.edu.utec.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.sharedpreferences.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {
EditText txtcodProd, txtDesc, txtPrecio;
Button btnInserts, btnUpdates, btnDeletes, btnBuscars, btnBuscarDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcodProd=findViewById(R.id.editTextTextPersonName);
        txtDesc=findViewById(R.id.editTextTextPersonName2);
        txtPrecio=findViewById(R.id.editTextNumberDecimal);
        btnInserts=findViewById(R.id.btnInsert);
        btnUpdates=findViewById(R.id.btnUpdate);
        btnDeletes=findViewById(R.id.btnDelete);
        btnBuscars=findViewById(R.id.btnBuscar);
        btnBuscarDescrip=findViewById(R.id.btnBDescrip);


        btnInserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(getApplicationContext(),"Bodega",null,1);

            SQLiteDatabase bd= admin.getWritableDatabase();
            String cod=txtcodProd.getText().toString();
            String des=txtDesc.getText().toString();
            String pre=txtPrecio.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("codProducto",cod);
                informacion.put("descripProducto",des);
                informacion.put("precioProd",pre);
            try{
                bd.insert("productos", null,informacion);
                bd.close();

                Toast.makeText(getApplicationContext(),"Se inserto el producto", Toast.LENGTH_LONG).show();

            }catch (Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
            }
        });

        btnUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(getApplicationContext(),"Bodega",null,1);
            SQLiteDatabase bd= admin.getWritableDatabase();
                String cod=txtcodProd.getText().toString();
                String des=txtDesc.getText().toString();
                String pre=txtPrecio.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("codProducto",cod);
                informacion.put("descripProducto",des);
                informacion.put("precioProd",pre);

                int cant=bd.update("productos", informacion,"codProducto="+cod,null);
                bd.close();

                if (cant==1){
                    Toast.makeText(getApplicationContext(),"Se modifico el producto", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"No se modifico el producto", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDeletes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(getApplicationContext(),"Bodega",null,1);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String cod=txtcodProd.getText().toString();

                int cant=bd.delete("productos","codProducto="+cod,null);
                bd.close();
                txtcodProd.setText("");
                txtDesc.setText("");
                txtPrecio.setText("");

                if (cant==1){
                    Toast.makeText(getApplicationContext(),"Se borro el producto", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"No se borro el producto", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnBuscars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(getApplicationContext(),"Bodega",null,1);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String cod=txtcodProd.getText().toString();

                Cursor filas = bd.rawQuery("Select descripProducto, precioProd " +
                        "from productos where codProducto="+cod,null);

                if (filas.moveToFirst()){
                    txtDesc.setText(filas.getString(0));
                    txtPrecio.setText(filas.getString(1));
                }
                else {
                    Toast.makeText(getApplicationContext(),"No se encontro el producto", Toast.LENGTH_LONG).show();
                }
                bd.close();
            }
        });

        btnBuscarDescrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(getApplicationContext(),"Bodega",null,1);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String des=txtDesc.getText().toString();

                Cursor filas = bd.rawQuery("Select codProducto, descripProducto, precioProd " +
                        "from productos where descripProducto='"+des+"'",null);

                if (filas.moveToFirst()){
                    txtcodProd.setText(filas.getString(0));
                    txtDesc.setText(filas.getString(1));
                    txtPrecio.setText(filas.getString(2));
                }
                else {
                    Toast.makeText(getApplicationContext(),"No se encontro el producto", Toast.LENGTH_LONG).show();
                }
                bd.close();
            }
        });
    }
}