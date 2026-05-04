package v1;

import android.view.ViewGroup;
import androidx.fragment.app.p;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f23083b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(p fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        t.f(fragment, "fragment");
        this.f23083b = viewGroup;
    }
}
