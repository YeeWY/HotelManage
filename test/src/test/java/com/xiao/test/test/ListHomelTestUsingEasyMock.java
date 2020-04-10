package com.xiao.test.test;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class ListHomelTestUsingEasyMock {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	private IData iData = null;

	@Test
	public void testSearchWhenAllRoomIsNotEmpty() {
		iData = EasyMock.createMock("iData", IData.class);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				EasyMock.expect(iData.getStation((i + 1) * 100 + j + 1)).andReturn("EMPTY");
			}
		}

		EasyMock.replay(iData);

		ListHome listHome = new ListHome(iData);
		listHome.search();

		String lineSeperator = System.getProperty("line.separator");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				if (j + 1 < 10) {
					sb.append(i + 1 + "0" + (j + 1) + "\t");
				} else {
					sb.append(i + 1 + "" + (j + 1) + "\t");
				}
			}

			// 打印房间状态
			sb.append(lineSeperator);
			for (int j = 0; j < 12; j++) {
				sb.append("EMPTY" + "\t");
			}
			sb.append(lineSeperator);
		}
		assertEquals(sb.toString(), systemOutRule.getLog());
		EasyMock.verify(iData);
	}

	@Test
	public void testSearchWhenRoom101IsNotEmpty() {
		iData = EasyMock.createMock("iData", IData.class);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				if ((i == 0) && (j == 0)) {
					EasyMock.expect(iData.getStation(101)).andReturn("张三");
				} else {
					EasyMock.expect(iData.getStation((i + 1) * 100 + j + 1)).andReturn("EMPTY");
				}

			}
		}

		EasyMock.replay(iData);

		ListHome lh = new ListHome(iData);
		lh.search();

		String lineSeperator = System.getProperty("line.separator");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				if (j + 1 < 10) {
					sb.append(i + 1 + "0" + (j + 1) + "\t");
				} else {
					sb.append(i + 1 + "" + (j + 1) + "\t");
				}
			}

			// 打印房间状态
			sb.append(lineSeperator);
			for (int j = 0; j < 12; j++) {
				if ((i == 0) && (j == 0)) {
					sb.append("张三" + "\t");
				} else {
					sb.append("EMPTY" + "\t");
				}

			}
			sb.append(lineSeperator);
		}

		assertEquals(sb.toString(), systemOutRule.getLog());
		EasyMock.verify(iData);
	}

}