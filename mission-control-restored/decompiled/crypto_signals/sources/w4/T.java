package w4;

/* JADX INFO: loaded from: classes.dex */
public final class T extends u4.e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f11107a;

    static {
        boolean z6 = false;
        try {
            Class.forName("android.app.Application", false, T.class.getClassLoader());
            z6 = true;
        } catch (Exception unused) {
        }
        f11107a = z6;
    }
}
