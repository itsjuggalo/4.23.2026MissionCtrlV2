package p1;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import o1.C2291c;
import r1.g;

/* JADX INFO: renamed from: p1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2366a implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f21450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f21451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f21452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f21453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C2366a f21454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C2366a f21455h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21457b;

    static {
        String strA = AbstractC2370e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f21450c = strA;
        String strA2 = AbstractC2370e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f21451d = strA2;
        String strA3 = AbstractC2370e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f21452e = strA3;
        f21453f = Collections.unmodifiableSet(new HashSet(Arrays.asList(C2291c.b("proto"), C2291c.b("json"))));
        f21454g = new C2366a(strA, null);
        f21455h = new C2366a(strA2, strA3);
    }

    public C2366a(String str, String str2) {
        this.f21456a = str;
        this.f21457b = str2;
    }

    public static C2366a d(byte[] bArr) {
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
        return new C2366a(str2, str3);
    }

    @Override // r1.g
    public Set a() {
        return f21453f;
    }

    @Override // r1.f
    public byte[] b() {
        return c();
    }

    public byte[] c() {
        String str = this.f21457b;
        if (str == null && this.f21456a == null) {
            return null;
        }
        String str2 = this.f21456a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", "1$", str2, "\\", str).getBytes(Charset.forName("UTF-8"));
    }

    public String e() {
        return this.f21457b;
    }

    public String f() {
        return this.f21456a;
    }

    @Override // r1.f
    public String getName() {
        return "cct";
    }
}
