package interAc;
//String ac[] = {"매출액","매출원가","기초매출채권","매출채권","기초재고자산","재고자산"};
//활동성 비율(Activity Ratio)
public class Ac_ratio {
	public static double sales, costofsales, s_acR, acR, s_inv, inv;// GuiCalc.d_ac [] 배열에 들어가게 될 항목들
	public double ac_acR, ac_inv; //결과로 출력되는 비율들
	Ac_ratio() {//비율 계산
		ac_acR = GuiCalc.d_ac[0] / ((GuiCalc.d_ac[2] + GuiCalc.d_ac[3]) / 2);
		ac_inv = GuiCalc.d_ac[0] / ((GuiCalc.d_ac[4] + GuiCalc.d_ac[5]) / 2);
	}

	public void printac() {
		System.out.println("매출채권회전율 =" + ac_acR + "\n재고자산회전율=" + ac_inv);
	}
}
