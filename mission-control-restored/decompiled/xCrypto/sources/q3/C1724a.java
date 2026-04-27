package q3;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: q3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1724a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f14292a;

    public C1724a(e sequence) {
        r.f(sequence, "sequence");
        this.f14292a = new AtomicReference(sequence);
    }

    @Override // q3.e
    public Iterator iterator() {
        e eVar = (e) this.f14292a.getAndSet(null);
        if (eVar != null) {
            return eVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
