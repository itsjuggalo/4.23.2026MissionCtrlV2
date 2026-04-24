package L3;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class M extends AbstractC0381d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f1458f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(K3.a json, i3.k nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(nodeConsumer, "nodeConsumer");
        this.f1458f = new LinkedHashMap();
    }

    @Override // J3.q0, I3.d
    public void E(H3.e descriptor, int i4, F3.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (obj != null || this.f1517d.f()) {
            super.E(descriptor, i4, serializer, obj);
        }
    }

    @Override // L3.AbstractC0381d
    public K3.h q0() {
        return new K3.u(this.f1458f);
    }

    @Override // L3.AbstractC0381d
    public void u0(String key, K3.h element) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(element, "element");
        this.f1458f.put(key, element);
    }

    public final Map v0() {
        return this.f1458f;
    }
}
