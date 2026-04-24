package w4;

import java.util.concurrent.atomic.AtomicBoolean;
import u4.AbstractC1225g;

/* JADX INFO: loaded from: classes.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1225g[] f11175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f11176b = new AtomicBoolean(false);

    static {
        new a2(new AbstractC1225g[0]);
    }

    public a2(AbstractC1225g[] abstractC1225gArr) {
        this.f11175a = abstractC1225gArr;
    }

    public final void a(long j4) {
        for (AbstractC1225g abstractC1225g : this.f11175a) {
            abstractC1225g.g(j4);
        }
    }
}
