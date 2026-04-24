package Y;

import android.view.ViewGroup;
import androidx.fragment.app.AbstractComponentCallbacksC0828p;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class n extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f5647b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(AbstractComponentCallbacksC0828p fragment, ViewGroup container) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + container + " which is not a FragmentContainerView");
        r.f(fragment, "fragment");
        r.f(container, "container");
        this.f5647b = container;
    }
}
