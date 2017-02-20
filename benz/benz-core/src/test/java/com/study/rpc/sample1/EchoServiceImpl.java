package com.study.rpc.sample1;

public class EchoServiceImpl implements EchoService {

	@Override
	public String echo(String ping) {
		// TODO Auto-generated method stub
		return ping != null ? ping + "--> I am ok.":"I am ok .";
	}

}
