package s5;

import B5.o;
import java.io.Serializable;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: s5.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2712j implements InterfaceC2711i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2712j f23116a = new C2712j();

    @Override // s5.InterfaceC2711i
    public Object K(Object obj, o operation) {
        AbstractC2304t.f(operation, "operation");
        return obj;
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i.b a(InterfaceC2711i.c key) {
        AbstractC2304t.f(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i m0(InterfaceC2711i context) {
        AbstractC2304t.f(context, "context");
        return context;
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i r0(InterfaceC2711i.c key) {
        AbstractC2304t.f(key, "key");
        return this;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
