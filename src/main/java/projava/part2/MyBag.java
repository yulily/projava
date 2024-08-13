package projava.part2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyBag
{
    public static void main(String[] args) {
        var frame = new JFrame("test");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var label = new JLabel("test");
        frame.add(label);

        var image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        label.setIcon(new ImageIcon(image));

        var line1 = image.createGraphics();
        line1.drawLine(0, 0, 300, 300);

        var line2 = image.createGraphics();
        line2.drawLine(0, 300, 300, 0);

        var line3 = image.createGraphics();
        line3.drawLine(0, 150, 300, 150);

        var line4 = image.createGraphics();
        line4.drawLine(150, 0, 150, 300);

        var circle = image.createGraphics();
        circle.setColor(Color.BLUE);
        circle.fillOval(125, 125, 50, 50);

        var rect = image.createGraphics();
        rect.setColor(Color.GREEN);
        rect.fillRect(125, 175, 50, 50);

        var triangle1 = image.createGraphics();
        triangle1.setColor(Color.RED);
        triangle1.drawLine(125, 125, 150, 75);

        var triangle2 = image.createGraphics();
        triangle2.setColor(Color.RED);
        triangle2.drawLine(175, 125, 150, 75);

        var triangle3 = image.createGraphics();
        triangle3.setColor(Color.RED);
        triangle3.drawLine(125, 125, 175, 125);

        frame.pack();
        frame.setVisible(true);
    }
}
