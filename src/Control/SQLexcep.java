
package Control;


public class SQLexcep extends Exception{
    
 private int codigoError;

    public SQLexcep(int codigoError) {
        super("Se ha producido algun error con la base de datos, codigo: ");
        this.codigoError = codigoError;
        
    }

    public int getCodigoError() {
        return codigoError;
    }

    @Override
    public String toString() {
        return super.getMessage() + codigoError;
    }
 
    
}
