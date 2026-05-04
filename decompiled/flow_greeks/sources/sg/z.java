package sg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class z extends ng.a implements id.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gd.e f20435d;

    public z(gd.i iVar, gd.e eVar) {
        super(iVar, true, true);
        this.f20435d = eVar;
    }

    @Override // ng.a
    public void K0(Object obj) {
        gd.e eVar = this.f20435d;
        eVar.resumeWith(ng.e0.a(obj, eVar));
    }

    @Override // ng.e2
    public final boolean g0() {
        return true;
    }

    @Override // id.e
    public final id.e getCallerFrame() {
        gd.e eVar = this.f20435d;
        if (eVar instanceof id.e) {
            return (id.e) eVar;
        }
        return null;
    }

    @Override // ng.e2
    public void x(Object obj) {
        i.b(hd.b.c(this.f20435d), ng.e0.a(obj, this.f20435d));
    }
}
