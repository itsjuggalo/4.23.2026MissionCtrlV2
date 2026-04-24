package N1;

import java.util.Objects;

/* JADX INFO: renamed from: N1.l1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0110l1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0113m1 f1691b;

    public RunnableC0110l1(C0113m1 c0113m1, int i) {
        this.f1690a = i;
        switch (i) {
            case 1:
                Objects.requireNonNull(c0113m1);
                this.f1691b = c0113m1;
                break;
            default:
                Objects.requireNonNull(c0113m1);
                this.f1691b = c0113m1;
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1690a) {
            case 0:
                C0113m1 c0113m1 = this.f1691b;
                c0113m1.e = c0113m1.f1702n;
                break;
            default:
                this.f1691b.f1702n = null;
                break;
        }
    }
}
