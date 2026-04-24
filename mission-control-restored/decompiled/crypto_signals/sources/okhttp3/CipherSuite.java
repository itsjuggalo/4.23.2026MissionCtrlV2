package okhttp3;

import java.util.Comparator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class CipherSuite {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f8748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CipherSuite f8749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CipherSuite f8750d;
    public static final CipherSuite e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CipherSuite f8751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CipherSuite f8752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CipherSuite f8753h;
    public static final CipherSuite i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final CipherSuite f8754j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CipherSuite f8755k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CipherSuite f8756l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CipherSuite f8757m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final CipherSuite f8758n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final CipherSuite f8759o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final CipherSuite f8760p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final CipherSuite f8761q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final CipherSuite f8762r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final CipherSuite f8763s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final CipherSuite f8764t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8765a;

    static {
        new Comparator<String>() { // from class: okhttp3.CipherSuite.1
            @Override // java.util.Comparator
            public final int compare(String str, String str2) {
                String str3 = str;
                String str4 = str2;
                int iMin = Math.min(str3.length(), str4.length());
                for (int i6 = 4; i6 < iMin; i6++) {
                    char cCharAt = str3.charAt(i6);
                    char cCharAt2 = str4.charAt(i6);
                    if (cCharAt != cCharAt2) {
                        return cCharAt < cCharAt2 ? -1 : 1;
                    }
                }
                int length = str3.length();
                int length2 = str4.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        f8748b = new LinkedHashMap();
        b("SSL_RSA_WITH_NULL_MD5");
        b("SSL_RSA_WITH_NULL_SHA");
        b("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        b("SSL_RSA_WITH_RC4_128_MD5");
        b("SSL_RSA_WITH_RC4_128_SHA");
        b("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_RSA_WITH_DES_CBC_SHA");
        f8749c = b("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        b("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_DHE_DSS_WITH_DES_CBC_SHA");
        b("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        b("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_DHE_RSA_WITH_DES_CBC_SHA");
        b("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        b("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        b("SSL_DH_anon_WITH_RC4_128_MD5");
        b("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        b("SSL_DH_anon_WITH_DES_CBC_SHA");
        b("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        b("TLS_KRB5_WITH_DES_CBC_SHA");
        b("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        b("TLS_KRB5_WITH_RC4_128_SHA");
        b("TLS_KRB5_WITH_DES_CBC_MD5");
        b("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        b("TLS_KRB5_WITH_RC4_128_MD5");
        b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        b("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        b("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        f8750d = b("TLS_RSA_WITH_AES_128_CBC_SHA");
        b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        b("TLS_DH_anon_WITH_AES_128_CBC_SHA");
        e = b("TLS_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_DH_anon_WITH_AES_256_CBC_SHA");
        b("TLS_RSA_WITH_NULL_SHA256");
        b("TLS_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_RSA_WITH_AES_256_CBC_SHA256");
        b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        b("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        b("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        b("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        b("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        b("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        b("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        b("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        b("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        b("TLS_PSK_WITH_RC4_128_SHA");
        b("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        b("TLS_PSK_WITH_AES_128_CBC_SHA");
        b("TLS_PSK_WITH_AES_256_CBC_SHA");
        b("TLS_RSA_WITH_SEED_CBC_SHA");
        f8751f = b("TLS_RSA_WITH_AES_128_GCM_SHA256");
        f8752g = b("TLS_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        b("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        b("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        b("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        b("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        b("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        b("TLS_FALLBACK_SCSV");
        b("TLS_ECDH_ECDSA_WITH_NULL_SHA");
        b("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        b("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        b("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        b("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDH_RSA_WITH_NULL_SHA");
        b("TLS_ECDH_RSA_WITH_RC4_128_SHA");
        b("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDHE_RSA_WITH_NULL_SHA");
        b("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        b("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        f8753h = b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        i = b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        b("TLS_ECDH_anon_WITH_NULL_SHA");
        b("TLS_ECDH_anon_WITH_RC4_128_SHA");
        b("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        b("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        b("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        f8754j = b("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        f8755k = b("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        b("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        b("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        f8756l = b("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        f8757m = b("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        b("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        b("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        b("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        f8758n = b("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        f8759o = b("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        b("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        b("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
        f8760p = b("TLS_AES_128_GCM_SHA256");
        f8761q = b("TLS_AES_256_GCM_SHA384");
        f8762r = b("TLS_CHACHA20_POLY1305_SHA256");
        f8763s = b("TLS_AES_128_CCM_SHA256");
        f8764t = b("TLS_AES_256_CCM_8_SHA256");
    }

    public CipherSuite(String str) {
        str.getClass();
        this.f8765a = str;
    }

    public static synchronized CipherSuite a(String str) {
        CipherSuite cipherSuite;
        String str2;
        try {
            LinkedHashMap linkedHashMap = f8748b;
            cipherSuite = (CipherSuite) linkedHashMap.get(str);
            if (cipherSuite == null) {
                if (str.startsWith("TLS_")) {
                    str2 = "SSL_" + str.substring(4);
                } else if (str.startsWith("SSL_")) {
                    str2 = "TLS_" + str.substring(4);
                } else {
                    str2 = str;
                }
                cipherSuite = (CipherSuite) linkedHashMap.get(str2);
                if (cipherSuite == null) {
                    cipherSuite = new CipherSuite(str);
                }
                linkedHashMap.put(str, cipherSuite);
            }
        } catch (Throwable th) {
            throw th;
        }
        return cipherSuite;
    }

    public static CipherSuite b(String str) {
        CipherSuite cipherSuite = new CipherSuite(str);
        f8748b.put(str, cipherSuite);
        return cipherSuite;
    }

    public final String toString() {
        return this.f8765a;
    }
}
