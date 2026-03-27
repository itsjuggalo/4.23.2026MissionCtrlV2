package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S.d f12389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f12390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f12391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0198a f12392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f12393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f12395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12396h;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0198a {
        void a(int i8, int i9);

        void b(b bVar);

        void c(int i8, int i9, Object obj);

        void d(b bVar);

        RecyclerView.A e(int i8);

        void f(int i8, int i9);

        void g(int i8, int i9);

        void h(int i8, int i9);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f12399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12400d;

        public b(int i8, int i9, int i10, Object obj) {
            this.f12397a = i8;
            this.f12398b = i9;
            this.f12400d = i10;
            this.f12399c = obj;
        }

        public String a() {
            int i8 = this.f12397a;
            return i8 != 1 ? i8 != 2 ? i8 != 4 ? i8 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i8 = this.f12397a;
            if (i8 != bVar.f12397a) {
                return false;
            }
            if (i8 == 8 && Math.abs(this.f12400d - this.f12398b) == 1 && this.f12400d == bVar.f12398b && this.f12398b == bVar.f12400d) {
                return true;
            }
            if (this.f12400d != bVar.f12400d || this.f12398b != bVar.f12398b) {
                return false;
            }
            Object obj2 = this.f12399c;
            Object obj3 = bVar.f12399c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f12397a * 31) + this.f12398b) * 31) + this.f12400d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f12398b + "c:" + this.f12400d + ",p:" + this.f12399c + "]";
        }
    }

    public a(InterfaceC0198a interfaceC0198a) {
        this(interfaceC0198a, false);
    }

    @Override // androidx.recyclerview.widget.g.a
    public void a(b bVar) {
        if (this.f12394f) {
            return;
        }
        bVar.f12399c = null;
        this.f12389a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.g.a
    public b b(int i8, int i9, int i10, Object obj) {
        b bVar = (b) this.f12389a.b();
        if (bVar == null) {
            return new b(i8, i9, i10, obj);
        }
        bVar.f12397a = i8;
        bVar.f12398b = i9;
        bVar.f12400d = i10;
        bVar.f12399c = obj;
        return bVar;
    }

    public final void c(b bVar) {
        p(bVar);
    }

    public final void d(b bVar) {
        p(bVar);
    }

    public final void e(b bVar) {
        boolean z7;
        byte b8;
        int i8 = bVar.f12398b;
        int i9 = bVar.f12400d + i8;
        byte b9 = -1;
        int i10 = i8;
        int i11 = 0;
        while (i10 < i9) {
            this.f12392d.e(i10);
            if (g(i10)) {
                if (b9 == 0) {
                    j(b(2, i8, i11, null));
                    z7 = true;
                } else {
                    z7 = false;
                }
                b8 = 1;
            } else {
                if (b9 == 1) {
                    p(b(2, i8, i11, null));
                    z7 = true;
                } else {
                    z7 = false;
                }
                b8 = 0;
            }
            if (z7) {
                i10 -= i11;
                i9 -= i11;
                i11 = 1;
            } else {
                i11++;
            }
            i10++;
            b9 = b8;
        }
        if (i11 != bVar.f12400d) {
            a(bVar);
            bVar = b(2, i8, i11, null);
        }
        if (b9 == 0) {
            j(bVar);
        } else {
            p(bVar);
        }
    }

    public final void f(b bVar) {
        int i8 = bVar.f12398b;
        int i9 = bVar.f12400d + i8;
        int i10 = 0;
        byte b8 = -1;
        int i11 = i8;
        while (i8 < i9) {
            this.f12392d.e(i8);
            if (g(i8)) {
                if (b8 == 0) {
                    j(b(4, i11, i10, bVar.f12399c));
                    i11 = i8;
                    i10 = 0;
                }
                b8 = 1;
            } else {
                if (b8 == 1) {
                    p(b(4, i11, i10, bVar.f12399c));
                    i11 = i8;
                    i10 = 0;
                }
                b8 = 0;
            }
            i10++;
            i8++;
        }
        if (i10 != bVar.f12400d) {
            Object obj = bVar.f12399c;
            a(bVar);
            bVar = b(4, i11, i10, obj);
        }
        if (b8 == 0) {
            j(bVar);
        } else {
            p(bVar);
        }
    }

    public final boolean g(int i8) {
        int size = this.f12391c.size();
        for (int i9 = 0; i9 < size; i9++) {
            b bVar = (b) this.f12391c.get(i9);
            int i10 = bVar.f12397a;
            if (i10 == 8) {
                if (m(bVar.f12400d, i9 + 1) == i8) {
                    return true;
                }
            } else if (i10 == 1) {
                int i11 = bVar.f12398b;
                int i12 = bVar.f12400d + i11;
                while (i11 < i12) {
                    if (m(i11, i9 + 1) == i8) {
                        return true;
                    }
                    i11++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void h() {
        int size = this.f12391c.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.f12392d.d((b) this.f12391c.get(i8));
        }
        r(this.f12391c);
        this.f12396h = 0;
    }

    public void i() {
        h();
        int size = this.f12390b.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = (b) this.f12390b.get(i8);
            int i9 = bVar.f12397a;
            if (i9 == 1) {
                this.f12392d.d(bVar);
                this.f12392d.g(bVar.f12398b, bVar.f12400d);
            } else if (i9 == 2) {
                this.f12392d.d(bVar);
                this.f12392d.h(bVar.f12398b, bVar.f12400d);
            } else if (i9 == 4) {
                this.f12392d.d(bVar);
                this.f12392d.c(bVar.f12398b, bVar.f12400d, bVar.f12399c);
            } else if (i9 == 8) {
                this.f12392d.d(bVar);
                this.f12392d.a(bVar.f12398b, bVar.f12400d);
            }
            Runnable runnable = this.f12393e;
            if (runnable != null) {
                runnable.run();
            }
        }
        r(this.f12390b);
        this.f12396h = 0;
    }

    public final void j(b bVar) {
        int i8;
        int i9 = bVar.f12397a;
        if (i9 == 1 || i9 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iT = t(bVar.f12398b, i9);
        int i10 = bVar.f12398b;
        int i11 = bVar.f12397a;
        if (i11 == 2) {
            i8 = 0;
        } else {
            if (i11 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i8 = 1;
        }
        int i12 = 1;
        for (int i13 = 1; i13 < bVar.f12400d; i13++) {
            int iT2 = t(bVar.f12398b + (i8 * i13), bVar.f12397a);
            int i14 = bVar.f12397a;
            if (i14 == 2 ? iT2 != iT : !(i14 == 4 && iT2 == iT + 1)) {
                b bVarB = b(i14, iT, i12, bVar.f12399c);
                k(bVarB, i10);
                a(bVarB);
                if (bVar.f12397a == 4) {
                    i10 += i12;
                }
                i12 = 1;
                iT = iT2;
            } else {
                i12++;
            }
        }
        Object obj = bVar.f12399c;
        a(bVar);
        if (i12 > 0) {
            b bVarB2 = b(bVar.f12397a, iT, i12, obj);
            k(bVarB2, i10);
            a(bVarB2);
        }
    }

    public void k(b bVar, int i8) {
        this.f12392d.b(bVar);
        int i9 = bVar.f12397a;
        if (i9 == 2) {
            this.f12392d.h(i8, bVar.f12400d);
        } else {
            if (i9 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f12392d.c(i8, bVar.f12400d, bVar.f12399c);
        }
    }

    public int l(int i8) {
        return m(i8, 0);
    }

    public int m(int i8, int i9) {
        int size = this.f12391c.size();
        while (i9 < size) {
            b bVar = (b) this.f12391c.get(i9);
            int i10 = bVar.f12397a;
            if (i10 == 8) {
                int i11 = bVar.f12398b;
                if (i11 == i8) {
                    i8 = bVar.f12400d;
                } else {
                    if (i11 < i8) {
                        i8--;
                    }
                    if (bVar.f12400d <= i8) {
                        i8++;
                    }
                }
            } else {
                int i12 = bVar.f12398b;
                if (i12 > i8) {
                    continue;
                } else if (i10 == 2) {
                    int i13 = bVar.f12400d;
                    if (i8 < i12 + i13) {
                        return -1;
                    }
                    i8 -= i13;
                } else if (i10 == 1) {
                    i8 += bVar.f12400d;
                }
            }
            i9++;
        }
        return i8;
    }

    public boolean n(int i8) {
        return (i8 & this.f12396h) != 0;
    }

    public boolean o() {
        return this.f12390b.size() > 0;
    }

    public final void p(b bVar) {
        this.f12391c.add(bVar);
        int i8 = bVar.f12397a;
        if (i8 == 1) {
            this.f12392d.g(bVar.f12398b, bVar.f12400d);
            return;
        }
        if (i8 == 2) {
            this.f12392d.f(bVar.f12398b, bVar.f12400d);
            return;
        }
        if (i8 == 4) {
            this.f12392d.c(bVar.f12398b, bVar.f12400d, bVar.f12399c);
        } else {
            if (i8 == 8) {
                this.f12392d.a(bVar.f12398b, bVar.f12400d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void q() {
        this.f12395g.b(this.f12390b);
        int size = this.f12390b.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = (b) this.f12390b.get(i8);
            int i9 = bVar.f12397a;
            if (i9 == 1) {
                c(bVar);
            } else if (i9 == 2) {
                e(bVar);
            } else if (i9 == 4) {
                f(bVar);
            } else if (i9 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f12393e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f12390b.clear();
    }

    public void r(List list) {
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            a((b) list.get(i8));
        }
        list.clear();
    }

    public void s() {
        r(this.f12390b);
        r(this.f12391c);
        this.f12396h = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int t(int r9, int r10) {
        /*
            r8 = this;
            java.util.ArrayList r0 = r8.f12391c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            r2 = 8
            if (r0 < 0) goto L7d
            java.util.ArrayList r3 = r8.f12391c
            java.lang.Object r3 = r3.get(r0)
            androidx.recyclerview.widget.a$b r3 = (androidx.recyclerview.widget.a.b) r3
            int r4 = r3.f12397a
            r5 = 2
            if (r4 != r2) goto L5e
            int r2 = r3.f12398b
            int r4 = r3.f12400d
            if (r2 >= r4) goto L22
            r6 = r2
            r7 = r4
            goto L24
        L22:
            r7 = r2
            r6 = r4
        L24:
            if (r9 < r6) goto L48
            if (r9 > r7) goto L48
            if (r6 != r2) goto L39
            if (r10 != r1) goto L31
            int r4 = r4 + 1
        L2e:
            r3.f12400d = r4
            goto L36
        L31:
            if (r10 != r5) goto L36
            int r4 = r4 + (-1)
            goto L2e
        L36:
            int r9 = r9 + 1
            goto L7a
        L39:
            if (r10 != r1) goto L40
            int r2 = r2 + 1
        L3d:
            r3.f12398b = r2
            goto L45
        L40:
            if (r10 != r5) goto L45
            int r2 = r2 + (-1)
            goto L3d
        L45:
            int r9 = r9 + (-1)
            goto L7a
        L48:
            if (r9 >= r2) goto L7a
            if (r10 != r1) goto L55
            int r2 = r2 + 1
            r3.f12398b = r2
            int r4 = r4 + 1
        L52:
            r3.f12400d = r4
            goto L7a
        L55:
            if (r10 != r5) goto L7a
            int r2 = r2 + (-1)
            r3.f12398b = r2
            int r4 = r4 + (-1)
            goto L52
        L5e:
            int r2 = r3.f12398b
            if (r2 > r9) goto L6e
            if (r4 != r1) goto L68
            int r2 = r3.f12400d
            int r9 = r9 - r2
            goto L7a
        L68:
            if (r4 != r5) goto L7a
            int r2 = r3.f12400d
            int r9 = r9 + r2
            goto L7a
        L6e:
            if (r10 != r1) goto L75
            int r2 = r2 + 1
        L72:
            r3.f12398b = r2
            goto L7a
        L75:
            if (r10 != r5) goto L7a
            int r2 = r2 + (-1)
            goto L72
        L7a:
            int r0 = r0 + (-1)
            goto L8
        L7d:
            java.util.ArrayList r10 = r8.f12391c
            int r10 = r10.size()
            int r10 = r10 - r1
        L84:
            if (r10 < 0) goto Lab
            java.util.ArrayList r0 = r8.f12391c
            java.lang.Object r0 = r0.get(r10)
            androidx.recyclerview.widget.a$b r0 = (androidx.recyclerview.widget.a.b) r0
            int r1 = r0.f12397a
            if (r1 != r2) goto La3
            int r1 = r0.f12400d
            int r3 = r0.f12398b
            if (r1 == r3) goto L9a
            if (r1 >= 0) goto La8
        L9a:
            java.util.ArrayList r1 = r8.f12391c
            r1.remove(r10)
            r8.a(r0)
            goto La8
        La3:
            int r1 = r0.f12400d
            if (r1 > 0) goto La8
            goto L9a
        La8:
            int r10 = r10 + (-1)
            goto L84
        Lab:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.a.t(int, int):int");
    }

    public a(InterfaceC0198a interfaceC0198a, boolean z7) {
        this.f12389a = new S.e(30);
        this.f12390b = new ArrayList();
        this.f12391c = new ArrayList();
        this.f12396h = 0;
        this.f12392d = interfaceC0198a;
        this.f12394f = z7;
        this.f12395g = new g(this);
    }
}
