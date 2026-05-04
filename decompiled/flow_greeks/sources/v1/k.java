package v1;

import androidx.fragment.app.p;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23086b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(p fragment, boolean z10) {
        super(fragment, "Attempting to set user visible hint to " + z10 + " for fragment " + fragment);
        t.f(fragment, "fragment");
        this.f23086b = z10;
    }
}
