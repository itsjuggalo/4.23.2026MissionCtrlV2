package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final O f11169a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final O f11170b = new P();

    public static O a() {
        return f11169a;
    }

    public static O b() {
        return f11170b;
    }

    public static O c() {
        if (U.f11176d) {
            return null;
        }
        try {
            return (O) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
