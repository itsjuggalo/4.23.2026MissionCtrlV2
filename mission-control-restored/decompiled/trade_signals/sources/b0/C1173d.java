package b0;

import java.io.IOException;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: b0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1173d extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1173d(String message, Throwable th) {
        super(message, th);
        AbstractC2304t.f(message, "message");
    }

    public /* synthetic */ C1173d(String str, Throwable th, int i8, AbstractC2296k abstractC2296k) {
        this(str, (i8 & 2) != 0 ? null : th);
    }
}
