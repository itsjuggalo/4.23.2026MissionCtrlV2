package Y;

import androidx.fragment.app.AbstractComponentCallbacksC0828p;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class k extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5645b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(AbstractComponentCallbacksC0828p fragment, boolean z4) {
        super(fragment, "Attempting to set user visible hint to " + z4 + " for fragment " + fragment);
        r.f(fragment, "fragment");
        this.f5645b = z4;
    }
}
