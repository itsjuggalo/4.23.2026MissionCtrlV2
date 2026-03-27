package r3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r3.c;
import r3.h;

/* JADX INFO: loaded from: classes.dex */
public class k extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f22472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Comparator f22473b;

    public static k m(List list, Map map, c.a.InterfaceC0344a interfaceC0344a, Comparator comparator) {
        return b.b(list, map, interfaceC0344a, comparator);
    }

    public static k n(Map map, Comparator comparator) {
        return b.b(new ArrayList(map.keySet()), map, c.a.d(), comparator);
    }

    @Override // r3.c
    public boolean a(Object obj) {
        return p(obj) != null;
    }

    @Override // r3.c
    public Object b(Object obj) {
        h hVarP = p(obj);
        if (hVarP != null) {
            return hVarP.getValue();
        }
        return null;
    }

    @Override // r3.c
    public Comparator c() {
        return this.f22473b;
    }

    @Override // r3.c
    public Object g() {
        return this.f22472a.h().getKey();
    }

    @Override // r3.c
    public Object h() {
        return this.f22472a.g().getKey();
    }

    @Override // r3.c
    public int indexOf(Object obj) {
        h hVarA = this.f22472a;
        int size = 0;
        while (!hVarA.isEmpty()) {
            int iCompare = this.f22473b.compare(obj, hVarA.getKey());
            if (iCompare == 0) {
                return size + hVarA.a().size();
            }
            if (iCompare < 0) {
                hVarA = hVarA.a();
            } else {
                size += hVarA.a().size() + 1;
                hVarA = hVarA.f();
            }
        }
        return -1;
    }

    @Override // r3.c
    public boolean isEmpty() {
        return this.f22472a.isEmpty();
    }

    @Override // r3.c, java.lang.Iterable
    public Iterator iterator() {
        return new d(this.f22472a, null, this.f22473b, false);
    }

    @Override // r3.c
    public c j(Object obj, Object obj2) {
        return new k(this.f22472a.b(obj, obj2, this.f22473b).d(null, null, h.a.BLACK, null, null), this.f22473b);
    }

    @Override // r3.c
    public Iterator k(Object obj) {
        return new d(this.f22472a, obj, this.f22473b, false);
    }

    @Override // r3.c
    public c l(Object obj) {
        return !a(obj) ? this : new k(this.f22472a.c(obj, this.f22473b).d(null, null, h.a.BLACK, null, null), this.f22473b);
    }

    public final h p(Object obj) {
        h hVarA = this.f22472a;
        while (!hVarA.isEmpty()) {
            int iCompare = this.f22473b.compare(obj, hVarA.getKey());
            if (iCompare < 0) {
                hVarA = hVarA.a();
            } else {
                if (iCompare == 0) {
                    return hVarA;
                }
                hVarA = hVarA.f();
            }
        }
        return null;
    }

    @Override // r3.c
    public int size() {
        return this.f22472a.size();
    }

    public k(h hVar, Comparator comparator) {
        this.f22472a = hVar;
        this.f22473b = comparator;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f22474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f22475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c.a.InterfaceC0344a f22476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f22477d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public j f22478e;

        /* JADX INFO: renamed from: r3.k$b$b, reason: collision with other inner class name */
        public static class C0346b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f22483a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f22484b;
        }

        public b(List list, Map map, c.a.InterfaceC0344a interfaceC0344a) {
            this.f22474a = list;
            this.f22475b = map;
            this.f22476c = interfaceC0344a;
        }

        public static k b(List list, Map map, c.a.InterfaceC0344a interfaceC0344a, Comparator comparator) {
            b bVar = new b(list, map, interfaceC0344a);
            Collections.sort(list, comparator);
            int size = list.size();
            for (C0346b c0346b : new a(list.size())) {
                int i7 = c0346b.f22484b;
                size -= i7;
                if (c0346b.f22483a) {
                    bVar.c(h.a.BLACK, i7, size);
                } else {
                    bVar.c(h.a.BLACK, i7, size);
                    int i8 = c0346b.f22484b;
                    size -= i8;
                    bVar.c(h.a.RED, i8, size);
                }
            }
            h hVarI = bVar.f22477d;
            if (hVarI == null) {
                hVarI = g.i();
            }
            return new k(hVarI, comparator);
        }

        public final h a(int i7, int i8) {
            if (i8 == 0) {
                return g.i();
            }
            if (i8 == 1) {
                Object obj = this.f22474a.get(i7);
                return new f(obj, d(obj), null, null);
            }
            int i9 = i8 / 2;
            int i10 = i7 + i9;
            h hVarA = a(i7, i9);
            h hVarA2 = a(i10 + 1, i9);
            Object obj2 = this.f22474a.get(i10);
            return new f(obj2, d(obj2), hVarA, hVarA2);
        }

        public final void c(h.a aVar, int i7, int i8) {
            h hVarA = a(i8 + 1, i7 - 1);
            Object obj = this.f22474a.get(i8);
            j iVar = aVar == h.a.RED ? new i(obj, d(obj), null, hVarA) : new f(obj, d(obj), null, hVarA);
            if (this.f22477d == null) {
                this.f22477d = iVar;
                this.f22478e = iVar;
            } else {
                this.f22478e.t(iVar);
                this.f22478e = iVar;
            }
        }

        public final Object d(Object obj) {
            return this.f22475b.get(this.f22476c.a(obj));
        }

        public static class a implements Iterable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f22479a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f22480b;

            public a(int i7) {
                int i8 = i7 + 1;
                int iFloor = (int) Math.floor(Math.log(i8) / Math.log(2.0d));
                this.f22480b = iFloor;
                this.f22479a = (((long) Math.pow(2.0d, iFloor)) - 1) & ((long) i8);
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return new C0345a();
            }

            /* JADX INFO: renamed from: r3.k$b$a$a, reason: collision with other inner class name */
            public class C0345a implements Iterator {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f22481a;

                public C0345a() {
                    this.f22481a = a.this.f22480b - 1;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public C0346b next() {
                    long j7 = a.this.f22479a & ((long) (1 << this.f22481a));
                    C0346b c0346b = new C0346b();
                    c0346b.f22483a = j7 == 0;
                    c0346b.f22484b = (int) Math.pow(2.0d, this.f22481a);
                    this.f22481a--;
                    return c0346b;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f22481a >= 0;
                }

                @Override // java.util.Iterator
                public void remove() {
                }
            }
        }
    }
}
