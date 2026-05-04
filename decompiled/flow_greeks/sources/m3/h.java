package m3;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h implements g3.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f15775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final URL f15776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f15778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public URL f15779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile byte[] f15780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15781h;

    public h(URL url) {
        this(url, i.f15783b);
    }

    @Override // g3.f
    public void b(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f15777d;
        return str != null ? str : ((URL) c4.k.e(this.f15776c)).toString();
    }

    public final byte[] d() {
        if (this.f15780g == null) {
            this.f15780g = c().getBytes(g3.f.f10026a);
        }
        return this.f15780g;
    }

    public Map e() {
        return this.f15775b.a();
    }

    @Override // g3.f
    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (c().equals(hVar.c()) && this.f15775b.equals(hVar.f15775b)) {
                return true;
            }
        }
        return false;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f15778e)) {
            String string = this.f15777d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) c4.k.e(this.f15776c)).toString();
            }
            this.f15778e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$[]");
        }
        return this.f15778e;
    }

    public final URL g() {
        if (this.f15779f == null) {
            this.f15779f = new URL(f());
        }
        return this.f15779f;
    }

    public URL h() {
        return g();
    }

    @Override // g3.f
    public int hashCode() {
        if (this.f15781h == 0) {
            int iHashCode = c().hashCode();
            this.f15781h = iHashCode;
            this.f15781h = (iHashCode * 31) + this.f15775b.hashCode();
        }
        return this.f15781h;
    }

    public String toString() {
        return c();
    }

    public h(String str) {
        this(str, i.f15783b);
    }

    public h(URL url, i iVar) {
        this.f15776c = (URL) c4.k.e(url);
        this.f15777d = null;
        this.f15775b = (i) c4.k.e(iVar);
    }

    public h(String str, i iVar) {
        this.f15776c = null;
        this.f15777d = c4.k.c(str);
        this.f15775b = (i) c4.k.e(iVar);
    }
}
