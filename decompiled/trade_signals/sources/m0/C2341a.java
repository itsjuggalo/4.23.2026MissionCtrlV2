package m0;

import androidx.fragment.app.AbstractComponentCallbacksC1139p;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: m0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2341a extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21223b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2341a(AbstractComponentCallbacksC1139p fragment, String previousFragmentId) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId);
        AbstractC2304t.f(fragment, "fragment");
        AbstractC2304t.f(previousFragmentId, "previousFragmentId");
        this.f21223b = previousFragmentId;
    }
}
