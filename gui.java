import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;

public class gui{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton mainButton;
    private JLabel mainLabel;
    private JLabel extendedLabel;
    private JButton century16th;
    private JButton century17th;
    private JButton century18th;
    private JButton century19th;
    // sent variables for standard button width and height
    private int width = 221;
    private int height = 25;
    
    String[] centurySelected = {"16th Century", "17th Century", "18th Century", "19th Century"};
    String currentCentury = "";
    
    // counter for panel
    int COUNTER = 1;
    // counter for incorrect answers
    int INCORRECT_ANSWER = 0; 
    // array to hold specific information for each panel
    data newClassobj = new data();
    String[] header = newClassobj.getHeaderArray();
    String[] imageFile = newClassobj.getImageArray();
    String[] summaryField = newClassobj.getSummaryArray();
    String[] correctAnswer = newClassobj.getCorrectAnswerArray();
    String[][] questionArray = newClassobj.getQuestionArray();
    
    public gui(){
        // create main frame
        mainFrame = new JFrame();
        
        // button for starting the quiz
        mainButton = new JButton("Start Quiz");
        mainButton.setPreferredSize(new Dimension(width, height));
        mainButton.setEnabled(false);

        // label to show the user what they are using
        mainLabel = new JLabel("Test Your Art Knowledge (or lack thereof)!");
        extendedLabel = new JLabel("Select the century you want to be quizzed on:");
        
        century16th = new JButton("16th Century");
        century16th.setPreferredSize(new Dimension(width, height));
        century17th = new JButton("17th Century");
        century17th.setPreferredSize(new Dimension(width, height));
        century18th = new JButton("18th Century");
        century18th.setPreferredSize(new Dimension(width, height));
        century19th = new JButton("19th Century");
        century19th.setPreferredSize(new Dimension(width, height));
        
        // each "page" will be a panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // need to add components into the panel 
        mainPanel.add(mainLabel);
        mainPanel.add(extendedLabel);
        mainPanel.add(century16th);
        mainPanel.add(century17th);
        mainPanel.add(century18th);
        mainPanel.add(century19th);
        mainPanel.add(mainButton);
        
        // add main panel to main frame
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        // application will close if exit is clicked
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setting frame title
        mainFrame.setTitle("Art Quiz");
        mainFrame.setSize(850,650);
        mainFrame.setVisible(true);

        century16th.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                currentCentury = centurySelected[0];
                mainButton.setEnabled(true);
                century16th.setBackground(Color.GREEN);
                century17th.setEnabled(false);
                century18th.setEnabled(false);
                century19th.setEnabled(false);
            }
        });
        century17th.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                currentCentury = centurySelected[1];
                mainButton.setEnabled(true);
                century17th.setBackground(Color.GREEN);
                century16th.setEnabled(false);
                century18th.setEnabled(false);
                century19th.setEnabled(false);
            }
        });
        century18th.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                currentCentury = centurySelected[2];
                mainButton.setEnabled(true);
                century18th.setBackground(Color.GREEN);
                century16th.setEnabled(false);
                century17th.setEnabled(false);
                century19th.setEnabled(false);
            }
        });
        century19th.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                currentCentury = centurySelected[3];
                mainButton.setEnabled(true);
                century19th.setBackground(Color.GREEN);
                century16th.setEnabled(false);
                century17th.setEnabled(false);
                century18th.setEnabled(false);
            }
        });

        // method to connect the first button to an action when clicked
        mainButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                // when mainButton is clicked, the mainPanel will be invisible
                mainPanel.setVisible(false);
                switch(currentCentury){
                    case "16th Century":
                    // call method to build question panel
                    buildQuestionPanel(header[0], imageFile[0], questionArray[0], correctAnswer[0], summaryField[0], INCORRECT_ANSWER);
                    break;

                    case "17th Century":
                    break;

                    case "18th Century":
                    break;

                    case "19th Century":
                    break;
                }
            }
        });

    }
    // this method builds question panel
    public void buildQuestionPanel(String label, String fileName, String[] questionArray, String correct, String summary, int INCORRECT_ANSWER){
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
            // if option is the correct answer, build summary panel
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
                INCORRECT_ANSWER += 1;
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
                    buildQuestionPanel(header[COUNTER], imageFile[COUNTER], questionArray[COUNTER], correctAnswer[COUNTER], summaryField[COUNTER], INCORRECT_ANSWER);
                    COUNTER += 1;
                }
            }
        });
        
    }
    // placeholder to show we have reached the end
    // will turn into results page 
    void buildResultsPage(){
        JPanel panel = new JPanel();
        JLabel label = new JLabel("You selected " + INCORRECT_ANSWER + " incorrect answers!");
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.add(label);
        mainFrame.add(panel, BorderLayout.CENTER);
    }
    
    // main method to call and build application
    public static void main(String[] args){
        new gui();
    }
}