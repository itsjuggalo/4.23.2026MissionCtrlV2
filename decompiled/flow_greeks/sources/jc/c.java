package jc;

import cc.l;
import cc.q;
import cc.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public enum c implements lc.d {
    INSTANCE,
    NEVER;

    public static void a(cc.c cVar) {
        cVar.a(INSTANCE);
        cVar.onComplete();
    }

    public static void b(l lVar) {
        lVar.a(INSTANCE);
        lVar.onComplete();
    }

    public static void i(q qVar) {
        qVar.a(INSTANCE);
        qVar.onComplete();
    }

    public static void k(Throwable th, cc.c cVar) {
        cVar.a(INSTANCE);
        cVar.onError(th);
    }

    public static void l(Throwable th, l lVar) {
        lVar.a(INSTANCE);
        lVar.onError(th);
    }

    public static void m(Throwable th, q qVar) {
        qVar.a(INSTANCE);
        qVar.onError(th);
    }

    public static void o(Throwable th, t tVar) {
        tVar.a(INSTANCE);
        tVar.onError(th);
    }

    @Override // fc.b
    public boolean c() {
        return this == INSTANCE;
    }

    @Override // lc.i
    public boolean isEmpty() {
        return true;
    }

    @Override // lc.i
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // lc.i
    public Object poll() {
        return null;
    }

    @Override // lc.i
    public void clear() {
    }

    @Override // fc.b
    public void dispose() {
    }
}
