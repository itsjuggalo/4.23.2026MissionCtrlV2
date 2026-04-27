package q2;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class g extends j implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f14270a = new ArrayList();

    @Override // q2.j
    public boolean c() {
        return r().c();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof g) && ((g) obj).f14270a.equals(this.f14270a);
        }
        return true;
    }

    public int hashCode() {
        return this.f14270a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f14270a.iterator();
    }

    @Override // q2.j
    public String l() {
        return r().l();
    }

    public void q(j jVar) {
        if (jVar == null) {
            jVar = l.f14271a;
        }
        this.f14270a.add(jVar);
    }

    public final j r() {
        int size = this.f14270a.size();
        if (size == 1) {
            return (j) this.f14270a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }
}
