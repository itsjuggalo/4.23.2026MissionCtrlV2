package t3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public class C {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f14906b = AtomicIntegerFieldUpdater.newUpdater(C.class, "_handled");
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f14907a;

    public C(Throwable th, boolean z4) {
        this.f14907a = th;
        this._handled = z4 ? 1 : 0;
    }

    public final boolean a() {
        return f14906b.get(this) != 0;
    }

    public final boolean b() {
        return f14906b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return P.a(this) + '[' + this.f14907a + ']';
    }

    public /* synthetic */ C(Throwable th, boolean z4, int i4, AbstractC1585j abstractC1585j) {
        this(th, (i4 & 2) != 0 ? false : z4);
    }
}
