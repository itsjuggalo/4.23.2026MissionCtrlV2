package A2;

/* JADX INFO: loaded from: classes.dex */
public final class i extends j {
    @Override // A2.h
    public final boolean c() {
        return true;
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
        return new i(obj, obj2, hVar, hVar2);
    }

    @Override // A2.j
    public final int m() {
        return 1;
    }

    @Override // A2.h
    public final int size() {
        return this.f56d.size() + this.f55c.size() + 1;
    }
}
