package d6;

import R5.InterfaceC0856m;
import R5.m0;
import e6.c0;
import h6.y;
import h6.z;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f17016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0856m f17017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f17019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H6.h f17020e;

    public m(k c8, InterfaceC0856m containingDeclaration, z typeParameterOwner, int i8) {
        AbstractC2304t.f(c8, "c");
        AbstractC2304t.f(containingDeclaration, "containingDeclaration");
        AbstractC2304t.f(typeParameterOwner, "typeParameterOwner");
        this.f17016a = c8;
        this.f17017b = containingDeclaration;
        this.f17018c = i8;
        this.f17019d = S6.a.d(typeParameterOwner.getTypeParameters());
        this.f17020e = c8.e().d(new l(this));
    }

    public static final c0 c(m mVar, y typeParameter) {
        AbstractC2304t.f(typeParameter, "typeParameter");
        Integer num = (Integer) mVar.f17019d.get(typeParameter);
        if (num == null) {
            return null;
        }
        return new c0(c.k(c.d(mVar.f17016a, mVar), mVar.f17017b.getAnnotations()), typeParameter, mVar.f17018c + num.intValue(), mVar.f17017b);
    }

    @Override // d6.p
    public m0 a(y javaTypeParameter) {
        AbstractC2304t.f(javaTypeParameter, "javaTypeParameter");
        c0 c0Var = (c0) this.f17020e.invoke(javaTypeParameter);
        return c0Var != null ? c0Var : this.f17016a.f().a(javaTypeParameter);
    }
}
