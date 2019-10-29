package com.mix;

import java.util.HashMap;

/**
 * @Autor : Keshav Kumar 
 * @Date : 09-Jul-2019
 */

public class DomainException  extends Exception{
		
		private static final long serialVersionUID = 1493995256700285257L;
		
		private String code;
		
		private ExceptionName excpetion;
		
		
		public enum ExceptionName {
			
			//Common Exceptions
			DOC_NOT_WITH_USER("%s is not with the user", "D0001"), //not needed 
			DOC_NOT_EXIST("%s doesn't exist", "D0002"), //not needed 
			NO_RECORD_FOUND("No record found for the given request", "D0003"), //not needed 
			NOT_AUTHORIZED("User not authorised to perform the required action", "D0004"),
			INVALID_REQUEST("Invalid request", "D0005"),
			INVALID_DOCUMENT_TYPE("Invalid document Type", "D0006"),
//			DOC_WAS_NEVER_WITH_USER("%s is/was not with the user", "E0006"), //not needed 
			//DIGITAL_SIGNATURE_ONLY_ON_ELECTRONIC_DOC("Only Electronic file can be signed", "E0007"),
			ONLY_ON_PHYSICAL_DOCUMENT("%s is not a physical document, requested operation is applicable only on physical document", "D0007"),
			ONLY_ON_ELECTRONIC_DOCUMENT("%s is not a electronic document, requested operation is applicable only on electronic document", "D0008"),
			CAN_NOT_OPERATE_ON_DOC_AS_USER_OF_DIFFERENT_SECTION("%s of same user section can only operate", "D0009"),
					

			//Receipt Exceptions
			PDF_NEEDED_FOR_ELECTRONIC_RECEIPT("PDF needs to be uploaded for electronic receipt", "D00010"),
			LETTER_DATE_CANNOT_BE_GREATER_THAN_DIARY_DATE("Letter Date cannot be greater than diary date", "D0011"),
			RECEIVE_DATE_CANNOT_BE_GREATER_THAN_DIARY_DATE("Receive Date cannot be greater than diary date", "D0012"),
			RECEIVE_DATE_CANNOT_BE_LESS_THAN_LETTER_DATE("Receive Date cannot be less than letter date.", "D0013"),
			EITHER_SENDER_NAME_OR_DESIGNATION_NEEDED("Sender name or designation must be filled", "D0014"),
					
			//Draft Exceptions
			INVALID_TAG("Invalid # tag found", "D0015"),
			EITHER_RECIPIENT_NAME_OR_DESIGNATION_NEEDED("Name or Designation must be provided for all recipients.", "D0016"),
			//INVALID_INTERNAL_RECIPIENT("Invalid postdetail id has been passed.", "D0005"),
			//POST_ID_REQUIRED_FOR_EOFFICE_COMMUNICATIONS("Post detail id is require for internal or external eoffice communications.", "D0006"),
			CANNOT_CREATE_BLANK_DRAFT("You can not create a blank draft.", "D0017"),
			CANNOT_UPDATE_MULTIPLE_SIGN_ON_DRAFT("You are not privilege to update multiple sign value.", "D0018"),
			//CANNOT_UPDATE_APPROVED_DRAFT("Sorry, approved draft can not be updated.", "D0008"),
			//CANNOT_DELETE_APPROVED_DRAFT("Sorry, approved draft can not be deleted.", "D0009"),
			//CANNOT_DISPATCH_UNAPPROVED_DRAFT("Sorry, you can not dispatch the draft due to draft is not approved.", "D0010"),
			//CANNOT_DISPATCH_UNSIGNED_DRAFT("Sorry, you can not dispatch the draft due to draft is not signed.", "D0011"),
			
			//Close
			CANNOT_CLOSE_DOC_IN_PENDING_CLOSING_APPROVAL_STATE("Closing approval request for %s is not approved", "D0019"),
			CANNOT_REOPEN_DOC_IN_PENDING_REOPENING_APPROVAL_STATE("Reopening approval request for %s is not approved", "D0020"),
			DOC_IS_IN_PENDING_STATE_FOR_CLOSING_REOPENING("%s is in pending state for Closing/Reopening", "D0021"), //not needed
			//DOC_ALREADY_CLOSED("Can't close already closed", "C0003"),
			DOC_ALREADY_HAVING_PENDING_REQUEST("Document already having pending request", "C0022"),
			CAN_NOT_OPERATE_ON_CLOSED_DOC("Can't work on closed document", "D0023"),  
			CAN_REOPEN_ONLY_CLOSED_DOCUMENT("Only closed %s can reopen", "D0024"),
			CAN_NOT_CLOSE_DOC_HAVING_ATTACHMENTS("%s having attachments can not be close", "D0025"),  
			CAN_NOT_CLOSE_ATTACHED_DOC("Attached %s can not be close ", "D0026"),

			//File Exceptions
			BASIC_HEAD_REQUIRED("File Basic Head is required.", "D0027"),
			FILE_CODE_REQUIRED("File Code is required.", "D0028"),
			FILE_NUMBER_ALREADY_EXIST("File cannot be created as File Number already exists", "D0029"),
			FILE_NUMBER_REQUIRED("File Number is required.", "D0030"),
			//CANNOT_CREATE_PART_FILE_OF_PART_OR_VOLUME_FILE("Cannot create part file of part file or volume file", "F0005"),
			//CANNOT_CREATE_VOLUME_FILE_OF_PART_OR_VOLUME_FILE("Cannot create volume file of part file or volume file", "F0006"),
			//VOLUME_FILE_APPLICABLE_FOR_PHYSICAL_FILE("Volume file can only be created for physical file", "F0007"),
			DOC_NOT_ENCLOSED("%s and %s are not enclosed", "D0031"),
			CANNOT_DISCLOSE_ELECTRONIC_DOC_AFTER_MOVEMENT("Electronic document cannot be removed after file has moved", "F0009"),
			PDF_NEEDED_TO_ENCLOSE_ON_ELECTRONIC_FILE("Only receipts having PDF can be enclosed in an electronic file", "D0032"),
			CAN_NOT_REMOVE_REFERENCE_AFTER_MOVEMENT("Local reference can not be removed after Document moved", "D0033"),
			CAN_NOT_PULLUP_ATTACHED_DOC("Attached %s can not be PullUp ", "D0034"),
			CAN_NOT_TRANSFER_ATTACHED_DOC("Attached %s can not be Transfered ", "D0035"),
			
			//Folder
			FOLDER_NOT_EXIST("Folder doesn't exist", "D0036"), //not needed
			FOLDER_NAME_ALREADY_EXIST("Duplicate Folder Name", "D0037"),
			INVALID_FOLDER_NAME("Folder name can not contain special characters!!!", "D0038"),
			FOLDER_NAME_LENGTH_EXCEED("Folder name can not be more than 50 characters!!!", "D0039"),
			CAN_NOT_MOVE_DOC_TO_FOLDER("Not able to move %s to Folder", "D0040"),
			
			//Initiate Action
			CAN_NOT_INITIATE_ACTION_ON_CLOSED_DOC("Can't initiate action on closed document", "D0041"),
			CAN_NOT_COMMENT_ON_CLOSED_DOC("Can't comment on closed document", "D0042"),
			INITIATE_ACTION_FROM_SENT("You can initiate action only for documents that are there in your sent box", "D0043"),
			NO_INITIATED_ACTION_FOR_DOC("No initiated action available for %s", "D0044"),
//			USER_NOT_AUTHORISE_TO_CLOSE_INITIATED_ACTION("Can't close action initiated by another section user", "D0050"),
			ACTION_ALREADY_INITIATED("Already an action has been initiated for this document", "D0045"),
			
			//Movement
			INVALID_RECEIVERS("Invalid receivers", "D0046"),
			SELF_MOVEMENT_NOT_ALLOWED("Self movement not allowed", "D0047"),
			PHYSICAL_DOC_CAN_RECEIVED("Only physical documents can be received", "D0048"),
			//ELECTRONIC_DOC_CAN_READ("Only electronic documents can be read", "D0055"),
			NO_MOVEMENT_FOR_DOC("There are no movements for the given document", "D0049"),
			CHILD_DOC_CAN_NOT_RECEIVED_DIRECTLY("Child documents cannot be received, directly", "D0050"),
			DOC_ALREADY_RECEIVED("Document already received", "D0051"),
			CHILD_DOC_CAN_NOT_PULLBACK_DIRECTLY("Child documents cannot be pulledback, directly", "D0052"),
			//CHILD_DOC_CAN_NOT_MARK_READ_DIRECTLY("Child documents cannot be marked as read, directly", "D0060"),
			DOC_ALREADY_READ("%s has been already read", "D0053"),
			DOC_ALREADY_PULLBACK("%s already pulledback", "D0054"),
			DOC_NOT_SENT_BY_USER("%s was not sent by the user", "D0055"),
			TRANSFER_REMARK_NOT_FOUND("Please provide Transfer remarks", "D0056"),
			INVALID_AUTHORIZATION_DOC("Please upload Authorization Document", "D0057"),
			STANDLONE_DOC_CAN_NOT_SENT_OTHER_INSTANCE("Stanalone %s can't be sent to another instance", "D0058"),
			
			//NOTE
			GREEN_NOTE_ALREADY_EXIST("Can't create green note, already exists.", "D0059"), 
			CAN_NOT_CREATE_GREEN_NOTE_AS_YELLOW_NOTE_ALREADY_EXIST("Green note cannot be created as yellow note already exists.", "D0060"), 
			CAN_NOT_CREATE_YELLOW_NOTE_AS_GREEN_NOTE_ALREADY_EXIST("Yellow note cannot be created as green note already exists.", "D0061"),
			CAN_NOT_CREATE_YELLOW_NOTE_AS_YELLOW_NOTE_ALREADY_EXIST("Yellow note cannot be created as yellow note already exists.", "D0062"),
//			NO_YELLOW_NOTE_EXIST("Yellow Note doesn`t exists", "D0068"), //not needed
			INVALID_PARAMETERS_IN_REFERENCE_LINK("Reference link does not contain valid parameters", "D0063"), //not needed
			INVALID_PAGE_NUMBER_IN_REFERENCE_LINK("Reference link does not contain valid page number", "D0064"), //not needed
			INVALID_NOTEID_IN_REFERENCE_LINK("Reference link does not contain valid note id", "D0065"), //not needed
			
			
			
			//SIGNING
			NO_CONTENT_FOR_SIGNING_IN_DOC("Document doesn`t have any content for signing", "D0066"), //not needed
			CERTIFICATE_ALREADY_REGISTERED_WITH_ACCOUNT("Another certificate is already registered with your account.", "D0067"),
			CERTIFICATE_ALREADY_REGISTERED_WITH_OTHER_USER("Certificate has already been registered by any other user.", "D0068"),
			NO_CRL_SERVICE_EXIST("CRL service doesn`t exists", "D0069"),
			USER_ALREADY_REGISTERED("You are already registered", "D0070"),
			CERTIFICATE_NOT_VALID_FOR_REGISTRATION("Certificate is not valid for registration", "D0071"),
			ACTIVE_CERTIFICATE_NOT_FOUND("No active certificate found", "D0072"),
			CERTIFICATE_NOT_FOUND("No certificate found", "D0073"),
			DSC_SIGN_IN_FAILED("DSC sign failed", "D0074"), 
			USER_NOT_DSC_REGISTERED("User is not DSC registered", "D0075"),
			USER_NOT_HAVE_REGISTERED_CERTIFICATE("User doesn`t have any registered certificates", "D0076"),
			USER_ALREDY_HAVE_ACTIVE_CERTIFICATE("Cannot activate as user is already having an active certificate", "D0078"),
			CERTIFICATE_ALREADY_DEACTIVE("Certificate is already in Deactive mode", "D0079"), //not needed
			
			//USER_NOT_AUTHORISE_TO_UPDATE_FOLDER("User not authorise to update folder", "D0089"),
//			CAN_NOT_CREATE_REMINDER_FOR_REMINDER("Sorry, you can not create reminder in respect to a reminder.", "D0090"), //not needed
//			ALREADY_EXIST_ACKNOWLEDGEMENT("Acknowledgement already get dispatched", "D0091"), //not needed
			NAME_DESIGNATION_CAN_NOT_BE_BLANK_FOR_COMMUNICATION_DETAIL("Name and Designation both can not be blank for communication detail.", "D0080"),
			DOC_NOT_IN_INBOX("%s is not in Inbox", "D0081"),
			DOC_NOT_STANDLONE("%s is not standlone", "D0082"),
			
			//Park
			DUE_DATE_LESS_THAN_CURRENT_DATE("Due date is less than current date", "D0083"),
			DOC_ALREADY_PARK("%s have already active parking", "D0084"),
			DOC_NOT_PARK("%s has no active parking", "D0085"),
			
			//Correspondence
			INVALID_CORRESPONDENCE("Invalid correspondence", "D0086"),
			
			//Search
			//TODO discuss. changed in DTO
//			INVALID_DATE("Invalid date, Please enter valid date!!!", "D0102"), //not needed
//			INVALID_APPROVED_FORM_DATE("Invalid date, Please enter valid approved from date!!!", "D0103"), //not needed
//			INVALID_APPROVED_TO_DATE("Invalid date, Please enter valid approved to date!!!", "D0104"), //not needed
//			INVALID_SIGNED_FROM_DATE("Invalid date, Please enter valid signed from date!!!", "D0105"), //not needed
//			INVALID_SIGNED_TO_DATE("Invalid date, Please enter valid signed to date!!!", "D0106"), //not needed
//			INVALID_DISPATCH_PARAMETER("Please provide valid dispatched parameter!!!", "D0107"), //not needed  
//			INVALID_CREATION_FROM_DATE("Invalid date type, please enter valid creation from date!!!", "D0108"), //not needed   
//			INVALID_CREATION_TO_DATE("Invalid date type, please enter valid creation to date!!!", "D0109"), //not needed  
//			INVALID_MOVEMENT_FROM_DATE("IInvalid date type, please enter valid movment from date!!!", "D0110"), //not needed  
//			INVALID_MOVEMENT_TO_DATE("IInvalid date type, please enter valid movment to date!!!", "D0111"), //not needed  
			
			PROVIDE_SEARCH_SCOPE("Please provide search scope!!!", "D0087"),  
			PROVIDE_SEARCH_SCOPE_E("Please provide search scopeE between 1 to 7!!!", "D0088"),
			PROVIDE_SEARCH_SCOPE_P("Please provide search scopeP between 1 to 7!!!", "D0089"),
//			INVALID_DIARY_FROM_DATE("Invalid date, Please Enter Valid Dairy From Date!!!", "D0115"),  //not needed  
//			INVALID_DIARY_TO_DATE("Invalid date, Please Enter Valid Dairy to Date!!!", "D0116"), //not needed
			
//			USER_NOT_IN_MOVEMENT_OF_DOC_OR_NOT_WITH_USER("User is not in the movement of %s or may not be with the user", "D0117"),  //not needed  
			
//			INVALID_LETTER_FROM_DATE("Invalid date, Please Enter Valid Letter From Date!!!", "D0118"),  //not needed  
//			INVALID_LETTER_TO_DATE("Invalid date, Please Enter Valid Letter to Date!!!", "D0119"), //not needed  
//			INVALID_RECEIVED_FROM_DATE("Invalid date, Please Enter Valid Received From Date!!!", "D0120"),  //not needed  
//			INVALID_RECEIVED_TO_DATE("Invalid date, Please Enter Valid Received to Date!!!", "D0121"), //not needed  
//			INVALID_FORWARD_FROM_DATE("Invalid date, Please Enter Valid Forward From Date!!!", "D0122"), //not needed  
//			INVALID_FORWARD_TO_DATE("Invalid date, Please Enter Valid Forward to Date!!!", "D0123"), //not needed  

			//Acknowledge
			NO_ACKNOWLEDGE_EXIST("Sorry, No Acknowledgement Exist with given ID", "D0090"),  
			USER_NOT_CREATED_ACKNOWLEDGEMENT("Sorry, You have not created given acknowledgement.", "D0091"),  
			NO_OPERATION_ALLOWED_ON_ACKNOWLEDGEMENT_BECAUSE_ALREDY_DISPATCHED("No Operation allowed due to acknowledgement has already dispached.", "D0092"),  
			NO_OPERATION_ALLOWED_ON_ACKNOWLEDGEMENT_BECAUSE_ALREADY_SIGNED("No Operation allowed due to acknowledgement has already signed.", "D0093"),  
			CAN_NOT_ACKNOWLEDGEMENT_CLOSED_DOC("Can't create acknowledgement on closed %s", "D0094"),
			
			//Attachment
			ALREADY_ATTACHED_DOC("Document is already attached", "D0095"),  
			CAN_NOT_ATTACH_DOC_HAVING_ATTACHMENT("Document having attachment can't be attached", "D0096"),   
			ATTACHED_DOC_CAN_NOT_HAVE_ATTACHMENT("Document attached can't have attachment", "D0097"),   
			ONLY_ATTACHED_DOC_CAN_DETACH("%s and %s are not attached", "D0098"),  
			
			//Dispatch
			NO_DISPATCH_EXIST_WITH_PARENT("Dispatch is not exist with provided parent %s.", "D0099"),  
//			NO_DISPATCH_EXIST("Sorry, Dispatch is not exist with provided ID.", "D0131"),  //not needed  
			DOC_ALREADY_DISPATCH("You can not update the information due to document is already dispatched.", "D0100"),  
			NO_OPERATION_ALLOWED_AS_DOC_NOT_WITH_YOU_OR_DOC_NOT_RECEIVED("Either Document is not received or Document is not lying with you so you can not return it.", "D0101"),  
//			CAN_NOT_RESEND_AS_DOC_NOT_WITH_YOU_OR_DOC_NOT_RECEIVED("Either Document is not received or Document is not lying with you so you can not resend it.", "D0134"),  //not needed  
//			CAN_NOT_DISPATCH_AS_DOC_NOT_WITH_YOU_OR_DOC_NOT_RECEIVED("Either Document is not received or Document is not lying with you so you can not dispatch it.", "D0135"),  //not needed  
			SELECT_CRU_AND_DELIEVERY_MODE_FOR_DISPATCH("You have to select CRU and delivery mode for dispatch by CRU.", "D0102"),
			DOC_ALREADY_RECEIVED_BY_USER("%s is already received by you.", "D0103"),  
			PDF_NOT_FOUND_FOR_COMMUNICATION_BY_MAIL("Pdf must be uploaded to dispatch by mail for communication", "D0104"),  
			EMAIL_NOT_FOUND_FOR_COMMUNICATION_BY_MAIL("Email is required to dispatch by mail for communication", "D0105"),  
			EMAIL_SUBJECT_NOT_FOUND_FOR_COMMUNICATION_BY_MAIL("Email Subject is required to dispatch by mail for communication", "D0106"),  
			EMAIL_BODY_NOT_FOUND_FOR_COMMUNICATION_BY_MAIL("Email Body is required to dispatch by mail for communication", "D0107"),  
			ADDRESS_NOT_FOUND_FOR_COMMUNICATION_BY_POST("Address is required to dispatch by post for communication", "D0108"),  
			MISSING_INSTANCE_CODE_FOR_EXTERNAL_USER("Missing instance code for external eoffice user", "D0109"),  
			MISSING_POST_DETAIL_ID_FOR_EOFFICE_USER("Missing post detail id for eoffice user ", "D0110"),  
			INVALID_POST_DETAIL_ID_FOR_INTERNAL_USER("Invalid post detail id for internal eoffice user", "D0111"),  

			FOLLOWUP_NOT_EXIST("Followup doesn't exist", "D0112"),  
			INVALID_FOLLOWUP_STATUS("Followup status should be interim or final", "D0113"),
			FOLLOWUP_STATUS_SHOULD_BE_FINAL("Followup status should be final", "D0114"),
			FOLLOWUP_ALREADY_FINAL("Can't update, Followup is already final", "D0115"),
			
			PDF_CAN_NOT_BLANK("Pdf can not be blank", "D0116"),  
//			CAN_NOT_CREATE_PART_FILE_FOR_CLOSED_DOC("Cannot create part file of closed document", "D0140"),  //not needed  
//			CAN_NOT_CREATE_VOLUME_FILE_FOR_CLOSED_DOC("Cannot create volume file of closed document", "D0141"),  //not needed  
//			CAN_NOT_SIGN_FOR_CLOSED_DOC("Cannot sign on closed document", "D0142"),  //not needed  
			
			UNAUTHORIZED_DELEGATED_POST("Unauthorized access to delegated post", "D0117"),
			PHYSICAL_DOC_SHOULD_BE_RECEIVED("Physical %s should be received", "D0118"),

			USER_OF_DIFF_SECTION("User is not of same section", "D0119"),
//			DOC_CLOSED("%s is closed", "D0151"),  //not needed  
			
			//Link
			FILES_NOT_LINKED("%s and %s are not linked", "D0120"),
			SELF_LINK_NOT_ALLOWED("%s can't be linked with itself", "D0021"),
			ALREADY_LINKED_DOC("%s and %s are already linked", "D0122"),
			
			//Merge
			ONLY_PHYSICAL_DOC_CAN_MERGE("Only physical %s can be merged", "D0123"),
			SELF_MERGE_NOT_ALLOWED("Can Not merge same parent and child docId %s", "D0124"),
			
			//Migration
			FILE_ALREADY_MIGRATED("File already migrated", "D0125"),
			NO_MIGRATION_EXISTS("No migration exists for the given number", "D0126"),  
			INVALID_SCOPE("Invalid scope for %s pullUp", "D0155"),  
//			ACTION_NOT_ALLOWED("This Action not allowed", "D0156"),  //not needed  
			CAN_NOT_OPERATE_ON_PENDING_CONVERSION_DOC("Can't work on pending conversion %s", "D0157"),  
			CAN_NOT_OPERATE_ON_PENDING_MIGRATION_DOC("Can't work on pending migration %s", "D0158"),  
			OPENING_DATE_REQUIRED("Opening date is missing", "D0159"),
			OLD_FILE_NO_REQUIRED("Migrated file number is missing", "D0160"),
			INVALID_OPENING_DATE("Openign date should not be future date", "D0161"), 
			INVALID_DISPATCH_DATE("Dispatch date should not be future date", "D0162"),
//			NOT_TOC_PDF("PDF is not of receipt or issue", "D0164"), //not needed  
			INVALID_DIARY_DATE("Diary date should not be future date", "D0163"),
			CAN_NOT_PULLUP_EXTERNALLY_MOVED_DOC("Externally %s can not be Pulled up", "D0164"),
			CAN_NOT_PULL_OWN_DOC("User already have %s", "D00165"),
			NOT_ALL_CORRESPONDENCE_MIGRATED("You have to create correspondences for all uploaded PDF before finalizing", "D0166"),
			INVALID_MIGRATION_PDF("No PDF present with the given name", "D0167"),
			SUBJECT_REQUIRED("Draft subject cannot be empty", "D0168"),
			FILE_ALREADY_UNDER_MIGRATION("File already under migration", "D0169"),
			DOC_NOT_UNDER_MIGRATION("%s not under migration", "D0170"),
			INVALID_ISSUE_TYPE("Invalid issue type", "D0171"), 
			DRAFT_TYPE_REQUIRED("Draft type is required", "D0172"),
//			ENCLOSED_DOC_NOT_FOUND("%s and %s are not enclosed", "D0175"), //not needed
			CAN_NOT_ENCLOSE_ATTACHED_DOC("Attached %s can not be enclosed ", "D0173"),
			ENCLOSED_DOC_ALREADY_MARKED("Cannot mark as %s is already marked","D0174"),
			ENCLOSED_DOC_NOT_MARKED("%s is not marked", "D0175"),
			CAN_NOT_UNMARK_ENCLOSED_DOC("Cannot unmark enclosed %s document", "D0176"), 
			ENCLOSED_DOC_NOT_MARKED_AS_PUC("%s is not marked as PUC", "D0177"),
			CAN_NOT_DISCARD_YELLOW_NOTE("Cannot discard yellow note", "D0178"),	
			YELLOW_NOTE_LOCK_EXPIRED("Yellow note has been updated by another session", "D0179"),
			GREEN_NOTE_LOCK_EXPIRED("Green note has been updated by another session", "D0180"),
//			ONLY_LATEST_CAN_BE_DELETED_VERSION("Only latest version can be deleted", "D0175"), //not needed 
			NOT_PERMITTED_FOR_DIR("User not have access permission for Directory", "D0181"), //not needed 
//			USER_NOT_AUTHORISE_TO_PERMIT_FOLDER("User not authorise to give permission to folder", "D0181"), //not needed 

			//INVALID_DISPATCH_ID("Invalid Dispatch Id!!!", "D0184"),
			DOC_NOT_IN_FOLDER("Document dose not belong to this folder", "D0181"),//not needed 

			START_RANGE_IS_GREATER_THAN_END_RANGE("Start range is greater than end range!", "D0182"),
			START_RANGE_IS_LESS_THAN_OR_EQUAL_TO_ZERO("Start range is less than or equal to 0!", "D0183"),
			START_RANGE_IS_GREATER_THAN_LIMIT("Start range is beyond limit!", "D0184"),
			END_RANGE_IS_GREATER_THAN_LIMIT("End range is beyond limit!", "D0185"),

//			CLOSED_DOC_CAN_NOT_ACKNOWLEDGE("Can't acknowledge closed %s", "D0003"), //not needed 
			
//			CLOSED_DOC_CAN_NOT_HAVE_NOTE("Closed document can't have note", "D0005"); //not needed 
			
			EXTERNAL_MOVEMENT_NOT_ALLOWED_FOR_FILE_WITH_ATTACHMENT("%s is having attachment and can't be sent to another instance", "D0186"),
			FOLLOWUP_REMARK_REQUIRED("Followp remarks required", "D0187"),
			FOLLOWUP_REPLY_DATE_REQUIRED("Followp reply date required", "D0188"),
			FOLLOWUP_STATUS_REQUIRED("Followp status required", "D0189"),

			SELECT_USER("Please select user", "D0190"),
			NO_SEARCH_PRIVILEGES_FOR_USER("No search privileges found for the user", "D0191"),
			INVALID_DEALING_SECTION("Assign to dealing section doesn`t exists", "D0192"),
			DOCUMENT_DEALING_SECTION_CANNOT_BE_CHANGED("Document dealing section cannot be changed", "D0193"), 
			LOGIN_NAME_ALREADY_EXIST("Login Name already exists", "D0194"), 
			LOGIN_NAME_DOES_NOT_EXIST("Login name doesn`t exists", "D0195"), 
		
		
			CANT_CREATE_DRAFT_ON_REMAINDER("Can't create draft on a remainder", "D0196"),
			DOC_NOT_IN_SENT("%s is not in Sent", "D0197"), 
			INVALID_SEARCH_SCOPE("Search is not allowed in selected scope","D0198"),
			INVALID_PARENT_DOCUMNET_ID("You have provided invalid parameters for parent document id.", "D0199"),
			DRAFT_ALREADY_SIGNED("Draft is already signed.", "D0200"),
			SIGNED_DOC_NOT_FOUND("Can't finalize, no document on this draft %s.", "D0201"),
			DRAFT_NOT_APPROVED("Can't ink sign, Draft %s is not approved.", "D0202"),
			DRAF_APPROVER_CAN_INK_SIGN("Only draft approver section can upload the ink sign copy.", "D0203"),
			INK_SIGN_NOT_INITIATED("Ink sign is not initiated on this draft.", "D0204"),
			MULTIPLE_SIGNING_NOT_ALLOWED("Can't finalize, multiple signing is not applicable for this draft %s.", "D0205"),
			DRAFT_NOT_SIGNED("Can't finalize, Draft {} is not yet signed.", "D0206"),
			INVALID_DRAFT_VERSION("Incorrect version provided", "D0207");
			
			
			private String text;
			private String code;
			
			private ExceptionName(String text, String code) {
				
				this.text = text;
				this.code = code;
				
			}
			
			public String getCode() {
				return code;
			}
			
			public String getText() {
				return text;
			}
			
			
		}
		
		
		public DomainException(String message) {
			super(message);
		
		}

		public DomainException(String message,String code) {
			super(message);
			this.code = code;
		}
		
		/*public DomainException(String message,String code, Map<DocumentId, String> documentIds) {
			super(message);
			this.code = code;
			this.documentIds = documentIds;
		}*/
		

	protected DomainException() {
		super();
	}

	public static void main(String[] args) {
		//System.out.println(ExceptionName.values());
		ExceptionName[] values = ExceptionName.values();
		String[] names = new String[values.length];
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < names.length; i++) {
			String txt = "\""+ values[i].getText().replace("%s", "$") +"\"";
			System.out.println("\"" + values[i].getCode()+ "\"" + " : " + txt + ",");
			map.put("\"" + values[i].getCode() + "\"","\""+ txt+"\"");
			//System.out.println(map);
		}
	}

}
