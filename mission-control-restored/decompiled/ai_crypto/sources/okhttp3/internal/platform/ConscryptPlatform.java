package okhttp3.internal.platform;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes2.dex */
public class ConscryptPlatform extends Platform {
    private ConscryptPlatform() {
    }

    public static ConscryptPlatform u() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new ConscryptPlatform();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void f(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void g(SSLSocket sSLSocket, String str, List list) {
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.g(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setHostname(sSLSocket, str);
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) Platform.b(list).toArray(new String[0]));
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext n() {
        try {
            return SSLContext.getInstance("TLSv1.3", v());
        } catch (NoSuchAlgorithmException e7) {
            try {
                return SSLContext.getInstance("TLS", v());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e7);
            }
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String o(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.o(sSLSocket);
    }

    public final Provider v() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }
}
