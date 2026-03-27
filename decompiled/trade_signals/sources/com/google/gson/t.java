package com.google.gson;

import com.google.gson.internal.x;
import com.google.gson.internal.z;
import java.io.IOException;
import java.math.BigDecimal;
import p4.C2568a;
import p4.C2571d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class t implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f16267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f16268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f16269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f16270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ t[] f16271e;

    public enum a extends t {
        public a(String str, int i8) {
            super(str, i8, null);
        }

        @Override // com.google.gson.u
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(C2568a c2568a) {
            return Double.valueOf(c2568a.W());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        f16267a = aVar;
        t tVar = new t("LAZILY_PARSED_NUMBER", 1) { // from class: com.google.gson.t.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.u
            public Number a(C2568a c2568a) {
                return new x(c2568a.v0());
            }
        };
        f16268b = tVar;
        t tVar2 = new t("LONG_OR_DOUBLE", 2) { // from class: com.google.gson.t.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.u
            public Number a(C2568a c2568a) throws IOException {
                String strV0 = c2568a.v0();
                if (strV0.indexOf(46) >= 0) {
                    return b(strV0, c2568a);
                }
                try {
                    return Long.valueOf(Long.parseLong(strV0));
                } catch (NumberFormatException unused) {
                    return b(strV0, c2568a);
                }
            }

            public final Number b(String str, C2568a c2568a) throws C2571d {
                try {
                    Double dValueOf = Double.valueOf(str);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        if (!c2568a.R()) {
                            throw new C2571d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + c2568a.N());
                        }
                    }
                    return dValueOf;
                } catch (NumberFormatException e8) {
                    throw new m("Cannot parse " + str + "; at path " + c2568a.N(), e8);
                }
            }
        };
        f16269c = tVar2;
        t tVar3 = new t("BIG_DECIMAL", 3) { // from class: com.google.gson.t.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.u
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(C2568a c2568a) throws IOException {
                String strV0 = c2568a.v0();
                try {
                    return z.b(strV0);
                } catch (NumberFormatException e8) {
                    throw new m("Cannot parse " + strV0 + "; at path " + c2568a.N(), e8);
                }
            }
        };
        f16270d = tVar3;
        f16271e = new t[]{aVar, tVar, tVar2, tVar3};
    }

    public t(String str, int i8) {
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f16271e.clone();
    }

    public /* synthetic */ t(String str, int i8, a aVar) {
        this(str, i8);
    }
}
