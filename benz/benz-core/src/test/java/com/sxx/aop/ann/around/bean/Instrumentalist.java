package com.sxx.aop.ann.around.bean;

public class Instrumentalist implements Performer {
  public void perform() {
    instrument.play();
  }

  private Instrument instrument;

  public void setInstrument(Instrument instrument) {
    this.instrument = instrument;
  }

  public Instrument getInstrument() {
    return instrument;
  }
}
