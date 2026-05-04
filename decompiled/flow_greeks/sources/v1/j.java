package v1;

import androidx.fragment.app.p;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f23084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23085c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(p fragment, p targetFragment, int i10) {
        super(fragment, "Attempting to set target fragment " + targetFragment + " with request code " + i10 + " for fragment " + fragment);
        t.f(fragment, "fragment");
        t.f(targetFragment, "targetFragment");
        this.f23084b = targetFragment;
        this.f23085c = i10;
    }
}
