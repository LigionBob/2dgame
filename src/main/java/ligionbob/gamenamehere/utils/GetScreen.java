package ligionbob.gamenamehere.utils;

import java.awt.*;

public class GetScreen {
    public static final GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static final Dimension screenSize = new Dimension(screen.getDisplayMode().getWidth(), screen.getDisplayMode().getHeight());

    public static boolean isHD(Dimension screenSize) {
        if(screenSize.getWidth() >= 1920 && screenSize.getHeight() >= 1080) {
            return true;
        } else {
            return false;
        }
    }
}
