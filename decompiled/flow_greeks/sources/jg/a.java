package jg;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f14366a;

    public a(h sequence) {
        kotlin.jvm.internal.t.f(sequence, "sequence");
        this.f14366a = new AtomicReference(sequence);
    }

    @Override // jg.h
    public Iterator iterator() {
        h hVar = (h) this.f14366a.getAndSet(null);
        if (hVar != null) {
            return hVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
