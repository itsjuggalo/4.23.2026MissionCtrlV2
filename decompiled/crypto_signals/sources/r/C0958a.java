package r;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: r.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0958a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0958a f9408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0958a f9409d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CancellationException f9411b;

    static {
        if (h.f9426d) {
            f9409d = null;
            f9408c = null;
        } else {
            f9409d = new C0958a(false, null);
            f9408c = new C0958a(true, null);
        }
    }

    public C0958a(boolean z6, CancellationException cancellationException) {
        this.f9410a = z6;
        this.f9411b = cancellationException;
    }
}
