package ge;

import ge.h;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10559a;

    public i(List annotations) {
        t.f(annotations, "annotations");
        this.f10559a = annotations;
    }

    @Override // ge.h
    public boolean E(ef.c cVar) {
        return h.b.b(this, cVar);
    }

    @Override // ge.h
    public c b(ef.c cVar) {
        return h.b.a(this, cVar);
    }

    @Override // ge.h
    public boolean isEmpty() {
        return this.f10559a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f10559a.iterator();
    }

    public String toString() {
        return this.f10559a.toString();
    }
}
