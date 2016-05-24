package lab.mars.m2m.protocol.enumeration;

import lab.mars.m2m.protocol.resource.*;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
public interface m2m_resourceType {
    int accessControlPolicy = 1;
    int AE = 2;
    int container = 3;
    int contentInstance = 4;
    int CSEBase = 5;
    int delivery = 6;
    int eventConfig = 7;
    int execInstance = 8;
    //    @XmlEnumValue("9")fanOutPoint,
    int group = 9;
    int localPolicy = 10;
    int m2mServiceSubscription = 11;
    int mgmtCmd = 12;
    int mgmtObj = 13;
    int node = 14;
    //    @XmlEnumValue("15")nodeInfo,
    int pollingChannel = 15;
    int remoteCSE = 16;
    int request = 17;
    int schedule = 18;
    int serviceSubscribedNode = 19;
    int statsCollect = 20;
    int statsConfig = 21;
    int subscription = 22;
    int accessControlPolicyAnnc = 10001;
    int AEAnnc = 10002;
    int containerAnnc = 10003;
    int contentInstanceAnnc = 10004;
    int groupAnnc = 10009;
    int localPolicyAnnc = 10010;
    int mgmtObjAnnc = 10013;
    int nodeAnnc = 10014;
    int remoteCSEAnnc = 10016;
    int scheduleAnnc = 10018;

    static Class clzForType(int ty) {
        //TODO complete all the ty to clz cases
        switch (ty) {
            case accessControlPolicy: return m2m_AccessControlPolicy.class;
            case AE: return m2m_AE.class;
            case container: return m2m_Container.class;
            case contentInstance: return m2m_ContentInstance.class;
            case CSEBase: return m2m_CSEBase.class;
            case subscription: return m2m_Subscription.class;
            case group: return m2m_Group.class;
            default:
                return null;
        }
    }

    static String stringForType(int ty) {
        //TODO complete all the ty to string cases
        switch (ty) {
            case accessControlPolicy: return "accessControlPolicy";
            case AE: return "AE";
            case container: return "container";
            case contentInstance: return "contentInstance";
            case CSEBase: return "CSEBase";
            case subscription: return "subscription";
            case group: return "group";
            default:
                return "undefined";
        }
    }

    static int typeForString(String name) {
        switch (name) {
            case "accessControlPolicy": return accessControlPolicy;
            case "AE": return AE;
            case "container": return container;
            case "contentInstance": return contentInstance;
            case "CSEBase": return CSEBase;
            case "subscription": return subscription;
            case "group": return group;
            case "undefined":default:
                return 0;
        }
    }
}
