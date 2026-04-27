package v3;

import java.util.concurrent.CancellationException;
import t3.AbstractC1825l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m {
    public static final void a(t tVar, Throwable th) {
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = AbstractC1825l0.a("Channel was consumed, consumer had failed", th);
            }
        }
        tVar.cancel(cancellationExceptionA);
    }
}
