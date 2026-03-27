package C6;

import I6.S;
import R5.InterfaceC0844a;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0844a f637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q6.f f638d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(InterfaceC0844a declarationDescriptor, S receiverType, q6.f fVar, g gVar) {
        super(receiverType, gVar);
        AbstractC2304t.f(declarationDescriptor, "declarationDescriptor");
        AbstractC2304t.f(receiverType, "receiverType");
        this.f637c = declarationDescriptor;
        this.f638d = fVar;
    }

    @Override // C6.f
    public q6.f a() {
        return this.f638d;
    }

    public InterfaceC0844a c() {
        return this.f637c;
    }

    public String toString() {
        return "Cxt { " + c() + " }";
    }
}
