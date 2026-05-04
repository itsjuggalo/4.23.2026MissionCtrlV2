package jc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public enum b implements fc.b {
    DISPOSED;

    public static boolean a(AtomicReference atomicReference) {
        fc.b bVar;
        fc.b bVar2 = (fc.b) atomicReference.get();
        b bVar3 = DISPOSED;
        if (bVar2 == bVar3 || (bVar = (fc.b) atomicReference.getAndSet(bVar3)) == bVar3) {
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar.dispose();
        return true;
    }

    public static boolean b(fc.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean h(AtomicReference atomicReference, fc.b bVar) {
        fc.b bVar2;
        do {
            bVar2 = (fc.b) atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!com.amazon.a.a.l.d.a(atomicReference, bVar2, bVar));
        return true;
    }

    public static void i() {
        yc.a.q(new gc.e("Disposable already set!"));
    }

    public static boolean k(AtomicReference atomicReference, fc.b bVar) {
        fc.b bVar2;
        do {
            bVar2 = (fc.b) atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!com.amazon.a.a.l.d.a(atomicReference, bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }

    public static boolean l(AtomicReference atomicReference, fc.b bVar) {
        kc.b.d(bVar, "d is null");
        if (com.amazon.a.a.l.d.a(atomicReference, null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        i();
        return false;
    }

    public static boolean m(fc.b bVar, fc.b bVar2) {
        if (bVar2 == null) {
            yc.a.q(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        i();
        return false;
    }

    @Override // fc.b
    public boolean c() {
        return true;
    }

    @Override // fc.b
    public void dispose() {
    }
}
