package P3;

import android.window.OnBackInvokedCallback;
import d.C0512p;

/* JADX INFO: renamed from: P3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0227b implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2524b;

    public /* synthetic */ C0227b(Object obj, int i) {
        this.f2523a = i;
        this.f2524b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f2523a) {
            case 0:
                ((AbstractActivityC0229d) this.f2524b).onBackPressed();
                break;
            case 1:
                ((C0512p) this.f2524b).invoke();
                break;
            default:
                ((Runnable) this.f2524b).run();
                break;
        }
    }
}
