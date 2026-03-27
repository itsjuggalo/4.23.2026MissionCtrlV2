package D;

import W2.p;
import W2.q;
import android.os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AtomicBoolean implements OutcomeReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z2.e f292a;

    public e(Z2.e eVar) {
        super(false);
        this.f292a = eVar;
    }

    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            Z2.e eVar = this.f292a;
            p.a aVar = p.f5487b;
            eVar.resumeWith(p.b(q.a(th)));
        }
    }

    public void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.f292a.resumeWith(p.b(obj));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
