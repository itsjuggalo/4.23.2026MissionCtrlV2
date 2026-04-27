package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1114p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC1112n f11340a = new C1113o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1112n f11341b = c();

    public static AbstractC1112n a() {
        AbstractC1112n abstractC1112n = f11341b;
        if (abstractC1112n != null) {
            return abstractC1112n;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static AbstractC1112n b() {
        return f11340a;
    }

    public static AbstractC1112n c() {
        if (U.f11176d) {
            return null;
        }
        try {
            return (AbstractC1112n) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
