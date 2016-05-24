package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_memberType {
//    @XmlEnumValue("1")accessControlPolicy,
//    @XmlEnumValue("2")AE,
//    @XmlEnumValue("3")container,
//    @XmlEnumValue("4")contentInstance,
//    @XmlEnumValue("5")CSEBase,
//    @XmlEnumValue("6")Delivery,
//    @XmlEnumValue("7")eventConfig,
//    @XmlEnumValue("8")execInstance,
//    @XmlEnumValue("9")fanOutPoint,
//    @XmlEnumValue("10")group,
//    @XmlEnumValue("11")localPolicy,
//    @XmlEnumValue("12")m2mServiceSubscription,
//    @XmlEnumValue("13")mgmtCmd,
//    @XmlEnumValue("14")mgmtObj,
//    @XmlEnumValue("15")node,
//    @XmlEnumValue("16")nodeInfo,
//    @XmlEnumValue("17")pollingChannel,
//    @XmlEnumValue("18")remoteCSE,
//    @XmlEnumValue("19")request,
//    @XmlEnumValue("20")schedule,
//    @XmlEnumValue("21")statsCollect,
//    @XmlEnumValue("22")statsConfig,
//    @XmlEnumValue("23")subscription,
//    @XmlEnumValue("24")mixed;

    @XmlEnumValue("1")accessControlPolicy(1),
    @XmlEnumValue("2")AE(2),
    @XmlEnumValue("3")container(3),
    @XmlEnumValue("4")contentInstance(4),
    @XmlEnumValue("5")CSEBase(5),
    @XmlEnumValue("6")Delivery(6),
    @XmlEnumValue("7")eventConfig(7),
    @XmlEnumValue("8")execInstance(8),
//    @XmlEnumValue("9")fanOutPoint(9),
    @XmlEnumValue("9")group(9),
    @XmlEnumValue("10")localPolicy(10),
    @XmlEnumValue("11")m2mServiceSubscription(11),
    @XmlEnumValue("12")mgmtCmd(12),
    @XmlEnumValue("13")mgmtObj(13),
    @XmlEnumValue("14")node(14),
//    @XmlEnumValue("16")nodeInfo(16),
    @XmlEnumValue("15")pollingChannel(15),
    @XmlEnumValue("16")remoteCSE(16),
    @XmlEnumValue("17")request(17),
    @XmlEnumValue("18")schedule(18),
    @XmlEnumValue("19")serviceSubscribedNode(19),
    @XmlEnumValue("20")statsCollect(20),
    @XmlEnumValue("21")statsConfig(21),
    @XmlEnumValue("22")subscription(22),
    @XmlEnumValue("23")mixed(23);

    private int ty;

    m2m_memberType(int ty) {
        this.ty = ty;
    }

    public int type() {
        return this.ty;
    }

}
