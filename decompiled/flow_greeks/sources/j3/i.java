package j3;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements j3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f13844a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f13845b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f13846c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f13847d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13849f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f13850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Class f13852c;

        public a(b bVar) {
            this.f13850a = bVar;
        }

        @Override // j3.m
        public void a() {
            this.f13850a.c(this);
        }

        public void b(int i10, Class cls) {
            this.f13851b = i10;
            this.f13852c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f13851b == aVar.f13851b && this.f13852c == aVar.f13852c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i10 = this.f13851b * 31;
            Class cls = this.f13852c;
            return i10 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f13851b + "array=" + this.f13852c + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends c {
        @Override // j3.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a e(int i10, Class cls) {
            a aVar = (a) b();
            aVar.b(i10, cls);
            return aVar;
        }
    }

    public i(int i10) {
        this.f13848e = i10;
    }

    @Override // j3.b
    public synchronized void a(int i10) {
        try {
            if (i10 >= 40) {
                b();
            } else if (i10 >= 20 || i10 == 15) {
                g(this.f13848e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // j3.b
    public synchronized void b() {
        g(0);
    }

    @Override // j3.b
    public synchronized Object c(int i10, Class cls) {
        return k(this.f13845b.e(i10, cls), cls);
    }

    @Override // j3.b
    public synchronized Object d(int i10, Class cls) {
        Integer num;
        try {
            num = (Integer) l(cls).ceilingKey(Integer.valueOf(i10));
        } catch (Throwable th) {
            throw th;
        }
        return k(o(i10, num) ? this.f13845b.e(num.intValue(), cls) : this.f13845b.e(i10, cls), cls);
    }

    public final void e(int i10, Class cls) {
        NavigableMap navigableMapL = l(cls);
        Integer num = (Integer) navigableMapL.get(Integer.valueOf(i10));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapL.remove(Integer.valueOf(i10));
                return;
            } else {
                navigableMapL.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
    }

    public final void f() {
        g(this.f13848e);
    }

    public final void g(int i10) {
        while (this.f13849f > i10) {
            Object objF = this.f13844a.f();
            c4.k.e(objF);
            j3.a aVarH = h(objF);
            this.f13849f -= aVarH.c(objF) * aVarH.b();
            e(aVarH.c(objF), objF.getClass());
            if (Log.isLoggable(aVarH.a(), 2)) {
                Log.v(aVarH.a(), "evicted: " + aVarH.c(objF));
            }
        }
    }

    public final j3.a h(Object obj) {
        return i(obj.getClass());
    }

    public final j3.a i(Class cls) {
        j3.a fVar;
        j3.a aVar = (j3.a) this.f13847d.get(cls);
        if (aVar != null) {
            return aVar;
        }
        if (cls.equals(int[].class)) {
            fVar = new h();
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            fVar = new f();
        }
        this.f13847d.put(cls, fVar);
        return fVar;
    }

    public final Object j(a aVar) {
        return this.f13844a.a(aVar);
    }

    public final Object k(a aVar, Class cls) {
        j3.a aVarI = i(cls);
        Object objJ = j(aVar);
        if (objJ != null) {
            this.f13849f -= aVarI.c(objJ) * aVarI.b();
            e(aVarI.c(objJ), cls);
        }
        if (objJ != null) {
            return objJ;
        }
        if (Log.isLoggable(aVarI.a(), 2)) {
            Log.v(aVarI.a(), "Allocated " + aVar.f13851b + " bytes");
        }
        return aVarI.newArray(aVar.f13851b);
    }

    public final NavigableMap l(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.f13846c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f13846c.put(cls, treeMap);
        return treeMap;
    }

    public final boolean m() {
        int i10 = this.f13849f;
        return i10 == 0 || this.f13848e / i10 >= 2;
    }

    public final boolean n(int i10) {
        return i10 <= this.f13848e / 2;
    }

    public final boolean o(int i10, Integer num) {
        if (num != null) {
            return m() || num.intValue() <= i10 * 8;
        }
        return false;
    }

    @Override // j3.b
    public synchronized void put(Object obj) {
        Class<?> cls = obj.getClass();
        j3.a aVarI = i(cls);
        int iC = aVarI.c(obj);
        int iB = aVarI.b() * iC;
        if (n(iB)) {
            a aVarE = this.f13845b.e(iC, cls);
            this.f13844a.d(aVarE, obj);
            NavigableMap navigableMapL = l(cls);
            Integer num = (Integer) navigableMapL.get(Integer.valueOf(aVarE.f13851b));
            Integer numValueOf = Integer.valueOf(aVarE.f13851b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapL.put(numValueOf, Integer.valueOf(iIntValue));
            this.f13849f += iB;
            f();
        }
    }
}
