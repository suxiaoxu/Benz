package com.springinaction.springidol;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;


public class MsgExecute {
	
	private Map<Integer,MsgService> msgset;
	
	/*public boolean executMsg(List<TypeEnum> list,NoticeDO noticeDo){
		for(TypeEnum type:list){
			MsgService msgservice = (MsgService)msgset.get(type.getNum());
			if(!msgservice.paramater(noticeDo)){
				continue;
			}
			msgservice.noticeMsg(noticeDo);
		}
		return true;
	}*/
	public boolean executMsg(EnumSet<TypeEnum> setln,NoticeDO noticeDo){
		for(TypeEnum type:setln){
			MsgService msgservice = (MsgService)msgset.get(type.getNum());
			if(!msgservice.paramater(noticeDo)){
				continue;
			}
			msgservice.noticeMsg(noticeDo);
		}
		return true;
	}

	public Map<Integer, MsgService> getMsgset() {
		return msgset;
	}

	public void setMsgset(Map<Integer, MsgService> msgset) {
		this.msgset = msgset;
	}
	
	
}
