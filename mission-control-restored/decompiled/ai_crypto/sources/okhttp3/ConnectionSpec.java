package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionSpec {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CipherSuite[] f20439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CipherSuite[] f20440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConnectionSpec f20441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConnectionSpec f20442h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConnectionSpec f20443i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConnectionSpec f20444j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f20446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f20447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f20448d;

    static {
        CipherSuite cipherSuite = CipherSuite.f20401n1;
        CipherSuite cipherSuite2 = CipherSuite.f20404o1;
        CipherSuite cipherSuite3 = CipherSuite.f20407p1;
        CipherSuite cipherSuite4 = CipherSuite.f20410q1;
        CipherSuite cipherSuite5 = CipherSuite.f20413r1;
        CipherSuite cipherSuite6 = CipherSuite.f20360Z0;
        CipherSuite cipherSuite7 = CipherSuite.f20371d1;
        CipherSuite cipherSuite8 = CipherSuite.f20362a1;
        CipherSuite cipherSuite9 = CipherSuite.f20374e1;
        CipherSuite cipherSuite10 = CipherSuite.f20392k1;
        CipherSuite cipherSuite11 = CipherSuite.f20389j1;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11};
        f20439e = cipherSuiteArr;
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11, CipherSuite.f20330K0, CipherSuite.f20332L0, CipherSuite.f20385i0, CipherSuite.f20388j0, CipherSuite.f20321G, CipherSuite.f20329K, CipherSuite.f20390k};
        f20440f = cipherSuiteArr2;
        Builder builderC = new Builder(true).c(cipherSuiteArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        f20441g = builderC.f(tlsVersion, tlsVersion2).d(true).a();
        Builder builderC2 = new Builder(true).c(cipherSuiteArr2);
        TlsVersion tlsVersion3 = TlsVersion.TLS_1_1;
        TlsVersion tlsVersion4 = TlsVersion.TLS_1_0;
        f20442h = builderC2.f(tlsVersion, tlsVersion2, tlsVersion3, tlsVersion4).d(true).a();
        f20443i = new Builder(true).c(cipherSuiteArr2).f(tlsVersion4).d(true).a();
        f20444j = new Builder(false).a();
    }

    public ConnectionSpec(Builder builder) {
        this.f20445a = builder.f20449a;
        this.f20447c = builder.f20450b;
        this.f20448d = builder.f20451c;
        this.f20446b = builder.f20452d;
    }

    public void a(SSLSocket sSLSocket, boolean z7) {
        ConnectionSpec connectionSpecE = e(sSLSocket, z7);
        String[] strArr = connectionSpecE.f20448d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = connectionSpecE.f20447c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List b() {
        String[] strArr = this.f20447c;
        if (strArr != null) {
            return CipherSuite.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f20445a) {
            return false;
        }
        String[] strArr = this.f20448d;
        if (strArr != null && !Util.A(Util.f20686q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f20447c;
        return strArr2 == null || Util.A(CipherSuite.f20363b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.f20445a;
    }

    public final ConnectionSpec e(SSLSocket sSLSocket, boolean z7) {
        String[] strArrY = this.f20447c != null ? Util.y(CipherSuite.f20363b, sSLSocket.getEnabledCipherSuites(), this.f20447c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrY2 = this.f20448d != null ? Util.y(Util.f20686q, sSLSocket.getEnabledProtocols(), this.f20448d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iV = Util.v(CipherSuite.f20363b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z7 && iV != -1) {
            strArrY = Util.h(strArrY, supportedCipherSuites[iV]);
        }
        return new Builder(this).b(strArrY).e(strArrY2).a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z7 = this.f20445a;
        if (z7 != connectionSpec.f20445a) {
            return false;
        }
        return !z7 || (Arrays.equals(this.f20447c, connectionSpec.f20447c) && Arrays.equals(this.f20448d, connectionSpec.f20448d) && this.f20446b == connectionSpec.f20446b);
    }

    public boolean f() {
        return this.f20446b;
    }

    public List g() {
        String[] strArr = this.f20448d;
        if (strArr != null) {
            return TlsVersion.b(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f20445a) {
            return ((((527 + Arrays.hashCode(this.f20447c)) * 31) + Arrays.hashCode(this.f20448d)) * 31) + (!this.f20446b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f20445a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f20447c != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f20448d != null ? g().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f20446b + ")";
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f20450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f20451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f20452d;

        public Builder(boolean z7) {
            this.f20449a = z7;
        }

        public ConnectionSpec a() {
            return new ConnectionSpec(this);
        }

        public Builder b(String... strArr) {
            if (!this.f20449a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f20450b = (String[]) strArr.clone();
            return this;
        }

        public Builder c(CipherSuite... cipherSuiteArr) {
            if (!this.f20449a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[cipherSuiteArr.length];
            for (int i7 = 0; i7 < cipherSuiteArr.length; i7++) {
                strArr[i7] = cipherSuiteArr[i7].f20430a;
            }
            return b(strArr);
        }

        public Builder d(boolean z7) {
            if (!this.f20449a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f20452d = z7;
            return this;
        }

        public Builder e(String... strArr) {
            if (!this.f20449a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f20451c = (String[]) strArr.clone();
            return this;
        }

        public Builder f(TlsVersion... tlsVersionArr) {
            if (!this.f20449a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i7 = 0; i7 < tlsVersionArr.length; i7++) {
                strArr[i7] = tlsVersionArr[i7].f20667a;
            }
            return e(strArr);
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.f20449a = connectionSpec.f20445a;
            this.f20450b = connectionSpec.f20447c;
            this.f20451c = connectionSpec.f20448d;
            this.f20452d = connectionSpec.f20446b;
        }
    }
}
