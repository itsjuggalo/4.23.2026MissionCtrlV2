package g8;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f10112a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10113b;

    public d(h hVar, Object obj, Comparator comparator, boolean z10) {
        this.f10113b = z10;
        while (!hVar.isEmpty()) {
            int iCompare = obj != null ? z10 ? comparator.compare(obj, hVar.getKey()) : comparator.compare(hVar.getKey(), obj) : 1;
            if (iCompare < 0) {
                hVar = z10 ? hVar.a() : hVar.g();
            } else if (iCompare == 0) {
                this.f10112a.push((j) hVar);
                return;
            } else {
                this.f10112a.push((j) hVar);
                hVar = z10 ? hVar.g() : hVar.a();
            }
        }
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        try {
            j jVar = (j) this.f10112a.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(jVar.getKey(), jVar.getValue());
            if (this.f10113b) {
                for (h hVarA = jVar.a(); !hVarA.isEmpty(); hVarA = hVarA.g()) {
                    this.f10112a.push((j) hVarA);
                }
            } else {
                for (h hVarG = jVar.g(); !hVarG.isEmpty(); hVarG = hVarG.a()) {
                    this.f10112a.push((j) hVarG);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f10112a.size() > 0;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
