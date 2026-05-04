package com.google.gson;

import com.google.gson.internal.x;
import com.google.gson.internal.z;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f6891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f6892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f6893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f6894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ t[] f6895e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a extends t {
        public a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.gson.u
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(gb.a aVar) {
            return Double.valueOf(aVar.e0());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        f6891a = aVar;
        t tVar = new t("LAZILY_PARSED_NUMBER", 1) { // from class: com.google.gson.t.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.u
            public Number a(gb.a aVar2) {
                return new x(aVar2.l0());
            }
        };
        f6892b = tVar;
        t tVar2 = new t("LONG_OR_DOUBLE", 2) { // from class: com.google.gson.t.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.u
            public Number a(gb.a aVar2) throws IOException {
                String strL0 = aVar2.l0();
                if (strL0.indexOf(46) >= 0) {
                    return b(strL0, aVar2);
                }
                try {
                    return Long.valueOf(Long.parseLong(strL0));
                } catch (NumberFormatException unused) {
                    return b(strL0, aVar2);
                }
            }

            public final Number b(String str, gb.a aVar2) throws gb.d {
                try {
                    Double dValueOf = Double.valueOf(str);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        if (!aVar2.a0()) {
                            throw new gb.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar2.O());
                        }
                    }
                    return dValueOf;
                } catch (NumberFormatException e10) {
                    throw new m("Cannot parse " + str + "; at path " + aVar2.O(), e10);
                }
            }
        };
        f6893c = tVar2;
        t tVar3 = new t("BIG_DECIMAL", 3) { // from class: com.google.gson.t.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.u
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(gb.a aVar2) throws IOException {
                String strL0 = aVar2.l0();
                try {
                    return z.b(strL0);
                } catch (NumberFormatException e10) {
                    throw new m("Cannot parse " + strL0 + "; at path " + aVar2.O(), e10);
                }
            }
        };
        f6894d = tVar3;
        f6895e = new t[]{aVar, tVar, tVar2, tVar3};
    }

    public t(String str, int i10) {
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f6895e.clone();
    }

    public /* synthetic */ t(String str, int i10, a aVar) {
        this(str, i10);
    }
}
