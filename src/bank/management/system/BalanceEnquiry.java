package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JLabel label2 , label1;
    JButton b1;
    BalanceEnquiry(String pin){
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        JLabel l3 = null;
        if (i1.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("Image not found. Please check the file path.");
        } else {
            Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l3 = new JLabel(i3);
            l3.setBounds(0, 0, 1550, 830);
            add(l3);
        }

        label1 = new JLabel("Your Current Balance is Rs. ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430, 180, 700, 35);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430, 220, 400, 35);
        l3.add(label2);

        b1 = new JButton("Back");
        b1.setBounds(700,362,150,35);
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'" );
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);

        setSize(1550, 1080);
        setLocation(0, 0);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");

    }
}
