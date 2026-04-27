package v0;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: v0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1876a implements InterfaceC1881f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f15200c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15202b;

    /* JADX INFO: renamed from: v0.a$a, reason: collision with other inner class name */
    public static class C0245a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set f15203a = new HashSet(Arrays.asList(l.d().a()));
    }

    /* JADX INFO: renamed from: v0.a$b */
    public static class b extends AbstractC1876a {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // v0.AbstractC1876a
        public final boolean b() {
            return true;
        }
    }

    /* JADX INFO: renamed from: v0.a$c */
    public static class c extends AbstractC1876a {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // v0.AbstractC1876a
        public final boolean b() {
            return true;
        }
    }

    /* JADX INFO: renamed from: v0.a$d */
    public static class d extends AbstractC1876a {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // v0.AbstractC1876a
        public final boolean b() {
            return false;
        }
    }

    /* JADX INFO: renamed from: v0.a$e */
    public static class e extends AbstractC1876a {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // v0.AbstractC1876a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    /* JADX INFO: renamed from: v0.a$f */
    public static class f extends AbstractC1876a {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // v0.AbstractC1876a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    /* JADX INFO: renamed from: v0.a$g */
    public static class g extends AbstractC1876a {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // v0.AbstractC1876a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    /* JADX INFO: renamed from: v0.a$h */
    public static class h extends AbstractC1876a {
        public h(String str, String str2) {
            super(str, str2);
        }

        @Override // v0.AbstractC1876a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* JADX INFO: renamed from: v0.a$i */
    public static class i extends AbstractC1876a {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // v0.AbstractC1876a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public AbstractC1876a(String str, String str2) {
        this.f15201a = str;
        this.f15202b = str2;
        f15200c.add(this);
    }

    public static Set d() {
        return Collections.unmodifiableSet(f15200c);
    }

    @Override // v0.InterfaceC1881f
    public String a() {
        return this.f15201a;
    }

    public abstract boolean b();

    public boolean c() {
        return S3.a.b(C0245a.f15203a, this.f15202b);
    }

    @Override // v0.InterfaceC1881f
    public boolean isSupported() {
        return b() || c();
    }
}
