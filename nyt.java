import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class nyt implements ActionListener{
    final String BG_GREEN = "\u001b[42m";
    final String BG_YELLOW = "\u001b[43m";
    final String RESET = "\u001b[0m";
    JFrame window = new JFrame("CONNECTIONS");
    JFrame game1 = new JFrame("WORDLE");
    JButton resetButton = new JButton("ENTER");

    JButton[][] board = new JButton[4][4];
    JButton[][] word = new JButton[6][5];
    static JFrame f;
    static JFrame e;

    public static void main(String[] args) {

        new nyt();
/*        f = new JFrame("YOU WON");
        e = new JFrame("YOU WON");

        JPanel p = new JPanel();

        JButton b = new JButton("CONGRATS");

        p.add(b);

        f.add(p);
        e.add(p);

        // set the size of frame
        f.setSize(400, 400);
        e.setSize(400, 400);*/
    }
    public nyt(){
        window.setLayout(new BorderLayout());
        window.setSize(800, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game1.setLayout(new BorderLayout());
        game1.setSize(800, 800);
        game1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container resetContainer = new Container();
        Container boardContainer = new Container();
        resetContainer.setLayout(new GridLayout(1, 1));
        boardContainer.setLayout(new GridLayout(4, 4));

        Container enterContainer = new Container();
        Container wordContainer = new Container();
        enterContainer.setLayout(new GridLayout(1, 1));
        wordContainer.setLayout(new GridLayout(6, 5));

        resetButton.addActionListener(this);
        resetContainer.add(resetButton);



        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = new JButton();
                board[row][col].addActionListener(this);
                boardContainer.add(board[row][col]);

            }
        }
        for (int row = 0; row < word.length; row++) {
            for (int col = 0; col < word[0].length; col++) {
                word[row][col] = new JButton();
                word[row][col].addActionListener(this);
                wordContainer.add(word[row][col]);

            }
        }
        window.add(resetContainer, BorderLayout.NORTH);
        window.add(boardContainer, BorderLayout.CENTER);


        game1.add(wordContainer, BorderLayout.CENTER);


        System.out.println("Welcome to the NYT mini games! Select from the eligible games listed to get started.");
        System.out.println("Which game would you like to play? (1 or 2)");
        System.out.println("1. WORDLE");
        System.out.println("2. SPELLING BEE");
        System.out.println("3. CONNECTIONS");
        Scanner stringScanner = new Scanner(System.in);
        String bla = stringScanner.next();
        if(bla.equals("1")){

            game1.setVisible(true);
            wordle();

        }
        if(bla.equals("2")){
            spellingBee();
        }
        if(bla.equals("3")){
            window.setVisible(true);
            connections();
        }


    }
    String[] words = {"ABOUT", "ALERT", "ARGUE", "BEACH", "ACTOR", "ALLOW", "ASIDE", "BEGUN",
            "ADULT", "AMONG", "AVOID", "BILLY", "AGREE", "APART", "BAKER", "BLIND",
            "BOOST", "BUYER", "CHINA", "COVER", "BRAND", "CATCH", "CLASS", "CRIME",
            "BRING", "CHASE", "CLOSE", "CYCLE", "BUILD", "CHEIF", "COUNT", "DEALT",
            "DEPTH", "ERROR", "FORUM", "GUARD", "DOZEN", "EXACT", "FRANK", "GUIDE",
            "DREAM", "FALSE", "FRUIT", "HEAVY", "DRIVE", "FIFTH", "GIVEN", "HOTEL",
            "EARLY", "FIRST", "GRACE", "IMAGE", "EMPTY", "FLOOR", "GRASS", "ISSUE",
            "JUDGE", "METAL", "MEDIA", "NEWLY", "LASER", "LOWER", "MIXED", "NOVEl",
            "LEARN", "MAGIC", "MORAL", "OFFER", "LEGAL", "MUSIC", "MOUTH", "OUGHT",
            "PEACE", "POWER", "RADIO", "ROUND", "PHOTO", "PRIME", "RATIO", "SCALE",
            "PLACE", "PROOF", "RIGHT", "SENSE", "PLATE", "SIXTH", "STAND", "SHAPE",
            "SHELF", "SPEAK", "SUGAR", "TIRED", "SHOCK", "SPLIT", "TABLE", "TOTAL",
            "SIGHT", "STAGE", "TEACH", "TRACK", "SKILL", "STEAM", "THEFT", "TRIAL",
            "SMART", "THESE", "TIMER", "TRULY", "SOLID", "STORM", "THIRD", "UNDER",
            "SOUTH", "STUDY", "THROW", "UNTIL", "USAGE", "WOMAN", "WATER", "WRONG",
            "VIDEO", "WORSE", "WHILE", "YOUTH"};
    int y = (int) (Math.random() * words.length);
    String correct = words[y];
    Scanner sc = new Scanner(System.in);
    String guess = "";

    public void wordle() {

        System.out.println("WORDLE!");
        for(int a = 0; a <6; a++) {
            System.out.print("Please guess: ");

                    guess = sc.nextLine().toUpperCase();

            for (int i = 0; i < 5; i++) {

                if (guess.substring(i, i + 1).equals(correct.substring(i, i + 1))) {
                    word[numb][i].setText(guess.substring(i, i + 1));
                    word[numb][i].setBackground(Color.GREEN);
                    word[numb][i].setOpaque(true);
                    word[numb][i].setEnabled(false);



                } else if (correct.indexOf(guess.substring(i, i + 1)) > -1) {
                    word[numb][i].setText(guess.substring(i, i + 1));
                    word[numb][i].setBackground(Color.YELLOW);
                    word[numb][i].setOpaque(true);
                    word[numb][i].setEnabled(false);

                } else {
                    word[numb][i].setText(guess.substring(i, i + 1));
                    word[numb][i].setOpaque(true);
                    word[numb][i].setEnabled(false);

                }

            }
            numb++;

            System.out.println("");
            if(guess.equals(correct)){
                System.out.println("Correct! You win!");
                break;
            }

        }
        if(!guess.equals(correct)){
            System.out.println("Wrong! The correct word is " + correct + ".");
        }

    }

    public void spellingBee(){

        System.out.println("To play the Spelling Bee you need to type words MORE than THREE ");
        System.out.println("letters long. WORDS MUST INCLUDE HIGHLIGHTED LETTER. The ");
        System.out.println("longer the word, the more points you'll get. If you ever wish to ");
        System.out.println("exit the game simply type 'quit'. Good Luck!");
        ArrayList<Puzzle> game= new ArrayList<Puzzle>();
        int score = 0;
        Puzzle one = new Puzzle("F A B E I L N", new String[]{"AFFABLE", "ALFALFA", "BAFFLE", "BAILIFF", "BEEF",
                "BEFALL", "BEFALLEN", "BEFELL", "BELIEF", "BIFF", "ELFIN", "ENFEEBLE", "FABLE", "FAIL", "FALAFEL",
                "FALL", "FALLEN", "FALLIBLE", "FEEBLE", "FEEL", "FELINE", "FELL", "FELLA", "FENNEL", "FIEF", "FIFE",
                "FILE", "FILIAL", "FILL", "FILLABLE", "FINAL", "FINALE", "FINE","FINIAL","FLAB", "FLAIL", "FLAN",
                "FLANNEL", "FLEA", "FLEE", "INEFFABLE", "INFALLIBLE", "INFILL","LEAF","LIFE","LIFELINE","NAIF"});
        Puzzle two = new Puzzle("R G N O P U W", new String[]{"GORGON", "GORP", "GROG", "GROUP", "GROW", "GROWN",
                "GROWNUP", "GURU", "POOR", "PORN", "PORNO", "POUR", "PRONG", "PRONOUN", "PROP", "PROW", "PURR", "RUNG",
                "UNGROUP", "UNWORN", "WORN", "WRONG", "WRUNG"});
        game.add(one);
        game.add(two);
        Puzzle three = new Puzzle("H A E L N P T", new String[]{"ALEPH", "ALPHA", "ATHLETE", "ELEPHANT", "ETHANE",
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", });
        String[] letters = { "G A C E N O T", "I A D L M O R",
                "L B E N O T V", "N C D E K T U", "C A I N R T Y", "R A H T U W Y", "F D E I L P U", "M A D L N T Y" ,
                "O F C I M N R", "T D E G I L U", "U B E D H L M", "C H I M N O P", "O A E G H L N", "A C E I N T Y" ,
                "O A B E L M Z", "F C D E I N O", "O D G H I L R", "R A B D L O Y", "T D E G H L N", "I A C H L R V" ,
                "I A G J M N U", "F A C I L R Y", "B A C E I L P", "V E G I L N O", "N C I M O T U", "E A C D T V X" ,
                "O B F G L R U", "D A I M N O T", "L A D I T V Y", "E F K L M N O", "I F G H L T Y", "B A C D E N U" ,
                "R A D K L O W", "O C G I N U V", "G A I L O R T", "D A B I L O R", "N D E I P U Z", "C A B K M O R"};
        int y = (int)(Math.random()*game.size());
        String guess = "";
        while(game.get(y).getArray().length> 0 && !guess.equals("QUIT")){
            System.out.println(BG_YELLOW + game.get(y).getLetters().substring(0,1)+ RESET + game.get(y).getLetters().substring(1));
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your word: ");
            guess = sc.nextLine().toUpperCase();
            ArrayList<String> guesser= new ArrayList<String>();
            int a = 0;
            int b = 0;
            for(int i = 0; i<game.get(y).getArray().length;i++) {
                if (guess.equals(game.get(y).getArray()[i])&& !guesser.contains(guess)) {
                    a=1;
                    b = i;

                }
            }
            if(a==1){
                score = score + game.get(y).getArray()[b].length();
                System.out.println("+" + game.get(y).getArray()[b].length());
                System.out.println("Total: " + score);
            }
            if(guesser.contains(guess)){
                System.out.println("Word has already been used. Try again.");
            }
            if(a==0 && !guesser.contains(guess) && !guess.equals("QUIT")){
                System.out.println("Not an eligible word. Try again.");
            }
            if(guess.equals("QUIT")){
                System.out.println("Better luck next time!");
            }
            guesser.add(guess);
            if(guesser.size() == game.get(y).getArray().length){
                System.out.println("You have found all the possible words!");
            }
        }

    }
    String[][] nums = new String[4][4];
    //int num = (int) (Math.random()*4)+2;
    int num = 1;
    String[][] one = {{"COLLAPSE", "WAVE", "SEA", "GIVE"},
            {"CAVE", "DANCE", "FLOP", "MASS"},
            {"BUCKLE", "SNAP", "WHISTLE", "TON"}
            ,         {"BUTTON", "SHOUT","SLEW", "LAUGH"}};
    String fall = "BUCKLECAVECOLLAPSEGIVE";
    String attention = "SHOUTSNAPWAVEWHISTLE";
    String amount = "MASSSEASLEWTON";
    String belly = "BUTTONDANCEFLOPLAUGH";
    String[][] two = {
            {" JELLY BEAN ", " LOUNGE ", " FELLOW ", " BUNNY "},
            {" PEER ", " PARTNER ", " LIBRARY ", " EGG "},
            {" SPY ", " HALL ", " PEEP ", " BIRTHMARK "},
            {" ASSOCIATE ", " STUDY "," ANIMAL ", " UNIT "}};
    String easter = "BUNNYEGGJELLY BEANPEEP";
    String pal = "ASSOCIATEFELLOWPARTNERPEER";
    String clue = "HALLLIBRARYLOUNGESTUDY";
    String mole = "ANIMALBIRTHMARKSPYUNIT";
    String[][] three = {
            {" CHANNEL ", " OUTSIDE ", " VEHICLE ", " STYLES "},
            {" LARGE ", " SWIFT ", " MEDIUM ", " GRANDE "},
            {" MARS ", " REMOTE ", " LEGEND ", " SLIM "},
            {" MEANS ", " ROOM "," PROOF ", " SMALL "}};

    String[][] four = {{" COMPLAINT ", " WINDSOCK ", " CLAIM ", " RUNWAY "}, {" FOXGLOVE ", " HANGAR ", " TURNCOAT ", " LAWSUIT "}, {" RING ", " ACTION ",
            "TORCH", "CLUB"}, {"BEANBAG", "GUMSHOE","TARMAC", "TERMINAL"}};
    String[][] five = {{"TOE", "PIPE", "COLLECTIVE", "DRAIN"}, {"LUCID", "CIGARETTE", "TICKET", "MUTUAL"}, {"CLEAR", "FEVER",
            "EMPTY", "FLUSH"}, {"PENCIL", "AMERICAN","JOINT", "COMMON"}};
    public void connections(){

        int row = 4;
        int col = 4;

        for(int x= 0; x<row; x++){
            for(int y = 0; y<col; y++)
                if(num == 1){
                    board[x][y].setText(one[x][y]);

                }
                else if(num == 2){
                    board[x][y].setText(two[x][y]);

                }
                else if(num == 3){
                    board[x][y].setText(three[x][y]);

                }
                else if(num == 4){
                    board[x][y].setText(four[x][y]);

                }
                else if(num == 5){
                    board[x][y].setText(five[x][y]);

                }
            System.out.println();
        }

    }
    int count = 0;
    int n = -1;
    int w = 0;
    int numb = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {

                    if (e.getSource().equals(board[row][col]) && count < 4) {

                        board[row][col].setEnabled(false);
                        count++;

                    }


                }
            }
            if (e.getSource() == resetButton) {
                ArrayList<String> q = new ArrayList<String>();
                if (num == 1) {
                    for (int y = w; y < board.length; y++) {
                        for (int x = 0; x < board[0].length; x++) {
                            if (!board[y][x].isEnabled()) {
                                q.add(board[y][x].getText());
                            }
                        }
                    }
                    System.out.println(q);

                    if (amount.contains(q.get(0)) && amount.contains(q.get(1)) && amount.contains(q.get(2)) && amount.contains(q.get(3))) {
                        n = 2;
                    }
                    if (belly.contains(q.get(0)) && belly.contains(q.get(1)) && belly.contains(q.get(2)) && belly.contains(q.get(3))) {
                        n = 3;
                    }
                    if (attention.contains(q.get(0)) && attention.contains(q.get(1)) && attention.contains(q.get(2)) && attention.contains(q.get(3))) {
                        n = 1;
                    }
                    if (fall.contains(q.get(0)) && fall.contains(q.get(1)) && fall.contains(q.get(2)) && fall.contains(q.get(3))) {
                        n = 0;
                    }
                }
                if(num == 2){
                    for (int y = w; y < board.length; y++) {
                        for (int x = 0; x < board[0].length; x++) {
                            if (!board[y][x].isEnabled()) {
                                q.add(board[y][x].getText());
                            }
                        }
                    }
                    System.out.println(q);

                    if (mole.contains(q.get(0)) && mole.contains(q.get(1)) && mole.contains(q.get(2)) && mole.contains(q.get(3))) {
                        n = 3;
                    }
                    if (pal.contains(q.get(0)) && pal.contains(q.get(1)) && pal.contains(q.get(2)) && pal.contains(q.get(3))) {
                        n = 1;
                    }
                    if (easter.contains(q.get(0)) && easter.contains(q.get(1)) && easter.contains(q.get(2)) && easter.contains(q.get(3))) {
                        n = 2;
                    }
                    if (clue.contains(q.get(0)) && clue.contains(q.get(1)) && clue.contains(q.get(2)) && clue.contains(q.get(3))) {
                        n = 0;
                    }
                }
                System.out.println(n);
                if (n == 0) {
                    int g = 0;
                    for (int row = w; row < board.length; row++) {
                        for (int col = 0; col < board[0].length; col++) {
                            if (!board[row][col].isEnabled()) {
                                board[row][col].setEnabled(true);
                                String j = board[w][g].getText();
                                String h = board[row][col].getText();
                                board[row][col].setText(j);
                                board[w][g].setText(h);
                                g++;
                            }

                        }
                    }
                    for (int r = 0; r < 4; r++) {
                        board[w][r].setBackground(Color.GREEN);
                        board[w][r].setOpaque(true);
                        board[w][r].setEnabled(false);
                    }
                    w++;


                } else if (n == 1) {
                    int g = 0;
                    for (int row = w; row < board.length; row++) {
                        for (int col = 0; col < board[0].length; col++) {
                            if (!board[row][col].isEnabled()) {
                                board[row][col].setEnabled(true);
                                String h = board[row][col].getText();
                                String j = board[w][g].getText();
                                board[w][g].setText(h);
                                board[row][col].setText(j);
                                g++;
                            }

                        }
                    }
                    for (int c = 0; c < 4; c++) {
                        board[w][c].setBackground(Color.BLUE);
                        board[w][c].setOpaque(true);
                        board[w][c].setEnabled(false);
                    }
                    w++;


                } else if (n == 2) {
                    int g = 0;
                    for (int row = w; row < board.length; row++) {
                        for (int col = 0; col < board[0].length; col++) {
                            if (!board[row][col].isEnabled()) {
                                board[row][col].setEnabled(true);
                                String h = board[row][col].getText();
                                String j = board[w][g].getText();
                                board[w][g].setText(h);
                                board[row][col].setText(j);
                                g++;
                            }

                        }
                    }
                    for (int c = 0; c < 4; c++) {
                        board[w][c].setBackground(Color.YELLOW);
                        board[w][c].setOpaque(true);
                        board[w][c].setEnabled(false);
                    }
                    w++;


                } else if (n == 3) {
                    int g = 0;
                    for (int row = w; row < board.length; row++) {
                        for (int col = 0; col < board[0].length; col++) {
                            if (!board[row][col].isEnabled()) {
                                board[row][col].setEnabled(true);
                                String h = board[row][col].getText();
                                String j = board[w][g].getText();
                                board[w][g].setText(h);
                                board[row][col].setText(j);
                                g++;
                            }

                        }
                    }
                    for (int c = 0; c < 4; c++) {
                        board[w][c].setBackground(new Color(200, 0, 200));
                        board[w][c].setOpaque(true);
                        board[w][c].setEnabled(false);
                    }
                    w++;

                } else {
                    for (int row = 0; row < board.length; row++) {
                        for (int col = 0; col < board[0].length; col++) {
                            if (!board[row][col].isEnabled()) {
                                board[row][col].setEnabled(true);
                            }
                        }
                    }

                }


                count = 0;
            }
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (!board[row][col].isEnabled()) {
                        y++;
                        if (y == 16) {
                            f.show();
                        }
                    }

                }


            }

        }
    }




