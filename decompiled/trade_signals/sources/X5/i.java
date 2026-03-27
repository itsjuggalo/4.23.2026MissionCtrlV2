package X5;

import h6.InterfaceC1892a;
import h6.InterfaceC1894c;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends AbstractC0992h implements InterfaceC1894c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Annotation f9429c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(q6.f fVar, Annotation annotation) {
        super(fVar, null);
        AbstractC2304t.f(annotation, "annotation");
        this.f9429c = annotation;
    }

    @Override // h6.InterfaceC1894c
    public InterfaceC1892a a() {
        return new C0991g(this.f9429c);
    }
}
