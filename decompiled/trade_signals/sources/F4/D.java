package F4;

import java.security.cert.Certificate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f1607f = Logger.getLogger(D.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final D f1608g = new D();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentNavigableMap f1609a = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentNavigableMap f1610b = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentMap f1611c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentMap f1612d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentMap f1613e = new ConcurrentHashMap();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f1614a;

        public b(c cVar) {
            this.f1614a = (c) AbstractC2848n.n(cVar);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Certificate f1616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Certificate f1617c;

        public c(SSLSession sSLSession) {
            String cipherSuite = sSLSession.getCipherSuite();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            Certificate certificate = null;
            Certificate certificate2 = localCertificates != null ? localCertificates[0] : null;
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                if (peerCertificates != null) {
                    certificate = peerCertificates[0];
                }
            } catch (SSLPeerUnverifiedException e8) {
                D.f1607f.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e8);
            }
            this.f1615a = cipherSuite;
            this.f1616b = certificate2;
            this.f1617c = certificate;
        }
    }

    public static void b(Map map, I i8) {
    }

    public static long f(N n8) {
        return n8.h().d();
    }

    public static D g() {
        return f1608g;
    }

    public static void h(Map map, I i8) {
    }

    public void c(I i8) {
        b(this.f1612d, i8);
    }

    public void d(I i8) {
        b(this.f1610b, i8);
    }

    public void e(I i8) {
        b(this.f1611c, i8);
    }

    public void i(I i8) {
        h(this.f1612d, i8);
    }

    public void j(I i8) {
        h(this.f1610b, i8);
    }

    public void k(I i8) {
        h(this.f1611c, i8);
    }
}
