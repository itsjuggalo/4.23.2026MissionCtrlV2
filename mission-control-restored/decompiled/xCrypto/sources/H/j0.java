package H;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import u.C1859g;

/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f564a;

    public static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Window f565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final A f566b;

        public a(Window window, A a4) {
            this.f565a = window;
            this.f566b = a4;
        }

        public void c(int i4) {
            View decorView = this.f565a.getDecorView();
            decorView.setSystemUiVisibility(i4 | decorView.getSystemUiVisibility());
        }

        public void d(int i4) {
            this.f565a.addFlags(i4);
        }

        public void e(int i4) {
            View decorView = this.f565a.getDecorView();
            decorView.setSystemUiVisibility((~i4) & decorView.getSystemUiVisibility());
        }

        public void f(int i4) {
            this.f565a.clearFlags(i4);
        }
    }

    public static class b extends a {
        public b(Window window, A a4) {
            super(window, a4);
        }

        @Override // H.j0.e
        public void b(boolean z4) {
            if (!z4) {
                e(UserMetadata.MAX_INTERNAL_KEY_SIZE);
                return;
            }
            f(67108864);
            d(Integer.MIN_VALUE);
            c(UserMetadata.MAX_INTERNAL_KEY_SIZE);
        }
    }

    public static class c extends b {
        public c(Window window, A a4) {
            super(window, a4);
        }

        @Override // H.j0.e
        public void a(boolean z4) {
            if (!z4) {
                e(16);
                return;
            }
            f(134217728);
            d(Integer.MIN_VALUE);
            c(16);
        }
    }

    public j0(Window window, View view) {
        A a4 = new A(view);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            this.f564a = new d(window, this, a4);
        } else if (i4 >= 26) {
            this.f564a = new c(window, a4);
        } else {
            this.f564a = new b(window, a4);
        }
    }

    public void a(boolean z4) {
        this.f564a.a(z4);
    }

    public void b(boolean z4) {
        this.f564a.b(z4);
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final A f569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C1859g f570d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Window f571e;

        public d(Window window, j0 j0Var, A a4) {
            this(window.getInsetsController(), j0Var, a4);
            this.f571e = window;
        }

        @Override // H.j0.e
        public void a(boolean z4) {
            if (z4) {
                if (this.f571e != null) {
                    c(16);
                }
                this.f568b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f571e != null) {
                    d(16);
                }
                this.f568b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // H.j0.e
        public void b(boolean z4) {
            if (z4) {
                if (this.f571e != null) {
                    c(UserMetadata.MAX_INTERNAL_KEY_SIZE);
                }
                this.f568b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f571e != null) {
                    d(UserMetadata.MAX_INTERNAL_KEY_SIZE);
                }
                this.f568b.setSystemBarsAppearance(0, 8);
            }
        }

        public void c(int i4) {
            View decorView = this.f571e.getDecorView();
            decorView.setSystemUiVisibility(i4 | decorView.getSystemUiVisibility());
        }

        public void d(int i4) {
            View decorView = this.f571e.getDecorView();
            decorView.setSystemUiVisibility((~i4) & decorView.getSystemUiVisibility());
        }

        public d(WindowInsetsController windowInsetsController, j0 j0Var, A a4) {
            this.f570d = new C1859g();
            this.f568b = windowInsetsController;
            this.f567a = j0Var;
            this.f569c = a4;
        }
    }

    public static class e {
        public abstract void b(boolean z4);

        public void a(boolean z4) {
        }
    }
}
