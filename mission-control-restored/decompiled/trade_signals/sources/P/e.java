package P;

import android.os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import o5.AbstractC2491s;
import o5.C2490r;
import s5.InterfaceC2707e;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AtomicBoolean implements OutcomeReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2707e f6251a;

    public e(InterfaceC2707e interfaceC2707e) {
        super(false);
        this.f6251a = interfaceC2707e;
    }

    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            InterfaceC2707e interfaceC2707e = this.f6251a;
            C2490r.a aVar = C2490r.f21981b;
            interfaceC2707e.resumeWith(C2490r.b(AbstractC2491s.a(th)));
        }
    }

    public void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.f6251a.resumeWith(C2490r.b(obj));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
