package y2;

import android.content.Context;
import dd.r;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements x2.a {
    public static final void d(s0.a aVar) {
        aVar.accept(new s(r.k()));
    }

    @Override // x2.a
    public void a(s0.a callback) {
        t.f(callback, "callback");
    }

    @Override // x2.a
    public void b(Context context, Executor executor, final s0.a callback) {
        t.f(context, "context");
        t.f(executor, "executor");
        t.f(callback, "callback");
        executor.execute(new Runnable() { // from class: y2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(callback);
            }
        });
    }
}
