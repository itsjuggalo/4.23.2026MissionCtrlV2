package fc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends AtomicReference implements b {
    public d(Object obj) {
        super(kc.b.d(obj, "value is null"));
    }

    public abstract void a(Object obj);

    @Override // fc.b
    public final boolean c() {
        return get() == null;
    }

    @Override // fc.b
    public final void dispose() {
        Object andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }
}
