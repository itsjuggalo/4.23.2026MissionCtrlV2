package n0;

import android.view.ViewGroup;
import kotlin.jvm.internal.r;
import m0.AbstractComponentCallbacksC2216p;

/* JADX INFO: loaded from: classes.dex */
public final class h extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f19074b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(AbstractComponentCallbacksC2216p fragment, ViewGroup container) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + container + " which is not a FragmentContainerView");
        r.f(fragment, "fragment");
        r.f(container, "container");
        this.f19074b = container;
    }
}
