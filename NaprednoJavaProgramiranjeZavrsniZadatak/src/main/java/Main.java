import com.evidencija.domain.entity.Enrolled;
import com.evidencija.domain.entity.Program;
import com.evidencija.domain.entity.Student;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource ds = createDataSource();


        //test
        Student marko = new Student("Marko", "Markic");
        Program java = new Program("Java", 50);
        if(addProgram(java, ds)){
            System.out.println("Succsess");
        }else{
            System.out.println("fail");
        }
    }

    while(true){

    }



    private static boolean addStudent(Student student, DataSource ds){
        String query = """
                {CALL dbo.dodajNovogPolaznika(?, ?)}
                """;
        try(
            Connection con = ds.getConnection();
            CallableStatement cs = con.prepareCall(query);
        ) {
            cs.setString(1, student.getFirstName());
            cs.setString(2, student.getLastName());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean addProgram(Program program, DataSource ds){
        String query = """
                {CALL dbo.dodajNoviProgramObrazovanja(?,?)}
                """;
        try(
                Connection con = ds.getConnection();
                CallableStatement cs = con.prepareCall(query);
        ) {
            cs.setString(1, program.getName());
            cs.setInt(2, program.getCsvet());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean registerStudent(Student student, Program program, DataSource ds){
        String query = """
                {CALL dbo.UpisPolaznika(?,?)}
                """;
        try(
                Connection con = ds.getConnection();
                CallableStatement cs = con.prepareCall(query);
        ) {
            cs.setInt(1, student.getId());
            cs.setInt(2, program.getId());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean transferStudent(Student student, Program programOut, Program programIn, DataSource ds){
        String query = """
                {CALL dbo.dbo.PrebaciPolaznika(?,?,?)}
                """;
        try(
                Connection con = ds.getConnection();
                CallableStatement cs = con.prepareCall(query);
        ) {
            cs.setInt(1, student.getId());
            cs.setInt(2, programOut.getId());
            cs.setInt(3, programIn.getId());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static List<Enrolled> getEnrolled(Program program, DataSource ds){
        List<Enrolled> enroled = new ArrayList<>();
        String query = """
                SELECT Ime, Prezime, Naziv, CSVET
                FROM dbo.ProgramObrazovanja
                	JOIN dbo.Polaznik ON Polaznik.PolaznikId = ProgramObrazovanja.ProgramObrazovanjaId
                WHERE ProgramObrazovanjaId = ?
                """;
        String query2 = "{CALL dbo.ispisiPolaznikeZaProgram(?)}";
        try(
                Connection con = ds.getConnection();
                CallableStatement cs = con.prepareCall(query2);
        ) {
            cs.setInt(1, program.getId());
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                enroled.add(
                        new Enrolled(
                                rs.getRow(),
                                new Student(rs.getString(1), rs.getString(2)),
                                new Program(rs.getString(3), rs.getInt(4))
                        ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enroled;
    }



    private static DataSource createDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("DESKTOP-Q1U8QL7\\SQLEXPRESS");
        ds.setDatabaseName("JavaAdv");
        ds.setUser("java");
        ds.setPassword("sql");
        ds.setEncrypt(false);
        return ds;
    }

    public static void ispisiIzbornik(){
        System.out.println("Odaberite opciju: ");
        System.out.println("1. Unesite novog polaznika.");
        System.out.println("2");
    }
}

