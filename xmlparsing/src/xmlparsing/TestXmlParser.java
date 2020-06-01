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
		//导入dom解析包
		//创建一个SAXReader 一个xml文档阅读器  SAX只能用来读 DOM可以用来改
		SAXReader saxReader = new SAXReader();
		//使用reader读取 
		//ctrl+1 assign statement to local variable
		Document document = saxReader.read(new File("test.xml"));
		System.out.println("document:"+document);
	}
	@Test
	public void textXml2() throws DocumentException {
		//导入dom解析包
		//创建一个SAXReader 一个xml文档阅读器  SAX只能用来读 DOM可以用来改
		SAXReader saxReader = new SAXReader();
		//使用reader读取 
		//ctrl+1 assign statement to local variable
		Document document = saxReader.read(new File("test.xml"));
		
		//解析
		short nodeType = document.getNodeType();
		//9 matches Document nodes 
		//System.out.println(nodeType);
		//获取根节点
		Element ele = document.getRootElement();
		System.out.println("rootEleName:"+ele.getName());
		System.out.println("rootText:"+ele.getText());
		//根节点往下查找
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
		//获取第一个student
		Element element = rootElement.element("student");
		Element name = element.element("name");
		//System.out.println(name.getText());
		name.setText("newName");
		name.addAttribute("firstName","FirstName");
		//输出文件
		//OutputFormat将输出的数据格式化
		OutputFormat createCompactFormat = OutputFormat.createCompactFormat();
		//XMLWriter用来写document对象
		XMLWriter writer = new XMLWriter(new FileOutputStream("out.xml"),createCompactFormat);
		writer.write(document);
		
		OutputFormat prettyPrintFormat = OutputFormat.createPrettyPrint();
		XMLWriter writer2 = new XMLWriter(new FileOutputStream("out2.xml"),prettyPrintFormat);
		writer2.write(document);
	}
	
	/**
	 * XPath简化查找
	 * 从根标签开始找子元素 用单斜线
	 *  /AAA
	 *  /AAA/CCC
	 *  /AAA/DDD/BBB
	 * 无论层级管辖选择文档中所有满足规则的 用双斜线
	 *	//BBB
	 *  //DDD/BBB
	 *  
	 * 星号表示所有
	 * 	/AAA/CCC/DDD/*
	 *  / * / * / * /BBB
	 *  
	 *  方块号里的表达式可以进一步指定元素，其中数字表示元素在选择集里的位置
	 *  而last()函数则表示选择集中的最后一个元素
	 *  
	 *  /AAA/BBB[1]
	 *  /AAA/BBB[last()]
	 *  //@id
	 *  //BBB[@id] 选择有id的BBB元素
	 *  //BBB[@name] 选择有name属性的元素
	 *  //BBB[@*] 选择有任意属性的BBB元素
	 *  //BBB[@id='b1']
	 *  //BBB[@name='bbb']
	 *  //BBB[normalize-space(@name)='bbb'] 选择含有属性name且其值在
	 *  			用normalilze-space函数去掉前后空格后为'bbb'的BBB元素
	 * @throws DocumentException 
	 *  
	 */
	@Test
	public void testXml5() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("test.xml");
		Element rootElement = document.getRootElement();
		
		//用id获取student
		Node node = rootElement.selectSingleNode("//student[@id='123']");
		String name = node.getName();
		System.out.println("nodename:"+name);
		
		//ctrl+shift+T
		//org.dom4j Element
		Element element = (Element) node;
		String id = element.attributeValue("id");
		System.out.println("id:"+id);
		
		//获取所有name标签
		List<Element> list = rootElement.selectNodes("//name");
		for(Element ele : list) {
			System.out.println("text:"+ele.getText());
		}
	}
}
