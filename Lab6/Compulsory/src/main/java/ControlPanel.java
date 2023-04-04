import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.event.ActionEvent;

/*public class ControlPanel extends JPanel {
    final MainFrame frame;

    //creates buttons
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        //set the layout
        setLayout(new GridLayout(1, 4));

        //add buttons
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        //listeners for all buttons
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);
    }

    //setters
    public void setExitBtn(JButton exitBtn) {
        this.exitBtn = exitBtn;
    }

    public void setLoadBtn(JButton loadBtn) {
        this.loadBtn = loadBtn;
    }

    public void setResetBtn(JButton resetBtn) {
        this.resetBtn = resetBtn;
    }

    public void setSaveBtn(JButton saveBtn) {
        this.saveBtn = saveBtn;
    }

    //getters
    public MainFrame getFrame() {
        return frame;
    }
    public JButton getExitBtn() {
        return exitBtn;
    }
    public JButton getLoadBtn() {
        return loadBtn;
    }

    public JButton getResetBtn() {
        return resetBtn;
    }
    public JButton getSaveBtn() {
        return saveBtn;
    }

    //Listener
    private void loadGame(ActionEvent e){
    }
    private void saveGame(ActionEvent e){

    }
    private void resetGame(ActionEvent e){

    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

}*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void loadGame(ActionEvent e) {
        System.out.println("Load"); //TODO...
    }

    private void saveGame(ActionEvent e) {
        System.out.println("Save"); //TODO...
    }

    private void resetGame(ActionEvent e) {
        System.out.println("Reset"); //TODO...
    }
}
