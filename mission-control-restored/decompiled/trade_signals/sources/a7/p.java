package a7;

import Y6.AbstractC1012j0;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class p {
    public static final void a(w wVar, Throwable th) {
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = AbstractC1012j0.a("Channel was consumed, consumer had failed", th);
            }
        }
        wVar.e(cancellationExceptionA);
    }
}
