package S6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2288c;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.V;
import p5.AbstractC2585g;
import p5.AbstractC2592n;
import p5.S;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends AbstractC2585g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f7769c = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f7770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7771b;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f7772a;

        public a(Object[] array) {
            AbstractC2304t.f(array, "array");
            this.f7772a = AbstractC2288c.a(array);
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7772a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.f7772a.next();
        }
    }

    public static final class b {
        public b() {
        }

        public final l a() {
            return new l(null);
        }

        public final l b(Collection set) {
            AbstractC2304t.f(set, "set");
            l lVar = new l(null);
            lVar.addAll(set);
            return lVar;
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class c implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f7773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7774b = true;

        public c(Object obj) {
            this.f7773a = obj;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7774b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f7774b) {
                throw new NoSuchElementException();
            }
            this.f7774b = false;
            return this.f7773a;
        }
    }

    public l() {
    }

    public static final l d() {
        return f7769c.a();
    }

    @Override // p5.AbstractC2585g
    public int a() {
        return this.f7771b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        Object obj2;
        if (size() == 0) {
            this.f7770a = obj;
        } else if (size() == 1) {
            if (AbstractC2304t.b(this.f7770a, obj)) {
                return false;
            }
            this.f7770a = new Object[]{this.f7770a, obj};
        } else if (size() < 5) {
            Object obj3 = this.f7770a;
            AbstractC2304t.d(obj3, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr = (Object[]) obj3;
            if (AbstractC2592n.x(objArr, obj)) {
                return false;
            }
            if (size() == 4) {
                LinkedHashSet linkedHashSetE = S.e(Arrays.copyOf(objArr, objArr.length));
                linkedHashSetE.add(obj);
                obj2 = linkedHashSetE;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, size() + 1);
                AbstractC2304t.e(objArrCopyOf, "copyOf(...)");
                objArrCopyOf[objArrCopyOf.length - 1] = obj;
                obj2 = objArrCopyOf;
            }
            this.f7770a = obj2;
        } else {
            Object obj4 = this.f7770a;
            AbstractC2304t.d(obj4, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!V.b(obj4).add(obj)) {
                return false;
            }
        }
        e(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f7770a = null;
        e(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return AbstractC2304t.b(this.f7770a, obj);
        }
        if (size() < 5) {
            Object obj2 = this.f7770a;
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return AbstractC2592n.x((Object[]) obj2, obj);
        }
        Object obj3 = this.f7770a;
        AbstractC2304t.d(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    public void e(int i8) {
        this.f7771b = i8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        Set setB;
        if (size() == 0) {
            setB = Collections.emptySet();
        } else {
            if (size() == 1) {
                return new c(this.f7770a);
            }
            if (size() < 5) {
                Object obj = this.f7770a;
                AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
                return new a((Object[]) obj);
            }
            Object obj2 = this.f7770a;
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            setB = V.b(obj2);
        }
        return setB.iterator();
    }

    public /* synthetic */ l(AbstractC2296k abstractC2296k) {
        this();
    }
}
