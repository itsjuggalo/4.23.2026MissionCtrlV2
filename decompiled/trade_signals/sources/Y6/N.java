package Y6;

import o5.C2487o;
import s5.AbstractC2709g;
import s5.InterfaceC2707e;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final N f9632a = new N("DEFAULT", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final N f9633b = new N("LAZY", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final N f9634c = new N("ATOMIC", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final N f9635d = new N("UNDISPATCHED", 3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ N[] f9636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f9637f;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9638a;

        static {
            int[] iArr = new int[N.values().length];
            try {
                iArr[N.f9632a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[N.f9634c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[N.f9635d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[N.f9633b.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f9638a = iArr;
        }
    }

    static {
        N[] nArrA = a();
        f9636e = nArrA;
        f9637f = AbstractC2875b.a(nArrA);
    }

    public N(String str, int i8) {
    }

    public static final /* synthetic */ N[] a() {
        return new N[]{f9632a, f9633b, f9634c, f9635d};
    }

    public static N valueOf(String str) {
        return (N) Enum.valueOf(N.class, str);
    }

    public static N[] values() {
        return (N[]) f9636e.clone();
    }

    public final void b(B5.o oVar, Object obj, InterfaceC2707e interfaceC2707e) {
        int i8 = a.f9638a[ordinal()];
        if (i8 == 1) {
            e7.a.b(oVar, obj, interfaceC2707e);
            return;
        }
        if (i8 == 2) {
            AbstractC2709g.a(oVar, obj, interfaceC2707e);
        } else if (i8 == 3) {
            e7.b.a(oVar, obj, interfaceC2707e);
        } else if (i8 != 4) {
            throw new C2487o();
        }
    }

    public final boolean g() {
        return this == f9633b;
    }
}
