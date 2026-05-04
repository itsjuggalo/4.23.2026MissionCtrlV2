package g3;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f10027e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f10029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile byte[] f10031d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void a(byte[] bArr, Object obj, MessageDigest messageDigest);
    }

    public g(String str, Object obj, b bVar) {
        this.f10030c = c4.k.c(str);
        this.f10028a = obj;
        this.f10029b = (b) c4.k.e(bVar);
    }

    public static g a(String str, Object obj, b bVar) {
        return new g(str, obj, bVar);
    }

    public static b b() {
        return f10027e;
    }

    public static g e(String str) {
        return new g(str, null, b());
    }

    public static g f(String str, Object obj) {
        return new g(str, obj, b());
    }

    public Object c() {
        return this.f10028a;
    }

    public final byte[] d() {
        if (this.f10031d == null) {
            this.f10031d = this.f10030c.getBytes(f.f10026a);
        }
        return this.f10031d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f10030c.equals(((g) obj).f10030c);
        }
        return false;
    }

    public void g(Object obj, MessageDigest messageDigest) {
        this.f10029b.a(d(), obj, messageDigest);
    }

    public int hashCode() {
        return this.f10030c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f10030c + "'}";
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements b {
        @Override // g3.g.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }
}
