package j$.time.temporal;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17278b;

    public /* synthetic */ o(int i7, int i8) {
        this.f17277a = i8;
        this.f17278b = i7;
    }

    @Override // j$.time.temporal.n
    public final m c(m mVar) {
        switch (this.f17277a) {
            case 0:
                int i7 = mVar.i(a.DAY_OF_WEEK);
                int i8 = this.f17278b;
                if (i7 == i8) {
                    return mVar;
                }
                return mVar.d(i7 - i8 >= 0 ? 7 - r0 : -r0, b.DAYS);
            default:
                int i9 = mVar.i(a.DAY_OF_WEEK);
                int i10 = this.f17278b;
                if (i9 == i10) {
                    return mVar;
                }
                return mVar.e(i10 - i9 >= 0 ? 7 - r1 : -r1, b.DAYS);
        }
    }
}
