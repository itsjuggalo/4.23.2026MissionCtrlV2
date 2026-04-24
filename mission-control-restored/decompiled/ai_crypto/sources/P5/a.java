package P5;

import X5.c;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.InterfaceC2145g;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final Class a(c cVar) {
        r.f(cVar, "<this>");
        Class clsE = ((InterfaceC2145g) cVar).e();
        r.d(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class b(c cVar) {
        r.f(cVar, "<this>");
        Class clsE = ((InterfaceC2145g) cVar).e();
        if (!clsE.isPrimitive()) {
            r.d(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return clsE;
        }
        String name = clsE.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    clsE = Double.class;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    clsE = Integer.class;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    clsE = Byte.class;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    clsE = Character.class;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    clsE = Long.class;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    clsE = Void.class;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    clsE = Boolean.class;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    clsE = Float.class;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    clsE = Short.class;
                }
                break;
        }
        r.d(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return clsE;
    }

    public static final c c(Class cls) {
        r.f(cls, "<this>");
        return H.b(cls);
    }
}
