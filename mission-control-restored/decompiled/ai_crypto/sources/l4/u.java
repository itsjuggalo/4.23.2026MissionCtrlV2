package l4;

import java.io.IOException;
import java.math.BigDecimal;
import n4.AbstractC2256A;
import n4.y;
import t4.C2657a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f18394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f18395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f18396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f18397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ u[] f18398e;

    public enum a extends u {
        public a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // l4.v
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(C2657a c2657a) {
            return Double.valueOf(c2657a.D0());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        f18394a = aVar;
        u uVar = new u("LAZILY_PARSED_NUMBER", 1) { // from class: l4.u.b
            {
                a aVar2 = null;
            }

            @Override // l4.v
            public Number a(C2657a c2657a) {
                return new y(c2657a.K0());
            }
        };
        f18395b = uVar;
        u uVar2 = new u("LONG_OR_DOUBLE", 2) { // from class: l4.u.c
            {
                a aVar2 = null;
            }

            @Override // l4.v
            public Number a(C2657a c2657a) throws IOException {
                String strK0 = c2657a.K0();
                if (strK0.indexOf(46) >= 0) {
                    return b(strK0, c2657a);
                }
                try {
                    return Long.valueOf(Long.parseLong(strK0));
                } catch (NumberFormatException unused) {
                    return b(strK0, c2657a);
                }
            }

            public final Number b(String str, C2657a c2657a) throws t4.d {
                try {
                    Double dValueOf = Double.valueOf(str);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        if (!c2657a.z0()) {
                            throw new t4.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + c2657a.c0());
                        }
                    }
                    return dValueOf;
                } catch (NumberFormatException e7) {
                    throw new n("Cannot parse " + str + "; at path " + c2657a.c0(), e7);
                }
            }
        };
        f18396c = uVar2;
        u uVar3 = new u("BIG_DECIMAL", 3) { // from class: l4.u.d
            {
                a aVar2 = null;
            }

            @Override // l4.v
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(C2657a c2657a) throws IOException {
                String strK0 = c2657a.K0();
                try {
                    return AbstractC2256A.b(strK0);
                } catch (NumberFormatException e7) {
                    throw new n("Cannot parse " + strK0 + "; at path " + c2657a.c0(), e7);
                }
            }
        };
        f18397d = uVar3;
        f18398e = new u[]{aVar, uVar, uVar2, uVar3};
    }

    public u(String str, int i7) {
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f18398e.clone();
    }

    public /* synthetic */ u(String str, int i7, a aVar) {
        this(str, i7);
    }
}
