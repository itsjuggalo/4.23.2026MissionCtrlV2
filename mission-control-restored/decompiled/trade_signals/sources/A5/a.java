package A5;

import I5.d;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.InterfaceC2293h;
import kotlin.jvm.internal.O;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final d a(Annotation annotation) {
        AbstractC2304t.f(annotation, "<this>");
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        AbstractC2304t.e(clsAnnotationType, "annotationType(...)");
        d dVarE = e(clsAnnotationType);
        AbstractC2304t.d(dVarE, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return dVarE;
    }

    public static final Class b(d dVar) {
        AbstractC2304t.f(dVar, "<this>");
        Class clsE = ((InterfaceC2293h) dVar).e();
        AbstractC2304t.d(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class c(d dVar) {
        AbstractC2304t.f(dVar, "<this>");
        Class clsE = ((InterfaceC2293h) dVar).e();
        if (!clsE.isPrimitive()) {
            AbstractC2304t.d(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
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
        AbstractC2304t.d(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return clsE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class d(d dVar) {
        AbstractC2304t.f(dVar, "<this>");
        Class clsE = ((InterfaceC2293h) dVar).e();
        if (clsE.isPrimitive()) {
            AbstractC2304t.d(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return clsE;
        }
        String name = clsE.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final d e(Class cls) {
        AbstractC2304t.f(cls, "<this>");
        return O.b(cls);
    }
}
