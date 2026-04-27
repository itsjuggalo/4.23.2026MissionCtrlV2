package p3;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final Object a(InterfaceC1716c interfaceC1716c, Object obj) {
        r.f(interfaceC1716c, "<this>");
        if (interfaceC1716c.c(obj)) {
            r.d(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + interfaceC1716c.a());
    }
}
