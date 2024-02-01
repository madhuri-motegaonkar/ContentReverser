import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class FileContentReverser {
    public static void main(String[] args) {
        InputStreamReader ioStream = null;
        try {
            ioStream = new InputStreamReader(FileContentReverser.class
                    .getResource("Input.txt").openStream());

            BufferedReader bufferedContent = new BufferedReader(ioStream);
            ArrayList list = new ArrayList();
            String line;
            while ((line = bufferedContent.readLine()) != null) {
                list.add(new StringBuilder(line).reverse().toString());
            }

            Collections.reverse(list);

            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Output.txt")));
            for (Iterator i = list.iterator(); i.hasNext();) {
                printWriter.println((String) i.next());
            }
            printWriter.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        finally {
            if(ioStream!=null)
                try{
                    ioStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
