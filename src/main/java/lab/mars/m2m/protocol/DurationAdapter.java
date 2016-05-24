package lab.mars.m2m.protocol;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.Duration;

/**
 * Created by haixiao on 14/12/16.
 * Duration
 */
public class DurationAdapter extends XmlAdapter<String, Duration> {

    @Override
    public Duration unmarshal(String v) throws Exception {
        return Duration.parse(v);
    }

    @Override
    public String marshal(Duration v) throws Exception {
        return v.toString();
    }
}
