package M4;

import F4.AbstractC0490d;
import F4.C0489c;
import java.util.concurrent.TimeUnit;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0490d f5355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0489c f5356b;

    public interface a {
        b a(AbstractC0490d abstractC0490d, C0489c c0489c);
    }

    public b(AbstractC0490d abstractC0490d, C0489c c0489c) {
        this.f5355a = (AbstractC0490d) AbstractC2848n.o(abstractC0490d, "channel");
        this.f5356b = (C0489c) AbstractC2848n.o(c0489c, "callOptions");
    }

    public abstract b a(AbstractC0490d abstractC0490d, C0489c c0489c);

    public final C0489c b() {
        return this.f5356b;
    }

    public final AbstractC0490d c() {
        return this.f5355a;
    }

    public final b d(long j8, TimeUnit timeUnit) {
        return a(this.f5355a, this.f5356b.m(j8, timeUnit));
    }
}
