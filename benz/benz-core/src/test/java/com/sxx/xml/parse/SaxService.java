package com.sxx.xml.parse;

/**
 * ��װ����ҵ����
 */

import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SaxService {
    
    public static List<Map<String,String>> ReadXML(String uri,String NodeName){
        try {
            //����һ������XML�Ĺ�������
            SAXParserFactory parserFactory=SAXParserFactory.newInstance();
            //����һ������XML�Ķ���
            SAXParser parser=parserFactory.newSAXParser();
            //����һ������������
            Myhandler myhandler=new Myhandler("stu");
            parser.parse(uri, myhandler);
            return myhandler.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            
        }
        return null;
        
    }
}
