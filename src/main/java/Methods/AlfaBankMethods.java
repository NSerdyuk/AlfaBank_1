package Methods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Натали on 08.11.2017.
 */
public class AlfaBankMethods {
    public static void writeUsingFileWriter(String ttl, String txt) {
        String browser = "Chrome";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss");
        System.out.println(dateFormat.format(date));

        File file = new File("E:/Git/.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(ttl+txt);


        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
                file.renameTo(new File("E:/Git/" + browser + dateFormat.format(date) + ".txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
