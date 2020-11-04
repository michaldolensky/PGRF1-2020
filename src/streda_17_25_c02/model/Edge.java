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
        // TODO prohodit pokud y1 větší než y2
    }

}
