package U0;

import java.security.MessageDigest;
import q1.C2619b;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public final class h implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2882a f8083b = new C2619b();

    public static void f(g gVar, Object obj, MessageDigest messageDigest) {
        gVar.g(obj, messageDigest);
    }

    @Override // U0.f
    public void a(MessageDigest messageDigest) {
        for (int i8 = 0; i8 < this.f8083b.size(); i8++) {
            f((g) this.f8083b.f(i8), this.f8083b.j(i8), messageDigest);
        }
    }

    public Object c(g gVar) {
        return this.f8083b.containsKey(gVar) ? this.f8083b.get(gVar) : gVar.c();
    }

    public void d(h hVar) {
        this.f8083b.g(hVar.f8083b);
    }

    public h e(g gVar, Object obj) {
        this.f8083b.put(gVar, obj);
        return this;
    }

    @Override // U0.f
    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f8083b.equals(((h) obj).f8083b);
        }
        return false;
    }

    @Override // U0.f
    public int hashCode() {
        return this.f8083b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f8083b + '}';
    }
}
