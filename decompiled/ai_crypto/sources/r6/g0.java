package r6;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g0 extends AbstractC2629p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.e f22885b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(n6.b primitiveSerializer) {
        super(primitiveSerializer, null);
        kotlin.jvm.internal.r.f(primitiveSerializer, "primitiveSerializer");
        this.f22885b = new f0(primitiveSerializer.getDescriptor());
    }

    @Override // r6.AbstractC2610a
    public final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // r6.AbstractC2610a, n6.a
    public final Object deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return f(decoder, null);
    }

    @Override // r6.AbstractC2629p, n6.b, n6.h, n6.a
    public final p6.e getDescriptor() {
        return this.f22885b;
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final e0 a() {
        return (e0) k(r());
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final int b(e0 e0Var) {
        kotlin.jvm.internal.r.f(e0Var, "<this>");
        return e0Var.d();
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void c(e0 e0Var, int i7) {
        kotlin.jvm.internal.r.f(e0Var, "<this>");
        e0Var.b(i7);
    }

    public abstract Object r();

    @Override // r6.AbstractC2629p
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void n(e0 e0Var, int i7, Object obj) {
        kotlin.jvm.internal.r.f(e0Var, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    @Override // r6.AbstractC2629p, n6.h
    public final void serialize(q6.f encoder, Object obj) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        int iE = e(obj);
        p6.e eVar = this.f22885b;
        q6.d dVarV = encoder.v(eVar, iE);
        u(dVarV, obj, iE);
        dVarV.b(eVar);
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final Object l(e0 e0Var) {
        kotlin.jvm.internal.r.f(e0Var, "<this>");
        return e0Var.a();
    }

    public abstract void u(q6.d dVar, Object obj, int i7);
}
