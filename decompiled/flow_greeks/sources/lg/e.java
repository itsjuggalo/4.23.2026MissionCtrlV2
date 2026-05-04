package lg;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static final double a(double d10, d sourceUnit, d targetUnit) {
        t.f(sourceUnit, "sourceUnit");
        t.f(targetUnit, "targetUnit");
        long jConvert = targetUnit.b().convert(1L, sourceUnit.b());
        return jConvert > 0 ? d10 * jConvert : d10 / sourceUnit.b().convert(1L, targetUnit.b());
    }

    public static final long b(long j10, d sourceUnit, d targetUnit) {
        t.f(sourceUnit, "sourceUnit");
        t.f(targetUnit, "targetUnit");
        return targetUnit.b().convert(j10, sourceUnit.b());
    }

    public static final long c(long j10, d sourceUnit, d targetUnit) {
        t.f(sourceUnit, "sourceUnit");
        t.f(targetUnit, "targetUnit");
        return targetUnit.b().convert(j10, sourceUnit.b());
    }
}
