
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.util.Random;


import static java.lang.Math.abs;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    Color currentPlayerColor = Color.RED;
    int numEdges;
    int[] edgeStartX = new int[100];
    int[] edgeStartY = new int[100];
    int[] edgeEndX = new int[100];
    int[] edgeEndY = new int[100];

    Color[] edgeColors = new Color[100];

//    Color winnerPlayerColor;


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        frame.configPanel.createButton.addActionListener(e -> createBoard());
//        frame.controlPanel.resetBtn.addActionListener(e -> createBoard());
//        frame.controlPanel.loadBtn.addActionListener(e -> createBoard());
//        frame.controlPanel.saveBtn.addActionListener(e -> createBoard());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Get the x,y coordinates of the mouse click
                int mouseX = e.getX();
                int mouseY = e.getY();
                // Check if the mouse click was on a line segment
                for (int i = 0; i < numEdges; i++) {
                    int x1 = edgeStartX[i];
//                    System.out.println("x1 = " + x1);
                    int y1 = edgeStartY[i];
//                    System.out.println("y1 = " + y1);
                    int x2 = edgeEndX[i];
//                    System.out.println("x2 = " + x2);
                    int y2 = edgeEndY[i];
//                    System.out.println("y2 = " + y2);
                    double distance = distanceFromPointToLine(mouseX, mouseY, x1, y1, x2, y2);
//                    System.out.println("distance = " + distance);
                    if (distance < 8 && edgeColors[i] == Color.GRAY) {
                        // The mouse was pressed on this line segment, update its color
                        currentPlayerColor = (currentPlayerColor == Color.RED) ? Color.BLUE : Color.RED;
                        graphics.setColor(currentPlayerColor);
                        graphics.drawLine(x1, y1, x2, y2);
                        edgeColors[i] = currentPlayerColor;
                        checkForTriangle();
//                        if (checkForTriangle()) {
////                            System.out.println("Triangle found!");
////                            System.out.println("Player " + winnerPlayerColor + " wins!");
//                            break;
//                        }
                        break;
                    }
                }
                repaint();
            }
        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = Double.parseDouble((String) frame.configPanel.linesCombo.getSelectedItem());
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        numEdges = 0;
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < numVertices - 1; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                float rand = new Random().nextFloat();
                if (rand * 2 <= edgeProbability) {
                    edgeStartX[numEdges] = x[i] + 5;
                    edgeStartY[numEdges] = y[i] + 5;
                    edgeEndX[numEdges] = x[j] + 5;
                    edgeEndY[numEdges] = y[j] + 5;
                    graphics.drawLine(x[i] + 5, y[i] + 5, x[j] + 5, y[j] + 5);
                    edgeColors[numEdges] = Color.GRAY;
                    numEdges++;
                }
            }
        }
        System.out.println("nr de linii: " + numEdges);
    }

    private void drawVertices() {
        graphics.setColor(Color.BLACK);
//        System.out.println(graphics.getColor());
        for (int i = 0; i < numVertices; i++) {
            graphics.drawOval(x[i], y[i], 10, 10);
            graphics.fillOval(x[i], y[i], 10, 10);
//            System.out.println("drew vertex " + i);
        }
    }

    @Override
    public void update(Graphics g) {
    } //No need for update


    //Draw the offscreen image, using the original graphics @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

    public double distanceFromPointToLine(int x, int y, int x1, int y1, int x2, int y2) {
        double numerator = abs((y2 - y1) * x - (x2 - x1) * y + x2 * y1 - y2 * x1);
        double denominator = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        return numerator / denominator;
    }

    private void checkForTriangle() {
        for (int i = 0; i < numVertices - 2; i++) {
            for (int j = i + 1; j < numVertices - 1; j++) {
                int e1 = existsEdge(x[i], y[i], x[j], y[j]);
//                System.out.println(e1);
                if (e1 != 0) {
                    for (int k = j + 1; k < numVertices; k++) {
                        int e2 = existsEdge(x[i], y[i], x[k], y[k]);
//                        System.out.println(e2);
                        int e3 = existsEdge(x[j], y[j], x[k], y[k]);
//                        System.out.println(e3);
                        if (e2 != 0 && e3 != 0) {
                            if (edgeColors[e1] == edgeColors[e2] && edgeColors[e2] == edgeColors[e3] && edgeColors[e1]!=Color.GRAY){
                                System.out.println("Triangle found!");
                                if (edgeColors[e1] == Color.RED) {
                                    System.out.println("Player RED wins!");
                                } else {
                                    System.out.println("Player BLUE wins!");
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    private int existsEdge(int x1, int y1, int x2, int y2) {
        for (int i = 0; i < numEdges; i++) {
            if ((abs(edgeStartX[i] - x1) < 10 && abs(edgeStartY[i] - y1) < 10)
                    && abs(edgeEndX[i] - x2) < 10 && abs(edgeEndY[i] - y2) < 10) {
                return i;
            }
        }
        return 0;
    }

    private boolean isTriangle(int xA, int yA, int xB, int yB, int xC, int yC) {
        double a = Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
        double b = Math.sqrt(Math.pow(xC - xB, 2) + Math.pow(yC - yB, 2));
        double c = Math.sqrt(Math.pow(xA - xC, 2) + Math.pow(yA - yC, 2));
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        }
        return false;
    }
}