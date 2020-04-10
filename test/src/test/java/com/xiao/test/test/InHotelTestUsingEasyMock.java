package com.xiao.test.test;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Test;

public class InHotelTestUsingEasyMock {
	private IData iData = null;

	@Test
	public void testInSuccess() {
		iData = EasyMock.createMock(IData.class);
		EasyMock.expect(iData.in_Out_Room(101, "张三")).andReturn("张三成功入住101房间!");
		EasyMock.replay(iData);
		InHotel inHotel = new InHotel(iData);
		String result = inHotel.in(101, "张三");
		assertEquals("张三成功入住101房间!", result);
		EasyMock.verify(iData);
	}

	@Test
	public void testInFailure() {
		iData = EasyMock.createMock(IData.class);
		EasyMock.expect(iData.in_Out_Room(101, "张三")).andReturn("该房间已有客人入住!");
		EasyMock.replay(iData);
		InHotel inHotel = new InHotel(iData);
		String result = inHotel.in(101, "张三");
		assertEquals(result, "该房间已有客人入住!");
		EasyMock.verify(iData);
	}
}
