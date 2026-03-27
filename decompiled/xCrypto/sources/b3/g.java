package b3;

import com.google.firebase.messaging.Constants;
import java.lang.reflect.Field;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static final void a(int i4, int i5) {
        if (i5 <= i4) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i4 + ", got " + i5 + ". Please update the Kotlin standard library.").toString());
    }

    public static final InterfaceC0868f b(AbstractC0863a abstractC0863a) {
        return (InterfaceC0868f) abstractC0863a.getClass().getAnnotation(InterfaceC0868f.class);
    }

    public static final int c(AbstractC0863a abstractC0863a) {
        try {
            Field declaredField = abstractC0863a.getClass().getDeclaredField(Constants.ScionAnalytics.PARAM_LABEL);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(abstractC0863a);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(AbstractC0863a abstractC0863a) {
        String strC;
        r.f(abstractC0863a, "<this>");
        InterfaceC0868f interfaceC0868fB = b(abstractC0863a);
        if (interfaceC0868fB == null) {
            return null;
        }
        a(1, interfaceC0868fB.v());
        int iC = c(abstractC0863a);
        int i4 = iC < 0 ? -1 : interfaceC0868fB.l()[iC];
        String strB = i.f8285a.b(abstractC0863a);
        if (strB == null) {
            strC = interfaceC0868fB.c();
        } else {
            strC = strB + '/' + interfaceC0868fB.c();
        }
        return new StackTraceElement(strC, interfaceC0868fB.m(), interfaceC0868fB.f(), i4);
    }
}
