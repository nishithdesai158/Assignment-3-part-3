

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DomParserDTD {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DocumentBuilderFactory myFactory = DocumentBuilderFactory.newInstance();
			myFactory.setValidating(true);

			DocumentBuilder myBuilder = myFactory.newDocumentBuilder();
			Boolean flag = myFactory.isValidating();
			System.out.println(flag);
			myBuilder.setErrorHandler(new ErrorHandler() {
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					// TODO Auto-generated method stub

				}

				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					// TODO Auto-generated method stub

				}

				@Override
				public void error(SAXParseException exception) throws SAXException {
					// TODO Auto-generated method stub
				}
			});
			if (flag == false) {
				System.out.println("Error occured while validating xml");
			} else {
				System.out.println("Xml Validated with DTD");
				System.out.println("=======================");
				Document doc = myBuilder.parse("test.xml");

				NodeList myNodeList = doc.getElementsByTagName("note");
				for (int i = 0; i < myNodeList.getLength(); i++) {
					Node root = myNodeList.item(i);
					if (root.getNodeType() == root.ELEMENT_NODE) {
						Element Rnode = (Element) root;
						NodeList childList = Rnode.getChildNodes();
						for (int j = 0; j < childList.getLength(); j++) {
							Node Cnode = childList.item(j);
							if (Cnode.getNodeType() == Node.ELEMENT_NODE) {
								Element childs = (Element) Cnode;
								NodeList Data = childs.getChildNodes();
								for (int k = 0; k < Data.getLength(); k++) {
									Node dataNodes = Data.item(k);
									if (dataNodes.getNodeType() == Node.ELEMENT_NODE) {
										Element dataElements = (Element) dataNodes;
										System.out.println(
												dataElements.getTagName() + "=" + dataElements.getTextContent());

									}
								}

							}
							System.out.println("=======================");
						}

					}
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
