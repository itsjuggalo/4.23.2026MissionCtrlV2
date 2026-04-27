package m;

import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: m.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0841s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f8431b;

    public /* synthetic */ RunnableC0841s0(SearchView searchView, int i) {
        this.f8430a = i;
        this.f8431b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8430a) {
            case 0:
                this.f8431b.q();
                break;
            default:
                L.c cVar = this.f8431b.f4309S;
                if (cVar instanceof D0) {
                    cVar.b(null);
                }
                break;
        }
    }
}
