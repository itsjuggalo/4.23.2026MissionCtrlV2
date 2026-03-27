package n0;

import kotlin.jvm.internal.r;
import m0.AbstractComponentCallbacksC2216p;

/* JADX INFO: renamed from: n0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2249a extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19053b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2249a(AbstractComponentCallbacksC2216p fragment, String previousFragmentId) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId);
        r.f(fragment, "fragment");
        r.f(previousFragmentId, "previousFragmentId");
        this.f19053b = previousFragmentId;
    }
}
