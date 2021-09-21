public class Valuta {
    private final float kurs;

    public Valuta(float kurs) {
        this.kurs = kurs;
    }

    public float tilNok(float sum) {
        return sum * kurs;
    }

    public float fraNok(float sum) {
        return sum / kurs;
    }
}