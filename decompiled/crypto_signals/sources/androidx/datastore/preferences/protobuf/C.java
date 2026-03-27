package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B f4477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final B f4478b;

    static {
        B b3;
        S s6 = S.f4509c;
        try {
            b3 = (B) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            b3 = null;
        }
        f4477a = b3;
        f4478b = new B();
    }
}
