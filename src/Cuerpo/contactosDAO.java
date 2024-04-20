/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuerpo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author eiron
 */
public class contactosDAO {

    Connection abrirCon() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
    }
   
    public Contactos select(String nombre) throws SQLException {
        Connection con = abrirCon();

        PreparedStatement ps = con.prepareStatement("select * from contactos where nombre=?");
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        
        String tipo = null;
        String nombr = null;
        Integer numero = null;
        String correo = null;
        Date cumple = null;
        String empresa = null;
        while (rs.next()) {
            tipo = rs.getString(1);
            nombr = rs.getString(2);
            numero = rs.getInt(3);
            if (numero == 0) {
                numero = null;
            }
            correo = rs.getString(4);
            cumple = rs.getDate(5);
            empresa = rs.getString(6);
        }
        ps.close();
        con.close();
        
        Contactos c;
        if (tipo.equalsIgnoreCase("a")) {
            c = new Contactos_Amigos(nombre);
            c.setCorreo(correo);
            c.setNumero(numero);
           ((Contactos_Amigos)c).setFechaCumpleanios(cumple);
            
        } else {
            c = new Contactos_Profesionales(nombre);
            c.setCorreo(correo);
            c.setNumero(numero);
            ((Contactos_Profesionales)c).setNombreEmpresa(empresa);
            
        }
            return c;
    }

    public void insert(Contactos c) throws SQLException {
        Connection con = abrirCon();
        PreparedStatement ps;

        if (c instanceof Contactos_Amigos) {
            ps = con.prepareStatement("insert into amigos values (?,?,?,?)");
            ps.setString(1, c.getNombre());
            if (c.getNumero() == null) {
                ps.setNull(2, java.sql.Types.INTEGER);
            } else {
                ps.setInt(2, c.getNumero());
            }
            ps.setString(3, c.getCorreo());

            Date cumple = ((Contactos_Amigos) c).getFechaCumpleanios();

            if (cumple == null) {
                ps.setNull(4, java.sql.Types.DATE);
            } else {
                java.sql.Date sd = new java.sql.Date(((Contactos_Amigos) c).getFechaCumpleanios().getTime());
                ps.setDate(4, sd);
            }
        } else {
            ps = con.prepareStatement("insert into profesionales values (?,?,?,?)");
            ps.setString(1, c.getNombre());
            if (c.getNumero() == null) {
                ps.setNull(2, java.sql.Types.INTEGER);
            } else {
                ps.setInt(2, c.getNumero());
            }
            ps.setString(3, c.getCorreo());
            ps.setString(4, ((Contactos_Profesionales) c).getNombreEmpresa());

        }
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void update(Contactos c) throws SQLException {
        Connection con = abrirCon();
        PreparedStatement ps;
        if (c instanceof Contactos_Amigos) {
            ps = con.prepareStatement("update amigos set telefono=?, correo=?, cumpleaños=? where nombre=?");
            if (c.getNumero() == null) {
                ps.setNull(1, java.sql.Types.INTEGER);
            } else {
                ps.setInt(1, c.getNumero());
            }
            ps.setString(2, c.getCorreo());

            Date cumple = ((Contactos_Amigos) c).getFechaCumpleanios();

            if (cumple == null) {
                ps.setNull(3, java.sql.Types.DATE);
            } else {
                java.sql.Date sd = new java.sql.Date(((Contactos_Amigos) c).getFechaCumpleanios().getTime());
                ps.setDate(3, sd);
            }
            ps.setString(4, c.getNombre());
        } else {
            ps = con.prepareStatement("update profesionales set telefono=?, correo=?, empresa=? where nombre=?");
            if (c.getNumero() == null) {
                ps.setNull(1, java.sql.Types.INTEGER);
            } else {
                ps.setInt(1, c.getNumero());
            }
            ps.setString(2, c.getCorreo());
            ps.setString(3, ((Contactos_Profesionales) c).getNombreEmpresa());
            ps.setString(4, c.getNombre());
        }
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void delete(String nombre) throws SQLException {
        Connection con = abrirCon();
        PreparedStatement ps;
        if (select(nombre) instanceof Contactos_Amigos) {
            ps = con.prepareStatement("delete from amigos where nombre=?");
            ps.setString(1, nombre);

        } else {
            ps = con.prepareStatement("delete from profesionales where nombre=?");
            ps.setString(1, nombre);
        }
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public ArrayList<String> nombres() throws SQLException {
        Connection con = abrirCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select nombre from contactos");
        ArrayList<String> al = new ArrayList<>();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            al.add(nombre);
        }
        rs.close();
        con.close();
        return al;

    }

    public HashMap<String, Contactos> getContactos() throws SQLException {
        Connection con = abrirCon();

        HashMap<String, Contactos> contactos = new HashMap<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from contactos order by nombre");

        String tipo = null;
        String nombr = null;
        Integer numero = null;
        String correo = null;
        Date cumple = null;
        String empresa = null;
        while (rs.next()) {
            tipo = rs.getString(1);
            nombr = rs.getString(2);
            numero = rs.getInt(3);
            if (numero == 0) {
                numero = null;
            }
            correo = rs.getString(4);
            cumple = rs.getDate(5);
            empresa = rs.getString(6);
            if (tipo.equalsIgnoreCase("a")) {
                Contactos_Amigos ca = new Contactos_Amigos(nombr, numero, correo, cumple);

                contactos.put(nombr, ca);
            } else {
                Contactos_Profesionales cp = new Contactos_Profesionales(nombr, numero, correo, empresa);

                contactos.put(nombr, cp);
            }
        }
        rs.close();
        con.close();

        return contactos;
    }

}
