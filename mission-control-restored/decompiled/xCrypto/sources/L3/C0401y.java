package L3;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: L3.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0401y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f1546a = AbstractC0400x.a(16);

    /* JADX INFO: renamed from: L3.y$a */
    public static final class a {
    }

    public final Object a(H3.e descriptor, a key) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(key, "key");
        Map map = (Map) this.f1546a.get(descriptor);
        Object obj = map != null ? map.get(key) : null;
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public final Object b(H3.e descriptor, a key, Function0 defaultValue) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(defaultValue, "defaultValue");
        Object objA = a(descriptor, key);
        if (objA != null) {
            return objA;
        }
        Object objInvoke = defaultValue.invoke();
        c(descriptor, key, objInvoke);
        return objInvoke;
    }

    public final void c(H3.e descriptor, a key, Object value) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(value, "value");
        Map map = this.f1546a;
        Object objA = map.get(descriptor);
        if (objA == null) {
            objA = AbstractC0400x.a(2);
            map.put(descriptor, objA);
        }
        ((Map) objA).put(key, value);
    }
}
