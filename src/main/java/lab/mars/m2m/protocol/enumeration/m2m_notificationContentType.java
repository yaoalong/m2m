package lab.mars.m2m.protocol.enumeration;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
public interface m2m_notificationContentType {
    int modifiedAttributes = 1;
    int wholeResource = 2;
    int referenceOnly = 3;
}
