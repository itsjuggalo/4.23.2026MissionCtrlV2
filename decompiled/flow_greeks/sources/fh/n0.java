package fh;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f9602g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(eh.b json, pd.k nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(nodeConsumer, "nodeConsumer");
        this.f9602g = new ArrayList();
    }

    @Override // fh.e, dh.u0
    public String a0(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return String.valueOf(i10);
    }

    @Override // fh.e
    public eh.i r0() {
        return new eh.c(this.f9602g);
    }

    @Override // fh.e
    public void v0(String key, eh.i element) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(element, "element");
        this.f9602g.add(Integer.parseInt(key), element);
    }
}
