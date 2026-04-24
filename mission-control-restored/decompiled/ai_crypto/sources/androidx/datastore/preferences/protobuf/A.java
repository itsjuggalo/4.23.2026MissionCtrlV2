package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC0953y f7316a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC0953y f7317b = new C0954z();

    public static InterfaceC0953y a() {
        return f7316a;
    }

    public static InterfaceC0953y b() {
        return f7317b;
    }

    public static InterfaceC0953y c() {
        if (U.f7364d) {
            return null;
        }
        try {
            return (InterfaceC0953y) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
