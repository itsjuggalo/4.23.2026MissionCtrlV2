package K0;

import L0.f;
import android.app.Activity;
import b7.d;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f4730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final J0.a f4731c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f tracker) {
        this(tracker, new J0.a());
        AbstractC2304t.f(tracker, "tracker");
    }

    @Override // L0.f
    public d a(Activity activity) {
        AbstractC2304t.f(activity, "activity");
        return this.f4730b.a(activity);
    }

    public final void b(Activity activity, Executor executor, S.a consumer) {
        AbstractC2304t.f(activity, "activity");
        AbstractC2304t.f(executor, "executor");
        AbstractC2304t.f(consumer, "consumer");
        this.f4731c.a(executor, consumer, this.f4730b.a(activity));
    }

    public final void c(S.a consumer) {
        AbstractC2304t.f(consumer, "consumer");
        this.f4731c.b(consumer);
    }

    public a(f fVar, J0.a aVar) {
        this.f4730b = fVar;
        this.f4731c = aVar;
    }
}
