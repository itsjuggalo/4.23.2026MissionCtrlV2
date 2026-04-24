package t5;

import java.text.MessageFormat;
import java.util.logging.Level;
import r5.AbstractC2590f;
import r5.F;

/* JADX INFO: renamed from: t5.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2691o extends AbstractC2590f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2693p f24081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final R0 f24082b;

    /* JADX INFO: renamed from: t5.o$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24083a;

        static {
            int[] iArr = new int[AbstractC2590f.a.values().length];
            f24083a = iArr;
            try {
                iArr[AbstractC2590f.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24083a[AbstractC2590f.a.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24083a[AbstractC2590f.a.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C2691o(C2693p c2693p, R0 r02) {
        this.f24081a = (C2693p) H2.m.o(c2693p, "tracer");
        this.f24082b = (R0) H2.m.o(r02, com.amazon.a.a.h.a.f9648b);
    }

    public static void d(r5.K k7, AbstractC2590f.a aVar, String str) {
        Level levelF = f(aVar);
        if (C2693p.f24095f.isLoggable(levelF)) {
            C2693p.d(k7, levelF, str);
        }
    }

    public static void e(r5.K k7, AbstractC2590f.a aVar, String str, Object... objArr) {
        Level levelF = f(aVar);
        if (C2693p.f24095f.isLoggable(levelF)) {
            C2693p.d(k7, levelF, MessageFormat.format(str, objArr));
        }
    }

    public static Level f(AbstractC2590f.a aVar) {
        int i7 = a.f24083a[aVar.ordinal()];
        return (i7 == 1 || i7 == 2) ? Level.FINE : i7 != 3 ? Level.FINEST : Level.FINER;
    }

    public static F.b g(AbstractC2590f.a aVar) {
        int i7 = a.f24083a[aVar.ordinal()];
        return i7 != 1 ? i7 != 2 ? F.b.CT_INFO : F.b.CT_WARNING : F.b.CT_ERROR;
    }

    @Override // r5.AbstractC2590f
    public void a(AbstractC2590f.a aVar, String str) {
        d(this.f24081a.b(), aVar, str);
        if (c(aVar)) {
            h(aVar, str);
        }
    }

    @Override // r5.AbstractC2590f
    public void b(AbstractC2590f.a aVar, String str, Object... objArr) {
        a(aVar, (c(aVar) || C2693p.f24095f.isLoggable(f(aVar))) ? MessageFormat.format(str, objArr) : null);
    }

    public final boolean c(AbstractC2590f.a aVar) {
        return aVar != AbstractC2590f.a.DEBUG && this.f24081a.c();
    }

    public final void h(AbstractC2590f.a aVar, String str) {
        if (aVar == AbstractC2590f.a.DEBUG) {
            return;
        }
        this.f24081a.f(new F.a().b(str).c(g(aVar)).e(this.f24082b.a()).a());
    }
}
