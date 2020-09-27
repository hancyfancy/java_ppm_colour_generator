abstract class AbstractPpm {
    private Integer pixelSize = -1;
    private Integer maximumOpacity = -1;
    public AbstractPpm() {
        this.setPixelSize(3);
        this.setMaximumOpacity(9);
    }
    public Integer getPixelSize() {
        return this.pixelSize;
    }
    private void setPixelSize(int newPixelSize) {
        if (newPixelSize > 0) {
            this.pixelSize = newPixelSize;
        }
    }
    public Integer getMaximumOpacity() {
        return this.maximumOpacity;
    }
    private void setMaximumOpacity(int newMaximumOpacity) {
        if (newMaximumOpacity < 10) {
            this.maximumOpacity = newMaximumOpacity;
        }
    }
}
