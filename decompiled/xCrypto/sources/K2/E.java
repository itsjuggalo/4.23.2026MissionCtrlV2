package K2;

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

/* JADX INFO: loaded from: classes3.dex */
public final class E {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f1020f = Logger.getLogger(E.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final E f1021g = new E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentNavigableMap f1022a = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentNavigableMap f1023b = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentMap f1024c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentMap f1025d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentMap f1026e = new ConcurrentHashMap();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f1027a;

        public b(c cVar) {
            this.f1027a = (c) Z1.m.n(cVar);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Certificate f1029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Certificate f1030c;

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
            } catch (SSLPeerUnverifiedException e4) {
                E.f1020f.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e4);
            }
            this.f1028a = cipherSuite;
            this.f1029b = certificate2;
            this.f1030c = certificate;
        }
    }

    public static void b(Map map, J j4) {
    }

    public static long f(P p4) {
        return p4.h().d();
    }

    public static E g() {
        return f1021g;
    }

    public static void h(Map map, J j4) {
    }

    public void c(J j4) {
        b(this.f1025d, j4);
    }

    public void d(J j4) {
        b(this.f1023b, j4);
    }

    public void e(J j4) {
        b(this.f1024c, j4);
    }

    public void i(J j4) {
        h(this.f1025d, j4);
    }

    public void j(J j4) {
        h(this.f1023b, j4);
    }

    public void k(J j4) {
        h(this.f1024c, j4);
    }
}
