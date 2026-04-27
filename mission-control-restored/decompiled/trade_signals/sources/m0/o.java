package m0;

import androidx.fragment.app.AbstractComponentCallbacksC1139p;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class o extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractComponentCallbacksC1139p f21248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21249c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(AbstractComponentCallbacksC1139p fragment, AbstractComponentCallbacksC1139p expectedParentFragment, int i8) {
        super(fragment, "Attempting to nest fragment " + fragment + " within the view of parent fragment " + expectedParentFragment + " via container with ID " + i8 + " without using parent's childFragmentManager");
        AbstractC2304t.f(fragment, "fragment");
        AbstractC2304t.f(expectedParentFragment, "expectedParentFragment");
        this.f21248b = expectedParentFragment;
        this.f21249c = i8;
    }
}
