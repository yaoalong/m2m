package lab.mars.m2m.protocol;

import lab.mars.m2m.protocol.common.m2m_childResourceRef;

import java.util.List;

/**
 * Created by haixiao on 2015/5/13.
 * Email: wumo@outlook.com
 */
public interface HasChildren {
    List<m2m_childResourceRef> children();

    void setChildren(List<m2m_childResourceRef> children);

    void remove(m2m_childResourceRef child);
    void add(m2m_childResourceRef child);
}
