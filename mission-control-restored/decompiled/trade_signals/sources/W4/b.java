package W4;

import java.util.concurrent.atomic.AtomicReference;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public enum b implements S4.b {
    DISPOSED;

    public static boolean a(AtomicReference atomicReference) {
        S4.b bVar;
        S4.b bVar2 = (S4.b) atomicReference.get();
        b bVar3 = DISPOSED;
        if (bVar2 == bVar3 || (bVar = (S4.b) atomicReference.getAndSet(bVar3)) == bVar3) {
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar.dispose();
        return true;
    }

    public static boolean b(S4.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean i(AtomicReference atomicReference, S4.b bVar) {
        S4.b bVar2;
        do {
            bVar2 = (S4.b) atomicReference.get();
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

    public static void k() {
        AbstractC2283a.q(new T4.e("Disposable already set!"));
    }

    public static boolean l(AtomicReference atomicReference, S4.b bVar) {
        S4.b bVar2;
        do {
            bVar2 = (S4.b) atomicReference.get();
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

    public static boolean m(AtomicReference atomicReference, S4.b bVar) {
        X4.b.d(bVar, "d is null");
        if (com.amazon.a.a.l.d.a(atomicReference, null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        k();
        return false;
    }

    public static boolean n(S4.b bVar, S4.b bVar2) {
        if (bVar2 == null) {
            AbstractC2283a.q(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        k();
        return false;
    }

    @Override // S4.b
    public boolean g() {
        return true;
    }

    @Override // S4.b
    public void dispose() {
    }
}
