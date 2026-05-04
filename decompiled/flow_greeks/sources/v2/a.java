package v2;

import android.app.Activity;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import qg.d;
import w2.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f23091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u2.a f23092c;

    public a(n nVar, u2.a aVar) {
        this.f23091b = nVar;
        this.f23092c = aVar;
    }

    @Override // w2.n
    public d a(Activity activity) {
        t.f(activity, "activity");
        return this.f23091b.a(activity);
    }

    public final void b(Activity activity, Executor executor, s0.a consumer) {
        t.f(activity, "activity");
        t.f(executor, "executor");
        t.f(consumer, "consumer");
        this.f23092c.a(executor, consumer, this.f23091b.a(activity));
    }

    public final void c(s0.a consumer) {
        t.f(consumer, "consumer");
        this.f23092c.b(consumer);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(n tracker) {
        this(tracker, new u2.a());
        t.f(tracker, "tracker");
    }
}
