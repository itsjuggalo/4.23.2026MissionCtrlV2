package q5;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2585g;

/* JADX INFO: renamed from: q5.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2641h extends AbstractC2585g implements Set, Serializable, C5.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f22644b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2641h f22645c = new C2641h(C2637d.f22619n.e());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2637d f22646a;

    /* JADX INFO: renamed from: q5.h$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C2641h() {
        this(new C2637d());
    }

    @Override // p5.AbstractC2585g
    public int a() {
        return this.f22646a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.f22646a.j(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        this.f22646a.m();
        return super.addAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f22646a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f22646a.containsKey(obj);
    }

    public final Set d() {
        this.f22646a.l();
        return size() > 0 ? this : f22645c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f22646a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f22646a.E();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f22646a.N(obj);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        this.f22646a.m();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        this.f22646a.m();
        return super.retainAll(elements);
    }

    public C2641h(C2637d backing) {
        AbstractC2304t.f(backing, "backing");
        this.f22646a = backing;
    }
}
