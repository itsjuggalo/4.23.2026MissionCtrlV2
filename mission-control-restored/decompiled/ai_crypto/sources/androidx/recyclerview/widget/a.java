package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public P.c f8275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f8276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f8277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0137a f8278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f8279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f8281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8282h;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0137a {
        void a(int i7, int i8);

        void b(b bVar);

        void c(int i7, int i8, Object obj);

        void d(b bVar);

        RecyclerView.C e(int i7);

        void f(int i7, int i8);

        void g(int i7, int i8);

        void h(int i7, int i8);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f8285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8286d;

        public b(int i7, int i8, int i9, Object obj) {
            this.f8283a = i7;
            this.f8284b = i8;
            this.f8286d = i9;
            this.f8285c = obj;
        }

        public String a() {
            int i7 = this.f8283a;
            return i7 != 1 ? i7 != 2 ? i7 != 4 ? i7 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i7 = this.f8283a;
            if (i7 != bVar.f8283a) {
                return false;
            }
            if (i7 == 8 && Math.abs(this.f8286d - this.f8284b) == 1 && this.f8286d == bVar.f8284b && this.f8284b == bVar.f8286d) {
                return true;
            }
            if (this.f8286d != bVar.f8286d || this.f8284b != bVar.f8284b) {
                return false;
            }
            Object obj2 = this.f8285c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f8285c)) {
                    return false;
                }
            } else if (bVar.f8285c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f8283a * 31) + this.f8284b) * 31) + this.f8286d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f8284b + "c:" + this.f8286d + ",p:" + this.f8285c + "]";
        }
    }

    public a(InterfaceC0137a interfaceC0137a) {
        this(interfaceC0137a, false);
    }

    @Override // androidx.recyclerview.widget.h.a
    public void a(b bVar) {
        if (this.f8280f) {
            return;
        }
        bVar.f8285c = null;
        this.f8275a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.h.a
    public b b(int i7, int i8, int i9, Object obj) {
        b bVar = (b) this.f8275a.b();
        if (bVar == null) {
            return new b(i7, i8, i9, obj);
        }
        bVar.f8283a = i7;
        bVar.f8284b = i8;
        bVar.f8286d = i9;
        bVar.f8285c = obj;
        return bVar;
    }

    public final void c(b bVar) {
        r(bVar);
    }

    public final void d(b bVar) {
        r(bVar);
    }

    public int e(int i7) {
        int size = this.f8276b.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = (b) this.f8276b.get(i8);
            int i9 = bVar.f8283a;
            if (i9 != 1) {
                if (i9 == 2) {
                    int i10 = bVar.f8284b;
                    if (i10 <= i7) {
                        int i11 = bVar.f8286d;
                        if (i10 + i11 > i7) {
                            return -1;
                        }
                        i7 -= i11;
                    } else {
                        continue;
                    }
                } else if (i9 == 8) {
                    int i12 = bVar.f8284b;
                    if (i12 == i7) {
                        i7 = bVar.f8286d;
                    } else {
                        if (i12 < i7) {
                            i7--;
                        }
                        if (bVar.f8286d <= i7) {
                            i7++;
                        }
                    }
                }
            } else if (bVar.f8284b <= i7) {
                i7 += bVar.f8286d;
            }
        }
        return i7;
    }

    public final void f(b bVar) {
        boolean z7;
        byte b7;
        int i7 = bVar.f8284b;
        int i8 = bVar.f8286d + i7;
        byte b8 = -1;
        int i9 = i7;
        int i10 = 0;
        while (i9 < i8) {
            if (this.f8278d.e(i9) != null || h(i9)) {
                if (b8 == 0) {
                    k(b(2, i7, i10, null));
                    z7 = true;
                } else {
                    z7 = false;
                }
                b7 = 1;
            } else {
                if (b8 == 1) {
                    r(b(2, i7, i10, null));
                    z7 = true;
                } else {
                    z7 = false;
                }
                b7 = 0;
            }
            if (z7) {
                i9 -= i10;
                i8 -= i10;
                i10 = 1;
            } else {
                i10++;
            }
            i9++;
            b8 = b7;
        }
        if (i10 != bVar.f8286d) {
            a(bVar);
            bVar = b(2, i7, i10, null);
        }
        if (b8 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    public final void g(b bVar) {
        int i7 = bVar.f8284b;
        int i8 = bVar.f8286d + i7;
        int i9 = 0;
        byte b7 = -1;
        int i10 = i7;
        while (i7 < i8) {
            if (this.f8278d.e(i7) != null || h(i7)) {
                if (b7 == 0) {
                    k(b(4, i10, i9, bVar.f8285c));
                    i10 = i7;
                    i9 = 0;
                }
                b7 = 1;
            } else {
                if (b7 == 1) {
                    r(b(4, i10, i9, bVar.f8285c));
                    i10 = i7;
                    i9 = 0;
                }
                b7 = 0;
            }
            i9++;
            i7++;
        }
        if (i9 != bVar.f8286d) {
            Object obj = bVar.f8285c;
            a(bVar);
            bVar = b(4, i10, i9, obj);
        }
        if (b7 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    public final boolean h(int i7) {
        int size = this.f8277c.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = (b) this.f8277c.get(i8);
            int i9 = bVar.f8283a;
            if (i9 == 8) {
                if (n(bVar.f8286d, i8 + 1) == i7) {
                    return true;
                }
            } else if (i9 == 1) {
                int i10 = bVar.f8284b;
                int i11 = bVar.f8286d + i10;
                while (i10 < i11) {
                    if (n(i10, i8 + 1) == i7) {
                        return true;
                    }
                    i10++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void i() {
        int size = this.f8277c.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f8278d.d((b) this.f8277c.get(i7));
        }
        t(this.f8277c);
        this.f8282h = 0;
    }

    public void j() {
        i();
        int size = this.f8276b.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = (b) this.f8276b.get(i7);
            int i8 = bVar.f8283a;
            if (i8 == 1) {
                this.f8278d.d(bVar);
                this.f8278d.g(bVar.f8284b, bVar.f8286d);
            } else if (i8 == 2) {
                this.f8278d.d(bVar);
                this.f8278d.h(bVar.f8284b, bVar.f8286d);
            } else if (i8 == 4) {
                this.f8278d.d(bVar);
                this.f8278d.c(bVar.f8284b, bVar.f8286d, bVar.f8285c);
            } else if (i8 == 8) {
                this.f8278d.d(bVar);
                this.f8278d.a(bVar.f8284b, bVar.f8286d);
            }
            Runnable runnable = this.f8279e;
            if (runnable != null) {
                runnable.run();
            }
        }
        t(this.f8276b);
        this.f8282h = 0;
    }

    public final void k(b bVar) {
        int i7;
        int i8 = bVar.f8283a;
        if (i8 == 1 || i8 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iV = v(bVar.f8284b, i8);
        int i9 = bVar.f8284b;
        int i10 = bVar.f8283a;
        if (i10 == 2) {
            i7 = 0;
        } else {
            if (i10 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i7 = 1;
        }
        int i11 = 1;
        for (int i12 = 1; i12 < bVar.f8286d; i12++) {
            int iV2 = v(bVar.f8284b + (i7 * i12), bVar.f8283a);
            int i13 = bVar.f8283a;
            if (i13 == 2 ? iV2 != iV : !(i13 == 4 && iV2 == iV + 1)) {
                b bVarB = b(i13, iV, i11, bVar.f8285c);
                l(bVarB, i9);
                a(bVarB);
                if (bVar.f8283a == 4) {
                    i9 += i11;
                }
                i11 = 1;
                iV = iV2;
            } else {
                i11++;
            }
        }
        Object obj = bVar.f8285c;
        a(bVar);
        if (i11 > 0) {
            b bVarB2 = b(bVar.f8283a, iV, i11, obj);
            l(bVarB2, i9);
            a(bVarB2);
        }
    }

    public void l(b bVar, int i7) {
        this.f8278d.b(bVar);
        int i8 = bVar.f8283a;
        if (i8 == 2) {
            this.f8278d.h(i7, bVar.f8286d);
        } else {
            if (i8 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f8278d.c(i7, bVar.f8286d, bVar.f8285c);
        }
    }

    public int m(int i7) {
        return n(i7, 0);
    }

    public int n(int i7, int i8) {
        int size = this.f8277c.size();
        while (i8 < size) {
            b bVar = (b) this.f8277c.get(i8);
            int i9 = bVar.f8283a;
            if (i9 == 8) {
                int i10 = bVar.f8284b;
                if (i10 == i7) {
                    i7 = bVar.f8286d;
                } else {
                    if (i10 < i7) {
                        i7--;
                    }
                    if (bVar.f8286d <= i7) {
                        i7++;
                    }
                }
            } else {
                int i11 = bVar.f8284b;
                if (i11 > i7) {
                    continue;
                } else if (i9 == 2) {
                    int i12 = bVar.f8286d;
                    if (i7 < i11 + i12) {
                        return -1;
                    }
                    i7 -= i12;
                } else if (i9 == 1) {
                    i7 += bVar.f8286d;
                }
            }
            i8++;
        }
        return i7;
    }

    public boolean o(int i7) {
        return (i7 & this.f8282h) != 0;
    }

    public boolean p() {
        return this.f8276b.size() > 0;
    }

    public boolean q() {
        return (this.f8277c.isEmpty() || this.f8276b.isEmpty()) ? false : true;
    }

    public final void r(b bVar) {
        this.f8277c.add(bVar);
        int i7 = bVar.f8283a;
        if (i7 == 1) {
            this.f8278d.g(bVar.f8284b, bVar.f8286d);
            return;
        }
        if (i7 == 2) {
            this.f8278d.f(bVar.f8284b, bVar.f8286d);
            return;
        }
        if (i7 == 4) {
            this.f8278d.c(bVar.f8284b, bVar.f8286d, bVar.f8285c);
        } else {
            if (i7 == 8) {
                this.f8278d.a(bVar.f8284b, bVar.f8286d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void s() {
        this.f8281g.b(this.f8276b);
        int size = this.f8276b.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = (b) this.f8276b.get(i7);
            int i8 = bVar.f8283a;
            if (i8 == 1) {
                c(bVar);
            } else if (i8 == 2) {
                f(bVar);
            } else if (i8 == 4) {
                g(bVar);
            } else if (i8 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f8279e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f8276b.clear();
    }

    public void t(List list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            a((b) list.get(i7));
        }
        list.clear();
    }

    public void u() {
        t(this.f8276b);
        t(this.f8277c);
        this.f8282h = 0;
    }

    public final int v(int i7, int i8) {
        int i9;
        int i10;
        for (int size = this.f8277c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f8277c.get(size);
            int i11 = bVar.f8283a;
            if (i11 == 8) {
                int i12 = bVar.f8284b;
                int i13 = bVar.f8286d;
                if (i12 < i13) {
                    i10 = i12;
                    i9 = i13;
                } else {
                    i9 = i12;
                    i10 = i13;
                }
                if (i7 < i10 || i7 > i9) {
                    if (i7 < i12) {
                        if (i8 == 1) {
                            bVar.f8284b = i12 + 1;
                            bVar.f8286d = i13 + 1;
                        } else if (i8 == 2) {
                            bVar.f8284b = i12 - 1;
                            bVar.f8286d = i13 - 1;
                        }
                    }
                } else if (i10 == i12) {
                    if (i8 == 1) {
                        bVar.f8286d = i13 + 1;
                    } else if (i8 == 2) {
                        bVar.f8286d = i13 - 1;
                    }
                    i7++;
                } else {
                    if (i8 == 1) {
                        bVar.f8284b = i12 + 1;
                    } else if (i8 == 2) {
                        bVar.f8284b = i12 - 1;
                    }
                    i7--;
                }
            } else {
                int i14 = bVar.f8284b;
                if (i14 <= i7) {
                    if (i11 == 1) {
                        i7 -= bVar.f8286d;
                    } else if (i11 == 2) {
                        i7 += bVar.f8286d;
                    }
                } else if (i8 == 1) {
                    bVar.f8284b = i14 + 1;
                } else if (i8 == 2) {
                    bVar.f8284b = i14 - 1;
                }
            }
        }
        for (int size2 = this.f8277c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f8277c.get(size2);
            if (bVar2.f8283a == 8) {
                int i15 = bVar2.f8286d;
                if (i15 == bVar2.f8284b || i15 < 0) {
                    this.f8277c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f8286d <= 0) {
                this.f8277c.remove(size2);
                a(bVar2);
            }
        }
        return i7;
    }

    public a(InterfaceC0137a interfaceC0137a, boolean z7) {
        this.f8275a = new P.d(30);
        this.f8276b = new ArrayList();
        this.f8277c = new ArrayList();
        this.f8282h = 0;
        this.f8278d = interfaceC0137a;
        this.f8280f = z7;
        this.f8281g = new h(this);
    }
}
