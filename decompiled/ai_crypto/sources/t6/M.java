package t6;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class M extends AbstractC2714d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f24251f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(s6.a json, Q5.k nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(nodeConsumer, "nodeConsumer");
        this.f24251f = new LinkedHashMap();
    }

    @Override // t6.AbstractC2714d
    public s6.h q0() {
        return new s6.u(this.f24251f);
    }

    @Override // r6.q0, q6.d
    public void r(p6.e descriptor, int i7, n6.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (obj != null || this.f24310d.f()) {
            super.r(descriptor, i7, serializer, obj);
        }
    }

    @Override // t6.AbstractC2714d
    public void u0(String key, s6.h element) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(element, "element");
        this.f24251f.put(key, element);
    }

    public final Map v0() {
        return this.f24251f;
    }
}
