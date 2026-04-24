package q7;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: q7.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2667z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f22904a = AbstractC2666y.a(16);

    /* JADX INFO: renamed from: q7.z$a */
    public static final class a {
    }

    public final Object a(m7.e descriptor, a key) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(key, "key");
        Map map = (Map) this.f22904a.get(descriptor);
        Object obj = map != null ? map.get(key) : null;
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public final Object b(m7.e descriptor, a key, Function0 defaultValue) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(defaultValue, "defaultValue");
        Object objA = a(descriptor, key);
        if (objA != null) {
            return objA;
        }
        Object objInvoke = defaultValue.invoke();
        c(descriptor, key, objInvoke);
        return objInvoke;
    }

    public final void c(m7.e descriptor, a key, Object value) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(value, "value");
        Map map = this.f22904a;
        Object objA = map.get(descriptor);
        if (objA == null) {
            objA = AbstractC2666y.a(2);
            map.put(descriptor, objA);
        }
        ((Map) objA).put(key, value);
    }
}
