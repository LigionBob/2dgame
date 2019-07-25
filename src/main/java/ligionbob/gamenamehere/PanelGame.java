package ligionbob.gamenamehere;

import ligionbob.gamenamehere.utils.GetScreen;
import ligionbob.gamenamehere.utils.LogUtil;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.security.Key;

public class PanelGame extends JPanel implements ActionListener, KeyListener {

    private static int rectX;
    private static int newX;
    private static int rectY;
    private static int newY;
    private static int rectWidth;
    private static int rectHeight;
    Timer timer = new Timer(1, this);

    public PanelGame() {
        timer.start();
        if(GetScreen.isHD(GetScreen.screenSize)) {
            this.setSize(1280, 720);
        } else {
            this.setSize(640, 480);
        }
        rectWidth = 100;
        rectHeight = 100;
        rectX = this.getWidth()/2 - rectWidth/2;
        rectY = this.getHeight()/2 - rectHeight/2;
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.repaint();
    }
    public void move(int direction) {
        switch(direction){
            case 0:
                newY = rectY - 10;
                break;
            case 1:
                newY= rectY + 10;
                break;
            case 2:
                newX = rectX - 10;
                break;
            case 3:
                newX = rectX + 10;
                break;
            default:
                LogUtil.getLogger().info("Move method being told to move in a nonexistent direction!");
                break;
        }
        if(newX > this.getWidth() - rectWidth) {
            newX = 0;
        }
        if(newY > this.getHeight() - rectHeight) {
            newY = 0;
        }
        if(newX < 0) {
            newX = this.getWidth() - rectWidth;
        }
        if(newY < 0) {
            newY = this.getHeight() - rectHeight;
        }

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(rectX, rectY, rectWidth, rectHeight);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_W) {
            move(0);
            repaint();
            rectY = newY;
            //rectX = newX;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_S) {
            move(1);
            repaint();
            rectY = newY;
            //rectX = newX;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_A) {
            move(2);
            repaint();
            //rectY = newY;
            rectX = newX;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_D) {
            move(3);
            repaint();
            //rectY = newY;
            rectX = newX;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
