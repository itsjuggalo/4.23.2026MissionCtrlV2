package n0;

import kotlin.jvm.internal.r;
import m0.AbstractComponentCallbacksC2216p;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractComponentCallbacksC2216p f19073a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(AbstractComponentCallbacksC2216p fragment, String str) {
        super(str);
        r.f(fragment, "fragment");
        this.f19073a = fragment;
    }

    public final AbstractComponentCallbacksC2216p a() {
        return this.f19073a;
    }
}
