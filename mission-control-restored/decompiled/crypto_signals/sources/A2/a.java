package A2;

import java.util.AbstractMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Iterable f45c;

    public a(b bVar, int i) {
        this.f45c = bVar;
        this.f44b = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f43a) {
            case 0:
                if (this.f44b < ((b) this.f45c).f46a.length) {
                }
                break;
            default:
                if (this.f44b >= 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f43a) {
            case 0:
                b bVar = (b) this.f45c;
                Object[] objArr = bVar.f46a;
                int i = this.f44b;
                Object obj = objArr[i];
                Object obj2 = bVar.f47b[i];
                this.f44b = i + 1;
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            default:
                int i6 = this.f44b;
                g gVar = new g();
                Math.pow(2.0d, i6);
                this.f44b--;
                return gVar;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f43a) {
            case 0:
                throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
            default:
                return;
        }
    }

    public a(k kVar) {
        this.f45c = kVar;
        this.f44b = kVar.f58b - 1;
    }

    private final void a() {
    }
}
