package r3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v extends u {
    public static Double j(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        try {
            if (m.f14598b.b(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    public static Float k(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        try {
            if (m.f14598b.b(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}
