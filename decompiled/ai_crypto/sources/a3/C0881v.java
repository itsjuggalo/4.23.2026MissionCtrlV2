package a3;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: renamed from: a3.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0881v implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RunnableC0883w f6285a;

    public C0881v(RunnableC0883w runnableC0883w) {
        this.f6285a = runnableC0883w;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        if (exc instanceof Q2.o) {
            C0877t.f6276h.g("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.f6285a.f6287b.d();
        }
    }
}
