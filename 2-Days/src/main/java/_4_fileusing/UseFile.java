package _4_fileusing;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class UseFile {

    String path = "";
    final File file;
    public UseFile(String path) {
       this.path = path+".txt";
       file = new File(this.path);
    }

    public void create() throws Exception {
        if ( !file.exists() ) {
            file.createNewFile();
        }
    }

    public void write( String data ) throws Exception {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.append(data + System.lineSeparator());
        fileWriter.close();
    }

    public void read() throws Exception {
        Scanner scanner = new Scanner(file);
        while( scanner.hasNextLine() ) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }

}
