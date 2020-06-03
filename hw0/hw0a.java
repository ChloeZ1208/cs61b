public class hw0a{
	public static void main(String[] args){
		int col = 0, row = 0, SIZE = 5;
		while(col <= row){
			while(row < SIZE){
				col = 0;
				while(col < row){
					System.out.print("*");
					col = col + 1;
				}
				System.out.println("*");
				row = row + 1;
			}
		}

	}
}