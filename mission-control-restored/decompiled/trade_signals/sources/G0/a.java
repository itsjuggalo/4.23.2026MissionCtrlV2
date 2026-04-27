package G0;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements G0.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f2010c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2012b;

    /* JADX INFO: renamed from: G0.a$a, reason: collision with other inner class name */
    public static class C0030a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set f2013a = new HashSet(Arrays.asList(o.d().a()));
    }

    public static class b extends a {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // G0.a
        public final boolean c() {
            return true;
        }
    }

    public static class c extends a {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // G0.a
        public final boolean c() {
            return true;
        }
    }

    public static class d extends a {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // G0.a
        public final boolean c() {
            return false;
        }
    }

    public static class e extends a {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // G0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    public static class f extends a {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // G0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    public static class g extends a {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // G0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    public static class h extends a {
        public h(String str, String str2) {
            super(str, str2);
        }

        @Override // G0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    public static class i extends a {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // G0.a
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public a(String str, String str2) {
        this.f2011a = str;
        this.f2012b = str2;
        f2010c.add(this);
    }

    public static Set e() {
        return Collections.unmodifiableSet(f2010c);
    }

    @Override // G0.i
    public String a() {
        return this.f2011a;
    }

    @Override // G0.i
    public boolean b() {
        return c() || d();
    }

    public abstract boolean c();

    public boolean d() {
        return w7.a.b(C0030a.f2013a, this.f2012b);
    }
}
