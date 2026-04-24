package m0;

import androidx.fragment.app.AbstractComponentCallbacksC1139p;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractComponentCallbacksC1139p f21246a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(AbstractComponentCallbacksC1139p fragment, String str) {
        super(str);
        AbstractC2304t.f(fragment, "fragment");
        this.f21246a = fragment;
    }

    public final AbstractComponentCallbacksC1139p a() {
        return this.f21246a;
    }
}
