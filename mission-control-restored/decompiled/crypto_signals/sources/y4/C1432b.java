package y4;

import P2.A;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: y4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1432b {
    public static final C1432b e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f11681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f11682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11683d;

    static {
        EnumC1431a[] enumC1431aArr = {EnumC1431a.TLS_AES_128_GCM_SHA256, EnumC1431a.TLS_AES_256_GCM_SHA384, EnumC1431a.TLS_CHACHA20_POLY1305_SHA256, EnumC1431a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, EnumC1431a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, EnumC1431a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, EnumC1431a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, EnumC1431a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, EnumC1431a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, EnumC1431a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, EnumC1431a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, EnumC1431a.TLS_RSA_WITH_AES_128_GCM_SHA256, EnumC1431a.TLS_RSA_WITH_AES_256_GCM_SHA384, EnumC1431a.TLS_RSA_WITH_AES_128_CBC_SHA, EnumC1431a.TLS_RSA_WITH_AES_256_CBC_SHA, EnumC1431a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        A a6 = new A(true);
        a6.c(enumC1431aArr);
        EnumC1442l enumC1442l = EnumC1442l.TLS_1_3;
        EnumC1442l enumC1442l2 = EnumC1442l.TLS_1_2;
        a6.f(enumC1442l, enumC1442l2);
        if (!a6.f2348a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        a6.f2349b = true;
        C1432b c1432b = new C1432b(a6);
        e = c1432b;
        A a7 = new A(c1432b);
        a7.f(enumC1442l, enumC1442l2, EnumC1442l.TLS_1_1, EnumC1442l.TLS_1_0);
        if (!a7.f2348a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        a7.f2349b = true;
        new C1432b(a7);
        new C1432b(new A(false));
    }

    public C1432b(A a6) {
        this.f11680a = a6.f2348a;
        this.f11681b = (String[]) a6.f2350c;
        this.f11682c = (String[]) a6.f2351d;
        this.f11683d = a6.f2349b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1432b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C1432b c1432b = (C1432b) obj;
        boolean z6 = c1432b.f11680a;
        boolean z7 = this.f11680a;
        if (z7 != z6) {
            return false;
        }
        if (z7) {
            return Arrays.equals(this.f11681b, c1432b.f11681b) && Arrays.equals(this.f11682c, c1432b.f11682c) && this.f11683d == c1432b.f11683d;
        }
        return true;
    }

    public final int hashCode() {
        if (this.f11680a) {
            return ((((527 + Arrays.hashCode(this.f11681b)) * 31) + Arrays.hashCode(this.f11682c)) * 31) + (!this.f11683d ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        List listUnmodifiableList;
        EnumC1442l enumC1442l;
        if (!this.f11680a) {
            return "ConnectionSpec()";
        }
        String[] strArr = this.f11681b;
        if (strArr == null) {
            listUnmodifiableList = null;
        } else {
            EnumC1431a[] enumC1431aArr = new EnumC1431a[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                enumC1431aArr[i] = str.startsWith("SSL_") ? EnumC1431a.valueOf("TLS_" + str.substring(4)) : EnumC1431a.valueOf(str);
            }
            String[] strArr2 = m.f11718a;
            listUnmodifiableList = Collections.unmodifiableList(Arrays.asList((Object[]) enumC1431aArr.clone()));
        }
        StringBuilder sbP = a3.d.p("ConnectionSpec(cipherSuites=", listUnmodifiableList == null ? "[use default]" : listUnmodifiableList.toString(), ", tlsVersions=");
        String[] strArr3 = this.f11682c;
        EnumC1442l[] enumC1442lArr = new EnumC1442l[strArr3.length];
        for (int i6 = 0; i6 < strArr3.length; i6++) {
            String str2 = strArr3[i6];
            if ("TLSv1.3".equals(str2)) {
                enumC1442l = EnumC1442l.TLS_1_3;
            } else if ("TLSv1.2".equals(str2)) {
                enumC1442l = EnumC1442l.TLS_1_2;
            } else if ("TLSv1.1".equals(str2)) {
                enumC1442l = EnumC1442l.TLS_1_1;
            } else if ("TLSv1".equals(str2)) {
                enumC1442l = EnumC1442l.TLS_1_0;
            } else {
                if (!"SSLv3".equals(str2)) {
                    throw new IllegalArgumentException(AbstractC1024h.b("Unexpected TLS version: ", str2));
                }
                enumC1442l = EnumC1442l.SSL_3_0;
            }
            enumC1442lArr[i6] = enumC1442l;
        }
        String[] strArr4 = m.f11718a;
        sbP.append(Collections.unmodifiableList(Arrays.asList((Object[]) enumC1442lArr.clone())));
        sbP.append(", supportsTlsExtensions=");
        sbP.append(this.f11683d);
        sbP.append(")");
        return sbP.toString();
    }
}
