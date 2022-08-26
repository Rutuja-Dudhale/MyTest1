import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
     try {
    	 File file=new File("File1.xml");
    	 DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
    	 DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.parse(file);
		doc.getDocumentElement().normalize();
		System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
		NodeList NodeList = doc.getElementsByTagName("student");
		for(int itr=0;itr<NodeList.getLength();itr++)
		{
			Node node=NodeList.item(itr);
			System.out.println("\nNode name:"+node.getNodeName());
			if(node.getNodeType()==Node.ELEMENT_NODE)
			{
				Element eElement=(Element)node;
				System.out.println("Student id:"+eElement.getElementsByTagName("id").item(0).getTextContent());
				System.out.println("First Name:"+eElement.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Last Name:"+eElement.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Subject:"+eElement.getElementsByTagName("subject").item(0).getTextContent());
				System.out.println("Marks:"+eElement.getElementsByTagName("marks").item(0).getTextContent());
			}
		}
     }
     catch(Exception e)
     {
    	 e.printStackTrace();
     }
	}
}
