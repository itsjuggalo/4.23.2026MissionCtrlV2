package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f8198b = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8199a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8203e;

        public void a(int i4) {
            this.f8199a = i4 | this.f8199a;
        }

        public boolean b() {
            int i4 = this.f8199a;
            if ((i4 & 7) != 0 && (i4 & c(this.f8202d, this.f8200b)) == 0) {
                return false;
            }
            int i5 = this.f8199a;
            if ((i5 & 112) != 0 && (i5 & (c(this.f8202d, this.f8201c) << 4)) == 0) {
                return false;
            }
            int i6 = this.f8199a;
            if ((i6 & 1792) != 0 && (i6 & (c(this.f8203e, this.f8200b) << 8)) == 0) {
                return false;
            }
            int i7 = this.f8199a;
            return (i7 & 28672) == 0 || (i7 & (c(this.f8203e, this.f8201c) << 12)) != 0;
        }

        public int c(int i4, int i5) {
            if (i4 > i5) {
                return 1;
            }
            return i4 == i5 ? 2 : 4;
        }

        public void d() {
            this.f8199a = 0;
        }

        public void e(int i4, int i5, int i6, int i7) {
            this.f8200b = i4;
            this.f8201c = i5;
            this.f8202d = i6;
            this.f8203e = i7;
        }
    }

    public interface b {
        View a(int i4);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    public l(b bVar) {
        this.f8197a = bVar;
    }

    public View a(int i4, int i5, int i6, int i7) {
        int iC = this.f8197a.c();
        int iD = this.f8197a.d();
        int i8 = i5 > i4 ? 1 : -1;
        View view = null;
        while (i4 != i5) {
            View viewA = this.f8197a.a(i4);
            this.f8198b.e(iC, iD, this.f8197a.b(viewA), this.f8197a.e(viewA));
            if (i6 != 0) {
                this.f8198b.d();
                this.f8198b.a(i6);
                if (this.f8198b.b()) {
                    return viewA;
                }
            }
            if (i7 != 0) {
                this.f8198b.d();
                this.f8198b.a(i7);
                if (this.f8198b.b()) {
                    view = viewA;
                }
            }
            i4 += i8;
        }
        return view;
    }
}
