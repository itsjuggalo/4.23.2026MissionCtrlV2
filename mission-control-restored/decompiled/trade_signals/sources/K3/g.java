package K3;

import H3.k;
import android.app.Application;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.firebase.inappmessaging.model.MessageType;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f4740b = 327938;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f4741c = 327970;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4742a = 65824;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4743a;

        static {
            int[] iArr = new int[MessageType.values().length];
            f4743a = iArr;
            try {
                iArr[MessageType.MODAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4743a[MessageType.CARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4743a[MessageType.IMAGE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4743a[MessageType.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String a(MessageType messageType, int i8) {
        if (i8 == 1) {
            int i9 = a.f4743a[messageType.ordinal()];
            if (i9 == 1) {
                return "MODAL_PORTRAIT";
            }
            if (i9 == 2) {
                return "CARD_PORTRAIT";
            }
            if (i9 == 3) {
                return "IMAGE_ONLY_PORTRAIT";
            }
            if (i9 != 4) {
                return null;
            }
            return "BANNER_PORTRAIT";
        }
        int i10 = a.f4743a[messageType.ordinal()];
        if (i10 == 1) {
            return "MODAL_LANDSCAPE";
        }
        if (i10 == 2) {
            return "CARD_LANDSCAPE";
        }
        if (i10 == 3) {
            return "IMAGE_ONLY_LANDSCAPE";
        }
        if (i10 != 4) {
            return null;
        }
        return "BANNER_LANDSCAPE";
    }

    public H3.k b(DisplayMetrics displayMetrics) {
        k.a aVarQ = H3.k.q();
        Float fValueOf = Float.valueOf(0.3f);
        k.a aVarM = aVarQ.i(fValueOf).j(fValueOf).g(Integer.valueOf((int) (displayMetrics.heightPixels * 0.5f))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f))).k(48).l(Integer.valueOf(this.f4742a)).n(-1).m(-2);
        Boolean bool = Boolean.TRUE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public H3.k c(DisplayMetrics displayMetrics) {
        k.a aVarQ = H3.k.q();
        Float fValueOf = Float.valueOf(0.3f);
        k.a aVarM = aVarQ.i(fValueOf).j(fValueOf).g(Integer.valueOf((int) (displayMetrics.heightPixels * 0.5f))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f))).k(48).l(Integer.valueOf(this.f4742a)).n(-1).m(-2);
        Boolean bool = Boolean.TRUE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public H3.k d(DisplayMetrics displayMetrics) {
        k.a aVarM = H3.k.q().g(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).h(Integer.valueOf(displayMetrics.widthPixels)).i(Float.valueOf(1.0f)).j(Float.valueOf(0.5f)).k(17).l(Integer.valueOf(f4741c)).n(-2).m(-2);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public H3.k e(DisplayMetrics displayMetrics) {
        k.a aVarM = H3.k.q().g(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.7f))).i(Float.valueOf(0.6f)).j(Float.valueOf(1.0f)).e(Float.valueOf(0.1f)).f(Float.valueOf(0.9f)).k(17).l(Integer.valueOf(f4741c)).n(-2).m(-2);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public DisplayMetrics f(Application application) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) application.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public H3.k g(DisplayMetrics displayMetrics) {
        k.a aVarH = H3.k.q().g(Integer.valueOf((int) (displayMetrics.heightPixels * 0.9f))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f)));
        Float fValueOf = Float.valueOf(0.8f);
        k.a aVarM = aVarH.j(fValueOf).i(fValueOf).k(17).l(Integer.valueOf(f4740b)).n(-2).m(-2);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public H3.k h(DisplayMetrics displayMetrics) {
        k.a aVarI = H3.k.q().g(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).h(Integer.valueOf(displayMetrics.widthPixels)).i(Float.valueOf(1.0f));
        Float fValueOf = Float.valueOf(0.4f);
        k.a aVarM = aVarI.j(fValueOf).e(Float.valueOf(0.6f)).f(fValueOf).k(17).l(Integer.valueOf(f4740b)).n(-1).m(-1);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public H3.k i(DisplayMetrics displayMetrics) {
        k.a aVarE = H3.k.q().g(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.7f))).i(Float.valueOf(0.6f)).e(Float.valueOf(0.1f));
        Float fValueOf = Float.valueOf(0.9f);
        k.a aVarM = aVarE.j(fValueOf).f(fValueOf).k(17).l(Integer.valueOf(f4740b)).n(-1).m(-2);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }

    public H3.k j(DisplayMetrics displayMetrics) {
        k.a aVarH = H3.k.q().g(Integer.valueOf((int) (displayMetrics.heightPixels * 0.9f))).h(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f)));
        Float fValueOf = Float.valueOf(0.8f);
        k.a aVarM = aVarH.j(fValueOf).i(fValueOf).k(17).l(Integer.valueOf(f4740b)).n(-2).m(-2);
        Boolean bool = Boolean.FALSE;
        return aVarM.d(bool).b(bool).c(bool).a();
    }
}
