package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0334p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0333o f4589a = new C0333o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0333o f4590b;

    static {
        C0333o c0333o;
        S s6 = S.f4509c;
        try {
            c0333o = (C0333o) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            c0333o = null;
        }
        f4590b = c0333o;
    }
}
