package hg;

import dd.n;
import dd.u0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends dd.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f11443c = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f11444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11445b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f11446a;

        public a(Object[] array) {
            t.f(array, "array");
            this.f11446a = kotlin.jvm.internal.c.a(array);
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11446a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.f11446a.next();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final l a() {
            return new l(null);
        }

        public final l b(Collection set) {
            t.f(set, "set");
            l lVar = new l(null);
            lVar.addAll(set);
            return lVar;
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f11447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11448b = true;

        public c(Object obj) {
            this.f11447a = obj;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11448b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f11448b) {
                throw new NoSuchElementException();
            }
            this.f11448b = false;
            return this.f11447a;
        }
    }

    public /* synthetic */ l(kotlin.jvm.internal.k kVar) {
        this();
    }

    public static final l c() {
        return f11443c.a();
    }

    @Override // dd.g
    public int a() {
        return this.f11445b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        Object obj2;
        if (size() == 0) {
            this.f11444a = obj;
        } else if (size() == 1) {
            if (t.b(this.f11444a, obj)) {
                return false;
            }
            this.f11444a = new Object[]{this.f11444a, obj};
        } else if (size() < 5) {
            Object obj3 = this.f11444a;
            t.d(obj3, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr = (Object[]) obj3;
            if (n.x(objArr, obj)) {
                return false;
            }
            if (size() == 4) {
                LinkedHashSet linkedHashSetE = u0.e(Arrays.copyOf(objArr, objArr.length));
                linkedHashSetE.add(obj);
                obj2 = linkedHashSetE;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, size() + 1);
                t.e(objArrCopyOf, "copyOf(...)");
                objArrCopyOf[objArrCopyOf.length - 1] = obj;
                obj2 = objArrCopyOf;
            }
            this.f11444a = obj2;
        } else {
            Object obj4 = this.f11444a;
            t.d(obj4, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!t0.b(obj4).add(obj)) {
                return false;
            }
        }
        e(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f11444a = null;
        e(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return t.b(this.f11444a, obj);
        }
        if (size() < 5) {
            Object obj2 = this.f11444a;
            t.d(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return n.x((Object[]) obj2, obj);
        }
        Object obj3 = this.f11444a;
        t.d(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    public void e(int i10) {
        this.f11445b = i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        if (size() == 0) {
            return Collections.EMPTY_SET.iterator();
        }
        if (size() == 1) {
            return new c(this.f11444a);
        }
        if (size() < 5) {
            Object obj = this.f11444a;
            t.d(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.f11444a;
        t.d(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return t0.b(obj2).iterator();
    }

    public l() {
    }
}
