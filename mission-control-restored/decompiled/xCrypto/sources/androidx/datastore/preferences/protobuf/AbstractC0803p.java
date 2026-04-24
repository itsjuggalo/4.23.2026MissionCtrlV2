package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0803p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0801n f7120a = new C0802o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0801n f7121b = c();

    public static AbstractC0801n a() {
        AbstractC0801n abstractC0801n = f7121b;
        if (abstractC0801n != null) {
            return abstractC0801n;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static AbstractC0801n b() {
        return f7120a;
    }

    public static AbstractC0801n c() {
        if (U.f6956d) {
            return null;
        }
        try {
            return (AbstractC0801n) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
