package M0;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements M0.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f3725c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3727b;

    /* JADX INFO: renamed from: M0.a$a, reason: collision with other inner class name */
    public static class C0048a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set f3728a = new HashSet(Arrays.asList(o.d().a()));
    }

    public static class b extends a {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // M0.a
        public final boolean c() {
            return true;
        }
    }

    public static class c extends a {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // M0.a
        public final boolean c() {
            return true;
        }
    }

    public static class d extends a {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // M0.a
        public final boolean c() {
            return false;
        }
    }

    public static class e extends a {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // M0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    public static class f extends a {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // M0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    public static class g extends a {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // M0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    public static class h extends a {
        public h(String str, String str2) {
            super(str, str2);
        }

        @Override // M0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    public static class i extends a {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // M0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public a(String str, String str2) {
        this.f3726a = str;
        this.f3727b = str2;
        f3725c.add(this);
    }

    public static Set e() {
        return Collections.unmodifiableSet(f3725c);
    }

    @Override // M0.i
    public boolean a() {
        return c() || d();
    }

    @Override // M0.i
    public String b() {
        return this.f3726a;
    }

    public abstract boolean c();

    public boolean d() {
        return A6.a.b(C0048a.f3728a, this.f3727b);
    }
}
