import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

/*public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        //line label
        linesLabel = new JLabel("Line probability:");
        Double[] value = {1.0,2.0};
        linesCombo = new JComboBox(value);

        //button
        createButton = new JButton("Create new game");

        //add buttons
        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
}*/

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;



    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel = new JLabel("Line probability:");
        linesCombo = new JComboBox(new String[]{"1.0", "1.2", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0"});
        createButton = new JButton("Create new game");
        //...TODO
        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
//        createButton.addActionListener(this::createGame);
        //...TODO
    }

//    private void createGame(ActionEvent e) {
//        System.out.println("Create new game"); //TODO...
////        int numVertices = (int) dotsSpinner.getValue();
////        double edgeProbability = Double.parseDouble((String) linesCombo.getSelectedItem());
////        frame.drawingPanel.createBoard(numVertices, edgeProbability);
//    }

}


