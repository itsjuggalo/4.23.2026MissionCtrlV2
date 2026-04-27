package I0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: renamed from: I0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0562c extends AbstractC0571l {

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final String[] f2732Q = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final Property f2733R = new b(PointF.class, "boundsOrigin");

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final Property f2734S = new C0026c(PointF.class, "topLeft");

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final Property f2735T = new d(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final Property f2736U = new e(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final Property f2737V = new f(PointF.class, "topLeft");

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final Property f2738W = new g(PointF.class, "position");

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static C0569j f2739X = new C0569j();

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int[] f2740I = new int[2];

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f2741O = false;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f2742P = false;

    /* JADX INFO: renamed from: I0.c$a */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f2744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f2745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f2746d;

        public a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f7) {
            this.f2743a = viewGroup;
            this.f2744b = bitmapDrawable;
            this.f2745c = view;
            this.f2746d = f7;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            A.b(this.f2743a).b(this.f2744b);
            A.g(this.f2745c, this.f2746d);
        }
    }

    /* JADX INFO: renamed from: I0.c$b */
    public class b extends Property {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f2748a;

        public b(Class cls, String str) {
            super(cls, str);
            this.f2748a = new Rect();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f2748a);
            Rect rect = this.f2748a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f2748a);
            this.f2748a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f2748a);
        }
    }

    /* JADX INFO: renamed from: I0.c$c, reason: collision with other inner class name */
    public class C0026c extends Property {
        public C0026c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* JADX INFO: renamed from: I0.c$d */
    public class d extends Property {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* JADX INFO: renamed from: I0.c$e */
    public class e extends Property {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            A.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* JADX INFO: renamed from: I0.c$f */
    public class f extends Property {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            A.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: renamed from: I0.c$g */
    public class g extends Property {
        public g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            A.f(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* JADX INFO: renamed from: I0.c$h */
    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f2749a;
        private k mViewBounds;

        public h(k kVar) {
            this.f2749a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* JADX INFO: renamed from: I0.c$i */
    public class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f2753c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f2754d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f2755e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f2756f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f2757g;

        public i(View view, Rect rect, int i7, int i8, int i9, int i10) {
            this.f2752b = view;
            this.f2753c = rect;
            this.f2754d = i7;
            this.f2755e = i8;
            this.f2756f = i9;
            this.f2757g = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2751a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2751a) {
                return;
            }
            Q.N.s0(this.f2752b, this.f2753c);
            A.f(this.f2752b, this.f2754d, this.f2755e, this.f2756f, this.f2757g);
        }
    }

    /* JADX INFO: renamed from: I0.c$j */
    public class j extends AbstractC0572m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2759a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2760b;

        public j(ViewGroup viewGroup) {
            this.f2760b = viewGroup;
        }

        @Override // I0.AbstractC0572m, I0.AbstractC0571l.f
        public void a(AbstractC0571l abstractC0571l) {
            x.c(this.f2760b, false);
        }

        @Override // I0.AbstractC0572m, I0.AbstractC0571l.f
        public void b(AbstractC0571l abstractC0571l) {
            x.c(this.f2760b, true);
        }

        @Override // I0.AbstractC0572m, I0.AbstractC0571l.f
        public void d(AbstractC0571l abstractC0571l) {
            x.c(this.f2760b, false);
            this.f2759a = true;
        }

        @Override // I0.AbstractC0571l.f
        public void e(AbstractC0571l abstractC0571l) {
            if (!this.f2759a) {
                x.c(this.f2760b, false);
            }
            abstractC0571l.P(this);
        }
    }

    /* JADX INFO: renamed from: I0.c$k */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f2766e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2767f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2768g;

        public k(View view) {
            this.f2766e = view;
        }

        public void a(PointF pointF) {
            this.f2764c = Math.round(pointF.x);
            this.f2765d = Math.round(pointF.y);
            int i7 = this.f2768g + 1;
            this.f2768g = i7;
            if (this.f2767f == i7) {
                b();
            }
        }

        public final void b() {
            A.f(this.f2766e, this.f2762a, this.f2763b, this.f2764c, this.f2765d);
            this.f2767f = 0;
            this.f2768g = 0;
        }

        public void c(PointF pointF) {
            this.f2762a = Math.round(pointF.x);
            this.f2763b = Math.round(pointF.y);
            int i7 = this.f2767f + 1;
            this.f2767f = i7;
            if (i7 == this.f2768g) {
                b();
            }
        }
    }

    @Override // I0.AbstractC0571l
    public String[] D() {
        return f2732Q;
    }

    public final void c0(s sVar) {
        View view = sVar.f2855b;
        if (!Q.N.P(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f2854a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f2854a.put("android:changeBounds:parent", sVar.f2855b.getParent());
        if (this.f2742P) {
            sVar.f2855b.getLocationInWindow(this.f2740I);
            sVar.f2854a.put("android:changeBounds:windowX", Integer.valueOf(this.f2740I[0]));
            sVar.f2854a.put("android:changeBounds:windowY", Integer.valueOf(this.f2740I[1]));
        }
        if (this.f2741O) {
            sVar.f2854a.put("android:changeBounds:clip", Q.N.s(view));
        }
    }

    public final boolean d0(View view, View view2) {
        if (!this.f2742P) {
            return true;
        }
        s sVarT = t(view, true);
        if (sVarT == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == sVarT.f2855b) {
            return true;
        }
        return false;
    }

    @Override // I0.AbstractC0571l
    public void f(s sVar) {
        c0(sVar);
    }

    @Override // I0.AbstractC0571l
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // I0.AbstractC0571l
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        int i7;
        View view;
        int i8;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map map = sVar.f2854a;
        Map map2 = sVar2.f2854a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f2855b;
        if (!d0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) sVar.f2854a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) sVar.f2854a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) sVar2.f2854a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) sVar2.f2854a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.f2740I);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fC = A.c(view2);
            A.g(view2, 0.0f);
            A.b(viewGroup).a(bitmapDrawable);
            AbstractC0566g abstractC0566gV = v();
            int[] iArr = this.f2740I;
            int i9 = iArr[0];
            int i10 = iArr[1];
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, AbstractC0567h.a(f2733R, abstractC0566gV.a(iIntValue - i9, iIntValue2 - i10, iIntValue3 - i9, iIntValue4 - i10)));
            objectAnimatorOfPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, fC));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect = (Rect) sVar.f2854a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) sVar2.f2854a.get("android:changeBounds:bounds");
        int i11 = rect.left;
        int i12 = rect2.left;
        int i13 = rect.top;
        int i14 = rect2.top;
        int i15 = rect.right;
        int i16 = rect2.right;
        int i17 = rect.bottom;
        int i18 = rect2.bottom;
        int i19 = i15 - i11;
        int i20 = i17 - i13;
        int i21 = i16 - i12;
        int i22 = i18 - i14;
        Rect rect3 = (Rect) sVar.f2854a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) sVar2.f2854a.get("android:changeBounds:clip");
        if ((i19 == 0 || i20 == 0) && (i21 == 0 || i22 == 0)) {
            i7 = 0;
        } else {
            i7 = (i11 == i12 && i13 == i14) ? 0 : 1;
            if (i15 != i16 || i17 != i18) {
                i7++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i7++;
        }
        if (i7 <= 0) {
            return null;
        }
        if (this.f2741O) {
            view = view2;
            A.f(view, i11, i13, Math.max(i19, i21) + i11, Math.max(i20, i22) + i13);
            ObjectAnimator objectAnimatorA = (i11 == i12 && i13 == i14) ? null : AbstractC0565f.a(view, f2738W, v().a(i11, i13, i12, i14));
            if (rect3 == null) {
                i8 = 0;
                rect3 = new Rect(0, 0, i19, i20);
            } else {
                i8 = 0;
            }
            Rect rect5 = rect4 == null ? new Rect(i8, i8, i21, i22) : rect4;
            if (rect3.equals(rect5)) {
                objectAnimator = null;
            } else {
                Q.N.s0(view, rect3);
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", f2739X, rect3, rect5);
                objectAnimatorOfObject.addListener(new i(view, rect4, i12, i14, i16, i18));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorC = r.c(objectAnimatorA, objectAnimator);
        } else {
            view = view2;
            A.f(view, i11, i13, i15, i17);
            if (i7 != 2) {
                animatorC = (i11 == i12 && i13 == i14) ? AbstractC0565f.a(view, f2736U, v().a(i15, i17, i16, i18)) : AbstractC0565f.a(view, f2737V, v().a(i11, i13, i12, i14));
            } else if (i19 == i21 && i20 == i22) {
                animatorC = AbstractC0565f.a(view, f2738W, v().a(i11, i13, i12, i14));
            } else {
                k kVar = new k(view);
                ObjectAnimator objectAnimatorA2 = AbstractC0565f.a(kVar, f2734S, v().a(i11, i13, i12, i14));
                ObjectAnimator objectAnimatorA3 = AbstractC0565f.a(kVar, f2735T, v().a(i15, i17, i16, i18));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new h(kVar));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            x.c(viewGroup4, true);
            a(new j(viewGroup4));
        }
        return animatorC;
    }
}
