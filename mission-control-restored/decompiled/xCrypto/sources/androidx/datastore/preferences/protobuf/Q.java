package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final O f6949a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final O f6950b = new P();

    public static O a() {
        return f6949a;
    }

    public static O b() {
        return f6950b;
    }

    public static O c() {
        if (U.f6956d) {
            return null;
        }
        try {
            return (O) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
