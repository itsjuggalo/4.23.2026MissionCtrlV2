package o7;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2524p0 extends AbstractC2523p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m7.e f22197b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC2524p0(k7.b primitiveSerializer) {
        super(primitiveSerializer, null);
        AbstractC2304t.f(primitiveSerializer, "primitiveSerializer");
        this.f22197b = new C2522o0(primitiveSerializer.getDescriptor());
    }

    @Override // o7.AbstractC2493a
    public final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    @Override // o7.AbstractC2493a, k7.a
    public final Object deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return f(decoder, null);
    }

    @Override // o7.AbstractC2523p, k7.b, k7.k, k7.a
    public final m7.e getDescriptor() {
        return this.f22197b;
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final AbstractC2520n0 a() {
        return (AbstractC2520n0) k(r());
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final int b(AbstractC2520n0 abstractC2520n0) {
        AbstractC2304t.f(abstractC2520n0, "<this>");
        return abstractC2520n0.d();
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void c(AbstractC2520n0 abstractC2520n0, int i8) {
        AbstractC2304t.f(abstractC2520n0, "<this>");
        abstractC2520n0.b(i8);
    }

    public abstract Object r();

    @Override // o7.AbstractC2523p
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void n(AbstractC2520n0 abstractC2520n0, int i8, Object obj) {
        AbstractC2304t.f(abstractC2520n0, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    @Override // o7.AbstractC2523p, k7.k
    public final void serialize(n7.f encoder, Object obj) {
        AbstractC2304t.f(encoder, "encoder");
        int iE = e(obj);
        m7.e eVar = this.f22197b;
        n7.d dVarZ = encoder.z(eVar, iE);
        u(dVarZ, obj, iE);
        dVarZ.d(eVar);
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final Object l(AbstractC2520n0 abstractC2520n0) {
        AbstractC2304t.f(abstractC2520n0, "<this>");
        return abstractC2520n0.a();
    }

    public abstract void u(n7.d dVar, Object obj, int i8);
}
