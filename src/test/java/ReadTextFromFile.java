import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Натали on 08.11.2017.
 */
public class ReadTextFromFile {
    @Test
    public void main() {
        {
            Scanner scanner = null;
            try {
                scanner = new Scanner(new File("E:/Git/file.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Set<Integer> words = new TreeSet<>();
            while (scanner.hasNext()) {
                int word = Integer.parseInt(scanner.useDelimiter(",").next());
                words.add(Integer.valueOf(word));
            }

            System.out.println("Значения по возрастанию: " + words);

            List<Integer> reverseNumbers = new ArrayList<>(words);
            Collections.sort(reverseNumbers, Collections.reverseOrder());

            System.out.println("Значения по убыванию: " + reverseNumbers);

        }
    }

}
