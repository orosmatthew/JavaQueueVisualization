package queue_visualization;

import queue.Queue;
import queue.QueueLL;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DisplayGraphics extends Canvas {

    private static final Queue<String> queue = new QueueLL<>();

    public static void main(String[] args) {
        setupUI();
    }

    private static void setupUI() {

        // enable anti-aliasing
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        // main frame
        JFrame frame = new JFrame();
        frame.setSize(600, 400);

        // panel for content
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setBackground(new Color(40, 44, 52));

        // layout for top and bottom sections
        GridLayout layout = new GridLayout(2, 0);
        panel.setLayout(layout);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // panel for buttons and text box
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(33, 37, 43));
        GridLayout controlLayout = new GridLayout(3, 0);
        controlLayout.setVgap(10);
        controlPanel.setLayout(controlLayout);
        controlPanel.setBorder(new EmptyBorder(25, 50, 25, 50));

        // add queue graphics to top of panel
        DisplayGraphics displayGraphics = new DisplayGraphics();
        panel.add(displayGraphics);

        // add controls to bottom
        panel.add(controlPanel);

        // set up control panel
        JTextField textField = new JTextField();
        Border textBorder = BorderFactory.createLineBorder(new Color(50, 56, 68), 3);
        textField.setBorder(textBorder);
        Font textFont = textField.getFont().deriveFont(18.0f);
        textField.setFont(textFont);
        textField.setBackground(new Color(40, 44, 52));
        textField.setForeground(new Color(130, 141, 150));

        JButton dequeueButton = new JButton("dequeue");
        dequeueButton.setBorderPainted(false);
        dequeueButton.setFocusPainted(false);
        dequeueButton.setBackground(new Color(199, 84, 80));
        dequeueButton.setForeground(new Color(33, 37, 43));
        dequeueButton.addActionListener(e -> {
            queue.dequeue();
            displayGraphics.repaint();
            textField.grabFocus();
            System.out.println(queue);
        });
        controlPanel.add(dequeueButton);

        controlPanel.add(textField);

        JButton enqueueButton = new JButton("enqueue");
        enqueueButton.setBorderPainted(false);
        enqueueButton.setFocusPainted(false);
        enqueueButton.setBackground(new Color(73, 156, 84));
        enqueueButton.setForeground(new Color(33, 37, 43));
        enqueueButton.addActionListener(e -> {
            if (textField.getText().equals(""))
                return;
            queue.enqueue(Character.toString(textField.getText().charAt(0)));
            displayGraphics.repaint();
            textField.grabFocus();
            System.out.println(queue);
        });
        controlPanel.add(enqueueButton);

        // allows user to press enter to add item
        frame.getRootPane().setDefaultButton(enqueueButton);

        frame.setResizable(false);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textField.grabFocus();
    }

    // paints queue item box
    private void drawData(Graphics g, int pos, String data) {
        g.setColor(new Color(51, 124, 151));
        g.fillRect(10 + (60 * pos), 50, 50, 50);

        Font font = g.getFont().deriveFont(20.0f);
        g.setFont(font);
        g.setColor(new Color(33, 37, 43));
        g.drawString(data, 15 + (60 * pos), 75);
    }

    public void paint(Graphics g) {

        Queue<String> queueCopy = queue.copy();

        int count = 0;

        while (!queueCopy.empty()) {
            drawData(g, count, queueCopy.dequeue());
            count++;
        }
    }
}
