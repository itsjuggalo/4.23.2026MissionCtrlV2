package o8;

import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r8.i f17601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17603c;

    public a(r8.i iVar, boolean z10, boolean z11) {
        this.f17601a = iVar;
        this.f17602b = z10;
        this.f17603c = z11;
    }

    public r8.i a() {
        return this.f17601a;
    }

    public n b() {
        return this.f17601a.g();
    }

    public boolean c(r8.b bVar) {
        return (f() && !this.f17603c) || this.f17601a.g().F(bVar);
    }

    public boolean d(j8.l lVar) {
        return lVar.isEmpty() ? f() && !this.f17603c : c(lVar.K());
    }

    public boolean e() {
        return this.f17603c;
    }

    public boolean f() {
        return this.f17602b;
    }
}
