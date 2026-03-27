package n0;

import android.view.ViewGroup;
import kotlin.jvm.internal.r;
import m0.AbstractComponentCallbacksC2216p;

/* JADX INFO: loaded from: classes.dex */
public final class d extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f19072b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AbstractComponentCallbacksC2216p fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        r.f(fragment, "fragment");
        this.f19072b = viewGroup;
    }
}
