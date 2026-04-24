package a3;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: a3.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0812E implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f6124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f6125b;

    public C0812E(C0804A c0804a, TaskCompletionSource taskCompletionSource, Context context) {
        this.f6124a = taskCompletionSource;
        this.f6125b = context;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f6124a.setException(exc);
        C0804A.g(this.f6125b);
    }
}
