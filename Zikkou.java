public class Zikkou{
	public static void main(String[] args){
		
		Account0 kouza1 = new Account0(2000);	//2000�̏����l���������C���X�^���X�����܂�
		Account0 kouza2 = new Account0(3000);	//3000�̏����l���������C���X�^���X�����܂�
		kouza1.transfer(1,1000);
		System.out.println(kouza1);//toString���������̂�
		System.out.println(kouza2);//�C���X�^���X��������toString�����s����܂�
	}

}