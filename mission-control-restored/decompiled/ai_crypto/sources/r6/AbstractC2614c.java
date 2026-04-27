package r6;

import E5.C0462g;

/* JADX INFO: renamed from: r6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2614c {
    public static final Void a(X5.c subClass, X5.c baseClass) {
        kotlin.jvm.internal.r.f(subClass, "subClass");
        kotlin.jvm.internal.r.f(baseClass, "baseClass");
        String strC = subClass.c();
        if (strC == null) {
            strC = String.valueOf(subClass);
        }
        b(strC, baseClass);
        throw new C0462g();
    }

    public static final Void b(String str, X5.c baseClass) {
        String str2;
        kotlin.jvm.internal.r.f(baseClass, "baseClass");
        String str3 = "in the scope of '" + baseClass.c() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default polymorphic serializers were registered " + str3;
        } else {
            str2 = "Class '" + str + "' is not registered for polymorphic serialization " + str3 + ".\nTo be registered automatically, class '" + str + "' has to be '@Serializable', and the base class '" + baseClass.c() + "' has to be sealed and '@Serializable'.\nAlternatively, register the serializer for '" + str + "' explicitly in a corresponding SerializersModule.";
        }
        throw new n6.g(str2);
    }
}
