package j$.time.temporal;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7555b;

    public /* synthetic */ o(int i, int i6) {
        this.f7554a = i6;
        this.f7555b = i;
    }

    @Override // j$.time.temporal.n
    public final m c(m mVar) {
        switch (this.f7554a) {
            case 0:
                int i = mVar.i(a.DAY_OF_WEEK);
                int i6 = this.f7555b;
                if (i == i6) {
                    return mVar;
                }
                return mVar.d(i - i6 >= 0 ? 7 - r0 : -r0, b.DAYS);
            default:
                int i7 = mVar.i(a.DAY_OF_WEEK);
                int i8 = this.f7555b;
                if (i7 == i8) {
                    return mVar;
                }
                return mVar.e(i8 - i7 >= 0 ? 7 - r1 : -r1, b.DAYS);
        }
    }
}
