import org.junit.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void mainTest() throws Exception{

        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        Main.main(null);
        assertNotNull(bos.toString());
        System.setOut(originalOut);
    }

}