package k6;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import l6.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends l6.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l6.i f14739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f14740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f14741c;

    public k(m mVar, l6.i iVar, TaskCompletionSource taskCompletionSource) {
        this.f14741c = mVar;
        this.f14739a = iVar;
        this.f14740b = taskCompletionSource;
    }

    @Override // l6.h
    public void zzb(Bundle bundle) {
        t tVar = this.f14741c.f14743a;
        if (tVar != null) {
            tVar.u(this.f14740b);
        }
        this.f14739a.c("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
