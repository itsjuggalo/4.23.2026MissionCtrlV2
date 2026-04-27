package e3;

import e3.h;

/* JADX INFO: loaded from: classes.dex */
public class i extends j {
    public i(Object obj, Object obj2) {
        super(obj, obj2, g.j(), g.j());
    }

    @Override // e3.h
    public boolean e() {
        return true;
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
        return new i(obj, obj2, hVar, hVar2);
    }

    @Override // e3.j
    public h.a n() {
        return h.a.RED;
    }

    @Override // e3.h
    public int size() {
        return b().size() + 1 + f().size();
    }

    public i(Object obj, Object obj2, h hVar, h hVar2) {
        super(obj, obj2, hVar, hVar2);
    }
}
