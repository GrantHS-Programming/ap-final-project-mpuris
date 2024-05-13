public class Puzzle {
    private String letters;
    private String[] array;
    Puzzle(String letters, String[] array){
        this.letters = letters;
        this.array = array;
    }
    public String getLetters(){
        return letters;
    }
    public String[] getArray(){
        return array;
    }

}
