package in.ravikalla.cloudBank.utils;

public class TestConstants {
	public static final String URI_BASE = "/jersey";

	public static final String URI_MONGO_SAVE_PERSON = "/mongo/saveperson";
	public static final String URI_MONGO_GET_PERSONS = "/mongo/persons";
	public static final String URI_MONGO_GET_PERSON = "/mongo/person?id=";
	public static final String URI_MONGO_GET_PERSON_BY_NAME = "/mongo/person?firstName=<firstName>&lastName=<lastName>";
	public static final String URI_MONGO_PUT_DELETEALL = "/mongo/deleteAll";
	public static final String URI_MONGO_PUT_DELETEBYID = "/mongo/deleteById?id=";

	public static final String URI_EXTERNALSITE_SAVE_PERSON = "/externalSite/saveperson";
	public static final String URI_EXTERNALSITE_GET_PERSONS = "/externalSite/persons";
//	public static final String URI_EXTERNALSITE_GET_PERSON = "/externalSite/person?id=";
	public static final String URI_EXTERNALSITE_GET_PERSON_BY_NAME = "/externalSite/person?firstName=<firstName>&lastName=<lastName>";
	public static final String URI_EXTERNALSITE_PUT_DELETEALL = "/mongo/deleteAll";
//	public static final String URI_EXTERNALSITE_PUT_DELETEBYID = "/mongo/deleteById?id=";

	public static final String URL_EXTERNAL_SITE = "http://www.ravikalla.in:8010";
	public static final String EXTERNAL_URI_FINDALL = "/api/findAll";

	public static final String CONTENT_TYPE_APP_JSON = "application/json";
}
