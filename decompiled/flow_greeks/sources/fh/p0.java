package fh;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends l0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9609i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(eh.b json, pd.k nodeConsumer) {
        super(json, nodeConsumer);
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(nodeConsumer, "nodeConsumer");
        this.f9609i = true;
    }

    @Override // fh.l0, fh.e
    public eh.i r0() {
        return new eh.c0(w0());
    }

    @Override // fh.l0, fh.e
    public void v0(String key, eh.i element) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(element, "element");
        if (!this.f9609i) {
            Map mapW0 = w0();
            String str = this.f9608h;
            if (str == null) {
                kotlin.jvm.internal.t.s("tag");
                str = null;
            }
            mapW0.put(str, element);
            this.f9609i = true;
            return;
        }
        if (element instanceof eh.e0) {
            this.f9608h = ((eh.e0) element).a();
            this.f9609i = false;
        } else {
            if (element instanceof eh.c0) {
                throw c0.d(eh.d0.f8983a.getDescriptor());
            }
            if (!(element instanceof eh.c)) {
                throw new cd.o();
            }
            throw c0.d(eh.d.f8978a.getDescriptor());
        }
    }
}
