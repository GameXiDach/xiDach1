package XiDach;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class frameDangNhap extends main {

	public frameDangNhap(cai c) {

		setLayout(null);
		setSize(1200, 675);

		JLabel xidach = new JLabel("Xi Dach");
		xidach.setBounds(460, 60, 200, 50);
		xidach.setFont(new Font("", ALLBITS, 30));
		add(xidach);

		JButton dn = new JButton("Dang Nhap");
		JButton dk = new JButton("Dang Ki");

		JLabel l_tk = new JLabel("Tai Khoan");
		l_tk.setBounds(50, 200, 100, 50);
		JTextField t_tk = new JTextField(20);
		t_tk.setBounds(150, 200, 480, 50);
		add(l_tk);
		add(t_tk);

		dn.setBounds(170, 400, 100, 50);
		dk.setBounds(460, 400, 100, 50);

		JLabel l_mk = new JLabel("Mat Khau");
		l_mk.setBounds(50, 280, 100, 50);
		JPasswordField t_mk = new JPasswordField(20);
		t_mk.setBounds(150, 280, 480, 50);

		add(l_mk);
		add(t_mk);
		add(dn);
		add(dk);

		ImageIcon him = new ImageIcon(getClass().getResource("dn.jpg"));

		JLabel picture = new JLabel("");
		picture.setIcon(him);
		picture.setBounds(685, 100, 500, 400);
		add(picture);

		dn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					FileReader fr = new FileReader("informationphayer.txt");
					BufferedReader br = new BufferedReader(fr);

					int i = 0;
					String str[] = new String[5];
					while (i < 5) {
						str[i] = br.readLine();
						i++;
					}
					br.close();
					fr.close();
					int sdt = Integer.parseInt(str[2]);
					int cc = Integer.parseInt(str[3]);
					int ns = Integer.parseInt(str[4]);
					
                    // nap thong tin nguoi da da dang ki vao chuong trinh
					c.addCon(str[0], str[1], sdt, cc, ns, 100000);
					
                    // kiem tra tai khoan mat khau dang nhap
					if (str[0].equals(t_tk.getText()) && str[1].equals(t_mk.getText())) {
						new frameChucNang(c);
						dispose();
					} else {
						JLabel error = new JLabel("Sai mat khau hoac ten dang nhap ");
						add(error);
						error.setBounds(200, 145, 400, 50);
						error.setFont(new Font("tru", ALLBITS, 20));
						error.setForeground(Color.RED);
					}
				} catch (IOException er) {
					// TODO Auto-generated catch block
					er.printStackTrace();
				}
			}
		});
		dk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new frameDangKi(c);
				dispose();
			}
		});
		super.getContentPane().setBackground(Color.GRAY);
		setVisible(true);
	}
}

class frameDangKi extends main {
	public frameDangKi(cai c) {
		setLayout(null);
		setSize(1200, 675);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel l_ten = new JLabel("TEN");
		l_ten.setBounds(70, 100, 110, 40);
		JTextField t_ten = new JTextField(30);
		t_ten.setBounds(190, 100, 400, 40);
		add(l_ten);
		add(t_ten);

		JLabel l_mk = new JLabel("MA KHAU");
		l_mk.setBounds(70, 170, 110, 40);
		JTextField t_mk = new JTextField(30);
		t_mk.setBounds(190, 170, 400, 40);
		add(l_mk);
		add(t_mk);

		JLabel l_sdt = new JLabel("SO DIEN THOAI");
		l_sdt.setBounds(70, 240, 110, 40);
		JTextField t_sdt = new JTextField(20);
		t_sdt.setBounds(190, 240, 400, 40);
		add(l_sdt);
		add(t_sdt);

		JLabel l_cmnd = new JLabel("SO CHUNG MINH");
		l_cmnd.setBounds(70, 310, 110, 40);
		JTextField t_cmnd = new JTextField(20);
		t_cmnd.setBounds(190, 310, 400, 40);
		add(l_cmnd);
		add(t_cmnd);

		JLabel l_ns = new JLabel("NAM SINH");
		l_ns.setBounds(70, 380, 110, 40);
		JTextField t_ns = new JTextField(20);
		t_ns.setBounds(190, 380, 400, 40);
		add(l_ns);
		add(t_ns);

		JButton save = new JButton("SAVE");
		add(save);
		save.setBounds(570, 480, 100, 40);

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int sdt = Integer.parseInt(t_sdt.getText());
				int cmnd = Integer.parseInt(t_cmnd.getText());
				int ns = Integer.parseInt(t_ns.getText());
				c.addCon(t_ten.getText(), t_mk.getText(), sdt, cmnd, ns, 100000);
				try {
					FileOutputStream fo = new FileOutputStream("informationphayer.txt");
					PrintWriter pw = new PrintWriter(fo);
					pw.write(t_ten.getText());
					pw.write("\n");
					pw.write(t_mk.getText());
					pw.write("\n");
					pw.write(t_sdt.getText());
					pw.write("\n");
					pw.write(t_cmnd.getText());
					pw.write("\n");
					pw.write(t_ns.getText());

					pw.close();
					fo.close();

					new frameDangNhap(c);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		quaylai(c, 5);
		setVisible(true);
	}
}

class frameChucNang extends main {
	public frameChucNang(cai c) {

		setSize(1200, 675);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton batDau = new JButton("Bat Dau");
		batDau.setBounds(490, 170, 300, 60);
		JButton napTien = new JButton("Nap Tien");
		napTien.setBounds(490, 260, 300, 60);
		JButton rutTien = new JButton("Doi Thuong");
		rutTien.setBounds(490, 350, 300, 60);
		JButton show = new JButton("Xem Thong Tin Ca Nhan");
		show.setBounds(490, 440, 300, 60);
		JButton exit = new JButton("Exit");
		exit.setBounds(490, 530, 300, 60);
		ImageIcon him = new ImageIcon(getClass().getResource("cn.jpg"));
		JLabel picture = new JLabel("");
		picture.setIcon(him);
		picture.setBounds(0, 10, 1200, 650);
		
		xlsk3 x3 = new xlsk3();
		exit.addActionListener(x3);

		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new frameShowInfor(c);
				dispose();
			}
		});
		napTien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new frameNapTien(c);
				dispose();
			}
		});
		rutTien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new frameRutTien(c);
				dispose();
			}
		});
		batDau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new frameBatDau(c);
				dispose();
			}
		});
		quaylai(c, 1);
		add(batDau);
		add(napTien);
		add(rutTien);
		add(show);
		add(exit);
		add(picture);
		setVisible(true);
	}
}

class frameBatDau extends main {

	public frameBatDau(cai c) {

		setSize(1200, 675);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon him = new ImageIcon(getClass().getResource("vt.jpg"));
		JLabel picture = new JLabel("");
		picture.setIcon(him);
		picture.setBounds(0, 10, 1200, 650);
		JLabel vaiTro = new JLabel("Vai Tro");
		vaiTro.setBounds(250, 130, 120, 100);
		vaiTro.setFont(new Font("tru", ALLBITS, 20));
		vaiTro.setForeground(Color.GREEN);
		JLabel tru = new JLabel("Tru");
		tru.setBounds(250, 230, 120, 100);
		tru.setFont(new Font("tru", ALLBITS, 20));
		tru.setForeground(Color.GREEN);
		Choice choi = new Choice();
		Choice soLuongPlayer = new Choice();
		// vai tro
		choi.add("Lam Cai");
		choi.add("Lam Con");
		choi.setBounds(390, 170, 300, 330);
		choi.setSize(300, 200);
		// so tru gioi han tu 2-10
		soLuongPlayer.add("2");
		soLuongPlayer.add("3");
		soLuongPlayer.add("4");
//		soLuongPlayer.add("5");
//		soLuongPlayer.add("6");
//		soLuongPlayer.add("7");
//		soLuongPlayer.add("8");
//		soLuongPlayer.add("9");
//		soLuongPlayer.add("10");
		soLuongPlayer.setBounds(390, 270, 300, 330);

		add(vaiTro);
		add(choi);
		add(tru);
		add(soLuongPlayer);

		JButton xong = new JButton("xong");
		xong.setBounds(750, 220, 75, 65);
		add(xong);
		JButton sanSang = new JButton("San Sang");
		xong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int soTru = Integer.parseInt(soLuongPlayer.getSelectedItem());
				int varChoi = choi.getSelectedIndex();

				c.setSoTru(soTru);
				if (varChoi == 0)
					c.setIdentify(true);
				else
					c.setIdentify(false);
				add(sanSang);
				sanSang.setBounds(500, 380, 150, 50);

			}
		});
		sanSang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new frameXuLiBai(c);
				dispose();
			}
		});
		quaylai(c, 2);
		add(picture);
		setVisible(true);
	}
}

class frameShowInfor extends main {
	public frameShowInfor(cai c) {
		setLayout(null);
		setSize(1200, 675);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		try {
			FileReader fr = new FileReader("informationphayer.txt");
			BufferedReader br = new BufferedReader(fr);

			int i = 0;
			String str[] = new String[6]; // Khai bao 6 de thua o cuoi cho null
			while ((str[i] = br.readLine()) != null) {
				i++;
			}

			JLabel l_ten = new JLabel("TEN");
			l_ten.setBounds(100, 90, 200, 60);
			JLabel ten = new JLabel("");
			ten.setBounds(350, 90, 300, 60);
			l_ten.setFont(new Font("", ALLBITS, 20));
			ten.setFont(new Font("", ALLBITS, 20));
			ten.setText(str[0]);
			add(l_ten);
			add(ten);

			JLabel l_mk = new JLabel("MA KHAU");
			l_mk.setBounds(100, 160, 200, 60);
			JLabel mk = new JLabel("");
			mk.setBounds(350, 160, 300, 60);
			l_mk.setFont(new Font("", ALLBITS, 20));
			mk.setFont(new Font("", ALLBITS, 20));
			mk.setText(str[1]);
			add(l_mk);
			add(mk);

			JLabel l_sdt = new JLabel("SO DIEN THOAI");
			l_sdt.setBounds(100, 230, 200, 60);
			JLabel sdt = new JLabel("");
			sdt.setBounds(350, 230, 300, 60);
			l_sdt.setFont(new Font("", ALLBITS, 20));
			sdt.setFont(new Font("", ALLBITS, 20));
			sdt.setText(str[2]);
			add(l_sdt);
			add(sdt);

			JLabel l_cmnd = new JLabel("SO CHUNG MINH");
			l_cmnd.setBounds(100, 300, 200, 60);
			JLabel cmnd = new JLabel("");
			cmnd.setBounds(350, 300, 300, 60);
			l_cmnd.setFont(new Font("", ALLBITS, 20));
			cmnd.setFont(new Font("", ALLBITS, 20));
			cmnd.setText(str[3]);
			add(l_cmnd);
			add(cmnd);

			JLabel l_ns = new JLabel("NAM SINH");
			l_ns.setBounds(100, 370, 200, 60);
			JLabel ns = new JLabel("");
			ns.setBounds(350, 370, 300, 60);
			l_ns.setFont(new Font("", ALLBITS, 20));
			ns.setFont(new Font("", ALLBITS, 20));
			ns.setText(str[4]);
			add(l_ns);
			add(ns);

			JLabel l_money = new JLabel("TIEN ");
			l_money.setBounds(100, 440, 200, 60);
			JLabel money = new JLabel("");
			money.setBounds(350, 440, 300, 60);
			l_money.setFont(new Font("", ALLBITS, 20));
			money.setFont(new Font("", ALLBITS, 20));
			money.setText(c.tienDangCo + "VND");
			add(l_money);
			add(money);

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		quaylai(c, 6);
		setVisible(true);
	}
}

class frameRutTien extends main {

	public frameRutTien(cai c) {
		setLayout(null);
		setSize(1200, 675);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Choice menhGia = new Choice();

		JLabel l_rut = new JLabel("DOI THUONG");
		l_rut.setBounds(500, 70, 200, 40);
		l_rut.setFont(new Font("tru", ALLBITS, 25));

		JLabel chonmg = new JLabel("Chon menh gia");
		add(chonmg);
		chonmg.setBounds(200, 200, 140, 40);
		chonmg.setFont(new Font("tru", ALLBITS, 17));

		menhGia.add("100.000 = 10.000VND");
		menhGia.add("200.000 = 20.000VND");
		menhGia.add("500.000 = 50.000VND");
		menhGia.add("1.000.000 = 100.000VND");
		menhGia.setBounds(400, 210, 300, 50);
		
		JButton doi = new JButton("Doi");
		doi.setBounds(750, 200, 70, 40);

		JLabel card = new JLabel("Ma The");
		JLabel ma = new JLabel("");

		doi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				long money = 0;
				String str = "";

				if (menhGia.getSelectedIndex() == 0) {
					money = 100000;
					if (c.tienDangCo < 100000) {
						card.setVisible(false);
						str = "Khong Du Tien";
					} else {
						card.setVisible(true);
						for (int i = 0; i < 10; i++) {
							int ma = (int) (Math.random() * (10));
							str = str + ma;
						}
					}
				} else if (menhGia.getSelectedIndex() == 1) {
					money = 200000;
					if (c.tienDangCo < 200000) {
						card.setVisible(false);
						str = "Khong Du Tien";
					} else {
						card.setVisible(true);
						for (int i = 0; i < 10; i++) {
							int ma = (int) (Math.random() * (10));
							str = str + ma;
						}
					}
				} else if (menhGia.getSelectedIndex() == 2) {
					money = 500000;
					if (c.tienDangCo < 500000) {
						card.setVisible(false);
						str = "Khong Du Tien";
					} else {
						card.setVisible(true);
						for (int i = 0; i < 10; i++) {
							int ma = (int) (Math.random() * (13));
							str = str + ma;
						}
					}
				} else if (menhGia.getSelectedIndex() == 3) {
					money = 1000000;
					if (c.tienDangCo < 1000000) {
						card.setVisible(false);
						str = "Khong Du Tien";
					} else {
						card.setVisible(true);
						for (int i = 0; i < 10; i++) {
							int ma = (int) (Math.random() * (13));
							str = str + ma;
						}
					}
				}
				add(card);
				add(ma);
				card.setBounds(300, 400, 100, 40);
				ma.setBounds(400, 400, 300, 40);
				ma.setFont(new Font("", ALLBITS, 20));
				ma.setForeground(Color.RED);
				card.setFont(new Font("", ALLBITS, 20));
				ma.setText(str);
				c.rutTien(money);
			}
		});
		add(doi);
		add(l_rut);
		add(menhGia);
		quaylai(c, 8);
		setVisible(true);
		
	}
}

class frameNapTien extends main {
	public frameNapTien(cai c) {

		setLayout(null);
		setSize(1200, 675);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Choice menhGia = new Choice();
		JLabel l_nap = new JLabel("NAP TIEN");
		l_nap.setBounds(500, 70, 150, 40);
		l_nap.setFont(new Font("", ALLBITS, 25));

		JLabel chonmg = new JLabel("Chon menh gia");
		add(chonmg);
		chonmg.setBounds(200, 200, 140, 40);
		chonmg.setFont(new Font("", ALLBITS, 17));

		menhGia.add("10.000VND");
		menhGia.add("20.000VND");
		menhGia.add("50.000VND");
		menhGia.add("100.000VND");
		menhGia.add("200.000VND");
		menhGia.add("500.000VND");
		menhGia.setBounds(400, 210, 300, 50);

		add(l_nap);
		add(menhGia);
		JButton nap = new JButton("Nap");
		JLabel l_nhap = new JLabel("Ma The");
		JTextField t_nhap = new JTextField(10);
		JButton xong = new JButton("Xong");
		xong.setBounds(750, 200, 100, 40);
		xong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				add(l_nhap);
				add(t_nhap);
				l_nhap.setBounds(200, 300, 100, 40);
				l_nhap.setFont(new Font("", ALLBITS, 17));
				t_nhap.setBounds(400, 300, 300, 40);
				add(nap);
				nap.setBounds(750, 300, 100, 40);
			}
		});

		nap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				long money = 0;
				if (menhGia.getSelectedIndex() == 0)
					money = 10000;
				else if (menhGia.getSelectedIndex() == 1)
					money = 20000;
				else if (menhGia.getSelectedIndex() == 2)
					money = 50000;
				else if (menhGia.getSelectedIndex() == 3)
					money = 100000;
				else if (menhGia.getSelectedIndex() == 4)
					money = 200000;
				else if (menhGia.getSelectedIndex() == 5)
					money = 500000;
				String tien = money + "";
				JLabel success = new JLabel("Nap Thanh Cong");
				if (t_nhap.getText().length() > 9) {
					add(success);
					success.setBounds(450, 450, 300, 50);
					success.setFont(new Font("", ALLBITS, 20));
					success.setForeground(Color.RED);
					// TODO Auto-generated method stub
					try {
						FileOutputStream fo = new FileOutputStream("naptien.txt");
						PrintWriter pw = new PrintWriter(fo);
						pw.write(t_nhap.getText() + "\t");
						pw.write(tien);
						pw.close();
						fo.close();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					c.napTien(money);
				}
			}
		});
		add(xong);
		quaylai(c, 7);
		setVisible(true);
	}

}

class frameXuLiBai extends main {

	ImageIcon him = new ImageIcon(getClass().getResource("ban.jpg"));
	JLabel picture = new JLabel("");

	public frameXuLiBai(cai c) {

		setSize(1200, 675);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		try {
			chiaBai(c);
			quaylai(c, 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nen(c);
	}

	public static long money;
	public void chiaBai(cai c)  {

		JButton chiaBai = new JButton("Chia bai");

		if (c.isIdentify() == true) {
			chiaBai.setBounds(510, 300, 120, 50);
			add(chiaBai);
			try {
				chiaBai.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						c.chiabai(1000);
						chiaBaiv1(c);
						khuiAll(c);
						xemBai(c);
						bot(c);
						resetBai(c);
						nen(c);
						chiaBai.setVisible(false);
					}
				});
			} catch (NullPointerException e) {
				JLabel error = new JLabel("Khong Du Tien");
				add(error);
				error.setBounds(600, 180, 150, 40);

			}

		} else
		// con chia bai co tien cuoc
		{
			JButton tienCuoc = new JButton("Dat Cuoc");
			tienCuoc.setBounds(400, 350, 120, 50);
			Choice tien = new Choice();

			tien.add("5000VND");
			tien.add("10000VND");
			tien.add("20000VND");
			tien.add("50000VND");
			tien.add("100000VND");
			tien.add("200000VND");
			tien.add("1000000VND");

			tien.setBounds(530, 360, 120, 50);

			add(tienCuoc);
			add(tien);
			add(chiaBai);
			tienCuoc.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int vttien = tien.getSelectedIndex();
					if (vttien == 0)
						money = 5000;
					else if (vttien == 1)
						money = 10000;
					else if (vttien == 2)
						money = 20000;
					else if (vttien == 3)
						money = 50000;
					else if (vttien == 4)
						money = 100000;
					else if (vttien == 5)
						money = 200000;
					else if (vttien == 6)
						money = 1000000;
					chiaBai.setBounds(510, 300, 120, 50);
					tien.setVisible(false);
					tienCuoc.setVisible(false);

				}
			});

			try {
				chiaBai.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						c.chiabai(money);
						chiaBaiv1(c);
						khuiAll(c);
						xemBai(c);
						resetBai(c);
						bot(c);
						nen(c);
						chiaBai.setVisible(false);
					}
				});
			} catch (NullPointerException e) {
				JLabel error = new JLabel("Khong Du Tien");
				add(error);
				error.setBounds(430, 170, 150, 40);
			}
		}
	}

	public void resetBai(cai c) {

		JButton reset = new JButton("Reset");
		reset.setBounds(800, 435, 100, 40);
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < c.soTru; i++)
					c.dscon[i] = null;
				new frameXuLiBai(c);
				dispose();
			}
		});
		add(reset);
	}

	// tim cac la bai de tra ve ten la do
	public String anhBai(int m, int n, cai c) {
		String str = "";
		switch (c.dscon[m].dsLa[n]) {
		case 1:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "a1.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "a2.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "a3.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "a4.png";
		case 2:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "21.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "22.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "23.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "24.png";
		case 3:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "31.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "32.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "33.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "34.png";
		case 4:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "41.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "42.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "43.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "44.png";
		case 5:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "51.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "52.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "53.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "54.png";
		case 6:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "61.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "62.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "63.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "64.png";
		case 7:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "71.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "72.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "73.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "74.png";
		case 8:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "81.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "82.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "83.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "84.png";
		case 9:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "91.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "92.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "93.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "94.png";
		case 10:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "101.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "102.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "103.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "104.png";
		case 11:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "j1.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "j2.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "j3.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "j4.png";
		case 12:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "q1.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "q2.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "q3.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "q4.png";
		case 13:
			if (c.dscon[m].typeLa[n] == 1)
				return str = "k1.png";
			else if (c.dscon[m].typeLa[n] == 2)
				return str = "k2.png";
			else if (c.dscon[m].typeLa[n] == 3)
				return str = "k3.png";
			else if (c.dscon[m].typeLa[n] == 4)
				return str = "k4.png";
		}
		return str;
	}

	// chia bai (hien thi la bai)
	public void chiaBaiv1(cai c) {

		ImageIcon him = new ImageIcon(getClass().getResource("baiup.jpg"));
		int player = c.getSoTru();
		try {
			for (int i = 0; i < player; i++) // de lay tung con
			{
				int tmp = 0;
				int n = c.dscon[i].soLa; // lay so la
				int x = 300, y = 495, dl = 103, rl = 140, add = 0, add2 = 0; // reset lai la vi tri
				for (int j = 0; j < n; j++) // chia bai theo so la
				{
					JLabel la = new JLabel(him);
					// 2 tru
					if (player == 2) {
						// la o tru chan
						if (i % 2 == 0) {
							add(la);
							la.setBounds(x + add, y, dl, rl);
							latBai(x + add, y, dl, rl, i, j, c); // lat tung la bai
						}
						// la tru le
						else {
							add(la);
							la.setBounds(x + add, 0, dl, rl);
							if (tmp == 0) // cai dat 1 lan khui
							{
								khuiEach(x + 50, 0 + rl + 10, i, c);
								tmp++;
							}

						}
						add = add + 108;
					}
					// 3 tru
					if (player == 3) {
						if (i < 2) {
							if (i % 2 == 0) {
								add(la);
								la.setBounds(x + add, y, dl, rl);
								latBai(x + add, y, dl, rl, i, j, c);
							} else {
								add(la);
								la.setBounds(x + add, 0, dl, rl);
								if (tmp == 0) // cai dat 1 lan khui
								{
									khuiEach(x + 50, 0 + rl + 10, i, c);
									tmp++;
								}

							}
							add = add + 108;
						} else if (i >= 2) {
							add(la);
							la.setBounds(0 + add2, 230, dl, rl);
							if (tmp == 0) // cai dat 1 lan khui
							{
								khuiEach(dl + dl + 30, 230 + rl + 10, i, c);
								tmp++;
							}
							add2 = add2 + 108;
						}
					}
					// 4 tru
					if (player == 4) {
						if (i < 2) {
							if (i % 2 == 0) {
								add(la);
								la.setBounds(x + add, y, dl, rl);
								latBai(x + add, y, dl, rl, i, j, c);
							} else {
								add(la);
								la.setBounds(x + add, 0, dl, rl);
								if (tmp == 0) // cai dat 1 lan khui
								{
									khuiEach(x + 50, 0 + rl + 10, i, c);
									tmp++;
								}

							}
							add = add + 108;
						} else if (i >= 2) {
							if (i % 2 == 0) {
								add(la);
								la.setBounds(0 + add2, 230, dl, rl);
								if (tmp == 0) // cai dat 1 lan khui
								{
									khuiEach(dl + dl + 30, 230 + rl + 10, i, c);
									tmp++;
								}

							} else {
								add(la);
								la.setBounds(650 + add2, 230, dl, rl);
								if (tmp == 0) // cai dat 1 lan khui
								{
									khuiEach(650 - 80, 230 + rl + 10, i, c);
									tmp++;
								}
							}
							add2 = add2 + 108;
						}
					}
				}
			}
		} catch (NullPointerException e) {
			JLabel error = new JLabel("Khong Du Tien");
			add(error);
			error.setBounds(400, 200, 150, 40);
			error.setFont(new Font("tru", ALLBITS, 15));
			error.setForeground(Color.RED);
		}
	}

// lat 1 la bai cai
	private void latBai(int a, int b, int k, int d, int m, int n, cai c) {

		JButton latBai1 = new JButton("");
		add(latBai1);
		latBai1.setBounds(a, b, k, d);

		String str = anhBai(m, n, c);
		latBai1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ImageIcon him = new ImageIcon(getClass().getResource(str));
					latBai1.setIcon(him);
				} catch (Exception a) {
					System.out.println(a.getMessage() + "loi chua co bai");
				}
			}
		});
	}

// khui nha
	public static int increv2 = 0;

	private void khuiEach(int m, int n, int vt, cai c) {

		// chi co cai co quyen su dung chuc nang nay
		if (c.isIdentify() == true) {
			JButton Khui = new JButton("Khui");
			Khui.setBounds(m, n, 67, 40);

			JLabel hienThiCon = new JLabel(" ");
			hienThiCon.setBounds(480, 280, 200, 40);
			add(Khui);
			Khui.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Khui.setVisible(false);
						if (vt != 0) {

							c.conBotv1(vt);
							c.khui(vt);
						}

					} catch (Exception a) {
						System.out.println("loi chua co bai");
					}
						hienThiCon(vt, c);
						nen(c);
				}
			});
		}
	}

	JLabel xemTien = new JLabel(" ");
	public void nen(cai c) {
		
		ImageIcon him1 = new ImageIcon(getClass().getResource("user.jpg"));
		JLabel picture1 = new JLabel("");
		picture1.setIcon(him1);
		picture1.setBounds(0, 520, 80, 80);
		add(picture1);

		JLabel tenuser = new JLabel("");
		tenuser.setText(c.getTen());
		tenuser.setBounds(5, 490, 60, 40);
		add(tenuser);
		
		xemTien.setText(c.tienDangCo + "VND");
		add(xemTien);
		xemTien.setFont(new Font("", ALLBITS, 20));
		xemTien.setBounds(10, 600, 150, 50);
		
		picture.setIcon(him);
		picture.setBounds(-90, 0, 1400, 635);
		add(picture);
		setVisible(true);

	}


// su dung khi khui
	public int add;
	public void hienThiCon(int vt, cai c) {
		add = 0;
		for (int i = 0; i < c.dscon[vt].soLa; i++) {

			int x = 300;
			String str = anhBai(vt, i, c);
			ImageIcon him = new ImageIcon(getClass().getResource(str));
			int rl = 140, dl = 103;
			JLabel la = new JLabel(him);
			JButton bla = new JButton(him);
			add(bla);
			if (vt == 0)
				bla.setBounds(x + add, 495, dl, rl);
			else if (1 == vt)
				bla.setBounds(x + add, 0, dl, rl);
			else if (vt == 2)
				bla.setBounds(0 + add, 230, dl, rl);
			else if (vt == 3)
				bla.setBounds(650 + add, 230, dl, rl);

			bla.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					add(la);
					if (vt == 0)
						la.setBounds(x + add, 495, dl, rl);
					else if (1 == vt)
						la.setBounds(x + add, 0, dl, rl);
					else if (vt == 2)
						la.setBounds(0 + add, 230, dl, rl);
					else if (vt == 3)
						la.setBounds(650 + add, 230, dl, rl);

				}
			});
			add = add + 108;
		}
	}

	// khui nhiu con
	private void khuiAll(cai c) {
		JButton khuiHet = new JButton("Khui het");
		khuiHet.setBounds(690, 435, 100, 40);
		add(khuiHet);
		khuiHet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					c.conBot();
					for (int i = 0; i < c.soTru; i++) {
						hienThiCon(i, c);
					}

					// neu la cai khui het bai con lai chua duoc khui
					if (c.isIdentify() == true)
						c.khuihet();
					else
						c.win(0);
				
				
				} catch (Exception a) {
					System.out.println(a.getMessage());
				}
					nen(c);
					khuiHet.setVisible(false);
			}
		});
	}

// xem bai
	private void xemBai(cai c) {

		JButton xem = new JButton("Xem bai");
		xem.setBounds(350, 435, 110, 50);
		xem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hienThiCon(0, c);
			}
		});
		add(xem);

	}

	// hien thi bot cho cai
	public void add(int m, int n, int x, int y, cai c) {
		String str = anhBai(m, n, c);
		ImageIcon him = new ImageIcon(getClass().getResource(str));
		int dl = 103, rl = 140;
		JLabel la = new JLabel(him);
		JButton bla = new JButton(him);
		add(bla);
		bla.setBounds(x + dl + dl + 7, y, dl, rl);
		bla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				add(la);
				la.setBounds(x + dl + dl + 7, y, dl, rl);
			}
		});
	}

	// bot bai
	public int incre = 0;
	private void bot(cai c) {
		JButton bot = new JButton("bot");
		bot.setBounds(600, 435, 65, 40);
		bot.setBackground(Color.green);
		bot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

					c.bot(0);
					int i = c.dscon[0].soLa;
					int x = 300, y = 495;
					add(0, i - 1, x + incre, y, c); // goi ham them la
					incre = incre + 113;
			}
		});
		add(bot);
	}
}

class xlsk3 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}

