package board.scoreBoard.slot_machin;

import javax.swing.*;

import Interface.SlotMachinChosenCoinListener;
import board.scoreBoard.TurnPanel;
import constants.CoinColor;
import player.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChooseCoin extends JDialog {
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JButton submitButton;
    private JButton exitButton;
    private ArrayList<String> selectedColors = new ArrayList<>(); // ArrayList to store selected colors

    private SlotMachinChosenCoinListener slotMachinChosenCoinListener;
    TurnPanel turnPanel;

    private SlotMachin slotmachin[] =  new SlotMachin[5];

    public ChooseCoin(SlotMachinChosenCoinListener slotMachinChosenCoinListener, TurnPanel turnPanel) {
        this.turnPanel = turnPanel;
        this.slotMachinChosenCoinListener = slotMachinChosenCoinListener;

        setTitle("Slot Machin");
        setSize(400, 400);
        setLayout(new GridLayout(3, 4));

        creatSlotMAchinIcon();
        createCheckbox();
        createAcceptbutton();
    }

    private void createCheckbox(){
        // Create checkboxes
        checkBox1 = new JCheckBox();

        checkBox2 = new JCheckBox();

        checkBox3 = new JCheckBox();
        
        checkBox4 = new JCheckBox();

        checkBox5 = new JCheckBox();
        
        // Add checkboxes and button to the frame
        add(checkBox1);
        add(slotmachin[0]);

        add(checkBox2);
        add(slotmachin[1]);

        add(checkBox3);
        add(slotmachin[2]);

        add(checkBox4);
        add(slotmachin[3]);

        add(checkBox5);
        add(slotmachin[4]);
    }

    private void createAcceptbutton(){
        // Create a button
        submitButton = new JButton("Submit");
        add(submitButton);

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if either one checkbox or three checkboxes are selected
                int selectedCount = 0;
                StringBuilder selectedCheckboxes = new StringBuilder();
                
        
                if (checkBox1.isSelected()) {
                    selectedCount++;
                    selectedCheckboxes.append("Checkbox 1 ");
                    selectedColors.add("P"); 
                }
                if (checkBox2.isSelected()) {
                    selectedCount++;
                    selectedCheckboxes.append("Checkbox 2 ");
                    selectedColors.add("O"); 
                }
                if (checkBox3.isSelected()) {
                    selectedCount++;
                    selectedCheckboxes.append("Checkbox 3 ");
                    selectedColors.add("R"); 
                }
                if (checkBox4.isSelected()) {
                    selectedCount++;
                    selectedCheckboxes.append("Checkbox 4 ");
                    selectedColors.add("B"); 
                }
                if (checkBox5.isSelected()) {
                    selectedCount++;
                    selectedCheckboxes.append("Checkbox 5 ");
                    selectedColors.add("G"); 
                }
        
                if (selectedCount == 1 || selectedCount == 3) {
                    slotMachinChosenCoinListener.onSelectedCoins();
                    turnPanel.updateTurn();                    
                    dispose();
                }
                else {
                    selectedColors.clear(); // Clear the ArrayList
                    checkBox1.setSelected(false); // Clear the checkboxes
                    checkBox2.setSelected(false);
                    checkBox3.setSelected(false);
                    checkBox4.setSelected(false);
                    checkBox5.setSelected(false);
                }
            }
        });
    }        

    private void creatExitButton(){
        exitButton = new JButton("Exit");

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
    }

    private void creatSlotMAchinIcon(){
        slotmachin[0] = new SlotMachin(CoinColor.PINK);
        slotmachin[1] = new SlotMachin(CoinColor.ORANGE);
        slotmachin[2] = new SlotMachin(CoinColor.RED);
        slotmachin[3] = new SlotMachin(CoinColor.BLUE);
        slotmachin[4] = new SlotMachin(CoinColor.GREEN);
    }

    public ArrayList<String> getSelectedColors() {
        return selectedColors;
    }
}

