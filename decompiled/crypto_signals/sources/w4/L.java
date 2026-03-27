package w4;

/* JADX INFO: loaded from: classes.dex */
public final class L implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ O f10938c;

    public /* synthetic */ L(O o3, int i, int i6) {
        this.f10936a = i6;
        this.f10938c = o3;
        this.f10937b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10936a) {
            case 0:
                this.f10938c.f10972c.e(this.f10937b);
                break;
            case 1:
                this.f10938c.f10972c.f(this.f10937b);
                break;
            default:
                this.f10938c.f10972c.a(this.f10937b);
                break;
        }
    }
}
