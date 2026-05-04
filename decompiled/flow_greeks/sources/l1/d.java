package l1;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends IOException {
    public /* synthetic */ d(String str, Throwable th, int i10, kotlin.jvm.internal.k kVar) {
        this(str, (i10 & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String message, Throwable th) {
        super(message, th);
        kotlin.jvm.internal.t.f(message, "message");
    }
}
