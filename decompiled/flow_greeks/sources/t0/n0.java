package t0;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f20542a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Window f20543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y f20544b;

        public a(Window window, y yVar) {
            this.f20543a = window;
            this.f20544b = yVar;
        }

        public void c(int i10) {
            View decorView = this.f20543a.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        public void d(int i10) {
            this.f20543a.addFlags(i10);
        }

        public void e(int i10) {
            View decorView = this.f20543a.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        public void f(int i10) {
            this.f20543a.clearFlags(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends a {
        public b(Window window, y yVar) {
            super(window, yVar);
        }

        @Override // t0.n0.g
        public void b(boolean z10) {
            if (!z10) {
                e(8192);
                return;
            }
            f(67108864);
            d(Integer.MIN_VALUE);
            c(8192);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends b {
        public c(Window window, y yVar) {
            super(window, yVar);
        }

        @Override // t0.n0.g
        public void a(boolean z10) {
            if (!z10) {
                e(16);
                return;
            }
            f(134217728);
            d(Integer.MIN_VALUE);
            c(16);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e extends d {
        public e(Window window, n0 n0Var, y yVar) {
            super(window, n0Var, yVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f extends e {
        public f(Window window, n0 n0Var, y yVar) {
            super(window, n0Var, yVar);
        }
    }

    public n0(Window window, View view) {
        y yVar = new y(view);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 35) {
            this.f20542a = new f(window, this, yVar);
            return;
        }
        if (i10 >= 30) {
            this.f20542a = new d(window, this, yVar);
        } else if (i10 >= 26) {
            this.f20542a = new c(window, yVar);
        } else {
            this.f20542a = new b(window, yVar);
        }
    }

    public void a(boolean z10) {
        this.f20542a.a(z10);
    }

    public void b(boolean z10) {
        this.f20542a.b(z10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n0 f20545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f20546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y f20547c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final w.i f20548d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Window f20549e;

        public d(Window window, n0 n0Var, y yVar) {
            this(window.getInsetsController(), n0Var, yVar);
            this.f20549e = window;
        }

        @Override // t0.n0.g
        public void a(boolean z10) {
            if (z10) {
                if (this.f20549e != null) {
                    c(16);
                }
                this.f20546b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f20549e != null) {
                    d(16);
                }
                this.f20546b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // t0.n0.g
        public void b(boolean z10) {
            if (z10) {
                if (this.f20549e != null) {
                    c(8192);
                }
                this.f20546b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f20549e != null) {
                    d(8192);
                }
                this.f20546b.setSystemBarsAppearance(0, 8);
            }
        }

        public void c(int i10) {
            View decorView = this.f20549e.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        public void d(int i10) {
            View decorView = this.f20549e.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        public d(WindowInsetsController windowInsetsController, n0 n0Var, y yVar) {
            this.f20548d = new w.i();
            this.f20546b = windowInsetsController;
            this.f20545a = n0Var;
            this.f20547c = yVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g {
        public abstract void b(boolean z10);

        public void a(boolean z10) {
        }
    }
}
