package b6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: b6.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1056C {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f8964b = AtomicIntegerFieldUpdater.newUpdater(C1056C.class, "_handled");
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f8965a;

    public C1056C(Throwable th, boolean z7) {
        this.f8965a = th;
        this._handled = z7 ? 1 : 0;
    }

    public final boolean a() {
        return f8964b.get(this) != 0;
    }

    public final boolean b() {
        return f8964b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return P.a(this) + '[' + this.f8965a + ']';
    }

    public /* synthetic */ C1056C(Throwable th, boolean z7, int i7, AbstractC2148j abstractC2148j) {
        this(th, (i7 & 2) != 0 ? false : z7);
    }
}
