package SFDCMetadata;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import credentials.RestLogin;

public class FinalMetadata {

	public static void main(String[] args) throws Exception {
		JSONObject loginObject = RestLogin.GetLoginObject();

		String startdate = "";
		String enddate = "";

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		Element xmlroot = doc.createElement("Package");
		Attr attrType1 = doc.createAttribute("xmlns");
		attrType1.setValue("http://soap.sforce.com/2006/04/metadata");
		xmlroot.setAttributeNode(attrType1);
		doc.appendChild(xmlroot);

		/* ----------------------Apex class Start--------------- */
		JSONArray apexclassList = DataWarehouse.getApexClassList(loginObject, startdate, enddate);
		if (apexclassList != null) {
			if (apexclassList.length() > 0) {
				Element xmlapexclasstype = doc.createElement("types");
				xmlroot.appendChild(xmlapexclasstype);
				for (int i = 0; i < apexclassList.length(); i++) {
					try {
						Element xmlapexclassMembers = doc.createElement("members");
						xmlapexclassMembers
								.appendChild(doc.createTextNode(apexclassList.getJSONObject(i).getString("Name")));
						xmlapexclasstype.appendChild(xmlapexclassMembers);
						// System.out.println("Class Name : " +
						// apexTriggerList.getJSONObject(i).getString("Name"));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlapexclassName = doc.createElement("name");
				xmlapexclassName.appendChild(doc.createTextNode("ApexClass"));// Make it dynamic
				xmlapexclasstype.appendChild(xmlapexclassName);
			}
		}
		/* ----------------------Apex class End--------------- */
		/* ----------------------Apex Component Start--------------- */

		JSONArray apexComponentList = DataWarehouse.getApexComponentList(loginObject, startdate, enddate);
		if (apexComponentList != null) {
			if (apexComponentList.length() > 0) {
				Element xmlapexComponenttype = doc.createElement("types");
				xmlroot.appendChild(xmlapexComponenttype);
				for (int i = 0; i < apexComponentList.length(); i++) {
					try {
						Element xmlapexComponentMembers = doc.createElement("members");
						xmlapexComponentMembers
								.appendChild(doc.createTextNode(apexComponentList.getJSONObject(i).getString("Name")));
						xmlapexComponenttype.appendChild(xmlapexComponentMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				Element xmlapexComponentName = doc.createElement("name");
				xmlapexComponentName.appendChild(doc.createTextNode("ApexComponent"));// Make it dynamic
				xmlapexComponenttype.appendChild(xmlapexComponentName);
			}
		}
		/* ----------------------Apex Component End--------------- */
		/* ----------------------Apex page Start--------------- */
		JSONArray apexPageList = DataWarehouse.getApexPageList(loginObject, startdate, enddate);
		if (apexPageList != null) {
			if (apexPageList.length() > 0) {
				Element xmlapexPagetype = doc.createElement("types");
				xmlroot.appendChild(xmlapexPagetype);
				for (int i = 0; i < apexPageList.length(); i++) {
					try {
						Element xmlapexPageMembers = doc.createElement("members");
						xmlapexPageMembers
								.appendChild(doc.createTextNode(apexPageList.getJSONObject(i).getString("Name")));
						xmlapexPagetype.appendChild(xmlapexPageMembers);
						// System.out.println("Apex page Name : " +
						// apexPageList.getJSONObject(i).getString("Name"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlapexPageName = doc.createElement("name");
				xmlapexPageName.appendChild(doc.createTextNode("ApexPage"));// Make it dynamic
				xmlapexPagetype.appendChild(xmlapexPageName);
			}
		}
		/* ----------------------apex page End--------------- */
		/* ----------------------Apex Trigger Start--------------- */
		JSONArray apexTriggerList = DataWarehouse.getApexTriggerList(loginObject, startdate, enddate);
		if (apexTriggerList != null) {
			if (apexTriggerList.length() > 0) {
				Element xmlapextriggertype = doc.createElement("types");
				xmlroot.appendChild(xmlapextriggertype);
				for (int i = 0; i < apexTriggerList.length(); i++) {
					try {
						Element xmlapextriggerMembers = doc.createElement("members");
						xmlapextriggerMembers
								.appendChild(doc.createTextNode(apexTriggerList.getJSONObject(i).getString("Name")));
						xmlapextriggertype.appendChild(xmlapextriggerMembers);
						// System.out.println("Tigger Name : " +
						// apexTriggerList.getJSONObject(i).getString("Name"));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlapextriggerName = doc.createElement("name");
				xmlapextriggerName.appendChild(doc.createTextNode("ApexTrigger"));// Make it dynamic
				xmlapextriggertype.appendChild(xmlapextriggerName);
			}
		}
		/* ----------------------Apex Trigger End--------------- */
		/* ----------------------AssignmentRule Start--------------- */
		JSONArray assignmentRuleList = DataWarehouse.getAssignmentRuleList(loginObject, startdate, enddate);
		if (assignmentRuleList != null) {
			if (assignmentRuleList.length() > 0) {
				Element xmlassignmentRuletype = doc.createElement("types");
				xmlroot.appendChild(xmlassignmentRuletype);
				for (int i = 0; i < assignmentRuleList.length(); i++) {
					try {
						Element xmlassignmentRuleMembers = doc.createElement("members");
						xmlassignmentRuleMembers.appendChild(
								doc.createTextNode(assignmentRuleList.getJSONObject(i).getString("EntityDefinitionId")
										+ "." + assignmentRuleList.getJSONObject(i).getString("Name")));
						xmlassignmentRuletype.appendChild(xmlassignmentRuleMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlassignmentRuleName = doc.createElement("name");
				xmlassignmentRuleName.appendChild(doc.createTextNode("AssignmentRule"));// Make it dynamic
				xmlassignmentRuletype.appendChild(xmlassignmentRuleName);
			}
		}
		/* ----------------------AssignmentRule End--------------- */
		/* ----------------------AuraDefinitionBundle Start--------------- */
		JSONArray auraDefinitionBundle = DataWarehouse.getAuraDefinitionBundleList(loginObject, startdate, enddate);
		if (auraDefinitionBundle != null) {
			if (auraDefinitionBundle.length() > 0) {
				Element xmlAuraDefinitionBundletype = doc.createElement("types");
				xmlroot.appendChild(xmlAuraDefinitionBundletype);
				try {
					for (int i = 0; i < auraDefinitionBundle.length(); i++) {
						Element xmlAuraDefinitionBundleMembers = doc.createElement("members");
						xmlAuraDefinitionBundleMembers.appendChild(
								doc.createTextNode(auraDefinitionBundle.getJSONObject(i).getString("DeveloperName")));
						xmlAuraDefinitionBundletype.appendChild(xmlAuraDefinitionBundleMembers);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				Element xmlAuraDefinitionBundleName = doc.createElement("name");
				xmlAuraDefinitionBundleName.appendChild(doc.createTextNode("AuraDefinitionBundle"));// Make it dynamic
				xmlAuraDefinitionBundletype.appendChild(xmlAuraDefinitionBundleName);
			}
		}
		/* ----------------------AuraDefinitionBundle End--------------- */
		/* ----------------------AutoResponse Start--------------- */

		JSONArray autoResponseList = DataWarehouse.getAutoResponseList(loginObject, startdate, enddate);
		if (autoResponseList != null) {
			if (autoResponseList.length() > 0) {
				Element xmlautoResponseListtype = doc.createElement("types");
				xmlroot.appendChild(xmlautoResponseListtype);
				for (int i = 0; i < autoResponseList.length(); i++) {
					try {
						Element xmlautoResponseListMembers = doc.createElement("members");
						xmlautoResponseListMembers
								.appendChild(doc.createTextNode(autoResponseList.getJSONObject(i).getString("Name")));
						xmlautoResponseListtype.appendChild(xmlautoResponseListMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				Element xmlautoResponseListName = doc.createElement("name");
				xmlautoResponseListName.appendChild(doc.createTextNode("ApexComponent"));// Make it dynamic
				xmlautoResponseListtype.appendChild(xmlautoResponseListName);
			}
		}
		/* ----------------------Apex Component End--------------- */
		/* ----------------------BusinessProcess Start--------------- */
		JSONArray businessProcessList = DataWarehouse.getBusinessProcessList(loginObject, startdate, enddate);
		if (businessProcessList != null) {
			if (businessProcessList.length() > 0) {
				Element xmlbusinessProcesstype = doc.createElement("types");
				xmlroot.appendChild(xmlbusinessProcesstype);
				for (int i = 0; i < businessProcessList.length(); i++) {
					try {
						Element xmlbusinessProcessMembers = doc.createElement("members");
						xmlbusinessProcessMembers.appendChild(
								doc.createTextNode(businessProcessList.getJSONObject(i).getString("Name")));
						xmlbusinessProcesstype.appendChild(xmlbusinessProcessMembers);
						// System.out.println("Class Name : " +
						// businessProcessList.getJSONObject(i).getString("Name"));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlbusinessProcessName = doc.createElement("name");
				xmlbusinessProcessName.appendChild(doc.createTextNode("BusinessProcess"));// Make it dynamic
				xmlbusinessProcesstype.appendChild(xmlbusinessProcessName);
			}
		}
		/* ----------------------BusinessProcess End--------------- */
		/* ----------------------Custom Object Start--------------- */

		JSONArray customobjectList = DataWarehouse.getCustomObjectList(loginObject, startdate, enddate);
		if (customobjectList != null) {
			if (customobjectList.length() > 0) {
				Element xmlcustomobjecttype = doc.createElement("types");
				xmlroot.appendChild(xmlcustomobjecttype);
				for (int i = 0; i < customobjectList.length(); i++) {
					try {
						Element xmlcustomobjectMembers = doc.createElement("members");
						xmlcustomobjectMembers.appendChild(
								doc.createTextNode(customobjectList.getJSONObject(i).getString("DeveloperName")));
						xmlcustomobjecttype.appendChild(xmlcustomobjectMembers);
						// System.out.println("Custom Object Name : " +
						// customobjectList.getJSONObject(i).getString("DeveloperName"));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				Element xmlcustomobjectName = doc.createElement("name");
				xmlcustomobjectName.appendChild(doc.createTextNode("CustomObject"));// Make it dynamic
				xmlcustomobjecttype.appendChild(xmlcustomobjectName);
			}
		}
		/* ----------------------Custom Object End--------------- */
		/* ----------------------Custom Field Start--------------- */
		JSONArray customFieldList = DataWarehouse.__getCustomFieldList(loginObject, startdate, enddate);
		if (customFieldList != null) {
			if (customFieldList.length() > 0) {
				Element xmlcustomfieldtype = doc.createElement("types");
				xmlroot.appendChild(xmlcustomfieldtype);
				if (customFieldList.length() > 0) {
					String customObjectName = "";
					for (int j = 0; j < customFieldList.length(); j++) {
						if (customFieldList.getJSONObject(j).getString("TableEnumOrId").matches("^[A-Za-z]+[0-9]*"))
							customObjectName = customFieldList.getJSONObject(j).getString("TableEnumOrId");
						else {
							customObjectName = DataWarehouse.getCustomObjectName(loginObject,
									customFieldList.getJSONObject(j).getString("TableEnumOrId"));
							customObjectName += "__c";
						}
						Element xmlcustomfieldMembers = doc.createElement("members");
						xmlcustomfieldMembers.appendChild(doc.createTextNode(customObjectName + "."
								+ customFieldList.getJSONObject(j).getString("DeveloperName") + "__c"));
						xmlcustomfieldtype.appendChild(xmlcustomfieldMembers);
					}
				}
				Element xmlcustomfieldName = doc.createElement("name");
				xmlcustomfieldName.appendChild(doc.createTextNode("CustomField"));// Make it dynamic
				xmlcustomfieldtype.appendChild(xmlcustomfieldName);
			}
		}
		/* ----------------------Custom Field End--------------- */
		/* ----------------------EmailTemplate Start--------------- */
		JSONArray emailTemplateList = DataWarehouse.getEmailTemplateList(loginObject, startdate, enddate);
		if (emailTemplateList != null) {
			if (emailTemplateList.length() > 0) {
				Element xmlemailTemplateListtype = doc.createElement("types");
				xmlroot.appendChild(xmlemailTemplateListtype);
				for (int i = 0; i < emailTemplateList.length(); i++) {
					try {
						Element xmlemailTemplateListMembers = doc.createElement("members");
						xmlemailTemplateListMembers
								.appendChild(doc.createTextNode(emailTemplateList.getJSONObject(i).getString("Name")));
						xmlemailTemplateListtype.appendChild(xmlemailTemplateListMembers);
						// System.out.println("emailTemplateList Name : " +
						// emailTemplateList.getJSONObject(i).getString("Name"));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlemailTemplateListName = doc.createElement("name");
				xmlemailTemplateListName.appendChild(doc.createTextNode("EmailTemplate"));// Make it dynamic
				xmlemailTemplateListtype.appendChild(xmlemailTemplateListName);
			}
		}
		/* ----------------------EmailTemplate End--------------- */
		/* ----------------------FieldSet Start--------------- */
		JSONArray fieldSetList = DataWarehouse.getFieldSetList(loginObject, startdate, enddate);
		if (fieldSetList != null) {
			if (fieldSetList.length() > 0) {
				Element xmlfieldSettype = doc.createElement("types");
				xmlroot.appendChild(xmlfieldSettype);
				for (int i = 0; i < fieldSetList.length(); i++) {
					try {
						Element xmlfieldSetMembers = doc.createElement("members");
						xmlfieldSetMembers.appendChild(
								doc.createTextNode(fieldSetList.getJSONObject(i).getString("DeveloperName")));
						xmlfieldSettype.appendChild(xmlfieldSetMembers);
						// System.out.println("emailTemplateList Name : " +
						// fieldSetList.getJSONObject(i).getString("DeveloperName"));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlxmlfieldSetName = doc.createElement("name");
				xmlxmlfieldSetName.appendChild(doc.createTextNode("FieldSet"));// Make it dynamic
				xmlfieldSettype.appendChild(xmlxmlfieldSetName);
			}
		}
		/* ----------------------FieldSet End--------------- */
		/* ----------------------FlexiPage Start--------------- */
		JSONArray flexiPageList = DataWarehouse.getFlexiPageList(loginObject, startdate, enddate);
		if (flexiPageList != null) {
			if (flexiPageList.length() > 0) {
				Element xmlflexiPageListtype = doc.createElement("types");
				xmlroot.appendChild(xmlflexiPageListtype);
				for (int i = 0; i < flexiPageList.length(); i++) {
					try {
						Element xmlflexiPageListMembers = doc.createElement("members");
						xmlflexiPageListMembers.appendChild(
								doc.createTextNode(flexiPageList.getJSONObject(i).getString("DeveloperName")));
						xmlflexiPageListtype.appendChild(xmlflexiPageListMembers);
						// System.out.println("flexiPageList Name : " +
						// flexiPageList.getJSONObject(i).getString("DeveloperName"));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlflexiPageListName = doc.createElement("name");
				xmlflexiPageListName.appendChild(doc.createTextNode("FlexiPage"));// Make it dynamic
				xmlflexiPageListtype.appendChild(xmlflexiPageListName);
			}
		}
		/* ----------------------FlexiPage End--------------- */
		/* ----------------------GlobalValueSet Start--------------- */
		JSONArray globalValueSetList = DataWarehouse.getGlobalValueSetList(loginObject, startdate, enddate);
		if (globalValueSetList != null) {
			if (globalValueSetList.length() > 0) {
				Element xmlglobalValueSettype = doc.createElement("types");
				xmlroot.appendChild(xmlglobalValueSettype);
				for (int i = 0; i < globalValueSetList.length(); i++) {
					try {
						Element xmlglobalValueSetMembers = doc.createElement("members");
						xmlglobalValueSetMembers.appendChild(
								doc.createTextNode(globalValueSetList.getJSONObject(i).getString("DeveloperName")));
						xmlglobalValueSettype.appendChild(xmlglobalValueSetMembers);
						// System.out.println("flexiPageList Name : " +
						// globalValueSetList.getJSONObject(i).getString("DeveloperName"));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlglobalValueSetName = doc.createElement("name");
				xmlglobalValueSetName.appendChild(doc.createTextNode("GlobalValueSet"));// Make it dynamic
				xmlglobalValueSettype.appendChild(xmlglobalValueSetName);
			}
		}
		/* ----------------------GlobalValueSet End--------------- */
		/* ----------------------HomePageLayout Start--------------- */
		JSONArray homePageLayoutList = DataWarehouse.getHomePageLayoutList(loginObject, startdate, enddate);
		if (homePageLayoutList != null) {
			if (homePageLayoutList.length() > 0) {
				Element xmlhomePageLayouttype = doc.createElement("types");
				xmlroot.appendChild(xmlhomePageLayouttype);
				for (int i = 0; i < homePageLayoutList.length(); i++) {
					try {
						Element xmlhomePageLayoutMembers = doc.createElement("members");
						xmlhomePageLayoutMembers
								.appendChild(doc.createTextNode(homePageLayoutList.getJSONObject(i).getString("Name")));
						xmlhomePageLayouttype.appendChild(xmlhomePageLayoutMembers);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlhomePageLayoutName = doc.createElement("name");
				xmlhomePageLayoutName.appendChild(doc.createTextNode("HomePageLayout"));// Make it dynamic
				xmlhomePageLayouttype.appendChild(xmlhomePageLayoutName);
			}
		}
		/* ----------------------HomePageLayout End--------------- */
		/* ----------------------RecordType Start--------------- */
		JSONArray recordTypeList = DataWarehouse.getRecordTypeList(loginObject, startdate, enddate);
		if (recordTypeList != null) {
			if (recordTypeList.length() > 0) {
				Element xmlrecordTypetype = doc.createElement("types");
				xmlroot.appendChild(xmlrecordTypetype);
				for (int i = 0; i < recordTypeList.length(); i++) {
					try {
						Element xmlrecordTypeMembers = doc.createElement("members");
						xmlrecordTypeMembers
								.appendChild(doc.createTextNode(recordTypeList.getJSONObject(i).getString("Name") + "."
										+ recordTypeList.getJSONObject(i).getString("Name")));
						xmlrecordTypetype.appendChild(xmlrecordTypeMembers);
				
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlrecordTypeName = doc.createElement("name");
				xmlrecordTypeName.appendChild(doc.createTextNode("RecordType"));// Make it dynamic
				xmlrecordTypetype.appendChild(xmlrecordTypeName);
			}
		}
		/* ----------------------RecordType End--------------- */
		/* ----------------------StaticResource Start--------------- */
		JSONArray staticResourceList = DataWarehouse.getStaticResourceList(loginObject, startdate, enddate);
		if (staticResourceList != null) {
			if (staticResourceList.length() > 0) {
				Element xmlstaticResourcetype = doc.createElement("types");
				xmlroot.appendChild(xmlstaticResourcetype);
				for (int i = 0; i < staticResourceList.length(); i++) {
					try {
						Element xmlstaticResourceMembers = doc.createElement("members");
						xmlstaticResourceMembers
								.appendChild(doc.createTextNode(staticResourceList.getJSONObject(i).getString("Name")));
						xmlstaticResourcetype.appendChild(xmlstaticResourceMembers);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlstaticResourceName = doc.createElement("name");
				xmlstaticResourceName.appendChild(doc.createTextNode("StaticResource"));// Make it dynamic
				xmlstaticResourcetype.appendChild(xmlstaticResourceName);
			}
		}
		/* ----------------------StaticResource End--------------- */
		/* ----------------------ValidationRule Start--------------- */
		JSONArray validationRuleList = DataWarehouse.getValidationRuleList(loginObject, startdate, enddate);
		if (validationRuleList != null) {
			if (validationRuleList.length() > 0) {
				Element xmlvalidationRuletype = doc.createElement("types");
				xmlroot.appendChild(xmlvalidationRuletype);
				for (int i = 0; i < validationRuleList.length(); i++) {
					try {
						Element xmlvalidationRuleMembers = doc.createElement("members");
						xmlvalidationRuleMembers
								.appendChild(doc.createTextNode(DataWarehouse.getValidationRuleObjectName(loginObject,
										validationRuleList.getJSONObject(i).getString("Id"))));
						xmlvalidationRuletype.appendChild(xmlvalidationRuleMembers);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Element xmlvalidationRuleName = doc.createElement("name");
				xmlvalidationRuleName.appendChild(doc.createTextNode("ValidationRule"));// Make it dynamic
				xmlvalidationRuletype.appendChild(xmlvalidationRuleName);
			}
		}
		/* ----------------------ValidationRule End--------------- */
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(
				"E:\\XML\\" + (new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date()).toString()) + ".xml"));
		transformer.transform(source, result);
	}

}
