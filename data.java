public class data {
    private String[] header = {"Who is the artist of this painting?", "What country did this painting orginiate from?", "What century is depicted in this painting?", 
                        "What is the name of this very famous painting?", "This painting ushered in a new wave of Impressionism called..."};
    private String[] imageFile = {"monet_impression_sunrise.png", "great_wave_kanagawa.png", "dance_le_moulin.png", "starry_night.png", "sunday_afternoon.png"};
    private String[] summaryField = {"The 'Impression Sunrise' was painted by Claude Monet in 1872. This painting depicts the port of Le Havre which is Monet's hometown.",
                                            "'The Great Wave off Kanagawa' was painted in 1831 by Japanese artist Hokusai. Considered 'the most famous artwork in Japanese history.'",
                                            "In the 19th century, Pierre-Auguste Renoir painted 'Bal du moulin de la Galette'. Captures the escence of a Paris outing.",
                                            "Vincet van Gogh is arguabely one of the world's most famous aritsts. 'Starry Night' was painted in 1889.",
                                            "By painting'A Sunday Afternoon on the Island of La Grande Jatte', Georges Seurat ushered in Neo-Impressionism in the 19th century."};
    private String[] correctAnswer = {"Monet", "Japan", "19th Century", "Starry Night", "Neo-Impressionism"};
    private String[][] questionArray = {{"Monet", "Van Gough", "Taylor Swift", "Picaso"}, {"Philippines", "Sinagpore", "Japan", "Taiwan"}, 
                                                    {"17th Centry", "16th Century", "18th Century", "19th Century"}, {"Starry Night", "Star Night", "Moonlight", "Star at Night"},
                                                    {"Open-Impressionism", "Neo-Impressionism", "Not-Impressed", "Unimpressed"}};
    private String[] centurySelected = {"16th Century", "17th Century", "18th Century", "19th Century"};

    public String[] getHeaderArray() {
        return header.clone();
    }
    
    public String[] getImageArray() {
        return imageFile.clone();
    }

    public String[] getSummaryArray() {
        return summaryField.clone();
    }

    public String[] getCorrectAnswerArray() {
        return correctAnswer.clone();
    }

    public String[][] getQuestionArray() {
        return questionArray.clone();
    }

    public String[] getCentury() {
        return centurySelected.clone();
    }
}
