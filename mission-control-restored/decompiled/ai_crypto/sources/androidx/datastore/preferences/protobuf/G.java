package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E f7331a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final E f7332b = new F();

    public static E a() {
        return f7331a;
    }

    public static E b() {
        return f7332b;
    }

    public static E c() {
        if (U.f7364d) {
            return null;
        }
        try {
            return (E) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
