package p0;

import android.os.OutcomeReceiver;
import cd.r;
import cd.s;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends AtomicBoolean implements OutcomeReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gd.e f18165a;

    public e(gd.e eVar) {
        super(false);
        this.f18165a = eVar;
    }

    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            gd.e eVar = this.f18165a;
            r.a aVar = r.f3870b;
            eVar.resumeWith(r.b(s.a(th)));
        }
    }

    public void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.f18165a.resumeWith(r.b(obj));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
