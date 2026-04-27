package j2;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: renamed from: j2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0740p implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f7720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f7721c;

    public C0740p(P3.u uVar, TaskCompletionSource taskCompletionSource, Context context, int i) {
        this.f7719a = i;
        switch (i) {
            case 1:
                this.f7720b = taskCompletionSource;
                this.f7721c = context;
                Objects.requireNonNull(uVar);
                break;
            case 2:
                this.f7720b = taskCompletionSource;
                this.f7721c = context;
                Objects.requireNonNull(uVar);
                break;
            default:
                this.f7720b = taskCompletionSource;
                this.f7721c = context;
                Objects.requireNonNull(uVar);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        switch (this.f7719a) {
            case 0:
                this.f7720b.setException(exc);
                P3.u.p(this.f7721c);
                break;
            case 1:
                this.f7720b.setException(exc);
                P3.u.p(this.f7721c);
                break;
            default:
                this.f7720b.setException(exc);
                P3.u.p(this.f7721c);
                break;
        }
    }
}
