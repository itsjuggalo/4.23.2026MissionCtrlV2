package fh;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class l0 extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f9593g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(eh.b json, pd.k nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(nodeConsumer, "nodeConsumer");
        this.f9593g = new LinkedHashMap();
    }

    @Override // dh.a2, ch.d
    public void e(bh.e descriptor, int i10, zg.k serializer, Object obj) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(serializer, "serializer");
        if (obj != null || this.f9566d.j()) {
            super.e(descriptor, i10, serializer, obj);
        }
    }

    @Override // fh.e
    public eh.i r0() {
        return new eh.c0(this.f9593g);
    }

    @Override // fh.e
    public void v0(String key, eh.i element) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(element, "element");
        this.f9593g.put(key, element);
    }

    public final Map w0() {
        return this.f9593g;
    }
}
