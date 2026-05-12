import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
    private ArrayList<ColoredPoint> points = new ArrayList<>();
    private Color brushColor = Color.BLACK;

    public DrawingPanel(){
        setBackground(Color.WHITE);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override public void mouseDragged(MouseEvent e){
                ColoredPoint newPoint = new ColoredPoint(e.getPoint(), brushColor);
                points.add(newPoint);

                repaint();
            }
        });
    }

    public void setBrushColor(Color newColor){
        if (newColor != null && !newColor.equals(this.brushColor)){
            this.brushColor = newColor;
        }
    }

    public void clearCanvas(){
        if (!points.isEmpty()){
            points.clear();
            repaint();
        }
    }

    @Override protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(brushColor);

        for (ColoredPoint cp : points){
            g.setColor(cp.color);
            g.fillOval(cp.position.x, cp.position.y, 10, 10);
        }
    }
}
