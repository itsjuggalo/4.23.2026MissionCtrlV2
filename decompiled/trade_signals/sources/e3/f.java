package e3;

import e3.h;

/* JADX INFO: loaded from: classes.dex */
public class f extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17158e;

    public f(Object obj, Object obj2, h hVar, h hVar2) {
        super(obj, obj2, hVar, hVar2);
        this.f17158e = -1;
    }

    @Override // e3.h
    public boolean e() {
        return false;
    }

    @Override // e3.j
    public j l(Object obj, Object obj2, h hVar, h hVar2) {
        if (obj == null) {
            obj = getKey();
        }
        if (obj2 == null) {
            obj2 = getValue();
        }
        if (hVar == null) {
            hVar = b();
        }
        if (hVar2 == null) {
            hVar2 = f();
        }
        return new f(obj, obj2, hVar, hVar2);
    }

    @Override // e3.j
    public h.a n() {
        return h.a.BLACK;
    }

    @Override // e3.h
    public int size() {
        if (this.f17158e == -1) {
            this.f17158e = b().size() + 1 + f().size();
        }
        return this.f17158e;
    }

    @Override // e3.j
    public void u(h hVar) {
        if (this.f17158e != -1) {
            throw new IllegalStateException("Can't set left after using size");
        }
        super.u(hVar);
    }
}
