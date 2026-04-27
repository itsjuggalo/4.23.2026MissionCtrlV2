package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final O f4507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final O f4508b;

    static {
        O o3;
        S s6 = S.f4509c;
        try {
            o3 = (O) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            o3 = null;
        }
        f4507a = o3;
        f4508b = new O();
    }
}
