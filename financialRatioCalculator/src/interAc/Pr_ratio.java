package interAc;
//String pr[] = {"��������","�����","�����ڻ�","�ڻ�","�ڱ��ں�"};
//���ͼ� ����(Profitability Ratio)
public class Pr_ratio {
	public static double earning, sales, s_asset, asset, equity ;//// GuiCalc.d_ac [] �迭�� ���� �� �׸��
	public static double pr_sales,pr_asset,pr_equity;//����� ��µǴ� ������

	Pr_ratio(){//���� ���
		pr_sales = (GuiCalc.d_pr[0] / GuiCalc.d_pr[1])*100;
		pr_asset = (GuiCalc.d_pr[0] / ((GuiCalc.d_pr[2]+GuiCalc.d_pr[3])/2)*100);
		pr_equity = (GuiCalc.d_pr[0] / GuiCalc.d_pr[4])*100;
	}
	public void printpr() {
		System.out.println("����׼����ͷ�="+pr_sales+"%\n���ڻ����ͷ�="+pr_asset+"%\n�ڱ��ں����ͷ�="+pr_equity+"%");
	}

}
