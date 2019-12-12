package interAc;
//String pr[] = {"당기순이익","매출액","기초자산","자산","자기자본"};
//수익성 비율(Profitability Ratio)
public class Pr_ratio {
	public static double earning, sales, s_asset, asset, equity ;//// GuiCalc.d_ac [] 배열에 들어가게 될 항목들
	public static double pr_sales,pr_asset,pr_equity;//결과로 출력되는 비율들

	Pr_ratio(){//비율 계산
		pr_sales = (GuiCalc.d_pr[0] / GuiCalc.d_pr[1])*100;
		pr_asset = (GuiCalc.d_pr[0] / ((GuiCalc.d_pr[2]+GuiCalc.d_pr[3])/2)*100);
		pr_equity = (GuiCalc.d_pr[0] / GuiCalc.d_pr[4])*100;
	}
	public void printpr() {
		System.out.println("매출액순이익률="+pr_sales+"%\n총자산이익률="+pr_asset+"%\n자기자본이익률="+pr_equity+"%");
	}

}
