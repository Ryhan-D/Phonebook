/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.util.ArrayList;

/**
 *
 * @author eiron
 */
public class archivoException extends Exception {

    private  ArrayList<String> error;

    public archivoException(ArrayList<String> error) {
        this.error = error;
    }

    public ArrayList<String> getError() {
        return error;
    }

}
