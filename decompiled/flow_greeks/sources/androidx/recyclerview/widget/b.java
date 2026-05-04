package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0040b f2768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2769b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2770c = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2771a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f2772b;

        public void a(int i10) {
            if (i10 < 64) {
                this.f2771a &= ~(1 << i10);
                return;
            }
            a aVar = this.f2772b;
            if (aVar != null) {
                aVar.a(i10 - 64);
            }
        }

        public int b(int i10) {
            a aVar = this.f2772b;
            return aVar == null ? i10 >= 64 ? Long.bitCount(this.f2771a) : Long.bitCount(this.f2771a & ((1 << i10) - 1)) : i10 < 64 ? Long.bitCount(this.f2771a & ((1 << i10) - 1)) : aVar.b(i10 - 64) + Long.bitCount(this.f2771a);
        }

        public final void c() {
            if (this.f2772b == null) {
                this.f2772b = new a();
            }
        }

        public boolean d(int i10) {
            if (i10 < 64) {
                return (this.f2771a & (1 << i10)) != 0;
            }
            c();
            return this.f2772b.d(i10 - 64);
        }

        public boolean e(int i10) {
            if (i10 >= 64) {
                c();
                return this.f2772b.e(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f2771a;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.f2771a = j12;
            long j13 = j10 - 1;
            this.f2771a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            a aVar = this.f2772b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    g(63);
                }
                this.f2772b.e(0);
            }
            return z10;
        }

        public void f() {
            this.f2771a = 0L;
            a aVar = this.f2772b;
            if (aVar != null) {
                aVar.f();
            }
        }

        public void g(int i10) {
            if (i10 < 64) {
                this.f2771a |= 1 << i10;
            } else {
                c();
                this.f2772b.g(i10 - 64);
            }
        }

        public String toString() {
            if (this.f2772b == null) {
                return Long.toBinaryString(this.f2771a);
            }
            return this.f2772b.toString() + "xx" + Long.toBinaryString(this.f2771a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0040b {
        int j();

        View k(int i10);

        void l();

        int m(View view);

        RecyclerView.a0 n(View view);

        void o(int i10);

        void p(View view);
    }

    public b(InterfaceC0040b interfaceC0040b) {
        this.f2768a = interfaceC0040b;
    }

    public void a(int i10) {
        int iE = e(i10);
        this.f2769b.e(iE);
        this.f2768a.o(iE);
    }

    public View b(int i10) {
        if (this.f2770c.size() <= 0) {
            return null;
        }
        this.f2768a.n((View) this.f2770c.get(0));
        throw null;
    }

    public View c(int i10) {
        return this.f2768a.k(e(i10));
    }

    public int d() {
        return this.f2768a.j() - this.f2770c.size();
    }

    public final int e(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int iJ = this.f2768a.j();
        int i11 = i10;
        while (i11 < iJ) {
            int iB = i10 - (i11 - this.f2769b.b(i11));
            if (iB == 0) {
                while (this.f2769b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += iB;
        }
        return -1;
    }

    public View f(int i10) {
        return this.f2768a.k(i10);
    }

    public int g() {
        return this.f2768a.j();
    }

    public int h(View view) {
        int iM = this.f2768a.m(view);
        if (iM == -1 || this.f2769b.d(iM)) {
            return -1;
        }
        return iM - this.f2769b.b(iM);
    }

    public void i() {
        this.f2769b.f();
        for (int size = this.f2770c.size() - 1; size >= 0; size--) {
            this.f2768a.p((View) this.f2770c.get(size));
            this.f2770c.remove(size);
        }
        this.f2768a.l();
    }

    public void j(View view) {
        int iM = this.f2768a.m(view);
        if (iM < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f2769b.d(iM)) {
            this.f2769b.a(iM);
            k(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean k(View view) {
        if (!this.f2770c.remove(view)) {
            return false;
        }
        this.f2768a.p(view);
        return true;
    }

    public String toString() {
        return this.f2769b.toString() + ", hidden list:" + this.f2770c.size();
    }
}
