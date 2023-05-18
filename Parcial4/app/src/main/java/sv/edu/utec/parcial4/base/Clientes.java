package sv.edu.utec.parcial4.base;
import android.content.Context;

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


        } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return codigo;
    }
}
