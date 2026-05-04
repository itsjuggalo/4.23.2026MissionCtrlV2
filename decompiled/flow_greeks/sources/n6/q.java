package n6;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f16668c;

    public q(s sVar, int i10) {
        super(sVar.size(), i10);
        this.f16668c = sVar;
    }

    @Override // n6.o
    public final Object b(int i10) {
        return this.f16668c.get(i10);
    }
}
