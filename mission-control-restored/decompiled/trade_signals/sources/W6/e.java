package W6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static final double a(double d8, d sourceUnit, d targetUnit) {
        AbstractC2304t.f(sourceUnit, "sourceUnit");
        AbstractC2304t.f(targetUnit, "targetUnit");
        long jConvert = targetUnit.b().convert(1L, sourceUnit.b());
        return jConvert > 0 ? d8 * jConvert : d8 / sourceUnit.b().convert(1L, targetUnit.b());
    }

    public static final long b(long j8, d sourceUnit, d targetUnit) {
        AbstractC2304t.f(sourceUnit, "sourceUnit");
        AbstractC2304t.f(targetUnit, "targetUnit");
        return targetUnit.b().convert(j8, sourceUnit.b());
    }

    public static final long c(long j8, d sourceUnit, d targetUnit) {
        AbstractC2304t.f(sourceUnit, "sourceUnit");
        AbstractC2304t.f(targetUnit, "targetUnit");
        return targetUnit.b().convert(j8, sourceUnit.b());
    }
}
