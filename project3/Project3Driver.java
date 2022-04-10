public class Project3Driver {

    /**
     * The main method of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Circle c = new Circle(2.0, "JR Circle");
        testShape(c);
        System.out.println(c.getArea());

        Square s = new Square(2.0, "JR Square");
        testShape(s);
        System.out.println(s.getArea());

        Cylinder c2 = new Cylinder(5.0, 2.0, "JR Cylinder");
        testShape(c2);
        System.out.println(c2.getVolume());

        Sphere s2 = new Sphere(2.0, "JR Sphere");
        testShape(s2);
        System.out.println(s2.getVolume());

        Cube c3 = new Cube(2.0, "JR Cube");
        testShape(c3);
        System.out.println(c3.getVolume());

        Glome g = new Glome(2.0, "JR Glome");
        testShape(g);
        System.out.println(g.getVolume());
    }

    /**
     * Tests common methods of any class in the Shape class hierarchy.
     *
     * @param s Shape to test
     */
    public static void testShape(Shape s) {
        System.out.println();
        System.out.println(s.getName());
        System.out.println(s.equals(s));
        System.out.println(s.toString());
    }

}