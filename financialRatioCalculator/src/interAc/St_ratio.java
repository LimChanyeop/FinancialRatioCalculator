package interAc;
//String st[] = {"유동자산","유동부채","재고자산","부채","자기자본","영업이익","금융비용"};
//안정성 비율 계산(Stability Ratio)
public class St_ratio {
	public static double currentA, currentL, inv, liability, equity, operationE, financeEx;// GuiCalc.d_ac [] 배열에 들어가게 될 항목들
	public double st_current, st_quickasset, st_liability, st_financeEx;//결과로 출력되는 비율들

	St_ratio() {//비율 계산
		st_current = (GuiCalc.d_st[0] / GuiCalc.d_st[1] ) * 100;
		st_quickasset = (GuiCalc.d_st[0] - GuiCalc.d_st[2]) / GuiCalc.d_st[1] * 100;
		st_liability = (GuiCalc.d_st[3] / GuiCalc.d_st[4]) * 100;
		st_financeEx = GuiCalc.d_st[5] / GuiCalc.d_st[6];
	}

	public void printst() {
		System.out.println("유동비율=" + st_current + "%\n" + "당좌비율=" + st_quickasset + "%\n" + "부채비율=" + st_liability + "%\n" + "이자보상배율=" + st_financeEx);
	}
}

/*st_current = (GuiCalc.d_st[0] / currentL) * 100;
st_quickasset = (currentA - Ac_ratio.inv) / currentL * 100;
st_liability = (liability / equity) * 100;
st_financeEx = operationE / financeEx;*/