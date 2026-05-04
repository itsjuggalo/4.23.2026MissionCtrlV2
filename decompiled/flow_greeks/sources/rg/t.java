package rg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements gd.e, id.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gd.e f19916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gd.i f19917b;

    public t(gd.e eVar, gd.i iVar) {
        this.f19916a = eVar;
        this.f19917b = iVar;
    }

    @Override // id.e
    public id.e getCallerFrame() {
        gd.e eVar = this.f19916a;
        if (eVar instanceof id.e) {
            return (id.e) eVar;
        }
        return null;
    }

    @Override // gd.e
    public gd.i getContext() {
        return this.f19917b;
    }

    @Override // gd.e
    public void resumeWith(Object obj) {
        this.f19916a.resumeWith(obj);
    }
}
