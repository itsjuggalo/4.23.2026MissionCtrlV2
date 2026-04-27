package a3;

import Z2.InterfaceC0761i;
import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: a3.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0808C implements OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f6118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f6119b;

    public C0808C(C0804A c0804a, TaskCompletionSource taskCompletionSource, Context context) {
        this.f6118a = taskCompletionSource;
        this.f6119b = context;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Object obj) {
        this.f6118a.setResult((InterfaceC0761i) obj);
        C0804A.g(this.f6119b);
    }
}
