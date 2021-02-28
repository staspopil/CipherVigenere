package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

    JFrame a = new JFrame("Vijiner");
    JButton Button = new JButton("Encrypt");
    JTextField message = new JTextField("Write Message");
    JTextField SecondKey = new JTextField("Write SecondKey");
    JLabel EncryptedMessage = new JLabel("Message");
    ButtonGroup group = new ButtonGroup();
    JRadioButton smallButton = new JRadioButton("Encrypt", true);
    JRadioButton mediumButton = new JRadioButton("Decrypt", false);
    Message tempMes = new Message();




    public void CreateFrame(){

        group.add(smallButton);
        group.add(mediumButton);
        message.setBounds(145,48,200,20);
        message.setHorizontalAlignment(JTextField.CENTER);
        Button.setBounds(200,160,85,20);
        EncryptedMessage.setBounds(200,125,300,20);
        //EncryptedMessage.setHorizontalAlignment(JTextField.CENTER);
        smallButton.setBounds(145,100,100,20);
        mediumButton.setBounds(275,100,100,20);
        SecondKey.setBounds(145,70,200,20);
        SecondKey.setHorizontalAlignment(JTextField.CENTER);
        JLabel note1 = new JLabel("Message:");
        JLabel note2 = new JLabel("Key:");
        JLabel note3 = new JLabel("Processed message:");
       // note.setBounds(10,24,200,20);
        note1.setBounds(10,48,200,20);
        note2.setBounds(10,72,200,20);
        note3.setBounds(5,125,200,20);
        //a.add(note);
        a.add(note1);
        a.add(note2);
        a.add(note3);
        a.add(SecondKey);
        a.add(Button);
        a.add(message);
        a.add(EncryptedMessage);
        a.add(smallButton);
        a.add(mediumButton);
        a.setSize(700,230);
        a.setLayout(null);
        a.setLocationRelativeTo(null);
        a.setVisible(true);

    }

    public void Button(){
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempMes.setData(message.getText(),SecondKey.getText(),smallButton.isSelected());
                tempMes.process();
               // System.out.println(tempMes.getNewMessage());
                EncryptedMessage.setText(tempMes.getNewMessage());
            }
        });
    }


}
