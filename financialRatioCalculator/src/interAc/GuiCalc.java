package interAc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiCalc extends JFrame {
	
	JTextField tf = new JTextField(13);
	JLabel la = new JLabel("");
	JLabel exception = new JLabel("다시 올바른 값을 입력해주세요");
	
	int i=0; int j = 1;
	String st[] = {"유동자산","유동부채","재고자산","부채","자기자본","영업이익","금융비용"};//안정성 비율 분석 시 필요한 항목들
	public static Double d_st[] = {St_ratio.currentA,St_ratio.currentL,St_ratio.inv,St_ratio.liability,St_ratio.equity,St_ratio.operationE,St_ratio.financeEx};
	String ac[] = {"매출액","매출원가","기초매출채권","매출채권","기초재고자산","재고자산"};//활동성 비율 분석 시 필요한 항목들
	public static Double d_ac[] = {Ac_ratio.sales, Ac_ratio.costofsales, Ac_ratio.s_acR, Ac_ratio.acR, Ac_ratio.s_inv, Ac_ratio.inv};
	String pr[] = {"당기순이익","매출액","기초자산","자산","자기자본"};//수익성 비율 분석 시 필요한 항목들
	public static Double d_pr[] = {Pr_ratio.earning, Pr_ratio.sales,Pr_ratio.s_asset,Pr_ratio.asset,Pr_ratio.equity}; 
	String gr[] = {"매출액","전기매출액","기초자산","자산","당기순이익","전기순이익"};//성장성 비율 분석 시 필요한 항목들
	public static Double d_gr[] = {Gr_ratio.sales,Gr_ratio.s_sales,Gr_ratio.s_asset,Gr_ratio.asset,Gr_ratio.earning,Gr_ratio.s_earning};

	public GuiCalc() {
		setTitle("기업분석프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
		
		JButton b_st= new JButton ("안정성분석"); c.add(b_st);// 버튼 부착
		b_st.addActionListener(new listener());
		JButton b_pr= new JButton ("수익성분석"); c.add(b_pr);
		b_pr.addActionListener(new listener());
		JButton b_ac= new JButton ("활동성분석"); c.add(b_ac);
		b_ac.addActionListener(new listener());
		JButton b_gr= new JButton ("성장성분석"); c.add(b_gr);
		b_gr.addActionListener(new listener());
			
		tf.addActionListener(new listener_tf());
		
		
		c.add(la);
		tf.setSize(60,10);
		c.add(tf);
		
		setSize(1000,300);
		setVisible(true);
					
	}
	class listener implements ActionListener{
		public void actionPerformed(ActionEvent e) { // 버튼 리스너 ( 제목을 분석 종류로 변경 & 텍스트필드 입력 라벨 초기값 설정)
			JButton b = (JButton)e.getSource();
		 	setTitle(b.getText());
		 	if(b.getText().equals("안정성분석")) // 라벨을 분석에 필요한 첫번쨰 항목으로 설정한다 
		 		la.setText(st[0]); 
		 	if(b.getText().equals("활동성분석"))
		 		la.setText(ac[0]);
		 	if(b.getText().equals("수익성분석"))
		 		la.setText(pr[0]);
		 	if(b.getText().equals("성장성분석"))
		 		la.setText(gr[0]);
		 	
		 }
	}
	class listener_tf implements ActionListener{ // 텍스트필드 리스너 : 초기값 입력 이후 동작 프로세스
		public void actionPerformed(ActionEvent e) {
			switch(GuiCalc.super.getTitle()) {
			case ("안정성분석") : //안정성 분석 버튼을 눌렀을 때
			try {	
				d_st[i] = Double.valueOf(tf.getText());
			}
			catch(NumberFormatException ex) { // 숫자가 아닌 값을 입력하면 받지않는다. 
				tf.setText("");
				break;
			}
				tf.setText("");
				if(j != 7) // 분석에 필요한 항목을 다 받을때까지 계속 반복
					la.setText(st[j]);
				i++; j++; //다음 항목을 받을 수 있도록 함
				if(i==7){
					St_ratio stab = new St_ratio(); //안정성비율 객체 생성
					stab.printst(); // 콘솔창에 비율 출력하는 함수 호출
					i = 0; j = 1; // 다음 분석을 이어서 할 수 있도록 초기화
					la.setText("분석 결과가 출력되었습니다.");
				}
				break;
			case ("활동성분석"):  //활동성 분석 버튼을 눌렀을 때
			try {
				d_ac[i] = Double.valueOf(tf.getText());
			}
			catch(NumberFormatException ex) {
				tf.setText("");
				break;
			}	
			tf.setText("");
				if(j != 6) 
					la.setText(ac[j]);
				i++; j++;
				if(i==6){
					Ac_ratio activ = new Ac_ratio();
					activ.printac();
					i = 0; j = 1;
					la.setText("분석 결과가 출력되었습니다.");
				}
				break;
			case ("수익성분석"): //수익성 분석 버튼을 눌렀을 때
			try {
				d_pr[i] = Double.valueOf(tf.getText());
			}
			catch(NumberFormatException ex) {
				tf.setText("");
				break;
			}
				tf.setText("");
				if(j != 5) 
					la.setText(pr[j]);
				i++; j++;
				if(i==5){
					Pr_ratio profi = new Pr_ratio();
					profi.printpr();
					i = 0; j = 1;
					la.setText("분석 결과가 출력되었습니다.");
				}
				break;	
			case ("성장성분석"): //성장성 분석 버튼을 눌렀을 때
				
				try {
					d_gr[i] = Double.valueOf(tf.getText());
				}
				catch(NumberFormatException ex) {
					tf.setText("");
					break;
				}
					tf.setText("");
				if(j != 6)
						la.setText(st[j]);
				i++; j++;
				if(i==6){
					Gr_ratio grow = new Gr_ratio();
					grow.printgr();
					i = 0; j = 1;
					la.setText("분석 결과가 출력되었습니다.");
				}
				break;
			}
		}
	}
	public static void main(String[] args) {
			GuiCalc g = new GuiCalc();
	}
}
