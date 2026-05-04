package x0;

import android.content.Context;
import android.os.CancellationSignal;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24134a = a.f24135a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f24135a = new a();

        public final d a(Context context) {
            kotlin.jvm.internal.t.f(context, "context");
            return new f(context);
        }
    }

    static d create(Context context) {
        return f24134a.a(context);
    }

    void a(x0.a aVar, CancellationSignal cancellationSignal, Executor executor, e eVar);

    void b(Context context, w wVar, CancellationSignal cancellationSignal, Executor executor, e eVar);
}
