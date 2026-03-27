package a3;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: a3.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0806B implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f6111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f6112b;

    public C0806B(C0804A c0804a, TaskCompletionSource taskCompletionSource, Context context) {
        this.f6111a = taskCompletionSource;
        this.f6112b = context;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f6111a.setException(exc);
        C0804A.g(this.f6112b);
    }
}
