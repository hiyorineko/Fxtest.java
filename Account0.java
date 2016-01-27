public class Account0{
	
	private final static int MAX_ACCOUNT = 1000;	//口座数最大値
	private static Account0[] acs = new Account0[MAX_ACCOUNT]; //口座用配列
	private static int count = 0;	//口座数カウンター
	private int zandaka;	//口座残高
	private int No;	//口座番号
	
	public Account0(int shokichi){
		zandaka = shokichi;
		System.out.println(shokichi+"で口座作成");
		acs[count]=this;
		No = getNumberOfInstance();
		count++;
	}
	
	public static int getNumberOfInstance(){
		return count;	//privateなのでメソッドを挟む
	}
	
	public void transfer(int idx,int gaku){
		acs[idx].hikidashi(gaku);
		this.azuke(gaku);
	}
	
	public void hikidashi(int gaku){
		zandaka -=gaku;
		System.out.println("口座 #"+No+" "+gaku+"引出");
	}
	
	public void azuke(int gaku){
		zandaka += gaku;
		System.out.println("口座 #"+No+" "+gaku+"預入");
	}
	
	public String toString(){	//String型でインスタンス名だけを呼び出すとこれが実行されます
		return "口座 #"+No+" 残高 = "+zandaka+"";
	}
}