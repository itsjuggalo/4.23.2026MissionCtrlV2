package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s0.c f2756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f2757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0039a f2759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f2760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f2762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2763h;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0039a {
        void a(int i10, int i11);

        void b(b bVar);

        void c(int i10, int i11, Object obj);

        void d(b bVar);

        RecyclerView.a0 e(int i10);

        void f(int i10, int i11);

        void g(int i10, int i11);

        void h(int i10, int i11);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f2766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2767d;

        public b(int i10, int i11, int i12, Object obj) {
            this.f2764a = i10;
            this.f2765b = i11;
            this.f2767d = i12;
            this.f2766c = obj;
        }

        public String a() {
            int i10 = this.f2764a;
            return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f2764a;
            if (i10 != bVar.f2764a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f2767d - this.f2765b) == 1 && this.f2767d == bVar.f2765b && this.f2765b == bVar.f2767d) {
                return true;
            }
            if (this.f2767d != bVar.f2767d || this.f2765b != bVar.f2765b) {
                return false;
            }
            Object obj2 = this.f2766c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f2766c)) {
                    return false;
                }
            } else if (bVar.f2766c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f2764a * 31) + this.f2765b) * 31) + this.f2767d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f2765b + "c:" + this.f2767d + ",p:" + this.f2766c + "]";
        }
    }

    public a(InterfaceC0039a interfaceC0039a) {
        this(interfaceC0039a, false);
    }

    @Override // androidx.recyclerview.widget.g.a
    public void a(b bVar) {
        if (this.f2761f) {
            return;
        }
        bVar.f2766c = null;
        this.f2756a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.g.a
    public b b(int i10, int i11, int i12, Object obj) {
        b bVar = (b) this.f2756a.b();
        if (bVar == null) {
            return new b(i10, i11, i12, obj);
        }
        bVar.f2764a = i10;
        bVar.f2765b = i11;
        bVar.f2767d = i12;
        bVar.f2766c = obj;
        return bVar;
    }

    public final void c(b bVar) {
        p(bVar);
    }

    public final void d(b bVar) {
        p(bVar);
    }

    public final void e(b bVar) {
        boolean z10;
        byte b10;
        int i10 = bVar.f2765b;
        int i11 = bVar.f2767d + i10;
        byte b11 = -1;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            this.f2759d.e(i12);
            if (g(i12)) {
                if (b11 == 0) {
                    j(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                b10 = 1;
            } else {
                if (b11 == 1) {
                    p(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                b10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            b11 = b10;
        }
        if (i13 != bVar.f2767d) {
            a(bVar);
            bVar = b(2, i10, i13, null);
        }
        if (b11 == 0) {
            j(bVar);
        } else {
            p(bVar);
        }
    }

    public final void f(b bVar) {
        int i10 = bVar.f2765b;
        int i11 = bVar.f2767d + i10;
        int i12 = 0;
        byte b10 = -1;
        int i13 = i10;
        while (i10 < i11) {
            this.f2759d.e(i10);
            if (g(i10)) {
                if (b10 == 0) {
                    j(b(4, i13, i12, bVar.f2766c));
                    i13 = i10;
                    i12 = 0;
                }
                b10 = 1;
            } else {
                if (b10 == 1) {
                    p(b(4, i13, i12, bVar.f2766c));
                    i13 = i10;
                    i12 = 0;
                }
                b10 = 0;
            }
            i12++;
            i10++;
        }
        if (i12 != bVar.f2767d) {
            Object obj = bVar.f2766c;
            a(bVar);
            bVar = b(4, i13, i12, obj);
        }
        if (b10 == 0) {
            j(bVar);
        } else {
            p(bVar);
        }
    }

    public final boolean g(int i10) {
        int size = this.f2758c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f2758c.get(i11);
            int i12 = bVar.f2764a;
            if (i12 == 8) {
                if (m(bVar.f2767d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f2765b;
                int i14 = bVar.f2767d + i13;
                while (i13 < i14) {
                    if (m(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void h() {
        int size = this.f2758c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f2759d.d((b) this.f2758c.get(i10));
        }
        r(this.f2758c);
        this.f2763h = 0;
    }

    public void i() {
        h();
        int size = this.f2757b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f2757b.get(i10);
            int i11 = bVar.f2764a;
            if (i11 == 1) {
                this.f2759d.d(bVar);
                this.f2759d.g(bVar.f2765b, bVar.f2767d);
            } else if (i11 == 2) {
                this.f2759d.d(bVar);
                this.f2759d.h(bVar.f2765b, bVar.f2767d);
            } else if (i11 == 4) {
                this.f2759d.d(bVar);
                this.f2759d.c(bVar.f2765b, bVar.f2767d, bVar.f2766c);
            } else if (i11 == 8) {
                this.f2759d.d(bVar);
                this.f2759d.a(bVar.f2765b, bVar.f2767d);
            }
            Runnable runnable = this.f2760e;
            if (runnable != null) {
                runnable.run();
            }
        }
        r(this.f2757b);
        this.f2763h = 0;
    }

    public final void j(b bVar) {
        int i10;
        int i11 = bVar.f2764a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iT = t(bVar.f2765b, i11);
        int i12 = bVar.f2765b;
        int i13 = bVar.f2764a;
        if (i13 == 2) {
            i10 = 0;
        } else {
            if (i13 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i10 = 1;
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f2767d; i15++) {
            int iT2 = t(bVar.f2765b + (i10 * i15), bVar.f2764a);
            int i16 = bVar.f2764a;
            if (i16 == 2 ? iT2 != iT : !(i16 == 4 && iT2 == iT + 1)) {
                b bVarB = b(i16, iT, i14, bVar.f2766c);
                k(bVarB, i12);
                a(bVarB);
                if (bVar.f2764a == 4) {
                    i12 += i14;
                }
                i14 = 1;
                iT = iT2;
            } else {
                i14++;
            }
        }
        Object obj = bVar.f2766c;
        a(bVar);
        if (i14 > 0) {
            b bVarB2 = b(bVar.f2764a, iT, i14, obj);
            k(bVarB2, i12);
            a(bVarB2);
        }
    }

    public void k(b bVar, int i10) {
        this.f2759d.b(bVar);
        int i11 = bVar.f2764a;
        if (i11 == 2) {
            this.f2759d.h(i10, bVar.f2767d);
        } else {
            if (i11 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f2759d.c(i10, bVar.f2767d, bVar.f2766c);
        }
    }

    public int l(int i10) {
        return m(i10, 0);
    }

    public int m(int i10, int i11) {
        int size = this.f2758c.size();
        while (i11 < size) {
            b bVar = (b) this.f2758c.get(i11);
            int i12 = bVar.f2764a;
            if (i12 == 8) {
                int i13 = bVar.f2765b;
                if (i13 == i10) {
                    i10 = bVar.f2767d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f2767d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f2765b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f2767d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f2767d;
                }
            }
            i11++;
        }
        return i10;
    }

    public boolean n(int i10) {
        return (i10 & this.f2763h) != 0;
    }

    public boolean o() {
        return this.f2757b.size() > 0;
    }

    public final void p(b bVar) {
        this.f2758c.add(bVar);
        int i10 = bVar.f2764a;
        if (i10 == 1) {
            this.f2759d.g(bVar.f2765b, bVar.f2767d);
            return;
        }
        if (i10 == 2) {
            this.f2759d.f(bVar.f2765b, bVar.f2767d);
            return;
        }
        if (i10 == 4) {
            this.f2759d.c(bVar.f2765b, bVar.f2767d, bVar.f2766c);
        } else {
            if (i10 == 8) {
                this.f2759d.a(bVar.f2765b, bVar.f2767d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void q() {
        this.f2762g.b(this.f2757b);
        int size = this.f2757b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f2757b.get(i10);
            int i11 = bVar.f2764a;
            if (i11 == 1) {
                c(bVar);
            } else if (i11 == 2) {
                e(bVar);
            } else if (i11 == 4) {
                f(bVar);
            } else if (i11 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f2760e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f2757b.clear();
    }

    public void r(List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a((b) list.get(i10));
        }
        list.clear();
    }

    public void s() {
        r(this.f2757b);
        r(this.f2758c);
        this.f2763h = 0;
    }

    public final int t(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f2758c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f2758c.get(size);
            int i14 = bVar.f2764a;
            if (i14 == 8) {
                int i15 = bVar.f2765b;
                int i16 = bVar.f2767d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            bVar.f2765b = i15 + 1;
                            bVar.f2767d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f2765b = i15 - 1;
                            bVar.f2767d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f2767d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f2767d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f2765b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f2765b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f2765b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f2767d;
                    } else if (i14 == 2) {
                        i10 += bVar.f2767d;
                    }
                } else if (i11 == 1) {
                    bVar.f2765b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f2765b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f2758c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f2758c.get(size2);
            if (bVar2.f2764a == 8) {
                int i18 = bVar2.f2767d;
                if (i18 == bVar2.f2765b || i18 < 0) {
                    this.f2758c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f2767d <= 0) {
                this.f2758c.remove(size2);
                a(bVar2);
            }
        }
        return i10;
    }

    public a(InterfaceC0039a interfaceC0039a, boolean z10) {
        this.f2756a = new s0.d(30);
        this.f2757b = new ArrayList();
        this.f2758c = new ArrayList();
        this.f2763h = 0;
        this.f2759d = interfaceC0039a;
        this.f2761f = z10;
        this.f2762g = new g(this);
    }
}
