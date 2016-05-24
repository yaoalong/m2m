package lab.mars.m2m.protocol;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by haixiao on 14/12/16.
 * ISO_LOCAL_DATE_TIME
 */
public class DateAdapter extends XmlAdapter<String, Date> {
    private DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public Date unmarshal(String v) throws Exception {
        return Date.from(LocalDateTime.parse(v, formatter).toInstant(ZoneOffset.UTC));
    }

    @Override
    public String marshal(Date v) throws Exception {
        return LocalDateTime.ofInstant(v.toInstant(), ZoneId.systemDefault()).format(formatter);
    }
}
