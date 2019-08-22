public class OffByN implements CharacterComparator {
    public int n;

    public OffByN (int N) {
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return Math.abs(diff) == n;
    }
}