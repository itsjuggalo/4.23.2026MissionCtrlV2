package p6;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import n6.AbstractC2427a;

/* JADX INFO: renamed from: p6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2602e extends AbstractC2427a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f22408h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C2602e f22409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C2602e f22410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C2602e f22411k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f22412g;

    /* JADX INFO: renamed from: p6.e$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        C2602e c2602e = new C2602e(2, 1, 0);
        f22409i = c2602e;
        f22410j = c2602e.m();
        f22411k = new C2602e(new int[0]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2602e(int... numbers) {
        this(numbers, false);
        AbstractC2304t.f(numbers, "numbers");
    }

    public final boolean h(C2602e metadataVersionFromLanguageVersion) {
        AbstractC2304t.f(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        if (a() == 2 && b() == 0) {
            C2602e c2602e = f22409i;
            if (c2602e.a() == 1 && c2602e.b() == 8) {
                return true;
            }
        }
        return i(metadataVersionFromLanguageVersion.k(this.f22412g));
    }

    public final boolean i(C2602e c2602e) {
        if ((a() == 1 && b() == 0) || a() == 0) {
            return false;
        }
        return !l(c2602e);
    }

    public final boolean j() {
        return this.f22412g;
    }

    public final C2602e k(boolean z7) {
        C2602e c2602e = z7 ? f22409i : f22410j;
        return c2602e.l(this) ? c2602e : this;
    }

    public final boolean l(C2602e c2602e) {
        if (a() > c2602e.a()) {
            return true;
        }
        return a() >= c2602e.a() && b() > c2602e.b();
    }

    public final C2602e m() {
        return (a() == 1 && b() == 9) ? new C2602e(2, 0, 0) : new C2602e(a(), b() + 1, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2602e(int[] versionArray, boolean z7) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        AbstractC2304t.f(versionArray, "versionArray");
        this.f22412g = z7;
    }
}
