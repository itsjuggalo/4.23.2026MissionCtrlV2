package N2;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: N2.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0169s implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f2041b;

    public /* synthetic */ C0169s(int i, TaskCompletionSource taskCompletionSource) {
        this.f2040a = i;
        this.f2041b = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        switch (this.f2040a) {
            case 0:
                this.f2041b.setException(exc);
                break;
            default:
                this.f2041b.setException(exc);
                break;
        }
    }
}
