package J3;

import W2.C0739g;
import p3.InterfaceC1716c;

/* JADX INFO: renamed from: J3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0328c {
    public static final Void a(String str, InterfaceC1716c baseClass) {
        String str2;
        kotlin.jvm.internal.r.f(baseClass, "baseClass");
        String str3 = "in the scope of '" + baseClass.b() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default polymorphic serializers were registered " + str3;
        } else {
            str2 = "Class '" + str + "' is not registered for polymorphic serialization " + str3 + ".\nTo be registered automatically, class '" + str + "' has to be '@Serializable', and the base class '" + baseClass.b() + "' has to be sealed and '@Serializable'.\nAlternatively, register the serializer for '" + str + "' explicitly in a corresponding SerializersModule.";
        }
        throw new F3.g(str2);
    }

    public static final Void b(InterfaceC1716c subClass, InterfaceC1716c baseClass) {
        kotlin.jvm.internal.r.f(subClass, "subClass");
        kotlin.jvm.internal.r.f(baseClass, "baseClass");
        String strB = subClass.b();
        if (strB == null) {
            strB = String.valueOf(subClass);
        }
        a(strB, baseClass);
        throw new C0739g();
    }
}
