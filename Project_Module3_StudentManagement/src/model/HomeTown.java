package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class HomeTown implements Serializable{
	private int homeTomnID;
	private String province;

	public HomeTown(int homeTomnID, String province) {
		this.homeTomnID = homeTomnID;
		this.province = province;
	}

	public int getHomeTomnID() {
		return homeTomnID;
	}

	public void setHomeTomnID(int homeTomnID) {
		this.homeTomnID = homeTomnID;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "HomeTown{" + "homeTomnID=" + homeTomnID + ", province='" + province + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof HomeTown homeTown))
			return false;
		return getHomeTomnID() == homeTown.getHomeTomnID() && Objects.equals(getProvince(), homeTown.getProvince());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getHomeTomnID(), getProvince());
	}

//    Tạo list tỉnh thành
	public static ArrayList getProvinceList() {
		String[] arr_province = { "An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Thành phố Hồ Chí Minh",
				"Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng",
				"Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
				"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
				"Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long",
				"Vĩnh Phúc", "Yên Bái" };

		ArrayList listProvince = new ArrayList();
		int i = 1;
		for (String provinceName : arr_province) {
			HomeTown t = new HomeTown(i, provinceName);
			listProvince.add(t);
		}
		return listProvince;
	}



	public static HomeTown getProvinceById(int homeTown) {
		// TODO Auto-generated method stub
		return (HomeTown) HomeTown.getProvinceList().get(homeTown);

	}

	public static HomeTown getProvinceByName(String provinceNames) {
			ArrayList<HomeTown> listProvince = HomeTown.getProvinceList();
			for (HomeTown provinceName : listProvince) {
				if(provinceName.province.equalsIgnoreCase(provinceNames)) {
					return provinceName;
				}
			}
		return null;
	}

}
