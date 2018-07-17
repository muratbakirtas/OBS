import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    static void islemler() {
        System.out.println("Yapmak istediğiniz işlemi seçin:");
        System.out.println("1. Ders kaydı.");
        System.out.println("2. Ders ekle/sil.");
        System.out.println("3. Öğrenci ekle/sil.");
        System.out.println("4. Öğrenci ders kaydı sil.");
        System.out.println("5. Dersin öğrencilerini görüntüle.");
        System.out.println("6. Ögrenciye not ver.");
        System.out.println("7. Ögrenci notlarını görüntüle.");

    }

    public static void main(String[] args) throws IOException {


        {
            Scanner scan = new Scanner(System.in);
            ArrayList<Ders> dersListesi = new ArrayList();
            ArrayList<Ogrenci> ogrenciListesi = new ArrayList();
            String ayrac = "-";
            String line = "";
            String line1 = "";
            int sayac;
        /*FileReader fileReader = new FileReader("dosya.txt");
        BufferedReader br = new BufferedReader(fileReader);
        while (true) {
            String yazi = br.readLine();
            if (yazi == null)
                break;
            StringTokenizer s = new StringTokenizer(yazi, ayrac);
            String sayi = s.nextToken();
            int result = Integer.parseInt(sayi);
            dersListesi.add(new Ders(result, s.nextToken()));
        }
        br.close();*/


            connec conn = new connec();
            dersListesi = conn.dersBiligisiCek();


/*
                String verigonder;
                verigonder = "INSERT INTO Dersler ( dersID,dersAdi) VALUES ('101','')";
                st.execute(verigonder);
*/
/*
            FileReader fileReader1 = new FileReader("dosya1.txt");
            BufferedReader br1 = new BufferedReader(fileReader1);
            while (true)

            {
                String yazi1 = br1.readLine();
                if (yazi1 == null)
                    break;
                StringTokenizer s1 = new StringTokenizer(yazi1, ayrac);
                String sayi1 = s1.nextToken();
                int result1 = Integer.parseInt(sayi1);
                ogrenciListesi.add(new Ogrenci(result1, s1.nextToken(), s1.nextToken()));
            }
            br1.close();
 */

            ogrenciListesi = conn.ogrenciBilgisiCek();

            int num3 = 0;
            int num4 = 0;
            int num5 = 0;
            int num;
            int sayac4 = 0;
/*
            Connection connection = null;
            Statement stmt = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");

                stmt = connection.createStatement();

                //String sql = "DELETE FROM dersialanogrenciler WHERE ogrID";
               // stmt.executeUpdate(sql);
                String ql = "DELETE FROM notlar WHERE dersID";
                stmt.executeUpdate(ql);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
*/
            while (true)

            {
                islemler();
                num = scan.nextInt();
                while (num < 1 || num > 7) {
                    System.out.println("Geçersiz sayı girildi!");
                    islemler();
                    num = scan.nextInt();
                }
                switch (num) {
                    case 1:
                        System.out.println("Kaydı yapılacak dersi seçin");
                        for (int i = 0; i < dersListesi.size(); i++) {
                            System.out.println(dersListesi.get(i).getId() + "-" + dersListesi.get(i).getName());
                        }
                        int num1 = scan.nextInt();
                        for (int i = 0; i < ogrenciListesi.size(); i++) {
                            System.out.println(ogrenciListesi.get(i).getOgrİd() + "-" + ogrenciListesi.get(i).getOgrAdi());
                        }

                        for (int num2 = 0; num2 < dersListesi.size(); num2++) {
                            num3 = dersListesi.get(num2).getId();

                            if (num1 == num3) {
                                System.out.println("Ögrenci numaralarını girin. Bitirmek için -1 bas!");
                                num5 = scan.nextInt();
                                while (num5 != (-1)) {


                                    boolean x;
                                    for (int num7 = 0; num7 < ogrenciListesi.size(); num7++) {


                                        num4 = ogrenciListesi.get(num7).getOgrİd();


                                        if (num5 == num4) {
                                            int num24 = conn.dersAlanOgrencileriCek(num3).size();
                                            x = false;
                                            for (int i = 0; i < num24; i++) {

                                                int num23 = conn.dersAlanOgrencileriCek(num3).get(i).getOgrID();


                                                if (num5 == num23) {
                                                    System.out.println(num5 + "-numaralı öğrenci" + num3 + "-numaralı derse kayıtlıdır!");
                                                    x = true;
                                                    break;
                                                }
                                                //conn.dersAlanOgrencileriCek(num3);
                                            }

                                            if (x != true) {
                                                Connection connection1 = null;
                                                Statement stmt1 = null;
                                                try {
                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                    connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");

                                                    stmt1 = connection1.createStatement();

                                                    String sql1 = "INSERT INTO dersialanogrenciler (ogrID,dersID) VALUES (" +
                                                            "" + ogrenciListesi.get(num7).getOgrİd() + ", " +
                                                            "" + dersListesi.get(num2).getId() + ")";
                                                    stmt1.executeUpdate(sql1);
                                                } catch (ClassNotFoundException e) {
                                                    e.printStackTrace();
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                dersListesi.get(num2).ogrenciEkle(ogrenciListesi.get(num7));


                                            }

                                            x = false;
                                            break;
                                        }

                                    }
                                    //dersListesi.get(num2).ogrenciEkle(ogrenciListesi.get(num7));
                                    if (num5 != num4)
                                        System.out.println(num5 + " numaralı öğrenci yok!");
                                    num5 = scan.nextInt();
                                }
                            }

                        }
                        num5 = 0;
                        break;
                    case 2:
                        String line2 = "";
                        System.out.println("Ders eklemek için 1:");
                        System.out.println("Ders silmek için 2:");
                        int sec = scan.nextInt();
                        if (sec == 1) {
                            System.out.println("Bölümdeki dersleri @DersId-DersAdi@ biçiminde giriniz.");
                            line2 = scan.next();
                            while (!line2.equals("-1")) {
                                String kaydet2 = line2.replace(" ", "");
                                StringTokenizer s3 = new StringTokenizer(kaydet2, ayrac);
                                String sayi = s3.nextToken();
                                int result2 = Integer.parseInt(sayi);
                                dersListesi.add(new Ders(result2, s3.nextToken()));


                                Connection connection1 = null;
                                Statement stmt2 = null;
                                try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");

                                    stmt2 = connection1.createStatement();


                                    String sql2 = "INSERT INTO dersler  (dersID,dersAdi) VALUES (" +
                                            "" + dersListesi.get(dersListesi.size() - 1).getId() + ", " +
                                            "\"" + dersListesi.get(dersListesi.size() - 1).getName() + "\")";
                                    stmt2.executeUpdate(sql2);
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                line2 = scan.next();
                            }
/*
                            FileWriter fileWriter = new FileWriter("dosya.txt");
                            PrintWriter bWriter = new PrintWriter(fileWriter);
                            for (int i = 0; i < dersListesi.size(); i++) {
                                bWriter.println(dersListesi.get(i).getId() + "-" + dersListesi.get(i).getName());
                            }
                            bWriter.close();
*/
                        }
                        if (sec == 2) {
                            System.out.println("Silmek istediğiniz dersi seçin:");
                            for (int i = 0; i < dersListesi.size(); i++) {
                                System.out.println(dersListesi.get(i).getId());
                            }
                            int num9 = scan.nextInt();
                            for (int num2 = 0; num2 < dersListesi.size(); num2++) {
                                int num10 = dersListesi.get(num2).getId();
                                if (num9 == num10) {
                                    dersListesi.remove(num2);
                                    break;
                                }
                            }

                            Connection connection2 = null;
                            Statement stmt3 = null;
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");

                                stmt3 = connection2.createStatement();
                                String sql4 = "DELETE FROM dersler WHERE dersID";
                                stmt3.executeUpdate(sql4);
                                for (int i = 0; i < dersListesi.size(); i++) {
                                    String sql3 = "INSERT INTO dersler  (dersID,dersAdi) VALUES (" +
                                            "" + dersListesi.get(i).getId() + ", " +
                                            "\"" + dersListesi.get(i).getName() + "\")";
                                    stmt3.executeUpdate(sql3);
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                            System.out.println("Son ders durumu:");
                            for (int i = 0; i < dersListesi.size(); i++) {

                                System.out.println(dersListesi.get(i).getId());
                            }
/*
                            FileWriter fileWriter = new FileWriter("dosya.txt");
                            PrintWriter bWriter = new PrintWriter(fileWriter);
                            for (int i = 0; i < dersListesi.size(); i++) {
                                bWriter.println(dersListesi.get(i).getId() + "-" + dersListesi.get(i).getName());
                            }
                            bWriter.close();
 */
                        }
                        break;
                    case 3:
                        System.out.println("Öğrenci eklemek için 1:");
                        System.out.println("Ögrenci silmek için 2:");
                        int sec1 = scan.nextInt();
                        if (sec1 == 1) {
                            System.out.println("Bölümdeki öğrencileri @ÖğrenciId-ÖgrenciAdi-ÖgrenciCinsiyeti@ biçiminde giriniz");

                            String line3 = scan.next();
                            while (!line3.equals("-1")) {
                                String kaydet3 = line3.replace(" ", "");
                                StringTokenizer s2 = new StringTokenizer(kaydet3, ayrac);
                                String sayi1 = s2.nextToken();
                                int result2 = Integer.parseInt(sayi1);
                                ogrenciListesi.add(new Ogrenci(result2, s2.nextToken(), s2.nextToken()));

                                Connection connection2 = null;
                                Statement stmt3 = null;
                                try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");
                                    stmt3 = connection2.createStatement();
                                    String sql2 = "INSERT INTO ogrenciler  (ogrID,ogrAdi,ogrCinsiyet) VALUES (" +
                                            "" + ogrenciListesi.get(ogrenciListesi.size() - 1).getOgrİd() + ", " +
                                            "\"" + ogrenciListesi.get(ogrenciListesi.size() - 1).getOgrAdi() + "\", " +
                                            "\"" + ogrenciListesi.get(ogrenciListesi.size() - 1).getOgrCinsiyet() + "\")";
                                    stmt3.executeUpdate(sql2);
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                line3 = scan.next();
                            }

  /*
                            FileWriter fileWriter = new FileWriter("dosya1.txt");
                            PrintWriter bWriter = new PrintWriter(fileWriter);
                            for (int i = 0; i < ogrenciListesi.size(); i++) {
                                bWriter.println(ogrenciListesi.get(i).getOgrİd() + "-" + ogrenciListesi.get(i).getOgrAdi());
                            }
                            bWriter.close();*/
                        }

                        if (sec1 == 2) {
                            System.out.println("Silmek istediğiniz öğrenciyi seçin:");
                            for (int i = 0; i < ogrenciListesi.size(); i++) {
                                System.out.println(ogrenciListesi.get(i).getOgrİd() + "-" + ogrenciListesi.get(i).getOgrAdi());
                            }
                            int num11 = scan.nextInt();
                            for (int num2 = 0; num2 < ogrenciListesi.size(); num2++) {
                                int num12 = ogrenciListesi.get(num2).getOgrİd();
                                if (num11 == num12) {
                                    ogrenciListesi.remove(num2);

                                    break;
                                }
                            }

                            Connection connection3 = null;
                            Statement stmt3 = null;
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                connection3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");

                                stmt3 = connection3.createStatement();
                                String sql4 = "DELETE FROM ogrenciler WHERE ogrID";
                                stmt3.executeUpdate(sql4);
                                for (int i = 0; i < dersListesi.size(); i++) {
                                    String sql3 = "INSERT INTO ogrenciler  (ogrID,ogrAdi,ogrCinsiyet) VALUES (" +
                                            "" + ogrenciListesi.get(i).getOgrİd() + ", " +
                                            "\"" + ogrenciListesi.get(i).getOgrAdi() + "\", " +
                                            "\"" + ogrenciListesi.get(i).getOgrCinsiyet() + "\")";
                                    stmt3.executeUpdate(sql3);
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            System.out.println("Son ögrenci durumu:");
                            for (int i = 0; i < ogrenciListesi.size(); i++) {

                                System.out.println(ogrenciListesi.get(i).getOgrİd() + "-" + ogrenciListesi.get(i).getOgrAdi());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Ders kaydı silinecek dersi seçin");
                        for (int i = 0; i < dersListesi.size(); i++) {
                            System.out.println(dersListesi.get(i).getId());
                        }
                        int num15 = scan.nextInt();


                        for (int i = 0; i < conn.dersAlanOgrencileriCek(num15).size(); i++)
                            System.out.println(conn.dersAlanOgrencileriCek(num15).get(i).getOgrID());
                        System.out.println("Ders kaydını silmek istediğiniz ögrencinin numarasını girin.");

                        int num17 = scan.nextInt();
                        for (int num2 = 0; num2 < conn.dersAlanOgrencileriCek(num15).size(); num2++) {
                            int num16 = conn.dersAlanOgrencileriCek(num15).get(num2).getOgrID();

                            if (num17 == num16) {


                                for (int num7 = 0; num7 < conn.dersAlanOgrencileriCek(num15).size(); num7++) {
                                    int num21 = conn.dersAlanOgrencileriCek(num15).get(num7).getOgrID();
                                    if (num17 == num21) {
                                        //dersListesi.get(num2).ogrenciSil(dersListesi.get(num2).getOgrenciList().get(num7));


                                        Connection connection4 = null;
                                        Statement stmt4 = null;
                                        try {
                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                            connection4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");

                                            stmt4 = connection4.createStatement();
                                            String sql4 = "DELETE FROM dersialanogrenciler WHERE ogrID=" + num17 + " AND " + "dersID=" + num15;
                                            stmt4.executeUpdate(sql4);

                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }
                                dersListesi.get(num2).ogrenciListesiGor();
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Görüntülemek istediğiniz dersi secin.");
                        for (int i = 0; i < dersListesi.size(); i++) {
                            System.out.println(dersListesi.get(i).getId() + "-" + dersListesi.get(i).getName());
                        }
                        int num18 = scan.nextInt();
                        for (int num2 = 0; num2 < dersListesi.size(); num2++) {
                            int num16 = dersListesi.get(num2).getId();
                            if (num18 == num16) {

                                System.out.println("Dersini alan öğrenciler:");
                                conn.dersAlanOgrencileriCek(num16);
                                for (int i = 0; i < conn.dersAlanOgrencileriCek(num16).size(); i++)
                                    System.out.println(conn.dersAlanOgrencileriCek(num16).get(i).getOgrID());
                                //dersListesi.get(num2).ogrenciListesiGor();

                            }
                        }
                        break;
                    case 6:
                        System.out.println("Not vereceğin dersi seç.");
                        for (int i = 0; i < dersListesi.size(); i++) {
                            System.out.println(dersListesi.get(i).getId() + "-" + dersListesi.get(i).getName());
                        }
                        boolean y;
                        int num19 = scan.nextInt();
                        for (int sayac2 = 0; sayac2 < dersListesi.size(); sayac2++) {

                            int num20 = dersListesi.get(sayac2).getId();
                            if (num19 == num20) {
                                System.out.println("Not vereceğin öğrenciyi seç.");
                                for (int i = 0; i < conn.dersAlanOgrencileriCek(num20).size(); i++) {
                                    System.out.println(conn.dersAlanOgrencileriCek(num20).get(i).getOgrID());
                                }
                                int num21 = scan.nextInt();
                                for (sayac = 0; sayac < conn.dersAlanOgrencileriCek(num20).size(); sayac++) {
                                    int num22 = conn.dersAlanOgrencileriCek(num20).get(sayac).getOgrID();
                                    y = false;
                                    if (num21 == num22) {
                                        System.out.println("Vize notunu gir.");
                                        double viz = scan.nextDouble();
                                        //dersListesi.get(sayac2).getOgrenciList().get(sayac).vizeEkle(viz);
                                        System.out.println("Final notunu gir.");
                                        double fin = scan.nextDouble();
                                        // dersListesi.get(sayac2).getOgrenciList().get(sayac).fnalEkle(fin);
                                        double ort = ((viz * 40.0) / 100.0) + ((fin * 60.0) / 100.0);
                                        //dersListesi.get(sayac2).getOgrenciList().get(sayac).ortEkle(ort);
                                        //System.out.println("Ortalaması:" + ort);

                                        for (int i = 0; i < conn.notlarıCek(num19).size(); i++) {
                                            int num27 = conn.notlarıCek(num19).get(i).getOgrID();

                                            if (num21 == num27) {


                                                Connection connection1 = null;
                                                Statement stmt1 = null;
                                                try {
                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                    connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");

                                                    stmt1 = connection1.createStatement();

                                                    String sql = "DELETE FROM notlar WHERE ogrID=" + num27 + " AND " + "dersID=" + num19;
                                                    stmt1.executeUpdate(sql);
                                                } catch (ClassNotFoundException e) {
                                                    e.printStackTrace();
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                y = true;
                                            }
                                        }

                                        Connection connection6 = null;
                                        Statement stmt6 = null;
                                        try {
                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                            connection6 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");
                                            stmt6 = connection6.createStatement();

                                            String sql2 = "INSERT INTO notlar (dersID,ogrID,vize,final,ort)  VALUES (" +
                                                    "" + conn.dersAlanOgrencileriCek(num20).get(sayac).getDersID() + ", " +
                                                    "" + conn.dersAlanOgrencileriCek(num20).get(sayac).getOgrID() + ", " +
                                                    "'" + viz + "', " +
                                                    "'" + fin + "', " +
                                                    "'" + ort + "')";
                                            stmt6.executeUpdate(sql2);
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }


                                        break;

                                    }
                                }
                                break;
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Not görüntüleyeceğin dersi seç.");

                        for (int i = 0; i < dersListesi.size(); i++) {
                            System.out.println(dersListesi.get(i).getId() + "-" + dersListesi.get(i).getName());
                        }
                        int num23 = scan.nextInt();
                        for (int sayac2 = 0; sayac2 < dersListesi.size(); sayac2++) {

                            int num24 = conn.notlarıCek().get(sayac2).getDersID();
                            if (num23 == num24) {
                                System.out.println("Not görüntüleceğin öğrenciyi seç.");
                                for (int i = 0; i < conn.notlarıCek(num24).size(); i++) {
                                    System.out.println(conn.notlarıCek(num24).get(i).getOgrID());
                                }
                                int num25 = scan.nextInt();
                                for (int sayac1 = 0; sayac1 < conn.notlarıCek(num24).size(); sayac1++) {
                                    int num26 = conn.notlarıCek(num24).get(sayac1).getOgrID();
                                    if (num25 == num26) {
                                        for (int x = 0; x < conn.notlarıCek(num24, num26).size(); x++) {
                                            System.out.println("vize:" + conn.notlarıCek(num24, num26).get(x).getVizeler());
                                            System.out.println("final:" + conn.notlarıCek(num24, num26).get(x).getFnal());
                                            System.out.println("ortalama:" + conn.notlarıCek(num24, num26).get(x).getOrt());
                                        }
                                    }

                                }
                                break;
                            }

                        }
                        break;
                }
            }
        }

    }

}

