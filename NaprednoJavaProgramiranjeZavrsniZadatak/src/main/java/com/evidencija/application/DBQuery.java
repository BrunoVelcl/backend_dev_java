package com.evidencija.application;

import com.evidencija.domain.entity.Enrolled;
import com.evidencija.domain.entity.Program;
import com.evidencija.domain.entity.Student;
import com.evidencija.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBQuery {
    public static boolean addStudent(Student student){
        String query = " {CALL dbo.dodajNovogPolaznika(?, ?)}";
        try(
                Connection con = Util.ds.getConnection();
                CallableStatement cs = con.prepareCall(query)
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

     public static boolean addProgram(Program program){
        String query = "{CALL dbo.dodajNoviProgramObrazovanja(?,?)}";
        try(
                Connection con = Util.ds.getConnection();
                CallableStatement cs = con.prepareCall(query)
        ) {
            cs.setString(1, program.getName());
            cs.setInt(2, program.getCsvet());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean registerStudent(Student student, Program program){
        String query = "{CALL dbo.UpisPolaznika(?,?)}";
        try(
                Connection con = Util.ds.getConnection();
                CallableStatement cs = con.prepareCall(query)
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

    public static boolean transferStudent(Student student, Program programOut, Program programIn){
        String query = "{CALL dbo.PrebaciPolaznika(?,?,?)}";
        try(
                Connection con = Util.ds.getConnection();
                CallableStatement cs = con.prepareCall(query)
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

    public static List<Enrolled> getEnrolled(Program program){
        List<Enrolled> enroled = new ArrayList<>();
        String query = "{CALL dbo.ispisiPolaznikeZaProgram(?)}";
        try(
                Connection con = Util.ds.getConnection();
                CallableStatement cs = con.prepareCall(query)
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

    public static List<Student> filterStudentByFirstName(String firstName){
        List<Student> students = new ArrayList<>();
        String query = """
                SELECT PolaznikId, Ime, Prezime
                FROM dbo.Polaznik
                WHERE Ime LIKE ?
                """;

        try(
                Connection con = Util.ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
                ) {
            ps.setString(1, "%"+firstName+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1));
                students.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<Student> filterStudentByLastName(String lastName){
        List<Student> students = new ArrayList<>();
        String query = """
                SELECT PolaznikId, Ime, Prezime
                FROM dbo.Polaznik
                WHERE Prezime LIKE ?
                """;

        try(
                Connection con = Util.ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
        ) {
            ps.setString(1, "%"+lastName+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                students.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static Student getStudentById(int id){
        String query = """
                SELECT PolaznikId, Ime, Prezime
                FROM dbo.Polaznik
                WHERE PolaznikId = ?
                """;

        try(
                Connection con = Util.ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Program> filterProgramByName(String name){
        List<Program> programs = new ArrayList<>();
        String query = """
                SELECT ProgramObrazovanjaId, Naziv, CSVET
                FROM dbo.ProgramObrazovanja
                WHERE Naziv LIKE ?
                """;
        try(
                Connection con = Util.ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
                ) {
            ps.setString(1, "%"+name+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                programs.add(new Program(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programs;
    }

    public static List<Program> filterProgramByCSVET(Integer csvet){
        List<Program> programs = new ArrayList<>();
        String query = """
                SELECT ProgramObrazovanjaId, Naziv, CSVET
                FROM dbo.ProgramObrazovanja
                WHERE CSVET = ?
                """;
        try(
                Connection con = Util.ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
                ) {
            ps.setInt(1,csvet);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                programs.add(new Program(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programs;
    }

    public static Program getProgramById(int id){
        String query = """
                SELECT ProgramObrazovanjaId, Naziv, CSVET
                FROM dbo.ProgramObrazovanja
                WHERE ProgramObrazovanjaId = ?
                """;
        try(
                Connection con = Util.ds.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
                ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Program(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
