package e3;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: e3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1667d implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f17154a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17155b;

    public C1667d(h hVar, Object obj, Comparator comparator, boolean z7) {
        int iCompare;
        this.f17155b = z7;
        while (!hVar.isEmpty()) {
            if (obj != null) {
                Object key = hVar.getKey();
                iCompare = z7 ? comparator.compare(obj, key) : comparator.compare(key, obj);
            } else {
                iCompare = 1;
            }
            if (iCompare < 0) {
                hVar = z7 ? hVar.b() : hVar.f();
            } else if (iCompare == 0) {
                this.f17154a.push((j) hVar);
                return;
            } else {
                this.f17154a.push((j) hVar);
                if (z7) {
                }
            }
        }
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        try {
            j jVar = (j) this.f17154a.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(jVar.getKey(), jVar.getValue());
            if (this.f17155b) {
                for (h hVarB = jVar.b(); !hVarB.isEmpty(); hVarB = hVarB.f()) {
                    this.f17154a.push((j) hVarB);
                }
            } else {
                for (h hVarF = jVar.f(); !hVarF.isEmpty(); hVarF = hVarF.b()) {
                    this.f17154a.push((j) hVarF);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f17154a.size() > 0;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
