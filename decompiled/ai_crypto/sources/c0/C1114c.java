package c0;

import java.io.IOException;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: c0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1114c extends IOException {
    public /* synthetic */ C1114c(String str, Throwable th, int i7, AbstractC2148j abstractC2148j) {
        this(str, (i7 & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1114c(String message, Throwable th) {
        super(message, th);
        kotlin.jvm.internal.r.f(message, "message");
    }
}
