package H3;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.graphics.Point;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Application f3663b;

        public a(View view, Application application) {
            this.f3662a = view;
            this.f3663b = application;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f3662a.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(this.f3663b.getResources().getInteger(R.integer.config_longAnimTime)).setListener(null);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3665a;

        static {
            int[] iArr = new int[EnumC0046c.values().length];
            f3665a = iArr;
            try {
                iArr[EnumC0046c.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3665a[EnumC0046c.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3665a[EnumC0046c.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3665a[EnumC0046c.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: H3.c$c, reason: collision with other inner class name */
    public enum EnumC0046c {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM;

        public static Point g(EnumC0046c enumC0046c, View view) {
            view.measure(-2, -2);
            int i8 = b.f3665a[enumC0046c.ordinal()];
            return i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? new Point(0, view.getMeasuredHeight() * (-1)) : new Point(0, view.getMeasuredHeight()) : new Point(0, view.getMeasuredHeight() * (-1)) : new Point(view.getMeasuredWidth(), 0) : new Point(view.getMeasuredWidth() * (-1), 0);
        }
    }

    public void a(Application application, View view, EnumC0046c enumC0046c) {
        view.setAlpha(0.0f);
        Point pointG = EnumC0046c.g(enumC0046c, view);
        view.animate().translationX(pointG.x).translationY(pointG.y).setDuration(1L).setListener(new a(view, application));
    }
}
