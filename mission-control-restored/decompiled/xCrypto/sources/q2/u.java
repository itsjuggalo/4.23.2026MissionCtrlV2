package q2;

import java.io.IOException;
import java.math.BigDecimal;
import s2.AbstractC1768A;
import s2.y;
import y2.C1946a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f14286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f14287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f14288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f14289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ u[] f14290e;

    public enum a extends u {
        public a(String str, int i4) {
            super(str, i4, null);
        }

        @Override // q2.v
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Double a(C1946a c1946a) {
            return Double.valueOf(c1946a.i0());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        f14286a = aVar;
        u uVar = new u("LAZILY_PARSED_NUMBER", 1) { // from class: q2.u.b
            {
                a aVar2 = null;
            }

            @Override // q2.v
            public Number a(C1946a c1946a) {
                return new y(c1946a.p0());
            }
        };
        f14287b = uVar;
        u uVar2 = new u("LONG_OR_DOUBLE", 2) { // from class: q2.u.c
            {
                a aVar2 = null;
            }

            @Override // q2.v
            public Number a(C1946a c1946a) throws IOException {
                String strP0 = c1946a.p0();
                if (strP0.indexOf(46) >= 0) {
                    return c(strP0, c1946a);
                }
                try {
                    return Long.valueOf(Long.parseLong(strP0));
                } catch (NumberFormatException unused) {
                    return c(strP0, c1946a);
                }
            }

            public final Number c(String str, C1946a c1946a) throws y2.d {
                try {
                    Double dValueOf = Double.valueOf(str);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        if (!c1946a.e0()) {
                            throw new y2.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + c1946a.S());
                        }
                    }
                    return dValueOf;
                } catch (NumberFormatException e4) {
                    throw new n("Cannot parse " + str + "; at path " + c1946a.S(), e4);
                }
            }
        };
        f14288c = uVar2;
        u uVar3 = new u("BIG_DECIMAL", 3) { // from class: q2.u.d
            {
                a aVar2 = null;
            }

            @Override // q2.v
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(C1946a c1946a) throws IOException {
                String strP0 = c1946a.p0();
                try {
                    return AbstractC1768A.b(strP0);
                } catch (NumberFormatException e4) {
                    throw new n("Cannot parse " + strP0 + "; at path " + c1946a.S(), e4);
                }
            }
        };
        f14289d = uVar3;
        f14290e = new u[]{aVar, uVar, uVar2, uVar3};
    }

    public u(String str, int i4) {
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f14290e.clone();
    }

    public /* synthetic */ u(String str, int i4, a aVar) {
        this(str, i4);
    }
}
