import java.awt.*;
import java.util.Random;

public class Keybord {
    public static void main(String[] args) {

        Robot robot = null;
        try {


            robot = new Robot();
            Random random = new Random();
            robot.mouseMove(9, 8);
            robot.keyPress(768);



        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
