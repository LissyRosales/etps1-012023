package sv.edu.utec.parcial4.base;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;


public class Clientes extends BaseDatos{
    Context context;

    public Clientes(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertClientes(String NOMCLIENTE, String APELLCLIENTE, String DIRECCLIENTE, String CIUDCLIENTE){
    long codigo=0;
    try{
        BaseDatos baseDatos= new BaseDatos(context);
        SQLiteDatabase bd=baseDatos.getWritableDatabase();

        ContentValues valoresProv = new ContentValues();
        valoresProv.put("NOMCLIENTE", NOMCLIENTE);
        valoresProv.put("APELLCLIENTE", APELLCLIENTE);
        valoresProv.put("DIRECCLIENTE", DIRECCLIENTE);
        valoresProv.put("CIUDCLIENTE", CIUDCLIENTE);

        codigo=bd.insert(NOMBRE_TABLAcl, null, valoresProv);
        return codigo;

        } catch (Exception e) {
        e.toString();
        return codigo=0;
    }

    }
}
