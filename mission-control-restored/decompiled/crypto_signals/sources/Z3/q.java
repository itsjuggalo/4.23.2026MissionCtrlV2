package Z3;

import N1.C0146y;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f4015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f4017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0146y f4018d;

    public q(f fVar, String str) {
        this(fVar, str, w.f4022b, null);
    }

    public final void a(String str, Object obj, p pVar) {
        this.f4015a.b(this.f4016b, this.f4017c.d(new n(obj, str)), pVar == null ? null : new a(1, this, pVar));
    }

    public final void b(o oVar) {
        String str = this.f4016b;
        f fVar = this.f4015a;
        C0146y c0146y = this.f4018d;
        if (c0146y != null) {
            fVar.i(str, oVar != null ? new Y3.d(this, oVar, 13, false) : null, c0146y);
        } else {
            fVar.c(str, oVar != null ? new Y3.d(this, oVar, 13, false) : null);
        }
    }

    public q(f fVar, String str, r rVar, C0146y c0146y) {
        this.f4015a = fVar;
        this.f4016b = str;
        this.f4017c = rVar;
        this.f4018d = c0146y;
    }
}
