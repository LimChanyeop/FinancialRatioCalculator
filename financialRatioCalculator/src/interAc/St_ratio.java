package interAc;
//String st[] = {"�����ڻ�","������ä","����ڻ�","��ä","�ڱ��ں�","��������","�������"};
//������ ���� ���(Stability Ratio)
public class St_ratio {
	public static double currentA, currentL, inv, liability, equity, operationE, financeEx;// GuiCalc.d_ac [] �迭�� ���� �� �׸��
	public double st_current, st_quickasset, st_liability, st_financeEx;//����� ��µǴ� ������

	St_ratio() {//���� ���
		st_current = (GuiCalc.d_st[0] / GuiCalc.d_st[1] ) * 100;
		st_quickasset = (GuiCalc.d_st[0] - GuiCalc.d_st[2]) / GuiCalc.d_st[1] * 100;
		st_liability = (GuiCalc.d_st[3] / GuiCalc.d_st[4]) * 100;
		st_financeEx = GuiCalc.d_st[5] / GuiCalc.d_st[6];
	}

	public void printst() {
		System.out.println("��������=" + st_current + "%\n" + "���º���=" + st_quickasset + "%\n" + "��ä����=" + st_liability + "%\n" + "���ں������=" + st_financeEx);
	}
}

/*st_current = (GuiCalc.d_st[0] / currentL) * 100;
st_quickasset = (currentA - Ac_ratio.inv) / currentL * 100;
st_liability = (liability / equity) * 100;
st_financeEx = operationE / financeEx;*/