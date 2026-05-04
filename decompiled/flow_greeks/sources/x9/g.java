package x9;

import android.app.Application;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.firebase.inappmessaging.model.MessageType;
import u9.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f24681b = 327938;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f24682c = 327970;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f24683a = 65824;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24684a;

        static {
            int[] iArr = new int[MessageType.values().length];
            f24684a = iArr;
            try {
                iArr[MessageType.MODAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24684a[MessageType.CARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24684a[MessageType.IMAGE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24684a[MessageType.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String a(MessageType messageType, int i10) {
        if (i10 == 1) {
            int i11 = a.f24684a[messageType.ordinal()];
            if (i11 == 1) {
                return "MODAL_PORTRAIT";
            }
            if (i11 == 2) {
                return "CARD_PORTRAIT";
            }
            if (i11 == 3) {
                return "IMAGE_ONLY_PORTRAIT";
            }
            if (i11 != 4) {
                return null;
            }
            return "BANNER_PORTRAIT";
        }
        int i12 = a.f24684a[messageType.ordinal()];
        if (i12 == 1) {
            return "MODAL_LANDSCAPE";
        }
        if (i12 == 2) {
            return "CARD_LANDSCAPE";
        }
        if (i12 == 3) {
            return "IMAGE_ONLY_LANDSCAPE";
        }
        if (i12 != 4) {
            return null;
        }
        return "BANNER_LANDSCAPE";
    }

    public u9.k b(DisplayMetrics displayMetrics) {
        k.a aVarQ = u9.k.q();
        Float fValueOf = Float.valueOf(0.3f);
        k.a aVarM = aVarQ.i(fValueOf).j(fValueOf).g(Integer.valueOf((int) (displayMetrics.heightPixels * 0.5f))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f))).k(48).l(Integer.valueOf(this.f24683a)).n(-1).m(-2);
        Boolean bool = Boolean.TRUE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public u9.k c(DisplayMetrics displayMetrics) {
        k.a aVarQ = u9.k.q();
        Float fValueOf = Float.valueOf(0.3f);
        k.a aVarM = aVarQ.i(fValueOf).j(fValueOf).g(Integer.valueOf((int) (displayMetrics.heightPixels * 0.5f))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f))).k(48).l(Integer.valueOf(this.f24683a)).n(-1).m(-2);
        Boolean bool = Boolean.TRUE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public u9.k d(DisplayMetrics displayMetrics) {
        k.a aVarM = u9.k.q().g(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).h(Integer.valueOf(displayMetrics.widthPixels)).i(Float.valueOf(1.0f)).j(Float.valueOf(0.5f)).k(17).l(Integer.valueOf(f24682c)).n(-2).m(-2);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public u9.k e(DisplayMetrics displayMetrics) {
        k.a aVarM = u9.k.q().g(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.7f))).i(Float.valueOf(0.6f)).j(Float.valueOf(1.0f)).e(Float.valueOf(0.1f)).f(Float.valueOf(0.9f)).k(17).l(Integer.valueOf(f24682c)).n(-2).m(-2);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public DisplayMetrics f(Application application) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) application.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public u9.k g(DisplayMetrics displayMetrics) {
        k.a aVarH = u9.k.q().g(Integer.valueOf((int) (displayMetrics.heightPixels * 0.9f))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f)));
        Float fValueOf = Float.valueOf(0.8f);
        k.a aVarM = aVarH.j(fValueOf).i(fValueOf).k(17).l(Integer.valueOf(f24681b)).n(-2).m(-2);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public u9.k h(DisplayMetrics displayMetrics) {
        k.a aVarI = u9.k.q().g(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).h(Integer.valueOf(displayMetrics.widthPixels)).i(Float.valueOf(1.0f));
        Float fValueOf = Float.valueOf(0.4f);
        k.a aVarM = aVarI.j(fValueOf).e(Float.valueOf(0.6f)).f(fValueOf).k(17).l(Integer.valueOf(f24681b)).n(-1).m(-1);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public u9.k i(DisplayMetrics displayMetrics) {
        k.a aVarE = u9.k.q().g(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.7f))).i(Float.valueOf(0.6f)).e(Float.valueOf(0.1f));
        Float fValueOf = Float.valueOf(0.9f);
        k.a aVarM = aVarE.j(fValueOf).f(fValueOf).k(17).l(Integer.valueOf(f24681b)).n(-1).m(-2);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public u9.k j(DisplayMetrics displayMetrics) {
        k.a aVarH = u9.k.q().g(Integer.valueOf((int) (displayMetrics.heightPixels * 0.9f))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f)));
        Float fValueOf = Float.valueOf(0.8f);
        k.a aVarM = aVarH.j(fValueOf).i(fValueOf).k(17).l(Integer.valueOf(f24681b)).n(-2).m(-2);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }
}
