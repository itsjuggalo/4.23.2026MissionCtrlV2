package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f12494b = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12495a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12499e;

        public void a(int i8) {
            this.f12495a = i8 | this.f12495a;
        }

        public boolean b() {
            int i8 = this.f12495a;
            if ((i8 & 7) != 0 && (i8 & c(this.f12498d, this.f12496b)) == 0) {
                return false;
            }
            int i9 = this.f12495a;
            if ((i9 & 112) != 0 && (i9 & (c(this.f12498d, this.f12497c) << 4)) == 0) {
                return false;
            }
            int i10 = this.f12495a;
            if ((i10 & 1792) != 0 && (i10 & (c(this.f12499e, this.f12496b) << 8)) == 0) {
                return false;
            }
            int i11 = this.f12495a;
            return (i11 & 28672) == 0 || (i11 & (c(this.f12499e, this.f12497c) << 12)) != 0;
        }

        public int c(int i8, int i9) {
            if (i8 > i9) {
                return 1;
            }
            return i8 == i9 ? 2 : 4;
        }

        public void d() {
            this.f12495a = 0;
        }

        public void e(int i8, int i9, int i10, int i11) {
            this.f12496b = i8;
            this.f12497c = i9;
            this.f12498d = i10;
            this.f12499e = i11;
        }
    }

    public interface b {
        int a(View view);

        int b();

        int c();

        int d(View view);

        View k(int i8);
    }

    public l(b bVar) {
        this.f12493a = bVar;
    }

    public View a(int i8, int i9, int i10, int i11) {
        int iB = this.f12493a.b();
        int iC = this.f12493a.c();
        int i12 = i9 > i8 ? 1 : -1;
        View view = null;
        while (i8 != i9) {
            View viewK = this.f12493a.k(i8);
            this.f12494b.e(iB, iC, this.f12493a.a(viewK), this.f12493a.d(viewK));
            if (i10 != 0) {
                this.f12494b.d();
                this.f12494b.a(i10);
                if (this.f12494b.b()) {
                    return viewK;
                }
            }
            if (i11 != 0) {
                this.f12494b.d();
                this.f12494b.a(i11);
                if (this.f12494b.b()) {
                    view = viewK;
                }
            }
            i8 += i12;
        }
        return view;
    }
}
