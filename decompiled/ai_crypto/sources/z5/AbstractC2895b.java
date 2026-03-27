package z5;

import H2.m;
import java.util.concurrent.Executor;
import r5.AbstractC2586b;
import r5.AbstractC2588d;
import r5.C2587c;

/* JADX INFO: renamed from: z5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2895b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2588d f26062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2587c f26063b;

    /* JADX INFO: renamed from: z5.b$a */
    public interface a {
        AbstractC2895b a(AbstractC2588d abstractC2588d, C2587c c2587c);
    }

    public AbstractC2895b(AbstractC2588d abstractC2588d, C2587c c2587c) {
        this.f26062a = (AbstractC2588d) m.o(abstractC2588d, "channel");
        this.f26063b = (C2587c) m.o(c2587c, "callOptions");
    }

    public abstract AbstractC2895b a(AbstractC2588d abstractC2588d, C2587c c2587c);

    public final C2587c b() {
        return this.f26063b;
    }

    public final AbstractC2895b c(AbstractC2586b abstractC2586b) {
        return a(this.f26062a, this.f26063b.l(abstractC2586b));
    }

    public final AbstractC2895b d(Executor executor) {
        return a(this.f26062a, this.f26063b.n(executor));
    }
}
