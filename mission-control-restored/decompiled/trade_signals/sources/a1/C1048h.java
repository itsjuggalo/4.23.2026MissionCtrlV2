package a1;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import q1.AbstractC2628k;

/* JADX INFO: renamed from: a1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1048h implements U0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1049i f9837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final URL f9838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public URL f9841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile byte[] f9842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9843h;

    public C1048h(String str) {
        this(str, InterfaceC1049i.f9845b);
    }

    @Override // U0.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f9839d;
        return str != null ? str : ((URL) AbstractC2628k.d(this.f9838c)).toString();
    }

    public final byte[] d() {
        if (this.f9842g == null) {
            this.f9842g = c().getBytes(U0.f.f8077a);
        }
        return this.f9842g;
    }

    public Map e() {
        return this.f9837b.a();
    }

    @Override // U0.f
    public boolean equals(Object obj) {
        if (!(obj instanceof C1048h)) {
            return false;
        }
        C1048h c1048h = (C1048h) obj;
        return c().equals(c1048h.c()) && this.f9837b.equals(c1048h.f9837b);
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f9840e)) {
            String string = this.f9839d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) AbstractC2628k.d(this.f9838c)).toString();
            }
            this.f9840e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f9840e;
    }

    public final URL g() {
        if (this.f9841f == null) {
            this.f9841f = new URL(f());
        }
        return this.f9841f;
    }

    public URL h() {
        return g();
    }

    @Override // U0.f
    public int hashCode() {
        if (this.f9843h == 0) {
            int iHashCode = c().hashCode();
            this.f9843h = iHashCode;
            this.f9843h = (iHashCode * 31) + this.f9837b.hashCode();
        }
        return this.f9843h;
    }

    public String toString() {
        return c();
    }

    public C1048h(String str, InterfaceC1049i interfaceC1049i) {
        this.f9838c = null;
        this.f9839d = AbstractC2628k.b(str);
        this.f9837b = (InterfaceC1049i) AbstractC2628k.d(interfaceC1049i);
    }

    public C1048h(URL url) {
        this(url, InterfaceC1049i.f9845b);
    }

    public C1048h(URL url, InterfaceC1049i interfaceC1049i) {
        this.f9838c = (URL) AbstractC2628k.d(url);
        this.f9839d = null;
        this.f9837b = (InterfaceC1049i) AbstractC2628k.d(interfaceC1049i);
    }
}
