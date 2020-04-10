package com.xiao.test.test;

public class OutHotel // extends Empty
{
	// public String out(int roomNo) {
	// MainRun mr = new MainRun();
	// if (isEmpty(roomNo)) {
	//
	// return "�÷���û�п�����ס���˷�ʧ�ܣ�";
	// } else {
	// mr.getRoom()[(roomNo / 100) - 1][(roomNo % 100) - 1] = "EMPTY";
	// return roomNo + "�˷��ɹ���";
	// }

	// }
	IData iData;

	public OutHotel(IData iData) {
		this.iData = iData;
	}

	public OutHotel() {

	}

	public String out(int roomNo) {
		return iData.in_Out_Room(roomNo, "EMPTY");

	}
}