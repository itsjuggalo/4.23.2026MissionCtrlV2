package n0;

import kotlin.jvm.internal.r;
import m0.AbstractComponentCallbacksC2216p;

/* JADX INFO: loaded from: classes.dex */
public final class i extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractComponentCallbacksC2216p f19075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19076c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(AbstractComponentCallbacksC2216p fragment, AbstractComponentCallbacksC2216p expectedParentFragment, int i7) {
        super(fragment, "Attempting to nest fragment " + fragment + " within the view of parent fragment " + expectedParentFragment + " via container with ID " + i7 + " without using parent's childFragmentManager");
        r.f(fragment, "fragment");
        r.f(expectedParentFragment, "expectedParentFragment");
        this.f19075b = expectedParentFragment;
        this.f19076c = i7;
    }
}
