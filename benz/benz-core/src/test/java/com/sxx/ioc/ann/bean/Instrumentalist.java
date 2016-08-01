package com.sxx.ioc.ann.bean;


public class Instrumentalist implements Performer {
  public void perform()  {
	  System.out.println("=======");
	  instrument.play();
	  System.out.println("-------");

  }

  private Instrument instrument;

  public void setInstrument(Instrument instrument) {
    this.instrument = instrument;
  }

  public Instrument getInstrument() {
    return instrument;
  }
}
