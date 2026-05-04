package df;

import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends bf.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f8097h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f8098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f8099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f8100k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8101g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    static {
        e eVar = new e(2, 1, 0);
        f8098i = eVar;
        f8099j = eVar.m();
        f8100k = new e(new int[0]);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int[] versionArray, boolean z10) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        t.f(versionArray, "versionArray");
        this.f8101g = z10;
    }

    public final boolean h(e metadataVersionFromLanguageVersion) {
        t.f(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        if (a() == 2 && b() == 0) {
            e eVar = f8098i;
            if (eVar.a() == 1 && eVar.b() == 8) {
                return true;
            }
        }
        return i(metadataVersionFromLanguageVersion.k(this.f8101g));
    }

    public final boolean i(e eVar) {
        if ((a() == 1 && b() == 0) || a() == 0) {
            return false;
        }
        return !l(eVar);
    }

    public final boolean j() {
        return this.f8101g;
    }

    public final e k(boolean z10) {
        e eVar = z10 ? f8098i : f8099j;
        return eVar.l(this) ? eVar : this;
    }

    public final boolean l(e eVar) {
        if (a() > eVar.a()) {
            return true;
        }
        return a() >= eVar.a() && b() > eVar.b();
    }

    public final e m() {
        return (a() == 1 && b() == 9) ? new e(2, 0, 0) : new e(a(), b() + 1, 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(int... numbers) {
        this(numbers, false);
        t.f(numbers, "numbers");
    }
}
