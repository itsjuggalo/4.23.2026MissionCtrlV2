package g8;

import g8.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10116e;

    public f(Object obj, Object obj2, h hVar, h hVar2) {
        super(obj, obj2, hVar, hVar2);
        this.f10116e = -1;
    }

    @Override // g8.h
    public boolean f() {
        return false;
    }

    @Override // g8.j
    public j l(Object obj, Object obj2, h hVar, h hVar2) {
        if (obj == null) {
            obj = getKey();
        }
        if (obj2 == null) {
            obj2 = getValue();
        }
        if (hVar == null) {
            hVar = a();
        }
        if (hVar2 == null) {
            hVar2 = g();
        }
        return new f(obj, obj2, hVar, hVar2);
    }

    @Override // g8.j
    public h.a n() {
        return h.a.BLACK;
    }

    @Override // g8.h
    public int size() {
        if (this.f10116e == -1) {
            this.f10116e = a().size() + 1 + g().size();
        }
        return this.f10116e;
    }

    @Override // g8.j
    public void u(h hVar) {
        if (this.f10116e != -1) {
            throw new IllegalStateException("Can't set left after using size");
        }
        super.u(hVar);
    }
}
