package d;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* JADX INFO: renamed from: d.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0513q implements OnBackAnimationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0511o f5929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0511o f5930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0512p f5931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0512p f5932d;

    public C0513q(C0511o c0511o, C0511o c0511o2, C0512p c0512p, C0512p c0512p2) {
        this.f5929a = c0511o;
        this.f5930b = c0511o2;
        this.f5931c = c0512p;
        this.f5932d = c0512p2;
    }

    public final void onBackCancelled() {
        this.f5932d.invoke();
    }

    public final void onBackInvoked() {
        this.f5931c.invoke();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        kotlin.jvm.internal.j.e(backEvent, "backEvent");
        this.f5930b.invoke(new C0498b(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        kotlin.jvm.internal.j.e(backEvent, "backEvent");
        this.f5929a.invoke(new C0498b(backEvent));
    }
}
