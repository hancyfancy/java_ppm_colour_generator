public class PpmSchema extends AbstractPpm {
    private String magicNumber;
    private String permutation;
    public PpmSchema() {
        super();
        this.setMagicNumber("P3");
    }
    public PpmSchema(String newPermutation) {
        this();
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
        String output = getMagicNumber().concat(" ").concat(pixelSizeString).concat(" ").concat(pixelSizeString).concat(" ").concat(String.valueOf(getMaximumOpacity())).concat(" ").concat(getPermutation().repeat(pixelSize*pixelSize).replaceAll(".(?=.)", "$0 ")).concat("\n");
        return output;
    }
}
