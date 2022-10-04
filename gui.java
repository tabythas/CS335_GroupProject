import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;

public class gui implements ActionListener {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton mainButton;
    private JLabel mainLabel;
    private JPanel firstQuestion;
    private JPanel firstQuestionSummary;
    private JPanel secondQuestion;
    private int width = 221;
    private int height = 25;
    
    public gui(){
        // create main frame
        mainFrame = new JFrame();
        
        // button for starting the quiz
        mainButton = new JButton("Start Quiz");
        // need to connect the listener to the reciever 
        mainButton.addActionListener(this);

        // label to show the user what they are using
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
    public static void main(String[] args){
        new gui();
    }

    // method to connect the first button to an action when clicked
    public void actionPerformed(ActionEvent event){
        // when mainButton is clicked, the mainPanel will be invisible
        mainPanel.setVisible(false);
       
        // build next panel
        firstQuestion = new JPanel();
        firstQuestion.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        mainLabel = new JLabel("Who is the artist of this painting?");
        firstQuestion.add(mainLabel);
            
        // for now, gathering image data from file. Will need to figure out import
        File file = new File("monet_impression_sunrise.png");
        String absPath = file.getAbsolutePath();
        ImageIcon image = new ImageIcon(absPath);
        // need label to hold image
        JLabel firstImage = new JLabel();
        // add image to panel by setting icon
        firstImage.setIcon(image);
        firstQuestion.add(firstImage);

        // create four buttons for potential answers
        JButton firstQuestionButtonA = new JButton("A) Monet");
        firstQuestionButtonA.setPreferredSize(new Dimension(width, height));
        firstQuestion.add(firstQuestionButtonA);

        JButton firstQuestionButtonB = new JButton("B) Van Gough");
        firstQuestionButtonB.setPreferredSize(new Dimension(width, height));
        firstQuestion.add(firstQuestionButtonB);

        JButton firstQuestionButtonC = new JButton("C) Taylor Swift");
        firstQuestionButtonC.setPreferredSize(new Dimension(width, height));
        firstQuestion.add(firstQuestionButtonC);

        JButton firstQuestionButtonD = new JButton("D) Picaso");
        firstQuestionButtonD.setPreferredSize(new Dimension(width, height));
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

                mainLabel = new JLabel("CORRECT");
                Color correct = new Color(0, 153, 0);
                mainLabel.setForeground(correct);
                    
                JLabel firstQuestionDescription = new JLabel();
                firstQuestionDescription = new JLabel("The 'Impression Sunrise' was painted by Claude Monet in 1872. This painting depicts the port of Le Havre which is Monet's hometown.");

                firstQuestionSummary.add(mainLabel);
                firstQuestionSummary.add(firstQuestionDescription);
                firstQuestionSummary.add(firstImage);

                JButton firstQuestionContinue = new JButton("Continue");
                firstQuestionContinue.setPreferredSize(new Dimension(width, height));
                firstQuestionSummary.add(firstQuestionContinue);
                mainFrame.add(firstQuestionSummary, BorderLayout.CENTER);
                    
        firstQuestionContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent sc){
                firstQuestionSummary.setVisible(false);

                secondQuestion = new JPanel();
                secondQuestion.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                mainLabel = new JLabel("What country did this painting orginiate from?");
                secondQuestion.add(mainLabel);

                // for now, gathering image data from file. Will need to figure out import
                File file2 = new File("great_wave_kanagawa.png");
                String absPath = file2.getAbsolutePath();
                ImageIcon image2 = new ImageIcon(absPath);
                // need label to hold image
                JLabel secondImage = new JLabel();
                // add image to panel by setting icon
                secondImage.setIcon(image2);
                secondQuestion.add(secondImage);

                // create four buttons for potential answers
                JButton secondQuestionButtonA = new JButton("A) Monet");
                secondQuestionButtonA.setPreferredSize(new Dimension(width, height));
                secondQuestion.add(secondQuestionButtonA);

                JButton secondQuestionButtonB = new JButton("B) Van Gough");
                secondQuestionButtonB.setPreferredSize(new Dimension(width, height));
                secondQuestion.add(secondQuestionButtonB);

                JButton secondQuestionButtonC = new JButton("C) Taylor Swift");
                secondQuestionButtonC.setPreferredSize(new Dimension(width, height));
                secondQuestion.add(secondQuestionButtonC);

                JButton secondQuestionButtonD = new JButton("D) Picaso");
                secondQuestionButtonD.setPreferredSize(new Dimension(width, height));
                secondQuestion.add(secondQuestionButtonD);

                // if one of the three incorrect answers are selected, the button turns red and is disabled
                secondQuestionButtonB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent fcB) {
                        secondQuestionButtonB.setBackground(Color.RED);
                        secondQuestionButtonB.setEnabled(false);
                    }
                });
                secondQuestionButtonC.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent fcC) {
                        secondQuestionButtonC.setBackground(Color.RED);
                        secondQuestionButtonC.setEnabled(false);
                    }
                });
                secondQuestionButtonD.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent fcC) {
                        secondQuestionButtonD.setBackground(Color.RED);
                        secondQuestionButtonD.setEnabled(false);
                    }
                });

                mainFrame.add(secondQuestion, BorderLayout.CENTER);
            }
                    
        }
    );
                    
        }
    });
            
}
} 