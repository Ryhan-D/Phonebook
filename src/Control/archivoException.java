
package Control;

import java.util.ArrayList;


public class archivoException extends Exception {

    private  ArrayList<String> error;

    public archivoException(ArrayList<String> error) {
        this.error = error;
    }

    public ArrayList<String> getError() {
        return error;
    }

}
