package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    private String pin;
    TextField textField;
    JButton b1 , b2;
    public Deposit(String pin) {
        this.pin = pin;

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

        JLabel label1 = new JLabel("PLEASE ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460, 180, 400, 35);
        l3.add(label1);

        textField = new TextField();
        textField.setBackground(Color.WHITE);
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(700,362,150,35);
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);


        //setTitle("Deposit - Bank Management System");
        setSize(1550, 1080);
        setLocation(0, 0);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource()==b1){
                if (textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter the Amount You want to Deposit");
                }else {
                    Conn c = new Conn();
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+ amount+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pin);
                }
            } else if (e.getSource()==b2) {
                setVisible(false);
                new Transaction(pin);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
}

