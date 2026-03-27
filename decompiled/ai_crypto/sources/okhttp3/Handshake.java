package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class Handshake {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TlsVersion f20485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CipherSuite f20486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f20487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f20488d;

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List list, List list2) {
        this.f20485a = tlsVersion;
        this.f20486b = cipherSuite;
        this.f20487c = list;
        this.f20488d = list2;
    }

    public static Handshake b(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        CipherSuite cipherSuiteA = CipherSuite.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion tlsVersionA = TlsVersion.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listT = peerCertificates != null ? Util.t(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new Handshake(tlsVersionA, cipherSuiteA, listT, localCertificates != null ? Util.t(localCertificates) : Collections.emptyList());
    }

    public static Handshake c(TlsVersion tlsVersion, CipherSuite cipherSuite, List list, List list2) {
        if (tlsVersion == null) {
            throw new NullPointerException("tlsVersion == null");
        }
        if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, Util.s(list), Util.s(list2));
        }
        throw new NullPointerException("cipherSuite == null");
    }

    public CipherSuite a() {
        return this.f20486b;
    }

    public List d() {
        return this.f20488d;
    }

    public List e() {
        return this.f20487c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return this.f20485a.equals(handshake.f20485a) && this.f20486b.equals(handshake.f20486b) && this.f20487c.equals(handshake.f20487c) && this.f20488d.equals(handshake.f20488d);
    }

    public TlsVersion f() {
        return this.f20485a;
    }

    public int hashCode() {
        return ((((((527 + this.f20485a.hashCode()) * 31) + this.f20486b.hashCode()) * 31) + this.f20487c.hashCode()) * 31) + this.f20488d.hashCode();
    }
}
