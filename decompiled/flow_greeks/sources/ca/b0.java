package ca;

import ib.g;
import rb.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f3755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f3757c;

    public b0(z zVar, bd.a aVar, bd.a aVar2) {
        this.f3755a = zVar;
        this.f3756b = aVar;
        this.f3757c = aVar2;
    }

    public static b0 a(z zVar, bd.a aVar, bd.a aVar2) {
        return new b0(zVar, aVar, aVar2);
    }

    public static g.b c(z zVar, rb.d dVar, y0 y0Var) {
        return (g.b) r9.d.e(zVar.c(dVar, y0Var));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g.b get() {
        return c(this.f3755a, (rb.d) this.f3756b.get(), (y0) this.f3757c.get());
    }
}
