package w2;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public abstract class y {

    public class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f24057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f24058b;

        /* JADX INFO: renamed from: w2.y$a$a, reason: collision with other inner class name */
        public class C0424a extends AbstractC2913b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator f24059c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Iterator f24060d;

            public C0424a() {
                this.f24059c = a.this.f24057a.iterator();
                this.f24060d = a.this.f24058b.iterator();
            }

            @Override // w2.AbstractC2913b
            public Object b() {
                if (this.f24059c.hasNext()) {
                    return this.f24059c.next();
                }
                while (this.f24060d.hasNext()) {
                    Object next = this.f24060d.next();
                    if (!a.this.f24057a.contains(next)) {
                        return next;
                    }
                }
                return c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f24057a = set;
            this.f24058b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC2910B iterator() {
            return new C0424a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f24057a.contains(obj) || this.f24058b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f24057a.isEmpty() && this.f24058b.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.f24057a.size();
            Iterator it = this.f24058b.iterator();
            while (it.hasNext()) {
                if (!this.f24057a.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    public static abstract class b extends AbstractSet {
        public b() {
        }

        /* JADX INFO: renamed from: a */
        public abstract AbstractC2910B iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static boolean a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static int b(Set set) {
        Iterator it = set.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i8 = ~(~(i8 + (next != null ? next.hashCode() : 0)));
        }
        return i8;
    }

    public static b c(Set set, Set set2) {
        AbstractC2848n.o(set, "set1");
        AbstractC2848n.o(set2, "set2");
        return new a(set, set2);
    }
}
