package Y6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: loaded from: classes2.dex */
public class A {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9601b = AtomicIntegerFieldUpdater.newUpdater(A.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f9602a;

    public A(Throwable th, boolean z7) {
        this.f9602a = th;
        this._handled$volatile = z7 ? 1 : 0;
    }

    public final boolean a() {
        return f9601b.get(this) != 0;
    }

    public final boolean c() {
        return f9601b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return P.a(this) + '[' + this.f9602a + ']';
    }

    public /* synthetic */ A(Throwable th, boolean z7, int i8, AbstractC2296k abstractC2296k) {
        this(th, (i8 & 2) != 0 ? false : z7);
    }
}
