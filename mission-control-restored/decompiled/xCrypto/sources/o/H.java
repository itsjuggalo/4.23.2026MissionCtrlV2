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
import android.widget.ListAdapter;
import android.widget.ListView;
import g.AbstractC1248a;
import j.AbstractC1559a;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class H extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f13663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13665c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Field f13669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f13670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public M.e f13674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f13675n;

    public static class a extends AbstractC1559a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13676b;

        public a(Drawable drawable) {
            super(drawable);
            this.f13676b = true;
        }

        public void c(boolean z4) {
            this.f13676b = z4;
        }

        @Override // j.AbstractC1559a, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f13676b) {
                super.draw(canvas);
            }
        }

        @Override // j.AbstractC1559a, android.graphics.drawable.Drawable
        public void setHotspot(float f4, float f5) {
            if (this.f13676b) {
                super.setHotspot(f4, f5);
            }
        }

        @Override // j.AbstractC1559a, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i4, int i5, int i6, int i7) {
            if (this.f13676b) {
                super.setHotspotBounds(i4, i5, i6, i7);
            }
        }

        @Override // j.AbstractC1559a, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f13676b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // j.AbstractC1559a, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z4, boolean z5) {
            if (this.f13676b) {
                return super.setVisible(z4, z5);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void a() {
            H h4 = H.this;
            h4.f13675n = null;
            h4.removeCallbacks(this);
        }

        public void b() {
            H.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            H h4 = H.this;
            h4.f13675n = null;
            h4.drawableStateChanged();
        }
    }

    public H(Context context, boolean z4) {
        super(context, null, AbstractC1248a.f11555n);
        this.f13663a = new Rect();
        this.f13664b = 0;
        this.f13665c = 0;
        this.f13666e = 0;
        this.f13667f = 0;
        this.f13672k = z4;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f13669h = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
    }

    public final void a() {
        this.f13673l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f13668g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
    }

    public final void b(View view, int i4) {
        performItemClick(view, i4, getItemIdAtPosition(i4));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (this.f13663a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f13663a);
        selector.draw(canvas);
    }

    public int d(int i4, int i5, int i6, int i7, int i8) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        View view = null;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i12 = layoutParams.height;
            view.measure(i4, i12 > 0 ? View.MeasureSpec.makeMeasureSpec(i12, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i9 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i7) {
                return (i8 < 0 || i9 <= i8 || i11 <= 0 || measuredHeight == i7) ? i7 : i11;
            }
            if (i8 >= 0 && i9 >= i8) {
                i11 = measuredHeight;
            }
            i9++;
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
        if (this.f13675n != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
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
            M.e r9 = r7.f13674m
            if (r9 != 0) goto L5a
            M.e r9 = new M.e
            r9.<init>(r7)
            r7.f13674m = r9
        L5a:
            M.e r9 = r7.f13674m
            r9.m(r1)
            M.e r9 = r7.f13674m
            r9.onTouch(r7, r8)
            return r3
        L65:
            M.e r8 = r7.f13674m
            if (r8 == 0) goto L6c
            r8.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o.H.e(android.view.MotionEvent, int):boolean");
    }

    public final void f(int i4, View view) {
        Rect rect = this.f13663a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f13664b;
        rect.top -= this.f13665c;
        rect.right += this.f13666e;
        rect.bottom += this.f13667f;
        try {
            boolean z4 = this.f13669h.getBoolean(this);
            if (view.isEnabled() != z4) {
                this.f13669h.set(this, Boolean.valueOf(!z4));
                if (i4 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
    }

    public final void g(int i4, View view) {
        Drawable selector = getSelector();
        boolean z4 = (selector == null || i4 == -1) ? false : true;
        if (z4) {
            selector.setVisible(false, false);
        }
        f(i4, view);
        if (z4) {
            Rect rect = this.f13663a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            A.a.d(selector, fExactCenterX, fExactCenterY);
        }
    }

    public final void h(int i4, View view, float f4, float f5) {
        g(i4, view);
        Drawable selector = getSelector();
        if (selector == null || i4 == -1) {
            return;
        }
        A.a.d(selector, f4, f5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f13672k || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f13672k || super.hasWindowFocus();
    }

    public final void i(View view, int i4, float f4, float f5) {
        View childAt;
        this.f13673l = true;
        drawableHotspotChanged(f4, f5);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i5 = this.f13668g;
        if (i5 != -1 && (childAt = getChildAt(i5 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f13668g = i4;
        view.drawableHotspotChanged(f4 - view.getLeft(), f5 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i4, view, f4, f5);
        j(false);
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f13672k || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f13672k && this.f13671j) || super.isInTouchMode();
    }

    public final void j(boolean z4) {
        a aVar = this.f13670i;
        if (aVar != null) {
            aVar.c(z4);
        }
    }

    public final boolean k() {
        return this.f13673l;
    }

    public final void l() {
        Drawable selector = getSelector();
        if (selector != null && k() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f13675n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f13675n == null) {
            b bVar = new b();
            this.f13675n = bVar;
            bVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return zOnHoverEvent;
        }
        int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
            }
            l();
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f13668g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f13675n;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z4) {
        this.f13671j = z4;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f13670i = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f13664b = rect.left;
        this.f13665c = rect.top;
        this.f13666e = rect.right;
        this.f13667f = rect.bottom;
    }
}
