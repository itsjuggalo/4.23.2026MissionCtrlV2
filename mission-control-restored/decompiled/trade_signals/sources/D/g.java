package D;

import D.f;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f691m;

    public g(p pVar) {
        super(pVar);
        this.f674e = pVar instanceof l ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    @Override // D.f
    public void d(int i8) {
        if (this.f679j) {
            return;
        }
        this.f679j = true;
        this.f676g = i8;
        for (d dVar : this.f680k) {
            dVar.a(dVar);
        }
    }
}
