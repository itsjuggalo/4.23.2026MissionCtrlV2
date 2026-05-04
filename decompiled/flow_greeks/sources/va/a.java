package va;

import kotlin.jvm.internal.t;
import ua.s0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23204a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static s0 f23205b;

    public static final void b() {
        try {
            if (f23205b == null) {
                f23204a.c(s0.f22651a.a());
            }
            a aVar = f23204a;
            if (aVar.a().a()) {
                aVar.a().b();
            }
        } catch (Exception unused) {
        }
    }

    public final s0 a() {
        s0 s0Var = f23205b;
        if (s0Var != null) {
            return s0Var;
        }
        t.s("sharedSessionRepository");
        return null;
    }

    public final void c(s0 s0Var) {
        t.f(s0Var, "<set-?>");
        f23205b = s0Var;
    }
}
