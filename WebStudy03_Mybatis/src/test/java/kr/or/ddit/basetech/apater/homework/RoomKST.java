package kr.or.ddit.basetech.apater.homework;

public class RoomKST {
	public final ConcentKST concent;

	public RoomKST(ConcentKST concent) {
		super();
		this.concent = concent;
	}
	public void callConcent(PluggubleKST plug) {
		concent.plugIn(plug);
	}
}
