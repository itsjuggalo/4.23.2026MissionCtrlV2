package d6;

import b6.AbstractC1080l0;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class l {
    public static final void a(s sVar, Throwable th) {
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = AbstractC1080l0.a("Channel was consumed, consumer had failed", th);
            }
        }
        sVar.cancel(cancellationExceptionA);
    }
}
