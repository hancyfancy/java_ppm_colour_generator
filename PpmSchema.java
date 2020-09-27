public class PpmSchema extends AbstractPpm {
    private String magicNumber;
    private int opacity;
    private String permutation;
    public PpmSchema(int newOpacity) {
        super();
        this.setMagicNumber("P3");
        this.setOpacity(newOpacity, getPixelSize());
    }
    public PpmSchema(int newOpacity, String newPermutation) {
        this(newOpacity);
        this.setPermutation(newPermutation);
    }
    public String getMagicNumber() {
        return this.magicNumber;
    }
    private void setMagicNumber(String newMagicNumber) {
        if ((newMagicNumber != null) && (newMagicNumber != "")) {
            this.magicNumber = newMagicNumber;
        }
    }
    public int getOpacity() {
        return this.opacity;
    }
    private void setOpacity(int newOpacity, int pixelSize) {
        if ((newOpacity > 0) && ((newOpacity % pixelSize) == 0) && (newOpacity <= getMaximumOpacity())) {
            this.opacity = newOpacity;
        }
    }
    public String getPermutation() {
        return this.permutation;
    }
    protected void setPermutation(String newPermutation) {
        if (newPermutation.length() == getPixelSize()) {
            try {
                Integer.parseInt(newPermutation);
                this.permutation = newPermutation;
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
    }
    public String toString() {
        int pixelSize = getPixelSize();
        String pixelSizeString = String.valueOf(pixelSize);
        String output = getMagicNumber().concat(" ").concat(pixelSizeString).concat(" ").concat(pixelSizeString).concat(" ").concat(String.valueOf(getOpacity())).concat(" ").concat(getPermutation().repeat(pixelSize*pixelSize).replaceAll(".(?=.)", "$0 ")).concat("\n");
        return output;
    }
}
