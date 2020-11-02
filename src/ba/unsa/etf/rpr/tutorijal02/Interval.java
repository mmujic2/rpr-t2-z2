package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetnaTacka;
    double krajnjaTacka;
    boolean isPocetnaTackaInInterval;
    boolean isKrajnjaTackaInInterval;

    Interval(double PocetnaTacka, double KrajnjaTacka, boolean tacka1, boolean tacka2) throws IllegalArgumentException {
        if (PocetnaTacka > KrajnjaTacka) {
            throw new IllegalArgumentException("Pogresne Tacke!");
        }
        this.pocetnaTacka = PocetnaTacka;
        this.krajnjaTacka = KrajnjaTacka;
        this.isPocetnaTackaInInterval = tacka1;
        this.isKrajnjaTackaInInterval = tacka2;
    }

    Interval() {
        pocetnaTacka = 0;
        krajnjaTacka = 0;
        isPocetnaTackaInInterval = false;
        isKrajnjaTackaInInterval = false;
    }

    public boolean isNull() {
        return pocetnaTacka == 0 && krajnjaTacka == 0 && !isPocetnaTackaInInterval && !isKrajnjaTackaInInterval;
    }

    public boolean isIn(double tacka) {
        if (tacka > pocetnaTacka && tacka < krajnjaTacka) {
            return true;
        } else if (tacka == pocetnaTacka && isPocetnaTackaInInterval && tacka < krajnjaTacka) {
            return true;
        } else return tacka > pocetnaTacka && tacka <= krajnjaTacka && isKrajnjaTackaInInterval;
    }

    private void postaviPocetnuTacku(Interval i) {
        this.pocetnaTacka = i.pocetnaTacka;
        this.isPocetnaTackaInInterval = i.isPocetnaTackaInInterval;
    }

    private void postaviKrajnjuTacku(Interval i) {
        this.krajnjaTacka = i.krajnjaTacka;
        this.isKrajnjaTackaInInterval = i.isKrajnjaTackaInInterval;
    }


    public Interval intersect(Interval interval) {
        Interval presjecniInterval = new Interval();
        if(this.pocetnaTacka > interval.pocetnaTacka) {
            presjecniInterval.postaviPocetnuTacku(this);
        } else {
            presjecniInterval.postaviPocetnuTacku(interval);
        }

        if(this.krajnjaTacka < interval.krajnjaTacka) {
            presjecniInterval.postaviKrajnjuTacku(this);
        } else {
            presjecniInterval.postaviKrajnjuTacku(interval);
        }

        return presjecniInterval;
    }

    public static Interval intersect(Interval interval1, Interval interval2){
        Interval presjecniInterval = new Interval();
        if(interval1.pocetnaTacka > interval2.pocetnaTacka) {
            presjecniInterval.postaviPocetnuTacku(interval1);
        } else {
            presjecniInterval.postaviPocetnuTacku(interval2);
        }

        if(interval1.krajnjaTacka < interval2.krajnjaTacka) {
            presjecniInterval.postaviKrajnjuTacku(interval1);
        } else {
            presjecniInterval.postaviKrajnjuTacku(interval2);
        }

        return presjecniInterval;
    }

    public String toString() {
        String s = "";
        if (this.isNull()) {
            s = "()";
            return s;
        }

        if(isPocetnaTackaInInterval) {
            s = s + "[";
        } else {
            s = s + "(";
        }

        s = s + pocetnaTacka + "," + krajnjaTacka;

        if(isKrajnjaTackaInInterval){
            s = s + "]";
        } else {
            s = s + ")";
        }

        return s;
    }

    public boolean equals(Interval interval) {
        return this.pocetnaTacka == interval.pocetnaTacka &&
                this.krajnjaTacka == interval.krajnjaTacka &&
                this.isPocetnaTackaInInterval == interval.isPocetnaTackaInInterval &&
                this.isKrajnjaTackaInInterval == interval.isKrajnjaTackaInInterval;
    }
}


