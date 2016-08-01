package com.springinaction.springidol;

import static java.lang.System.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:com/springinaction/springidol/spring-idol.xml" })
public class IdolTest {

  @BeforeClass
  public static void setup() {
    setProperty("STANS_SONG", "Total Eclipse of the Heart");
  }

  @Autowired
  ApplicationContext context;
  
  @Test
  public void testEnumSet() throws PerformanceException{
	  MsgExecute msgExecute = (MsgExecute)context.getBean("execute");
	  /*List<TypeEnum> typeEnums = new ArrayList<TypeEnum>();
	  typeEnums.add(TypeEnum.MSG);
	  typeEnums.add(TypeEnum.PHONE);*/
	  NoticeDO sn = new NoticeDO();
	  sn.setName("xiaoxu");
	  sn.setAge("14");
	  EnumSet<TypeEnum> typeEnums = EnumSet.of(TypeEnum.MSG,TypeEnum.PHONE);
	  msgExecute.executMsg(typeEnums,sn);
	  
  }
  
  
  @Test
  public void testPergormer() throws PerformanceException{
	  Performer performer = (Performer)context.getBean("duke");
	  performer.perform();
  }
  
  @Test
  public void testPoeticDuke() throws PerformanceException{
	  Performer duck = (Performer)context.getBean("poeticDuke");
	  duck.perform();
  }

  @Test
  public void carlShouldBeWiredWithKennysSong() {
    Instrumentalist kenny = (Instrumentalist) context.getBean("kenny");
    Instrumentalist carl = (Instrumentalist) context.getBean("carl");
    assertEquals(kenny.getSong(), carl.getSong());
  }

  @Test
  public void stanShouldBeWiredWithSongFromSystemProperties() {
    Instrumentalist stan = (Instrumentalist) context.getBean("stan");
    assertEquals("Total Eclipse of the Heart", stan.getSong());
  }

  @Test
  public void rickyShouldBeWiredWithSongFromSongBook() {
    Instrumentalist ricky = (Instrumentalist) context.getBean("ricky");
    assertEquals("That Old Black Magic", ricky.getSong());
  }

}
