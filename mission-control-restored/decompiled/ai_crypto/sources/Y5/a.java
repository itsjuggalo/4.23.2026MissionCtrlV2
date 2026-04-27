package Y5;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f5647a;

    public a(f sequence) {
        r.f(sequence, "sequence");
        this.f5647a = new AtomicReference(sequence);
    }

    @Override // Y5.f
    public Iterator iterator() {
        f fVar = (f) this.f5647a.getAndSet(null);
        if (fVar != null) {
            return fVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
