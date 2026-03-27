package m0;

import android.view.ViewGroup;
import androidx.fragment.app.AbstractComponentCallbacksC1139p;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class n extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f21247b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(AbstractComponentCallbacksC1139p fragment, ViewGroup container) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + container + " which is not a FragmentContainerView");
        AbstractC2304t.f(fragment, "fragment");
        AbstractC2304t.f(container, "container");
        this.f21247b = container;
    }
}
