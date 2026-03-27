package m0;

import android.view.ViewGroup;
import androidx.fragment.app.AbstractComponentCallbacksC1139p;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class d extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f21242b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AbstractComponentCallbacksC1139p fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        AbstractC2304t.f(fragment, "fragment");
        this.f21242b = viewGroup;
    }
}
