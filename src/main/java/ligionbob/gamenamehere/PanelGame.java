package ligionbob.gamenamehere;

import ligionbob.gamenamehere.utils.GetScreen;

import javax.swing.*;
import java.awt.*;

public class PanelGame extends JPanel {
    public PanelGame() {
        if(GetScreen.isHD(GetScreen.screenSize)) {
            this.setSize(1280, 720);
        } else {
            this.setSize(640, 480);
        }
        this.repaint();
    }

    public void paint(Graphics g) {
        g.drawRect(this.getWidth()/2 - 250, this.getHeight()/2 - 250, 500, 500);
    }
}
