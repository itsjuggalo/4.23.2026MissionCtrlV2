package X4;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f3518a;

    public a(d dVar) {
        this.f3518a = new AtomicReference(dVar);
    }

    @Override // X4.d
    public final Iterator iterator() {
        d dVar = (d) this.f3518a.getAndSet(null);
        if (dVar != null) {
            return dVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
