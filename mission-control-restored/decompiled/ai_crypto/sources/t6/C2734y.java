package t6;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: t6.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2734y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f24339a = AbstractC2733x.a(16);

    /* JADX INFO: renamed from: t6.y$a */
    public static final class a {
    }

    public final Object a(p6.e descriptor, a key) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(key, "key");
        Map map = (Map) this.f24339a.get(descriptor);
        Object obj = map != null ? map.get(key) : null;
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public final Object b(p6.e descriptor, a key, Function0 defaultValue) {
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

    public final void c(p6.e descriptor, a key, Object value) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(value, "value");
        Map map = this.f24339a;
        Object objA = map.get(descriptor);
        if (objA == null) {
            objA = AbstractC2733x.a(2);
            map.put(descriptor, objA);
        }
        ((Map) objA).put(key, value);
    }
}
