package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f8429b = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8430a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8433d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8434e;

        public void a(int i7) {
            this.f8430a = i7 | this.f8430a;
        }

        public boolean b() {
            int i7 = this.f8430a;
            if ((i7 & 7) != 0 && (i7 & c(this.f8433d, this.f8431b)) == 0) {
                return false;
            }
            int i8 = this.f8430a;
            if ((i8 & 112) != 0 && (i8 & (c(this.f8433d, this.f8432c) << 4)) == 0) {
                return false;
            }
            int i9 = this.f8430a;
            if ((i9 & 1792) != 0 && (i9 & (c(this.f8434e, this.f8431b) << 8)) == 0) {
                return false;
            }
            int i10 = this.f8430a;
            return (i10 & 28672) == 0 || (i10 & (c(this.f8434e, this.f8432c) << 12)) != 0;
        }

        public int c(int i7, int i8) {
            if (i7 > i8) {
                return 1;
            }
            return i7 == i8 ? 2 : 4;
        }

        public void d() {
            this.f8430a = 0;
        }

        public void e(int i7, int i8, int i9, int i10) {
            this.f8431b = i7;
            this.f8432c = i8;
            this.f8433d = i9;
            this.f8434e = i10;
        }
    }

    public interface b {
        View a(int i7);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    public o(b bVar) {
        this.f8428a = bVar;
    }

    public View a(int i7, int i8, int i9, int i10) {
        int iC = this.f8428a.c();
        int iD = this.f8428a.d();
        int i11 = i8 > i7 ? 1 : -1;
        View view = null;
        while (i7 != i8) {
            View viewA = this.f8428a.a(i7);
            this.f8429b.e(iC, iD, this.f8428a.b(viewA), this.f8428a.e(viewA));
            if (i9 != 0) {
                this.f8429b.d();
                this.f8429b.a(i9);
                if (this.f8429b.b()) {
                    return viewA;
                }
            }
            if (i10 != 0) {
                this.f8429b.d();
                this.f8429b.a(i10);
                if (this.f8429b.b()) {
                    view = viewA;
                }
            }
            i7 += i11;
        }
        return view;
    }

    public boolean b(View view, int i7) {
        this.f8429b.e(this.f8428a.c(), this.f8428a.d(), this.f8428a.b(view), this.f8428a.e(view));
        if (i7 == 0) {
            return false;
        }
        this.f8429b.d();
        this.f8429b.a(i7);
        return this.f8429b.b();
    }
}
