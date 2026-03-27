package T0;

import F5.AbstractC0556n;
import R0.j;
import android.content.Context;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class c implements S0.a {
    public static final void d(P.a callback) {
        r.f(callback, "$callback");
        callback.accept(new j(AbstractC0556n.g()));
    }

    @Override // S0.a
    public void a(Context context, Executor executor, final P.a callback) {
        r.f(context, "context");
        r.f(executor, "executor");
        r.f(callback, "callback");
        executor.execute(new Runnable() { // from class: T0.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(callback);
            }
        });
    }

    @Override // S0.a
    public void b(P.a callback) {
        r.f(callback, "callback");
    }
}
