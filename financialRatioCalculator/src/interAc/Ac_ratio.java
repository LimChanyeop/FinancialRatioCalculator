package interAc;
//String ac[] = {"�����","�������","���ʸ���ä��","����ä��","��������ڻ�","����ڻ�"};
//Ȱ���� ����(Activity Ratio)
public class Ac_ratio {
	public static double sales, costofsales, s_acR, acR, s_inv, inv;// GuiCalc.d_ac [] �迭�� ���� �� �׸��
	public double ac_acR, ac_inv; //����� ��µǴ� ������
	Ac_ratio() {//���� ���
		ac_acR = GuiCalc.d_ac[0] / ((GuiCalc.d_ac[2] + GuiCalc.d_ac[3]) / 2);
		ac_inv = GuiCalc.d_ac[0] / ((GuiCalc.d_ac[4] + GuiCalc.d_ac[5]) / 2);
	}

	public void printac() {
		System.out.println("����ä��ȸ���� =" + ac_acR + "\n����ڻ�ȸ����=" + ac_inv);
	}
}
