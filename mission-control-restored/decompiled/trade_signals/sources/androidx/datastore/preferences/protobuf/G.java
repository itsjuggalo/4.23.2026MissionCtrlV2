package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E f11143a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final E f11144b = new F();

    public static E a() {
        return f11143a;
    }

    public static E b() {
        return f11144b;
    }

    public static E c() {
        if (U.f11176d) {
            return null;
        }
        try {
            return (E) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
