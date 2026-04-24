package f3;

import java.net.URI;

/* JADX INFO: renamed from: f3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1749f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17414c;

    public C1749f(String str, String str2, boolean z7) {
        this.f17412a = str;
        this.f17413b = str2;
        this.f17414c = z7;
    }

    public static URI a(String str, boolean z7, String str2, String str3) {
        String str4 = (z7 ? "wss" : "ws") + "://" + str + "/.ws?ns=" + str2 + "&v" + com.amazon.a.a.o.b.f.f14101b + "5";
        if (str3 != null) {
            str4 = str4 + "&ls=" + str3;
        }
        return URI.create(str4);
    }

    public String b() {
        return this.f17412a;
    }

    public String c() {
        return this.f17413b;
    }

    public boolean d() {
        return this.f17414c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("http");
        sb.append(this.f17414c ? "s" : "");
        sb.append("://");
        sb.append(this.f17412a);
        return sb.toString();
    }
}
