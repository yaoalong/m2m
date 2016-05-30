package lab.mars.onem2m.client;

import org.lab.mars.onem2m.M2mKeeperException;
import org.lab.mars.onem2m.OneM2m;

import java.io.IOException;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class OneM2MClient {
    OneM2m oneM2m;

    public OneM2MClient(String client) {
        oneM2m = new OneM2m(client);
    }

    public void create(String path, byte[] data) throws IOException, M2mKeeperException {
        oneM2m.create(path, data);
    }

    public void delete(String path) throws M2mKeeperException {
        oneM2m.delete(path);
    }

    public void setData(String path, byte[] data) throws M2mKeeperException {
        oneM2m.setData(path, data);
    }

    public byte[] getData(String path) throws M2mKeeperException {
        return oneM2m.getData(path);
    }

}
