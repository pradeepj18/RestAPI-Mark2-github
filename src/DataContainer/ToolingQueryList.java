package DataContainer;

public class ToolingQueryList {
	public static String getCustomObjects(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,DeveloperName,CreatedById,CreatedDate,LastModifiedDate+from+CustomObject+order+by+DeveloperName+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,DeveloperName,CreatedById,CreatedDate,LastModifiedDate+from+CustomObject+where+LastModifiedDate%3E"
					+ startdate + "+order+by+DeveloperName+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,DeveloperName,CreatedById,CreatedDate,LastModifiedDate+from+CustomObject+where+LastModifiedDate%3E"
					+ enddate + "+order+by+DeveloperName+asc";
		} else {

			return "select+Id,DeveloperName,CreatedById,CreatedDate,LastModifiedDate+from+CustomObject+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+DeveloperName+asc";
		}
	}

	public static String getCustomFields(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,DeveloperName,TableEnumOrId,LastModifiedDate+from+CustomField+order+by+TableEnumOrId+desc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,DeveloperName,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
					+ startdate + "+order+by+TableEnumOrId+desc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,DeveloperName,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
					+ enddate + "+order+by+TableEnumOrId+desc";
		} else {

			return "select+Id,DeveloperName,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+TableEnumOrId+desc";
		}
	}

	public static String getCustom_StdObjectFields(String startdate, String enddate, String objectId) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,DeveloperName,CreatedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='"
					+ objectId + "'+order+by+DeveloperName+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,DeveloperName,CreatedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='"
					+ objectId + "'+and+LastModifiedDate%3E" + startdate + "+order+by+DeveloperName+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,DeveloperName,CreatedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='"
					+ objectId + "'+and+LastModifiedDate%3E" + enddate + "+order+by+DeveloperName+asc";
		} else {

			return "select+Id,DeveloperName,CreatedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+TableEnumOrId='"
					+ objectId + "'+and+LastModifiedDate%3E" + startdate + "+and+LastModifiedDate%3C" + enddate
					+ "+order+by+DeveloperName+asc";
		}
	}

	public static String getApexTriggers(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexTrigger+order+by+Name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexTrigger+where+LastModifiedDate%3E" + startdate
					+ "+order+by+Name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexTrigger+where+LastModifiedDate%3E" + enddate
					+ "+order+by+Name+asc";
		} else {

			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexTrigger+where+LastModifiedDate%3E" + startdate
					+ "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
		}
	}

	public static String getApexClasses(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexClass+order+by+name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexClass+where+LastModifiedDate%3E" + startdate
					+ "+order+by+name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexClass+where+LastModifiedDate%3E" + enddate
					+ "+order+by+name+asc";
		} else {

			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexClass+where+LastModifiedDate%3E" + startdate
					+ "+and+LastModifiedDate%3C" + enddate + "+order+by+name+asc";
		}
	}

	public static String getObjectNameQuery(String CustomObjectId) {
		return "select+Id,CreatedById,DeveloperName+from+CustomObject+where+Id='" + CustomObjectId + "'";
	}

	public static String getCustomObjects() {
		return "select+Id,CreatedById,DeveloperName,LastModifiedDate+from+CustomObject";
	}

	public static String getStdObject(String startdate, String enddate) {
		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,CreatedById,TableEnumOrId,LastModifiedDate+from+CustomField+order+by+TableEnumOrId+desc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,CreatedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
					+ startdate + "+order+by+TableEnumOrId+desc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,CreatedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
					+ enddate + "+order+by+TableEnumOrId+desc";
		} else {

			return "select+Id,CreatedById,TableEnumOrId,LastModifiedDate+from+CustomField+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+TableEnumOrId+desc";
		}
	}

	public static String getApexComponents(String startdate, String enddate) {
		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexComponent+order+by+Name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexComponent+where+LastModifiedDate%3E"
					+ startdate + "+order+by+Name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexComponent+where+LastModifiedDate%3E" + enddate
					+ "+order+by+Name+asc";
		} else {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexComponent+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
		}
	}

	public static String getApexPages(String startdate, String enddate) {
		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexPage+order+by+Name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexPage+where+LastModifiedDate%3E" + startdate
					+ "+order+by+Name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexPage+where+LastModifiedDate%3E" + enddate
					+ "+order+by+Name+asc";
		} else {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+ApexPage+where+LastModifiedDate%3E" + startdate
					+ "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
		}
	}

	public static String getAuraDefinitionBundles(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,DeveloperName,CreatedById,LastModifiedDate+from+AuraDefinitionBundle+order+by+DeveloperName+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,DeveloperName,CreatedById,LastModifiedDate+from+AuraDefinitionBundle+where+LastModifiedDate%3E"
					+ startdate + "+order+by+DeveloperName+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,DeveloperName,CreatedById,LastModifiedDate+from+AuraDefinitionBundle+where+LastModifiedDate%3E"
					+ enddate + "+order+by+DeveloperName+asc";
		} else {

			return "select+Id,DeveloperName,CreatedById,LastModifiedDate+from+AuraDefinitionBundle+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+DeveloperName+asc";
		}
	}

	public static String getAssignmentRules(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+AssignmentRule+order+by+Name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+AssignmentRule+where+LastModifiedDate%3E"
					+ startdate + "+order+by+Name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+AssignmentRule+where+LastModifiedDate%3E"
					+ enddate + "+order+by+Name+asc";
		} else {

			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+AssignmentRule+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
		}
	}

	public static String getAutoResponseRules(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+AutoResponseRule+order+by+Name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+AutoResponseRule+where+LastModifiedDate%3E"
					+ startdate + "+order+by+Name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+AutoResponseRule+where+LastModifiedDate%3E"
					+ enddate + "+order+by+Name+asc";
		} else {

			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+AutoResponseRule+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
		}
	}

	public static String getBusinessProcess(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+BusinessProcess+order+by+Name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+BusinessProcess+where+LastModifiedDate%3E"
					+ startdate + "+order+by+Name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+BusinessProcess+where+LastModifiedDate%3E"
					+ enddate + "+order+by+Name+asc";
		} else {

			return "select+Id,Name,EntityDefinitionId,CreatedById,LastModifiedDate+from+BusinessProcess+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
		}
	}

	public static String getEmailTemplates(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+EmailTemplate+order+by+Name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+EmailTemplate+where+LastModifiedDate%3E"
					+ startdate + "+order+by+Name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+EmailTemplate+where+LastModifiedDate%3E" + enddate
					+ "+order+by+Name+asc";
		} else {

			return "select+Id,Name,CreatedById,LastModifiedDate+from+EmailTemplate+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
		}
	}

	public static String getFieldSet(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,DeveloperName,CreatedById,LastModifiedDate+from+FieldSet+order+by+DeveloperName+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,DeveloperName,CreatedById,LastModifiedDate+from+FieldSet+where+LastModifiedDate%3E"
					+ startdate + "+order+by+DeveloperName+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,DeveloperName,CreatedById,LastModifiedDate+from+FieldSet+where+LastModifiedDate%3E"
					+ enddate + "+order+by+DeveloperName+asc";
		} else {

			return "select+Id,DeveloperName,CreatedById,LastModifiedDate+from+FieldSet+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+DeveloperName+asc";
		}
	}

	public static String getFlexiPage(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,DeveloperName,LastModifiedDate+from+FlexiPage+order+by+DeveloperName+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,DeveloperName,LastModifiedDate+from+FlexiPage+where+LastModifiedDate%3E" + startdate
					+ "+order+by+DeveloperName+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,DeveloperName,LastModifiedDate+from+FlexiPage+where+LastModifiedDate%3E" + enddate
					+ "+order+by+DeveloperName+asc";
		} else {

			return "select+Id,DeveloperName,LastModifiedDate+from+FlexiPage+where+LastModifiedDate%3E" + startdate
					+ "+and+LastModifiedDate%3C" + enddate + "+order+by+DeveloperName+asc";
		}
	}

	public static String getGlobalValueSet(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,DeveloperName,LastModifiedDate+from+GlobalValueSet+order+by+DeveloperName+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,DeveloperName,LastModifiedDate+from+GlobalValueSet+where+LastModifiedDate%3E" + startdate
					+ "+order+by+DeveloperName+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,DeveloperName,LastModifiedDate+from+GlobalValueSet+where+LastModifiedDate%3E" + enddate
					+ "+order+by+DeveloperName+asc";
		} else {

			return "select+Id,DeveloperName,LastModifiedDate+from+GlobalValueSet+where+LastModifiedDate%3E" + startdate
					+ "+and+LastModifiedDate%3C" + enddate + "+order+by+DeveloperName+asc";
		}
	}

	public static String getHomePageLayout(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+HomePageLayout+order+by+Name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+HomePageLayout+where+LastModifiedDate%3E"
					+ startdate + "+order+by+Name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+HomePageLayout+where+LastModifiedDate%3E" + enddate
					+ "+order+by+Name+asc";
		} else {

			return "select+Id,Name,CreatedById,LastModifiedDate+from+HomePageLayout+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
		}
	}

	public static String getRecordType(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,SobjectType,CreatedById,LastModifiedDate+from+RecordType+order+by+Name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,SobjectType,CreatedById,LastModifiedDate+from+RecordType+where+LastModifiedDate%3E"
					+ startdate + "+order+by+Name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,SobjectType,CreatedById,LastModifiedDate+from+RecordType+where+LastModifiedDate%3E"
					+ enddate + "+order+by+Name+asc";
		} else {

			return "select+Id,Name,SobjectType,CreatedById,LastModifiedDate+from+RecordType+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
		}
	}

	public static String getStaticResource(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+StaticResource+order+by+Name+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+StaticResource+where+LastModifiedDate%3E"
					+ startdate + "+order+by+Name+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,Name,CreatedById,LastModifiedDate+from+StaticResource+where+LastModifiedDate%3E" + enddate
					+ "+order+by+Name+asc";
		} else {

			return "select+Id,Name,CreatedById,LastModifiedDate+from+StaticResource+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+Name+asc";
		}
	}

	public static String getValidationRuleID(String startdate, String enddate) {

		if ((startdate.equalsIgnoreCase("") || startdate == null)
				&& (enddate.equalsIgnoreCase("") || enddate == null)) {
			return "select+Id,ValidationName,CreatedById,LastModifiedDate+from+ValidationRule+order+by+ValidationName+asc";

		} else if (enddate.equalsIgnoreCase("") || enddate == null) {
			return "select+Id,ValidationName,CreatedById,LastModifiedDate+from+ValidationRule+where+LastModifiedDate%3E"
					+ startdate + "+order+by+ValidationName+asc";

		} else if (startdate.equalsIgnoreCase("") || startdate == null) {
			return "select+Id,ValidationName,CreatedById,LastModifiedDate+from+ValidationRule+where+LastModifiedDate%3E"
					+ enddate + "+order+by+ValidationName+asc";
		} else {

			return "select+Id,ValidationName,CreatedById,LastModifiedDate+from+ValidationRule+where+LastModifiedDate%3E"
					+ startdate + "+and+LastModifiedDate%3C" + enddate + "+order+by+ValidationName+asc";
		}
	}

	public static String getValidationRuleFullName(String objId) {
		return "select+Id,FullName+from+ValidationRule+where+id='" + objId + "'";
	}
}
