package temp_calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Temp_Calculator extends JFrame{

    Temp_Calculator(){

        //--- All components declared
        JPanel topPanel, midPanel, downPanel;
        JLabel headL, fromL, toL;
        JComboBox fromCb, toCb;
        JTextField fromT, toT;
        JButton goBtn;
        Font h1 = new Font(Font.MONOSPACED, Font.BOLD, 18);
        Font h = new Font(Font.MONOSPACED, Font.BOLD, 15);
        Font h3 = new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, 15);
        String[] tempUnits = {"C", "F", "K"};
        DecimalFormat df = new DecimalFormat("###.##");
        
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, 250,50);
        topPanel.setLayout(null);
        topPanel.setBackground(Color.white);
        headL = new JLabel("-- CONVERT --");
        headL.setFont(h1);
        headL.setBounds(45, 10, 150, 30);
        topPanel.add(headL);
        add(topPanel);
        
        
        midPanel = new JPanel();
        midPanel.setBounds(0,50,250,150);
        midPanel.setLayout(null);
        midPanel.setBackground(Color.white);
        
        fromL = new JLabel("From: ");
        fromL.setBounds(30, 30, 60, 30);
        fromL.setFont(h3);
        
        fromCb = new JComboBox(tempUnits);
        fromCb.setBounds(80,38,40,20);
        fromCb.setFont(h3);
        fromCb.setBackground(Color.white);
        
        fromT = new JTextField();
        fromT.setBounds(130,38,70,21);
        fromT.setFont(h3);
        
        
        toL = new JLabel("To: ");
        toL.setBounds(30, 80, 50, 30);
        toL.setFont(h3);
        
        toCb = new JComboBox(tempUnits);
        toCb.setBounds(80,88,40,20);
        toCb.setFont(h3);
        toCb.setBackground(Color.white);
        
        toT = new JTextField();
        toT.setBounds(130,88,70,21);
        toT.setFont(h3);
        
        
        midPanel.add(fromL);
        midPanel.add(fromCb);
        midPanel.add(fromT);
        midPanel.add(toL);
        midPanel.add(toCb);
        midPanel.add(toT);
        add(midPanel);
        
        
        downPanel = new JPanel();
        downPanel.setLayout(null);
        downPanel.setBounds(0,200,250,62);
        downPanel.setBackground(Color.white);
        goBtn = new JButton("GO");
        goBtn.setFont(h);
        goBtn.setBounds(90,0,60,25);
        goBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String s = fromT.getText();
                if(fromCb.getSelectedItem() == toCb.getSelectedItem()){
                    toT.setText(s);
                }else if(fromCb.getSelectedItem().equals("C") && toCb.getSelectedItem().equals("F")){
                    double f, c = Double.parseDouble(s);
                    f = ((c*9)/5)+32;
                    toT.setText(String.valueOf(df.format(f)));
                }else if(fromCb.getSelectedItem().equals("C") && toCb.getSelectedItem().equals("K")){
                    double k, c = Double.parseDouble(s);
                    k = c+273;
                    toT.setText(String.valueOf(df.format(k)));
                }else if(fromCb.getSelectedItem().equals("F") && toCb.getSelectedItem().equals("C")){
                    double c, f = Double.parseDouble(s);
                    c = ((f-32)*5)/9;
                    toT.setText(String.valueOf(df.format(c)));
                }else if(fromCb.getSelectedItem().equals("F") && toCb.getSelectedItem().equals("K")){
                    double k, f = Double.parseDouble(s);
                    k = ((5*(f-32))/9)+273;
                    toT.setText(String.valueOf(df.format(k)));
                }else if(fromCb.getSelectedItem().equals("K") && toCb.getSelectedItem().equals("C")){
                    double c, k = Double.parseDouble(s);
                    c = k-273;
                    toT.setText(String.valueOf(df.format(c)));
                }else if(fromCb.getSelectedItem().equals("K") && toCb.getSelectedItem().equals("F")){
                    double f, k = Double.parseDouble(s);
                    f = ((9*(k-273))/5)+32;
                    toT.setText(String.valueOf(df.format(f)));
                }
            }
        });
        downPanel.add(goBtn);
        add(downPanel);

        setTitle("Temperature Calculator");
        setLayout(null);
        setSize(250, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Temp_Calculator();
    }
    
}
