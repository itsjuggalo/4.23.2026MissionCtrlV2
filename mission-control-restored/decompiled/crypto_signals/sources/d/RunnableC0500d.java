package d;

import Z.AbstractActivityC0282y;

/* JADX INFO: renamed from: d.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0500d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0282y f5883b;

    public /* synthetic */ RunnableC0500d(AbstractActivityC0282y abstractActivityC0282y, int i) {
        this.f5882a = i;
        this.f5883b = abstractActivityC0282y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5882a) {
            case 0:
                this.f5883b.invalidateOptionsMenu();
                return;
            default:
                try {
                    super/*android.app.Activity*/.onBackPressed();
                    return;
                } catch (IllegalStateException e) {
                    if (!kotlin.jvm.internal.j.a(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e;
                    }
                    return;
                } catch (NullPointerException e2) {
                    if (!kotlin.jvm.internal.j.a(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e2;
                    }
                    return;
                }
        }
    }
}
