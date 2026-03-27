package H;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends I.a {

    /* JADX INFO: renamed from: H.a$a, reason: collision with other inner class name */
    public static class C0039a {
        public static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        public static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        public static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        public static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        public static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    public static class b {
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static void b(Activity activity, String[] strArr, int i8) {
            activity.requestPermissions(strArr, i8);
        }

        public static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public static class c {
        public static boolean a(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        public static boolean b(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    public static class d {
        public static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface e {
        void validateRequestPermissionsRequestCode(int i8);
    }

    public static void o(Activity activity) {
        C0039a.a(activity);
    }

    public static void p(Activity activity) {
        C0039a.b(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void q(Activity activity, String[] strArr, int i8) {
        HashSet hashSet = new HashSet();
        for (int i9 = 0; i9 < strArr.length; i9++) {
            if (TextUtils.isEmpty(strArr[i9])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i9], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i9));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < strArr.length; i11++) {
                if (!hashSet.contains(Integer.valueOf(i11))) {
                    strArr2[i10] = strArr[i11];
                    i10++;
                }
            }
        }
        if (activity instanceof e) {
            ((e) activity).validateRequestPermissionsRequestCode(i8);
        }
        b.b(activity, strArr, i8);
    }

    public static void r(Activity activity, u uVar) {
        C0039a.c(activity, null);
    }

    public static void s(Activity activity, u uVar) {
        C0039a.d(activity, null);
    }

    public static boolean t(Activity activity, String str) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return i8 >= 32 ? d.a(activity, str) : i8 == 31 ? c.b(activity, str) : b.c(activity, str);
        }
        return false;
    }

    public static void u(Activity activity, Intent intent, int i8, Bundle bundle) {
        activity.startActivityForResult(intent, i8, bundle);
    }

    public static void v(Activity activity, IntentSender intentSender, int i8, Intent intent, int i9, int i10, int i11, Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i8, intent, i9, i10, i11, bundle);
    }

    public static void w(Activity activity) {
        C0039a.e(activity);
    }
}
