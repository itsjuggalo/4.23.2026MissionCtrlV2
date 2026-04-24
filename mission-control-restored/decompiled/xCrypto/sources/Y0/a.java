package Y0;

import a1.g;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f5653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f5654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f5655h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5657b;

    static {
        String strA = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f5650c = strA;
        String strA2 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f5651d = strA2;
        String strA3 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f5652e = strA3;
        f5653f = Collections.unmodifiableSet(new HashSet(Arrays.asList(X0.c.b("proto"), X0.c.b("json"))));
        f5654g = new a(strA, null);
        f5655h = new a(strA2, strA3);
    }

    public a(String str, String str2) {
        this.f5656a = str;
        this.f5657b = str2;
    }

    public static a d(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }

    @Override // a1.g
    public Set a() {
        return f5653f;
    }

    @Override // a1.f
    public byte[] b() {
        return c();
    }

    public byte[] c() {
        String str = this.f5657b;
        if (str == null && this.f5656a == null) {
            return null;
        }
        String str2 = this.f5656a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", "1$", str2, "\\", str).getBytes(Charset.forName("UTF-8"));
    }

    public String e() {
        return this.f5657b;
    }

    public String f() {
        return this.f5656a;
    }

    @Override // a1.f
    public String getName() {
        return "cct";
    }
}
