import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DataSource ds = createDataSource();
        //ArrayList<String> drzave = new ArrayList<>(List.of("Kina", "Indija", "Pakistan", "Nepal", "Tajland"));


        //addMultypleCountries(drzave, ds);

        //System.out.println("Unesite id iznad kojeg zelite obrisati: ");
        //deleteFromId(scanner.nextInt(), ds);

        if (izmjeniCijene(ds)) {
            System.out.println("Uspjesno izmjenjeno!");
        } else {
            System.out.println("Izmjena nije moguca!");
        }

    }

    private static void addMultypleCountries(ArrayList<String> countries, DataSource ds) {
        String query = """
                INSERT INTO dbo.Drzava(Naziv)
                VALUES (?)
                """;

        try (
                Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
        ) {
            for (String c : countries) {
                ps.setString(1, c);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void deleteFromId(int id, DataSource ds) {
        String query = "{CALL dbo.ObrisiSveOdID (?)}";
        try (
                Connection con = ds.getConnection();
                CallableStatement cs = con.prepareCall(query)
        ) {
            cs.setInt(1, id);
            cs.execute();
            System.out.print("Uspjesno obrisano");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean izmjeniCijene(DataSource ds) {
        String querryUpdate8 = """
                UPDATE dbo.Stavka
                SET UkupnaCijena= CijenaPoKomadu * Kolicina
                WHERE IDStavka = 8
                """;

        String querryUpdate9 = """
                UPDATE dbo.Stavka
                SET UkupnaCijena= CijenaPoKomadu * Kolicina
                WHERE IDStavka = 9
                """;
        try (Connection con = ds.getConnection()) {
            try (
                    Statement s = con.createStatement()
            ) {
                con.setAutoCommit(false);
                s.executeUpdate(querryUpdate8);
                s.executeUpdate(querryUpdate9);
                con.commit();
                return true;
            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static DataSource createDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("DESKTOP-Q1U8QL7\\SQLEXPRESS");
        ds.setDatabaseName("AdventureWorksOBP");
        ds.setUser("java");
        ds.setPassword("sql");
        ds.setEncrypt(false);
        return ds;
    }
}

