package XiDach;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class main extends JFrame {

	public static void main(String[] args) {
		cai c = new cai();
		new frameDangNhap(c);

	}
	public void quaylai(cai c, int frame) {

		JButton quaylai = new JButton("quay lai");
		quaylai.setBackground(Color.MAGENTA);
		quaylai.setBounds(0, 8, 80, 50);
		quaylai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(frame == 1)
					new frameDangNhap(c);
				else if(frame == 2)
				   new frameChucNang(c);
				else if(frame == 3)
					new frameBatDau(c);
				else if(frame == 5)
					new frameDangNhap(c);
				else if(frame == 6)
					new frameChucNang(c);
				else if(frame == 7)
					new frameChucNang(c);
				else if(frame == 8)
					new frameChucNang(c);
				dispose();
			}
		});
		add(quaylai);
	}
}


