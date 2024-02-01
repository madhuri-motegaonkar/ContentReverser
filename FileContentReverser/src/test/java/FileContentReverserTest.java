import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileContentReverserTest {

    @Description("It should read input.txt from test resources folder and create output file with content reversed")
    @Test
    public void verifyFileContentsAreReversed() throws IOException {
        File file = new File(FileContentReverserTest.class
                .getClassLoader()
                .getResource("Input.txt").getFile());
        if(!file.exists()) file.createNewFile();
        FileContentReverser.main(new String[]{});
        BufferedReader bufferedContent = new BufferedReader(new FileReader("Output.txt"));
        String line = bufferedContent.readLine();
        assertEquals("FEDCBA",line);
    }
}
