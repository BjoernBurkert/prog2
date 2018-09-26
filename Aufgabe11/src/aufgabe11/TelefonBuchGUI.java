// O. Bittel
// 10.03.2017

package aufgabe11;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class TelefonBuchGUI extends JFrame {

    private TelefonBuch telBuch;
    private JFrame telefonBuchFrame;

    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        telBuch = new TelefonBuch();
        telefonBuchFrame = new JFrame("Telefonbuch");
        

        // Menuleiste einbauen:
        // ...
        JMenuBar menuBar = new TelefonBuchMenuBar(telBuch);
        telefonBuchFrame.setJMenuBar(menuBar);
        
       JPanel mainPanel = new JPanel();
       JPanel einfuegenPanel = new TelefonBuchEinfuegenPanel(telBuch);
       JPanel suchenLoeschenPanel = new JPanel();
       suchenLoeschenPanel = new TelefonBuchSuchenLoeschenPanel(telBuch);

        // mainPanel mit Umrandung versehen und das
        // Einfuegen- und  SuchenLoeschenPanel einbauen:
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(einfuegenPanel);
        mainPanel.add(suchenLoeschenPanel);

        // Sonstige Eigenschaften des Hauptfenster setzen:
        telefonBuchFrame.setContentPane(mainPanel);
        telefonBuchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telefonBuchFrame.pack();
        telefonBuchFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new TelefonBuchGUI();
    }
}
