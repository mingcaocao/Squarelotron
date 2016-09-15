package squarelotron;

public class Squarelotron implements SquarelotronMethods {

	public int[][] squarelotron;
	public int size;

	public Squarelotron(int n){
		this.size = n;
		this.squarelotron = new int[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				squarelotron[i][j] = i * size + j + 1;
			}
		}	 
	}

	public Squarelotron(int[] array){
		this.size = (int) Math.sqrt(array.length);
		this.squarelotron = new int[size][size];
		int k = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				squarelotron[i][j] = array[k];
				k++;
			}
		}
	}

	public static Squarelotron makeSquarelotron(int[] array){
		int n = array.length;
		boolean positive = true;
		boolean negative = false;
		int i = 0;
		while(i < n && positive){
			if(array[i] < 0){
				positive = false;
				negative = true;
			}
			i++;
		}
		if(n != 1 && n != 4 && n != 9 && n != 16 && n != 25 && n != 36 && n != 49 && n != 64 || negative){
			throw new IllegalArgumentException("bad array provided");
		}
		else{
			Squarelotron squarelotron1 = new Squarelotron(array);
			return squarelotron1;
		}
	}

	public int[] numbers() {
		int[] numberArray = new int[size*size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				numberArray[i * size + j] = squarelotron[i][j];
			}
		}
		return numberArray;
	}

	public Squarelotron upsideDownFlip(int ring) {
		int[] numbers = numbers();
		int[] newNumbers = new int[size * size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(i == ring - 1 || i == size - ring || j == ring - 1 || j == size - ring){
					newNumbers[i * size + j] = numbers[(size - i - 1) * size + j];
				}
				else{
					newNumbers[i * size + j] = numbers[i * size + j];
				}
			}
		}
		Squarelotron newSquarelotron = new Squarelotron(newNumbers);
		return newSquarelotron;
	}

	public Squarelotron leftRightFlip(int ring) {
		int[] numbers = numbers();
		int[] newNumbers = new int[size * size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(i == ring - 1 || i == size - ring || j == ring - 1 || j == size - ring){
					newNumbers[i * size + j] = numbers[i * size + size - j - 1];
				}
				else{
					newNumbers[i * size + j] = numbers[i * size + j];
				}
			}
		}
		Squarelotron newSquarelotron = new Squarelotron(newNumbers);
		return newSquarelotron;		
	}

	public Squarelotron inverseDiagonalFlip(int ring) {
		int[] numbers = numbers();
		int[] newNumbers = new int[size * size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(i == ring - 1 || i == size - ring || j == ring - 1 || j == size - ring){
					newNumbers[i * size + j] = numbers[(size - 1 - j) * size + size - 1 - i];
				}
				else{
					newNumbers[i * size + j] = numbers[i * size + j];
				}
			}
		}
		Squarelotron newSquarelotron = new Squarelotron(newNumbers);
		return newSquarelotron;
	}

	public Squarelotron mainDiagonalFlip(int ring) {
		int[] numbers = numbers();
		int[] newNumbers = new int[size * size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(i == ring - 1 || i == size - ring || j == ring - 1 || j == size - ring){
					newNumbers[i * size + j] = numbers[j * size + i];
				}
				else{
					newNumbers[i * size + j] = numbers[i * size + j];
				}
			}
		}
		Squarelotron newSquarelotron = new Squarelotron(newNumbers);
		return newSquarelotron;
	}

	public Squarelotron sideFlip(String side) {
		int[] numbers = numbers();
		int[] newNumbers = new int[size * size];
		if(side.equals("left")){
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					if(j == 0 || j == 1){
						newNumbers[i * size + j] = numbers[i * size + 1 - j];
					}
					else{
						newNumbers[i * size + j] = numbers[i * size + j];
					}
				}
			}
		}
		else if(side.equals("right")){
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					if(j == size - 1 || j == size - 2){
						newNumbers[i * size + j] = numbers[i * size + 2 * size - 3 - j];
					}
					else{
						newNumbers[i * size + j] = numbers[i * size + j];
					}
				}
			}
		}
		else if(side.equals("top")){
			for(int j = 0; j < size; j++){
				for(int i = 0; i < size; i++){
					if(i == 0 || i == 1){
						newNumbers[i * size + j] = numbers[(1 - i) * size + j];
					}
					else{
						newNumbers[i * size + j] = numbers[i * size + j];
					}
				}
			}
		}
		else if(side.equals("bottom")){
			for(int j = 0; j < size; j++){
				for(int i = 0; i < size; i++){
					if(i == size - 1 || i == size - 2){
						newNumbers[i * size + j] = numbers[(2 * size - 3 - i) * size + j];
					}
					else{
						newNumbers[i * size + j] = numbers[i * size + j];
					}
				}
			}
		}
		Squarelotron newSquarelotron = new Squarelotron(newNumbers);
		return newSquarelotron;
	}

	public void rotateRightOnce(){
		for(int k = 0; k < size/2; k++){
			int[] savedArray = new int[size - 2 * k];
			int n = 0;
			for(int j = k; j < size - k; j++){
				savedArray[n] = squarelotron[k][j];
				n++;
			}
			for(int j = k; j < size - k; j++){
				squarelotron[k][j] = squarelotron[size - 1 - j][k];
			}
			for(int i = k; i < size - k; i++){
				squarelotron[i][k] = squarelotron[size - 1 - k][i];
			}
			for(int j = k; j < size - k; j++){
				squarelotron[size - 1 - k][j] = squarelotron[size - 1 - j][size - 1 - k];
			}
			n = 0;
			for(int i = k; i < size - k; i++){
				squarelotron[i][size - 1 - k] = savedArray[n];
				n++;
			}
		}
	}

	@Override
	public void rotateRight(int numberOfTurns) {
		if(size == 1){
			squarelotron[0][0] = squarelotron[0][0];
		}
		else if(numberOfTurns % 4 == 1 || numberOfTurns % 4 == -3){
			rotateRightOnce();
		}
		else if(numberOfTurns % 4 == 2 || numberOfTurns % 4 == -2){
			rotateRightOnce();
			rotateRightOnce();
		}
		else if(numberOfTurns % 4 == 3 || numberOfTurns % 4 == -1){
			rotateRightOnce();
			rotateRightOnce();
			rotateRightOnce();
		}
		else{
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					squarelotron[i][j] = squarelotron[i][j];
				}
			}
		}
	}
	
	public boolean same(Squarelotron providedSq){
		if(providedSq.size != size){
			return false;
		}
		boolean same = true;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(providedSq.squarelotron[i][j] != squarelotron[i][j]){
					same = false;
				}
			}
		}
		if(same){
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object object){
		Squarelotron providedSq = (Squarelotron) object;
		if(same(providedSq)){
			return true;
		}
		else{
			rotateRight(1);
		}
		if(same(providedSq)){
			return true;
		}
		else{
			rotateRight(1);
		}
		if(same(providedSq)){
			return true;
		}
		else{
			rotateRight(1);
		}		
		if(same(providedSq)){
			return true;
		}
		return false;
	}

	@Override
	public String toString(){
		String sqString = "";
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				sqString = sqString + squarelotron[i][j] + "\t";
			}
			sqString = sqString + "\n";
		}
		return sqString;
	}

	public static void main(String[] args) {
		String side = "left";
		boolean t = side.equals("left");
		System.out.println(t);
		Squarelotron sq1 = new Squarelotron(5);
		System.out.println(sq1.toString());
		Squarelotron sq3 = sq1.sideFlip("left");
		System.out.println(sq3.toString());
		int[] array2 = {1,2,3,4};
		Squarelotron sq2 = makeSquarelotron(array2);
		System.out.println(sq2.toString());
		int[] array3 = {2,3,-4,-5};
		makeSquarelotron(array3);
		int[] array4 = {3,4,5,6,7};
		makeSquarelotron(array4);
	}
}
