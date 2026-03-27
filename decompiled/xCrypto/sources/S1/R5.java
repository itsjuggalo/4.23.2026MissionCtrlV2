package S1;

import android.content.ComponentName;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class R5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentName f4223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Y5 f4224b;

    public R5(Y5 y5, ComponentName componentName) {
        this.f4223a = componentName;
        Objects.requireNonNull(y5);
        this.f4224b = y5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4224b.f4308c.K(this.f4223a);
    }
}
