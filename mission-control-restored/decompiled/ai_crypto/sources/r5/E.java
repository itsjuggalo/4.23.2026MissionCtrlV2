package r5;

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

/* JADX INFO: loaded from: classes2.dex */
public final class E {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f22510f = Logger.getLogger(E.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final E f22511g = new E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentNavigableMap f22512a = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentNavigableMap f22513b = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentMap f22514c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentMap f22515d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentMap f22516e = new ConcurrentHashMap();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f22517a;

        public b(c cVar) {
            this.f22517a = (c) H2.m.n(cVar);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Certificate f22519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Certificate f22520c;

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
            } catch (SSLPeerUnverifiedException e7) {
                E.f22510f.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e7);
            }
            this.f22518a = cipherSuite;
            this.f22519b = certificate2;
            this.f22520c = certificate;
        }
    }

    public static void b(Map map, J j7) {
    }

    public static long f(P p7) {
        return p7.h().d();
    }

    public static E g() {
        return f22511g;
    }

    public static void h(Map map, J j7) {
    }

    public void c(J j7) {
        b(this.f22515d, j7);
    }

    public void d(J j7) {
        b(this.f22513b, j7);
    }

    public void e(J j7) {
        b(this.f22514c, j7);
    }

    public void i(J j7) {
        h(this.f22515d, j7);
    }

    public void j(J j7) {
        h(this.f22513b, j7);
    }

    public void k(J j7) {
        h(this.f22514c, j7);
    }
}
