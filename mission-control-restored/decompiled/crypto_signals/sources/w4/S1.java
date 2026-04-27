package w4;

/* JADX INFO: loaded from: classes.dex */
public final class S1 extends W1 {
    @Override // w4.W1
    public final boolean r(T1 t12) {
        synchronized (t12) {
            try {
                if (t12.f11117c != 0) {
                    return false;
                }
                t12.f11117c = -1;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w4.W1
    public final void s(T1 t12) {
        synchronized (t12) {
            t12.f11117c = 0;
        }
    }
}
