package com.wutevr;
import javax.swing.*;
import java.awt.*;

/* Example usage
// Window and spider grid creation and display
        LaunchPage launchPage = new LaunchPage();
        launchPage.setVisible(true);
 */

public class SpiderGrid extends JFrame {
    // Makes a window of size x y (1000, 1000) in the center of the screen
    public SpiderGrid(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
    }

    public void drawDiamond(int row, int column, Color color, Graphics g){
        //draws a diamond at the row and column given in the given color (row and column indexing starts at 1x1)
        g.setColor(color);
        int xx = 40 + 55 * (column - 1);
        int[] x = {xx, xx + 10, xx + 20, xx + 10};
        int yy = 75 + 55 * (row - 1);
        int[] y = {yy, yy + 10, yy, yy - 10};
        g.fillPolygon(x, y, 4);
    }

    public void drawGrid(int rows, int columns, Graphics g){
        // Draws giant square for all tiles to sit in (5 pixel gaps & borders)
        g.setColor(Color.gray);
        g.fillRect(20, 45, 55 * columns + 5, 55 * rows + 5);

        // Draws all tiles in a row by column formation (5 pxl gaps)
        g.setColor(Color.black);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                g.fillRect(25 + 55 * j, 50 + 55 * i, 50, 50);
            }
        }
    }

    public void paint(Graphics g) {

        // Draws a grid with 25 tiles to sit in a 5 by 5 formation (5 pixel gaps & borders)
        drawGrid(5, 5, g);

        // Draws a white ball for the spider
        g.setColor(Color.white);
        g.fillOval(92, 227, 25, 25);

        // Draws green diamond
        drawDiamond(3, 2, Color.green, g);

        // Draws red diamond
        drawDiamond(2, 2, Color.red, g);

        // Draws blue diamond
        drawDiamond(2, 4, Color.blue, g);

        g.setColor(Color.white);
    }
}
