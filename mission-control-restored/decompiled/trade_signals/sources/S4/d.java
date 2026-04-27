package S4;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends AtomicReference implements b {
    public d(Object obj) {
        super(X4.b.d(obj, "value is null"));
    }

    public abstract void a(Object obj);

    @Override // S4.b
    public final void dispose() {
        Object andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    @Override // S4.b
    public final boolean g() {
        return get() == null;
    }
}
