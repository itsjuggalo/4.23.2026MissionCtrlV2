package C6;

import I6.S;
import R5.InterfaceC0848e;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0848e f635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q6.f f636d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(InterfaceC0848e classDescriptor, S receiverType, q6.f fVar, g gVar) {
        super(receiverType, gVar);
        AbstractC2304t.f(classDescriptor, "classDescriptor");
        AbstractC2304t.f(receiverType, "receiverType");
        this.f635c = classDescriptor;
        this.f636d = fVar;
    }

    @Override // C6.f
    public q6.f a() {
        return this.f636d;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.f635c + " }";
    }
}
