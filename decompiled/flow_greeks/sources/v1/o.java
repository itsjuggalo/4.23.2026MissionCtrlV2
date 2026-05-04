package v1;

import androidx.fragment.app.p;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f23089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23090c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p fragment, p expectedParentFragment, int i10) {
        super(fragment, "Attempting to nest fragment " + fragment + " within the view of parent fragment " + expectedParentFragment + " via container with ID " + i10 + " without using parent's childFragmentManager");
        t.f(fragment, "fragment");
        t.f(expectedParentFragment, "expectedParentFragment");
        this.f23089b = expectedParentFragment;
        this.f23090c = i10;
    }
}
