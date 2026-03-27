package Y;

import androidx.fragment.app.AbstractComponentCallbacksC0828p;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractComponentCallbacksC0828p f5646a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(AbstractComponentCallbacksC0828p fragment, String str) {
        super(str);
        r.f(fragment, "fragment");
        this.f5646a = fragment;
    }

    public final AbstractComponentCallbacksC0828p a() {
        return this.f5646a;
    }
}
