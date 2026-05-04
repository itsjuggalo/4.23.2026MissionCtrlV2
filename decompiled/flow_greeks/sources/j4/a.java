package j4;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import l4.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f13879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f13880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f13881h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13883b;

    static {
        String strA = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f13876c = strA;
        String strA2 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f13877d = strA2;
        String strA3 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f13878e = strA3;
        f13879f = Collections.unmodifiableSet(new HashSet(Arrays.asList(i4.c.b("proto"), i4.c.b("json"))));
        f13880g = new a(strA, null);
        f13881h = new a(strA2, strA3);
    }

    public a(String str, String str2) {
        this.f13882a = str;
        this.f13883b = str2;
    }

    public static a c(byte[] bArr) {
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

    @Override // l4.g
    public Set a() {
        return f13879f;
    }

    public byte[] b() {
        String str = this.f13883b;
        if (str == null && this.f13882a == null) {
            return null;
        }
        String str2 = this.f13882a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", "1$", str2, "\\", str).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f13883b;
    }

    public String e() {
        return this.f13882a;
    }

    @Override // l4.f
    public byte[] getExtras() {
        return b();
    }

    @Override // l4.f
    public String getName() {
        return "cct";
    }
}
