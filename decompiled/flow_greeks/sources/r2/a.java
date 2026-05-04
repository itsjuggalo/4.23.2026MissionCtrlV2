package r2;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements r2.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f19222c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19224b;

    /* JADX INFO: renamed from: r2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0334a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set f19225a = new HashSet(Arrays.asList(l.d().a()));
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends a {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // r2.a
        public final boolean b() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends a {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // r2.a
        public final boolean b() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d extends a {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // r2.a
        public final boolean b() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e extends a {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // r2.a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f extends a {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // r2.a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g extends a {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // r2.a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class h extends a {
        public h(String str, String str2) {
            super(str, str2);
        }

        @Override // r2.a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class i extends a {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // r2.a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public a(String str, String str2) {
        this.f19223a = str;
        this.f19224b = str2;
        f19222c.add(this);
    }

    public static Set d() {
        return Collections.unmodifiableSet(f19222c);
    }

    @Override // r2.f
    public String a() {
        return this.f19223a;
    }

    public abstract boolean b();

    public boolean c() {
        return jh.a.b(C0334a.f19225a, this.f19224b);
    }

    @Override // r2.f
    public boolean isSupported() {
        return b() || c();
    }
}
