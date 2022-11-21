// package src;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;

// import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarculaLaf;

public class gui{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton mainButton;
    private JLabel mainLabel;
    private JLabel extendedLabel;
    private JButton century17th;
    private JButton century18th;
    private JButton century19th;
    private JButton century20th;
    // set variables for standard button width and height
    private int width = 221;
    private int height = 25;

    String currentCentury = "";
    
    // counter for panel
    int COUNTER = 1;
    // counter for incorrect answers
    int INCORRECT_ANSWER = 0; 
    // array to hold specific information for each panel
    data newClassobj = new data();
    String[] centurySelected = newClassobj.getCentury();
    // 17th century data
    String[] header_17th = newClassobj.getHeaderArray17();
    String[] imageFile_17th = newClassobj.getImageArray17();
    String[] summaryField_17th = newClassobj.getSummaryArray17();
    String[] correctAnswer_17th = newClassobj.getCorrectAnswerArray17();
    String[][] questionArray_17th = newClassobj.getQuestionArray17();
    // 18th century data
    String[] header_18th = newClassobj.getHeaderArray18();
    String[] imageFile_18th = newClassobj.getImageArray18();
    String[] summaryField_18th = newClassobj.getSummaryArray18();
    String[] correctAnswer_18th = newClassobj.getCorrectAnswerArray18();
    String[][] questionArray_18th = newClassobj.getQuestionArray18();
    // 19th century data
    String[] header_19th = newClassobj.getHeaderArray19();
    String[] imageFile_19th = newClassobj.getImageArray19();
    String[] summaryField_19th = newClassobj.getSummaryArray19();
    String[] correctAnswer_19th = newClassobj.getCorrectAnswerArray19();
    String[][] questionArray_19th = newClassobj.getQuestionArray19();
    // 20th century data
    String[] header_20th = newClassobj.getHeaderArray20();
    String[] imageFile_20th = newClassobj.getImageArray20();
    String[] summaryField_20th = newClassobj.getSummaryArray20();
    String[] correctAnswer_20th = newClassobj.getCorrectAnswerArray20();
    String[][] questionArray_20th = newClassobj.getQuestionArray20();
    
    public gui(){
        // create main frame
        mainFrame = new JFrame();
        
        // button for starting the quiz
        mainButton = new JButton("Start Quiz");
        mainButton.setPreferredSize(new Dimension(width, height));
        mainButton.setEnabled(false);

        // label to show the user what they are using
        mainLabel = new JLabel("Test Your Art Knowledge (or lack thereof)!", SwingConstants.CENTER);
        extendedLabel = new JLabel("Select the century you want to be quizzed on:");
        mainLabel.putClientProperty("FlatLab.styleClass", "h1");
        mainLabel.putClientProperty( "FlatLaf.style", "font: bold $h1.font" );
        
        century17th = new JButton("17th Century");
        century17th.setPreferredSize(new Dimension(width, height));
        century18th = new JButton("18th Century");
        century18th.setPreferredSize(new Dimension(width, height));
        century19th = new JButton("19th Century");
        century19th.setPreferredSize(new Dimension(width, height));
        century20th = new JButton("20th Century");
        century20th.setPreferredSize(new Dimension(width, height));
        
        // each "page" will be a panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // need to add components into the panel 
        mainPanel.add(mainLabel);
        mainPanel.add(extendedLabel);
        mainPanel.add(century17th);
        mainPanel.add(century18th);
        mainPanel.add(century19th);
        mainPanel.add(century20th);
        mainPanel.add(mainButton);
        
        // add main panel to main frame
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        // application will close if exit is clicked
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setting frame title
        mainFrame.setTitle("Art Quiz");
        mainFrame.setSize(740,680);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

        century17th.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                currentCentury = centurySelected[0];
                setCenturyButtons(mainButton, century17th, century18th, century19th, century20th);
            }
        });
        century18th.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                currentCentury = centurySelected[1];
                setCenturyButtons(mainButton, century18th, century17th, century19th, century20th);
            }
        });
        century19th.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                currentCentury = centurySelected[2];
                setCenturyButtons(mainButton, century19th, century17th, century18th, century20th);
            }
        });
        century20th.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                currentCentury = centurySelected[3];
                setCenturyButtons(mainButton, century20th, century17th, century18th, century19th);
            }
        });

        // method to connect the first button to an action when clicked
        mainButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                // when mainButton is clicked, the mainPanel will be invisible
                mainPanel.setVisible(false);
                switch(currentCentury){
                    case "17th Century":
                    // call method to build question panel
                    buildQuestionPanel(header_17th[0], imageFile_17th[0], questionArray_17th[0], correctAnswer_17th[0], summaryField_17th[0], INCORRECT_ANSWER);
                    break;

                    case "18th Century":
                    buildQuestionPanel(header_18th[0], imageFile_18th[0], questionArray_18th[0], correctAnswer_18th[0], summaryField_18th[0], INCORRECT_ANSWER);
                    break;

                    case "19th Century":
                    buildQuestionPanel(header_19th[0], imageFile_19th[0], questionArray_19th[0], correctAnswer_19th[0], summaryField_19th[0], INCORRECT_ANSWER);
                    break;

                    case "20th Century":
                    buildQuestionPanel(header_20th[0], imageFile_20th[0], questionArray_20th[0], correctAnswer_20th[0], summaryField_20th[0], INCORRECT_ANSWER);
                    break;
                }
            }
        });

    }

    public void setCenturyButtons(JButton mainButton, JButton selection, JButton notSelected1, JButton notSelected2, JButton notSelected3){
        mainButton.setEnabled(true);
        selection.setBackground(Color.GREEN);
        notSelected1.setEnabled(false);
        notSelected2.setEnabled(false);
        notSelected3.setEnabled(false);
    };
    
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
                // TODO: Work around for using Flatlaf
                // Need to figure out how to use the Java AWT color class
                // wrong.putClientProperty(FlatClientProperties.STYLE, "Color(255,0,0)");
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
                    switch(currentCentury){
                        case "17th Century":
                        // call method to build question panel
                        buildQuestionPanel(header_17th[COUNTER], imageFile_17th[COUNTER], questionArray_17th[COUNTER], correctAnswer_17th[COUNTER], summaryField_17th[COUNTER], INCORRECT_ANSWER);
                        break;
    
                        case "18th Century":
                        buildQuestionPanel(header_18th[COUNTER], imageFile_18th[COUNTER], questionArray_18th[COUNTER], correctAnswer_18th[COUNTER], summaryField_18th[COUNTER], INCORRECT_ANSWER);
                        break;
    
                        case "19th Century":
                        buildQuestionPanel(header_19th[COUNTER], imageFile_19th[COUNTER], questionArray_19th[COUNTER], correctAnswer_19th[COUNTER], summaryField_19th[COUNTER], INCORRECT_ANSWER);
                        break;
    
                        case "20th Century":
                        buildQuestionPanel(header_20th[COUNTER], imageFile_20th[COUNTER], questionArray_20th[COUNTER], correctAnswer_20th[COUNTER], summaryField_20th[COUNTER], INCORRECT_ANSWER);
                        break;
                    }
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
        // FlatLaf needs to happen before we start working on the GUI
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        new gui();
    }
}