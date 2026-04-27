package a5;

/* JADX INFO: renamed from: a5.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0306m implements R4.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4142b;

    public /* synthetic */ C0306m(Object obj, int i) {
        this.f4141a = i;
        this.f4142b = obj;
    }

    @Override // R4.q
    public final Object b(Object obj, Object obj2, Object obj3) {
        Throwable th = (Throwable) obj;
        switch (this.f4141a) {
            case 0:
                ((V2.j) this.f4142b).invoke(th);
                break;
            default:
                ((j5.h) this.f4142b).b();
                break;
        }
        return G4.l.f540a;
    }
}
