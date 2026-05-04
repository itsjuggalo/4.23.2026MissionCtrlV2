package x0;

import android.content.Context;
import android.os.CancellationSignal;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f24136c = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f24137b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public f(Context context) {
        kotlin.jvm.internal.t.f(context, "context");
        this.f24137b = context;
    }

    @Override // x0.d
    public void a(x0.a request, CancellationSignal cancellationSignal, Executor executor, e callback) {
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(executor, "executor");
        kotlin.jvm.internal.t.f(callback, "callback");
        h hVarD = i.d(new i(this.f24137b), request.b(), false, 2, null);
        if (hVarD == null) {
            callback.onError(new y0.b("clearCredentialStateAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        } else {
            hVarD.onClearCredential(request, cancellationSignal, executor, callback);
        }
    }

    @Override // x0.d
    public void b(Context context, w request, CancellationSignal cancellationSignal, Executor executor, e callback) {
        kotlin.jvm.internal.t.f(context, "context");
        kotlin.jvm.internal.t.f(request, "request");
        kotlin.jvm.internal.t.f(executor, "executor");
        kotlin.jvm.internal.t.f(callback, "callback");
        h hVarD = i.d(new i(context), request, false, 2, null);
        if (hVarD == null) {
            callback.onError(new y0.j("getCredentialAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        } else {
            hVarD.onGetCredential(context, request, cancellationSignal, executor, callback);
        }
    }
}
