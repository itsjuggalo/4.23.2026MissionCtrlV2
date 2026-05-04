package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final Void a(String str, wd.d baseClass) {
        String str2;
        kotlin.jvm.internal.t.f(baseClass, "baseClass");
        String str3 = "in the polymorphic scope of '" + baseClass.c() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default serializers were registered " + str3 + com.amazon.a.a.o.c.a.b.f4610a;
        } else {
            str2 = "Serializer for subclass '" + str + "' is not found " + str3 + ".\nCheck if class with serial name '" + str + "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '" + str + "' has to be '@Serializable', and the base class '" + baseClass.c() + "' has to be sealed and '@Serializable'.";
        }
        throw new zg.j(str2);
    }

    public static final Void b(wd.d subClass, wd.d baseClass) {
        kotlin.jvm.internal.t.f(subClass, "subClass");
        kotlin.jvm.internal.t.f(baseClass, "baseClass");
        String strC = subClass.c();
        if (strC == null) {
            strC = String.valueOf(subClass);
        }
        a(strC, baseClass);
        throw new cd.h();
    }
}
