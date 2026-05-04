package ef;

import kg.n;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f8797a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f8798b = new n("[^\\p{L}\\p{Digit}]");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8799c = "$context_receiver";

    public static final f a(int i10) {
        f fVarK = f.k(f8799c + '_' + i10);
        t.e(fVarK, "identifier(...)");
        return fVarK;
    }

    public static final String b(String name) {
        t.f(name, "name");
        return f8798b.c(name, "_");
    }
}
