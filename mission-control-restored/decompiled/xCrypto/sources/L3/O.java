package L3;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class O extends AbstractC0381d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f1462f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(K3.a json, i3.k nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(nodeConsumer, "nodeConsumer");
        this.f1462f = new ArrayList();
    }

    @Override // L3.AbstractC0381d, J3.T
    public String a0(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return String.valueOf(i4);
    }

    @Override // L3.AbstractC0381d
    public K3.h q0() {
        return new K3.b(this.f1462f);
    }

    @Override // L3.AbstractC0381d
    public void u0(String key, K3.h element) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(element, "element");
        this.f1462f.add(Integer.parseInt(key), element);
    }
}
