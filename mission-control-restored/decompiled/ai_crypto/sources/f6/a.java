package f6;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient e6.e f14186a;

    public a(e6.e eVar) {
        super("Flow was aborted, no more elements needed");
        this.f14186a = eVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
