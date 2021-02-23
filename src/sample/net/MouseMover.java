package sample.net;

import java.awt.Robot;
import java.util.Random;

public class MouseMover {


    public static void main(String... args) throws Exception {
        int FIVE_SECONDS = 50;
        int MAX_Y = 100;
        int MAX_X = 100;
        Robot robot = new Robot();
        Random random = new Random();
        for (int i=10;i<1000;i+=100){
                for (int j=i;j<300;j+=10) {
                    robot.mouseMove(i, j);

                    System.out.println("X = " + i + " , Y = " + j);
                    Thread.sleep(FIVE_SECONDS);
                }
                for (int j=i;j>300;j-=10) {
                robot.mouseMove(i, j);
                System.out.println("X = " + i + " , Y = " +j);
                Thread.sleep(FIVE_SECONDS);
               }

        }
    }
}