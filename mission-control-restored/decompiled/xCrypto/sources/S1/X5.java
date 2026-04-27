package S1;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class X5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1984b f4289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Y5 f4290b;

    public X5(Y5 y5, C1984b c1984b) {
        this.f4289a = c1984b;
        Objects.requireNonNull(y5);
        this.f4290b = y5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0565e6 c0565e6 = this.f4290b.f4308c;
        c0565e6.O(null);
        if (this.f4289a.i() != 7777) {
            c0565e6.L();
            return;
        }
        if (c0565e6.P() == null) {
            c0565e6.Q(Executors.newScheduledThreadPool(1));
        }
        c0565e6.P().schedule(new Runnable() { // from class: S1.V5
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                final C0565e6 c0565e62 = this.f4266a.f4290b.f4308c;
                c0565e62.f4245a.b().t(new Runnable() { // from class: S1.W5
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        c0565e62.w();
                    }
                });
            }
        }, ((Long) AbstractC0569f2.f4555a0.b(null)).longValue(), TimeUnit.MILLISECONDS);
    }
}
