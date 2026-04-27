package F6;

import V6.A;
import kotlin.jvm.internal.AbstractC2304t;
import m6.AbstractC2382b;
import s6.AbstractC2722i;
import s6.C2720g;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends D6.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f1918r = new a();

    /* JADX WARN: Illegal instructions before constructor call */
    public a() {
        C2720g c2720gD = C2720g.d();
        AbstractC2382b.a(c2720gD);
        AbstractC2304t.e(c2720gD, "apply(...)");
        AbstractC2722i.f packageFqName = AbstractC2382b.f21480a;
        AbstractC2304t.e(packageFqName, "packageFqName");
        AbstractC2722i.f constructorAnnotation = AbstractC2382b.f21482c;
        AbstractC2304t.e(constructorAnnotation, "constructorAnnotation");
        AbstractC2722i.f classAnnotation = AbstractC2382b.f21481b;
        AbstractC2304t.e(classAnnotation, "classAnnotation");
        AbstractC2722i.f functionAnnotation = AbstractC2382b.f21483d;
        AbstractC2304t.e(functionAnnotation, "functionAnnotation");
        AbstractC2722i.f propertyAnnotation = AbstractC2382b.f21484e;
        AbstractC2304t.e(propertyAnnotation, "propertyAnnotation");
        AbstractC2722i.f propertyGetterAnnotation = AbstractC2382b.f21485f;
        AbstractC2304t.e(propertyGetterAnnotation, "propertyGetterAnnotation");
        AbstractC2722i.f propertySetterAnnotation = AbstractC2382b.f21486g;
        AbstractC2304t.e(propertySetterAnnotation, "propertySetterAnnotation");
        AbstractC2722i.f enumEntryAnnotation = AbstractC2382b.f21488i;
        AbstractC2304t.e(enumEntryAnnotation, "enumEntryAnnotation");
        AbstractC2722i.f compileTimeValue = AbstractC2382b.f21487h;
        AbstractC2304t.e(compileTimeValue, "compileTimeValue");
        AbstractC2722i.f parameterAnnotation = AbstractC2382b.f21489j;
        AbstractC2304t.e(parameterAnnotation, "parameterAnnotation");
        AbstractC2722i.f typeAnnotation = AbstractC2382b.f21490k;
        AbstractC2304t.e(typeAnnotation, "typeAnnotation");
        AbstractC2722i.f typeParameterAnnotation = AbstractC2382b.f21491l;
        AbstractC2304t.e(typeParameterAnnotation, "typeParameterAnnotation");
        super(c2720gD, packageFqName, constructorAnnotation, classAnnotation, functionAnnotation, null, propertyAnnotation, propertyGetterAnnotation, propertySetterAnnotation, null, null, null, enumEntryAnnotation, compileTimeValue, parameterAnnotation, typeAnnotation, typeParameterAnnotation);
    }

    public final String q(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return s(fqName) + ".kotlin_builtins";
    }

    public final String r(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return A.D(fqName.a(), com.amazon.a.a.o.c.a.b.f14112a, '/', false, 4, null) + '/' + q(fqName);
    }

    public final String s(q6.c cVar) {
        if (cVar.c()) {
            return "default-package";
        }
        String strB = cVar.f().b();
        AbstractC2304t.e(strB, "asString(...)");
        return strB;
    }
}
