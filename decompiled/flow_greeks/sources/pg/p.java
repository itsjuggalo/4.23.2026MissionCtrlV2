package pg;

import java.util.concurrent.CancellationException;
import ng.n1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class p {
    public static final void a(w wVar, Throwable th) {
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = n1.a("Channel was consumed, consumer had failed", th);
            }
        }
        wVar.cancel(cancellationExceptionA);
    }
}
