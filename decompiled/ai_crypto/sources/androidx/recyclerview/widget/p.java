package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import u.C2739d;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u.g f8435a = new u.g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2739d f8436b = new C2739d();

    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static P.c f8437d = new P.d(20);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.l.b f8439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public RecyclerView.l.b f8440c;

        public static void a() {
            while (f8437d.b() != null) {
            }
        }

        public static a b() {
            a aVar = (a) f8437d.b();
            return aVar == null ? new a() : aVar;
        }

        public static void c(a aVar) {
            aVar.f8438a = 0;
            aVar.f8439b = null;
            aVar.f8440c = null;
            f8437d.a(aVar);
        }
    }

    public interface b {
        void a(RecyclerView.C c7);

        void b(RecyclerView.C c7, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void c(RecyclerView.C c7, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void d(RecyclerView.C c7, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);
    }

    public void a(RecyclerView.C c7, RecyclerView.l.b bVar) {
        a aVarB = (a) this.f8435a.get(c7);
        if (aVarB == null) {
            aVarB = a.b();
            this.f8435a.put(c7, aVarB);
        }
        aVarB.f8438a |= 2;
        aVarB.f8439b = bVar;
    }

    public void b(RecyclerView.C c7) {
        a aVarB = (a) this.f8435a.get(c7);
        if (aVarB == null) {
            aVarB = a.b();
            this.f8435a.put(c7, aVarB);
        }
        aVarB.f8438a |= 1;
    }

    public void c(long j7, RecyclerView.C c7) {
        this.f8436b.i(j7, c7);
    }

    public void d(RecyclerView.C c7, RecyclerView.l.b bVar) {
        a aVarB = (a) this.f8435a.get(c7);
        if (aVarB == null) {
            aVarB = a.b();
            this.f8435a.put(c7, aVarB);
        }
        aVarB.f8440c = bVar;
        aVarB.f8438a |= 8;
    }

    public void e(RecyclerView.C c7, RecyclerView.l.b bVar) {
        a aVarB = (a) this.f8435a.get(c7);
        if (aVarB == null) {
            aVarB = a.b();
            this.f8435a.put(c7, aVarB);
        }
        aVarB.f8439b = bVar;
        aVarB.f8438a |= 4;
    }

    public void f() {
        this.f8435a.clear();
        this.f8436b.a();
    }

    public RecyclerView.C g(long j7) {
        return (RecyclerView.C) this.f8436b.d(j7);
    }

    public boolean h(RecyclerView.C c7) {
        a aVar = (a) this.f8435a.get(c7);
        return (aVar == null || (aVar.f8438a & 1) == 0) ? false : true;
    }

    public boolean i(RecyclerView.C c7) {
        a aVar = (a) this.f8435a.get(c7);
        return (aVar == null || (aVar.f8438a & 4) == 0) ? false : true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.C c7) {
        p(c7);
    }

    public final RecyclerView.l.b l(RecyclerView.C c7, int i7) {
        a aVar;
        RecyclerView.l.b bVar;
        int iG = this.f8435a.g(c7);
        if (iG >= 0 && (aVar = (a) this.f8435a.n(iG)) != null) {
            int i8 = aVar.f8438a;
            if ((i8 & i7) != 0) {
                int i9 = (~i7) & i8;
                aVar.f8438a = i9;
                if (i7 == 4) {
                    bVar = aVar.f8439b;
                } else {
                    if (i7 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    bVar = aVar.f8440c;
                }
                if ((i9 & 12) == 0) {
                    this.f8435a.l(iG);
                    a.c(aVar);
                }
                return bVar;
            }
        }
        return null;
    }

    public RecyclerView.l.b m(RecyclerView.C c7) {
        return l(c7, 8);
    }

    public RecyclerView.l.b n(RecyclerView.C c7) {
        return l(c7, 4);
    }

    public void o(b bVar) {
        for (int size = this.f8435a.size() - 1; size >= 0; size--) {
            RecyclerView.C c7 = (RecyclerView.C) this.f8435a.j(size);
            a aVar = (a) this.f8435a.l(size);
            int i7 = aVar.f8438a;
            if ((i7 & 3) == 3) {
                bVar.a(c7);
            } else if ((i7 & 1) != 0) {
                RecyclerView.l.b bVar2 = aVar.f8439b;
                if (bVar2 == null) {
                    bVar.a(c7);
                } else {
                    bVar.c(c7, bVar2, aVar.f8440c);
                }
            } else if ((i7 & 14) == 14) {
                bVar.b(c7, aVar.f8439b, aVar.f8440c);
            } else if ((i7 & 12) == 12) {
                bVar.d(c7, aVar.f8439b, aVar.f8440c);
            } else if ((i7 & 4) != 0) {
                bVar.c(c7, aVar.f8439b, null);
            } else if ((i7 & 8) != 0) {
                bVar.b(c7, aVar.f8439b, aVar.f8440c);
            }
            a.c(aVar);
        }
    }

    public void p(RecyclerView.C c7) {
        a aVar = (a) this.f8435a.get(c7);
        if (aVar == null) {
            return;
        }
        aVar.f8438a &= -2;
    }

    public void q(RecyclerView.C c7) {
        int iL = this.f8436b.l() - 1;
        while (true) {
            if (iL < 0) {
                break;
            }
            if (c7 == this.f8436b.m(iL)) {
                this.f8436b.k(iL);
                break;
            }
            iL--;
        }
        a aVar = (a) this.f8435a.remove(c7);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
