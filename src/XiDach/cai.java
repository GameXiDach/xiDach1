package XiDach;

import java.util.*;

public class cai extends conn {

	protected  static boolean identify;
	public  int soTru; // so nguoi choi
	private long tienNhaCai = 100000L; // tien mac dinh nha cai
	public conn[] dscon; // mang luu cac tru
	private ArrayList opened = new ArrayList(); // luu cac la bai da mo
	

	public void taoDSCon(int tru) {
		dscon = new conn[tru];
	}

	// lay 1 la bai bat ki trong bo bai
	public int LayBai() {
		int laBai = (int) (Math.random() * (13)) + 1;
		return laBai;
	}

	public void chiabai(long tien) {
		tiencuoc = tien;
		taoDSCon(soTru);
		int index = 0;
		int n = (soTru * 2);

		// rang buoc tien cai
		if (tienNhaCai <= tienDangCo) // chua xu li
		{
			for (int i = 0; i < n; i++) {
				// tao danh sach con, n con
				if (i < soTru)
					dscon[i] = new conn();

				// lay n la bai bo vao danh sach den vi tri n - 1
				int laBai = LayBai();
				if (soTru > i) {
					dscon[i].addBai(laBai);
				}
				// tu la n den het bo lai vao danh dach tu 0 den n-1
				else {
					dscon[index].addBai(laBai);
					index++;
				}
			}
		} else
			System.out.println("Khong du tien");
	}

	public void bot(int vt) {
		dscon[vt].addBai(LayBai());
	}
    // su dung o ham khui het
	public void conBot() {
			int n = soTru;
			int i = 1;
			conBotv1(n, i); // bot tu cai i den n
	}

	// bot o vi tri vi tri i
	public void conBotv1(int i) {
		while (tinhDiem(i) < 16  && dscon[i].soLa < 5) { // xi danh khong bot, xi bang khong bot
			if (((dscon[i].dsLa[0] == 1 && (dscon[i].dsLa[1] == 10 || dscon[i].dsLa[1] == 11 || dscon[i].dsLa[1] == 12
					|| dscon[i].dsLa[1] == 13))
					|| (dscon[i].dsLa[1] == 1 && (dscon[i].dsLa[0] == 10 || dscon[i].dsLa[0] == 11
							|| dscon[i].dsLa[0] == 12 || dscon[i].dsLa[0] == 13)))
					|| ((dscon[i].dsLa[0] == 1) && (dscon[i].dsLa[1] == 1))) {
			} else
				bot(i);
		}
	}

	// chua du diem bot het
	public void conBotv1(int n, int m) {
		for (int i = m; i < n; i++) {
			while (tinhDiem(i) < 16 && dscon[i].soLa < 5) { // xi danh khong bot
				if (((dscon[i].dsLa[0] == 1 && (dscon[i].dsLa[1] == 10 || dscon[i].dsLa[1] == 11
						|| dscon[i].dsLa[1] == 12 || dscon[i].dsLa[1] == 13))
						|| (dscon[i].dsLa[1] == 1 && (dscon[i].dsLa[0] == 10 || dscon[i].dsLa[0] == 11
								|| dscon[i].dsLa[0] == 12 || dscon[i].dsLa[0] == 13)))
						|| ((dscon[i].dsLa[0] == 1) && (dscon[i].dsLa[1] == 1))) {
				} else
					bot(i);
			}
		}
	}

	// khui 1 la
	public void khui(int vt) {
		win(vt);
		opened.add(vt); // danh dau vi tri nao da khui

	}

	// khui het tat ca bai
	public void khuihet() {
		for (int i = 1; i < soTru; i++) {
			// neu la cai
			if (identify == true) 
				{  // duyet cac la bai chua duoc khui de khui
					for (int j = 0; j < opened.size(); j++)
						if ((int) opened.get(j) == i)
							i = i + 1;
					win(i);
				}
		}
		// reset mang da khui bai cho lan choi ke tiep
		opened.clear();
	}
    // so sanh bai
	public long win(int vt) {

		int nhaCon;
		if (identify == true)
			 nhaCon = vt;
		else 
			 nhaCon = soTru-1;
		 int nhaCai = 0;
		 long tienCon = tiencuoc;
		 int pointCai = tinhDiem(nhaCai);
		 int pointCon = tinhDiem(nhaCon);

		// xi bang
		// xi bang nha cai
		if ((dscon[nhaCai].dsLa[0] == 1 && dscon[nhaCai].dsLa[1] == 1)
				&& !((dscon[nhaCon].dsLa[0] == 1 && dscon[nhaCon].dsLa[1] == 1)))
			return tienDangCo = tienDangCo + tienCon;
		// xi bang nha con
		if ((dscon[nhaCon].dsLa[0] == 1 && dscon[nhaCon].dsLa[1] == 1)
				&& !((dscon[nhaCai].dsLa[0] == 1 && dscon[nhaCai].dsLa[1] == 1)))
			return tienDangCo = tienDangCo - tienCon;

		// xi dach nha cai
		// la 1 xi, la 2 10
		if (dscon[nhaCai].dsLa[0] == 1
				&& (dscon[nhaCai].dsLa[1] == 10 || dscon[nhaCai].dsLa[1] == 11 || dscon[nhaCai].dsLa[1] == 12
						|| dscon[nhaCai].dsLa[1] == 13)
				&& !(dscon[nhaCon].dsLa[0] == 1 && (dscon[nhaCon].dsLa[1] == 10 || dscon[nhaCon].dsLa[1] == 11
						|| dscon[nhaCon].dsLa[1] == 12 || dscon[nhaCon].dsLa[1] == 13)))
			return tienDangCo = tienDangCo + tienCon;

		// la dau 10 , la thu 2 xi
		if (dscon[nhaCai].dsLa[1] == 1
				&& (dscon[nhaCai].dsLa[0] == 10 || dscon[nhaCai].dsLa[0] == 11 || dscon[nhaCai].dsLa[0] == 12
						|| dscon[nhaCai].dsLa[0] == 13)
				&& !(dscon[nhaCon].dsLa[1] == 1 && (dscon[nhaCon].dsLa[0] == 10 || dscon[nhaCon].dsLa[0] == 11
						|| dscon[nhaCon].dsLa[0] == 12 || dscon[nhaCon].dsLa[0] == 13)))
			return tienDangCo = tienDangCo + tienCon;

		// xi dach nha con
		// la 1 xi, la 2 10
		if (dscon[nhaCon].dsLa[0] == 1
				&& (dscon[nhaCon].dsLa[1] == 10 || dscon[nhaCon].dsLa[1] == 11 || dscon[nhaCon].dsLa[1] == 12
						|| dscon[nhaCon].dsLa[1] == 13)
				&& !(dscon[nhaCai].dsLa[0] == 1 && (dscon[nhaCai].dsLa[1] == 10 || dscon[nhaCai].dsLa[1] == 11
						|| dscon[nhaCai].dsLa[1] == 12 || dscon[nhaCai].dsLa[1] == 13)))
			return tienDangCo = tienDangCo + tienCon;

		// la dau 10 , la thu 2 xi
		if (dscon[nhaCon].dsLa[1] == 1
				&& (dscon[nhaCon].dsLa[0] == 10 || dscon[nhaCon].dsLa[0] == 11 || dscon[nhaCon].dsLa[0] == 12
						|| dscon[nhaCon].dsLa[0] == 13)
				&& !(dscon[nhaCai].dsLa[1] == 1 && (dscon[nhaCai].dsLa[0] == 10 || dscon[nhaCai].dsLa[0] == 11
						|| dscon[nhaCai].dsLa[0] == 12 || dscon[nhaCai].dsLa[0] == 13)))
			return tienDangCo = tienDangCo + tienCon;

		// ngu linh
		// linh nha cai
		if ((dscon[nhaCai].soLa == 5 && pointCai < 22) && !(dscon[nhaCon].soLa == 5 && pointCon < 22))
			return tienDangCo = tienDangCo + tienCon;
		// linh nha con
		if ((dscon[nhaCon].soLa == 5 && pointCon < 22) && !(dscon[nhaCai].soLa == 5 && nhaCai < 22))
			return tienDangCo = tienDangCo - tienCon;

		// ca 2 ngu linh
		if ((dscon[nhaCon].soLa == 5 && pointCon < 22) && (dscon[nhaCai].soLa == 5 && nhaCai < 22)) {
			if (pointCai < pointCon)
				return tienDangCo = tienDangCo + tienCon;
			else if (pointCai > pointCon)
				return tienDangCo = tienDangCo - tienCon;
		}
		
		// so sanh trong khoang diem
		if (((pointCai > 14) && (pointCai < 22)) && ((pointCon > 15) && (pointCon < 22))) {
			if (pointCai > pointCon)
				return tienDangCo = tienDangCo + tienCon;
			else if (pointCai < pointCon)
				return tienDangCo = tienDangCo - tienCon;
		}
		
		// quat
		if ((pointCai > 21) && ((pointCon > 15) && (pointCon < 22)))
			return tienDangCo = tienDangCo - tienCon;
		if ((pointCon > 21) && ((pointCai > 14) && (pointCai < 22)))
			return tienDangCo = tienDangCo + tienCon;
		
		// bai non
		if ((pointCai < 15) && ((pointCon > 15) && (pointCon < 22)))
			return tienDangCo = tienDangCo - tienCon;
//		if ((pointCon < 16) && ((pointCai > 14) && (pointCai < 22)))
//			return tienDangCo = tienDangCo + tienCon;

		return tienDangCo;
	}

	private int tinhDiem(int vt) {

		int index = dscon[vt].soLa;
		int sumpoint = 0;
		for (int i = 0; i < index; i++) {
			sumpoint = sumpoint + doiBai(dscon[vt].dsLa[i]);
		}
		return sumpoint;
	}
	public static boolean isIdentify() {
		return identify;
	}

	public static void setIdentify(boolean identify) {
		cai.identify = identify;
	}

	public int getSoTru() {
		return soTru;
	}

	public void setSoTru(int soTru) {
		this.soTru = soTru;
	}

}

//class myException extends Exception {
//	public myException(String str) {
//		super("Loi chia bai4");
//	}
//}


