package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC0811y f6908a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC0811y f6909b = new C0812z();

    public static InterfaceC0811y a() {
        return f6908a;
    }

    public static InterfaceC0811y b() {
        return f6909b;
    }

    public static InterfaceC0811y c() {
        if (U.f6956d) {
            return null;
        }
        try {
            return (InterfaceC0811y) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
