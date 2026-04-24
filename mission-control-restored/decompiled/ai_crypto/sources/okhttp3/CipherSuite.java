package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class CipherSuite {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator f20363b = new Comparator<String>() { // from class: okhttp3.CipherSuite.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int iMin = Math.min(str.length(), str2.length());
            for (int i7 = 4; i7 < iMin; i7++) {
                char cCharAt = str.charAt(i7);
                char cCharAt2 = str2.charAt(i7);
                if (cCharAt != cCharAt2) {
                    return cCharAt < cCharAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f20366c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CipherSuite f20369d = c("SSL_RSA_WITH_NULL_MD5", 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CipherSuite f20372e = c("SSL_RSA_WITH_NULL_SHA", 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CipherSuite f20375f = c("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CipherSuite f20378g = c("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CipherSuite f20381h = c("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CipherSuite f20384i = c("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final CipherSuite f20387j = c("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CipherSuite f20390k = c("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CipherSuite f20393l = c("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CipherSuite f20396m = c("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final CipherSuite f20399n = c("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final CipherSuite f20402o = c("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final CipherSuite f20405p = c("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final CipherSuite f20408q = c("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final CipherSuite f20411r = c("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final CipherSuite f20414s = c("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final CipherSuite f20416t = c("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final CipherSuite f20418u = c("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final CipherSuite f20420v = c("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final CipherSuite f20422w = c("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final CipherSuite f20424x = c("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final CipherSuite f20426y = c("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final CipherSuite f20428z = c("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final CipherSuite f20309A = c("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final CipherSuite f20311B = c("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final CipherSuite f20313C = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final CipherSuite f20315D = c("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final CipherSuite f20317E = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final CipherSuite f20319F = c("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final CipherSuite f20321G = c("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final CipherSuite f20323H = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final CipherSuite f20325I = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final CipherSuite f20327J = c("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final CipherSuite f20329K = c("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final CipherSuite f20331L = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final CipherSuite f20333M = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final CipherSuite f20335N = c("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final CipherSuite f20337O = c("TLS_RSA_WITH_NULL_SHA256", 59);

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final CipherSuite f20339P = c("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final CipherSuite f20341Q = c("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final CipherSuite f20343R = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final CipherSuite f20345S = c("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final CipherSuite f20347T = c("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final CipherSuite f20349U = c("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final CipherSuite f20351V = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final CipherSuite f20353W = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final CipherSuite f20355X = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static final CipherSuite f20357Y = c("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final CipherSuite f20359Z = c("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final CipherSuite f20361a0 = c("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final CipherSuite f20364b0 = c("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final CipherSuite f20367c0 = c("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final CipherSuite f20370d0 = c("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final CipherSuite f20373e0 = c("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final CipherSuite f20376f0 = c("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final CipherSuite f20379g0 = c("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final CipherSuite f20382h0 = c("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final CipherSuite f20385i0 = c("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final CipherSuite f20388j0 = c("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final CipherSuite f20391k0 = c("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final CipherSuite f20394l0 = c("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final CipherSuite f20397m0 = c("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final CipherSuite f20400n0 = c("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final CipherSuite f20403o0 = c("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final CipherSuite f20406p0 = c("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final CipherSuite f20409q0 = c("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final CipherSuite f20412r0 = c("TLS_FALLBACK_SCSV", 22016);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final CipherSuite f20415s0 = c("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final CipherSuite f20417t0 = c("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final CipherSuite f20419u0 = c("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final CipherSuite f20421v0 = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final CipherSuite f20423w0 = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final CipherSuite f20425x0 = c("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final CipherSuite f20427y0 = c("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final CipherSuite f20429z0 = c("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public static final CipherSuite f20310A0 = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public static final CipherSuite f20312B0 = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public static final CipherSuite f20314C0 = c("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public static final CipherSuite f20316D0 = c("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public static final CipherSuite f20318E0 = c("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    public static final CipherSuite f20320F0 = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    public static final CipherSuite f20322G0 = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    public static final CipherSuite f20324H0 = c("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* JADX INFO: renamed from: I0, reason: collision with root package name */
    public static final CipherSuite f20326I0 = c("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* JADX INFO: renamed from: J0, reason: collision with root package name */
    public static final CipherSuite f20328J0 = c("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    public static final CipherSuite f20330K0 = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    public static final CipherSuite f20332L0 = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    public static final CipherSuite f20334M0 = c("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    public static final CipherSuite f20336N0 = c("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    public static final CipherSuite f20338O0 = c("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    public static final CipherSuite f20340P0 = c("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    public static final CipherSuite f20342Q0 = c("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* JADX INFO: renamed from: R0, reason: collision with root package name */
    public static final CipherSuite f20344R0 = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* JADX INFO: renamed from: S0, reason: collision with root package name */
    public static final CipherSuite f20346S0 = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* JADX INFO: renamed from: T0, reason: collision with root package name */
    public static final CipherSuite f20348T0 = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* JADX INFO: renamed from: U0, reason: collision with root package name */
    public static final CipherSuite f20350U0 = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* JADX INFO: renamed from: V0, reason: collision with root package name */
    public static final CipherSuite f20352V0 = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* JADX INFO: renamed from: W0, reason: collision with root package name */
    public static final CipherSuite f20354W0 = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* JADX INFO: renamed from: X0, reason: collision with root package name */
    public static final CipherSuite f20356X0 = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* JADX INFO: renamed from: Y0, reason: collision with root package name */
    public static final CipherSuite f20358Y0 = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* JADX INFO: renamed from: Z0, reason: collision with root package name */
    public static final CipherSuite f20360Z0 = c("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final CipherSuite f20362a1 = c("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final CipherSuite f20365b1 = c("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final CipherSuite f20368c1 = c("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final CipherSuite f20371d1 = c("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final CipherSuite f20374e1 = c("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final CipherSuite f20377f1 = c("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final CipherSuite f20380g1 = c("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final CipherSuite f20383h1 = c("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final CipherSuite f20386i1 = c("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final CipherSuite f20389j1 = c("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final CipherSuite f20392k1 = c("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final CipherSuite f20395l1 = c("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final CipherSuite f20398m1 = c("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final CipherSuite f20401n1 = c("TLS_AES_128_GCM_SHA256", 4865);

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final CipherSuite f20404o1 = c("TLS_AES_256_GCM_SHA384", 4866);

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final CipherSuite f20407p1 = c("TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final CipherSuite f20410q1 = c("TLS_AES_128_CCM_SHA256", 4868);

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final CipherSuite f20413r1 = c("TLS_AES_256_CCM_8_SHA256", 4869);

    public CipherSuite(String str) {
        str.getClass();
        this.f20430a = str;
    }

    public static synchronized CipherSuite a(String str) {
        CipherSuite cipherSuite;
        try {
            Map map = f20366c;
            cipherSuite = (CipherSuite) map.get(str);
            if (cipherSuite == null) {
                cipherSuite = (CipherSuite) map.get(e(str));
                if (cipherSuite == null) {
                    cipherSuite = new CipherSuite(str);
                }
                map.put(str, cipherSuite);
            }
        } catch (Throwable th) {
            throw th;
        }
        return cipherSuite;
    }

    public static List b(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static CipherSuite c(String str, int i7) {
        CipherSuite cipherSuite = new CipherSuite(str);
        f20366c.put(str, cipherSuite);
        return cipherSuite;
    }

    public static String e(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    public String d() {
        return this.f20430a;
    }

    public String toString() {
        return this.f20430a;
    }
}
