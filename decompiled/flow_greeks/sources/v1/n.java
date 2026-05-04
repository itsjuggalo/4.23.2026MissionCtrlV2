package v1;

import android.view.ViewGroup;
import androidx.fragment.app.p;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f23088b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(p fragment, ViewGroup container) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + container + " which is not a FragmentContainerView");
        t.f(fragment, "fragment");
        t.f(container, "container");
        this.f23088b = container;
    }
}
