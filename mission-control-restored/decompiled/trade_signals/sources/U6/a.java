package U6;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f8429a;

    public a(h sequence) {
        AbstractC2304t.f(sequence, "sequence");
        this.f8429a = new AtomicReference(sequence);
    }

    @Override // U6.h
    public Iterator iterator() {
        h hVar = (h) this.f8429a.getAndSet(null);
        if (hVar != null) {
            return hVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
