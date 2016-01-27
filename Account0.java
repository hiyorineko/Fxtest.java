public class Account0{
	
	private final static int MAX_ACCOUNT = 1000;	//�������ő�l
	private static Account0[] acs = new Account0[MAX_ACCOUNT]; //�����p�z��
	private static int count = 0;	//�������J�E���^�[
	private int zandaka;	//�����c��
	private int No;	//�����ԍ�
	
	public Account0(int shokichi){
		zandaka = shokichi;
		System.out.println(shokichi+"�Ō����쐬");
		acs[count]=this;
		No = getNumberOfInstance();
		count++;
	}
	
	public static int getNumberOfInstance(){
		return count;	//private�Ȃ̂Ń��\�b�h������
	}
	
	public void transfer(int idx,int gaku){
		acs[idx].hikidashi(gaku);
		this.azuke(gaku);
	}
	
	public void hikidashi(int gaku){
		zandaka -=gaku;
		System.out.println("���� #"+No+" "+gaku+"���o");
	}
	
	public void azuke(int gaku){
		zandaka += gaku;
		System.out.println("���� #"+No+" "+gaku+"�a��");
	}
	
	public String toString(){	//String�^�ŃC���X�^���X���������Ăяo���Ƃ��ꂪ���s����܂�
		return "���� #"+No+" �c�� = "+zandaka+"";
	}
}