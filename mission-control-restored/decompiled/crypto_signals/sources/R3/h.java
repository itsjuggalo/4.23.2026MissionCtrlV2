package R3;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f2818b;

    public /* synthetic */ h(i iVar, int i) {
        this.f2817a = i;
        this.f2818b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2817a) {
            case 0:
                this.f2818b.b();
                break;
            default:
                this.f2818b.b();
                break;
        }
    }
}
