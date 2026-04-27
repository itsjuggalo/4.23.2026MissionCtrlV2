package h3;

import kotlin.jvm.internal.G;
import kotlin.jvm.internal.InterfaceC1582g;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: renamed from: h3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1282a {
    public static final Class a(InterfaceC1716c interfaceC1716c) {
        r.f(interfaceC1716c, "<this>");
        Class clsD = ((InterfaceC1582g) interfaceC1716c).d();
        r.d(clsD, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsD;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class b(InterfaceC1716c interfaceC1716c) {
        r.f(interfaceC1716c, "<this>");
        Class clsD = ((InterfaceC1582g) interfaceC1716c).d();
        if (!clsD.isPrimitive()) {
            r.d(clsD, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return clsD;
        }
        String name = clsD.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    clsD = Double.class;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    clsD = Integer.class;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    clsD = Byte.class;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    clsD = Character.class;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    clsD = Long.class;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    clsD = Void.class;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    clsD = Boolean.class;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    clsD = Float.class;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    clsD = Short.class;
                }
                break;
        }
        r.d(clsD, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return clsD;
    }

    public static final InterfaceC1716c c(Class cls) {
        r.f(cls, "<this>");
        return G.b(cls);
    }
}
