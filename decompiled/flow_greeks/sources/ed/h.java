package ed;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends dd.g implements Set, Serializable, qd.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8674b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f8675c = new h(d.f8649n.e());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8676a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    public h(d backing) {
        t.f(backing, "backing");
        this.f8676a = backing;
    }

    @Override // dd.g
    public int a() {
        return this.f8676a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.f8676a.k(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection elements) {
        t.f(elements, "elements");
        this.f8676a.n();
        return super.addAll(elements);
    }

    public final Set c() {
        this.f8676a.m();
        return size() > 0 ? this : f8675c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f8676a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f8676a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f8676a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f8676a.F();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f8676a.O(obj);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection elements) {
        t.f(elements, "elements");
        this.f8676a.n();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection elements) {
        t.f(elements, "elements");
        this.f8676a.n();
        return super.retainAll(elements);
    }

    public h() {
        this(new d());
    }
}
