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

public class contactosDAO {

    Connection abrirCon() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
    }

    public Contactos select(String nombre) throws SQLException {
        Connection con = abrirCon();

        PreparedStatement ps = con.prepareStatement("select * from contactos where nombre=?");
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        Contactos c = null;
        while (rs.next()) {
            String tipo = rs.getString(1);
            String nombr = rs.getString(2);
            Integer numero = rs.getInt(3);
            if (numero == 0) {
                numero = null;
            }
            String correo = rs.getString(4);
            Date cumple = rs.getDate(5);
            String empresa = rs.getString(6);

            if (tipo.equalsIgnoreCase("a")) {
                c = new Contactos_Amigos(nombre, numero, correo, cumple);

            } else {
                c = new Contactos_Profesionales(nombre, numero, correo, empresa);

            }
        }
        ps.close();
        con.close();

        return c;
    }

    public void insert(Contactos c) throws SQLException {
        Connection con = abrirCon();
        PreparedStatement ps;

        ps = con.prepareStatement("insert into contactos (tipo,nombre,telefono,correo,cumpleaños,empre) values (?,?,?,?,?,?)");
        ps.setString(1, c instanceof Contactos_Amigos ? "a" : "p");
        ps.setString(2, c.getNombre());
        if (c.getNumero() == null) {
            ps.setNull(3, java.sql.Types.INTEGER);
        } else {
            ps.setInt(3, c.getNumero());
        }
        ps.setString(4, c.getCorreo());
        Date cumple = c instanceof Contactos_Amigos ? ((Contactos_Amigos) c).getFechaCumpleanios() : null;
        if (cumple == null) {
            ps.setNull(5, java.sql.Types.DATE);
        } else {
            java.sql.Date sd = new java.sql.Date(cumple.getTime());
            ps.setDate(5, sd);
        }

        ps.setString(6, c instanceof Contactos_Profesionales ? ((Contactos_Profesionales) c).getNombreEmpresa() : null);

        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void update(Contactos c) throws SQLException {
        Connection con = abrirCon();
        PreparedStatement ps;

        ps = con.prepareStatement("update contactos set telefono=?, correo=?, cumpleaños=?,empre = ?, tipo = ? where nombre=?");
        if (c.getNumero() == null) {
            ps.setNull(1, java.sql.Types.INTEGER);
        } else {
            ps.setInt(1, c.getNumero());
        }
        ps.setString(2, c.getCorreo());

        Date cumple = c instanceof Contactos_Amigos ? ((Contactos_Amigos) c).getFechaCumpleanios() : null;

        if (cumple == null) {
            ps.setNull(3, java.sql.Types.DATE);
        } else {
            java.sql.Date sd = new java.sql.Date(cumple.getTime());
            ps.setDate(3, sd);
        }
        ps.setString(4, c instanceof Contactos_Profesionales ? ((Contactos_Profesionales) c).getNombreEmpresa() : null);
        ps.setString(5, c instanceof Contactos_Amigos ? "a" : "p");
        ps.setString(6, c.getNombre());

        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void delete(String nombre) throws SQLException {
        Connection con = abrirCon();
        PreparedStatement ps;
     
            ps = con.prepareStatement("delete from contactos where nombre=?");
            ps.setString(1, nombre);

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

    //metodo para probar la agenda con hashmap usando la BBDD como cuando trabajabamos con ficheros
    public HashMap<String, Contactos> getContactos() throws SQLException {
        Connection con = abrirCon();

        HashMap<String, Contactos> contactos = new HashMap<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from contactos order by nombre");

        while (rs.next()) {
            String tipo = rs.getString(1);
            String nombr = rs.getString(2);
            Integer numero = rs.getInt(3);
            if (numero == 0) {
                numero = null;
            }
            String correo = rs.getString(4);
            Date cumple = rs.getDate(5);
            String empresa = rs.getString(6);
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
