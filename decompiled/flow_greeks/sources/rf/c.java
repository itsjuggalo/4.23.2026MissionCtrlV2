package rf;

import kotlin.jvm.internal.t;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends a implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.a f19875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ef.f f19876d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(fe.a declarationDescriptor, r0 receiverType, ef.f fVar, g gVar) {
        super(receiverType, gVar);
        t.f(declarationDescriptor, "declarationDescriptor");
        t.f(receiverType, "receiverType");
        this.f19875c = declarationDescriptor;
        this.f19876d = fVar;
    }

    @Override // rf.f
    public ef.f a() {
        return this.f19876d;
    }

    public fe.a c() {
        return this.f19875c;
    }

    public String toString() {
        return "Cxt { " + c() + " }";
    }
}
