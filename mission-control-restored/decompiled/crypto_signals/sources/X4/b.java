package X4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator, S4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f3519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3520b = -2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f3521c;

    public b(c cVar) {
        this.f3521c = cVar;
    }

    public final void a() {
        Object objInvoke;
        int i = this.f3520b;
        c cVar = this.f3521c;
        if (i == -2) {
            cVar.getClass();
            objInvoke = Integer.valueOf(T4.d.f3048a.a() + 65536);
        } else {
            h hVar = (h) cVar.f3523b;
            Object obj = this.f3519a;
            j.b(obj);
            objInvoke = hVar.invoke(obj);
        }
        this.f3519a = objInvoke;
        this.f3520b = objInvoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3520b < 0) {
            a();
        }
        return this.f3520b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3520b < 0) {
            a();
        }
        if (this.f3520b == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.f3519a;
        j.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        this.f3520b = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
