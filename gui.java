import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class gui implements ActionListener {

    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    
    public gui() throws IOException{
        frame = new JFrame();
        JButton button = new JButton("Start Quiz");
        button.addActionListener(this);

        label = new JLabel("Test Your Art Knowledge (or lack thereof)!");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Art Quiz");
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) throws IOException{
        new gui();
    }

    public void actionPerformed(ActionEvent event){
        frame.dispose();
        try {
            new additional_frame();
        }
        catch (IOException ioe){
            ioe.printStackTrace(System.err);
        }
       
    }
}    