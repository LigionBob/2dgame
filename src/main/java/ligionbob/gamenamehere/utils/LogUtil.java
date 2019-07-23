package ligionbob.gamenamehere.utils;

import ligionbob.gamenamehere.utils.appenders.JTextAreaAppender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class LogUtil {
    private static JFrame frameLog;
    private static JTextArea textAreaLog = new JTextArea();

    private static Logger logger = LogManager.getLogger("GameNameHere");
    public static void init() {
        frameLog = new JFrame("Log");
        frameLog.setVisible(false);
        frameLog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameLog.setSize(640,480);
        frameLog.setResizable(false);
        textAreaLog.setSize(frameLog.getSize());
        textAreaLog.setEditable(false);
        textAreaLog.setText("");
        textAreaLog.setFont(new Font("Courier", Font.PLAIN, 18));
        textAreaLog.setLineWrap(true);
        JScrollPane scrollPaneLog = new JScrollPane(textAreaLog);
        scrollPaneLog.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        JTextAreaAppender.addTextArea(textAreaLog);
        frameLog.add(scrollPaneLog);
        frameLog.setVisible(true);
    }

    public static Logger getLogger() {
        return logger;
    }
}
