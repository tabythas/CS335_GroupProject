import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class gui implements ActionListener {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel firstQuestion;
    private JPanel firstQuestionSummary;
    
    public gui() throws IOException{
        // create main frame
        mainFrame = new JFrame();
        
        // button for starting the quiz
        JButton mainButton = new JButton("Start Quiz");
        // need to connect the listener to the reciever 
        mainButton.addActionListener(this);

        // label to show the user what they are using
        JLabel mainLabel = new JLabel();
        mainLabel = new JLabel("Test Your Art Knowledge (or lack thereof)!");

        // each "page" will be a panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
        mainPanel.setLayout(new GridLayout(0, 1));
        // need to add components into the panel 
        mainPanel.add(mainLabel);
        mainPanel.add(mainButton);
        
        // add main panel to main frame
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        // application will close if exit is clicked
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setting frame title
        mainFrame.setTitle("Art Quiz");
        mainFrame.pack();
        mainFrame.setVisible(true);

    }
    // main method to call and build application
    public static void main(String[] args) throws IOException{
        new gui();
    }

    // method to connect the first button to an action when clicked
    public void actionPerformed(ActionEvent event){
        // when mainButton is clicked, the mainPanel will be invisible
        mainPanel.setVisible(false);
       
        try {
            // build next panel
            firstQuestion = new JPanel();
            firstQuestion.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

            JLabel firstQuestionLabel = new JLabel(); 
            firstQuestionLabel = new JLabel("Who is the artist of this painting?");
            firstQuestion.add(firstQuestionLabel);
            
            // for now, gathering image data from file. Will need to figure out import
            File file = new File("C:\\Users\\tabyt\\OneDrive\\Desktop\\CS335_SoftwareEngineering\\CS335_GroupProject\\monet_impression_sunrise.png");
            BufferedImage bufferedImage = ImageIO.read(file);
            ImageIcon image = new ImageIcon(bufferedImage);
            // need label to hold image
            JLabel firstImage = new JLabel();
            // add image to panel by setting icon
            firstImage.setIcon(image);
            firstQuestion.add(firstImage);

            // create four buttons for potential answers
            JButton firstQuestionButtonA = new JButton("A) Monet");
            firstQuestionButtonA.setPreferredSize(new Dimension(221,25));
            firstQuestion.add(firstQuestionButtonA);

            JButton firstQuestionButtonB = new JButton("B) Van Gough");
            firstQuestionButtonB.setPreferredSize(new Dimension(221,25));
            firstQuestion.add(firstQuestionButtonB);

            JButton firstQuestionButtonC = new JButton("C) Taylor Swift");
            firstQuestionButtonC.setPreferredSize(new Dimension(221,25));
            firstQuestion.add(firstQuestionButtonC);

            JButton firstQuestionButtonD = new JButton("D) Picaso");
            firstQuestionButtonD.setPreferredSize(new Dimension(221,25));
            firstQuestion.add(firstQuestionButtonD);
            
            // add firstQuestion panel to the mainFrame for it to be visible
            mainFrame.add(firstQuestion, BorderLayout.CENTER);

            // if one of the three incorrect answers are selected, the button turns red and is disabled
            firstQuestionButtonB.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent fcB) {
                    firstQuestionButtonB.setBackground(Color.RED);
                    firstQuestionButtonB.setEnabled(false);
                }
            });
            firstQuestionButtonC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent fcC) {
                    firstQuestionButtonC.setBackground(Color.RED);
                    firstQuestionButtonC.setEnabled(false);
                }
            });
            firstQuestionButtonD.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent fcC) {
                    firstQuestionButtonD.setBackground(Color.RED);
                    firstQuestionButtonD.setEnabled(false);
                }
            });

            // when correct answer is clicked, panel is set to visible=false and summary panel will appear
            firstQuestionButtonA.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent fcA) {
                    firstQuestion.setVisible(false);
                    
                    // panel to summarize information about painting 
                    firstQuestionSummary = new JPanel();
                    firstQuestionSummary.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                    JLabel firstQuestionCorrect = new JLabel();
                    firstQuestionCorrect = new JLabel("CORRECT");
                    Color correct = new Color(0, 153, 0);
                    firstQuestionCorrect.setForeground(correct);
                    
                    JLabel firstQuestionDescription = new JLabel();
                    firstQuestionDescription = new JLabel("The 'Impression Sunrise' was painted by Claude Monet in 1872. This painting depicts the port of Le Havre which is Monet's hometown.");

                    firstQuestionSummary.add(firstQuestionCorrect);
                    firstQuestionSummary.add(firstQuestionDescription);
                    firstQuestionSummary.add(firstImage);

                    JButton firstQuestionContinue = new JButton("Continue");
                    firstQuestionContinue.setPreferredSize(new Dimension(221,25));
                    firstQuestionSummary.add(firstQuestionContinue);
                    mainFrame.add(firstQuestionSummary, BorderLayout.CENTER);
                    
                    firstQuestionContinue.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent sc){
                            firstQuestionSummary.setVisible(false);
                        }
                    });
                    
                }
            });
        }
        catch (IOException ioe){
            ioe.printStackTrace(System.err);
        }
    }
} 