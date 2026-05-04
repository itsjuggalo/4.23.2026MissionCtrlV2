package n2;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends l {
    public static final String[] S = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property T = new b(PointF.class, "boundsOrigin");
    public static final Property U = new C0294c(PointF.class, "topLeft");
    public static final Property V = new d(PointF.class, "bottomRight");
    public static final Property W = new e(PointF.class, "bottomRight");
    public static final Property X = new f(PointF.class, "topLeft");
    public static final Property Y = new g(PointF.class, "position");
    public static n2.j Z = new n2.j();
    public int[] I = new int[2];
    public boolean Q = false;
    public boolean R = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f16478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f16479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f16480d;

        public a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f16477a = viewGroup;
            this.f16478b = bitmapDrawable;
            this.f16479c = view;
            this.f16480d = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            y.b(this.f16477a).b(this.f16478b);
            y.g(this.f16479c, this.f16480d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends Property {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f16482a;

        public b(Class cls, String str) {
            super(cls, str);
            this.f16482a = new Rect();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f16482a);
            Rect rect = this.f16482a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f16482a);
            this.f16482a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f16482a);
        }
    }

    /* JADX INFO: renamed from: n2.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0294c extends Property {
        public C0294c(Class cls, String str) {
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
            y.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
            y.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
            y.f(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f16483a;
        private k mViewBounds;

        public h(k kVar) {
            this.f16483a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f16485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f16486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f16487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f16488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f16489e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f16490f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f16491g;

        public i(View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f16486b = view;
            this.f16487c = rect;
            this.f16488d = i10;
            this.f16489e = i11;
            this.f16490f = i12;
            this.f16491g = i13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f16485a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f16485a) {
                return;
            }
            t0.c0.O(this.f16486b, this.f16487c);
            y.f(this.f16486b, this.f16488d, this.f16489e, this.f16490f, this.f16491g);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class j extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f16493a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16494b;

        public j(ViewGroup viewGroup) {
            this.f16494b = viewGroup;
        }

        @Override // n2.m, n2.l.f
        public void a(l lVar) {
            v.c(this.f16494b, true);
        }

        @Override // n2.m, n2.l.f
        public void c(l lVar) {
            v.c(this.f16494b, false);
            this.f16493a = true;
        }

        @Override // n2.l.f
        public void d(l lVar) {
            if (!this.f16493a) {
                v.c(this.f16494b, false);
            }
            lVar.R(this);
        }

        @Override // n2.m, n2.l.f
        public void e(l lVar) {
            v.c(this.f16494b, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16499d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f16500e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f16501f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f16502g;

        public k(View view) {
            this.f16500e = view;
        }

        public void a(PointF pointF) {
            this.f16498c = Math.round(pointF.x);
            this.f16499d = Math.round(pointF.y);
            int i10 = this.f16502g + 1;
            this.f16502g = i10;
            if (this.f16501f == i10) {
                b();
            }
        }

        public final void b() {
            y.f(this.f16500e, this.f16496a, this.f16497b, this.f16498c, this.f16499d);
            this.f16501f = 0;
            this.f16502g = 0;
        }

        public void c(PointF pointF) {
            this.f16496a = Math.round(pointF.x);
            this.f16497b = Math.round(pointF.y);
            int i10 = this.f16501f + 1;
            this.f16501f = i10;
            if (i10 == this.f16502g) {
                b();
            }
        }
    }

    @Override // n2.l
    public String[] F() {
        return S;
    }

    public final void e0(r rVar) {
        View view = rVar.f16596b;
        if (!t0.c0.z(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        rVar.f16595a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        rVar.f16595a.put("android:changeBounds:parent", rVar.f16596b.getParent());
        if (this.R) {
            rVar.f16596b.getLocationInWindow(this.I);
            rVar.f16595a.put("android:changeBounds:windowX", Integer.valueOf(this.I[0]));
            rVar.f16595a.put("android:changeBounds:windowY", Integer.valueOf(this.I[1]));
        }
        if (this.Q) {
            rVar.f16595a.put("android:changeBounds:clip", t0.c0.m(view));
        }
    }

    public final boolean f0(View view, View view2) {
        if (!this.R) {
            return true;
        }
        r rVarV = v(view, true);
        return rVarV == null ? view == view2 : view2 == rVarV.f16596b;
    }

    @Override // n2.l
    public void h(r rVar) {
        e0(rVar);
    }

    @Override // n2.l
    public void k(r rVar) {
        e0(rVar);
    }

    @Override // n2.l
    public Animator o(ViewGroup viewGroup, r rVar, r rVar2) {
        Animator animator;
        int i10;
        int i11;
        Rect rect;
        View view;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        if (rVar == null || rVar2 == null) {
            return null;
        }
        Map map = rVar.f16595a;
        Map map2 = rVar2.f16595a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = rVar2.f16596b;
        if (f0(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) rVar.f16595a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) rVar2.f16595a.get("android:changeBounds:bounds");
            int i12 = rect2.left;
            int i13 = rect3.left;
            int i14 = rect2.top;
            int i15 = rect3.top;
            int i16 = rect2.right;
            int i17 = rect3.right;
            int i18 = rect2.bottom;
            int i19 = rect3.bottom;
            int i20 = i16 - i12;
            animator = null;
            int i21 = i18 - i14;
            int i22 = i17 - i13;
            int i23 = i19 - i15;
            Rect rect4 = (Rect) rVar.f16595a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) rVar2.f16595a.get("android:changeBounds:clip");
            if ((i20 == 0 || i21 == 0) && (i22 == 0 || i23 == 0)) {
                i10 = 0;
            } else {
                i10 = (i12 == i13 && i14 == i15) ? 0 : 1;
                if (i16 != i17 || i18 != i19) {
                    i10++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i10++;
            }
            if (i10 > 0) {
                if (this.Q) {
                    y.f(view2, i12, i14, Math.max(i20, i22) + i12, Math.max(i21, i23) + i14);
                    ObjectAnimator objectAnimatorA = (i12 == i13 && i14 == i15) ? null : n2.f.a(view2, Y, x().a(i12, i14, i13, i15));
                    if (rect4 == null) {
                        i11 = 0;
                        rect = new Rect(0, 0, i20, i21);
                    } else {
                        i11 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i11, i11, i22, i23) : rect5;
                    if (rect.equals(rect6)) {
                        view = view2;
                        objectAnimator = null;
                    } else {
                        t0.c0.O(view2, rect);
                        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view2, "clipBounds", Z, rect, rect6);
                        view = view2;
                        objectAnimatorOfObject.addListener(new i(view2, rect5, i13, i15, i17, i19));
                        objectAnimator = objectAnimatorOfObject;
                    }
                    animatorC = q.c(objectAnimatorA, objectAnimator);
                } else {
                    y.f(view2, i12, i14, i16, i18);
                    if (i10 != 2) {
                        animatorC = (i12 == i13 && i14 == i15) ? n2.f.a(view2, W, x().a(i16, i18, i17, i19)) : n2.f.a(view2, X, x().a(i12, i14, i13, i15));
                    } else if (i20 == i22 && i21 == i23) {
                        animatorC = n2.f.a(view2, Y, x().a(i12, i14, i13, i15));
                    } else {
                        k kVar = new k(view2);
                        ObjectAnimator objectAnimatorA2 = n2.f.a(kVar, U, x().a(i12, i14, i13, i15));
                        ObjectAnimator objectAnimatorA3 = n2.f.a(kVar, V, x().a(i16, i18, i17, i19));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                        animatorSet.addListener(new h(kVar));
                        animatorC = animatorSet;
                    }
                    view = view2;
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    v.c(viewGroup4, true);
                    a(new j(viewGroup4));
                }
                return animatorC;
            }
        } else {
            animator = null;
            int iIntValue = ((Integer) rVar.f16595a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) rVar.f16595a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) rVar2.f16595a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) rVar2.f16595a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue != iIntValue3 || iIntValue2 != iIntValue4) {
                viewGroup.getLocationInWindow(this.I);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                view2.draw(new Canvas(bitmapCreateBitmap));
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                float fC = y.c(view2);
                y.g(view2, 0.0f);
                y.b(viewGroup).a(bitmapDrawable);
                n2.g gVarX = x();
                int[] iArr = this.I;
                int i24 = iArr[0];
                int i25 = iArr[1];
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, n2.h.a(T, gVarX.a(iIntValue - i24, iIntValue2 - i25, iIntValue3 - i24, iIntValue4 - i25)));
                objectAnimatorOfPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, fC));
                return objectAnimatorOfPropertyValuesHolder;
            }
        }
        return animator;
    }
}
