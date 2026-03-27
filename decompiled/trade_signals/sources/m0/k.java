package m0;

import androidx.fragment.app.AbstractComponentCallbacksC1139p;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class k extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21245b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(AbstractComponentCallbacksC1139p fragment, boolean z7) {
        super(fragment, "Attempting to set user visible hint to " + z7 + " for fragment " + fragment);
        AbstractC2304t.f(fragment, "fragment");
        this.f21245b = z7;
    }
}
