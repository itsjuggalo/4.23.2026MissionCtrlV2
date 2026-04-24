package Q0;

import R0.f;
import android.app.Activity;
import e6.d;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f4480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final P0.a f4481c;

    public a(f fVar, P0.a aVar) {
        this.f4480b = fVar;
        this.f4481c = aVar;
    }

    @Override // R0.f
    public d a(Activity activity) {
        r.f(activity, "activity");
        return this.f4480b.a(activity);
    }

    public final void b(Activity activity, Executor executor, P.a consumer) {
        r.f(activity, "activity");
        r.f(executor, "executor");
        r.f(consumer, "consumer");
        this.f4481c.a(executor, consumer, this.f4480b.a(activity));
    }

    public final void c(P.a consumer) {
        r.f(consumer, "consumer");
        this.f4481c.b(consumer);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f tracker) {
        this(tracker, new P0.a());
        r.f(tracker, "tracker");
    }
}
