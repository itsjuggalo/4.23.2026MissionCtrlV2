package rb;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f19535f = Logger.getLogger(e0.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e0 f19536g = new e0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentNavigableMap f19537a = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentNavigableMap f19538b = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentMap f19539c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentMap f19540d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentMap f19541e = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f19542a;

        public b(c cVar) {
            this.f19542a = (c) p6.n.n(cVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Certificate f19544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Certificate f19545c;

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
            } catch (SSLPeerUnverifiedException e10) {
                e0.f19535f.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e10);
            }
            this.f19543a = cipherSuite;
            this.f19544b = certificate2;
            this.f19545c = certificate;
        }
    }

    public static void b(Map map, j0 j0Var) {
    }

    public static long f(p0 p0Var) {
        return p0Var.f().d();
    }

    public static e0 g() {
        return f19536g;
    }

    public static void h(Map map, j0 j0Var) {
    }

    public void c(j0 j0Var) {
        b(this.f19540d, j0Var);
    }

    public void d(j0 j0Var) {
        b(this.f19538b, j0Var);
    }

    public void e(j0 j0Var) {
        b(this.f19539c, j0Var);
    }

    public void i(j0 j0Var) {
        h(this.f19540d, j0Var);
    }

    public void j(j0 j0Var) {
        h(this.f19538b, j0Var);
    }

    public void k(j0 j0Var) {
        h(this.f19539c, j0Var);
    }
}
