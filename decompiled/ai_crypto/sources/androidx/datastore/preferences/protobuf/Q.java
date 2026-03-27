package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final O f7357a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final O f7358b = new P();

    public static O a() {
        return f7357a;
    }

    public static O b() {
        return f7358b;
    }

    public static O c() {
        if (U.f7364d) {
            return null;
        }
        try {
            return (O) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
