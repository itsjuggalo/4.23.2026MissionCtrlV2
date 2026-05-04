package le;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends h implements ve.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Annotation f15628c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ef.f fVar, Annotation annotation) {
        super(fVar, null);
        kotlin.jvm.internal.t.f(annotation, "annotation");
        this.f15628c = annotation;
    }

    @Override // ve.c
    public ve.a a() {
        return new g(this.f15628c);
    }
}
