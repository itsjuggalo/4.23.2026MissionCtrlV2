package C0;

import A0.j;
import X2.AbstractC0769p;
import android.content.Context;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class c implements B0.a {
    public static final void d(G.a callback) {
        r.f(callback, "$callback");
        callback.accept(new j(AbstractC0769p.g()));
    }

    @Override // B0.a
    public void a(G.a callback) {
        r.f(callback, "callback");
    }

    @Override // B0.a
    public void b(Context context, Executor executor, final G.a callback) {
        r.f(context, "context");
        r.f(executor, "executor");
        r.f(callback, "callback");
        executor.execute(new Runnable() { // from class: C0.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(callback);
            }
        });
    }
}
