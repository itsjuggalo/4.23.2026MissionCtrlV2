package gd;

import gd.i;
import java.io.Serializable;
import kotlin.jvm.internal.t;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f10531a = new j();

    @Override // gd.i
    public Object fold(Object obj, o operation) {
        t.f(operation, "operation");
        return obj;
    }

    @Override // gd.i
    public i.b get(i.c key) {
        t.f(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // gd.i
    public i minusKey(i.c key) {
        t.f(key, "key");
        return this;
    }

    @Override // gd.i
    public i plus(i context) {
        t.f(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
