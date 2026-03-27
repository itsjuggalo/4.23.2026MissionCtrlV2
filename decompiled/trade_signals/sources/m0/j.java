package m0;

import androidx.fragment.app.AbstractComponentCallbacksC1139p;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class j extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractComponentCallbacksC1139p f21243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21244c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(AbstractComponentCallbacksC1139p fragment, AbstractComponentCallbacksC1139p targetFragment, int i8) {
        super(fragment, "Attempting to set target fragment " + targetFragment + " with request code " + i8 + " for fragment " + fragment);
        AbstractC2304t.f(fragment, "fragment");
        AbstractC2304t.f(targetFragment, "targetFragment");
        this.f21243b = targetFragment;
        this.f21244c = i8;
    }
}
