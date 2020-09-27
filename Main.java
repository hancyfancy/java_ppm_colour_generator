import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ColourGenerator colourGenerator = new ColourGenerator(9, "./colour/");
        System.out.println(colourGenerator.getStorageLocation());
    }
}
