package a5;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: a5.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0315w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4159b = AtomicIntegerFieldUpdater.newUpdater(C0315w.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f4160a;

    public C0315w(Throwable th, boolean z6) {
        this.f4160a = th;
        this._handled$volatile = z6 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f4160a + ']';
    }
}
