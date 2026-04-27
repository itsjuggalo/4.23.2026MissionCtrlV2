package L3;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Q extends M {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1468h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(K3.a json, i3.k nodeConsumer) {
        super(json, nodeConsumer);
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(nodeConsumer, "nodeConsumer");
        this.f1468h = true;
    }

    @Override // L3.M, L3.AbstractC0381d
    public K3.h q0() {
        return new K3.u(v0());
    }

    @Override // L3.M, L3.AbstractC0381d
    public void u0(String key, K3.h element) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(element, "element");
        if (!this.f1468h) {
            Map mapV0 = v0();
            String str = this.f1467g;
            if (str == null) {
                kotlin.jvm.internal.r.t("tag");
                str = null;
            }
            mapV0.put(str, element);
            this.f1468h = true;
            return;
        }
        if (element instanceof K3.w) {
            this.f1467g = ((K3.w) element).f();
            this.f1468h = false;
        } else {
            if (element instanceof K3.u) {
                throw E.d(K3.v.f1383a.getDescriptor());
            }
            if (!(element instanceof K3.b)) {
                throw new W2.m();
            }
            throw E.d(K3.c.f1331a.getDescriptor());
        }
    }
}
