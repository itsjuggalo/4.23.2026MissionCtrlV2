package v5;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC2768a[] f24866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f24867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f24868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f24869h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f24870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f24871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f24872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f24873d;

    static {
        EnumC2768a[] enumC2768aArr = {EnumC2768a.TLS_AES_128_GCM_SHA256, EnumC2768a.TLS_AES_256_GCM_SHA384, EnumC2768a.TLS_CHACHA20_POLY1305_SHA256, EnumC2768a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, EnumC2768a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, EnumC2768a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, EnumC2768a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, EnumC2768a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, EnumC2768a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, EnumC2768a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, EnumC2768a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, EnumC2768a.TLS_RSA_WITH_AES_128_GCM_SHA256, EnumC2768a.TLS_RSA_WITH_AES_256_GCM_SHA384, EnumC2768a.TLS_RSA_WITH_AES_128_CBC_SHA, EnumC2768a.TLS_RSA_WITH_AES_256_CBC_SHA, EnumC2768a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f24866e = enumC2768aArr;
        C0388b c0388bG = new C0388b(true).g(enumC2768aArr);
        k kVar = k.TLS_1_3;
        k kVar2 = k.TLS_1_2;
        b bVarE = c0388bG.j(kVar, kVar2).h(true).e();
        f24867f = bVarE;
        f24868g = new C0388b(bVarE).j(kVar, kVar2, k.TLS_1_1, k.TLS_1_0).h(true).e();
        f24869h = new C0388b(false).e();
    }

    public void c(SSLSocket sSLSocket, boolean z7) {
        b bVarE = e(sSLSocket, z7);
        sSLSocket.setEnabledProtocols(bVarE.f24872c);
        String[] strArr = bVarE.f24871b;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    public List d() {
        String[] strArr = this.f24871b;
        if (strArr == null) {
            return null;
        }
        EnumC2768a[] enumC2768aArr = new EnumC2768a[strArr.length];
        int i7 = 0;
        while (true) {
            String[] strArr2 = this.f24871b;
            if (i7 >= strArr2.length) {
                return l.a(enumC2768aArr);
            }
            enumC2768aArr[i7] = EnumC2768a.a(strArr2[i7]);
            i7++;
        }
    }

    public final b e(SSLSocket sSLSocket, boolean z7) {
        String[] enabledCipherSuites;
        if (this.f24871b != null) {
            enabledCipherSuites = (String[]) l.c(String.class, this.f24871b, sSLSocket.getEnabledCipherSuites());
        } else {
            enabledCipherSuites = null;
        }
        if (z7 && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (enabledCipherSuites == null) {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            int length = enabledCipherSuites.length;
            String[] strArr = new String[length + 1];
            System.arraycopy(enabledCipherSuites, 0, strArr, 0, enabledCipherSuites.length);
            strArr[length] = "TLS_FALLBACK_SCSV";
            enabledCipherSuites = strArr;
        }
        return new C0388b(this).f(enabledCipherSuites).i((String[]) l.c(String.class, this.f24872c, sSLSocket.getEnabledProtocols())).e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        b bVar = (b) obj;
        boolean z7 = this.f24870a;
        if (z7 != bVar.f24870a) {
            return false;
        }
        return !z7 || (Arrays.equals(this.f24871b, bVar.f24871b) && Arrays.equals(this.f24872c, bVar.f24872c) && this.f24873d == bVar.f24873d);
    }

    public boolean f() {
        return this.f24873d;
    }

    public List g() {
        k[] kVarArr = new k[this.f24872c.length];
        int i7 = 0;
        while (true) {
            String[] strArr = this.f24872c;
            if (i7 >= strArr.length) {
                return l.a(kVarArr);
            }
            kVarArr[i7] = k.a(strArr[i7]);
            i7++;
        }
    }

    public int hashCode() {
        if (this.f24870a) {
            return ((((527 + Arrays.hashCode(this.f24871b)) * 31) + Arrays.hashCode(this.f24872c)) * 31) + (!this.f24873d ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f24870a) {
            return "ConnectionSpec()";
        }
        List listD = d();
        return "ConnectionSpec(cipherSuites=" + (listD == null ? "[use default]" : listD.toString()) + ", tlsVersions=" + g() + ", supportsTlsExtensions=" + this.f24873d + ")";
    }

    /* JADX INFO: renamed from: v5.b$b, reason: collision with other inner class name */
    public static final class C0388b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f24874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f24875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f24876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f24877d;

        public C0388b(boolean z7) {
            this.f24874a = z7;
        }

        public b e() {
            return new b(this);
        }

        public C0388b f(String... strArr) {
            if (!this.f24874a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr == null) {
                this.f24875b = null;
            } else {
                this.f24875b = (String[]) strArr.clone();
            }
            return this;
        }

        public C0388b g(EnumC2768a... enumC2768aArr) {
            if (!this.f24874a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[enumC2768aArr.length];
            for (int i7 = 0; i7 < enumC2768aArr.length; i7++) {
                strArr[i7] = enumC2768aArr[i7].f24865a;
            }
            this.f24875b = strArr;
            return this;
        }

        public C0388b h(boolean z7) {
            if (!this.f24874a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f24877d = z7;
            return this;
        }

        public C0388b i(String... strArr) {
            if (!this.f24874a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr == null) {
                this.f24876c = null;
            } else {
                this.f24876c = (String[]) strArr.clone();
            }
            return this;
        }

        public C0388b j(k... kVarArr) {
            if (!this.f24874a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (kVarArr.length == 0) {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
            String[] strArr = new String[kVarArr.length];
            for (int i7 = 0; i7 < kVarArr.length; i7++) {
                strArr[i7] = kVarArr[i7].f24932a;
            }
            this.f24876c = strArr;
            return this;
        }

        public C0388b(b bVar) {
            this.f24874a = bVar.f24870a;
            this.f24875b = bVar.f24871b;
            this.f24876c = bVar.f24872c;
            this.f24877d = bVar.f24873d;
        }
    }

    public b(C0388b c0388b) {
        this.f24870a = c0388b.f24874a;
        this.f24871b = c0388b.f24875b;
        this.f24872c = c0388b.f24876c;
        this.f24873d = c0388b.f24877d;
    }
}
