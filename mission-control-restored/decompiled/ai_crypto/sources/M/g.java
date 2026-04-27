package M;

import E5.p;
import E5.q;
import android.os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class g extends AtomicBoolean implements OutcomeReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H5.d f3714a;

    public g(H5.d dVar) {
        super(false);
        this.f3714a = dVar;
    }

    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            H5.d dVar = this.f3714a;
            p.a aVar = p.f1681b;
            dVar.resumeWith(p.b(q.a(th)));
        }
    }

    public void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.f3714a.resumeWith(p.b(obj));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
