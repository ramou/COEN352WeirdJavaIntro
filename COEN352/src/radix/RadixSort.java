package radix;

import java.lang.reflect.Method;

public class RadixSort {

	
	static void foo(FakeInteger a) {
		a.setVal(a.getVal()+1);
		System.out.println(a);
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		FakeInteger b = new FakeInteger(10);
		foo(b.clone());
		System.out.println(b);
		
		
		try {
			System.out.println(b.getClass().getConstructors()[0].newInstance(42));
			
			Method m = Class.forName("radix.RadixSort").getMethod("main", String[].class);
			
			//We couldn't pass it args because it was treating that as the sequence of arguments, 
			//so we had to wrap our string array in an object array so it was the first of a set 
			//of arguments... oh, this brings back memories.
			Object[] newArgs = new Object[1];
			newArgs[0] = args;

			//INFINITE LOOP!
			m.invoke(null, newArgs);

			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}

	
	private static class FakeInteger implements Cloneable{
		int val;

		public FakeInteger(int val) {
			super();
			this.val = val;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}
		
		@Override
		public FakeInteger clone() throws CloneNotSupportedException {
			return (FakeInteger)super.clone();
		}
		
		@Override
		public String toString() {
			return "" + val;
		}
	}
}
