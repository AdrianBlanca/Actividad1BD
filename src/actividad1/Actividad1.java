/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Actividad1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "root", "root");
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate("create table if not exists curso"
                                    + "(cod_curso int primary key, nombre varchar(30), horas smallint,"
                                    + "turno enum('mañana', 'tarde') not null, mes_comienzo varchar(12))");
            
            sentencia.executeUpdate("create table if not exists alumno"
                                    + "(cod_alumno int primary key, dni char(9) not null, nombre varchar(15),"
                                    + "apellidos varchar(50), direccion varchar(50), localidad varchar(20),"
                                    + "f_nac date, tfno char(9) not null)");
            
            sentencia.executeUpdate("create table if not exists matricula"
                                    + "(cod_curso int, cod_alumno int, fecha_mat date not null,"
                                    + "calificacion enum('Apto', 'No Apto'), primary key(cod_curso, cod_alumno),"
                                    + "foreign key (cod_curso) references curso(cod_curso),"
                                    + "foreign key (cod_alumno) references alumno(cod_alumno))");
            
            sentencia.executeUpdate("insert ignore into curso values"
                                    + "(1, 'Programación php', 200, 'mañana', 'enero'),"
                                    + "(2, 'El SGBD Oracle', 150, 'tarde', 'abril'),"
                                    + "(3, 'Iniciación a Java', 100, 'mañana', 'marzo')");
            
            sentencia.executeUpdate("insert ignore into alumno values"
                                    + "(123, '33396348X', 'María', 'Ruiz', 'C/La palma,6', 'Málaga', '1987/06/24', '607342310'),"
                                    + "(345, '25892410A', 'Pedro', 'López', 'C/Paseo, 2', 'Cártama', '1996/08/20', '670145678'),"
                                    + "(278, '33800678N', 'Alfonso', 'Carrasco', 'Avda. Fideo, s/n ', 'Nerja', null, '616245567')");
            
            sentencia.executeUpdate("insert ignore into matricula values"
                                    + "(1, 123, '2017/09/15', null),"
                                    + "()");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Actividad1.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
    }
    
}
