package i4;

import Z3.g;
import java.util.HashMap;

/* JADX INFO: renamed from: i4.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0702d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f7026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HashMap f7027c;

    public /* synthetic */ RunnableC0702d(g gVar, HashMap map, int i) {
        this.f7025a = i;
        this.f7026b = gVar;
        this.f7027c = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7025a) {
            case 0:
                g gVar = this.f7026b;
                gVar.c(this.f7027c);
                gVar.a();
                break;
            default:
                this.f7026b.c(this.f7027c);
                break;
        }
    }
}
