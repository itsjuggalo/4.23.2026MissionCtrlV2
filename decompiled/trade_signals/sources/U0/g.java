package U0;

import java.security.MessageDigest;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f8078e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f8080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile byte[] f8082d;

    public interface b {
        void a(byte[] bArr, Object obj, MessageDigest messageDigest);
    }

    public g(String str, Object obj, b bVar) {
        this.f8081c = AbstractC2628k.b(str);
        this.f8079a = obj;
        this.f8080b = (b) AbstractC2628k.d(bVar);
    }

    public static g a(String str, Object obj, b bVar) {
        return new g(str, obj, bVar);
    }

    public static b b() {
        return f8078e;
    }

    public static g e(String str) {
        return new g(str, null, b());
    }

    public static g f(String str, Object obj) {
        return new g(str, obj, b());
    }

    public Object c() {
        return this.f8079a;
    }

    public final byte[] d() {
        if (this.f8082d == null) {
            this.f8082d = this.f8081c.getBytes(f.f8077a);
        }
        return this.f8082d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f8081c.equals(((g) obj).f8081c);
        }
        return false;
    }

    public void g(Object obj, MessageDigest messageDigest) {
        this.f8080b.a(d(), obj, messageDigest);
    }

    public int hashCode() {
        return this.f8081c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f8081c + "'}";
    }

    public class a implements b {
        @Override // U0.g.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }
}
