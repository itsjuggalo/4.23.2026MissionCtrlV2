package S5;

import S5.h;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7666a;

    public i(List annotations) {
        AbstractC2304t.f(annotations, "annotations");
        this.f7666a = annotations;
    }

    @Override // S5.h
    public c b(q6.c cVar) {
        return h.b.a(this, cVar);
    }

    @Override // S5.h
    public boolean isEmpty() {
        return this.f7666a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f7666a.iterator();
    }

    @Override // S5.h
    public boolean r(q6.c cVar) {
        return h.b.b(this, cVar);
    }

    public String toString() {
        return this.f7666a.toString();
    }
}
