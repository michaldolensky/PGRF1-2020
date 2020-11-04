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

}
