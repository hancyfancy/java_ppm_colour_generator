import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColourGenerator extends AbstractPpm {
    private String storageLocation;
    private PpmSchema template;
    public ColourGenerator(String newStorageLocation) {
        super();
        this.setStorageLocation(newStorageLocation);
        this.setTemplate(new PpmSchema());
        this.generateColours(getMaximumOpacity(), newStorageLocation);
    }
    public String getStorageLocation() {
        return this.storageLocation;
    }
    private void setStorageLocation(String newStorageLocation) {
        Pattern pattern = Pattern.compile("((?:[^/]*/)*)(.*)");
        Matcher matcher = pattern.matcher(newStorageLocation);
        boolean matchFound = matcher.find();
        if (matchFound) {
            this.storageLocation = newStorageLocation;
        }
    }
    public PpmSchema getTemplate() {
        return this.template;
    }
    private void setTemplate(PpmSchema newTemplate) {
        if (newTemplate != null) {
            this.template = newTemplate;
        }
    }
    private void generateColours(int opacity, String storageLocation) {
        PpmSchema templateI = getTemplate();
        for (int i = 0; i < ((opacity*111)+1); i++) {
            String wordI = String.valueOf(i);
            String paddedWordI = ("000" + wordI).substring(wordI.length());
            templateI.setPermutation(paddedWordI);
            try {
                File f = new File(storageLocation.concat(paddedWordI).concat(".ppm"));
                FileOutputStream is = new FileOutputStream(f);
                OutputStreamWriter osw = new OutputStreamWriter(is);    
                Writer w = new BufferedWriter(osw);
                w.write(templateI.toString());
                w.close();
            } catch (IOException e) {
                System.err.println(e);
            }
            //System.out.println(templateI);
        }
    }
}
