package H4;

import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f3936a = Collections.unmodifiableList(Arrays.asList(I4.i.HTTP_2));

    public static String a(String str) {
        return (str.startsWith("[") && str.endsWith("]")) ? str.substring(1, str.length() - 1) : str;
    }

    public static SSLSocket b(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i8, I4.b bVar) throws SSLPeerUnverifiedException {
        AbstractC2848n.o(sSLSocketFactory, "sslSocketFactory");
        AbstractC2848n.o(socket, "socket");
        AbstractC2848n.o(bVar, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i8, true);
        bVar.c(sSLSocket, false);
        String strH = k.e().h(sSLSocket, str, bVar.f() ? f3936a : null);
        List list = f3936a;
        AbstractC2848n.x(list.contains(I4.i.a(strH)), "Only " + list + " are supported, but negotiated protocol is %s", strH);
        if (hostnameVerifier == null) {
            hostnameVerifier = I4.f.f4242a;
        }
        if (hostnameVerifier.verify(a(str), sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
