package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public enum m2m_responseStatusCodeType
{
    @XmlEnumValue("1")Success,
    @XmlEnumValue("2")Accepted,
    @XmlEnumValue("3")Location_info_not_authorized,
    @XmlEnumValue("4")Unsupported_resource,
    @XmlEnumValue("5")Unsupported_attribute,
    @XmlEnumValue("6")Cannot_forward_target_not_reachable,
    @XmlEnumValue("7")Cannot_forward_other_reason_TBD,
    @XmlEnumValue("8")Create_error_no_privilege,
    @XmlEnumValue("9")Create_error_already_exists,
    @XmlEnumValue("10")Create_error_missing_mandatory_parameter,
    @XmlEnumValue("11")Retrieve_error_no_privilege,
    @XmlEnumValue("12")Retrieve_error_does_not_exist,
    @XmlEnumValue("13")Update_error_no_privilege,
    @XmlEnumValue("14")Update_error_does_not_exist,
    @XmlEnumValue("15")Update_error_unacceptable_contents,
    @XmlEnumValue("16")Delete_error_does_not_exist,
    @XmlEnumValue("17")Delete_error_no_privilege,
    @XmlEnumValue("18")Create_delivery_not_able_to_take_on_responsibility,
    @XmlEnumValue("19")Create_fanoutpoint_group_request_identifier_exists,
    @XmlEnumValue("20")Retrieve_fanoutpoint_group_request_identifier_exists,
    @XmlEnumValue("21")Update_fanoutpoint_group_request_identifier_exists,
    @XmlEnumValue("22")Delete_fanoutpoint_group_request_identifier_exists,
    @XmlEnumValue("23")Create_mgmtObj_memory_shortage,
    @XmlEnumValue("24")External_object_not_found,
    @XmlEnumValue("25")Cancel_execInstance_not_cancellable,
    @XmlEnumValue("26")Cancel_execInstance_already_complete,
    @XmlEnumValue("27")Delete_execInstance_not_cancellable,
    @XmlEnumValue("28")Delete_execInstance_already_complete,
    @XmlEnumValue("29")Retrieve_CSEBase_format_error,
    @XmlEnumValue("30")CMDH_rules_non_compliant,
    @XmlEnumValue("31")Target_is_not_subscribable,
    @XmlEnumValue("32")Cannot_initiate_subscription_verification,
    @XmlEnumValue("33")Subscription_verification_failed;


    public static int encode(m2m_responseStatusCodeType c) {
        switch (c) {
            case Success:
                return 1;
            case Accepted:
                return 2;
            case Location_info_not_authorized:
                return 3;
            case Unsupported_resource:
                return 4;
            case Unsupported_attribute:
                return 5;
            case Cannot_forward_target_not_reachable:
                return 6;
            case Cannot_forward_other_reason_TBD:
                return 7;
            case Create_error_no_privilege:
                return 8;
            case Create_error_already_exists:
                return 9;
            case Create_error_missing_mandatory_parameter:
                return 10;
            case Retrieve_error_no_privilege:
                return 11;
            case Retrieve_error_does_not_exist:
                return 12;
            case Update_error_no_privilege:
                return 13;
            case Update_error_does_not_exist:
                return 14;
            case Update_error_unacceptable_contents:
                return 15;
            case Delete_error_does_not_exist:
                return 16;
            case Delete_error_no_privilege:
                return 17;
            case Create_delivery_not_able_to_take_on_responsibility:
                return 18;
            case Create_fanoutpoint_group_request_identifier_exists:
                return 19;
            case Retrieve_fanoutpoint_group_request_identifier_exists:
                return 20;
            case Update_fanoutpoint_group_request_identifier_exists:
                return 21;
            case Delete_fanoutpoint_group_request_identifier_exists:
                return 22;
            case Create_mgmtObj_memory_shortage:
                return 23;
            case External_object_not_found:
                return 24;
            case Cancel_execInstance_not_cancellable:
                return 25;
            case Cancel_execInstance_already_complete:
                return 26;
            case Delete_execInstance_not_cancellable:
                return 27;
            case Delete_execInstance_already_complete:
                return 28;
            case Retrieve_CSEBase_format_error:
                return 29;
            case CMDH_rules_non_compliant:
                return 30;
            case Target_is_not_subscribable:
                return 31;
            case Cannot_initiate_subscription_verification:
                return 32;
            case Subscription_verification_failed:
                return 33;
        }
        return 0;
    }

    public static m2m_responseStatusCodeType decode(String rsc) {
        switch (rsc) {
            case "1": return Success;
            case "2": return Accepted;
            case "3": return Location_info_not_authorized;
            case "4": return Unsupported_resource;
            case "5": return Unsupported_attribute;
            case "6": return Cannot_forward_target_not_reachable;
            case "7": return Cannot_forward_other_reason_TBD;
            case "8": return Create_error_no_privilege;
            case "9": return Create_error_already_exists;
            case "10": return Create_error_missing_mandatory_parameter;
            case "11": return Retrieve_error_no_privilege;
            case "12": return Retrieve_error_does_not_exist;
            case "13": return Update_error_no_privilege;
            case "14": return Update_error_does_not_exist;
            case "15": return Update_error_unacceptable_contents;
            case "16": return Delete_error_does_not_exist;
            case "17": return Delete_error_no_privilege;
            case "18": return Create_delivery_not_able_to_take_on_responsibility;
            case "19": return Create_fanoutpoint_group_request_identifier_exists;
            case "20": return Retrieve_fanoutpoint_group_request_identifier_exists;
            case "21": return Update_fanoutpoint_group_request_identifier_exists;
            case "22": return Delete_fanoutpoint_group_request_identifier_exists;
            case "23": return Create_mgmtObj_memory_shortage;
            case "24": return External_object_not_found;
            case "25": return Cancel_execInstance_not_cancellable;
            case "26": return Cancel_execInstance_already_complete;
            case "27": return Delete_execInstance_not_cancellable;
            case "28": return Delete_execInstance_already_complete;
            case "29": return Retrieve_CSEBase_format_error;
            case "30": return CMDH_rules_non_compliant;
            case "31": return Target_is_not_subscribable;
            case "32": return Cannot_initiate_subscription_verification;
            case "33": return Subscription_verification_failed;
            default: return null;
        }
    }
}
