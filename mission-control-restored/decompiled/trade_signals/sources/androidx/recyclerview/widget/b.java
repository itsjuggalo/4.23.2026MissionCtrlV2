package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0199b f12401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f12402b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f12403c = new ArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f12404a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f12405b;

        public void a(int i8) {
            if (i8 < 64) {
                this.f12404a &= ~(1 << i8);
                return;
            }
            a aVar = this.f12405b;
            if (aVar != null) {
                aVar.a(i8 - 64);
            }
        }

        public int b(int i8) {
            a aVar = this.f12405b;
            return aVar == null ? i8 >= 64 ? Long.bitCount(this.f12404a) : Long.bitCount(this.f12404a & ((1 << i8) - 1)) : i8 < 64 ? Long.bitCount(this.f12404a & ((1 << i8) - 1)) : aVar.b(i8 - 64) + Long.bitCount(this.f12404a);
        }

        public final void c() {
            if (this.f12405b == null) {
                this.f12405b = new a();
            }
        }

        public boolean d(int i8) {
            if (i8 < 64) {
                return (this.f12404a & (1 << i8)) != 0;
            }
            c();
            return this.f12405b.d(i8 - 64);
        }

        public boolean e(int i8) {
            if (i8 >= 64) {
                c();
                return this.f12405b.e(i8 - 64);
            }
            long j8 = 1 << i8;
            long j9 = this.f12404a;
            boolean z7 = (j9 & j8) != 0;
            long j10 = j9 & (~j8);
            this.f12404a = j10;
            long j11 = j8 - 1;
            this.f12404a = (j10 & j11) | Long.rotateRight((~j11) & j10, 1);
            a aVar = this.f12405b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    g(63);
                }
                this.f12405b.e(0);
            }
            return z7;
        }

        public void f() {
            this.f12404a = 0L;
            a aVar = this.f12405b;
            if (aVar != null) {
                aVar.f();
            }
        }

        public void g(int i8) {
            if (i8 < 64) {
                this.f12404a |= 1 << i8;
            } else {
                c();
                this.f12405b.g(i8 - 64);
            }
        }

        public String toString() {
            if (this.f12405b == null) {
                return Long.toBinaryString(this.f12404a);
            }
            return this.f12405b.toString() + "xx" + Long.toBinaryString(this.f12404a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    public interface InterfaceC0199b {
        int j();

        View k(int i8);

        void l();

        int m(View view);

        RecyclerView.A n(View view);

        void o(int i8);

        void p(View view);
    }

    public b(InterfaceC0199b interfaceC0199b) {
        this.f12401a = interfaceC0199b;
    }

    public void a(int i8) {
        int iE = e(i8);
        this.f12402b.e(iE);
        this.f12401a.o(iE);
    }

    public View b(int i8) {
        if (this.f12403c.size() <= 0) {
            return null;
        }
        this.f12401a.n((View) this.f12403c.get(0));
        throw null;
    }

    public View c(int i8) {
        return this.f12401a.k(e(i8));
    }

    public int d() {
        return this.f12401a.j() - this.f12403c.size();
    }

    public final int e(int i8) {
        if (i8 < 0) {
            return -1;
        }
        int iJ = this.f12401a.j();
        int i9 = i8;
        while (i9 < iJ) {
            int iB = i8 - (i9 - this.f12402b.b(i9));
            if (iB == 0) {
                while (this.f12402b.d(i9)) {
                    i9++;
                }
                return i9;
            }
            i9 += iB;
        }
        return -1;
    }

    public View f(int i8) {
        return this.f12401a.k(i8);
    }

    public int g() {
        return this.f12401a.j();
    }

    public int h(View view) {
        int iM = this.f12401a.m(view);
        if (iM == -1 || this.f12402b.d(iM)) {
            return -1;
        }
        return iM - this.f12402b.b(iM);
    }

    public void i() {
        this.f12402b.f();
        for (int size = this.f12403c.size() - 1; size >= 0; size--) {
            this.f12401a.p((View) this.f12403c.get(size));
            this.f12403c.remove(size);
        }
        this.f12401a.l();
    }

    public void j(View view) {
        int iM = this.f12401a.m(view);
        if (iM < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f12402b.d(iM)) {
            this.f12402b.a(iM);
            k(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean k(View view) {
        if (!this.f12403c.remove(view)) {
            return false;
        }
        this.f12401a.p(view);
        return true;
    }

    public String toString() {
        return this.f12402b.toString() + ", hidden list:" + this.f12403c.size();
    }
}
