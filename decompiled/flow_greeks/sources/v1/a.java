package v1;

import androidx.fragment.app.p;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23064b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(p fragment, String previousFragmentId) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId);
        t.f(fragment, "fragment");
        t.f(previousFragmentId, "previousFragmentId");
        this.f23064b = previousFragmentId;
    }
}
