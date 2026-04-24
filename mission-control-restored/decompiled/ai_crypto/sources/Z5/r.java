package Z5;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends q {
    public static Double f(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        try {
            if (k.f6047b.b(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float g(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        try {
            if (k.f6047b.b(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
