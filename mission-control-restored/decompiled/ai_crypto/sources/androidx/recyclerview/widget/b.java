package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0138b f8287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f8288b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f8289c = new ArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8290a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f8291b;

        public void a(int i7) {
            if (i7 < 64) {
                this.f8290a &= ~(1 << i7);
                return;
            }
            a aVar = this.f8291b;
            if (aVar != null) {
                aVar.a(i7 - 64);
            }
        }

        public int b(int i7) {
            a aVar = this.f8291b;
            return aVar == null ? i7 >= 64 ? Long.bitCount(this.f8290a) : Long.bitCount(this.f8290a & ((1 << i7) - 1)) : i7 < 64 ? Long.bitCount(this.f8290a & ((1 << i7) - 1)) : aVar.b(i7 - 64) + Long.bitCount(this.f8290a);
        }

        public final void c() {
            if (this.f8291b == null) {
                this.f8291b = new a();
            }
        }

        public boolean d(int i7) {
            if (i7 < 64) {
                return (this.f8290a & (1 << i7)) != 0;
            }
            c();
            return this.f8291b.d(i7 - 64);
        }

        public void e(int i7, boolean z7) {
            if (i7 >= 64) {
                c();
                this.f8291b.e(i7 - 64, z7);
                return;
            }
            long j7 = this.f8290a;
            boolean z8 = (Long.MIN_VALUE & j7) != 0;
            long j8 = (1 << i7) - 1;
            this.f8290a = ((j7 & (~j8)) << 1) | (j7 & j8);
            if (z7) {
                h(i7);
            } else {
                a(i7);
            }
            if (z8 || this.f8291b != null) {
                c();
                this.f8291b.e(0, z8);
            }
        }

        public boolean f(int i7) {
            if (i7 >= 64) {
                c();
                return this.f8291b.f(i7 - 64);
            }
            long j7 = 1 << i7;
            long j8 = this.f8290a;
            boolean z7 = (j8 & j7) != 0;
            long j9 = j8 & (~j7);
            this.f8290a = j9;
            long j10 = j7 - 1;
            this.f8290a = (j9 & j10) | Long.rotateRight((~j10) & j9, 1);
            a aVar = this.f8291b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f8291b.f(0);
            }
            return z7;
        }

        public void g() {
            this.f8290a = 0L;
            a aVar = this.f8291b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i7) {
            if (i7 < 64) {
                this.f8290a |= 1 << i7;
            } else {
                c();
                this.f8291b.h(i7 - 64);
            }
        }

        public String toString() {
            if (this.f8291b == null) {
                return Long.toBinaryString(this.f8290a);
            }
            return this.f8291b.toString() + "xx" + Long.toBinaryString(this.f8290a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    public interface InterfaceC0138b {
        View a(int i7);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.C f(View view);

        void g(int i7);

        void h(View view);

        void i(View view, int i7);

        void j(int i7);

        void k(View view, int i7, ViewGroup.LayoutParams layoutParams);
    }

    public b(InterfaceC0138b interfaceC0138b) {
        this.f8287a = interfaceC0138b;
    }

    public void a(View view, int i7, boolean z7) {
        int iC = i7 < 0 ? this.f8287a.c() : h(i7);
        this.f8288b.e(iC, z7);
        if (z7) {
            l(view);
        }
        this.f8287a.i(view, iC);
    }

    public void b(View view, boolean z7) {
        a(view, -1, z7);
    }

    public void c(View view, int i7, ViewGroup.LayoutParams layoutParams, boolean z7) {
        int iC = i7 < 0 ? this.f8287a.c() : h(i7);
        this.f8288b.e(iC, z7);
        if (z7) {
            l(view);
        }
        this.f8287a.k(view, iC, layoutParams);
    }

    public void d(int i7) {
        int iH = h(i7);
        this.f8288b.f(iH);
        this.f8287a.g(iH);
    }

    public View e(int i7) {
        int size = this.f8289c.size();
        for (int i8 = 0; i8 < size; i8++) {
            View view = (View) this.f8289c.get(i8);
            RecyclerView.C cF = this.f8287a.f(view);
            if (cF.m() == i7 && !cF.t() && !cF.v()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i7) {
        return this.f8287a.a(h(i7));
    }

    public int g() {
        return this.f8287a.c() - this.f8289c.size();
    }

    public final int h(int i7) {
        if (i7 < 0) {
            return -1;
        }
        int iC = this.f8287a.c();
        int i8 = i7;
        while (i8 < iC) {
            int iB = i7 - (i8 - this.f8288b.b(i8));
            if (iB == 0) {
                while (this.f8288b.d(i8)) {
                    i8++;
                }
                return i8;
            }
            i8 += iB;
        }
        return -1;
    }

    public View i(int i7) {
        return this.f8287a.a(i7);
    }

    public int j() {
        return this.f8287a.c();
    }

    public void k(View view) {
        int iE = this.f8287a.e(view);
        if (iE >= 0) {
            this.f8288b.h(iE);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void l(View view) {
        this.f8289c.add(view);
        this.f8287a.b(view);
    }

    public int m(View view) {
        int iE = this.f8287a.e(view);
        if (iE == -1 || this.f8288b.d(iE)) {
            return -1;
        }
        return iE - this.f8288b.b(iE);
    }

    public boolean n(View view) {
        return this.f8289c.contains(view);
    }

    public void o() {
        this.f8288b.g();
        for (int size = this.f8289c.size() - 1; size >= 0; size--) {
            this.f8287a.h((View) this.f8289c.get(size));
            this.f8289c.remove(size);
        }
        this.f8287a.d();
    }

    public void p(View view) {
        int iE = this.f8287a.e(view);
        if (iE < 0) {
            return;
        }
        if (this.f8288b.f(iE)) {
            t(view);
        }
        this.f8287a.j(iE);
    }

    public void q(int i7) {
        int iH = h(i7);
        View viewA = this.f8287a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f8288b.f(iH)) {
            t(viewA);
        }
        this.f8287a.j(iH);
    }

    public boolean r(View view) {
        int iE = this.f8287a.e(view);
        if (iE == -1) {
            t(view);
            return true;
        }
        if (!this.f8288b.d(iE)) {
            return false;
        }
        this.f8288b.f(iE);
        t(view);
        this.f8287a.j(iE);
        return true;
    }

    public void s(View view) {
        int iE = this.f8287a.e(view);
        if (iE < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f8288b.d(iE)) {
            this.f8288b.a(iE);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean t(View view) {
        if (!this.f8289c.remove(view)) {
            return false;
        }
        this.f8287a.h(view);
        return true;
    }

    public String toString() {
        return this.f8288b.toString() + ", hidden list:" + this.f8289c.size();
    }
}
