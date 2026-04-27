package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class I {
    public static H a(Object obj, Object obj2) {
        H hC = (H) obj;
        H h6 = (H) obj2;
        if (!h6.isEmpty()) {
            if (!hC.f4487a) {
                hC = hC.c();
            }
            hC.a();
            if (!h6.isEmpty()) {
                hC.putAll(h6);
            }
        }
        return hC;
    }
}
