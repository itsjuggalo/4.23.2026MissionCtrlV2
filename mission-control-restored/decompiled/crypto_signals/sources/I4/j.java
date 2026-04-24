package I4;

import R4.p;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class j implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f650a = new j();

    @Override // I4.i
    public final g get(h key) {
        kotlin.jvm.internal.j.e(key, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // I4.i
    public final i minusKey(h key) {
        kotlin.jvm.internal.j.e(key, "key");
        return this;
    }

    @Override // I4.i
    public final i plus(i context) {
        kotlin.jvm.internal.j.e(context, "context");
        return context;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // I4.i
    public final Object fold(Object obj, p pVar) {
        return obj;
    }
}
