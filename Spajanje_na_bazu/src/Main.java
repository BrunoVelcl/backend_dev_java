import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = createDataSource();
        String query = "SELECT * FROM Drzava";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            System.out.println("Uspješno spojeni na bazu podataka!");
            while (rs.next()) {
                Integer idDrzava = rs.getInt("IDDrzava");
                String ime = rs.getString("Naziv");
                System.out.println("Na ID-ju " + idDrzava + " se nalazi " + ime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static DataSource createDataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName("DESKTOP-Q1U8QL7\\SQLEXPRESS");
        dataSource.setDatabaseName("AdventureWorksOBP");
        dataSource.setUser("java");
        dataSource.setPassword("sql");
        dataSource.setEncrypt(false);
        return dataSource;
    }
}