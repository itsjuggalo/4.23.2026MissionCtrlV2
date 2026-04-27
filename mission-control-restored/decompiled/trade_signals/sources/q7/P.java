package q7;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import p7.AbstractC2609b;

/* JADX INFO: loaded from: classes2.dex */
public class P extends AbstractC2647e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f22810g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(AbstractC2609b json, B5.k nodeConsumer) {
        super(json, nodeConsumer, null);
        AbstractC2304t.f(json, "json");
        AbstractC2304t.f(nodeConsumer, "nodeConsumer");
        this.f22810g = new LinkedHashMap();
    }

    @Override // q7.AbstractC2647e
    public p7.i r0() {
        return new p7.C(this.f22810g);
    }

    @Override // o7.B0, n7.d
    public void u(m7.e descriptor, int i8, k7.k serializer, Object obj) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(serializer, "serializer");
        if (obj != null || this.f22871d.j()) {
            super.u(descriptor, i8, serializer, obj);
        }
    }

    @Override // q7.AbstractC2647e
    public void v0(String key, p7.i element) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(element, "element");
        this.f22810g.put(key, element);
    }

    public final Map w0() {
        return this.f22810g;
    }
}
