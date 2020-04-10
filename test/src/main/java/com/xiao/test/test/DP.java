package com.xiao.test.test;

public class DP implements IData {
	private static String[][] rooms;// ��ʾ����
	MainRun mr = new MainRun();

	public void iniRooms() {
		rooms = new String[10][12];
		for (int i = 0; i < rooms.length; i++) {

			for (int j = 0; j < rooms[0].length; j++) {

				rooms[i][j] = "EMPTY";

			}

		}

	}

	public String getStation(int roomNo) {
		return rooms[(roomNo / 100) - 1][(roomNo % 100) - 1];
	}

	public int roomNo(int roomNo) {
		if ("EMPTY".equals(rooms[(roomNo / 100) - 1][(roomNo % 100) - 1])) {
			return roomNo;
		} else {
			return 0;
		}
	}

	public String in_Out_Room(int roomNo, String name) {
		if (name.equals("EMPTY")) {
			if (roomNo(roomNo) == 0) {
				rooms[(roomNo / 100) - 1][(roomNo % 100) - 1] = name;
				return roomNo + "�˷��ɹ���";
			} else {
				return "�÷���û�п�����ס���˷�ʧ�ܣ�";
			}
		} else {
			if (roomNo(roomNo) == 0) {
				return "�÷����Ѿ��п�����ס��";
			} else {
				rooms[(roomNo / 100) - 1][(roomNo % 100) - 1] = name;
				return name + "�ɹ���ס" + roomNo + "���䣡";

			}
		}
	}

}
