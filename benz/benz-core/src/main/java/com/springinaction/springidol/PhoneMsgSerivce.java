package com.springinaction.springidol;

public class PhoneMsgSerivce implements MsgService {


	@Override
	public void noticeMsg(NoticeDO noticeDo) {
		// TODO Auto-generated method stub
		System.out.println("phoneMsg:"+noticeDo.getName());
	}

	@Override
	public boolean paramater(NoticeDO noticeDo) {
		// TODO Auto-generated method stub
		return true;
	}

}
