package E4;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static float a(float f7, float f8, float f9, float f10) {
        float f11;
        float f12 = f7 / (f10 / 2.0f);
        float f13 = f9 / 2.0f;
        if (f12 < 1.0f) {
            f11 = f13 * f12 * f12 * f12;
        } else {
            float f14 = f12 - 2.0f;
            f11 = f13 * ((f14 * f14 * f14) + 2.0f);
        }
        return f11 + f8;
    }

    public static float b(float f7, float f8, float f9, float f10) {
        float f11 = (f7 / f10) - 1.0f;
        return (f9 * ((f11 * f11 * f11) + 1.0f)) + f8;
    }
}
