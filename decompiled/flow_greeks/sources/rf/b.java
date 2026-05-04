package rf;

import kotlin.jvm.internal.t;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.e f19873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ef.f f19874d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(fe.e classDescriptor, r0 receiverType, ef.f fVar, g gVar) {
        super(receiverType, gVar);
        t.f(classDescriptor, "classDescriptor");
        t.f(receiverType, "receiverType");
        this.f19873c = classDescriptor;
        this.f19874d = fVar;
    }

    @Override // rf.f
    public ef.f a() {
        return this.f19874d;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.f19873c + " }";
    }
}
