package ng;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17077b = AtomicIntegerFieldUpdater.newUpdater(c0.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f17078a;

    public c0(Throwable th, boolean z10) {
        this.f17078a = th;
        this._handled$volatile = z10 ? 1 : 0;
    }

    public final boolean a() {
        return f17077b.get(this) != 0;
    }

    public final boolean c() {
        return f17077b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return r0.a(this) + '[' + this.f17078a + ']';
    }

    public /* synthetic */ c0(Throwable th, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
        this(th, (i10 & 2) != 0 ? false : z10);
    }
}
