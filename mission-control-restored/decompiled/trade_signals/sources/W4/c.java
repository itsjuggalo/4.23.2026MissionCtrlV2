package W4;

import P4.l;
import P4.q;
import P4.t;

/* JADX INFO: loaded from: classes2.dex */
public enum c implements Y4.e {
    INSTANCE,
    NEVER;

    public static void a(P4.c cVar) {
        cVar.b(INSTANCE);
        cVar.a();
    }

    public static void b(l lVar) {
        lVar.b(INSTANCE);
        lVar.a();
    }

    public static void i(q qVar) {
        qVar.b(INSTANCE);
        qVar.a();
    }

    public static void l(Throwable th, P4.c cVar) {
        cVar.b(INSTANCE);
        cVar.onError(th);
    }

    public static void m(Throwable th, l lVar) {
        lVar.b(INSTANCE);
        lVar.onError(th);
    }

    public static void n(Throwable th, q qVar) {
        qVar.b(INSTANCE);
        qVar.onError(th);
    }

    public static void q(Throwable th, t tVar) {
        tVar.b(INSTANCE);
        tVar.onError(th);
    }

    @Override // S4.b
    public boolean g() {
        return this == INSTANCE;
    }

    @Override // Y4.j
    public boolean isEmpty() {
        return true;
    }

    @Override // Y4.f
    public int k(int i8) {
        return i8 & 2;
    }

    @Override // Y4.j
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // Y4.j
    public Object poll() {
        return null;
    }

    @Override // Y4.j
    public void clear() {
    }

    @Override // S4.b
    public void dispose() {
    }
}
