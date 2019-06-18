// skeleton version of the class

public class Guitar37 implements Guitar {
    public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
    	private GuitarString[] strings;
    	private int count = 0;
	
	public Guitar37() {
		strings = new GuitarString[KEYBOARD.length()];
		for(int i = 0; i < strings.length; i++) {
			strings[i] = new GuitarString( 440 * Math.pow(2, (i-24)/12.0));
			//System.out.println(KEYBOARD.charAt(i) + " " + (440 * Math.pow(2, ((i-24)/12.0))));
		}
	}
	public void playNote(int pitch) {
		for(int i = 0; i < strings.length; i++) {
			if(i -24 == pitch) {
				strings[i].pluck();
			}
		}
	}

	public boolean hasString(char key) {
		
		return KEYBOARD.contains(key + "");
	}

	public void pluck(char key) {
		int index = KEYBOARD.indexOf(key);
		System.out.println(index);
		if(index == -1) 
			throw new IllegalArgumentException();
		
		strings[index].pluck();
		
	}

	public double sample() {
		double result = 0;
		for(int i = 0; i < strings.length; i++) {
			result += strings[i].sample();
		}
		return result;
	}

	public void tic() {
		for(int i = 0; i < strings.length; i++) {
			strings[i].tic();
		}
		count++;
	}

	public int time() {
	
		return count;
	}

}