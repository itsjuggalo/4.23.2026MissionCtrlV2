package C0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: renamed from: C0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0444c extends AbstractC0453l {

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final String[] f454R = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final Property f455S = new b(PointF.class, "boundsOrigin");

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final Property f456T = new C0005c(PointF.class, "topLeft");

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final Property f457U = new d(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final Property f458V = new e(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final Property f459W = new f(PointF.class, "topLeft");

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final Property f460X = new g(PointF.class, "position");

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static C0451j f461Y = new C0451j();

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int[] f462I = new int[2];

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f463P = false;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f464Q = false;

    /* JADX INFO: renamed from: C0.c$a */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f468d;

        public a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f8) {
            this.f465a = viewGroup;
            this.f466b = bitmapDrawable;
            this.f467c = view;
            this.f468d = f8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            A.b(this.f465a).b(this.f466b);
            A.g(this.f467c, this.f468d);
        }
    }

    /* JADX INFO: renamed from: C0.c$b */
    public class b extends Property {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f470a;

        public b(Class cls, String str) {
            super(cls, str);
            this.f470a = new Rect();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f470a);
            Rect rect = this.f470a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f470a);
            this.f470a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f470a);
        }
    }

    /* JADX INFO: renamed from: C0.c$c, reason: collision with other inner class name */
    public class C0005c extends Property {
        public C0005c(Class cls, String str) {
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

    /* JADX INFO: renamed from: C0.c$d */
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

    /* JADX INFO: renamed from: C0.c$e */
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

    /* JADX INFO: renamed from: C0.c$f */
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

    /* JADX INFO: renamed from: C0.c$g */
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

    /* JADX INFO: renamed from: C0.c$h */
    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f471a;
        private k mViewBounds;

        public h(k kVar) {
            this.f471a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* JADX INFO: renamed from: C0.c$i */
    public class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f477e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f478f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f479g;

        public i(View view, Rect rect, int i8, int i9, int i10, int i11) {
            this.f474b = view;
            this.f475c = rect;
            this.f476d = i8;
            this.f477e = i9;
            this.f478f = i10;
            this.f479g = i11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f473a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f473a) {
                return;
            }
            T.D.O(this.f474b, this.f475c);
            A.f(this.f474b, this.f476d, this.f477e, this.f478f, this.f479g);
        }
    }

    /* JADX INFO: renamed from: C0.c$j */
    public class j extends AbstractC0454m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f481a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f482b;

        public j(ViewGroup viewGroup) {
            this.f482b = viewGroup;
        }

        @Override // C0.AbstractC0454m, C0.AbstractC0453l.f
        public void a(AbstractC0453l abstractC0453l) {
            x.c(this.f482b, false);
        }

        @Override // C0.AbstractC0454m, C0.AbstractC0453l.f
        public void b(AbstractC0453l abstractC0453l) {
            x.c(this.f482b, false);
            this.f481a = true;
        }

        @Override // C0.AbstractC0454m, C0.AbstractC0453l.f
        public void c(AbstractC0453l abstractC0453l) {
            x.c(this.f482b, true);
        }

        @Override // C0.AbstractC0453l.f
        public void d(AbstractC0453l abstractC0453l) {
            if (!this.f481a) {
                x.c(this.f482b, false);
            }
            abstractC0453l.S(this);
        }
    }

    /* JADX INFO: renamed from: C0.c$k */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f487d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f488e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f489f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f490g;

        public k(View view) {
            this.f488e = view;
        }

        public void a(PointF pointF) {
            this.f486c = Math.round(pointF.x);
            this.f487d = Math.round(pointF.y);
            int i8 = this.f490g + 1;
            this.f490g = i8;
            if (this.f489f == i8) {
                b();
            }
        }

        public final void b() {
            A.f(this.f488e, this.f484a, this.f485b, this.f486c, this.f487d);
            this.f489f = 0;
            this.f490g = 0;
        }

        public void c(PointF pointF) {
            this.f484a = Math.round(pointF.x);
            this.f485b = Math.round(pointF.y);
            int i8 = this.f489f + 1;
            this.f489f = i8;
            if (i8 == this.f490g) {
                b();
            }
        }
    }

    @Override // C0.AbstractC0453l
    public String[] G() {
        return f454R;
    }

    public final void f0(s sVar) {
        View view = sVar.f577b;
        if (!T.D.z(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f576a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f576a.put("android:changeBounds:parent", sVar.f577b.getParent());
        if (this.f464Q) {
            sVar.f577b.getLocationInWindow(this.f462I);
            sVar.f576a.put("android:changeBounds:windowX", Integer.valueOf(this.f462I[0]));
            sVar.f576a.put("android:changeBounds:windowY", Integer.valueOf(this.f462I[1]));
        }
        if (this.f463P) {
            sVar.f576a.put("android:changeBounds:clip", T.D.m(view));
        }
    }

    public final boolean g0(View view, View view2) {
        if (!this.f464Q) {
            return true;
        }
        s sVarW = w(view, true);
        if (sVarW == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == sVarW.f577b) {
            return true;
        }
        return false;
    }

    @Override // C0.AbstractC0453l
    public void i(s sVar) {
        f0(sVar);
    }

    @Override // C0.AbstractC0453l
    public void l(s sVar) {
        f0(sVar);
    }

    @Override // C0.AbstractC0453l
    public Animator q(ViewGroup viewGroup, s sVar, s sVar2) {
        int i8;
        View view;
        int i9;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        Path pathA;
        Property property;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map map = sVar.f576a;
        Map map2 = sVar2.f576a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f577b;
        if (!g0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) sVar.f576a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) sVar.f576a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) sVar2.f576a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) sVar2.f576a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.f462I);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fC = A.c(view2);
            A.g(view2, 0.0f);
            A.b(viewGroup).a(bitmapDrawable);
            AbstractC0448g abstractC0448gY = y();
            int[] iArr = this.f462I;
            int i10 = iArr[0];
            int i11 = iArr[1];
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, AbstractC0449h.a(f455S, abstractC0448gY.a(iIntValue - i10, iIntValue2 - i11, iIntValue3 - i10, iIntValue4 - i11)));
            objectAnimatorOfPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, fC));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect = (Rect) sVar.f576a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) sVar2.f576a.get("android:changeBounds:bounds");
        int i12 = rect.left;
        int i13 = rect2.left;
        int i14 = rect.top;
        int i15 = rect2.top;
        int i16 = rect.right;
        int i17 = rect2.right;
        int i18 = rect.bottom;
        int i19 = rect2.bottom;
        int i20 = i16 - i12;
        int i21 = i18 - i14;
        int i22 = i17 - i13;
        int i23 = i19 - i15;
        Rect rect3 = (Rect) sVar.f576a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) sVar2.f576a.get("android:changeBounds:clip");
        if ((i20 == 0 || i21 == 0) && (i22 == 0 || i23 == 0)) {
            i8 = 0;
        } else {
            i8 = (i12 == i13 && i14 == i15) ? 0 : 1;
            if (i16 != i17 || i18 != i19) {
                i8++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i8++;
        }
        if (i8 <= 0) {
            return null;
        }
        if (this.f463P) {
            view = view2;
            A.f(view, i12, i14, Math.max(i20, i22) + i12, Math.max(i21, i23) + i14);
            ObjectAnimator objectAnimatorA = (i12 == i13 && i14 == i15) ? null : AbstractC0447f.a(view, f460X, y().a(i12, i14, i13, i15));
            if (rect3 == null) {
                i9 = 0;
                rect3 = new Rect(0, 0, i20, i21);
            } else {
                i9 = 0;
            }
            Rect rect5 = rect4 == null ? new Rect(i9, i9, i22, i23) : rect4;
            if (rect3.equals(rect5)) {
                objectAnimator = null;
            } else {
                T.D.O(view, rect3);
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", f461Y, rect3, rect5);
                objectAnimatorOfObject.addListener(new i(view, rect4, i13, i15, i17, i19));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorC = r.c(objectAnimatorA, objectAnimator);
        } else {
            view = view2;
            A.f(view, i12, i14, i16, i18);
            if (i8 == 2) {
                if (i20 == i22 && i21 == i23) {
                    pathA = y().a(i12, i14, i13, i15);
                    property = f460X;
                } else {
                    k kVar = new k(view);
                    ObjectAnimator objectAnimatorA2 = AbstractC0447f.a(kVar, f456T, y().a(i12, i14, i13, i15));
                    ObjectAnimator objectAnimatorA3 = AbstractC0447f.a(kVar, f457U, y().a(i16, i18, i17, i19));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                    animatorSet.addListener(new h(kVar));
                    animatorC = animatorSet;
                }
            } else if (i12 == i13 && i14 == i15) {
                pathA = y().a(i16, i18, i17, i19);
                property = f458V;
            } else {
                pathA = y().a(i12, i14, i13, i15);
                property = f459W;
            }
            animatorC = AbstractC0447f.a(view, property, pathA);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            x.c(viewGroup4, true);
            b(new j(viewGroup4));
        }
        return animatorC;
    }
}
