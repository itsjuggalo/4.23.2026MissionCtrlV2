package tb;

import java.text.MessageFormat;
import java.util.logging.Level;
import rb.f;
import rb.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends rb.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f21560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q2 f21561b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21562a;

        static {
            int[] iArr = new int[f.a.values().length];
            f21562a = iArr;
            try {
                iArr[f.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21562a[f.a.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21562a[f.a.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public o(p pVar, q2 q2Var) {
        this.f21560a = (p) p6.n.o(pVar, "tracer");
        this.f21561b = (q2) p6.n.o(q2Var, com.amazon.a.a.h.a.f4275b);
    }

    public static void d(rb.k0 k0Var, f.a aVar, String str) {
        Level levelF = f(aVar);
        if (p.f21565f.isLoggable(levelF)) {
            p.d(k0Var, levelF, str);
        }
    }

    public static void e(rb.k0 k0Var, f.a aVar, String str, Object... objArr) {
        Level levelF = f(aVar);
        if (p.f21565f.isLoggable(levelF)) {
            p.d(k0Var, levelF, MessageFormat.format(str, objArr));
        }
    }

    public static Level f(f.a aVar) {
        int i10 = a.f21562a[aVar.ordinal()];
        return (i10 == 1 || i10 == 2) ? Level.FINE : i10 != 3 ? Level.FINEST : Level.FINER;
    }

    public static f0.b g(f.a aVar) {
        int i10 = a.f21562a[aVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? f0.b.CT_INFO : f0.b.CT_WARNING : f0.b.CT_ERROR;
    }

    @Override // rb.f
    public void a(f.a aVar, String str) {
        d(this.f21560a.b(), aVar, str);
        if (c(aVar)) {
            h(aVar, str);
        }
    }

    @Override // rb.f
    public void b(f.a aVar, String str, Object... objArr) {
        a(aVar, (c(aVar) || p.f21565f.isLoggable(f(aVar))) ? MessageFormat.format(str, objArr) : null);
    }

    public final boolean c(f.a aVar) {
        return aVar != f.a.DEBUG && this.f21560a.c();
    }

    public final void h(f.a aVar, String str) {
        if (aVar == f.a.DEBUG) {
            return;
        }
        this.f21560a.f(new f0.a().b(str).c(g(aVar)).e(this.f21561b.a()).a());
    }
}
