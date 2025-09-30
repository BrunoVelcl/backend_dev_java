import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Main {
    public static void main(String[] args) {

        DataSource ds = createDataSource();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            MainMenu input;
            try {
                input = MainMenu.fromChar(scanner.nextLine().charAt(0));
            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                System.out.println(ANSI.Color.basicString("Nevažeći unos!", ANSI.BasicColor.RED));
                continue;
            }
            switch (input) {
                case ADD_NEW -> {
                    System.out.print(ANSI.Color.basicString("Unesite novu Državu: ", ANSI.BasicColor.WHITE));
                    addNew(scanner.nextLine().trim(), ds);
                }
                case UPDATE_EXISTING -> {
                    Integer id = getCountryId(scanner, ds);
                    if (id == null) continue;
                    renameCountry(scanner.nextLine(), id, ds);
                }
                case DELETE -> {
                    Integer id = getCountryId(scanner, ds);
                    if (id == null) continue;
                    System.out.print(ANSI.Color.basicString("Da li ste sigurni(Y/n): ", ANSI.BasicColor.YELLOW));
                    if (scanner.nextLine().toLowerCase().charAt(0) == 'y') {
                        deleteCountryById(id, ds);
                    } else {
                        System.out.println(ANSI.Color.basicString("Brisanje prekinuto!", ANSI.BasicColor.RED));
                    }
                }
                case PRINT_ALL -> {
                    printCountriesByName(ds);
                }
                case QUIT -> {
                    return;
                }
            }
        }
    }

    private static Integer getCountryId(Scanner scanner, DataSource ds) {
        System.out.print(ANSI.Color.basicString("Unesite ID države: ", ANSI.BasicColor.WHITE));
        int id;
        try {
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(ANSI.Color.basicString("Nevažeći unos!", ANSI.BasicColor.RED));
            scanner.nextLine();
            return null;
        }
        MessageState country = getCountryById(id, ds);
        System.out.println(country.message());
        if (!country.state()) return null;
        System.out.print(ANSI.Color.basicString("Unesite novi naziv: ", ANSI.BasicColor.WHITE));
        return id;
    }

    private static void printMenu() {
        System.out.println(
                ANSI.Color.basicBackground(
                        ANSI.Color.basicString("       Evidencija Država       ", ANSI.BasicColor.BLACK),
                        ANSI.BasicColor.WHITE));
        ANSI.Color.enableBrightString(ANSI.BasicColor.YELLOW);
        System.out.println("1 - Nova država");
        System.out.println("2 - Izmjena postojeće države");
        System.out.println("3 - Brisanje postojeće države");
        System.out.println("4 - Prikaz svih država po nazivu");
        System.out.println("5 - Kraj");
        ANSI.Color.disableForeground();
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


    private static void addNew(String country, DataSource ds) {
        if (country.isBlank()) {
            System.out.println(ANSI.Color.basicString("Nepravilan unos!", ANSI.BasicColor.RED));
            return;
        }
        String query = """
                INSERT INTO dbo.Drzava(Naziv)
                VALUES(?)
                """;
        try (
                Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
        ) {
            ps.setString(1, country);
            if (ps.executeUpdate() == 1) {
                System.out.println(ANSI.Color.basicString("Uspješno dodano!", ANSI.BasicColor.GREEN));
            } else {
                System.out.println(ANSI.Color.basicString("Dražavu je nemoguće dodati!", ANSI.BasicColor.RED));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static MessageState getCountryById(int id, DataSource ds) {
        String query = """
                SELECT d.Naziv
                FROM dbo.Drzava d
                WHERE d.IDDrzava = ?;
                """;

        try (
                Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query);

        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new MessageState(
                            ANSI.Color.basicString("Odabrana Drzava: ", ANSI.BasicColor.BLUE) +
                                    rs.getString("Naziv"),
                            true);
                }
                return new MessageState(
                        ANSI.Color.basicString("Nepostoji unos za ID: ", ANSI.BasicColor.RED) + id,
                        false);
            }
        } catch (SQLException e) {
            return new MessageState(e.getMessage(), false);
        }

    }

    private static void renameCountry(String naziv, int id, DataSource ds) {
        String query = """
                UPDATE dbo.Drzava
                SET Naziv = ?
                WHERE IDDrzava = ?
                """;

        try (
                Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
        ) {
            ps.setString(1, naziv);
            ps.setInt(2, id);
            if (ps.executeUpdate() == 1) {
                System.out.println(ANSI.Color.basicString("Uspješno izmjenjeno!", ANSI.BasicColor.GREEN));
            } else {
                System.out.println(ANSI.Color.basicString("Dražavu je nemoguće izmjeniti!", ANSI.BasicColor.RED));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteCountryById(int id, DataSource ds) {
        String query = """
                DELETE
                FROM dbo.Drzava
                WHERE IDDrzava = %d
                """;

        try (
                Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
        ) {
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                System.out.println(ANSI.Color.basicString("Uspješno izbrisano!", ANSI.BasicColor.GREEN));
            } else {
                System.out.println(ANSI.Color.basicString("Dražavu je nemoguće izbrisati!", ANSI.BasicColor.RED));
            }
        } catch (SQLException e) {
            System.out.println(ANSI.Color.basicString("Dražavu je nemoguće izbrisati!", ANSI.BasicColor.RED));
        }
    }

    private static void printCountriesByName(DataSource ds) {
        String query = """
                SELECT *
                FROM dbo.Drzava d
                ORDER BY d.Naziv
                """;

        try (
                Connection con = ds.getConnection();
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(query);
        ) {
            System.out.println(ANSI.Color.basicString("*****DRZAVE U TABLICI*****", ANSI.BasicColor.GREEN));
            while (rs.next()) {
                System.out.println(
                        rs.getString("Naziv") +
                                "  -  " +
                                ANSI.Color.basicString(rs.getString("IDDrzava"), ANSI.BasicColor.GREEN));
            }
            System.out.println(ANSI.Color.basicString("**************************", ANSI.BasicColor.GREEN));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}