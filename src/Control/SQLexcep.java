
package Control;


public class SQLexcep extends Exception{
    
 private int codigoError;

    public SQLexcep(int codigoError) {
        this.codigoError = codigoError;
    }

    public int getCodigoError() {
        return codigoError;
    }
 
    
}
