package j$.time.temporal;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19855b;

    public /* synthetic */ o(int i8, int i9) {
        this.f19854a = i9;
        this.f19855b = i8;
    }

    @Override // j$.time.temporal.n
    public final m d(m mVar) {
        switch (this.f19854a) {
            case 0:
                int i8 = mVar.i(a.DAY_OF_WEEK);
                int i9 = this.f19855b;
                if (i8 == i9) {
                    return mVar;
                }
                return mVar.e(i8 - i9 >= 0 ? 7 - r0 : -r0, b.DAYS);
            default:
                int i10 = mVar.i(a.DAY_OF_WEEK);
                int i11 = this.f19855b;
                if (i10 == i11) {
                    return mVar;
                }
                return mVar.a(i11 - i10 >= 0 ? 7 - r1 : -r1, b.DAYS);
        }
    }
}
