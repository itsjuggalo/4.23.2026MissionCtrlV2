package O2;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final O2.a[] f3235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f3236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f3237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f3238h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f3240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f3241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3242d;

    static {
        O2.a[] aVarArr = {O2.a.TLS_AES_128_GCM_SHA256, O2.a.TLS_AES_256_GCM_SHA384, O2.a.TLS_CHACHA20_POLY1305_SHA256, O2.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, O2.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, O2.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, O2.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, O2.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, O2.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, O2.a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, O2.a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, O2.a.TLS_RSA_WITH_AES_128_GCM_SHA256, O2.a.TLS_RSA_WITH_AES_256_GCM_SHA384, O2.a.TLS_RSA_WITH_AES_128_CBC_SHA, O2.a.TLS_RSA_WITH_AES_256_CBC_SHA, O2.a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f3235e = aVarArr;
        C0053b c0053bF = new C0053b(true).f(aVarArr);
        k kVar = k.TLS_1_3;
        k kVar2 = k.TLS_1_2;
        b bVarE = c0053bF.i(kVar, kVar2).h(true).e();
        f3236f = bVarE;
        f3237g = new C0053b(bVarE).i(kVar, kVar2, k.TLS_1_1, k.TLS_1_0).h(true).e();
        f3238h = new C0053b(false).e();
    }

    public void c(SSLSocket sSLSocket, boolean z4) {
        b bVarE = e(sSLSocket, z4);
        sSLSocket.setEnabledProtocols(bVarE.f3241c);
        String[] strArr = bVarE.f3240b;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    public List d() {
        String[] strArr = this.f3240b;
        if (strArr == null) {
            return null;
        }
        O2.a[] aVarArr = new O2.a[strArr.length];
        int i4 = 0;
        while (true) {
            String[] strArr2 = this.f3240b;
            if (i4 >= strArr2.length) {
                return l.a(aVarArr);
            }
            aVarArr[i4] = O2.a.a(strArr2[i4]);
            i4++;
        }
    }

    public final b e(SSLSocket sSLSocket, boolean z4) {
        String[] enabledCipherSuites;
        if (this.f3240b != null) {
            enabledCipherSuites = (String[]) l.c(String.class, this.f3240b, sSLSocket.getEnabledCipherSuites());
        } else {
            enabledCipherSuites = null;
        }
        if (z4 && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (enabledCipherSuites == null) {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            int length = enabledCipherSuites.length;
            String[] strArr = new String[length + 1];
            System.arraycopy(enabledCipherSuites, 0, strArr, 0, enabledCipherSuites.length);
            strArr[length] = "TLS_FALLBACK_SCSV";
            enabledCipherSuites = strArr;
        }
        return new C0053b(this).g(enabledCipherSuites).j((String[]) l.c(String.class, this.f3241c, sSLSocket.getEnabledProtocols())).e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        b bVar = (b) obj;
        boolean z4 = this.f3239a;
        if (z4 != bVar.f3239a) {
            return false;
        }
        return !z4 || (Arrays.equals(this.f3240b, bVar.f3240b) && Arrays.equals(this.f3241c, bVar.f3241c) && this.f3242d == bVar.f3242d);
    }

    public boolean f() {
        return this.f3242d;
    }

    public List g() {
        k[] kVarArr = new k[this.f3241c.length];
        int i4 = 0;
        while (true) {
            String[] strArr = this.f3241c;
            if (i4 >= strArr.length) {
                return l.a(kVarArr);
            }
            kVarArr[i4] = k.a(strArr[i4]);
            i4++;
        }
    }

    public int hashCode() {
        if (this.f3239a) {
            return ((((527 + Arrays.hashCode(this.f3240b)) * 31) + Arrays.hashCode(this.f3241c)) * 31) + (!this.f3242d ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f3239a) {
            return "ConnectionSpec()";
        }
        List listD = d();
        return "ConnectionSpec(cipherSuites=" + (listD == null ? "[use default]" : listD.toString()) + ", tlsVersions=" + g() + ", supportsTlsExtensions=" + this.f3242d + ")";
    }

    /* JADX INFO: renamed from: O2.b$b, reason: collision with other inner class name */
    public static final class C0053b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f3244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f3245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3246d;

        public C0053b(boolean z4) {
            this.f3243a = z4;
        }

        public b e() {
            return new b(this);
        }

        public C0053b f(O2.a... aVarArr) {
            if (!this.f3243a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[aVarArr.length];
            for (int i4 = 0; i4 < aVarArr.length; i4++) {
                strArr[i4] = aVarArr[i4].f3234a;
            }
            this.f3244b = strArr;
            return this;
        }

        public C0053b g(String... strArr) {
            if (!this.f3243a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr == null) {
                this.f3244b = null;
                return this;
            }
            this.f3244b = (String[]) strArr.clone();
            return this;
        }

        public C0053b h(boolean z4) {
            if (!this.f3243a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f3246d = z4;
            return this;
        }

        public C0053b i(k... kVarArr) {
            if (!this.f3243a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (kVarArr.length == 0) {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
            String[] strArr = new String[kVarArr.length];
            for (int i4 = 0; i4 < kVarArr.length; i4++) {
                strArr[i4] = kVarArr[i4].f3301a;
            }
            this.f3245c = strArr;
            return this;
        }

        public C0053b j(String... strArr) {
            if (!this.f3243a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr == null) {
                this.f3245c = null;
                return this;
            }
            this.f3245c = (String[]) strArr.clone();
            return this;
        }

        public C0053b(b bVar) {
            this.f3243a = bVar.f3239a;
            this.f3244b = bVar.f3240b;
            this.f3245c = bVar.f3241c;
            this.f3246d = bVar.f3242d;
        }
    }

    public b(C0053b c0053b) {
        this.f3239a = c0053b.f3243a;
        this.f3240b = c0053b.f3244b;
        this.f3241c = c0053b.f3245c;
        this.f3242d = c0053b.f3246d;
    }
}
