package z0;

import A0.f;
import android.app.Activity;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.r;
import w3.d;
import y0.C1936a;

/* JADX INFO: renamed from: z0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1969a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f16047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1936a f16048c;

    public C1969a(f fVar, C1936a c1936a) {
        this.f16047b = fVar;
        this.f16048c = c1936a;
    }

    @Override // A0.f
    public d a(Activity activity) {
        r.f(activity, "activity");
        return this.f16047b.a(activity);
    }

    public final void b(Activity activity, Executor executor, G.a consumer) {
        r.f(activity, "activity");
        r.f(executor, "executor");
        r.f(consumer, "consumer");
        this.f16048c.a(executor, consumer, this.f16047b.a(activity));
    }

    public final void c(G.a consumer) {
        r.f(consumer, "consumer");
        this.f16048c.b(consumer);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1969a(f tracker) {
        this(tracker, new C1936a());
        r.f(tracker, "tracker");
    }
}
