package g8;

import g8.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i extends j {
    public i(Object obj, Object obj2) {
        super(obj, obj2, g.j(), g.j());
    }

    @Override // g8.h
    public boolean f() {
        return true;
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
        return new i(obj, obj2, hVar, hVar2);
    }

    @Override // g8.j
    public h.a n() {
        return h.a.RED;
    }

    @Override // g8.h
    public int size() {
        return a().size() + 1 + g().size();
    }

    public i(Object obj, Object obj2, h hVar, h hVar2) {
        super(obj, obj2, hVar, hVar2);
    }
}
