package xe;

import java.util.Map;
import xe.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f24841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f24842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f24843c;

    public g(Map memberAnnotations, Map propertyConstants, Map annotationParametersDefaultValues) {
        kotlin.jvm.internal.t.f(memberAnnotations, "memberAnnotations");
        kotlin.jvm.internal.t.f(propertyConstants, "propertyConstants");
        kotlin.jvm.internal.t.f(annotationParametersDefaultValues, "annotationParametersDefaultValues");
        this.f24841a = memberAnnotations;
        this.f24842b = propertyConstants;
        this.f24843c = annotationParametersDefaultValues;
    }

    @Override // xe.e.a
    public Map a() {
        return this.f24841a;
    }

    public final Map b() {
        return this.f24843c;
    }

    public final Map c() {
        return this.f24842b;
    }
}
