package A2;

/* JADX INFO: loaded from: classes.dex */
public final class f extends j {
    public int e;

    public f(Object obj, Object obj2, h hVar, h hVar2) {
        super(obj, obj2, hVar, hVar2);
        this.e = -1;
    }

    @Override // A2.h
    public final boolean c() {
        return false;
    }

    @Override // A2.j
    public final j k(Object obj, Object obj2, h hVar, h hVar2) {
        if (obj == null) {
            obj = this.f53a;
        }
        if (obj2 == null) {
            obj2 = this.f54b;
        }
        if (hVar == null) {
            hVar = this.f55c;
        }
        if (hVar2 == null) {
            hVar2 = this.f56d;
        }
        return new f(obj, obj2, hVar, hVar2);
    }

    @Override // A2.j
    public final int m() {
        return 2;
    }

    @Override // A2.j
    public final void q(j jVar) {
        if (this.e != -1) {
            throw new IllegalStateException("Can't set left after using size");
        }
        this.f55c = jVar;
    }

    @Override // A2.h
    public final int size() {
        if (this.e == -1) {
            this.e = this.f56d.size() + this.f55c.size() + 1;
        }
        return this.e;
    }
}
