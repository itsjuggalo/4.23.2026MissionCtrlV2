package T;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f7855a;

    public static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Window f7856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0943z f7857b;

        public a(Window window, C0943z c0943z) {
            this.f7856a = window;
            this.f7857b = c0943z;
        }

        public void c(int i8) {
            View decorView = this.f7856a.getDecorView();
            decorView.setSystemUiVisibility(i8 | decorView.getSystemUiVisibility());
        }

        public void d(int i8) {
            this.f7856a.addFlags(i8);
        }

        public void e(int i8) {
            View decorView = this.f7856a.getDecorView();
            decorView.setSystemUiVisibility((~i8) & decorView.getSystemUiVisibility());
        }

        public void f(int i8) {
            this.f7856a.clearFlags(i8);
        }
    }

    public static class b extends a {
        public b(Window window, C0943z c0943z) {
            super(window, c0943z);
        }

        @Override // T.k0.e
        public void b(boolean z7) {
            if (!z7) {
                e(8192);
                return;
            }
            f(67108864);
            d(Integer.MIN_VALUE);
            c(8192);
        }
    }

    public static class c extends b {
        public c(Window window, C0943z c0943z) {
            super(window, c0943z);
        }

        @Override // T.k0.e
        public void a(boolean z7) {
            if (!z7) {
                e(16);
                return;
            }
            f(134217728);
            d(Integer.MIN_VALUE);
            c(16);
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0 f7858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f7859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0943z f7860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final w.i f7861d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Window f7862e;

        public d(Window window, k0 k0Var, C0943z c0943z) {
            this(window.getInsetsController(), k0Var, c0943z);
            this.f7862e = window;
        }

        @Override // T.k0.e
        public void a(boolean z7) {
            if (z7) {
                if (this.f7862e != null) {
                    c(16);
                }
                this.f7859b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f7862e != null) {
                    d(16);
                }
                this.f7859b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // T.k0.e
        public void b(boolean z7) {
            if (z7) {
                if (this.f7862e != null) {
                    c(8192);
                }
                this.f7859b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f7862e != null) {
                    d(8192);
                }
                this.f7859b.setSystemBarsAppearance(0, 8);
            }
        }

        public void c(int i8) {
            View decorView = this.f7862e.getDecorView();
            decorView.setSystemUiVisibility(i8 | decorView.getSystemUiVisibility());
        }

        public void d(int i8) {
            View decorView = this.f7862e.getDecorView();
            decorView.setSystemUiVisibility((~i8) & decorView.getSystemUiVisibility());
        }

        public d(WindowInsetsController windowInsetsController, k0 k0Var, C0943z c0943z) {
            this.f7861d = new w.i();
            this.f7859b = windowInsetsController;
            this.f7858a = k0Var;
            this.f7860c = c0943z;
        }
    }

    public k0(Window window, View view) {
        C0943z c0943z = new C0943z(view);
        int i8 = Build.VERSION.SDK_INT;
        this.f7855a = i8 >= 30 ? new d(window, this, c0943z) : i8 >= 26 ? new c(window, c0943z) : new b(window, c0943z);
    }

    public void a(boolean z7) {
        this.f7855a.a(z7);
    }

    public void b(boolean z7) {
        this.f7855a.b(z7);
    }

    public static class e {
        public abstract void b(boolean z7);

        public void a(boolean z7) {
        }
    }
}
