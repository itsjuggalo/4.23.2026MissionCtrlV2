package g8;

import g8.c;
import g8.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f10125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Comparator f10126b;

    public static k u(List list, Map map, c.a.InterfaceC0183a interfaceC0183a, Comparator comparator) {
        return b.b(list, map, interfaceC0183a, comparator);
    }

    public static k v(Map map, Comparator comparator) {
        return b.b(new ArrayList(map.keySet()), map, c.a.e(), comparator);
    }

    @Override // g8.c
    public Iterator P() {
        return new d(this.f10125a, null, this.f10126b, true);
    }

    @Override // g8.c
    public boolean a(Object obj) {
        return w(obj) != null;
    }

    @Override // g8.c
    public Object c(Object obj) {
        h hVarW = w(obj);
        if (hVarW != null) {
            return hVarW.getValue();
        }
        return null;
    }

    @Override // g8.c
    public Comparator d() {
        return this.f10126b;
    }

    @Override // g8.c
    public Object e() {
        return this.f10125a.i().getKey();
    }

    @Override // g8.c
    public Object f() {
        return this.f10125a.h().getKey();
    }

    @Override // g8.c
    public Object g(Object obj) {
        h hVarA = this.f10125a;
        h hVar = null;
        while (!hVarA.isEmpty()) {
            int iCompare = this.f10126b.compare(obj, hVarA.getKey());
            if (iCompare == 0) {
                if (hVarA.a().isEmpty()) {
                    if (hVar != null) {
                        return hVar.getKey();
                    }
                    return null;
                }
                h hVarA2 = hVarA.a();
                while (!hVarA2.g().isEmpty()) {
                    hVarA2 = hVarA2.g();
                }
                return hVarA2.getKey();
            }
            if (iCompare < 0) {
                hVarA = hVarA.a();
            } else {
                hVar = hVarA;
                hVarA = hVarA.g();
            }
        }
        throw new IllegalArgumentException("Couldn't find predecessor key of non-present key: " + obj);
    }

    @Override // g8.c
    public int indexOf(Object obj) {
        h hVarA = this.f10125a;
        int size = 0;
        while (!hVarA.isEmpty()) {
            int iCompare = this.f10126b.compare(obj, hVarA.getKey());
            if (iCompare == 0) {
                return size + hVarA.a().size();
            }
            if (iCompare < 0) {
                hVarA = hVarA.a();
            } else {
                size += hVarA.a().size() + 1;
                hVarA = hVarA.g();
            }
        }
        return -1;
    }

    @Override // g8.c
    public boolean isEmpty() {
        return this.f10125a.isEmpty();
    }

    @Override // g8.c, java.lang.Iterable
    public Iterator iterator() {
        return new d(this.f10125a, null, this.f10126b, false);
    }

    @Override // g8.c
    public void p(h.b bVar) {
        this.f10125a.e(bVar);
    }

    @Override // g8.c
    public c q(Object obj, Object obj2) {
        return new k(this.f10125a.b(obj, obj2, this.f10126b).c(null, null, h.a.BLACK, null, null), this.f10126b);
    }

    @Override // g8.c
    public Iterator r(Object obj) {
        return new d(this.f10125a, obj, this.f10126b, false);
    }

    @Override // g8.c
    public c s(Object obj) {
        return !a(obj) ? this : new k(this.f10125a.d(obj, this.f10126b).c(null, null, h.a.BLACK, null, null), this.f10126b);
    }

    @Override // g8.c
    public int size() {
        return this.f10125a.size();
    }

    public final h w(Object obj) {
        h hVarA = this.f10125a;
        while (!hVarA.isEmpty()) {
            int iCompare = this.f10126b.compare(obj, hVarA.getKey());
            if (iCompare < 0) {
                hVarA = hVarA.a();
            } else {
                if (iCompare == 0) {
                    return hVarA;
                }
                hVarA = hVarA.g();
            }
        }
        return null;
    }

    public k(h hVar, Comparator comparator) {
        this.f10125a = hVar;
        this.f10126b = comparator;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f10127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f10128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c.a.InterfaceC0183a f10129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f10130d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public j f10131e;

        /* JADX INFO: renamed from: g8.k$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0185b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f10136a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f10137b;
        }

        public b(List list, Map map, c.a.InterfaceC0183a interfaceC0183a) {
            this.f10127a = list;
            this.f10128b = map;
            this.f10129c = interfaceC0183a;
        }

        public static k b(List list, Map map, c.a.InterfaceC0183a interfaceC0183a, Comparator comparator) {
            b bVar = new b(list, map, interfaceC0183a);
            Collections.sort(list, comparator);
            int size = list.size();
            for (C0185b c0185b : new a(list.size())) {
                int i10 = c0185b.f10137b;
                size -= i10;
                if (c0185b.f10136a) {
                    bVar.c(h.a.BLACK, i10, size);
                } else {
                    bVar.c(h.a.BLACK, i10, size);
                    int i11 = c0185b.f10137b;
                    size -= i11;
                    bVar.c(h.a.RED, i11, size);
                }
            }
            h hVarJ = bVar.f10130d;
            if (hVarJ == null) {
                hVarJ = g.j();
            }
            return new k(hVarJ, comparator);
        }

        public final h a(int i10, int i11) {
            if (i11 == 0) {
                return g.j();
            }
            if (i11 == 1) {
                Object obj = this.f10127a.get(i10);
                return new f(obj, d(obj), null, null);
            }
            int i12 = i11 / 2;
            int i13 = i10 + i12;
            h hVarA = a(i10, i12);
            h hVarA2 = a(i13 + 1, i12);
            Object obj2 = this.f10127a.get(i13);
            return new f(obj2, d(obj2), hVarA, hVarA2);
        }

        public final void c(h.a aVar, int i10, int i11) {
            h hVarA = a(i11 + 1, i10 - 1);
            Object obj = this.f10127a.get(i11);
            j iVar = aVar == h.a.RED ? new i(obj, d(obj), null, hVarA) : new f(obj, d(obj), null, hVarA);
            if (this.f10130d == null) {
                this.f10130d = iVar;
                this.f10131e = iVar;
            } else {
                this.f10131e.u(iVar);
                this.f10131e = iVar;
            }
        }

        public final Object d(Object obj) {
            return this.f10128b.get(this.f10129c.a(obj));
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements Iterable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f10132a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f10133b;

            public a(int i10) {
                int i11 = i10 + 1;
                int iFloor = (int) Math.floor(Math.log(i11) / Math.log(2.0d));
                this.f10133b = iFloor;
                this.f10132a = (((long) Math.pow(2.0d, iFloor)) - 1) & ((long) i11);
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return new C0184a();
            }

            /* JADX INFO: renamed from: g8.k$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class C0184a implements Iterator {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f10134a;

                public C0184a() {
                    this.f10134a = a.this.f10133b - 1;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public C0185b next() {
                    long j10 = a.this.f10132a & ((long) (1 << this.f10134a));
                    C0185b c0185b = new C0185b();
                    c0185b.f10136a = j10 == 0;
                    c0185b.f10137b = (int) Math.pow(2.0d, this.f10134a);
                    this.f10134a--;
                    return c0185b;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f10134a >= 0;
                }

                @Override // java.util.Iterator
                public void remove() {
                }
            }
        }
    }
}
