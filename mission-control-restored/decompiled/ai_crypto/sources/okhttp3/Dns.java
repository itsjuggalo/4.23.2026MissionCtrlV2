package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface Dns {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Dns f20476a = new Dns() { // from class: okhttp3.Dns.1
        @Override // okhttp3.Dns
        public List a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e7) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e7);
                throw unknownHostException;
            }
        }
    };

    List a(String str);
}
