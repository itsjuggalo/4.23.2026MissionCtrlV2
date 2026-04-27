package a5;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: a5.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0308o extends C0315w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4149c = AtomicIntegerFieldUpdater.newUpdater(C0308o.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public C0308o(C0307n c0307n, Throwable th, boolean z6) {
        if (th == null) {
            th = new CancellationException("Continuation " + c0307n + " was cancelled normally");
        }
        super(th, z6);
        this._resumed$volatile = 0;
    }
}
