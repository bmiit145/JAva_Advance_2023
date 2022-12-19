class Test_garbage{

	public void finalize(){
		System.out.println("Ughighfoih");
	}
	public static void main(String args[]){
	
		Test_garbage t = new Test_garbage();
		
		t = null;
		
		System.gc();
	}
}
