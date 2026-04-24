package a3;

import Z2.C0772q;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: a3.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0874r0 implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f6275a;

    public C0874r0(C0810D c0810d, TaskCompletionSource taskCompletionSource) {
        this.f6275a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Log.e(C0810D.f6120b, String.format("Failed to get reCAPTCHA token with error [%s]- calling backend without app verification", exc.getMessage()));
        if ((exc instanceof C0772q) && ((C0772q) exc).a().endsWith("UNAUTHORIZED_DOMAIN")) {
            this.f6275a.setException(exc);
        } else {
            this.f6275a.setResult(new C0884w0().b());
        }
    }
}
