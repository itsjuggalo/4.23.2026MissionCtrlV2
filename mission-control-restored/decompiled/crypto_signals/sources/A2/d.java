package A2;

import N1.C0131t;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f49a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f50b;

    public d(C0131t c0131t) {
        this.f49a = 1;
        this.f50b = c0131t.f1790a.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f49a) {
            case 0:
                break;
            case 1:
                break;
            default:
                if (((ArrayDeque) this.f50b).size() > 0) {
                }
                break;
        }
        return ((Iterator) this.f50b).hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f49a) {
            case 0:
                return ((Map.Entry) ((Iterator) this.f50b).next()).getKey();
            case 1:
                return (String) ((Iterator) this.f50b).next();
            default:
                ArrayDeque arrayDeque = (ArrayDeque) this.f50b;
                try {
                    j jVar = (j) arrayDeque.pop();
                    AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(jVar.f53a, jVar.f54b);
                    for (h hVarA = jVar.f56d; !hVarA.isEmpty(); hVarA = hVarA.a()) {
                        arrayDeque.push((j) hVarA);
                        break;
                    }
                    return simpleEntry;
                } catch (EmptyStackException unused) {
                    throw new NoSuchElementException();
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f49a) {
            case 0:
                ((Iterator) this.f50b).remove();
                return;
            case 1:
                throw new UnsupportedOperationException("Remove not supported");
            default:
                throw new UnsupportedOperationException("remove called on immutable collection");
        }
    }

    public d(h hVar, Object obj, Comparator comparator) {
        this.f49a = 2;
        this.f50b = new ArrayDeque();
        while (!hVar.isEmpty()) {
            int iCompare = obj != null ? comparator.compare(hVar.getKey(), obj) : 1;
            if (iCompare < 0) {
                hVar = hVar.d();
            } else if (iCompare == 0) {
                ((ArrayDeque) this.f50b).push((j) hVar);
                return;
            } else {
                ((ArrayDeque) this.f50b).push((j) hVar);
                hVar = hVar.a();
            }
        }
    }

    public d(Iterator it) {
        this.f49a = 0;
        this.f50b = it;
    }
}
