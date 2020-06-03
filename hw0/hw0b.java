public class hw0b{
	public static void drawTriangle(int N){

		String y = "*";
		for(int i = 0; i < N; i++){
			System.out.println(y);
			y += "*";
	}
}
	public static void main(String[] args){
	drawTriangle(10);
	}
}