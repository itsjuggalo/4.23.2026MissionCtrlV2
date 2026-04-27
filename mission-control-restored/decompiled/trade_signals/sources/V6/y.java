package V6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y extends x {
    public static Double k(String str) {
        AbstractC2304t.f(str, "<this>");
        try {
            if (p.f9021b.b(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float l(String str) {
        AbstractC2304t.f(str, "<this>");
        try {
            if (p.f9021b.b(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
