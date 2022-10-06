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
    private JPanel secondQuestionSummary;
    private JPanel thirdQuestion; 
    private JPanel thirdQuestionSummary;
    private JPanel fourthQuestion;
    private JPanel fourthQuestionSummary;
    private JPanel fifthQuestion;
    private JPanel fifthQuestionSummary;
    private JPanel finalPanel;
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
        mainPanel.setBorder(BorderFactory.createEmptyBorder(275, 275, 275, 275));
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
        mainFrame.setSize(850,650);
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
            public void actionPerformed(ActionEvent fqB) {
                firstQuestionButtonB.setBackground(Color.RED);
                firstQuestionButtonB.setEnabled(false);
            }
        });
        firstQuestionButtonC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent fqC) {
                firstQuestionButtonC.setBackground(Color.RED);
                firstQuestionButtonC.setEnabled(false);
            }
        });
        firstQuestionButtonD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent fqD) {
                firstQuestionButtonD.setBackground(Color.RED);
                firstQuestionButtonD.setEnabled(false);
            }
        });

        // when correct answer is clicked, panel is set to visible=false and summary panel will appear
        firstQuestionButtonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent fqA) {
                firstQuestion.setVisible(false);
                    
                // panel to summarize information about painting 
                firstQuestionSummary = new JPanel();
                firstQuestionSummary.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                mainLabel = new JLabel("CORRECT");
                Color correct = new Color(0, 153, 0);
                mainLabel.setForeground(correct);
                    
                JLabel firstQuestionDescription = new JLabel();
                firstQuestionDescription = new JLabel("The 'Impression Sunrise' was painted by Claude Monet in 1872."
                                            + " This painting depicts the port of Le Havre which is Monet's hometown.");

                firstQuestionSummary.add(mainLabel);
                firstQuestionSummary.add(firstQuestionDescription);
                firstQuestionSummary.add(firstImage);

                JButton firstQuestionContinue = new JButton("Continue");
                firstQuestionContinue.setPreferredSize(new Dimension(width, height));
                firstQuestionSummary.add(firstQuestionContinue);
                mainFrame.add(firstQuestionSummary, BorderLayout.CENTER);
                    
        firstQuestionContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent sq){
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
                JButton secondQuestionButtonA = new JButton("A) Philippines");
                secondQuestionButtonA.setPreferredSize(new Dimension(width, height));
                secondQuestion.add(secondQuestionButtonA);

                JButton secondQuestionButtonB = new JButton("B) Singapore");
                secondQuestionButtonB.setPreferredSize(new Dimension(width, height));
                secondQuestion.add(secondQuestionButtonB);

                JButton secondQuestionButtonC = new JButton("C) Japan");
                secondQuestionButtonC.setPreferredSize(new Dimension(width, height));
                secondQuestion.add(secondQuestionButtonC);

                JButton secondQuestionButtonD = new JButton("D) Taiwan");
                secondQuestionButtonD.setPreferredSize(new Dimension(width, height));
                secondQuestion.add(secondQuestionButtonD);

                mainFrame.add(secondQuestion, BorderLayout.CENTER);

                // if one of the three incorrect answers are selected, the button turns red and is disabled
                secondQuestionButtonA.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent sqA) {
                        secondQuestionButtonA.setBackground(Color.RED);
                        secondQuestionButtonA.setEnabled(false);
                    }
                });
                secondQuestionButtonB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent sqB) {
                        secondQuestionButtonB.setBackground(Color.RED);
                        secondQuestionButtonB.setEnabled(false);
                    }
                });
                secondQuestionButtonD.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent sqC) {
                        secondQuestionButtonD.setBackground(Color.RED);
                        secondQuestionButtonD.setEnabled(false);
                    }
                });
                
                secondQuestionButtonC.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent sqC) {
                        secondQuestion.setVisible(false);

                        // panel to summarize information about painting 
                        secondQuestionSummary = new JPanel();
                        secondQuestionSummary.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                        mainLabel = new JLabel("CORRECT");
                        Color correct = new Color(0, 153, 0);
                        mainLabel.setForeground(correct);
                    
                        JLabel secondQuestionDescription = new JLabel();
                        secondQuestionDescription = new JLabel("'The Great Wave off Kanagawa' was painted in 1831 by Japanese artist Hokusai."
                                                                + " Considered 'the most famous artwork in Japanese history.'");

                        secondQuestionSummary.add(mainLabel);
                        secondQuestionSummary.add(secondQuestionDescription);
                        secondQuestionSummary.add(secondImage);

                        JButton secondQuestionContinue = new JButton("Continue");
                        secondQuestionContinue.setPreferredSize(new Dimension(width, height));
                        secondQuestionSummary.add(secondQuestionContinue);
                        mainFrame.add(secondQuestionSummary, BorderLayout.CENTER);

                secondQuestionContinue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent tq){
                        secondQuestionSummary.setVisible(false);

                        thirdQuestion = new JPanel();
                        thirdQuestion.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                        mainLabel = new JLabel("What century is depicted in this painting?");
                        thirdQuestion.add(mainLabel);

                        // for now, gathering image data from file. Will need to figure out import
                        File file3 = new File("dance_le_moulin.png");
                        String absPath = file3.getAbsolutePath();
                        ImageIcon image3 = new ImageIcon(absPath);
                        // need label to hold image
                        JLabel thirdImage = new JLabel();
                        // add image to panel by setting icon
                        thirdImage.setIcon(image3);
                        thirdQuestion.add(thirdImage);

                        // create four buttons for potential answers
                        JButton thirdQuestionButtonA = new JButton("A) 17th Century");
                        thirdQuestionButtonA.setPreferredSize(new Dimension(width, height));
                        thirdQuestion.add(thirdQuestionButtonA);

                        JButton thirdQuestionButtonB = new JButton("B) 16th Century");
                        thirdQuestionButtonB.setPreferredSize(new Dimension(width, height));
                        thirdQuestion.add(thirdQuestionButtonB);

                        JButton thirdQuestionButtonC = new JButton("C) 18th Century");
                        thirdQuestionButtonC.setPreferredSize(new Dimension(width, height));
                        thirdQuestion.add(thirdQuestionButtonC);

                        JButton thirdQuestionButtonD = new JButton("D) 19th Century");
                        thirdQuestionButtonD.setPreferredSize(new Dimension(width, height));
                        thirdQuestion.add(thirdQuestionButtonD);

                        mainFrame.add(thirdQuestion, BorderLayout.CENTER);

                        // if one of the three incorrect answers are selected, the button turns red and is disabled
                        thirdQuestionButtonA.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent tqA) {
                                thirdQuestionButtonA.setBackground(Color.RED);
                                thirdQuestionButtonA.setEnabled(false);
                            }
                        });
                        thirdQuestionButtonB.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent tqB) {
                                thirdQuestionButtonB.setBackground(Color.RED);
                                thirdQuestionButtonB.setEnabled(false);
                            }
                        });
                        thirdQuestionButtonC.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent tqC) {
                                thirdQuestionButtonC.setBackground(Color.RED);
                                thirdQuestionButtonC.setEnabled(false);
                            }
                        });

                        thirdQuestionButtonD.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent tqD) {
                                thirdQuestion.setVisible(false);

                                // panel to summarize information about painting 
                                thirdQuestionSummary = new JPanel();
                                thirdQuestionSummary.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                                mainLabel = new JLabel("CORRECT");
                                Color correct = new Color(0, 153, 0);
                                mainLabel.setForeground(correct);
                    
                                JLabel thirdQuestionDescription = new JLabel();
                                thirdQuestionDescription = new JLabel("In the 19th century, Pierre-Auguste Renoir painted 'Bal du moulin de la Galette'." 
                                                                    + "Captures the escence of a Paris outing.");

                                thirdQuestionSummary.add(mainLabel);
                                thirdQuestionSummary.add(thirdQuestionDescription);
                                thirdQuestionSummary.add(thirdImage);

                                JButton thirdQuestionContinue = new JButton("Continue");
                                thirdQuestionContinue.setPreferredSize(new Dimension(width, height));
                                thirdQuestionSummary.add(thirdQuestionContinue);
                                mainFrame.add(thirdQuestionSummary, BorderLayout.CENTER);
                        
                thirdQuestionContinue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent fourthq) {
                        thirdQuestionSummary.setVisible(false);

                        fourthQuestion = new JPanel();
                        fourthQuestion.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                        mainLabel = new JLabel("What is the name of this very famous painting?");
                        fourthQuestion.add(mainLabel);

                        // for now, gathering image data from file. Will need to figure out import
                        File file4 = new File("starry_night.png");
                        String absPath = file4.getAbsolutePath();
                        ImageIcon image4 = new ImageIcon(absPath);
                        // need label to hold image
                        JLabel fourthImage = new JLabel();
                        // add image to panel by setting icon
                        fourthImage.setIcon(image4);
                        fourthQuestion.add(fourthImage);

                        // create four buttons for potential answers
                        JButton fourthQuestionButtonA = new JButton("A) Starry Night");
                        fourthQuestionButtonA.setPreferredSize(new Dimension(width, height));
                        fourthQuestion.add(fourthQuestionButtonA);

                        JButton fourthQuestionButtonB = new JButton("B) Star Night");
                        fourthQuestionButtonB.setPreferredSize(new Dimension(width, height));
                        fourthQuestion.add(fourthQuestionButtonB);

                        JButton fourthQuestionButtonC = new JButton("C) Moonlight");
                        fourthQuestionButtonC.setPreferredSize(new Dimension(width, height));
                        fourthQuestion.add(fourthQuestionButtonC);

                        JButton fourthQuestionButtonD = new JButton("D) Star at Night");
                        fourthQuestionButtonD.setPreferredSize(new Dimension(width, height));
                        fourthQuestion.add(fourthQuestionButtonD);

                        mainFrame.add(fourthQuestion, BorderLayout.CENTER);

                        // if one of the three incorrect answers are selected, the button turns red and is disabled
                        fourthQuestionButtonB.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent fourqB) {
                                fourthQuestionButtonB.setBackground(Color.RED);
                                fourthQuestionButtonB.setEnabled(false);
                            }
                        });
                        fourthQuestionButtonC.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent fourqB) {
                                fourthQuestionButtonC.setBackground(Color.RED);
                                fourthQuestionButtonC.setEnabled(false);
                            }
                        });
                        fourthQuestionButtonD.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent frouqC) {
                                fourthQuestionButtonD.setBackground(Color.RED);
                                fourthQuestionButtonD.setEnabled(false);
                            }
                        });

                        fourthQuestionButtonA.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent fourqD) {
                                fourthQuestion.setVisible(false);

                                // panel to summarize information about painting 
                                fourthQuestionSummary = new JPanel();
                                fourthQuestionSummary.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                                mainLabel = new JLabel("CORRECT");
                                Color correct = new Color(0, 153, 0);
                                mainLabel.setForeground(correct);
                    
                                JLabel fourthQuestionDescription = new JLabel();
                                fourthQuestionDescription = new JLabel("Vincet van Gogh is arguabely one of the world's most famous aritsts. "
                                                                        + "'Starry Night' was painted in 1889.");

                                fourthQuestionSummary.add(mainLabel);
                                fourthQuestionSummary.add(fourthQuestionDescription);
                                fourthQuestionSummary.add(fourthImage);

                                JButton fourthQuestionContinue = new JButton("Continue");
                                fourthQuestionContinue.setPreferredSize(new Dimension(width, height));
                                fourthQuestionSummary.add(fourthQuestionContinue);
                                mainFrame.add(fourthQuestionSummary, BorderLayout.CENTER);
                    
                fourthQuestionContinue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent fifthq) {
                        fourthQuestionSummary.setVisible(false);
                        
                        fifthQuestion = new JPanel();
                        fifthQuestion.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                        mainLabel = new JLabel("This painting ushered in a new wave of Impressionism called...");
                        fifthQuestion.add(mainLabel);

                        // for now, gathering image data from file. Will need to figure out import
                        File file5 = new File("sunday_afternoon.png");
                        String absPath = file5.getAbsolutePath();
                        ImageIcon image5 = new ImageIcon(absPath);
                        // need label to hold image
                        JLabel fifthImage = new JLabel();
                        // add image to panel by setting icon
                        fifthImage.setIcon(image5);
                        fifthQuestion.add(fifthImage);

                        // create four buttons for potential answers
                        JButton fifthQuestionButtonA = new JButton("A) Open-Impressionism");
                        fifthQuestionButtonA.setPreferredSize(new Dimension(width, height));
                        fifthQuestion.add(fifthQuestionButtonA);

                        JButton fifthQuestionButtonB = new JButton("B) Neo-Impressionism");
                        fifthQuestionButtonB.setPreferredSize(new Dimension(width, height));
                        fifthQuestion.add(fifthQuestionButtonB);

                        JButton fifthQuestionButtonC = new JButton("C) Not-Impressed");
                        fifthQuestionButtonC.setPreferredSize(new Dimension(width, height));
                        fifthQuestion.add(fifthQuestionButtonC);

                        JButton fifthQuestionButtonD = new JButton("D) Unimpressed");
                        fifthQuestionButtonD.setPreferredSize(new Dimension(width, height));
                        fifthQuestion.add(fifthQuestionButtonD);

                        mainFrame.add(fifthQuestion, BorderLayout.CENTER);

                        fifthQuestionButtonA.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent fiveqA) {
                                fifthQuestionButtonA.setBackground(Color.RED);
                                fifthQuestionButtonA.setEnabled(false);
                            }
                        });
                        fifthQuestionButtonC.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent fiveqC) {
                                fifthQuestionButtonC.setBackground(Color.RED);
                                fifthQuestionButtonC.setEnabled(false);
                            }
                        });
                        fifthQuestionButtonD.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent fiveqC) {
                                fifthQuestionButtonD.setBackground(Color.RED);
                                fifthQuestionButtonD.setEnabled(false);
                            }
                        });

                        fifthQuestionButtonB.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent fiveqB) {
                                fifthQuestion.setVisible(false);

                                // panel to summarize information about painting 
                                fifthQuestionSummary = new JPanel();
                                fifthQuestionSummary.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                                mainLabel = new JLabel("CORRECT");
                                Color correct = new Color(0, 153, 0);
                                mainLabel.setForeground(correct);
                    
                                JLabel fifthQuestionDescription = new JLabel();
                                fifthQuestionDescription = new JLabel("By painting'A Sunday Afternoon on the Island of La Grande Jatte', "
                                                                    + "Georges Seurat ushered in Neo-Impressionism in the 19th century.");

                                fifthQuestionSummary.add(mainLabel);
                                fifthQuestionSummary.add(fifthQuestionDescription);
                                fifthQuestionSummary.add(fifthImage);

                                JButton fifthQuestionContinue = new JButton("Continue");
                                fifthQuestionContinue.setPreferredSize(new Dimension(width, height));
                                fifthQuestionSummary.add(fifthQuestionContinue);
                                mainFrame.add(fifthQuestionSummary, BorderLayout.CENTER);

                        fifthQuestionContinue.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent fnl) {
                                fifthQuestionSummary.setVisible(false);

                                finalPanel = new JPanel();
                                finalPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

                                mainLabel = new JLabel("THE END!");
                                finalPanel.add(mainLabel);

                                mainFrame.add(finalPanel, BorderLayout.CENTER);
                            }
                        });
                            }
                        });
                    }
                });
                            }
                        });
                    }
                });

                            }
                        });
                        }
        
                    });
                }
                });  
            }         
            }
            );
                    
        }
        });             
    }
} 