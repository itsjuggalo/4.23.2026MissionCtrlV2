package t3;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class f extends h implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f10246a = new ArrayList();

    @Override // t3.h
    public final boolean a() {
        return f().a();
    }

    @Override // t3.h
    public final String c() {
        return f().c();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof f) && ((f) obj).f10246a.equals(this.f10246a);
        }
        return true;
    }

    public final h f() {
        ArrayList arrayList = this.f10246a;
        int size = arrayList.size();
        if (size == 1) {
            return (h) arrayList.get(0);
        }
        throw new IllegalStateException(a3.d.f(size, "Array must have size 1, but has size "));
    }

    public final int hashCode() {
        return this.f10246a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f10246a.iterator();
    }
}
