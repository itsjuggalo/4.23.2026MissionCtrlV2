package Y;

import androidx.fragment.app.AbstractComponentCallbacksC0828p;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class o extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractComponentCallbacksC0828p f5648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5649c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(AbstractComponentCallbacksC0828p fragment, AbstractComponentCallbacksC0828p expectedParentFragment, int i4) {
        super(fragment, "Attempting to nest fragment " + fragment + " within the view of parent fragment " + expectedParentFragment + " via container with ID " + i4 + " without using parent's childFragmentManager");
        r.f(fragment, "fragment");
        r.f(expectedParentFragment, "expectedParentFragment");
        this.f5648b = expectedParentFragment;
        this.f5649c = i4;
    }
}
