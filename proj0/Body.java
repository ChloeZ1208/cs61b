public class Body {
	public double xxPos, yyPos;
	public double xxVel, yyVel;
	public double mass;
	public String imgFileName;

	private static final double G = 6.67E-11;

	/** 1st Constructor */
	public Body(double xP, double yP, double xV,
				double yV, double m, String img) {
		xxPos = xP; yyPos = yP;
		xxVel = xV; yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	/** 2nd Constructor */
	public Body(Body b) {
		xxPos = b.xxPos; yyPos = b.yyPos;
		xxVel = b.xxVel; yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	/** 由NBody写Body数组时发现少一个Constructor */
	public Body(){
		this.xxPos = 0;
        this.yyPos = 0;
        this.xxVel = 0;
        this.yyVel = 0;
        this.mass = 0;
        this.imgFileName = "";
	}

	/** Method1: Calculating the distance between two Bodys */
	public double calcDistance(Body goal) {
		double sqradius = (goal.xxPos - this.xxPos) * (goal.xxPos - this.xxPos) + (goal.yyPos - this.yyPos) * (goal.yyPos - this.yyPos);
		double radius = Math.sqrt(sqradius);
		return radius;
	}

	/** Method2: Calculating the total force */
	public double calcForceExertedBy(Body goal) {
		double forceBy = G * goal.mass * this.mass / (calcDistance(goal) * calcDistance(goal));
		return forceBy;
	}

	/** Method3: Calculating the force exerted in the X directions */
	public double calcForceExertedByX(Body goal) {
		double forceByX = calcForceExertedBy(goal) * (goal.xxPos - this.xxPos) / calcDistance(goal);
		return forceByX;
	}

	/** Method4: Calculating the force exerted in the Y directions */
	public double calcForceExertedByY(Body goal) {
		double forceByY = calcForceExertedBy(goal) * (goal.yyPos - this.yyPos) / calcDistance(goal);
		return forceByY;
	}

	/** Method5: Calculating the net force exerted in the X directions*/
	public double calcNetForceExertedByX(Body[] bodies) {
		double netforceX = 0.0;
		for (Body b: bodies){
			if (this.equals(b)) {
				continue;
			}
			netforceX = netforceX + calcForceExertedByX(b);
		}
		return netforceX;
	}

	/** Method6: Calculating the net force exerted in the Y directions*/
	public double calcNetForceExertedByY(Body[] bodies) {
		double netforceY = 0.0;
		for (Body b: bodies){
			if (this.equals(b)) {
				continue;
			}
			netforceY = netforceY + calcForceExertedByY(b);
		}
		return netforceY;
	}

	/** Method7: Updating the body's position and velocity*/
	public void update(double dt, double fX, double fY) {
		double aX = fX / mass,
			   aY = fY / mass;
	    xxVel = xxVel + dt * aX;
	    yyVel = yyVel + dt * aY;
	    xxPos = xxPos + dt * xxVel;
	    yyPos = yyPos + dt * yyVel;
	}

	/** Method8: Drawing one body*/
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + imgFileName);
	}

}