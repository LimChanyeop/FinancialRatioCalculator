package interAc;
//String gr[] = {"매출액","전기매출액","기초자산","자산","당기순이익","전기순이익"};
//성장성 비율 (Growth Ratio)

public class Gr_ratio {
	public static double sales, s_sales, s_asset, asset, earning, s_earning;// GuiCalc.d_ac [] 배열에 들어가게 될 항목들
	public static double gr_sales, gr_asset, gr_earning;//결과로 출력되는 비율들

	Gr_ratio() {//비율 계산
		gr_sales = ((GuiCalc.d_gr[0] - GuiCalc.d_gr[1]) / GuiCalc.d_gr[1]) * 100;
		gr_asset = ((GuiCalc.d_gr[3] - GuiCalc.d_gr[2]) / GuiCalc.d_gr[2]) * 100;
		gr_earning = ((GuiCalc.d_gr[4] / GuiCalc.d_gr[5]) * 100) - 100.0;
	}

	public void printgr() {
		System.out.println("매출액증가율=" + gr_sales + "%\n총자산증가율=" + gr_asset + "%\n순이익증가율=" + gr_earning + "%");
	}
}
