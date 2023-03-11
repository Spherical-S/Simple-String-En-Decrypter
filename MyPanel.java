package learning_gui;


import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;

class MyPanel extends JPanel {
    MyPanel (int width, int height, int x, int y, Color color) {
        setBackground(color);
        setPreferredSize(new Dimension(width, height));
        setBounds(x, y, width, height);
    }
}