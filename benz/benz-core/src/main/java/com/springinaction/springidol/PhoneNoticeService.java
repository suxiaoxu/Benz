package com.springinaction.springidol;

public class PhoneNoticeService implements MsgService {

	@Override
	public void noticeMsg(NoticeDO noticeDo) {
		// TODO Auto-generated method stub
		System.out.println("noticeMsg:"+noticeDo.getName());
	}

	@Override
	public boolean paramater(NoticeDO noticeDo) {
		// TODO Auto-generated method stub
		return false;
	}

}
