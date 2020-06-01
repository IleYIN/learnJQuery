package xmlparsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class TestXmlParser {
	@Test
	public void testXml1() throws DocumentException{
		//����dom������
		//����һ��SAXReader һ��xml�ĵ��Ķ���  SAXֻ�������� DOM����������
		SAXReader saxReader = new SAXReader();
		//ʹ��reader��ȡ 
		//ctrl+1 assign statement to local variable
		Document document = saxReader.read(new File("test.xml"));
		System.out.println("document:"+document);
	}
	@Test
	public void textXml2() throws DocumentException {
		//����dom������
		//����һ��SAXReader һ��xml�ĵ��Ķ���  SAXֻ�������� DOM����������
		SAXReader saxReader = new SAXReader();
		//ʹ��reader��ȡ 
		//ctrl+1 assign statement to local variable
		Document document = saxReader.read(new File("test.xml"));
		
		//����
		short nodeType = document.getNodeType();
		//9 matches Document nodes 
		//System.out.println(nodeType);
		//��ȡ���ڵ�
		Element ele = document.getRootElement();
		System.out.println("rootEleName:"+ele.getName());
		System.out.println("rootText:"+ele.getText());
		//���ڵ����²���
		List<Element> elements = ele.elements();
		for(Element ele2 : elements) {
//			System.out.println(ele2.getName());
			System.out.println(ele2.elementText("name"));
			System.out.println(ele2.elementText("age"));
		}

		for(Element eleTmp : elements) {
			String id = eleTmp.attributeValue("id");
			System.out.println(id);
		}
	}
	
	@Test
	public void testXml3() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("test.xml"));
		Element rootElement = doc.getRootElement();
		List<Element> elements = rootElement.elements();
		List<Student> stus = new ArrayList<>();
		for(Element ele : elements) {
			String id = ele.attributeValue("id");
			String name = ele.elementText("name");
			String age = ele.elementText("age");
			int parseInt = 0;
			//alt+shift+z
			try {
				parseInt = Integer.parseInt(age);
			} catch (NumberFormatException e) {
			}
			Student student = new Student(name, id,parseInt);
			stus.add(student);
		}
		System.out.println("students:--"+stus);
	}
	
	@Test
	public void testXml4() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("test.xml"));
		Element rootElement = document.getRootElement();
		//��ȡ��һ��student
		Element element = rootElement.element("student");
		Element name = element.element("name");
		//System.out.println(name.getText());
		name.setText("newName");
		name.addAttribute("firstName","FirstName");
		//����ļ�
		//OutputFormat����������ݸ�ʽ��
		OutputFormat createCompactFormat = OutputFormat.createCompactFormat();
		//XMLWriter����дdocument����
		XMLWriter writer = new XMLWriter(new FileOutputStream("out.xml"),createCompactFormat);
		writer.write(document);
		
		OutputFormat prettyPrintFormat = OutputFormat.createPrettyPrint();
		XMLWriter writer2 = new XMLWriter(new FileOutputStream("out2.xml"),prettyPrintFormat);
		writer2.write(document);
	}
	
	/**
	 * XPath�򻯲���
	 * �Ӹ���ǩ��ʼ����Ԫ�� �õ�б��
	 *  /AAA
	 *  /AAA/CCC
	 *  /AAA/DDD/BBB
	 * ���۲㼶��Ͻѡ���ĵ��������������� ��˫б��
	 *	//BBB
	 *  //DDD/BBB
	 *  
	 * �Ǻű�ʾ����
	 * 	/AAA/CCC/DDD/*
	 *  / * / * / * /BBB
	 *  
	 *  �������ı��ʽ���Խ�һ��ָ��Ԫ�أ��������ֱ�ʾԪ����ѡ�����λ��
	 *  ��last()�������ʾѡ���е����һ��Ԫ��
	 *  
	 *  /AAA/BBB[1]
	 *  /AAA/BBB[last()]
	 *  //@id
	 *  //BBB[@id] ѡ����id��BBBԪ��
	 *  //BBB[@name] ѡ����name���Ե�Ԫ��
	 *  //BBB[@*] ѡ�����������Ե�BBBԪ��
	 *  //BBB[@id='b1']
	 *  //BBB[@name='bbb']
	 *  //BBB[normalize-space(@name)='bbb'] ѡ��������name����ֵ��
	 *  			��normalilze-space����ȥ��ǰ��ո��Ϊ'bbb'��BBBԪ��
	 * @throws DocumentException 
	 *  
	 */
	@Test
	public void testXml5() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("test.xml");
		Element rootElement = document.getRootElement();
		
		//��id��ȡstudent
		Node node = rootElement.selectSingleNode("//student[@id='123']");
		String name = node.getName();
		System.out.println("nodename:"+name);
		
		//ctrl+shift+T
		//org.dom4j Element
		Element element = (Element) node;
		String id = element.attributeValue("id");
		System.out.println("id:"+id);
		
		//��ȡ����name��ǩ
		List<Element> list = rootElement.selectNodes("//name");
		for(Element ele : list) {
			System.out.println("text:"+ele.getText());
		}
	}
}
