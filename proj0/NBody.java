public class NBody {

	public static String starfield = "./images/starfield.jpg";

	public static double readRadius(String dataFile) {
		In in = new In(dataFile);
		in.readInt();
		double radius = in.readDouble();
		return radius;
	}

    /**对象数组 遍历*/
	public static Body[] readBodies(String dataFile) {
		In in = new In(dataFile);
		int bodyNumbers = in.readInt();
		Body[] bodies = new Body[bodyNumbers]; //创建bodies数组
		for(int i = 0; i < bodyNumbers; i++) {
			bodies[i] = new Body();
		}                                      //给bodies分配内存空间

		in.readDouble();

		for(int j = 0; j < bodyNumbers; j++) { //给bodies元素赋值
			bodies[j].xxPos = in.readDouble();
			bodies[j].yyPos = in.readDouble();
			bodies[j].xxVel = in.readDouble();
			bodies[j].yyVel = in.readDouble();
			bodies[j].mass = in.readDouble();
			bodies[j].imgFileName = in.readString();						
		}

		return bodies;
	}

	public static void main(String[] args){
		/** Collecting all needed input*/
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Body[] bodies = readBodies(filename);

		/** Drawing the background*/
		StdDraw.setScale(-radius, radius);
		StdDraw.enableDoubleBuffering();

		double time = 0.0;
		while (time < T){
			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];

			/** Calculate the net x and y forces for each Body*/
			for(int k = 0; k < bodies.length; k++){
				xForces[k] = bodies[k].calcNetForceExertedByX(bodies);
				yForces[k] = bodies[k].calcNetForceExertedByY(bodies);
			}
			/** Update each body’s position, velocity, and acceleration*/
			for(int m = 0; m < bodies.length; m++){
				bodies[m].update(dt, xForces[m], yForces[m]);
			}
			/** Draw the background image*/
			StdDraw.picture(0, 0, starfield);

			/** Drawing all the bodies*/
			for(Body b : bodies) {
			b.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);

			time = time + dt;
		}

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  	bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  	bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}
	}
}