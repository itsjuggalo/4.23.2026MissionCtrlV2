package S;

import java.io.IOException;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: S.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0518d extends IOException {
    public /* synthetic */ C0518d(String str, Throwable th, int i4, AbstractC1585j abstractC1585j) {
        this(str, (i4 & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0518d(String message, Throwable th) {
        super(message, th);
        kotlin.jvm.internal.r.f(message, "message");
    }
}
