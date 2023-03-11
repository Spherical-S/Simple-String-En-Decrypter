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
		
		//Setting up the window frame
        this.setSize(435, 280);
        this.setTitle("Sphericals String En/Decrypter");
        this.setResizable(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		// Panel to hold the title label
        MyPanel titlePanel = new MyPanel(435, 100, 0, 0, Color.white);
        titlePanel.setLayout(new BorderLayout());

		// Panel to hold the input text and the buttons
        MyPanel inputPanel = new MyPanel(435, 160, 0, 100, Color.white);
        inputPanel.setLayout(null);

		// Title label
        JLabel title = new JLabel("Welcome!");
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Cinzel Black", Font.PLAIN, 50));
        titlePanel.add(title);
		
		// Label to show where ti input text
        JLabel inputLabel = new JLabel("Input text below:");
        inputLabel.setBounds(125, 0, 300, 50);
        inputLabel.setFont(new Font("Cinzel Black", Font.PLAIN, 20));
        inputPanel.add(inputLabel);

		// Input text field
        input = new JTextField();
        input.setPreferredSize(new Dimension(400, 30));
        input.setBounds(10, 35, 400, 30);
        input.setFont(new Font("Doppio One", Font.PLAIN, 20));
        inputPanel.add(input);

		// The encrypt button
        encrypt = new JButton("Encrypt");
        encrypt.setFont(new Font("Cinzel Black", Font.PLAIN, 12));
        encrypt.addActionListener(this);
        encrypt.setBounds(80, 90, 90, 30);
        inputPanel.add(encrypt);
		
		// The decrypt button
        decrypt = new JButton("Decrypt");
        decrypt.setFont(new Font("Cinzel Black", Font.PLAIN, 12));
        decrypt.addActionListener(this);
        decrypt.setBounds(250, 90, 90, 30);
        inputPanel.add(decrypt);
		
		// Add the panels to the frame and set visibility
        this.add(titlePanel);
        this.add(inputPanel);
        this.setVisible(true);
    }

    // Method which handles the button clicks
	public void actionPerformed(ActionEvent e){
        if (e.getSource() == encrypt){
            encryptString(input.getText());
        }
        if (e.getSource() == decrypt){
            decryptString(input.getText());
        }
    }
	
	// Method to encrypt a string
    public void encryptString(String input){
        String encryptedText = "";
        String charsString = "V;g~&!+tYwHrZsBn#em[DR}/Ga^`<%hdfTp8l196@7c40'X)ASQ(okj:NqK32WP {EC$uIyF*-M,zJbO.Lx5=i]v?_U>\"\\";
        char[] chars = charsString.toCharArray();
        int newChar = 0;
        int count = 0;
        for (int i = 0; i<input.length(); i++){ //Loop through each character in the input
            if (count == 45){ // Add new line every 45 characters
                encryptedText = encryptedText + "\n";
                count = 0;
            }
            if (!charsString.contains(input.substring(i, i+1))){ //Check if the current character is a valid ascii character
                JOptionPane.showMessageDialog(this, "All characters must be default ASCII characters!", "Error", JOptionPane.WARNING_MESSAGE);
            }
			// Set the current character to the next element in the chars[] array
            if (input.substring(i, i+1) == "\\"){
                newChar = 0;
            }else{
                newChar = charsString.indexOf(input.substring(i, i+1)) + 1;
            }
            encryptedText = encryptedText + chars[newChar];
            count++;
        }
        JOptionPane.showMessageDialog(this, encryptedText, "Output:", JOptionPane.INFORMATION_MESSAGE); // Display the encrypted string
    }
	
	// Method to decrypt a string
    public void decryptString(String input){
        String decryptedText = "";
        String charsString = "V;g~&!+tYwHrZsBn#em[DR}/Ga^`<%hdfTp8l196@7c40'X)ASQ(okj:NqK32WP {EC$uIyF*-M,zJbO.Lx5=i]v?_U>\"\\";
        char[] chars = charsString.toCharArray();
        int newChar = 0;
        int count = 0;
        for (int i = 0; i<input.length(); i++){ //Loop through each character in the input
            if (count == 45){ // Add new line every 45 characters
                decryptedText = decryptedText + "\n";
                count = 0;
            }
            if (!charsString.contains(input.substring(i, i+1))){ //Check if the current character is a valid ascii character
                JOptionPane.showMessageDialog(this, "All characters must be default ASCII characters!", "Error", JOptionPane.WARNING_MESSAGE);
                break;
            }
			// Set the current character to the previous element in the chars[] array
            if (input.substring(i, i+1) == "V"){
                newChar = charsString.indexOf("\\");
            }else{
                newChar = charsString.indexOf(input.substring(i, i+1)) - 1;
            }
            decryptedText = decryptedText + chars[newChar];
            count++;
        }
        JOptionPane.showMessageDialog(this, decryptedText, "Output:", JOptionPane.INFORMATION_MESSAGE); // Display the decrypted string
    }
}