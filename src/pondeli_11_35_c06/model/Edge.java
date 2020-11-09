package pondeli_11_35_c06.model;

public class Edge {

    private int x1, y1, x2, y2;

    /**
     * @param p1 první koncový bod hrany
     * @param p2 druhý koncový bod hrany
     */
    public Edge(Point p1, Point p2) {
        // TODO přiřazení hodnot
    }

    /**
     * Zjistí, zda je hrana vodorovná
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
        // TODO prohození hodnot, když y1 je větší než y2
    }

    /**
     * Zjistí, zda existuje průsečík s touto hranou
     *
     * @param y y-ová souřadnice vodorovné přímky (řádek pixelů)
     * @return true, pokud v rozsahu této hrany existuje průsečík
     */
    public boolean hasIntersection(int y) {
        // TODO y je mezi y1, y2
        return false;
    }

    /**
     * Vypočítá x-ovou souřadnici průsečíku s touto hranou
     *
     * @param y y-ová souřadnice vodorovné přímky (řádek pixelů)
     * @return vrátí x-ovou souřadnici průsečíku
     */
    public int getIntersection(int y) {
        // TODO vypočítat průsečík (osa Y)
        // y = k*x+q
        // x = k*y+q
        return 0;
    }

    /**
     * Zjistí na které straně přímky tvořené touto úsečkou se nachází bod z parametru
     *
     * @param p bod pro zjištění
     * @return true, když je bod na "správné" straně - záleží na orientace a na výpočtu normály
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

    /**
     * Výpočet průsečíku dvou úseček.
     * První úsečka je daná instancí této třídy.
     * Druhá úsečka je dané dvěma body z parametrů funkce.
     *
     * @param p1 první krajní bod druhé úsečky
     * @param p2 druhá krajní bod druhé úsečky
     * @return průsečík
     */
    public Point getIntersection(Point p1, Point p2) {
        // TODO
        return new Point(0, 0);
    }

}
