package j$.time.temporal;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13752b;

    public /* synthetic */ o(int i10, int i11) {
        this.f13751a = i11;
        this.f13752b = i10;
    }

    @Override // j$.time.temporal.n
    public final m e(m mVar) {
        switch (this.f13751a) {
            case 0:
                int iG = mVar.g(a.DAY_OF_WEEK);
                int i10 = this.f13752b;
                if (iG == i10) {
                    return mVar;
                }
                return mVar.d(iG - i10 >= 0 ? 7 - r0 : -r0, b.DAYS);
            default:
                int iG2 = mVar.g(a.DAY_OF_WEEK);
                int i11 = this.f13752b;
                if (iG2 == i11) {
                    return mVar;
                }
                return mVar.a(i11 - iG2 >= 0 ? 7 - r1 : -r1, b.DAYS);
        }
    }
}
