package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectionSpec {
    public static final ConnectionSpec e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConnectionSpec f8771f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f8774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f8775d;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f8776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f8777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f8778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8779d;

        public Builder(boolean z6) {
            this.f8776a = z6;
        }

        public final void a(CipherSuite... cipherSuiteArr) {
            if (!this.f8776a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[cipherSuiteArr.length];
            for (int i = 0; i < cipherSuiteArr.length; i++) {
                strArr[i] = cipherSuiteArr[i].f8765a;
            }
            if (!this.f8776a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f8777b = (String[]) strArr.clone();
        }

        public final void b(TlsVersion... tlsVersionArr) {
            if (!this.f8776a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i = 0; i < tlsVersionArr.length; i++) {
                strArr[i] = tlsVersionArr[i].f8824a;
            }
            if (!this.f8776a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f8778c = (String[]) strArr.clone();
        }
    }

    static {
        CipherSuite cipherSuite = CipherSuite.f8760p;
        CipherSuite cipherSuite2 = CipherSuite.f8761q;
        CipherSuite cipherSuite3 = CipherSuite.f8762r;
        CipherSuite cipherSuite4 = CipherSuite.f8763s;
        CipherSuite cipherSuite5 = CipherSuite.f8764t;
        CipherSuite cipherSuite6 = CipherSuite.f8754j;
        CipherSuite cipherSuite7 = CipherSuite.f8756l;
        CipherSuite cipherSuite8 = CipherSuite.f8755k;
        CipherSuite cipherSuite9 = CipherSuite.f8757m;
        CipherSuite cipherSuite10 = CipherSuite.f8759o;
        CipherSuite cipherSuite11 = CipherSuite.f8758n;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11};
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11, CipherSuite.f8753h, CipherSuite.i, CipherSuite.f8751f, CipherSuite.f8752g, CipherSuite.f8750d, CipherSuite.e, CipherSuite.f8749c};
        Builder builder = new Builder(true);
        builder.a(cipherSuiteArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        builder.b(tlsVersion, tlsVersion2);
        if (!builder.f8776a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        builder.f8779d = true;
        new ConnectionSpec(builder);
        Builder builder2 = new Builder(true);
        builder2.a(cipherSuiteArr2);
        TlsVersion tlsVersion3 = TlsVersion.TLS_1_1;
        TlsVersion tlsVersion4 = TlsVersion.TLS_1_0;
        builder2.b(tlsVersion, tlsVersion2, tlsVersion3, tlsVersion4);
        if (!builder2.f8776a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        builder2.f8779d = true;
        e = new ConnectionSpec(builder2);
        Builder builder3 = new Builder(true);
        builder3.a(cipherSuiteArr2);
        builder3.b(tlsVersion4);
        if (!builder3.f8776a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        builder3.f8779d = true;
        new ConnectionSpec(builder3);
        f8771f = new ConnectionSpec(new Builder(false));
    }

    public ConnectionSpec(Builder builder) {
        this.f8772a = builder.f8776a;
        this.f8774c = builder.f8777b;
        this.f8775d = builder.f8778c;
        this.f8773b = builder.f8779d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z6 = connectionSpec.f8772a;
        boolean z7 = this.f8772a;
        if (z7 != z6) {
            return false;
        }
        if (z7) {
            return Arrays.equals(this.f8774c, connectionSpec.f8774c) && Arrays.equals(this.f8775d, connectionSpec.f8775d) && this.f8773b == connectionSpec.f8773b;
        }
        return true;
    }

    public final int hashCode() {
        if (this.f8772a) {
            return ((((527 + Arrays.hashCode(this.f8774c)) * 31) + Arrays.hashCode(this.f8775d)) * 31) + (!this.f8773b ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        String string;
        TlsVersion tlsVersion;
        if (!this.f8772a) {
            return "ConnectionSpec()";
        }
        String string2 = "[all enabled]";
        String[] strArr = this.f8774c;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(CipherSuite.a(str));
            }
            string = Collections.unmodifiableList(arrayList).toString();
        } else {
            string = "[all enabled]";
        }
        String[] strArr2 = this.f8775d;
        if (strArr2 != null) {
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            for (String str2 : strArr2) {
                str2.getClass();
                switch (str2) {
                    case "TLSv1.1":
                        tlsVersion = TlsVersion.TLS_1_1;
                        break;
                    case "TLSv1.2":
                        tlsVersion = TlsVersion.TLS_1_2;
                        break;
                    case "TLSv1.3":
                        tlsVersion = TlsVersion.TLS_1_3;
                        break;
                    case "SSLv3":
                        tlsVersion = TlsVersion.SSL_3_0;
                        break;
                    case "TLSv1":
                        tlsVersion = TlsVersion.TLS_1_0;
                        break;
                    default:
                        throw new IllegalArgumentException("Unexpected TLS version: ".concat(str2));
                }
                arrayList2.add(tlsVersion);
            }
            string2 = Collections.unmodifiableList(arrayList2).toString();
        }
        return "ConnectionSpec(cipherSuites=" + string + ", tlsVersions=" + string2 + ", supportsTlsExtensions=" + this.f8773b + ")";
    }
}
