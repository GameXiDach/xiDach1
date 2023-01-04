package XiDach;

public class conn {
	protected  static long tienDangCo ;
	protected  long tiencuoc;
	private    String ten ;
	private    String mk;
	protected  int cccd;
	protected  int sdt;
	protected  int namSinh;
	protected  int soLa = 0;
	protected  int[] dsLa = new int[10]; // mang luu gia tri la bai 
	protected  int[] typeLa = new int[10]; // mang luu loai la bai (bich-4, chuong-3, ro-2, co-1)
 
	public  void addBai(int La) {
		dsLa[soLa] = La;
		typeLa[soLa] = typela();
		soLa++;
	}

	public static int typela() {
		int laBai = (int) (Math.random() * (4)) + 1;
		return laBai;
	}
	
    // doi cac la J, Q, K va gia tri dac biet la A
	protected int doiBai(int a) {
		if (a == 1) {
			if (soLa == 2)
				return 11;
			if (soLa == 3)
				return 11;
			if (soLa == 4)
				return 1;
			if (soLa == 5)
				return 1;
		}
		if (a == 11)
			return 10;
		if (a == 12)
			return 10;
		if (a == 13)
			return 10;
		return a;
	}
	
	public String doiBai2(int a) {
		switch (a) {
		case 1:
			return "a";
		case 2:
			return 2 + "";
		case 3:
			return 3 + "";
		case 4:
			return 4 + "";
		case 5:
			return 5 + "";
		case 6:
			return 6 + "";
		case 7:
			return 7 + "";
		case 8:
			return 8 + "";
		case 9:
			return 9 + "";
		case 10:
			return 10 + "";
		case 11:
			return "j";
		case 12:
			return "q";
		case 13:
			return "k";
		}
		return " ";
	}

	public void napTien(long tien) {
         tienDangCo = tienDangCo + tien;
	}

	public void rutTien(long tien) {
		if(tienDangCo >= tien)
			tienDangCo = tienDangCo - tien;
	}

	public void addCon(String ten, String mk, int sdt, int cccd, int namSinh, long tienDangCo ) {
          this.ten = ten;
          this.mk = mk;
          this.sdt = sdt;
          this.cccd = cccd;
          this.namSinh = namSinh;
          this.tienDangCo = tienDangCo;
	}
	
	public String getTen() {
		return ten;
	}

}


