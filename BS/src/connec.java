import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.io.*;

public class connec {
    static Connection connection;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<Ders> dersBiligisiCek() {

        ArrayList dersbilgileri = new ArrayList();
        try {
            Connection connection = getConnection();
            java.sql.Statement st = null;
            ResultSet rs = null;
            st = connection.createStatement();
            String vericek = "SELECT * FROM Dersler";
            rs = st.executeQuery(vericek);
            while (rs.next()) {
                Ders ders = new Ders();
                ders.setId(rs.getInt("dersID"));
                ders.setName(rs.getString("dersAdi"));
                dersbilgileri.add(ders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dersbilgileri;
    }

    public ArrayList<Ogrenci> ogrenciBilgisiCek() {
        ArrayList ogrenciBilgileri = new ArrayList();
        try {
            Connection connection = getConnection();
            java.sql.Statement st = null;
            ResultSet rs = null;
            st = connection.createStatement();
            String vericek = "SELECT * FROM Ogrenciler";
            rs=st.executeQuery(vericek);
            while(rs.next()){
                Ogrenci ogr =new Ogrenci();
                ogr.setOgrİd(rs.getInt("ogrID"));
                ogr.setOgrAdi(rs.getString("ogrAdi"));
                ogr.setOgrCinsiyet(rs.getString("ogrCinsiyet"));
                ogrenciBilgileri.add(ogr);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return ogrenciBilgileri;
    }
    public ArrayList<DersAlanOgrenciler> dersAlanOgrencileriCek(int sayi) {
        ArrayList bilgiler = new ArrayList();
        try {
            Connection connection = getConnection();
            java.sql.Statement st = null;
            ResultSet rs = null;
            st = connection.createStatement();
            String vericek = "SELECT * FROM dersialanogrenciler WHERE dersID='"+sayi+"'";
            rs=st.executeQuery(vericek);
            while(rs.next()){
                DersAlanOgrenciler ogr1 =new DersAlanOgrenciler();
                ogr1.setOgrID(rs.getInt("ogrID"));
                ogr1.setDersID(rs.getInt("dersID"));
                bilgiler.add(ogr1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return bilgiler;
    }

    public ArrayList<Notlar> notlarıCek(int ders){
        ArrayList notBilgileri =new ArrayList();

        try{
            Connection connection = getConnection();
            java.sql.Statement st =null;
            ResultSet rs =null;
            st= connection.createStatement();
            String vericek ="SELECT * FROM notlar WHERE dersID="+ders+"";
            //WHERE ogrID=" + ogr  + " AND " + "dersID="+ ders
            rs=st.executeQuery(vericek);
            while(rs.next()){
                Notlar not =new Notlar(rs.getInt("dersID"),rs.getInt("ogrID"));

                notBilgileri.add(not);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notBilgileri;
    }
    public ArrayList<Notlar> notlarıCek(){
        ArrayList notBilgileri =new ArrayList();

        try{
            Connection connection = getConnection();
            java.sql.Statement st =null;
            ResultSet rs =null;
            st= connection.createStatement();
            String vericek ="SELECT * FROM notlar ";
            //WHERE ogrID=" + ogr  + " AND " + "dersID="+ ders
            rs=st.executeQuery(vericek);
            while(rs.next()){
                Notlar not =new Notlar(rs.getInt("dersID"),rs.getInt("ogrID"));
                notBilgileri.add(not);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notBilgileri;
    }

    public ArrayList<Notlar> notlarıCek(int ders,int ogr){
        ArrayList notBilgileri =new ArrayList();

        try{
            Connection connection = getConnection();
            java.sql.Statement st =null;
            ResultSet rs =null;
            st= connection.createStatement();
            String vericek ="SELECT * FROM notlar WHERE ogrID=" + ogr  + " AND " + "dersID="+ ders;

            rs=st.executeQuery(vericek);
            while(rs.next()){
                Notlar not =new Notlar(ogr,ders);
                not.setVizeler(rs.getDouble("vize"));
                not.setFnal(rs.getDouble("final"));
                not.setOrt(rs.getDouble("ort"));
                notBilgileri.add(not);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notBilgileri;
    }



}
