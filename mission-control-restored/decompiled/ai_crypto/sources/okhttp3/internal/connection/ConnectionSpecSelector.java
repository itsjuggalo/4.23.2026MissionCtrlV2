package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionSpecSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f20775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20776b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20778d;

    public ConnectionSpecSelector(List list) {
        this.f20775a = list;
    }

    public ConnectionSpec a(SSLSocket sSLSocket) throws UnknownServiceException {
        ConnectionSpec connectionSpec;
        int i7 = this.f20776b;
        int size = this.f20775a.size();
        while (true) {
            if (i7 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = (ConnectionSpec) this.f20775a.get(i7);
            if (connectionSpec.c(sSLSocket)) {
                this.f20776b = i7 + 1;
                break;
            }
            i7++;
        }
        if (connectionSpec != null) {
            this.f20777c = c(sSLSocket);
            Internal.f20668a.c(connectionSpec, sSLSocket, this.f20778d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f20778d + ", modes=" + this.f20775a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f20778d = true;
        if (!this.f20777c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z7 = iOException instanceof SSLHandshakeException;
        if ((z7 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z7 || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }

    public final boolean c(SSLSocket sSLSocket) {
        for (int i7 = this.f20776b; i7 < this.f20775a.size(); i7++) {
            if (((ConnectionSpec) this.f20775a.get(i7)).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
