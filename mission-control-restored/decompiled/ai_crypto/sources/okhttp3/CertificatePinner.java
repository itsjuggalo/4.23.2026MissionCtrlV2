package okhttp3;

import com.revenuecat.purchases.common.Constants;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import w6.C2795h;

/* JADX INFO: loaded from: classes2.dex */
public final class CertificatePinner {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CertificatePinner f20299c = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f20300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CertificateChainCleaner f20301b;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f20302a = new ArrayList();

        public CertificatePinner a() {
            return new CertificatePinner(new LinkedHashSet(this.f20302a), null);
        }
    }

    public static final class Pin {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f20304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f20305c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C2795h f20306d;

        public boolean a(String str) {
            if (!this.f20303a.startsWith("*.")) {
                return str.equals(this.f20304b);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 == this.f20304b.length()) {
                String str2 = this.f20304b;
                if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                if (this.f20303a.equals(pin.f20303a) && this.f20305c.equals(pin.f20305c) && this.f20306d.equals(pin.f20306d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f20303a.hashCode()) * 31) + this.f20305c.hashCode()) * 31) + this.f20306d.hashCode();
        }

        public String toString() {
            return this.f20305c + this.f20306d.a();
        }
    }

    public CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner) {
        this.f20300a = set;
        this.f20301b = certificateChainCleaner;
    }

    public static String c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + e((X509Certificate) certificate).a();
    }

    public static C2795h d(X509Certificate x509Certificate) {
        return C2795h.A(x509Certificate.getPublicKey().getEncoded()).F();
    }

    public static C2795h e(X509Certificate x509Certificate) {
        return C2795h.A(x509Certificate.getPublicKey().getEncoded()).G();
    }

    public void a(String str, List list) {
        List listB = b(str);
        if (listB.isEmpty()) {
            return;
        }
        CertificateChainCleaner certificateChainCleaner = this.f20301b;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.a(list, str);
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i7);
            int size2 = listB.size();
            C2795h c2795hE = null;
            C2795h c2795hD = null;
            for (int i8 = 0; i8 < size2; i8++) {
                Pin pin = (Pin) listB.get(i8);
                if (pin.f20305c.equals("sha256/")) {
                    if (c2795hE == null) {
                        c2795hE = e(x509Certificate);
                    }
                    if (pin.f20306d.equals(c2795hE)) {
                        return;
                    }
                } else {
                    if (!pin.f20305c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.f20305c);
                    }
                    if (c2795hD == null) {
                        c2795hD = d(x509Certificate);
                    }
                    if (pin.f20306d.equals(c2795hD)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i9 = 0; i9 < size3; i9++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i9);
            sb.append("\n    ");
            sb.append(c(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        int size4 = listB.size();
        for (int i10 = 0; i10 < size4; i10++) {
            Pin pin2 = (Pin) listB.get(i10);
            sb.append("\n    ");
            sb.append(pin2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public List b(String str) {
        List listEmptyList = Collections.emptyList();
        for (Pin pin : this.f20300a) {
            if (pin.a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList();
                }
                listEmptyList.add(pin);
            }
        }
        return listEmptyList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Util.p(this.f20301b, certificatePinner.f20301b) && this.f20300a.equals(certificatePinner.f20300a)) {
                return true;
            }
        }
        return false;
    }

    public CertificatePinner f(CertificateChainCleaner certificateChainCleaner) {
        return Util.p(this.f20301b, certificateChainCleaner) ? this : new CertificatePinner(this.f20300a, certificateChainCleaner);
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.f20301b;
        return ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31) + this.f20300a.hashCode();
    }
}
