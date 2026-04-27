package q4;

/* JADX INFO: loaded from: classes.dex */
public final class n implements d5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d5.e f9352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ T.e f9353c;

    public /* synthetic */ n(d5.e eVar, T.e eVar2, int i) {
        this.f9351a = i;
        this.f9352b = eVar;
        this.f9353c = eVar2;
    }

    @Override // d5.e
    public final Object e(d5.f fVar, I4.d dVar) {
        switch (this.f9351a) {
            case 0:
                Object objE = this.f9352b.e(new C0957m(fVar, this.f9353c, 0), dVar);
                if (objE != J4.a.f791a) {
                    break;
                }
                break;
            case 1:
                Object objE2 = this.f9352b.e(new C0957m(fVar, this.f9353c, 1), dVar);
                if (objE2 != J4.a.f791a) {
                    break;
                }
                break;
            case 2:
                Object objE3 = this.f9352b.e(new C0957m(fVar, this.f9353c, 2), dVar);
                if (objE3 != J4.a.f791a) {
                    break;
                }
                break;
            default:
                Object objE4 = this.f9352b.e(new C0957m(fVar, this.f9353c, 3), dVar);
                if (objE4 != J4.a.f791a) {
                    break;
                }
                break;
        }
        return G4.l.f540a;
    }
}
