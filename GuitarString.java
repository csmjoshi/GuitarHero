import java.util.*;
public class GuitarString {
		public static Set<Integer> nums =  new TreeSet<>();
		private Queue<Double> ringbuff;
		private int capacity;
		private double N;
		
		private static double energyDecay = 0.996;
		public GuitarString(double frequency) {
			
			//System.out.println(frequency);
			if(frequency <= 0)
				throw new IllegalArgumentException();
			ringbuff = new LinkedList<Double>();
			N = StdAudio.SAMPLE_RATE/frequency;
			nums.add((int) frequency);
			if(N % (int) N >= 0.5) {
				capacity = (int) N + 1;
			} else {
				capacity = (int)N;
			}
			
			if(capacity < 2)
				throw new IllegalArgumentException();
			
			for(int i = 0; i < capacity; i++) {
				ringbuff.add(0.0);
			}
		}
		
		public GuitarString(double[] init) {
			ringbuff = new LinkedList<Double>();
			if(init.length < 2) {
				throw new IllegalArgumentException();
			}
			//System.out.println(ringbuff);
			for(int i = 0; i  <init.length; i++) {
				System.out.println(init[i]);
				ringbuff.add(init[i]);
			}
			//System.out.println(ringbuff);
		}
		
		public void pluck() {
			for(int i = 0; i  < capacity; i++) {
				ringbuff.remove();
				System.out.println(Math.random() - 0.5);
				 ringbuff.add(Math.random() - 0.5);	
			}
		}
		public void tic() {
			double d = ringbuff.remove();
			double s = ringbuff.peek();
			ringbuff.add(energyDecay * 0.5 * (d + s));
		}
		
		public double sample()
		{
			return ringbuff.peek();
		}
}
