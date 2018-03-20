package SFDCMetadata;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import DataContainer.DataWarehouse;
import DataContainer.GenericData;
import credentials.RestLogin;

public class GenericDataTest {
	public static void main(String... ss) throws Exception {
		JSONObject loginObject = RestLogin.GetLoginObject();

		String startdate = "2018-02-01T17:23:04.000Z";
		String enddate = "2018-03-01T17:23:04.000Z";

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		Element xmlroot = doc.createElement("Package");
		Attr attrType1 = doc.createAttribute("xmlns");
		attrType1.setValue("http://soap.sforce.com/2006/04/metadata");
		xmlroot.setAttributeNode(attrType1);
		doc.appendChild(xmlroot);
		List<String> objlist_Name = new ArrayList<String>();
		objlist_Name.add("ApexComponent");
		objlist_Name.add("AutoResponseRule");
		objlist_Name.add("AssignmentRule");
	

		for (int index = 0; index < 1; index++) {
		
			/* ----------------------AssignmentRule Start--------------- */
			JSONArray assignmentRuleList = GenericData.getComponentList_Name(objlist_Name.get(index), loginObject, startdate, enddate);
			if (assignmentRuleList != null) {
				if (assignmentRuleList.length() > 0) {
					Element xmlassignmentRuletype = doc.createElement("types");
					xmlroot.appendChild(xmlassignmentRuletype);
					for (int i = 0; i < assignmentRuleList.length(); i++) {
						try {
							Element xmlassignmentRuleMembers = doc.createElement("members");
							xmlassignmentRuleMembers.appendChild(doc
									.createTextNode(assignmentRuleList.getJSONObject(i).getString("EntityDefinitionId")
											+ "." + assignmentRuleList.getJSONObject(i).getString("Name")));
							xmlassignmentRuletype.appendChild(xmlassignmentRuleMembers);
							System.out.println("Class Name : "
									+ assignmentRuleList.getJSONObject(i).getString("EntityDefinitionId") + "."
									+ assignmentRuleList.getJSONObject(i).getString("Name"));

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					Element xmlassignmentRuleName = doc.createElement("name");
					xmlassignmentRuleName.appendChild(doc.createTextNode("AssignmentRule"));// Make it dynamic
					xmlassignmentRuletype.appendChild(xmlassignmentRuleName);
				}
			}
			
		}
		/* ----------------------AssignmentRule End--------------- */

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(
				"E:\\XML\\" + (new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date()).toString()) + ".xml"));
		transformer.transform(source, result);
	}
}
