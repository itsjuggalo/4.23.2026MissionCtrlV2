package d;

/* JADX INFO: renamed from: d.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0512p extends kotlin.jvm.internal.k implements R4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0517u f5928b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0512p(C0517u c0517u, int i) {
        super(0);
        this.f5927a = i;
        this.f5928b = c0517u;
    }

    @Override // R4.a
    public final Object invoke() {
        switch (this.f5927a) {
            case 0:
                this.f5928b.b();
                break;
            case 1:
                this.f5928b.a();
                break;
            default:
                this.f5928b.b();
                break;
        }
        return G4.l.f540a;
    }
}
