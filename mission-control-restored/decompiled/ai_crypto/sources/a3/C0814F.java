package a3;

import Z2.InterfaceC0761i;
import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: a3.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0814F implements OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f6130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f6131b;

    public C0814F(C0804A c0804a, TaskCompletionSource taskCompletionSource, Context context) {
        this.f6130a = taskCompletionSource;
        this.f6131b = context;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Object obj) {
        this.f6130a.setResult((InterfaceC0761i) obj);
        C0804A.g(this.f6131b);
    }
}
