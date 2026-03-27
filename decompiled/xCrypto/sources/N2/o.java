package N2;

import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f3079a = Collections.unmodifiableList(Arrays.asList(O2.i.HTTP_2));

    public static String a(String str) {
        return (str.startsWith("[") && str.endsWith("]")) ? str.substring(1, str.length() - 1) : str;
    }

    public static SSLSocket b(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i4, O2.b bVar) throws SSLPeerUnverifiedException {
        Z1.m.o(sSLSocketFactory, "sslSocketFactory");
        Z1.m.o(socket, "socket");
        Z1.m.o(bVar, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i4, true);
        bVar.c(sSLSocket, false);
        String strH = k.e().h(sSLSocket, str, bVar.f() ? f3079a : null);
        List list = f3079a;
        Z1.m.w(list.contains(O2.i.a(strH)), "Only " + list + " are supported, but negotiated protocol is %s", strH);
        if (hostnameVerifier == null) {
            hostnameVerifier = O2.f.f3256a;
        }
        if (hostnameVerifier.verify(a(str), sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
