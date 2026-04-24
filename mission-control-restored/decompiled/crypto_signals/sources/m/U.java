package m;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.cryptosignals.ap.android.R;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class U extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f8298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8301d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8302f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public S f8303k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8304l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f8305m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8306n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public I.e f8307o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public A.b f8308p;

    public U(Context context, boolean z6) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f8298a = new Rect();
        this.f8299b = 0;
        this.f8300c = 0;
        this.f8301d = 0;
        this.e = 0;
        this.f8305m = z6;
        setCacheColorHint(0);
    }

    public final int a(int i, int i6) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
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
        int i7 = 0;
        View view = null;
        for (int i8 = 0; i8 < count; i8++) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            view.measure(i, i9 > 0 ? View.MeasureSpec.makeMeasureSpec(i9, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i8 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i6) {
                return i6;
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r18, android.view.MotionEvent r19) {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.U.b(int, android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f8298a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f8308p != null) {
            return;
        }
        super.drawableStateChanged();
        S s6 = this.f8303k;
        if (s6 != null) {
            s6.f8283b = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f8306n && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f8305m || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f8305m || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f8305m || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f8305m && this.f8304l) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f8308p = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f8308p == null) {
            A.b bVar = new A.b(this, 22);
            this.f8308p = bVar;
            post(bVar);
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
                requestFocus();
                if (i < 30 || !P.f8268d) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                } else {
                    try {
                        P.f8265a.invoke(this, Integer.valueOf(iPointToPosition), childAt, Boolean.FALSE, -1, -1);
                        P.f8266b.invoke(this, Integer.valueOf(iPointToPosition));
                        P.f8267c.invoke(this, Integer.valueOf(iPointToPosition));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            Drawable selector = getSelector();
            if (selector != null && this.f8306n && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f8302f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        A.b bVar = this.f8308p;
        if (bVar != null) {
            U u6 = (U) bVar.f4b;
            u6.f8308p = null;
            u6.removeCallbacks(bVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z6) {
        this.f8304l = z6;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        S s6 = null;
        if (drawable != null) {
            S s7 = new S();
            Drawable drawable2 = s7.f8282a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            s7.f8282a = drawable;
            drawable.setCallback(s7);
            s7.f8283b = true;
            s6 = s7;
        }
        this.f8303k = s6;
        super.setSelector(s6);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f8299b = rect.left;
        this.f8300c = rect.top;
        this.f8301d = rect.right;
        this.e = rect.bottom;
    }
}
