package interAc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiCalc extends JFrame {
	
	JTextField tf = new JTextField(13);
	JLabel la = new JLabel("");
	JLabel exception = new JLabel("�ٽ� �ùٸ� ���� �Է����ּ���");
	
	int i=0; int j = 1;
	String st[] = {"�����ڻ�","������ä","����ڻ�","��ä","�ڱ��ں�","��������","�������"};//������ ���� �м� �� �ʿ��� �׸��
	public static Double d_st[] = {St_ratio.currentA,St_ratio.currentL,St_ratio.inv,St_ratio.liability,St_ratio.equity,St_ratio.operationE,St_ratio.financeEx};
	String ac[] = {"�����","�������","���ʸ���ä��","����ä��","��������ڻ�","����ڻ�"};//Ȱ���� ���� �м� �� �ʿ��� �׸��
	public static Double d_ac[] = {Ac_ratio.sales, Ac_ratio.costofsales, Ac_ratio.s_acR, Ac_ratio.acR, Ac_ratio.s_inv, Ac_ratio.inv};
	String pr[] = {"��������","�����","�����ڻ�","�ڻ�","�ڱ��ں�"};//���ͼ� ���� �м� �� �ʿ��� �׸��
	public static Double d_pr[] = {Pr_ratio.earning, Pr_ratio.sales,Pr_ratio.s_asset,Pr_ratio.asset,Pr_ratio.equity}; 
	String gr[] = {"�����","��������","�����ڻ�","�ڻ�","��������","���������"};//���强 ���� �м� �� �ʿ��� �׸��
	public static Double d_gr[] = {Gr_ratio.sales,Gr_ratio.s_sales,Gr_ratio.s_asset,Gr_ratio.asset,Gr_ratio.earning,Gr_ratio.s_earning};

	public GuiCalc() {
		setTitle("����м����α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
		
		JButton b_st= new JButton ("�������м�"); c.add(b_st);// ��ư ����
		b_st.addActionListener(new listener());
		JButton b_pr= new JButton ("���ͼ��м�"); c.add(b_pr);
		b_pr.addActionListener(new listener());
		JButton b_ac= new JButton ("Ȱ�����м�"); c.add(b_ac);
		b_ac.addActionListener(new listener());
		JButton b_gr= new JButton ("���强�м�"); c.add(b_gr);
		b_gr.addActionListener(new listener());
			
		tf.addActionListener(new listener_tf());
		
		
		c.add(la);
		tf.setSize(60,10);
		c.add(tf);
		
		setSize(1000,300);
		setVisible(true);
					
	}
	class listener implements ActionListener{
		public void actionPerformed(ActionEvent e) { // ��ư ������ ( ������ �м� ������ ���� & �ؽ�Ʈ�ʵ� �Է� �� �ʱⰪ ����)
			JButton b = (JButton)e.getSource();
		 	setTitle(b.getText());
		 	if(b.getText().equals("�������м�")) // ���� �м��� �ʿ��� ù���� �׸����� �����Ѵ� 
		 		la.setText(st[0]); 
		 	if(b.getText().equals("Ȱ�����м�"))
		 		la.setText(ac[0]);
		 	if(b.getText().equals("���ͼ��м�"))
		 		la.setText(pr[0]);
		 	if(b.getText().equals("���强�м�"))
		 		la.setText(gr[0]);
		 	
		 }
	}
	class listener_tf implements ActionListener{ // �ؽ�Ʈ�ʵ� ������ : �ʱⰪ �Է� ���� ���� ���μ���
		public void actionPerformed(ActionEvent e) {
			switch(GuiCalc.super.getTitle()) {
			case ("�������м�") : //������ �м� ��ư�� ������ ��
			try {	
				d_st[i] = Double.valueOf(tf.getText());
			}
			catch(NumberFormatException ex) { // ���ڰ� �ƴ� ���� �Է��ϸ� �����ʴ´�. 
				tf.setText("");
				break;
			}
				tf.setText("");
				if(j != 7) // �м��� �ʿ��� �׸��� �� ���������� ��� �ݺ�
					la.setText(st[j]);
				i++; j++; //���� �׸��� ���� �� �ֵ��� ��
				if(i==7){
					St_ratio stab = new St_ratio(); //���������� ��ü ����
					stab.printst(); // �ܼ�â�� ���� ����ϴ� �Լ� ȣ��
					i = 0; j = 1; // ���� �м��� �̾ �� �� �ֵ��� �ʱ�ȭ
					la.setText("�м� ����� ��µǾ����ϴ�.");
				}
				break;
			case ("Ȱ�����м�"):  //Ȱ���� �м� ��ư�� ������ ��
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
					la.setText("�м� ����� ��µǾ����ϴ�.");
				}
				break;
			case ("���ͼ��м�"): //���ͼ� �м� ��ư�� ������ ��
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
					la.setText("�м� ����� ��µǾ����ϴ�.");
				}
				break;	
			case ("���强�м�"): //���强 �м� ��ư�� ������ ��
				
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
					la.setText("�м� ����� ��µǾ����ϴ�.");
				}
				break;
			}
		}
	}
	public static void main(String[] args) {
			GuiCalc g = new GuiCalc();
	}
}
