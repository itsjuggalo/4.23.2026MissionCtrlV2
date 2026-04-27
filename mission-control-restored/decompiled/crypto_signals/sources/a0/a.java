package a0;

import Z.AbstractComponentCallbacksC0277t;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class a extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractComponentCallbacksC0277t f4041a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AbstractComponentCallbacksC0277t fragment, String str) {
        super(str);
        j.e(fragment, "fragment");
        this.f4041a = fragment;
    }
}
