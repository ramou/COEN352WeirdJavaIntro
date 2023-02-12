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
			
			for(Method m : Class.forName("radix.RadixSort").getMethods())  {
				if(!m.getName().equals("main")) continue;
				System.out.println(m.getName());
				m.invoke(null, "", "");
			}
			
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
