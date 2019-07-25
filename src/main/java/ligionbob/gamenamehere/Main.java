package ligionbob.gamenamehere;

import ligionbob.gamenamehere.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static ligionbob.gamenamehere.utils.GetScreen.screen;

public class Main {

    public static final JFrame frameMain = new JFrame();
    public static final JPanel panelMainMenu = new JPanel();
    public static final JPanel panelGame = new PanelGame();
    public static final JButton buttonStart = new JButton();
    public static final SpringLayout layoutMainMenu = new SpringLayout();


    public static void main(String[] args) {
        if(init()) {
            LogUtil.getLogger().info("Initialization Complete");
        }

    }
    private static boolean init() {
        try {
            LogUtil.init();
            setComponents();
            setPanelMainMenu();
            setFrameMain(panelMainMenu, WindowConstants.EXIT_ON_CLOSE, true);
            frameMain.setLocation((screen.getDisplayMode().getWidth() / 2) - frameMain.getWidth()/2, (screen.getDisplayMode().getHeight() / 2) - frameMain.getHeight()/2);

        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private static void setComponents() {
        //set buttonStart
        buttonStart.setText("Start");
        buttonStart.setFont(new Font("Courier", Font.BOLD, 36));
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                LogUtil.getLogger().info("Starting Game");
                setFrameMain(panelGame, WindowConstants.EXIT_ON_CLOSE, true);
            }
        });
    }
    private static void setPanelMainMenu() {
        int width = 640;
        int height = 480;
        if(GetScreen.isHD(GetScreen.screenSize)) {
            width = 1280;
            height = 720;
        }
        panelMainMenu.setSize(width, height);
        panelMainMenu.setLayout(layoutMainMenu);
        panelMainMenu.add(buttonStart, layoutMainMenu);
        layoutMainMenu.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonStart, 0, SpringLayout.HORIZONTAL_CENTER, panelMainMenu);
        layoutMainMenu.putConstraint(SpringLayout.VERTICAL_CENTER, buttonStart, 0, SpringLayout.VERTICAL_CENTER, panelMainMenu);
    }
    public static void setFrameMain(JPanel panel, int closeOperation, boolean resizable) {
        frameMain.setVisible(false);
        frameMain.setContentPane(panel);
        LogUtil.getLogger().info("Panel Size = " + panel.getSize());
        frameMain.setSize(panel.getSize());
        LogUtil.getLogger().info("Frame Size = " + panel.getSize());
        frameMain.setDefaultCloseOperation(closeOperation);
        frameMain.setResizable(resizable);
        frameMain.revalidate();
        frameMain.repaint();
        frameMain.setVisible(true);
    }
}
