package Q;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f4469a;

    public static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Window f4470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final J f4471b;

        public a(Window window, J j7) {
            this.f4470a = window;
            this.f4471b = j7;
        }

        public void c(int i7) {
            View decorView = this.f4470a.getDecorView();
            decorView.setSystemUiVisibility(i7 | decorView.getSystemUiVisibility());
        }

        public void d(int i7) {
            this.f4470a.addFlags(i7);
        }

        public void e(int i7) {
            View decorView = this.f4470a.getDecorView();
            decorView.setSystemUiVisibility((~i7) & decorView.getSystemUiVisibility());
        }

        public void f(int i7) {
            this.f4470a.clearFlags(i7);
        }
    }

    public static class b extends a {
        public b(Window window, J j7) {
            super(window, j7);
        }

        @Override // Q.v0.e
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
        public c(Window window, J j7) {
            super(window, j7);
        }

        @Override // Q.v0.e
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

    public v0(Window window, View view) {
        J j7 = new J(view);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 30) {
            this.f4469a = new d(window, this, j7);
        } else if (i7 >= 26) {
            this.f4469a = new c(window, j7);
        } else {
            this.f4469a = new b(window, j7);
        }
    }

    public void a(boolean z7) {
        this.f4469a.a(z7);
    }

    public void b(boolean z7) {
        this.f4469a.b(z7);
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v0 f4472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f4473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final J f4474c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final u.g f4475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Window f4476e;

        public d(Window window, v0 v0Var, J j7) {
            this(window.getInsetsController(), v0Var, j7);
            this.f4476e = window;
        }

        @Override // Q.v0.e
        public void a(boolean z7) {
            if (z7) {
                if (this.f4476e != null) {
                    c(16);
                }
                this.f4473b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f4476e != null) {
                    d(16);
                }
                this.f4473b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // Q.v0.e
        public void b(boolean z7) {
            if (z7) {
                if (this.f4476e != null) {
                    c(8192);
                }
                this.f4473b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f4476e != null) {
                    d(8192);
                }
                this.f4473b.setSystemBarsAppearance(0, 8);
            }
        }

        public void c(int i7) {
            View decorView = this.f4476e.getDecorView();
            decorView.setSystemUiVisibility(i7 | decorView.getSystemUiVisibility());
        }

        public void d(int i7) {
            View decorView = this.f4476e.getDecorView();
            decorView.setSystemUiVisibility((~i7) & decorView.getSystemUiVisibility());
        }

        public d(WindowInsetsController windowInsetsController, v0 v0Var, J j7) {
            this.f4475d = new u.g();
            this.f4473b = windowInsetsController;
            this.f4472a = v0Var;
            this.f4474c = j7;
        }
    }

    public static class e {
        public abstract void b(boolean z7);

        public void a(boolean z7) {
        }
    }
}
