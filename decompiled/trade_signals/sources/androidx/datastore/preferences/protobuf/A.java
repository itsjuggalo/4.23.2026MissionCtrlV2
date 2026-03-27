package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC1122y f11128a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC1122y f11129b = new C1123z();

    public static InterfaceC1122y a() {
        return f11128a;
    }

    public static InterfaceC1122y b() {
        return f11129b;
    }

    public static InterfaceC1122y c() {
        if (U.f11176d) {
            return null;
        }
        try {
            return (InterfaceC1122y) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
