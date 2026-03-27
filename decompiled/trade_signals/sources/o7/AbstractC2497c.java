package o7;

import kotlin.jvm.internal.AbstractC2304t;
import o5.C2480h;

/* JADX INFO: renamed from: o7.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2497c {
    public static final Void a(I5.d subClass, I5.d baseClass) {
        AbstractC2304t.f(subClass, "subClass");
        AbstractC2304t.f(baseClass, "baseClass");
        String strR = subClass.r();
        if (strR == null) {
            strR = String.valueOf(subClass);
        }
        b(strR, baseClass);
        throw new C2480h();
    }

    public static final Void b(String str, I5.d baseClass) {
        String str2;
        AbstractC2304t.f(baseClass, "baseClass");
        String str3 = "in the polymorphic scope of '" + baseClass.r() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default serializers were registered " + str3 + com.amazon.a.a.o.c.a.b.f14112a;
        } else {
            str2 = "Serializer for subclass '" + str + "' is not found " + str3 + ".\nCheck if class with serial name '" + str + "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '" + str + "' has to be '@Serializable', and the base class '" + baseClass.r() + "' has to be sealed and '@Serializable'.";
        }
        throw new k7.j(str2);
    }
}
