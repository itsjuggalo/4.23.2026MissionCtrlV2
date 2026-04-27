package u5;

import java.lang.reflect.Field;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u5.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2780g {
    public static final void a(int i8, int i9) {
        if (i9 <= i8) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i8 + ", got " + i9 + ". Please update the Kotlin standard library.").toString());
    }

    public static final InterfaceC2779f b(AbstractC2774a abstractC2774a) {
        return (InterfaceC2779f) abstractC2774a.getClass().getAnnotation(InterfaceC2779f.class);
    }

    public static final int c(AbstractC2774a abstractC2774a) {
        try {
            Field declaredField = abstractC2774a.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(abstractC2774a);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(AbstractC2774a abstractC2774a) {
        String strC;
        AbstractC2304t.f(abstractC2774a, "<this>");
        InterfaceC2779f interfaceC2779fB = b(abstractC2774a);
        if (interfaceC2779fB == null) {
            return null;
        }
        a(1, interfaceC2779fB.v());
        int iC = c(abstractC2774a);
        int i8 = iC < 0 ? -1 : interfaceC2779fB.l()[iC];
        String strB = C2782i.f23521a.b(abstractC2774a);
        if (strB == null) {
            strC = interfaceC2779fB.c();
        } else {
            strC = strB + '/' + interfaceC2779fB.c();
        }
        return new StackTraceElement(strC, interfaceC2779fB.m(), interfaceC2779fB.f(), i8);
    }
}
