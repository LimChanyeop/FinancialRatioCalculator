package interAc;
//String gr[] = {"�����","��������","�����ڻ�","�ڻ�","��������","���������"};
//���强 ���� (Growth Ratio)

public class Gr_ratio {
	public static double sales, s_sales, s_asset, asset, earning, s_earning;// GuiCalc.d_ac [] �迭�� ���� �� �׸��
	public static double gr_sales, gr_asset, gr_earning;//����� ��µǴ� ������

	Gr_ratio() {//���� ���
		gr_sales = ((GuiCalc.d_gr[0] - GuiCalc.d_gr[1]) / GuiCalc.d_gr[1]) * 100;
		gr_asset = ((GuiCalc.d_gr[3] - GuiCalc.d_gr[2]) / GuiCalc.d_gr[2]) * 100;
		gr_earning = ((GuiCalc.d_gr[4] / GuiCalc.d_gr[5]) * 100) - 100.0;
	}

	public void printgr() {
		System.out.println("�����������=" + gr_sales + "%\n���ڻ�������=" + gr_asset + "%\n������������=" + gr_earning + "%");
	}
}
