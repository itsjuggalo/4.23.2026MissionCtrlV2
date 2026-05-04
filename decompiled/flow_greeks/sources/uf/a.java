package uf;

import gf.g;
import gf.i;
import kg.z;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends sf.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f22983r = new a();

    /* JADX WARN: Illegal instructions before constructor call */
    public a() {
        g gVarD = g.d();
        af.b.a(gVarD);
        t.e(gVarD, "apply(...)");
        i.f packageFqName = af.b.f812a;
        t.e(packageFqName, "packageFqName");
        i.f constructorAnnotation = af.b.f814c;
        t.e(constructorAnnotation, "constructorAnnotation");
        i.f classAnnotation = af.b.f813b;
        t.e(classAnnotation, "classAnnotation");
        i.f functionAnnotation = af.b.f815d;
        t.e(functionAnnotation, "functionAnnotation");
        i.f propertyAnnotation = af.b.f816e;
        t.e(propertyAnnotation, "propertyAnnotation");
        i.f propertyGetterAnnotation = af.b.f817f;
        t.e(propertyGetterAnnotation, "propertyGetterAnnotation");
        i.f propertySetterAnnotation = af.b.f818g;
        t.e(propertySetterAnnotation, "propertySetterAnnotation");
        i.f enumEntryAnnotation = af.b.f820i;
        t.e(enumEntryAnnotation, "enumEntryAnnotation");
        i.f compileTimeValue = af.b.f819h;
        t.e(compileTimeValue, "compileTimeValue");
        i.f parameterAnnotation = af.b.f821j;
        t.e(parameterAnnotation, "parameterAnnotation");
        i.f typeAnnotation = af.b.f822k;
        t.e(typeAnnotation, "typeAnnotation");
        i.f typeParameterAnnotation = af.b.f823l;
        t.e(typeParameterAnnotation, "typeParameterAnnotation");
        super(gVarD, packageFqName, constructorAnnotation, classAnnotation, functionAnnotation, null, propertyAnnotation, propertyGetterAnnotation, propertySetterAnnotation, null, null, null, enumEntryAnnotation, compileTimeValue, parameterAnnotation, typeAnnotation, typeParameterAnnotation);
    }

    public final String q(ef.c fqName) {
        t.f(fqName, "fqName");
        return s(fqName) + ".kotlin_builtins";
    }

    public final String r(ef.c fqName) {
        t.f(fqName, "fqName");
        return z.E(fqName.a(), com.amazon.a.a.o.c.a.b.f4610a, '/', false, 4, null) + '/' + q(fqName);
    }

    public final String s(ef.c cVar) {
        if (cVar.c()) {
            return "default-package";
        }
        String strB = cVar.f().b();
        t.e(strB, "asString(...)");
        return strB;
    }
}
