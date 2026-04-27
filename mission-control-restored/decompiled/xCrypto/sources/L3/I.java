package L3;

/* JADX INFO: loaded from: classes3.dex */
public final class I extends AbstractC0381d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public K3.h f1450f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(K3.a json, i3.k nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(nodeConsumer, "nodeConsumer");
        Y("primitive");
    }

    @Override // L3.AbstractC0381d
    public K3.h q0() {
        K3.h hVar = this.f1450f;
        if (hVar != null) {
            return hVar;
        }
        throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?");
    }

    @Override // L3.AbstractC0381d
    public void u0(String key, K3.h element) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(element, "element");
        if (key != "primitive") {
            throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag");
        }
        if (this.f1450f != null) {
            throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?");
        }
        this.f1450f = element;
        r0().invoke(element);
    }
}
