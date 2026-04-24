package a6;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static final double a(double d7, d sourceUnit, d targetUnit) {
        r.f(sourceUnit, "sourceUnit");
        r.f(targetUnit, "targetUnit");
        long jConvert = targetUnit.b().convert(1L, sourceUnit.b());
        return jConvert > 0 ? d7 * jConvert : d7 / sourceUnit.b().convert(1L, targetUnit.b());
    }

    public static final long b(long j7, d sourceUnit, d targetUnit) {
        r.f(sourceUnit, "sourceUnit");
        r.f(targetUnit, "targetUnit");
        return targetUnit.b().convert(j7, sourceUnit.b());
    }

    public static final long c(long j7, d sourceUnit, d targetUnit) {
        r.f(sourceUnit, "sourceUnit");
        r.f(targetUnit, "targetUnit");
        return targetUnit.b().convert(j7, sourceUnit.b());
    }
}
