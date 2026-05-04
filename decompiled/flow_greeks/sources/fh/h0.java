package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public eh.i f9582g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(eh.b json, pd.k nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(nodeConsumer, "nodeConsumer");
        Y("primitive");
    }

    @Override // fh.e
    public eh.i r0() {
        eh.i iVar = this.f9582g;
        if (iVar != null) {
            return iVar;
        }
        throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?");
    }

    @Override // fh.e
    public void v0(String key, eh.i element) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(element, "element");
        if (key != "primitive") {
            throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag");
        }
        if (this.f9582g != null) {
            throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?");
        }
        this.f9582g = element;
        s0().invoke(element);
    }
}
