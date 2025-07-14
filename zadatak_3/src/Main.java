import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

    Osoblje osoblje = new Osoblje();
    osoblje.ucitaIzDatoteke();
    osoblje.ispisi();

    }
}