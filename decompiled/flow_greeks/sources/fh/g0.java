package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final eh.i f9581g;

    public /* synthetic */ g0(eh.b bVar, eh.i iVar, String str, int i10, kotlin.jvm.internal.k kVar) {
        this(bVar, iVar, (i10 & 4) != 0 ? null : str);
    }

    @Override // fh.c
    public eh.i l0(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        if (tag == "primitive") {
            return z0();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag");
    }

    @Override // ch.c
    public int w(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return 0;
    }

    @Override // fh.c
    public eh.i z0() {
        return this.f9581g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(eh.b json, eh.i value, String str) {
        super(json, value, str, null);
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(value, "value");
        this.f9581g = value;
        c0("primitive");
    }
}
