package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final I f4488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final I f4489b;

    static {
        I i;
        S s6 = S.f4509c;
        try {
            i = (I) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            i = null;
        }
        f4488a = i;
        f4489b = new I();
    }
}
