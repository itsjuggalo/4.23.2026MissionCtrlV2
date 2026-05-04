package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f2856b = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2857a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2861e;

        public void a(int i10) {
            this.f2857a = i10 | this.f2857a;
        }

        public boolean b() {
            int i10 = this.f2857a;
            if ((i10 & 7) != 0 && (i10 & c(this.f2860d, this.f2858b)) == 0) {
                return false;
            }
            int i11 = this.f2857a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f2860d, this.f2859c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f2857a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f2861e, this.f2858b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f2857a;
            return (i13 & 28672) == 0 || (i13 & (c(this.f2861e, this.f2859c) << 12)) != 0;
        }

        public int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        public void d() {
            this.f2857a = 0;
        }

        public void e(int i10, int i11, int i12, int i13) {
            this.f2858b = i10;
            this.f2859c = i11;
            this.f2860d = i12;
            this.f2861e = i13;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        int a(View view);

        int b();

        int c();

        int d(View view);

        View k(int i10);
    }

    public l(b bVar) {
        this.f2855a = bVar;
    }

    public View a(int i10, int i11, int i12, int i13) {
        int iB = this.f2855a.b();
        int iC = this.f2855a.c();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View viewK = this.f2855a.k(i10);
            this.f2856b.e(iB, iC, this.f2855a.a(viewK), this.f2855a.d(viewK));
            if (i12 != 0) {
                this.f2856b.d();
                this.f2856b.a(i12);
                if (this.f2856b.b()) {
                    return viewK;
                }
            }
            if (i13 != 0) {
                this.f2856b.d();
                this.f2856b.a(i13);
                if (this.f2856b.b()) {
                    view = viewK;
                }
            }
            i10 += i14;
        }
        return view;
    }
}
