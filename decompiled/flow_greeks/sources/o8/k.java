package o8;

import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f17651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f17652b;

    public k(a aVar, a aVar2) {
        this.f17651a = aVar;
        this.f17652b = aVar2;
    }

    public n a() {
        if (this.f17651a.f()) {
            return this.f17651a.b();
        }
        return null;
    }

    public n b() {
        if (this.f17652b.f()) {
            return this.f17652b.b();
        }
        return null;
    }

    public a c() {
        return this.f17651a;
    }

    public a d() {
        return this.f17652b;
    }

    public k e(r8.i iVar, boolean z10, boolean z11) {
        return new k(new a(iVar, z10, z11), this.f17652b);
    }

    public k f(r8.i iVar, boolean z10, boolean z11) {
        return new k(this.f17651a, new a(iVar, z10, z11));
    }
}
