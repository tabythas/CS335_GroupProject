import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;

public class gui{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton mainButton;
    private JLabel mainLabel;
    // sent variables for standard button width and height
    private int width = 221;
    private int height = 25;
    // counter for panel
    int COUNTER = 1;
    // array to hold specific information for each panel
    String[] header = {"Who is the artist of this painting?", "What country did this painting orginiate from?", "What century is depicted in this painting?", 
                        "What is the name of this very famous painting?", "This painting ushered in a new wave of Impressionism called..."};
    String[] imageFile = {"monet_impression_sunrise.png", "great_wave_kanagawa.png", "dance_le_moulin.png", "starry_night.png", "sunday_afternoon.png"};
    String[] summaryField = {"The 'Impression Sunrise' was painted by Claude Monet in 1872. This painting depicts the port of Le Havre which is Monet's hometown.",
                        "'The Great Wave off Kanagawa' was painted in 1831 by Japanese artist Hokusai. Considered 'the most famous artwork in Japanese history.'",
                        "In the 19th century, Pierre-Auguste Renoir painted 'Bal du moulin de la Galette'. Captures the escence of a Paris outing.",
                        "Vincet van Gogh is arguabely one of the world's most famous aritsts. 'Starry Night' was painted in 1889.",
                        "By painting'A Sunday Afternoon on the Island of La Grande Jatte', Georges Seurat ushered in Neo-Impressionism in the 19th century."};
    String[] correctAnswer = {"Monet", "Japan", "19th Century", "Starry Night", "Neo-Impressionism"};
    String[][] questionArray = {{"Monet", "Van Gough", "Taylor Swift", "Picaso"}, {"Philippines", "Sinagpore", "Japan", "Taiwan"}, 
                                {"17th Centry", "16th Century", "18th Century", "19th Century"}, {"Starry Night", "Star Night", "Moonlight", "Star at Night"},
                                {"Open-Impressionism", "Neo-Impressionism", "Not-Impressed", "Unimpressed"}};

    public gui(){
        // create main frame
        mainFrame = new JFrame();
        
        // button for starting the quiz
        mainButton = new JButton("Start Quiz");

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

        // method to connect the first button to an action when clicked
        mainButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                // when mainButton is clicked, the mainPanel will be invisible
                mainPanel.setVisible(false);
                // call method to build question panel
                buildQuestionPanel(header[0], imageFile[0], questionArray[0], correctAnswer[0], summaryField[0]);
            }
        });

    }
    // this method builds question panel
    void buildQuestionPanel(String label, String fileName, String[] questionArray, String correct, String summary){
        JPanel panel = new JPanel();
        JLabel mainLabel = new JLabel(label);
        JLabel imageLabel = new JLabel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.add(mainLabel);
        
        File file = new File(fileName);
        String absPath = file.getAbsolutePath();
        ImageIcon image = new ImageIcon(absPath);
        imageLabel.setIcon(image);
        panel.add(imageLabel);
        // loop through array of options
        for (int i = 0; i <questionArray.length; i++){
            // is option is the correct answer, build summary panel
            if (questionArray[i] == correct){
                JButton correctAnswer = new JButton(correct);
                correctAnswer.setPreferredSize(new Dimension(width, height));
                panel.add(correctAnswer);
                correctAnswer.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent correctAnswer) {
                        panel.setVisible(false);
                        buildSummaryPanel(summary, imageLabel);
                    }
                });
            }
            // for each incorrect option, call wrong Button method
            else {
                JButton option = new JButton(questionArray[i]);
                option.setPreferredSize(new Dimension(width, height));
                panel.add(option);
                wrongButton(option);
            }
        }
        mainFrame.add(panel, BorderLayout.CENTER);
    }
    // button turns red and is disabled
    void wrongButton(JButton wrong){
        wrong.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent wrongAnswer) {
                wrong.setBackground(Color.RED);
                wrong.setEnabled(false);
            }
        });
    }
    // summary panel to be shown once correct option is clicked
    void buildSummaryPanel(String summary, JLabel image){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(summary);
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        JLabel correctAnswerLabel = new JLabel("CORRECT!");
        Color correctColor = new Color(0, 153, 0);
        correctAnswerLabel.setForeground(correctColor);
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(width, height));
        panel.add(correctAnswerLabel);
        panel.add(label);
        panel.add(image);
        panel.add(continueButton);
        mainFrame.add(panel, BorderLayout.CENTER);
        
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent continueButton) {
                panel.setVisible(false);
                // build final page once all summary panels have been shown
                if (COUNTER == 5){
                    buildResultsPage();
                }
                else{
                    buildQuestionPanel(header[COUNTER], imageFile[COUNTER], questionArray[COUNTER], correctAnswer[COUNTER], summaryField[COUNTER]);
                    COUNTER += 1;
                }
            }
        });
        
    }
    // placeholder to show we have reached the end
    // will turn into results page 
    void buildResultsPage(){
        JPanel panel = new JPanel();
        JLabel label = new JLabel("THE END!!!!");
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.add(label);
        mainFrame.add(panel, BorderLayout.CENTER);
    }
    
    // main method to call and build application
    public static void main(String[] args){
        new gui();
    }
}