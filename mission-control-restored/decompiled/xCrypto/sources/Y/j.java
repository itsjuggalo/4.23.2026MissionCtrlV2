package Y;

import androidx.fragment.app.AbstractComponentCallbacksC0828p;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class j extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractComponentCallbacksC0828p f5643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5644c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(AbstractComponentCallbacksC0828p fragment, AbstractComponentCallbacksC0828p targetFragment, int i4) {
        super(fragment, "Attempting to set target fragment " + targetFragment + " with request code " + i4 + " for fragment " + fragment);
        r.f(fragment, "fragment");
        r.f(targetFragment, "targetFragment");
        this.f5643b = targetFragment;
        this.f5644c = i4;
    }
}
