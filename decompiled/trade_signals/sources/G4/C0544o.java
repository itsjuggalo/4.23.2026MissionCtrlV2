package G4;

import F4.AbstractC0492f;
import F4.E;
import java.text.MessageFormat;
import java.util.logging.Level;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0544o extends AbstractC0492f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0546p f3108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final R0 f3109b;

    /* JADX INFO: renamed from: G4.o$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3110a;

        static {
            int[] iArr = new int[AbstractC0492f.a.values().length];
            f3110a = iArr;
            try {
                iArr[AbstractC0492f.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3110a[AbstractC0492f.a.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3110a[AbstractC0492f.a.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C0544o(C0546p c0546p, R0 r02) {
        this.f3108a = (C0546p) AbstractC2848n.o(c0546p, "tracer");
        this.f3109b = (R0) AbstractC2848n.o(r02, com.amazon.a.a.h.a.f13759b);
    }

    public static void d(F4.J j8, AbstractC0492f.a aVar, String str) {
        Level levelF = f(aVar);
        if (C0546p.f3122f.isLoggable(levelF)) {
            C0546p.d(j8, levelF, str);
        }
    }

    public static void e(F4.J j8, AbstractC0492f.a aVar, String str, Object... objArr) {
        Level levelF = f(aVar);
        if (C0546p.f3122f.isLoggable(levelF)) {
            C0546p.d(j8, levelF, MessageFormat.format(str, objArr));
        }
    }

    public static Level f(AbstractC0492f.a aVar) {
        int i8 = a.f3110a[aVar.ordinal()];
        return (i8 == 1 || i8 == 2) ? Level.FINE : i8 != 3 ? Level.FINEST : Level.FINER;
    }

    public static E.b g(AbstractC0492f.a aVar) {
        int i8 = a.f3110a[aVar.ordinal()];
        return i8 != 1 ? i8 != 2 ? E.b.CT_INFO : E.b.CT_WARNING : E.b.CT_ERROR;
    }

    @Override // F4.AbstractC0492f
    public void a(AbstractC0492f.a aVar, String str) {
        d(this.f3108a.b(), aVar, str);
        if (c(aVar)) {
            h(aVar, str);
        }
    }

    @Override // F4.AbstractC0492f
    public void b(AbstractC0492f.a aVar, String str, Object... objArr) {
        a(aVar, (c(aVar) || C0546p.f3122f.isLoggable(f(aVar))) ? MessageFormat.format(str, objArr) : null);
    }

    public final boolean c(AbstractC0492f.a aVar) {
        return aVar != AbstractC0492f.a.DEBUG && this.f3108a.c();
    }

    public final void h(AbstractC0492f.a aVar, String str) {
        if (aVar == AbstractC0492f.a.DEBUG) {
            return;
        }
        this.f3108a.f(new E.a().b(str).c(g(aVar)).e(this.f3109b.a()).a());
    }
}
