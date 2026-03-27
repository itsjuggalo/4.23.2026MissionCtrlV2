package s6;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class v extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f23223a;

    public v(p pVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f23223a = null;
    }

    public C2724k a() {
        return new C2724k(getMessage());
    }
}
