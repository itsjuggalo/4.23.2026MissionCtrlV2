package J3;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g0 extends AbstractC0343p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H3.e f928b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(F3.b primitiveSerializer) {
        super(primitiveSerializer, null);
        kotlin.jvm.internal.r.f(primitiveSerializer, "primitiveSerializer");
        this.f928b = new f0(primitiveSerializer.getDescriptor());
    }

    @Override // J3.AbstractC0324a
    public final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // J3.AbstractC0324a, F3.a
    public final Object deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return f(decoder, null);
    }

    @Override // J3.AbstractC0343p, F3.b, F3.h, F3.a
    public final H3.e getDescriptor() {
        return this.f928b;
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final e0 a() {
        return (e0) k(r());
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final int b(e0 e0Var) {
        kotlin.jvm.internal.r.f(e0Var, "<this>");
        return e0Var.d();
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void c(e0 e0Var, int i4) {
        kotlin.jvm.internal.r.f(e0Var, "<this>");
        e0Var.b(i4);
    }

    public abstract Object r();

    @Override // J3.AbstractC0343p
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void n(e0 e0Var, int i4, Object obj) {
        kotlin.jvm.internal.r.f(e0Var, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    @Override // J3.AbstractC0343p, F3.h
    public final void serialize(I3.f encoder, Object obj) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        int iE = e(obj);
        H3.e eVar = this.f928b;
        I3.d dVarV = encoder.v(eVar, iE);
        u(dVarV, obj, iE);
        dVarV.c(eVar);
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final Object l(e0 e0Var) {
        kotlin.jvm.internal.r.f(e0Var, "<this>");
        return e0Var.a();
    }

    public abstract void u(I3.d dVar, Object obj, int i4);
}
