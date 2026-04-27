package s3;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static final double a(double d4, d sourceUnit, d targetUnit) {
        r.f(sourceUnit, "sourceUnit");
        r.f(targetUnit, "targetUnit");
        long jConvert = targetUnit.c().convert(1L, sourceUnit.c());
        return jConvert > 0 ? d4 * jConvert : d4 / sourceUnit.c().convert(1L, targetUnit.c());
    }

    public static final long b(long j4, d sourceUnit, d targetUnit) {
        r.f(sourceUnit, "sourceUnit");
        r.f(targetUnit, "targetUnit");
        return targetUnit.c().convert(j4, sourceUnit.c());
    }

    public static final long c(long j4, d sourceUnit, d targetUnit) {
        r.f(sourceUnit, "sourceUnit");
        r.f(targetUnit, "targetUnit");
        return targetUnit.c().convert(j4, sourceUnit.c());
    }
}
