package learning_gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{

    JButton encrypt;
    JButton decrypt;
    JTextField input;
    JLabel output;

    MyFrame () {// class constructor
    
        this.setSize(435, 280);
        this.setTitle("Sphericals String En/Decrypter");
        this.setResizable(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        MyPanel titlePanel = new MyPanel(435, 100, 0, 0, Color.white);
        titlePanel.setLayout(new BorderLayout());

        MyPanel inputPanel = new MyPanel(435, 160, 0, 100, Color.white);
        inputPanel.setLayout(null);

        JLabel title = new JLabel("Welcome!");
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Cinzel Black", Font.PLAIN, 50));
        titlePanel.add(title);

        JLabel inputLabel = new JLabel("Input text below:");
        inputLabel.setBounds(125, 0, 300, 50);
        inputLabel.setFont(new Font("Cinzel Black", Font.PLAIN, 20));
        inputPanel.add(inputLabel);

        input = new JTextField();
        input.setPreferredSize(new Dimension(400, 30));
        input.setBounds(10, 35, 400, 30);
        input.setFont(new Font("Doppio One", Font.PLAIN, 20));
        inputPanel.add(input);

        encrypt = new JButton("Encrypt");
        encrypt.setFont(new Font("Cinzel Black", Font.PLAIN, 12));
        encrypt.addActionListener(this);
        encrypt.setBounds(80, 90, 90, 30);
        inputPanel.add(encrypt);

        decrypt = new JButton("Decrypt");
        decrypt.setFont(new Font("Cinzel Black", Font.PLAIN, 12));
        decrypt.addActionListener(this);
        decrypt.setBounds(250, 90, 90, 30);
        inputPanel.add(decrypt);

        this.add(titlePanel);
        this.add(inputPanel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == encrypt){
            encryptString(input.getText());
        }
        if (e.getSource() == decrypt){
            decryptString(input.getText());
        }
    }

    public void encryptString(String input){
        String encryptedText = "";
        String charsString = "V;g~&!+tYwHrZsBn#em[DR}/Ga^`<%hdfTp8l196@7c40'X)ASQ(okj:NqK32WP {EC$uIyF*-M,zJbO.Lx5=i]v?_U>\"\\";
        char[] chars = charsString.toCharArray();
        int newChar = 0;
        int count = 0;
        for (int i = 0; i<input.length(); i++){
            if (count == 45){
                encryptedText = encryptedText + "\n";
                count = 0;
            }
            if (!charsString.contains(input.substring(i, i+1))){
                JOptionPane.showMessageDialog(this, "All characters must be default ASCII characters!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            if (input.substring(i, i+1) == "\\"){
                newChar = 0;
            }else{
                newChar = charsString.indexOf(input.substring(i, i+1)) + 1;
            }
            encryptedText = encryptedText + chars[newChar];
            count++;
        }
        JOptionPane.showMessageDialog(this, encryptedText, "Output:", JOptionPane.INFORMATION_MESSAGE);
    }

    public void decryptString(String input){
        String decryptedText = "";
        String charsString = "V;g~&!+tYwHrZsBn#em[DR}/Ga^`<%hdfTp8l196@7c40'X)ASQ(okj:NqK32WP {EC$uIyF*-M,zJbO.Lx5=i]v?_U>\"\\";
        char[] chars = charsString.toCharArray();
        int newChar = 0;
        int count = 0;
        for (int i = 0; i<input.length(); i++){
            if (count == 45){
                decryptedText = decryptedText + "\n";
                count = 0;
            }
            if (!charsString.contains(input.substring(i, i+1))){
                JOptionPane.showMessageDialog(this, "All characters must be default ASCII characters!", "Error", JOptionPane.WARNING_MESSAGE);
                break;
            }
            if (input.substring(i, i+1) == "V"){
                newChar = charsString.indexOf("\\");
            }else{
                newChar = charsString.indexOf(input.substring(i, i+1)) - 1;
            }
            decryptedText = decryptedText + chars[newChar];
            count++;
        }
        JOptionPane.showMessageDialog(this, decryptedText, "Output:", JOptionPane.INFORMATION_MESSAGE);
    }
}