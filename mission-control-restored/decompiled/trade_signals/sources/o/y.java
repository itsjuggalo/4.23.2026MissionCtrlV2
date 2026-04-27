package o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import g.AbstractC1764a;
import j.AbstractC2196a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class y extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f21905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f21911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f21914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Y.d f21915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f21916l;

    public static class a {
        public static void a(View view, float f8, float f9) {
            view.drawableHotspotChanged(f8, f9);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Method f21917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f21918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Method f21919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f21920d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                f21917a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f21918b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f21919c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f21920d = true;
            } catch (NoSuchMethodException e8) {
                e8.printStackTrace();
            }
        }

        public static boolean a() {
            return f21920d;
        }

        public static void b(y yVar, int i8, View view) {
            try {
                f21917a.invoke(yVar, Integer.valueOf(i8), view, Boolean.FALSE, -1, -1);
                f21918b.invoke(yVar, Integer.valueOf(i8));
                f21919c.invoke(yVar, Integer.valueOf(i8));
            } catch (IllegalAccessException | InvocationTargetException e8) {
                e8.printStackTrace();
            }
        }
    }

    public static class c {
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView absListView, boolean z7) {
            absListView.setSelectedChildViewEnabled(z7);
        }
    }

    public static class d extends AbstractC2196a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f21921b;

        public d(Drawable drawable) {
            super(drawable);
            this.f21921b = true;
        }

        public void b(boolean z7) {
            this.f21921b = z7;
        }

        @Override // j.AbstractC2196a, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f21921b) {
                super.draw(canvas);
            }
        }

        @Override // j.AbstractC2196a, android.graphics.drawable.Drawable
        public void setHotspot(float f8, float f9) {
            if (this.f21921b) {
                super.setHotspot(f8, f9);
            }
        }

        @Override // j.AbstractC2196a, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i8, int i9, int i10, int i11) {
            if (this.f21921b) {
                super.setHotspotBounds(i8, i9, i10, i11);
            }
        }

        @Override // j.AbstractC2196a, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f21921b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // j.AbstractC2196a, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z7, boolean z8) {
            if (this.f21921b) {
                return super.setVisible(z7, z8);
            }
            return false;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Field f21922a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                e8.printStackTrace();
            }
            f21922a = declaredField;
        }

        public static boolean a(AbsListView absListView) {
            Field field = f21922a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e8) {
                e8.printStackTrace();
                return false;
            }
        }

        public static void b(AbsListView absListView, boolean z7) {
            Field field = f21922a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z7));
                } catch (IllegalAccessException e8) {
                    e8.printStackTrace();
                }
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void a() {
            y yVar = y.this;
            yVar.f21916l = null;
            yVar.removeCallbacks(this);
        }

        public void b() {
            y.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            y yVar = y.this;
            yVar.f21916l = null;
            yVar.drawableStateChanged();
        }
    }

    public y(Context context, boolean z7) {
        super(context, null, AbstractC1764a.f17663n);
        this.f21905a = new Rect();
        this.f21906b = 0;
        this.f21907c = 0;
        this.f21908d = 0;
        this.f21909e = 0;
        this.f21913i = z7;
        setCacheColorHint(0);
    }

    public final void a() {
        this.f21914j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f21910f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
    }

    public final void b(View view, int i8) {
        performItemClick(view, i8, getItemIdAtPosition(i8));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (this.f21905a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f21905a);
        selector.draw(canvas);
    }

    public int d(int i8, int i9, int i10, int i11, int i12) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return measuredHeight;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        View view = null;
        while (i13 < count) {
            int itemViewType = adapter.getItemViewType(i13);
            if (itemViewType != i14) {
                view = null;
                i14 = itemViewType;
            }
            view = adapter.getView(i13, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i16 = layoutParams.height;
            view.measure(i8, i16 > 0 ? View.MeasureSpec.makeMeasureSpec(i16, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i13 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i11) {
                return (i12 < 0 || i13 <= i12 || i15 <= 0 || measuredHeight == i11) ? i11 : i15;
            }
            if (i12 >= 0 && i13 >= i12) {
                i15 = measuredHeight;
            }
            i13++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f21916l != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r3 = r1
            r9 = r2
            goto L46
        L11:
            r9 = r2
            r3 = r9
            goto L46
        L14:
            r3 = r1
            goto L17
        L16:
            r3 = r2
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            Y.d r9 = r7.f21915k
            if (r9 != 0) goto L5a
            Y.d r9 = new Y.d
            r9.<init>(r7)
            r7.f21915k = r9
        L5a:
            Y.d r9 = r7.f21915k
            r9.m(r1)
            Y.d r9 = r7.f21915k
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            Y.d r8 = r7.f21915k
            if (r8 == 0) goto L6c
            r8.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o.y.e(android.view.MotionEvent, int):boolean");
    }

    public final void f(int i8, View view) {
        Rect rect = this.f21905a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f21906b;
        rect.top -= this.f21907c;
        rect.right += this.f21908d;
        rect.bottom += this.f21909e;
        boolean zK = k();
        if (view.isEnabled() != zK) {
            l(!zK);
            if (i8 != -1) {
                refreshDrawableState();
            }
        }
    }

    public final void g(int i8, View view) {
        Drawable selector = getSelector();
        boolean z7 = (selector == null || i8 == -1) ? false : true;
        if (z7) {
            selector.setVisible(false, false);
        }
        f(i8, view);
        if (z7) {
            Rect rect = this.f21905a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            M.a.c(selector, fExactCenterX, fExactCenterY);
        }
    }

    public final void h(int i8, View view, float f8, float f9) {
        g(i8, view);
        Drawable selector = getSelector();
        if (selector == null || i8 == -1) {
            return;
        }
        M.a.c(selector, f8, f9);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f21913i || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f21913i || super.hasWindowFocus();
    }

    public final void i(View view, int i8, float f8, float f9) {
        View childAt;
        this.f21914j = true;
        a.a(this, f8, f9);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i9 = this.f21910f;
        if (i9 != -1 && (childAt = getChildAt(i9 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f21910f = i8;
        a.a(view, f8 - view.getLeft(), f9 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i8, view, f8, f9);
        j(false);
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f21913i || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f21913i && this.f21912h) || super.isInTouchMode();
    }

    public final void j(boolean z7) {
        d dVar = this.f21911g;
        if (dVar != null) {
            dVar.b(z7);
        }
    }

    public final boolean k() {
        return Build.VERSION.SDK_INT >= 33 ? c.a(this) : e.a(this);
    }

    public final void l(boolean z7) {
        if (Build.VERSION.SDK_INT >= 33) {
            c.b(this, z7);
        } else {
            e.b(this, z7);
        }
    }

    public final boolean m() {
        return this.f21914j;
    }

    public final void n() {
        Drawable selector = getSelector();
        if (selector != null && m() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f21916l = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f21916l == null) {
            f fVar = new f();
            this.f21916l = fVar;
            fVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i8 < 30 || !b.a()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, iPointToPosition, childAt);
                    }
                }
                n();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f21910f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f21916l;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z7) {
        this.f21912h = z7;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f21911g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f21906b = rect.left;
        this.f21907c = rect.top;
        this.f21908d = rect.right;
        this.f21909e = rect.bottom;
    }
}
