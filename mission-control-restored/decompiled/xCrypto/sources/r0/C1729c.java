package r0;

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

/* JADX INFO: renamed from: r0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1729c extends AbstractC1738l {

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final String[] f14348Q = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final Property f14349R = new b(PointF.class, "boundsOrigin");

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final Property f14350S = new C0231c(PointF.class, "topLeft");

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final Property f14351T = new d(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final Property f14352U = new e(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final Property f14353V = new f(PointF.class, "topLeft");

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final Property f14354W = new g(PointF.class, "position");

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static C1736j f14355X = new C1736j();

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int[] f14356I = new int[2];

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f14357O = false;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f14358P = false;

    /* JADX INFO: renamed from: r0.c$a */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f14359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f14360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f14361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f14362d;

        public a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f4) {
            this.f14359a = viewGroup;
            this.f14360b = bitmapDrawable;
            this.f14361c = view;
            this.f14362d = f4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC1726A.b(this.f14359a).b(this.f14360b);
            AbstractC1726A.g(this.f14361c, this.f14362d);
        }
    }

    /* JADX INFO: renamed from: r0.c$b */
    public class b extends Property {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f14364a;

        public b(Class cls, String str) {
            super(cls, str);
            this.f14364a = new Rect();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f14364a);
            Rect rect = this.f14364a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f14364a);
            this.f14364a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f14364a);
        }
    }

    /* JADX INFO: renamed from: r0.c$c, reason: collision with other inner class name */
    public class C0231c extends Property {
        public C0231c(Class cls, String str) {
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

    /* JADX INFO: renamed from: r0.c$d */
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

    /* JADX INFO: renamed from: r0.c$e */
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
            AbstractC1726A.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* JADX INFO: renamed from: r0.c$f */
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
            AbstractC1726A.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: renamed from: r0.c$g */
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
            AbstractC1726A.f(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* JADX INFO: renamed from: r0.c$h */
    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f14365a;
        private k mViewBounds;

        public h(k kVar) {
            this.f14365a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* JADX INFO: renamed from: r0.c$i */
    public class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f14368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f14369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f14370d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f14371e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f14372f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f14373g;

        public i(View view, Rect rect, int i4, int i5, int i6, int i7) {
            this.f14368b = view;
            this.f14369c = rect;
            this.f14370d = i4;
            this.f14371e = i5;
            this.f14372f = i6;
            this.f14373g = i7;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f14367a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f14367a) {
                return;
            }
            H.E.L(this.f14368b, this.f14369c);
            AbstractC1726A.f(this.f14368b, this.f14370d, this.f14371e, this.f14372f, this.f14373g);
        }
    }

    /* JADX INFO: renamed from: r0.c$j */
    public class j extends AbstractC1739m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14375a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f14376b;

        public j(ViewGroup viewGroup) {
            this.f14376b = viewGroup;
        }

        @Override // r0.AbstractC1739m, r0.AbstractC1738l.f
        public void a(AbstractC1738l abstractC1738l) {
            x.c(this.f14376b, false);
        }

        @Override // r0.AbstractC1738l.f
        public void b(AbstractC1738l abstractC1738l) {
            if (!this.f14375a) {
                x.c(this.f14376b, false);
            }
            abstractC1738l.P(this);
        }

        @Override // r0.AbstractC1739m, r0.AbstractC1738l.f
        public void c(AbstractC1738l abstractC1738l) {
            x.c(this.f14376b, false);
            this.f14375a = true;
        }

        @Override // r0.AbstractC1739m, r0.AbstractC1738l.f
        public void d(AbstractC1738l abstractC1738l) {
            x.c(this.f14376b, true);
        }
    }

    /* JADX INFO: renamed from: r0.c$k */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14381d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f14382e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14383f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14384g;

        public k(View view) {
            this.f14382e = view;
        }

        public void a(PointF pointF) {
            this.f14380c = Math.round(pointF.x);
            this.f14381d = Math.round(pointF.y);
            int i4 = this.f14384g + 1;
            this.f14384g = i4;
            if (this.f14383f == i4) {
                b();
            }
        }

        public final void b() {
            AbstractC1726A.f(this.f14382e, this.f14378a, this.f14379b, this.f14380c, this.f14381d);
            this.f14383f = 0;
            this.f14384g = 0;
        }

        public void c(PointF pointF) {
            this.f14378a = Math.round(pointF.x);
            this.f14379b = Math.round(pointF.y);
            int i4 = this.f14383f + 1;
            this.f14383f = i4;
            if (i4 == this.f14384g) {
                b();
            }
        }
    }

    @Override // r0.AbstractC1738l
    public String[] D() {
        return f14348Q;
    }

    public final void c0(s sVar) {
        View view = sVar.f14471b;
        if (!H.E.x(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f14470a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f14470a.put("android:changeBounds:parent", sVar.f14471b.getParent());
        if (this.f14358P) {
            sVar.f14471b.getLocationInWindow(this.f14356I);
            sVar.f14470a.put("android:changeBounds:windowX", Integer.valueOf(this.f14356I[0]));
            sVar.f14470a.put("android:changeBounds:windowY", Integer.valueOf(this.f14356I[1]));
        }
        if (this.f14357O) {
            sVar.f14470a.put("android:changeBounds:clip", H.E.j(view));
        }
    }

    public final boolean d0(View view, View view2) {
        if (!this.f14358P) {
            return true;
        }
        s sVarT = t(view, true);
        return sVarT == null ? view == view2 : view2 == sVarT.f14471b;
    }

    @Override // r0.AbstractC1738l
    public void g(s sVar) {
        c0(sVar);
    }

    @Override // r0.AbstractC1738l
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // r0.AbstractC1738l
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        Animator animator;
        int i4;
        int i5;
        Rect rect;
        View view;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map map = sVar.f14470a;
        Map map2 = sVar2.f14470a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f14471b;
        if (d0(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) sVar.f14470a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) sVar2.f14470a.get("android:changeBounds:bounds");
            int i6 = rect2.left;
            int i7 = rect3.left;
            int i8 = rect2.top;
            int i9 = rect3.top;
            int i10 = rect2.right;
            int i11 = rect3.right;
            int i12 = rect2.bottom;
            int i13 = rect3.bottom;
            animator = null;
            int i14 = i10 - i6;
            int i15 = i12 - i8;
            int i16 = i11 - i7;
            int i17 = i13 - i9;
            Rect rect4 = (Rect) sVar.f14470a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) sVar2.f14470a.get("android:changeBounds:clip");
            if ((i14 == 0 || i15 == 0) && (i16 == 0 || i17 == 0)) {
                i4 = 0;
            } else {
                i4 = (i6 == i7 && i8 == i9) ? 0 : 1;
                if (i10 != i11 || i12 != i13) {
                    i4++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i4++;
            }
            if (i4 > 0) {
                if (this.f14357O) {
                    AbstractC1726A.f(view2, i6, i8, Math.max(i14, i16) + i6, Math.max(i15, i17) + i8);
                    ObjectAnimator objectAnimatorA = (i6 == i7 && i8 == i9) ? null : AbstractC1732f.a(view2, f14354W, v().a(i6, i8, i7, i9));
                    if (rect4 == null) {
                        i5 = 0;
                        rect = new Rect(0, 0, i14, i15);
                    } else {
                        i5 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i5, i5, i16, i17) : rect5;
                    if (rect.equals(rect6)) {
                        view = view2;
                        objectAnimator = null;
                    } else {
                        H.E.L(view2, rect);
                        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view2, "clipBounds", f14355X, rect, rect6);
                        view = view2;
                        objectAnimatorOfObject.addListener(new i(view2, rect5, i7, i9, i11, i13));
                        objectAnimator = objectAnimatorOfObject;
                    }
                    animatorC = r.c(objectAnimatorA, objectAnimator);
                } else {
                    AbstractC1726A.f(view2, i6, i8, i10, i12);
                    if (i4 != 2) {
                        animatorC = (i6 == i7 && i8 == i9) ? AbstractC1732f.a(view2, f14352U, v().a(i10, i12, i11, i13)) : AbstractC1732f.a(view2, f14353V, v().a(i6, i8, i7, i9));
                    } else if (i14 == i16 && i15 == i17) {
                        animatorC = AbstractC1732f.a(view2, f14354W, v().a(i6, i8, i7, i9));
                    } else {
                        k kVar = new k(view2);
                        ObjectAnimator objectAnimatorA2 = AbstractC1732f.a(kVar, f14350S, v().a(i6, i8, i7, i9));
                        ObjectAnimator objectAnimatorA3 = AbstractC1732f.a(kVar, f14351T, v().a(i10, i12, i11, i13));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                        animatorSet.addListener(new h(kVar));
                        animatorC = animatorSet;
                    }
                    view = view2;
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    x.c(viewGroup4, true);
                    a(new j(viewGroup4));
                }
                return animatorC;
            }
        } else {
            animator = null;
            int iIntValue = ((Integer) sVar.f14470a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) sVar.f14470a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) sVar2.f14470a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) sVar2.f14470a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue != iIntValue3 || iIntValue2 != iIntValue4) {
                viewGroup.getLocationInWindow(this.f14356I);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                view2.draw(new Canvas(bitmapCreateBitmap));
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                float fC = AbstractC1726A.c(view2);
                AbstractC1726A.g(view2, 0.0f);
                AbstractC1726A.b(viewGroup).a(bitmapDrawable);
                AbstractC1733g abstractC1733gV = v();
                int[] iArr = this.f14356I;
                int i18 = iArr[0];
                int i19 = iArr[1];
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, AbstractC1734h.a(f14349R, abstractC1733gV.a(iIntValue - i18, iIntValue2 - i19, iIntValue3 - i18, iIntValue4 - i19)));
                objectAnimatorOfPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, fC));
                return objectAnimatorOfPropertyValuesHolder;
            }
        }
        return animator;
    }
}
