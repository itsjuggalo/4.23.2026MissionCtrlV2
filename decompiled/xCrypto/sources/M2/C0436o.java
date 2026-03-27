package M2;

import K2.AbstractC0358f;
import K2.F;
import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: renamed from: M2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0436o extends AbstractC0358f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0438p f2530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final R0 f2531b;

    /* JADX INFO: renamed from: M2.o$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2532a;

        static {
            int[] iArr = new int[AbstractC0358f.a.values().length];
            f2532a = iArr;
            try {
                iArr[AbstractC0358f.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2532a[AbstractC0358f.a.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2532a[AbstractC0358f.a.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C0436o(C0438p c0438p, R0 r02) {
        this.f2530a = (C0438p) Z1.m.o(c0438p, "tracer");
        this.f2531b = (R0) Z1.m.o(r02, com.amazon.a.a.h.a.f8463b);
    }

    public static void d(K2.K k4, AbstractC0358f.a aVar, String str) {
        Level levelF = f(aVar);
        if (C0438p.f2544f.isLoggable(levelF)) {
            C0438p.d(k4, levelF, str);
        }
    }

    public static void e(K2.K k4, AbstractC0358f.a aVar, String str, Object... objArr) {
        Level levelF = f(aVar);
        if (C0438p.f2544f.isLoggable(levelF)) {
            C0438p.d(k4, levelF, MessageFormat.format(str, objArr));
        }
    }

    public static Level f(AbstractC0358f.a aVar) {
        int i4 = a.f2532a[aVar.ordinal()];
        return (i4 == 1 || i4 == 2) ? Level.FINE : i4 != 3 ? Level.FINEST : Level.FINER;
    }

    public static F.b g(AbstractC0358f.a aVar) {
        int i4 = a.f2532a[aVar.ordinal()];
        return i4 != 1 ? i4 != 2 ? F.b.CT_INFO : F.b.CT_WARNING : F.b.CT_ERROR;
    }

    @Override // K2.AbstractC0358f
    public void a(AbstractC0358f.a aVar, String str) {
        d(this.f2530a.b(), aVar, str);
        if (c(aVar)) {
            h(aVar, str);
        }
    }

    @Override // K2.AbstractC0358f
    public void b(AbstractC0358f.a aVar, String str, Object... objArr) {
        a(aVar, (c(aVar) || C0438p.f2544f.isLoggable(f(aVar))) ? MessageFormat.format(str, objArr) : null);
    }

    public final boolean c(AbstractC0358f.a aVar) {
        return aVar != AbstractC0358f.a.DEBUG && this.f2530a.c();
    }

    public final void h(AbstractC0358f.a aVar, String str) {
        if (aVar == AbstractC0358f.a.DEBUG) {
            return;
        }
        this.f2530a.f(new F.a().b(str).c(g(aVar)).e(this.f2531b.a()).a());
    }
}
