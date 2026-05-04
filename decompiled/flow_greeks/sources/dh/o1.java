package dh;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o1 extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bh.e f8199b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(zg.b primitiveSerializer) {
        super(primitiveSerializer, null);
        kotlin.jvm.internal.t.f(primitiveSerializer, "primitiveSerializer");
        this.f8199b = new n1(primitiveSerializer.getDescriptor());
    }

    @Override // dh.a
    public final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // dh.a, zg.a
    public final Object deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return f(decoder, null);
    }

    @Override // dh.p, zg.b, zg.k, zg.a
    public final bh.e getDescriptor() {
        return this.f8199b;
    }

    @Override // dh.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final m1 a() {
        return (m1) k(r());
    }

    @Override // dh.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final int b(m1 m1Var) {
        kotlin.jvm.internal.t.f(m1Var, "<this>");
        return m1Var.d();
    }

    @Override // dh.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void c(m1 m1Var, int i10) {
        kotlin.jvm.internal.t.f(m1Var, "<this>");
        m1Var.b(i10);
    }

    public abstract Object r();

    @Override // dh.p
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void n(m1 m1Var, int i10, Object obj) {
        kotlin.jvm.internal.t.f(m1Var, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    @Override // dh.p, zg.k
    public final void serialize(ch.f encoder, Object obj) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        int iE = e(obj);
        bh.e eVar = this.f8199b;
        ch.d dVarZ = encoder.z(eVar, iE);
        u(dVarZ, obj, iE);
        dVarZ.c(eVar);
    }

    @Override // dh.a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final Object l(m1 m1Var) {
        kotlin.jvm.internal.t.f(m1Var, "<this>");
        return m1Var.a();
    }

    public abstract void u(ch.d dVar, Object obj, int i10);
}
