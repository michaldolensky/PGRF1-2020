package streda_17_25_c02.model;

public class Edge {

    private int x1, y1, x2, y2;

    /**
     * @param p1 první hraniční vrchol úsečky
     * @param p2 druhý hraniční vrchol úsečky
     */
    public Edge(Point p1, Point p2) {
        this.x1 = p1.x;
        this.y1 = p1.y;
        this.x2 = p2.x;
        this.y2 = p2.y;
    }

    /**
     * Zjistí, zda je tato hrana vodorovná
     *
     * @return true pokud je vodorovná, jinak false
     */
    public boolean isHorizontal() {
        // TODO test na rovnost y1 a y2
        return true;
    }

    /**
     * Zorientuje hranu odshora dolů
     */
    public void orientate() {
        // TODO prohodit, pokud y1 větší než y2
    }

    /**
     * Zjistí, zda existuje průsečík s řádkem Y v rozsahu této hrany
     *
     * @param y y souřadnice vodorovného řádku pixelů
     * @return true, pokud v rozsahu této hrany existuje průsečík Y
     */
    public boolean hasIntersection(int y) {
        // TODO y, y1, y2 - porovnat, zda je Y v rozsahu
        return false;
    }

    /**
     * Vrátí X souřadnici průsečíku této hrany s přímkou, která je dána řádkem Y
     * @param y y souřadnice vodorovné přímky
     * @return X souřadnici průsešíku
     */
    public int getIntersection(int y) {
        // TODO použití obdoby y=kx+q; vypočítat průsečík pomocí y,k,q (podle osy Y)
        return 0;
    }

    /**
     * Zjistí, na které straně přímky tvořené touto úsečkou se nachází bod z parametru
     *
     * @param p bod pro zjištění
     * @return true, když je bod na "správné" straně (- záleží na orientaci)
     */
    public boolean isInside(Point p) {
        // tečný vektor
        Point t = new Point(x2 - x1, y2 - y1);

        // normálový vektor
        @SuppressWarnings("SuspiciousNameCombination")
        Point n = new Point(t.y, -t.x);
//        Point n = new Point(-t.y, t.x);

        // vektor k bodu
        Point v = new Point(p.x - x1, p.y - y1);

        return (v.x * n.x + v.y * n.y < 0);
    }

    public Point getIntersection(Point p1, Point p2) {
        // TODO opsat z přednášky
        return new Point(0, 0);
    }

}





