package gov.va.ascent.demo.service.utils;


/**
 * The Class HystrixCommandConstants. 
 */
public final class HystrixCommandConstants {

	/**
	 * Instantiates a new letter generator constants.
	 */
	private HystrixCommandConstants() {

	}

	/** Demo Service Thread Pool Group. */
	public static final String ASCENT_DEMO_SERVICE_GROUP_KEY = "AscentDemoServiceGroup";
	
	/** Demo Service Thread Pool Group. */
	public static final String ASCENT_PERSON_DEMO_SERVICE_GROUP_KEY = "AscentPersonDemoServiceGroup";

	/** Document Service Thread Pool Group. */
	public static final String ASCENT_DOCUMENT_SERVICE_GROUP_KEY = "AscentDocumentServiceGroup";	


}