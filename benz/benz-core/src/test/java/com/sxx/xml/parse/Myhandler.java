package com.sxx.xml.parse;

/**
 * ��SAX����XML��Handler
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Myhandler extends DefaultHandler {
    //�洢���ڽ�����Ԫ�ص�����
    private Map<String,String> map=null;
    //�洢���н�����Ԫ�ص�����
    private List<Map<String,String>> list=null;
    //���ڽ�����Ԫ�ص�����
    String currentTag=null;
    //���ڽ�����Ԫ�ص�Ԫ��ֵ
    String currentValue=null;
    //��ʼ������Ԫ��
    String nodeName=null;
    

    public Myhandler(String nodeName) {
        // TODO Auto-generated constructor stub
        this.nodeName=nodeName;
    }
    
    public List<Map<String, String>> getList() {
        return list;
    }

    //��ʼ�����ĵ�������ʼ����XML��Ԫ��ʱ���ø÷���
    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("--startDocument()--");
        //��ʼ��Map
        list=new ArrayList<Map<String,String>>();
    }
    
    //��ʼ����ÿ��Ԫ��ʱ������ø÷���
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        // TODO Auto-generated method stub
        //�ж����ڽ�����Ԫ���ǲ��ǿ�ʼ������Ԫ��
        System.out.println("--startElement()--"+qName);
        if(qName.equals(nodeName)){
            map=new HashMap<String, String>();
        }
        
        //�ж����ڽ�����Ԫ���Ƿ�������ֵ,���������ȫ��ȡ�������浽map�����У���:<person id="00001"></person>
        if(attributes!=null&&map!=null){
            for(int i=0;i<attributes.getLength();i++){
                map.put(attributes.getQName(i), attributes.getValue(i));
            }
        }
        currentTag=qName;  //���ڽ�����Ԫ��
    }
    
    //������ÿ��Ԫ�ص�����ʱ����ô˷���
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("--characters()--");
        if(currentTag!=null&&map!=null){
            currentValue=new String(ch,start,length);
            //������ݲ�Ϊ�պͿո�Ҳ���ǻ��з��򽫸�Ԫ������ֵ�ʹ���map��
            if(currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n")){
                map.put(currentTag, currentValue);
                System.out.println("-----"+currentTag+" "+currentValue);
            }
            //��ǰ��Ԫ���ѽ������������ÿ�������һ��Ԫ�صĽ���
            currentTag=null;
            currentValue=null;
        }
    }
    
    //ÿ��Ԫ�ؽ�����ʱ�򶼻���ø÷���
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("--endElement()--"+qName);
        //�ж��Ƿ�Ϊһ���ڵ������Ԫ�ر�ǩ
        if(qName.equals(nodeName)){
            list.add(map);
            map=null;
        }
    }
    
    //���������ĵ�����������Ԫ�ؽ�����ǩʱ���ø÷���
    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("--endDocument()--");
        super.endDocument();
    }
}
