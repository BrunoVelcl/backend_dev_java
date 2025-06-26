import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Ucilica ucilica = new Ucilica();

        String input;
        do{
        System.out.print("Želite li poredati oblike po površini? (Y/N):");
        input = scanner.nextLine().toUpperCase();
        }while(!(input.equals("Y") | input.equals("N")));
        if(input.equals("Y")){
            ucilica.sortByArea();
        }

        StringBuilder sb = new StringBuilder();
        System.out.println("**************************************************");
        for(GeometricShape shape: ucilica.getShapesList()){
            sb.append("\u001b[33m")
                .append(shape.getType().toString())
                .append("\u001b[37m")
                .append(" Površina: [")
                .append(String.format("%.2f", shape.getArea()))
                .append("] Radijus: [")
                .append(String.format("%.2f", shape.getPerimeter()))
                .append("]\n");
        }
        System.out.println(sb);
    }
}

