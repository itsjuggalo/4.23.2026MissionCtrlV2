package Z2;

import Z2.i;
import i3.o;
import java.io.Serializable;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f6012a = new j();

    @Override // Z2.i
    public Object fold(Object obj, o operation) {
        r.f(operation, "operation");
        return obj;
    }

    @Override // Z2.i
    public i.b get(i.c key) {
        r.f(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // Z2.i
    public i minusKey(i.c key) {
        r.f(key, "key");
        return this;
    }

    @Override // Z2.i
    public i plus(i context) {
        r.f(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
