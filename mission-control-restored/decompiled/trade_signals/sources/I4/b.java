package I4;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final I4.a[] f4221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f4222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f4223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f4224h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f4226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f4227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4228d;

    /* JADX INFO: renamed from: I4.b$b, reason: collision with other inner class name */
    public static final class C0052b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f4230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f4231c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4232d;

        public C0052b(b bVar) {
            this.f4229a = bVar.f4225a;
            this.f4230b = bVar.f4226b;
            this.f4231c = bVar.f4227c;
            this.f4232d = bVar.f4228d;
        }

        public b e() {
            return new b(this);
        }

        public C0052b f(I4.a... aVarArr) {
            if (!this.f4229a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[aVarArr.length];
            for (int i8 = 0; i8 < aVarArr.length; i8++) {
                strArr[i8] = aVarArr[i8].f4220a;
            }
            this.f4230b = strArr;
            return this;
        }

        public C0052b g(String... strArr) {
            if (!this.f4229a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr == null) {
                this.f4230b = null;
            } else {
                this.f4230b = (String[]) strArr.clone();
            }
            return this;
        }

        public C0052b h(boolean z7) {
            if (!this.f4229a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f4232d = z7;
            return this;
        }

        public C0052b i(k... kVarArr) {
            if (!this.f4229a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (kVarArr.length == 0) {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
            String[] strArr = new String[kVarArr.length];
            for (int i8 = 0; i8 < kVarArr.length; i8++) {
                strArr[i8] = kVarArr[i8].f4287a;
            }
            this.f4231c = strArr;
            return this;
        }

        public C0052b j(String... strArr) {
            if (!this.f4229a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr == null) {
                this.f4231c = null;
            } else {
                this.f4231c = (String[]) strArr.clone();
            }
            return this;
        }

        public C0052b(boolean z7) {
            this.f4229a = z7;
        }
    }

    static {
        I4.a[] aVarArr = {I4.a.TLS_AES_128_GCM_SHA256, I4.a.TLS_AES_256_GCM_SHA384, I4.a.TLS_CHACHA20_POLY1305_SHA256, I4.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, I4.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, I4.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, I4.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, I4.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, I4.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, I4.a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, I4.a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, I4.a.TLS_RSA_WITH_AES_128_GCM_SHA256, I4.a.TLS_RSA_WITH_AES_256_GCM_SHA384, I4.a.TLS_RSA_WITH_AES_128_CBC_SHA, I4.a.TLS_RSA_WITH_AES_256_CBC_SHA, I4.a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f4221e = aVarArr;
        C0052b c0052bF = new C0052b(true).f(aVarArr);
        k kVar = k.TLS_1_3;
        k kVar2 = k.TLS_1_2;
        b bVarE = c0052bF.i(kVar, kVar2).h(true).e();
        f4222f = bVarE;
        f4223g = new C0052b(bVarE).i(kVar, kVar2, k.TLS_1_1, k.TLS_1_0).h(true).e();
        f4224h = new C0052b(false).e();
    }

    public b(C0052b c0052b) {
        this.f4225a = c0052b.f4229a;
        this.f4226b = c0052b.f4230b;
        this.f4227c = c0052b.f4231c;
        this.f4228d = c0052b.f4232d;
    }

    public void c(SSLSocket sSLSocket, boolean z7) {
        b bVarE = e(sSLSocket, z7);
        sSLSocket.setEnabledProtocols(bVarE.f4227c);
        String[] strArr = bVarE.f4226b;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    public List d() {
        String[] strArr = this.f4226b;
        if (strArr == null) {
            return null;
        }
        I4.a[] aVarArr = new I4.a[strArr.length];
        int i8 = 0;
        while (true) {
            String[] strArr2 = this.f4226b;
            if (i8 >= strArr2.length) {
                return l.a(aVarArr);
            }
            aVarArr[i8] = I4.a.a(strArr2[i8]);
            i8++;
        }
    }

    public final b e(SSLSocket sSLSocket, boolean z7) {
        String[] enabledCipherSuites;
        if (this.f4226b != null) {
            enabledCipherSuites = (String[]) l.c(String.class, this.f4226b, sSLSocket.getEnabledCipherSuites());
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
        return new C0052b(this).g(enabledCipherSuites).j((String[]) l.c(String.class, this.f4227c, sSLSocket.getEnabledProtocols())).e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        b bVar = (b) obj;
        boolean z7 = this.f4225a;
        if (z7 != bVar.f4225a) {
            return false;
        }
        return !z7 || (Arrays.equals(this.f4226b, bVar.f4226b) && Arrays.equals(this.f4227c, bVar.f4227c) && this.f4228d == bVar.f4228d);
    }

    public boolean f() {
        return this.f4228d;
    }

    public List g() {
        k[] kVarArr = new k[this.f4227c.length];
        int i8 = 0;
        while (true) {
            String[] strArr = this.f4227c;
            if (i8 >= strArr.length) {
                return l.a(kVarArr);
            }
            kVarArr[i8] = k.a(strArr[i8]);
            i8++;
        }
    }

    public int hashCode() {
        if (this.f4225a) {
            return ((((527 + Arrays.hashCode(this.f4226b)) * 31) + Arrays.hashCode(this.f4227c)) * 31) + (!this.f4228d ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f4225a) {
            return "ConnectionSpec()";
        }
        List listD = d();
        return "ConnectionSpec(cipherSuites=" + (listD == null ? "[use default]" : listD.toString()) + ", tlsVersions=" + g() + ", supportsTlsExtensions=" + this.f4228d + ")";
    }
}
