package kr.or.ddit.basetech.apater.homework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
class RoomKSTTest {

	@Test
	void testRoomKST() {
		PluggubleKST plug = new SamsungProduct();
		ConcentKST concent = new ConcentKST();
		RoomKST room = new RoomKST(concent);
		room.callConcent(plug);
	}
}
