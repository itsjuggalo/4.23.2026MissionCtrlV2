package a3;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: a3.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0870p0 implements OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f6273a;

    public C0870p0(C0810D c0810d, TaskCompletionSource taskCompletionSource) {
        this.f6273a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Object obj) {
        this.f6273a.setResult(new C0884w0().c((String) obj).b());
    }
}
