package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final eh.c f9597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9599i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(eh.b json, eh.c value) {
        super(json, value, null, 4, null);
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(value, "value");
        this.f9597g = value;
        this.f9598h = z0().size();
        this.f9599i = -1;
    }

    @Override // fh.c
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public eh.c z0() {
        return this.f9597g;
    }

    @Override // dh.t0
    public String f0(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return String.valueOf(i10);
    }

    @Override // fh.c
    public eh.i l0(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        return z0().get(Integer.parseInt(tag));
    }

    @Override // ch.c
    public int w(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        int i10 = this.f9599i;
        if (i10 >= this.f9598h - 1) {
            return -1;
        }
        int i11 = i10 + 1;
        this.f9599i = i11;
        return i11;
    }
}
