package androidx.datastore.preferences.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e0 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11213a;

    public e0(J j8) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f11213a = null;
    }

    public C1119v a() {
        return new C1119v(getMessage());
    }
}
