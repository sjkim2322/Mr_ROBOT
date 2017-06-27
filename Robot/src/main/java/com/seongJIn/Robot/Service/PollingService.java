package com.seongJIn.Robot.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.seongJIn.Robot.DAO.FormatDao;
import com.seongJIn.Robot.Vo.FormatVo;

@Service
public class PollingService {

		@Autowired
		FormatDao formatDao;
		
		public void getUpdate(FormatVo formatVo) {
			
			polling(formatVo);
		}
		
		private void polling(FormatVo formatVo) {
		   
			String urlPath="http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=100";
			String pageContents = "";
			String contents = new String();
			try {
 
            URL url = new URL(urlPath);
            URLConnection con = (URLConnection)url.openConnection();
            InputStreamReader reader = new InputStreamReader (con.getInputStream(), "EUC-KR");
 
            
            BufferedReader buff = new BufferedReader(reader);
            while((pageContents = buff.readLine())!=null){
                //System.out.println(pageContents);             
                contents+=pageContents;
                //contents.append("\r\n");
            }
            buff.close();
 
            // System.out.println(contents.toString());

            
            InputSource is = new InputSource(new StringReader(contents));
            Document document =  DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);


            
            XPath xpath = XPathFactory.newInstance().newXPath();
             
            NodeList cols = (NodeList)xpath.evaluate("//row/col1", document, XPathConstants.NODESET);
              for( int idx=0; idx<cols.getLength(); idx++ ){
            	  System.out.println(cols.item(idx).getTextContent());
              }


 
        }catch(Exception e){
            e.printStackTrace();
        }
			
		}
}
