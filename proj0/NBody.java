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

        StdDraw.enableDoubleBuffering();

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
        double time;

        for (time = 0; time <= T; time = time + dt){
             double[] xForces = new double[5];
             double[] yForces = new double[5];

             for (int i = 0; i < 5; i++) {
                 xForces[i] = planets[i].calcNetForceExertedByX(planets);
                 yForces[i] = planets[i].calcNetForceExertedByY(planets);
             }

             for (int i = 0; i < 5; i++) {
                //System.out.println(xForces[i]);
                planets[i].update(time, xForces[i], yForces[i]);
             }


             // draw background image
             StdDraw.picture(0, 0, imageToDraw, radius * 2, radius * 2);

             // draw all the plantes
             for (int i = 0; i < planets.length; i++) {
                planets[i].draw();
             }

             // show the graph
             StdDraw.show();

             StdDraw.pause(10);
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }

}