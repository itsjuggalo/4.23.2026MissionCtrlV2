package vb;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final vb.a[] f23287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f23288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f23289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f23290h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f23292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f23293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23294d;

    static {
        vb.a[] aVarArr = {vb.a.TLS_AES_128_GCM_SHA256, vb.a.TLS_AES_256_GCM_SHA384, vb.a.TLS_CHACHA20_POLY1305_SHA256, vb.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, vb.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, vb.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, vb.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, vb.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, vb.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, vb.a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, vb.a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, vb.a.TLS_RSA_WITH_AES_128_GCM_SHA256, vb.a.TLS_RSA_WITH_AES_256_GCM_SHA384, vb.a.TLS_RSA_WITH_AES_128_CBC_SHA, vb.a.TLS_RSA_WITH_AES_256_CBC_SHA, vb.a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f23287e = aVarArr;
        C0403b c0403bG = new C0403b(true).g(aVarArr);
        k kVar = k.TLS_1_3;
        k kVar2 = k.TLS_1_2;
        b bVarE = c0403bG.j(kVar, kVar2).h(true).e();
        f23288f = bVarE;
        f23289g = new C0403b(bVarE).j(kVar, kVar2, k.TLS_1_1, k.TLS_1_0).h(true).e();
        f23290h = new C0403b(false).e();
    }

    public void c(SSLSocket sSLSocket, boolean z10) {
        b bVarE = e(sSLSocket, z10);
        sSLSocket.setEnabledProtocols(bVarE.f23293c);
        String[] strArr = bVarE.f23292b;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    public List d() {
        String[] strArr = this.f23292b;
        if (strArr == null) {
            return null;
        }
        vb.a[] aVarArr = new vb.a[strArr.length];
        int i10 = 0;
        while (true) {
            String[] strArr2 = this.f23292b;
            if (i10 >= strArr2.length) {
                return l.a(aVarArr);
            }
            aVarArr[i10] = vb.a.a(strArr2[i10]);
            i10++;
        }
    }

    public final b e(SSLSocket sSLSocket, boolean z10) {
        String[] enabledCipherSuites;
        if (this.f23292b != null) {
            enabledCipherSuites = (String[]) l.c(String.class, this.f23292b, sSLSocket.getEnabledCipherSuites());
        } else {
            enabledCipherSuites = null;
        }
        if (z10 && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (enabledCipherSuites == null) {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            int length = enabledCipherSuites.length;
            String[] strArr = new String[length + 1];
            System.arraycopy(enabledCipherSuites, 0, strArr, 0, enabledCipherSuites.length);
            strArr[length] = "TLS_FALLBACK_SCSV";
            enabledCipherSuites = strArr;
        }
        return new C0403b(this).f(enabledCipherSuites).i((String[]) l.c(String.class, this.f23293c, sSLSocket.getEnabledProtocols())).e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        b bVar = (b) obj;
        boolean z10 = this.f23291a;
        if (z10 != bVar.f23291a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f23292b, bVar.f23292b) && Arrays.equals(this.f23293c, bVar.f23293c) && this.f23294d == bVar.f23294d);
    }

    public boolean f() {
        return this.f23294d;
    }

    public List g() {
        k[] kVarArr = new k[this.f23293c.length];
        int i10 = 0;
        while (true) {
            String[] strArr = this.f23293c;
            if (i10 >= strArr.length) {
                return l.a(kVarArr);
            }
            kVarArr[i10] = k.a(strArr[i10]);
            i10++;
        }
    }

    public int hashCode() {
        if (this.f23291a) {
            return ((((527 + Arrays.hashCode(this.f23292b)) * 31) + Arrays.hashCode(this.f23293c)) * 31) + (!this.f23294d ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f23291a) {
            return "ConnectionSpec()";
        }
        List listD = d();
        return "ConnectionSpec(cipherSuites=" + (listD == null ? "[use default]" : listD.toString()) + ", tlsVersions=" + g() + ", supportsTlsExtensions=" + this.f23294d + ")";
    }

    /* JADX INFO: renamed from: vb.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0403b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f23295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f23296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f23297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f23298d;

        public C0403b(boolean z10) {
            this.f23295a = z10;
        }

        public b e() {
            return new b(this);
        }

        public C0403b f(String... strArr) {
            if (!this.f23295a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr == null) {
                this.f23296b = null;
                return this;
            }
            this.f23296b = (String[]) strArr.clone();
            return this;
        }

        public C0403b g(vb.a... aVarArr) {
            if (!this.f23295a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[aVarArr.length];
            for (int i10 = 0; i10 < aVarArr.length; i10++) {
                strArr[i10] = aVarArr[i10].f23286a;
            }
            this.f23296b = strArr;
            return this;
        }

        public C0403b h(boolean z10) {
            if (!this.f23295a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f23298d = z10;
            return this;
        }

        public C0403b i(String... strArr) {
            if (!this.f23295a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr == null) {
                this.f23297c = null;
                return this;
            }
            this.f23297c = (String[]) strArr.clone();
            return this;
        }

        public C0403b j(k... kVarArr) {
            if (!this.f23295a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (kVarArr.length == 0) {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
            String[] strArr = new String[kVarArr.length];
            for (int i10 = 0; i10 < kVarArr.length; i10++) {
                strArr[i10] = kVarArr[i10].f23353a;
            }
            this.f23297c = strArr;
            return this;
        }

        public C0403b(b bVar) {
            this.f23295a = bVar.f23291a;
            this.f23296b = bVar.f23292b;
            this.f23297c = bVar.f23293c;
            this.f23298d = bVar.f23294d;
        }
    }

    public b(C0403b c0403b) {
        this.f23291a = c0403b.f23295a;
        this.f23292b = c0403b.f23296b;
        this.f23293c = c0403b.f23297c;
        this.f23294d = c0403b.f23298d;
    }
}
