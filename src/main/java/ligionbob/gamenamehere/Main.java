package ligionbob.gamenamehere;

import ligionbob.gamenamehere.utils.*;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static final JFrame frameMain = new JFrame();
    public static final JPanel panelMainMenu = new JPanel();
    public static final JButton buttonStart = new JButton();

    public static final GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();


    public static void main(String[] args) {
        if(init()) {
            LogUtil.getLogger().info("Initialization Complete");
        }

    }
    private static boolean init() {
        try {
            LogUtil.init();
            setPanelMainMenu();
            setFrameMain(panelMainMenu, WindowConstants.EXIT_ON_CLOSE, true);
            frameMain.setLocation((screen.getDisplayMode().getWidth() / 2) - frameMain.getWidth()/2, (screen.getDisplayMode().getHeight() / 2) - frameMain.getHeight()/2);

        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private static void setPanelMainMenu() {
        int width = 640;
        int height = 480;
        if(GetScreen.isHD(GetScreen.screenSize)) {
            width = 1280;
            height = 720;
        }
        panelMainMenu.setSize(width, height);
    }
    public static void setFrameMain(JPanel panel, int closeOperation, boolean resizable) {
        frameMain.setVisible(false);
        frameMain.setContentPane(panel);
        frameMain.setSize(panel.getSize());
        frameMain.setDefaultCloseOperation(closeOperation);
        frameMain.setResizable(resizable);
        frameMain.setVisible(true);
    }
}
