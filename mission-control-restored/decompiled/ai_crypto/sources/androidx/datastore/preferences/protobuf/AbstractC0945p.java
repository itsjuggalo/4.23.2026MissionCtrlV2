package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0945p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0943n f7528a = new C0944o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0943n f7529b = c();

    public static AbstractC0943n a() {
        AbstractC0943n abstractC0943n = f7529b;
        if (abstractC0943n != null) {
            return abstractC0943n;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static AbstractC0943n b() {
        return f7528a;
    }

    public static AbstractC0943n c() {
        if (U.f7364d) {
            return null;
        }
        try {
            return (AbstractC0943n) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
