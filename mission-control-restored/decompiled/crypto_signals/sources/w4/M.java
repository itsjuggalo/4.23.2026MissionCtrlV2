package w4;

/* JADX INFO: loaded from: classes.dex */
public final class M implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ O f10945b;

    public /* synthetic */ M(O o3, int i) {
        this.f10944a = i;
        this.f10945b = o3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10944a) {
            case 0:
                this.f10945b.f10972c.k();
                break;
            case 1:
                this.f10945b.o();
                break;
            case 2:
                this.f10945b.f10972c.flush();
                break;
            default:
                this.f10945b.f10972c.l();
                break;
        }
    }
}
