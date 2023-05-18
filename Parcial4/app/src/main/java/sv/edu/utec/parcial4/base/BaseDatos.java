package sv.edu.utec.parcial4.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS=1;
    private static final String NOMBRE_BASE="BDVenta.db";
    public static final String NOMBRE_TABLAcl="t_cliente";
    private static final String NOMBRE_TABLAcv="t_clienteVehiculo";
    private static final String NOMBRE_TABLAvehi="t_Vehiculos";

    public BaseDatos(@Nullable Context context) {
        super(context, NOMBRE_BASE, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+NOMBRE_TABLAcl+" ("+
                "IDCLIENTE INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "NOMCLIENTE TEXT NOT NULL ,"+
                "APELLCLIENTE TEXT NOT NULL ,"+
                "DIRECCLIENTE TEXT NOT NULL ,"+
                "CIUDCLIENTE TEXT NOT NULL"
                +")");

        db.execSQL("CREATE TABLE "+NOMBRE_TABLAcv+" ("+
                "IDCLIENTE INTEGER ,"+
                "IDVEHICULO INTEGER ,"+
                "MATRICULOS TEXT NOT NULL ,"+
                "KILOMETROS TEXT NOT NULL "
                +")");

        db.execSQL("CREATE TABLE "+NOMBRE_TABLAvehi+" ("+
                "IDVEHICULO INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "MARCA TEXT NOT NULL ,"+
                "MODELO TEXT NOT NULL "
                +")");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+NOMBRE_TABLAcl+ NOMBRE_TABLAcv+ NOMBRE_TABLAvehi);
        onCreate(db);
    }

}

