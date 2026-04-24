package X0;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public final class i implements X0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f9331a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f9332b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f9333c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f9334d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9336f;

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f9337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Class f9339c;

        public a(b bVar) {
            this.f9337a = bVar;
        }

        @Override // X0.m
        public void a() {
            this.f9337a.c(this);
        }

        public void b(int i8, Class cls) {
            this.f9338b = i8;
            this.f9339c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9338b == aVar.f9338b && this.f9339c == aVar.f9339c;
        }

        public int hashCode() {
            int i8 = this.f9338b * 31;
            Class cls = this.f9339c;
            return i8 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f9338b + "array=" + this.f9339c + '}';
        }
    }

    public static final class b extends c {
        @Override // X0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a e(int i8, Class cls) {
            a aVar = (a) b();
            aVar.b(i8, cls);
            return aVar;
        }
    }

    public i(int i8) {
        this.f9335e = i8;
    }

    @Override // X0.b
    public synchronized void a(int i8) {
        try {
            if (i8 >= 40) {
                b();
            } else if (i8 >= 20 || i8 == 15) {
                h(this.f9335e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // X0.b
    public synchronized void b() {
        h(0);
    }

    @Override // X0.b
    public synchronized Object c(int i8, Class cls) {
        return l(this.f9332b.e(i8, cls), cls);
    }

    @Override // X0.b
    public synchronized void d(Object obj) {
        Class<?> cls = obj.getClass();
        X0.a aVarJ = j(cls);
        int iC = aVarJ.c(obj);
        int iB = aVarJ.b() * iC;
        if (o(iB)) {
            a aVarE = this.f9332b.e(iC, cls);
            this.f9331a.d(aVarE, obj);
            NavigableMap navigableMapM = m(cls);
            Integer num = (Integer) navigableMapM.get(Integer.valueOf(aVarE.f9338b));
            Integer numValueOf = Integer.valueOf(aVarE.f9338b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapM.put(numValueOf, Integer.valueOf(iIntValue));
            this.f9336f += iB;
            g();
        }
    }

    @Override // X0.b
    public synchronized Object e(int i8, Class cls) {
        Integer num;
        try {
            num = (Integer) m(cls).ceilingKey(Integer.valueOf(i8));
        } catch (Throwable th) {
            throw th;
        }
        return l(p(i8, num) ? this.f9332b.e(num.intValue(), cls) : this.f9332b.e(i8, cls), cls);
    }

    public final void f(int i8, Class cls) {
        NavigableMap navigableMapM = m(cls);
        Integer num = (Integer) navigableMapM.get(Integer.valueOf(i8));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i8 + ", this: " + this);
        }
        int iIntValue = num.intValue();
        Integer numValueOf = Integer.valueOf(i8);
        if (iIntValue == 1) {
            navigableMapM.remove(numValueOf);
        } else {
            navigableMapM.put(numValueOf, Integer.valueOf(num.intValue() - 1));
        }
    }

    public final void g() {
        h(this.f9335e);
    }

    public final void h(int i8) {
        while (this.f9336f > i8) {
            Object objF = this.f9331a.f();
            AbstractC2628k.d(objF);
            X0.a aVarI = i(objF);
            this.f9336f -= aVarI.c(objF) * aVarI.b();
            f(aVarI.c(objF), objF.getClass());
            if (Log.isLoggable(aVarI.a(), 2)) {
                Log.v(aVarI.a(), "evicted: " + aVarI.c(objF));
            }
        }
    }

    public final X0.a i(Object obj) {
        return j(obj.getClass());
    }

    public final X0.a j(Class cls) {
        X0.a fVar = (X0.a) this.f9334d.get(cls);
        if (fVar == null) {
            if (cls.equals(int[].class)) {
                fVar = new h();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                fVar = new f();
            }
            this.f9334d.put(cls, fVar);
        }
        return fVar;
    }

    public final Object k(a aVar) {
        return this.f9331a.a(aVar);
    }

    public final Object l(a aVar, Class cls) {
        X0.a aVarJ = j(cls);
        Object objK = k(aVar);
        if (objK != null) {
            this.f9336f -= aVarJ.c(objK) * aVarJ.b();
            f(aVarJ.c(objK), cls);
        }
        if (objK != null) {
            return objK;
        }
        if (Log.isLoggable(aVarJ.a(), 2)) {
            Log.v(aVarJ.a(), "Allocated " + aVar.f9338b + " bytes");
        }
        return aVarJ.newArray(aVar.f9338b);
    }

    public final NavigableMap m(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.f9333c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f9333c.put(cls, treeMap);
        return treeMap;
    }

    public final boolean n() {
        int i8 = this.f9336f;
        return i8 == 0 || this.f9335e / i8 >= 2;
    }

    public final boolean o(int i8) {
        return i8 <= this.f9335e / 2;
    }

    public final boolean p(int i8, Integer num) {
        return num != null && (n() || num.intValue() <= i8 * 8);
    }
}
