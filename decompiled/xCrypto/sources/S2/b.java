package S2;

import K2.AbstractC0354b;
import K2.AbstractC0356d;
import K2.C0355c;
import Z1.m;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0356d f5092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0355c f5093b;

    public interface a {
        b a(AbstractC0356d abstractC0356d, C0355c c0355c);
    }

    public b(AbstractC0356d abstractC0356d, C0355c c0355c) {
        this.f5092a = (AbstractC0356d) m.o(abstractC0356d, "channel");
        this.f5093b = (C0355c) m.o(c0355c, "callOptions");
    }

    public abstract b a(AbstractC0356d abstractC0356d, C0355c c0355c);

    public final C0355c b() {
        return this.f5093b;
    }

    public final b c(AbstractC0354b abstractC0354b) {
        return a(this.f5092a, this.f5093b.l(abstractC0354b));
    }

    public final b d(Executor executor) {
        return a(this.f5092a, this.f5093b.n(executor));
    }
}
