import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nyt implements ActionListener{
     JTextField t;
     JTextField g2;
     JButton b;
     JButton tw;
    Container betaContainer = new Container();

    // create a new frame to store text field and button

    final String BG_GREEN = "\u001b[42m";
    final String BG_YELLOW = "\u001b[43m";
    final String RESET = "\u001b[0m";
    JFrame window = new JFrame("CONNECTIONS");
    JFrame game1 = new JFrame("WORDLE");
    JFrame game2 = new JFrame("SPELLING BEE");
    JFrame begin = new JFrame("NYT MINI GAMES");
    JButton resetButton = new JButton("ENTER");
    JButton[][] bee;
    JButton[][] board = new JButton[4][4];
    JButton[][] word = new JButton[6][5];
    JButton[][] mini = new JButton[3][1];

    public static void main(String[] args) {
        // create a label to display text


        new nyt();
/*      f = new JFrame("YOU WON");
        e = new JFrame("YOU WON");

        JPanel p = new JPanel();

        JButton b = new JButton("CONGRATS");

        p.add(b);

        f.add(p);
        e.add(b);

        // set the size of frame
        f.setSize(400, 400);
        e.setSize(400, 400);*/

    }
    ArrayList<Puzzle> game= new ArrayList<Puzzle>();
    int score = 0;
    public nyt(){

        Puzzle uno = new Puzzle("F A B E I L N", new String[]
                {"AFFABLE", "ALFALFA", "BAFFLE", "BAILIFF", "BEEF",
                        "BEFALL", "BEFALLEN", "BEFELL", "BELIEF", "BIFF", "ELFIN", "ENFEEBLE", "FABLE", "FAIL", "FALAFEL",
                        "FALL", "FALLEN", "FALLIBLE", "FEEBLE", "FEEL", "FELINE", "FELL", "FELLA", "FENNEL", "FIEF", "FIFE",
                        "FILE", "FILIAL", "FILL", "FILLABLE", "FINAL", "FINALE", "FINE","FINIAL","FLAB", "FLAIL", "FLAN",
                        "FLANNEL", "FLEA", "FLEE", "INEFFABLE", "INFALLIBLE", "INFILL","LEAF","LIFE","LIFELINE","NAIF"});
        Puzzle dos = new Puzzle("R G N O P U W", new String[]{"GORGON", "GORP", "GROG", "GROUP", "GROW", "GROWN",
                "GROWNUP", "GURU", "POOR", "PORN", "PORNO", "POUR", "PRONG", "PRONOUN", "PROP", "PROW", "PURR", "RUNG",
                "UNGROUP", "UNWORN", "WORN", "WRONG", "WRUNG"});


        game.add(uno);
        game.add(dos);


        b = new JButton("submit");

        b.addActionListener(this);

        t = new JTextField(16);
        Container gamaContainer = new Container();
        gamaContainer.setLayout(new GridLayout(1, 2));

        gamaContainer.add(t);
        gamaContainer.add(b);

        tw = new JButton("enter");

        tw.addActionListener(this);

        g2 = new JTextField(16);

        betaContainer.setLayout(new GridLayout(1, 2));

        betaContainer.add(g2);
        betaContainer.add(tw);


        window.setLayout(new BorderLayout());
        window.setSize(800, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game1.setLayout(new BorderLayout());
        game1.setSize(800, 800);
        game1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game2.setLayout(new BorderLayout());
        game2.setSize(800, 800);
        game2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        begin.setLayout(new BorderLayout());
        begin.setSize(800, 800);
        begin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container resetContainer = new Container();
        Container boardContainer = new Container();
        resetContainer.setLayout(new GridLayout(1, 1));
        boardContainer.setLayout(new GridLayout(4, 4));

        Container wordContainer = new Container();
        wordContainer.setLayout(new GridLayout(6, 5));

        Container miniContainer = new Container();
        miniContainer.setLayout(new GridLayout(3, 1));

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

        for (int row = 0; row < mini.length; row++) {
            for (int col = 0; col < mini[0].length; col++) {
                mini[row][col] = new JButton();
                mini[row][col].addActionListener(this);
                miniContainer.add(mini[row][col]);

            }
        }

        window.add(resetContainer, BorderLayout.NORTH);
        window.add(boardContainer, BorderLayout.CENTER);

        game1.add(wordContainer, BorderLayout.CENTER);
        game1.add(gamaContainer, BorderLayout.SOUTH);

        begin.add(miniContainer, BorderLayout.CENTER);
        mini[0][0].setText("WORDLE");
        mini[1][0].setText("SPELLING BEE");
        mini[2][0].setText("CONNECTIONS");

        begin.setVisible(true);


    }
    String[] words = {"ABOUT", "ALERT", "ARGUE", "BEACH", "ACTOR", "ALLOW", "ASIDE", "BEGUN",
            "ADULT", "AMONG", "AVOID", "BILLY", "AGREE", "APART", "BAKER", "BLIND",
            "BOOST", "BUYER", "CHINA", "COVER", "BRAND", "CATCH", "CLASS", "CRIME",
            "BRING", "CHASE", "CLOSE", "CYCLE", "BUILD", "CHIEF", "COUNT", "DEALT",
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
    String[][] nums = new String[4][4];
    int num = (int) (Math.random()*5)+1;


    String[][] one = {{"COLLAPSE", "WAVE", "SEA", "GIVE"},
            {"CAVE", "DANCE", "FLOP", "MASS"},
            {"BUCKLE", "SNAP", "WHISTLE", "TON"}
            ,{"BUTTON", "SHOUT","SLEW", "LAUGH"}};
    String fall = "BUCKLECAVECOLLAPSEGIVE";
    String attention = "SHOUTSNAPWAVEWHISTLE";
    String amount = "MASSSEASLEWTON";
    String belly = "BUTTONDANCEFLOPLAUGH";
    String[][] two = {
            {"JELLY BEAN", "LOUNGE", "FELLOW", "BUNNY"},
            {"PEER", "PARTNER", "LIBRARY", "EGG"},
            {"SPY", "HALL", "PEEP", "BIRTHMARK"},
            {"ASSOCIATE", "STUDY","ANIMAL", "UNIT"}};
    String easter = "BUNNYEGGJELLY BEANPEEP";
    String pal = "ASSOCIATEFELLOWPARTNERPEER";
    String clue = "HALLLIBRARYLOUNGESTUDY";
    String mole = "ANIMALBIRTHMARKSPYUNIT";
    String[][] three = {
            {"CHANNEL", "OUTSIDE", "VEHICLE", "STYLES"},
            {"LARGE", "SWIFT", "MEDIUM", "GRANDE"},
            {"MARS", "REMOTE", "LEGEND", "SLIM"},
            {"MEANS", "ROOM","PROOF", "SMALL"}};
    String pop = "GRANDEMARSSTYLESSWIFT";
    String method = "CHANNELMEANSMEDIUMVEHICLE";
    String chance = "OUTSIDEREMOTESLIMSMALL";
    String living = "LARGELEGENDPROOFROOM";

    String[][] four = {
            {"COMPLAINT", "WINDSOCK", "CLAIM", "RUNWAY"},
            {"FOXGLOVE", "HANGAR", "TURNCOAT", "LAWSUIT"},
            {"RING", "ACTION", "TORCH", "CLUB"},
            {"BEANBAG", "GUMSHOE","TARMAC", "TERMINAL"}};
    String airport = "HANGARRUNWAYTARMACTERMINAL";
    String legal = "ACTIONCLAIMCOMPLAINTLAWSUIT";
    String juggle = "BEANBAGCLUBRINGTORCH";
    String clothing = "FOXGLOVEGUMSHOETURNCOATWINDSOCK";
    String[][] five = {
            {"TOE", "PIPE", "COLLECTIVE", "DRAIN"},
            {"LUCID", "CIGARETTE", "TICKET", "MUTUAL"},
            {"CLEAR", "FEVER", "EMPTY", "FLUSH"},
            {"PENCIL", "AMERICAN","JOINT", "COMMON"}};
    String dream = "AMERICANFEVERLUCIDPIPE";
    String shared = "COLLECTIVECOMMONJOINTMUTUAL";
    String rid = "CLEARDRAINEMPTYFLUSH";
    String stub = "CIGARETTEPENCILTICKETTOE";
    public void connections(){
        System.out.println(num);

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



    int yu = (int)(Math.random()*2);

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        int m = 0;
        if (s.equals("submit")) {
            while(m<6){
            guess = t.getText();
            guess = guess.toUpperCase();
            t.setText("");
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
                if(guess.equals(correct)){
                    game1.setVisible(false);
                    begin.setVisible(true);
                    mini[0][0].setEnabled(true);
                    break;
                }

            numb++;
            m++;
        }
        }

        for(int fi = 0; fi<mini.length; fi++){
            for(int yo = 0; yo<mini[0].length; yo++){
                if (e.getSource().equals(mini[fi][yo])) {
                    mini[fi][yo].setEnabled(false);
                    if(!mini[0][0].isEnabled()){
                        begin.setVisible(false);
                        game1.setVisible(true);
                        game1.repaint();


                    }
                    if(!mini[1][0].isEnabled()) {
                        System.out.println(yu);
                        if (yu == 0) {
                            bee = new JButton[8][6];
                            JButton enterButton = new JButton("F               A               B               E               I               L               N");

                            Container enterContainer = new Container();
                            Container beeContainer = new Container();
                            enterContainer.setLayout(new GridLayout(1, 1));
                            beeContainer.setLayout(new GridLayout(8, 6));

                            for (int row = 0; row < bee.length; row++) {
                                for (int col = 0; col < bee[0].length; col++) {
                                    bee[row][col] = new JButton();
                                    bee[row][col].addActionListener(this);
                                    beeContainer.add(bee[row][col]);
                                }
                            }

                            enterButton.addActionListener(this);
                            enterContainer.add(enterButton);

                            game2.add(enterContainer, BorderLayout.NORTH);
                            game2.add(beeContainer, BorderLayout.CENTER);
                            game2.add(betaContainer, BorderLayout.SOUTH);

                            bee[7][5].setText("Score: " + score);
                            bee[7][5].setEnabled(false);
                            game2.setVisible(true);

                        }

                        if (yu == 1) {
                            bee = new JButton[6][4];
                            JButton enterButton = new JButton("R               G               N               O               P               U               W");

                            Container enterContainer = new Container();
                            Container beeContainer = new Container();
                            enterContainer.setLayout(new GridLayout(1, 1));
                            beeContainer.setLayout(new GridLayout(6, 4));

                            for (int row = 0; row < bee.length; row++) {
                                for (int col = 0; col < bee[0].length; col++) {
                                    bee[row][col] = new JButton();
                                    bee[row][col].addActionListener(this);
                                    beeContainer.add(bee[row][col]);

                                }

                            }

                            enterButton.addActionListener(this);
                            enterContainer.add(enterButton);

                            game2.add(enterContainer, BorderLayout.NORTH);
                            game2.add(beeContainer, BorderLayout.CENTER);
                            game2.add(betaContainer, BorderLayout.SOUTH);
                            System.out.println("Uh?");
                            bee[5][3].setText("Score: " + score);
                            bee[5][3].setEnabled(false);
                            game2.setVisible(true);
                        }



                            String gu = "";
                            ArrayList<String> guesser = new ArrayList<String>();
                            while (game.get(yu).getArray().length > 0 && !gu.equals("QUIT") && guesser.size() != game.get(yu).getArray().length) {
                                if (s.equals("enter")) {
                                    gu = g2.getText();
                                    gu = gu.toUpperCase();
                                    g2.setText("");
                                    int a = 0;
                                    int b = 0;
                                    System.out.println(gu);
                                    for (int i = 0; i < game.get(yu).getArray().length; i++) {
                                        System.out.println(i);
                                        if (gu.equals(game.get(yu).getArray()[i]) && !guesser.contains(gu)) {
                                            a = 1;
                                            b = i;

                                        }
                                    }

                                    if (a == 1) {
                                        int r = 0;
                                        int c = 0;
                                        score = score + game.get(yu).getArray()[b].length();
                                        guesser.add(gu);
                                        if (yu == 0) {
                                            r = (int) (Math.random() * 8);
                                            c = (int) (Math.random() * 6);
                                        }
                                        if (yu == 1) {
                                            r = (int) (Math.random() * 6);
                                            c = (int) (Math.random() * 4);
                                        }
                                        if (bee[r][c].isEnabled()) {
                                            bee[r][c].setText(gu);
                                            bee[r][c].setEnabled(false);
                                            if (yu == 0) {
                                                bee[7][5].setText("Score: " + score);
                                                bee[7][5].setEnabled(false);
                                            }
                                            if (yu == 1) {
                                                bee[5][3].setText("Score: " + score);
                                                bee[5][3].setEnabled(false);
                                            }
                                        } else {
                                            while (!bee[r][c].isEnabled()) {
                                                if (yu == 0) {
                                                    r = (int) (Math.random() * 8);
                                                    c = (int) (Math.random() * 6);
                                                }
                                                if (yu == 1) {
                                                    r = (int) (Math.random() * 6);
                                                    c = (int) (Math.random() * 4);
                                                }
                                            }
                                            bee[r][c].setText(gu);
                                            bee[r][c].setEnabled(false);
                                            if (yu == 0) {
                                                bee[7][5].setText("Score: " + score);
                                                bee[7][5].setEnabled(false);
                                            }
                                            if (yu == 1) {
                                                bee[5][3].setText("Score: " + score);
                                                bee[5][3].setEnabled(false);
                                            }

                                        }

                                    } else if (guesser.contains(gu)) {
                                        System.out.println("Word has already been used. Try again.");
                                    } else if (a == 0 && !gu.equals("QUIT")) {
                                        System.out.println("Not an eligible word. Try again.");
                                    }
                                    if (gu.equals("QUIT")) {
                                        System.out.println("Better luck next time!");
                                    }

                                    if (guesser.size() == game.get(yu).getArray().length) {
                                        System.out.println("You have found all the possible words!");
                                    }

                                }
                            }


                    }
                    if(!mini[2][0].isEnabled()){
                        begin.setVisible(false);
                        window.setVisible(true);
                        connections();
                    }
                }
            }

        }
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
                n = -1;
                if (num == 1) {
                    for (int y = w; y < board.length; y++) {
                        for (int x = 0; x < board[0].length; x++) {
                            if (!board[y][x].isEnabled()) {
                                q.add(board[y][x].getText());
                            }
                        }
                    }




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
                if(num == 3){
                    for (int y = w; y < board.length; y++) {
                        for (int x = 0; x < board[0].length; x++) {
                            if (!board[y][x].isEnabled()) {
                                q.add(board[y][x].getText());
                            }
                        }
                    }


                    if (living.contains(q.get(0)) && living.contains(q.get(1)) && living.contains(q.get(2)) && living.contains(q.get(3))) {
                        n = 3;
                    }
                    if (chance.contains(q.get(0)) && chance.contains(q.get(1)) && chance.contains(q.get(2)) && chance.contains(q.get(3))) {
                        n = 1;
                    }
                    if (method.contains(q.get(0)) && method.contains(q.get(1)) && method.contains(q.get(2)) && method.contains(q.get(3))) {
                        n = 2;
                    }
                    if (pop.contains(q.get(0)) && pop.contains(q.get(1)) && pop.contains(q.get(2)) && pop.contains(q.get(3))) {
                        n = 0;
                    }
                }
                if(num == 4){
                    for (int y = w; y < board.length; y++) {
                        for (int x = 0; x < board[0].length; x++) {
                            if (!board[y][x].isEnabled()) {
                                q.add(board[y][x].getText());
                            }
                        }
                    }


                    if (clothing.contains(q.get(0)) && clothing.contains(q.get(1)) && clothing.contains(q.get(2)) && clothing.contains(q.get(3))) {
                        n = 3;
                    }
                    if (juggle.contains(q.get(0)) && juggle.contains(q.get(1)) && juggle.contains(q.get(2)) && juggle.contains(q.get(3))) {
                        n = 1;
                    }
                    if (legal.contains(q.get(0)) && legal.contains(q.get(1)) && legal.contains(q.get(2)) && legal.contains(q.get(3))) {
                        n = 2;
                    }
                    if (airport.contains(q.get(0)) && airport.contains(q.get(1)) && airport.contains(q.get(2)) && airport.contains(q.get(3))) {
                        n = 0;
                    }
                }
                if(num == 5){
                    for (int y = w; y < board.length; y++) {
                        for (int x = 0; x < board[0].length; x++) {
                            if (!board[y][x].isEnabled()) {
                                q.add(board[y][x].getText());
                            }
                        }
                    }


                    if (dream.contains(q.get(0)) && dream.contains(q.get(1)) && dream.contains(q.get(2)) && dream.contains(q.get(3))) {
                        n = 3;
                    }
                    if (stub.contains(q.get(0)) && stub.contains(q.get(1)) && stub.contains(q.get(2)) && stub.contains(q.get(3))) {
                        n = 1;
                    }
                    if (rid.contains(q.get(0)) && rid.contains(q.get(1)) && rid.contains(q.get(2)) && rid.contains(q.get(3))) {
                        n = 2;
                    }
                    if (shared.contains(q.get(0)) && shared.contains(q.get(1)) && shared.contains(q.get(2)) && shared.contains(q.get(3))) {
                        n = 0;
                    }
                }
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

                        }
                    }
                }
            }
        }
    }