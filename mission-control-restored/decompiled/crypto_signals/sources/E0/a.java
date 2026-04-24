package E0;

import H4.p;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static int a(SidecarDeviceState sidecarDeviceState) {
        kotlin.jvm.internal.j.e(sidecarDeviceState, "sidecarDeviceState");
        try {
            return sidecarDeviceState.posture;
        } catch (NoSuchFieldError unused) {
            try {
                Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                kotlin.jvm.internal.j.c(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) objInvoke).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }
    }

    public static int b(SidecarDeviceState sidecarDeviceState) {
        kotlin.jvm.internal.j.e(sidecarDeviceState, "sidecarDeviceState");
        int iA = a(sidecarDeviceState);
        if (iA < 0 || iA > 4) {
            return 0;
        }
        return iA;
    }

    public static List c(SidecarWindowLayoutInfo info) {
        List list;
        p pVar = p.f577a;
        kotlin.jvm.internal.j.e(info, "info");
        try {
            try {
                list = info.displayFeatures;
            } catch (NoSuchFieldError unused) {
                Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(info, new Object[0]);
                kotlin.jvm.internal.j.c(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                return (List) objInvoke;
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
        return list == null ? pVar : list;
    }

    public static void d(SidecarDeviceState sidecarDeviceState, int i) {
        try {
            try {
                sidecarDeviceState.posture = i;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        } catch (NoSuchFieldError unused2) {
            SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i));
        }
    }
}
