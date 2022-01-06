package _5_usetink;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

public class MainTink {

    File file = new File("secure.txt");

    public static void main(String[] args) {

        try {

        String key128Bit = "NcRfTjWnZr4u7x!A";
        String plainText = "100_12312312312_true_ali";
        //String associatedData = "ext_key";
        String associatedData = UUID.randomUUID().toString();
        System.out.println(associatedData);

        String cipherText = TinkEncDec.encrypt(key128Bit, plainText, associatedData);
        //System.out.println(cipherText);

        MainTink tink = new MainTink();
        tink.writeNio(cipherText);

        String readFile = tink.readNio();
        String plnText = TinkEncDec.decrypt(key128Bit, readFile, associatedData);
        System.out.println(plnText);

        }catch (Exception ex) {
            System.err.println("File Error : " + ex);
        }
    }

    public String readNio() throws IOException {
        Path path = Paths.get(file.getAbsolutePath());
        String fileContent = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        return fileContent;
    }

    public void writeNio(String cipherText) throws IOException {
        Path path = Paths.get(file.getAbsolutePath());
        Files.write(path, cipherText.getBytes(StandardCharsets.UTF_8));
    }



}
