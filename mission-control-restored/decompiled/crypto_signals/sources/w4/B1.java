package w4;

/* JADX INFO: loaded from: classes.dex */
public final class B1 implements E1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10835b;

    public /* synthetic */ B1(int i, int i6) {
        this.f10834a = i6;
        this.f10835b = i;
    }

    @Override // w4.E1
    public final void a(K1 k12) {
        switch (this.f10834a) {
            case 0:
                k12.f10932a.f(this.f10835b);
                break;
            case 1:
                k12.f10932a.a(this.f10835b);
                break;
            default:
                k12.f10932a.e(this.f10835b);
                break;
        }
    }
}
