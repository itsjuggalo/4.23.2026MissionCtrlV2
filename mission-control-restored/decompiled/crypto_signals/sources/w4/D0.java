package w4;

import u4.EnumC1229k;

/* JADX INFO: loaded from: classes.dex */
public final class D0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ R0 f10844b;

    public /* synthetic */ D0(R0 r02, int i) {
        this.f10843a = i;
        this.f10844b = r02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10843a) {
            case 0:
                this.f10844b.D(true);
                break;
            case 1:
                R0 r02 = this.f10844b;
                if (!r02.f11016J.get() && r02.f11007A != null) {
                    r02.D(false);
                    R0.A(r02);
                    break;
                }
                break;
            case 2:
                this.f10844b.E();
                if (this.f10844b.f11008B != null) {
                    this.f10844b.f11008B.getClass();
                }
                J0 j02 = this.f10844b.f11007A;
                if (j02 != null) {
                    ((u4.M) j02.f10916d.f6192c).e();
                }
                break;
            case 3:
                R0 r03 = this.f10844b;
                r03.f11022R.m(2, "Entering SHUTDOWN state");
                r03.f11052u.c(EnumC1229k.e);
                break;
            case 4:
                R0 r04 = this.f10844b;
                if (!r04.f11017K) {
                    r04.f11017K = true;
                    R0.B(r04);
                    break;
                }
                break;
            default:
                R0 r05 = this.f10844b;
                if (r05.f11007A != null) {
                    R0.A(r05);
                    break;
                }
                break;
        }
    }
}
