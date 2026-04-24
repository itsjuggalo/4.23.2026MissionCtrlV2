package t1;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h f9889b = new h(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h f9890c = new h(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9891a;

    public /* synthetic */ h(int i) {
        this.f9891a = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f9891a) {
            case 0:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
