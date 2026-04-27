package H5;

import H5.g;
import Q5.o;
import java.io.Serializable;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements g, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f2671a = new h();

    @Override // H5.g
    public Object fold(Object obj, o operation) {
        r.f(operation, "operation");
        return obj;
    }

    @Override // H5.g
    public g.b get(g.c key) {
        r.f(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // H5.g
    public g minusKey(g.c key) {
        r.f(key, "key");
        return this;
    }

    @Override // H5.g
    public g plus(g context) {
        r.f(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
