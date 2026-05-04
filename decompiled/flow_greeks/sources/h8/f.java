package h8;

import java.net.URI;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11133c;

    public f(String str, String str2, boolean z10) {
        this.f11131a = str;
        this.f11132b = str2;
        this.f11133c = z10;
    }

    public static URI a(String str, boolean z10, String str2, String str3) {
        String str4 = (z10 ? "wss" : "ws") + "://" + str + "/.ws?ns=" + str2 + "&v" + com.amazon.a.a.o.b.f.f4599b + "5";
        if (str3 != null) {
            str4 = str4 + "&ls=" + str3;
        }
        return URI.create(str4);
    }

    public String b() {
        return this.f11131a;
    }

    public String c() {
        return this.f11132b;
    }

    public boolean d() {
        return this.f11133c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("http");
        sb2.append(this.f11133c ? "s" : "");
        sb2.append("://");
        sb2.append(this.f11131a);
        return sb2.toString();
    }
}
