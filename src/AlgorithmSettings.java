public class AlgorithmSettings {

    private final int maximumCellIndex;
    private final int defaultThemeIndex;
    private final double[] liveCellChances;

    public AlgorithmSettings(int maximumCellIndex, int defaultThemeIndex, double[] liveCellChances) {
        this.maximumCellIndex = maximumCellIndex;
        this.defaultThemeIndex = defaultThemeIndex;
        this.liveCellChances = liveCellChances;
    }

    public int getMaximumCellIndex() {
        return maximumCellIndex;
    }

    public int getDefaultThemeIndex() {
        return defaultThemeIndex;
    }

    public double[] getLiveCellChances() {
        return liveCellChances;
    }
}
