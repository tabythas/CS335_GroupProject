import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

public class additional_frame implements ActionListener{
    private JFrame frame2 = new JFrame("Quiz");
    private JPanel panel1;

    public additional_frame() throws IOException{
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(730, 600);
        frame2.setVisible(true);
        JButton button1 = new JButton("Next Question");
        button1.addActionListener(this);

        button1.setSize(20,20);

        
        File file = new File("C:\\Users\\tabyt\\OneDrive\\Desktop\\CS335_SoftwareEngineering\\CS335_GroupProject\\impression_sunrise.png");
        BufferedImage bufferedImage = ImageIO.read(file);

        ImageIcon image = new ImageIcon(bufferedImage);
        

        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

        JLabel jLabel = new JLabel();
        jLabel.setIcon(image);

        panel1.add(jLabel);
        panel1.add(button1);

        frame2.add(panel1, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Question 1");
        frame2.pack();
        frame2.setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        frame2.dispose();
    }
}
