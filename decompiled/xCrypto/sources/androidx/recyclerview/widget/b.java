package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0116b f8105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f8106b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f8107c = new ArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8108a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f8109b;

        public void a(int i4) {
            if (i4 < 64) {
                this.f8108a &= ~(1 << i4);
                return;
            }
            a aVar = this.f8109b;
            if (aVar != null) {
                aVar.a(i4 - 64);
            }
        }

        public int b(int i4) {
            a aVar = this.f8109b;
            return aVar == null ? i4 >= 64 ? Long.bitCount(this.f8108a) : Long.bitCount(this.f8108a & ((1 << i4) - 1)) : i4 < 64 ? Long.bitCount(this.f8108a & ((1 << i4) - 1)) : aVar.b(i4 - 64) + Long.bitCount(this.f8108a);
        }

        public final void c() {
            if (this.f8109b == null) {
                this.f8109b = new a();
            }
        }

        public boolean d(int i4) {
            if (i4 < 64) {
                return (this.f8108a & (1 << i4)) != 0;
            }
            c();
            return this.f8109b.d(i4 - 64);
        }

        public boolean e(int i4) {
            if (i4 >= 64) {
                c();
                return this.f8109b.e(i4 - 64);
            }
            long j4 = 1 << i4;
            long j5 = this.f8108a;
            boolean z4 = (j5 & j4) != 0;
            long j6 = j5 & (~j4);
            this.f8108a = j6;
            long j7 = j4 - 1;
            this.f8108a = (j6 & j7) | Long.rotateRight((~j7) & j6, 1);
            a aVar = this.f8109b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    g(63);
                }
                this.f8109b.e(0);
            }
            return z4;
        }

        public void f() {
            this.f8108a = 0L;
            a aVar = this.f8109b;
            if (aVar != null) {
                aVar.f();
            }
        }

        public void g(int i4) {
            if (i4 < 64) {
                this.f8108a |= 1 << i4;
            } else {
                c();
                this.f8109b.g(i4 - 64);
            }
        }

        public String toString() {
            if (this.f8109b == null) {
                return Long.toBinaryString(this.f8108a);
            }
            return this.f8109b.toString() + "xx" + Long.toBinaryString(this.f8108a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    public interface InterfaceC0116b {
        View a(int i4);

        int b();

        void c();

        int d(View view);

        RecyclerView.A e(View view);

        void f(int i4);

        void g(View view);
    }

    public b(InterfaceC0116b interfaceC0116b) {
        this.f8105a = interfaceC0116b;
    }

    public void a(int i4) {
        int iE = e(i4);
        this.f8106b.e(iE);
        this.f8105a.f(iE);
    }

    public View b(int i4) {
        if (this.f8107c.size() <= 0) {
            return null;
        }
        this.f8105a.e((View) this.f8107c.get(0));
        throw null;
    }

    public View c(int i4) {
        return this.f8105a.a(e(i4));
    }

    public int d() {
        return this.f8105a.b() - this.f8107c.size();
    }

    public final int e(int i4) {
        if (i4 < 0) {
            return -1;
        }
        int iB = this.f8105a.b();
        int i5 = i4;
        while (i5 < iB) {
            int iB2 = i4 - (i5 - this.f8106b.b(i5));
            if (iB2 == 0) {
                while (this.f8106b.d(i5)) {
                    i5++;
                }
                return i5;
            }
            i5 += iB2;
        }
        return -1;
    }

    public View f(int i4) {
        return this.f8105a.a(i4);
    }

    public int g() {
        return this.f8105a.b();
    }

    public int h(View view) {
        int iD = this.f8105a.d(view);
        if (iD == -1 || this.f8106b.d(iD)) {
            return -1;
        }
        return iD - this.f8106b.b(iD);
    }

    public void i() {
        this.f8106b.f();
        for (int size = this.f8107c.size() - 1; size >= 0; size--) {
            this.f8105a.g((View) this.f8107c.get(size));
            this.f8107c.remove(size);
        }
        this.f8105a.c();
    }

    public void j(View view) {
        int iD = this.f8105a.d(view);
        if (iD < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f8106b.d(iD)) {
            this.f8106b.a(iD);
            k(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean k(View view) {
        if (!this.f8107c.remove(view)) {
            return false;
        }
        this.f8105a.g(view);
        return true;
    }

    public String toString() {
        return this.f8106b.toString() + ", hidden list:" + this.f8107c.size();
    }
}
