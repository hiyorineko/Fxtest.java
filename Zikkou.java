public class Zikkou{
	public static void main(String[] args){
		
		Account0 kouza1 = new Account0(2000);	//2000の初期値をもったインスタンスを作ります
		Account0 kouza2 = new Account0(3000);	//3000の初期値をもったインスタンスを作ります
		kouza1.transfer(1,1000);
		System.out.println(kouza1);//toStringを書いたので
		System.out.println(kouza2);//インスタンス名だけでtoStringが実行されます
	}

}