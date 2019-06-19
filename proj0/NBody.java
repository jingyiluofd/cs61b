public class NBody{

    public static double readRadius(String f){
        In in = new In(f);
        int firstItem = in.readInt();
        double secondItem = in.readDouble();
        return secondItem;
    }

    public static Body[] readBodies(String f) {
        int planetNum = 5;
        Body[] planet = new Body[planetNum] ;
        In in = new In(f);
        int firstItem = in.readInt();
        double secondItem = in.readDouble();

        for (int i = 0; i < planetNum; i++) {
            planet[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(), in.readString());
        }

        return planet;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String file = args[2];

        // init the plantes by read information from file
        double radius = readRadius(file);
        Body[] planets = new Body[5];
        planets = readBodies(file);

        // set up the canava
        StdDraw.setScale(-radius, radius);

        String imageToDraw = "./images/starfield.jpg";
        // draw background image
        StdDraw.picture(0, 0, imageToDraw, radius * 2, radius * 2);

        // draw all the plantes
        for (int i = 0; i < planets.length; i++) {
            planets[i].draw();
        }

        // show the graph
        StdDraw.show();
    }

}