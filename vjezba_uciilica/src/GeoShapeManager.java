import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class GeoShapeManager {

    public static void save(List<GeometricShape> shapes){
        File save = new File("save.txt");
        try(PrintWriter printWriter = new PrintWriter(save)){
            for(GeometricShape shape : shapes){
                printWriter.write(shape.toString() + '\n');
            }
        }catch(FileNotFoundException e){
            System.err.println("File not found!");
        }
    }

}
