package x0;

import android.content.Context;
import android.os.CancellationSignal;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface h {
    boolean isAvailableOnDevice();

    void onClearCredential(a aVar, CancellationSignal cancellationSignal, Executor executor, e eVar);

    default void onGetCredential(Context context, a0 pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, e callback) {
        kotlin.jvm.internal.t.f(context, "context");
        kotlin.jvm.internal.t.f(pendingGetCredentialHandle, "pendingGetCredentialHandle");
        kotlin.jvm.internal.t.f(executor, "executor");
        kotlin.jvm.internal.t.f(callback, "callback");
    }

    void onGetCredential(Context context, w wVar, CancellationSignal cancellationSignal, Executor executor, e eVar);

    default void onPrepareCredential(w request, CancellationSignal cancellationSignal, Executor executor, e callback) {
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(executor, "executor");
        kotlin.jvm.internal.t.f(callback, "callback");
    }
}
