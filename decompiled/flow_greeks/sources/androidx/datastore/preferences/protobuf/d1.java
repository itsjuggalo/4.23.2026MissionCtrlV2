package androidx.datastore.preferences.protobuf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d1 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1680a;

    public d1(j0 j0Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f1680a = null;
    }

    public v a() {
        return new v(getMessage());
    }
}
