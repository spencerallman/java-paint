import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class PaintApp {
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("Simple Java Paint");

        DrawingPanel canvas = new DrawingPanel();

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> canvas.clearCanvas());

        JButton colButton = new JButton("Choose Color");
        colButton.addActionListener(e -> {
            Color seleColor = JColorChooser.showDialog(frame,"Select Brush Color", Color.BLACK);

            if (seleColor != null){
                canvas.setBrushColor(seleColor);
            }
        });

        JPanel controls = new JPanel();
        controls.add(colButton);
        controls.add(clearButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.add(canvas);
        frame.add(controls, BorderLayout.NORTH);
        frame.setVisible(true);

    }
}
