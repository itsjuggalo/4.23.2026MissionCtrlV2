package g3;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w.a f10032b = new c4.b();

    public static void f(g gVar, Object obj, MessageDigest messageDigest) {
        gVar.g(obj, messageDigest);
    }

    @Override // g3.f
    public void b(MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.f10032b.size(); i10++) {
            f((g) this.f10032b.g(i10), this.f10032b.k(i10), messageDigest);
        }
    }

    public Object c(g gVar) {
        return this.f10032b.containsKey(gVar) ? this.f10032b.get(gVar) : gVar.c();
    }

    public void d(h hVar) {
        this.f10032b.h(hVar.f10032b);
    }

    public h e(g gVar, Object obj) {
        this.f10032b.put(gVar, obj);
        return this;
    }

    @Override // g3.f
    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f10032b.equals(((h) obj).f10032b);
        }
        return false;
    }

    @Override // g3.f
    public int hashCode() {
        return this.f10032b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f10032b + '}';
    }
}
