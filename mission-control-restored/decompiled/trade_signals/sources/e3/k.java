package e3;

import e3.AbstractC1666c;
import e3.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k extends AbstractC1666c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f17167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Comparator f17168b;

    public k(h hVar, Comparator comparator) {
        this.f17167a = hVar;
        this.f17168b = comparator;
    }

    public static k I(List list, Map map, AbstractC1666c.a.InterfaceC0293a interfaceC0293a, Comparator comparator) {
        return b.b(list, map, interfaceC0293a, comparator);
    }

    public static k J(Map map, Comparator comparator) {
        return b.b(new ArrayList(map.keySet()), map, AbstractC1666c.a.e(), comparator);
    }

    @Override // e3.AbstractC1666c
    public void C(h.b bVar) {
        this.f17167a.g(bVar);
    }

    @Override // e3.AbstractC1666c
    public Iterator E() {
        return new C1667d(this.f17167a, null, this.f17168b, true);
    }

    @Override // e3.AbstractC1666c
    public AbstractC1666c F(Object obj, Object obj2) {
        return new k(this.f17167a.c(obj, obj2, this.f17168b).a(null, null, h.a.BLACK, null, null), this.f17168b);
    }

    @Override // e3.AbstractC1666c
    public AbstractC1666c H(Object obj) {
        return !a(obj) ? this : new k(this.f17167a.d(obj, this.f17168b).a(null, null, h.a.BLACK, null, null), this.f17168b);
    }

    public final h K(Object obj) {
        h hVarB = this.f17167a;
        while (!hVarB.isEmpty()) {
            int iCompare = this.f17168b.compare(obj, hVarB.getKey());
            if (iCompare < 0) {
                hVarB = hVarB.b();
            } else {
                if (iCompare == 0) {
                    return hVarB;
                }
                hVarB = hVarB.f();
            }
        }
        return null;
    }

    @Override // e3.AbstractC1666c
    public boolean a(Object obj) {
        return K(obj) != null;
    }

    @Override // e3.AbstractC1666c
    public Object d(Object obj) {
        h hVarK = K(obj);
        if (hVarK != null) {
            return hVarK.getValue();
        }
        return null;
    }

    @Override // e3.AbstractC1666c
    public Comparator e() {
        return this.f17168b;
    }

    @Override // e3.AbstractC1666c
    public Object f() {
        return this.f17167a.i().getKey();
    }

    @Override // e3.AbstractC1666c
    public Object h() {
        return this.f17167a.h().getKey();
    }

    @Override // e3.AbstractC1666c
    public boolean isEmpty() {
        return this.f17167a.isEmpty();
    }

    @Override // e3.AbstractC1666c, java.lang.Iterable
    public Iterator iterator() {
        return new C1667d(this.f17167a, null, this.f17168b, false);
    }

    @Override // e3.AbstractC1666c
    public Object n(Object obj) {
        h hVarB = this.f17167a;
        h hVar = null;
        while (!hVarB.isEmpty()) {
            int iCompare = this.f17168b.compare(obj, hVarB.getKey());
            if (iCompare == 0) {
                if (hVarB.b().isEmpty()) {
                    if (hVar != null) {
                        return hVar.getKey();
                    }
                    return null;
                }
                h hVarB2 = hVarB.b();
                while (!hVarB2.f().isEmpty()) {
                    hVarB2 = hVarB2.f();
                }
                return hVarB2.getKey();
            }
            if (iCompare < 0) {
                hVarB = hVarB.b();
            } else {
                hVar = hVarB;
                hVarB = hVarB.f();
            }
        }
        throw new IllegalArgumentException("Couldn't find predecessor key of non-present key: " + obj);
    }

    @Override // e3.AbstractC1666c
    public int size() {
        return this.f17167a.size();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f17169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f17170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AbstractC1666c.a.InterfaceC0293a f17171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f17172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public j f17173e;

        /* JADX INFO: renamed from: e3.k$b$b, reason: collision with other inner class name */
        public static class C0295b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f17178a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f17179b;
        }

        public b(List list, Map map, AbstractC1666c.a.InterfaceC0293a interfaceC0293a) {
            this.f17169a = list;
            this.f17170b = map;
            this.f17171c = interfaceC0293a;
        }

        public static k b(List list, Map map, AbstractC1666c.a.InterfaceC0293a interfaceC0293a, Comparator comparator) {
            b bVar = new b(list, map, interfaceC0293a);
            Collections.sort(list, comparator);
            int size = list.size();
            for (C0295b c0295b : new a(list.size())) {
                int i8 = c0295b.f17179b;
                size -= i8;
                if (c0295b.f17178a) {
                    bVar.c(h.a.BLACK, i8, size);
                } else {
                    bVar.c(h.a.BLACK, i8, size);
                    int i9 = c0295b.f17179b;
                    size -= i9;
                    bVar.c(h.a.RED, i9, size);
                }
            }
            h hVarJ = bVar.f17172d;
            if (hVarJ == null) {
                hVarJ = g.j();
            }
            return new k(hVarJ, comparator);
        }

        public final h a(int i8, int i9) {
            if (i9 == 0) {
                return g.j();
            }
            if (i9 == 1) {
                Object obj = this.f17169a.get(i8);
                return new f(obj, d(obj), null, null);
            }
            int i10 = i9 / 2;
            int i11 = i8 + i10;
            h hVarA = a(i8, i10);
            h hVarA2 = a(i11 + 1, i10);
            Object obj2 = this.f17169a.get(i11);
            return new f(obj2, d(obj2), hVarA, hVarA2);
        }

        public final void c(h.a aVar, int i8, int i9) {
            h hVarA = a(i9 + 1, i8 - 1);
            Object obj = this.f17169a.get(i9);
            j iVar = aVar == h.a.RED ? new i(obj, d(obj), null, hVarA) : new f(obj, d(obj), null, hVarA);
            if (this.f17172d == null) {
                this.f17172d = iVar;
            } else {
                this.f17173e.u(iVar);
            }
            this.f17173e = iVar;
        }

        public final Object d(Object obj) {
            return this.f17170b.get(this.f17171c.a(obj));
        }

        public static class a implements Iterable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f17174a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f17175b;

            public a(int i8) {
                int i9 = i8 + 1;
                int iFloor = (int) Math.floor(Math.log(i9) / Math.log(2.0d));
                this.f17175b = iFloor;
                this.f17174a = (((long) Math.pow(2.0d, iFloor)) - 1) & ((long) i9);
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return new C0294a();
            }

            /* JADX INFO: renamed from: e3.k$b$a$a, reason: collision with other inner class name */
            public class C0294a implements Iterator {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f17176a;

                public C0294a() {
                    this.f17176a = a.this.f17175b - 1;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public C0295b next() {
                    long j8 = a.this.f17174a & ((long) (1 << this.f17176a));
                    C0295b c0295b = new C0295b();
                    c0295b.f17178a = j8 == 0;
                    c0295b.f17179b = (int) Math.pow(2.0d, this.f17176a);
                    this.f17176a--;
                    return c0295b;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f17176a >= 0;
                }

                @Override // java.util.Iterator
                public void remove() {
                }
            }
        }
    }
}
