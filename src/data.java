public class data {
    private String[] centurySelected = {"17th Century", "18th Century", "19th Century", "20th Century"};

    // 17th century setters
    private String[] header_17th = {"The Supper at Emmaus (1601) is a Baroque painting by...", "This prayer book shows the Virgin Mary. It is from the country...", "The controversial paiting, The Night Watch (1642), is a painting by...", 
                        "Vermeer's painting Girl with a Pearl Earring is an example of...", "This painting by Vermeer's Baroque (1657) is called..."};
    private String[] imageFile_17th = {"17th_century/supper_at_emmaus.png", "17th_century/virgin_mary.png", "17th_century/night_watch.png", "17th_century/girl_pearl.png", "17th_century/vermeer_baroque.png"};
    private String[] correctAnswer_17th = {"Caravaggio", "Ethiopia", "Rembrandt", "Baroque", "The Milkmaid"};
    private String[][] questionArray_17th = {{"Rembrandt", "Caravaggio", "Aleijadinho", "Velazquez"}, {"Ethiopia", "Lithuania", "Britain", "Guam"}, 
                                                    {"Willem van Tuytenburch", "Frans Bannick Cocq", "Rubens", "Rembrandt"}, {"Impressionism", "Renaissance", "Realism", "Baroque"},
                                                    {"Woman Holding a Jug", "The Farmhand", "The Milkmaid", "Lady Setting the Table"}};

    // 18th century setters
    private String[] header_18th = {"The Blue Boy (1770) by Thomas Gainsborough is an example of...", "The Lake of Albano and Castel Gandolfo (1783) is a landscape painting that depicts a lake in...", "Marie Antoinette and Her Children (1787) is an oil painting by...", 
                        "The Defeat of the Floating Batteries at Gibraltar, September 1782 (1791) is a painting by...", "Watson and the Shark (1778) by John Singleton Copley is an example of..."};
    private String[] imageFile_18th = {"18th_century/blue_boy.png", "18th_century/lake_albano.png", "18th_century/marie_antoinette.png", "18th_century/defeat_batteries.png", "18th_century/watson_shark.png"};
    private String[] correctAnswer_18th = {"Rococo", "Italy", "Elisabeth Vigee Le Brun", "John Singleton Copley", "Romanticism"};
    private String[][] questionArray_18th = {{"Realism", "Impressionism", "Rococo", "Romanticism"}, {"Romania", "Spain", "Portugal", "Italy"}, 
                                                    {"Charles d'Agar", "Pierre Allais", "Elisabeth Vigee Le Brun", "Marie Victoire"}, {"Thomas Sully", "John Singleton Copley", "Henry Benbridge", "Charles Wilson Peale"},
                                                    {"Romanticism", "Realism", "Neoclassicalism", "Post-impressionism"}};
    
    // 19th century setters
    private String[] header_19th = {"This impressionist painting (1875-1876) is by Edgar Degas and is called...", "The Balloon (1886) is a painting by French artist...", "Theodore Gericault painted this horrifying scene of cannibalism, which is called...", 
                        "The Gleaners is an oil painting (1857) depiciting lower French class by...", "Bridge over a Pond of Water Lilies (1899) is a oil painting by..."};
    private String[] imageFile_19th = {"19th_century/labsinthe.png", "19th_century/the_balloon.png", "19th_century/raft_medusa.png", "19th_century/gleaners.png", "19th_century/pond_waterlilies.png"};
    private String[] correctAnswer_19th = {"L'Absinthe", "Julien Dupre", "The Raft of the Medusa", "Jean-Francois Millet", "Claude Monet"};
    private String[][] questionArray_19th = {{"La Tasse à Café Homm", "L'Absent", "Juste un Verre", "L'Absinthe"}, {"Pierre-Auguste Renoir", "Edgar Degas", "Paul Cezanne", "Julien Dupre"}, 
                                                    {"Of Meat and Bones", "Saturn Devouring His Son", "The Wreck of the Lost", "The Raft of the Medusa"}, {"Valerio Adami", "Edouard Manet", "Paul Gauguin", "Jean-Francois Millet"},
                                                    {"Edouard Manet", "Arthur Melville", "Claude Lorrain", "Claude Monet"}};
    
    // 20th century setters
    private String[] header_20th = {"Man with a Guitar (1912) by George Braque is an example of...", "Auguste Rodin sculpted this dynamic headless figure in 1907. The title of the sculpture is...", "Meret Oppenheim's Object (Le Dejeuner en fourrure) is an example of... ", 
                        "Marcel Duchamp made the Bicycle Wheel (1951). This was the first of Duchamp's series called...", "Woman I (1952) is part of a series of abstract, grotesque female forms done by the artist..."};
    private String[] imageFile_20th = {"20th_century/man_guitar.png", "20th_century/walking_man.png", "20th_century/oppenheim_object.png", "20th_century/bicycle_wheel.png", "20th_century/woman.png"};
    private String[] correctAnswer_20th = {"Cubism", "The Walking Man", "Surrealism", "Readymades", "Willem de Kooning"};
    private String[][] questionArray_20th = {{"Cubism", "Futurism", "Neoclassical", "Surrealism"}, {"The Walking Man", "The Thinker", "Man", "Headless god"}, 
                                                    {"Dada", "Futurism", "Postmodern", "Surrealism"}, {"Combinatoric", "Readymades", "Modern material", "Mobiles"},
                                                    {"Pablo Picasso", "Pablo Neruda", "Willem de Kooning", "Adolf Ulrik Wertmuller"}};
    
    public String[] getCentury() {
        return centurySelected.clone();
    }
    
    // 17th century getters
    public String[] getHeaderArray17() {
        return header_17th.clone();
    }
    public String[] getImageArray17() {
        return imageFile_17th.clone();
    }
    public String[] getCorrectAnswerArray17() {
        return correctAnswer_17th.clone();
    }
    public String[][] getQuestionArray17() {
        return questionArray_17th.clone();
    }

    // 18th century getters
    public String[] getHeaderArray18() {
        return header_18th.clone();
    }
    public String[] getImageArray18() {
        return imageFile_18th.clone();
    }
    public String[] getCorrectAnswerArray18() {
        return correctAnswer_18th.clone();
    }
    public String[][] getQuestionArray18() {
        return questionArray_18th.clone();
    }

    // 19th century getters
    public String[] getHeaderArray19() {
        return header_19th.clone();
    }
    public String[] getImageArray19() {
        return imageFile_19th.clone();
    }
    public String[] getCorrectAnswerArray19() {
        return correctAnswer_19th.clone();
    }
    public String[][] getQuestionArray19() {
        return questionArray_19th.clone();
    }

    // 20th century getters
    public String[] getHeaderArray20() {
        return header_20th.clone();
    }
    public String[] getImageArray20() {
        return imageFile_20th.clone();
    }
    public String[] getCorrectAnswerArray20() {
        return correctAnswer_20th.clone();
    }
    public String[][] getQuestionArray20() {
        return questionArray_20th.clone();
    }

}
