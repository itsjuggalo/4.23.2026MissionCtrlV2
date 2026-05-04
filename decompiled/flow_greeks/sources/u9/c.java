package u9;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.graphics.Point;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f22428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Application f22429b;

        public a(View view, Application application) {
            this.f22428a = view;
            this.f22429b = application;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f22428a.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(this.f22429b.getResources().getInteger(R.integer.config_longAnimTime)).setListener(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22431a;

        static {
            int[] iArr = new int[EnumC0387c.values().length];
            f22431a = iArr;
            try {
                iArr[EnumC0387c.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22431a[EnumC0387c.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22431a[EnumC0387c.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22431a[EnumC0387c.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: u9.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum EnumC0387c {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM;

        public static Point c(EnumC0387c enumC0387c, View view) {
            view.measure(-2, -2);
            int i10 = b.f22431a[enumC0387c.ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new Point(0, view.getMeasuredHeight() * (-1)) : new Point(0, view.getMeasuredHeight()) : new Point(0, view.getMeasuredHeight() * (-1)) : new Point(view.getMeasuredWidth(), 0) : new Point(view.getMeasuredWidth() * (-1), 0);
        }
    }

    public void a(Application application, View view, EnumC0387c enumC0387c) {
        view.setAlpha(0.0f);
        Point pointC = EnumC0387c.c(enumC0387c, view);
        view.animate().translationX(pointC.x).translationY(pointC.y).setDuration(1L).setListener(new a(view, application));
    }
}
