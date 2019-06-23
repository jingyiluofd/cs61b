public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {

        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body c) {

        double xx;
        double yy;

        xx = this.xxPos - c.xxPos;
        yy = this.yyPos - c.yyPos;
        return Math.sqrt(xx * xx + yy * yy);
    }

    public double calcForceExertedBy(Body d) {

        double f;
        double r;

        r = this.calcDistance(d);
        f = (6.67 * Math.pow(10, -11) * this.mass * d.mass) / (r * r);
        return f;
    }


    public double calcForceExertedByX(Body d) {

        double f;
        double r;
        double dx;
        double fx;

        r = this.calcDistance(d);
        f = this.calcForceExertedBy(d);
        dx = d.xxPos - this.xxPos;
        fx = (f * dx) / r;
        return fx;
    }

    public double calcForceExertedByY(Body d) {

        double f;
        double r;
        double dy;
        double fy;
        System.out.println(d.imgFileName);
        r = this.calcDistance(d);
        f = this.calcForceExertedBy(d);
        dy = d.yyPos - this.yyPos;
        fy = (f * dy) / r;

        return fy;
    }

    public double calcNetForceExertedByX(Body[] allbodys) {
        double fx = 0;

        for (int i = 0; i < allbodys.length; i++) {
            if (allbodys[i].equals(this)) {
                continue;
            }
            fx = fx + this.calcForceExertedByX(allbodys[i]);
        }
        return fx;
    }


    public double calcNetForceExertedByY(Body[] allbodys) {
        double fy = 0;

        for (int i = 0; i < allbodys.length; i++) {
            if (allbodys[i].equals(this)) {
                continue;
            }
            fy = fy + this.calcForceExertedByY(allbodys[i]);
        }
        return fy;
    }

    public void update( double dt, double fX, double fY) {
        double ax;
        double ay;

        ax = fX / mass;
        ay = fY / mass;

        xxVel = xxVel + dt * ax;
        yyVel = yyVel + dt * ay;

        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }

}
