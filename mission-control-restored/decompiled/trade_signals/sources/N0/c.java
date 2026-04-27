package N0;

import L0.j;
import android.content.Context;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
public final class c implements M0.a {
    public static final void d(S.a aVar) {
        aVar.accept(new j(AbstractC2595q.i()));
    }

    @Override // M0.a
    public void a(Context context, Executor executor, final S.a callback) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(executor, "executor");
        AbstractC2304t.f(callback, "callback");
        executor.execute(new Runnable() { // from class: N0.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(callback);
            }
        });
    }

    @Override // M0.a
    public void b(S.a callback) {
        AbstractC2304t.f(callback, "callback");
    }
}
