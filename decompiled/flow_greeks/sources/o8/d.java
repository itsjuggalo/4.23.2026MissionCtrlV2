package o8;

import o8.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e.a f17612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j8.i f17613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e8.b f17614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17615d;

    public d(e.a aVar, j8.i iVar, e8.b bVar, String str) {
        this.f17612a = aVar;
        this.f17613b = iVar;
        this.f17614c = bVar;
        this.f17615d = str;
    }

    @Override // o8.e
    public void a() {
        this.f17613b.d(this);
    }

    public e.a b() {
        return this.f17612a;
    }

    public j8.l c() {
        j8.l lVarS = this.f17614c.g().s();
        return this.f17612a == e.a.VALUE ? lVarS : lVarS.L();
    }

    public String d() {
        return this.f17615d;
    }

    public e8.b e() {
        return this.f17614c;
    }

    @Override // o8.e
    public String toString() {
        if (this.f17612a == e.a.VALUE) {
            return c() + ": " + this.f17612a + ": " + this.f17614c.i(true);
        }
        return c() + ": " + this.f17612a + ": { " + this.f17614c.e() + ": " + this.f17614c.i(true) + " }";
    }
}
