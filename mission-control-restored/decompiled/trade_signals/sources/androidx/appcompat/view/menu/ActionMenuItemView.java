package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionMenuView;
import o.AbstractViewOnTouchListenerC2431A;
import o.C2446o;
import o.P;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends C2446o implements h.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f10365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f10366i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f10367j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d.b f10368k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AbstractViewOnTouchListenerC2431A f10369l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f10370m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10371n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10372o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10373p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10374q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10375r;

    public class a extends AbstractViewOnTouchListenerC2431A {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // o.AbstractViewOnTouchListenerC2431A
        public n.c b() {
            b bVar = ActionMenuItemView.this.f10370m;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // o.AbstractViewOnTouchListenerC2431A
        public boolean c() {
            n.c cVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            d.b bVar = actionMenuItemView.f10368k;
            return bVar != null && bVar.a(actionMenuItemView.f10365h) && (cVarB = b()) != null && cVarB.e();
        }
    }

    public static abstract class b {
        public abstract n.c a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return s();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return s() && this.f10365h.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean c() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void d(e eVar, int i8) {
        this.f10365h = eVar;
        setIcon(eVar.getIcon());
        setTitle(eVar.h(this));
        setId(eVar.getItemId());
        setVisibility(eVar.isVisible() ? 0 : 8);
        setEnabled(eVar.isEnabled());
        if (eVar.hasSubMenu() && this.f10369l == null) {
            this.f10369l = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.h.a
    public e getItemData() {
        return this.f10365h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b bVar = this.f10368k;
        if (bVar != null) {
            bVar.a(this.f10365h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f10371n = t();
        u();
    }

    @Override // o.C2446o, android.widget.TextView, android.view.View
    public void onMeasure(int i8, int i9) {
        int i10;
        boolean zS = s();
        if (zS && (i10 = this.f10374q) >= 0) {
            super.setPadding(i10, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i8, i9);
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f10373p) : this.f10373p;
        if (mode != 1073741824 && this.f10373p > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i9);
        }
        if (zS || this.f10367j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f10367j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractViewOnTouchListenerC2431A abstractViewOnTouchListenerC2431A;
        if (this.f10365h.hasSubMenu() && (abstractViewOnTouchListenerC2431A = this.f10369l) != null && abstractViewOnTouchListenerC2431A.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean s() {
        return !TextUtils.isEmpty(getText());
    }

    public void setCheckable(boolean z7) {
    }

    public void setChecked(boolean z7) {
    }

    public void setExpandedFormat(boolean z7) {
        if (this.f10372o != z7) {
            this.f10372o = z7;
            e eVar = this.f10365h;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f10367j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i8 = this.f10375r;
            if (intrinsicWidth > i8) {
                intrinsicHeight = (int) (intrinsicHeight * (i8 / intrinsicWidth));
                intrinsicWidth = i8;
            }
            if (intrinsicHeight > i8) {
                intrinsicWidth = (int) (intrinsicWidth * (i8 / intrinsicHeight));
            } else {
                i8 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i8);
        }
        setCompoundDrawables(drawable, null, null, null);
        u();
    }

    public void setItemInvoker(d.b bVar) {
        this.f10368k = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i8, int i9, int i10, int i11) {
        this.f10374q = i8;
        super.setPadding(i8, i9, i10, i11);
    }

    public void setPopupCallback(b bVar) {
        this.f10370m = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f10366i = charSequence;
        u();
    }

    public final boolean t() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i8 = configuration.screenWidthDp;
        return i8 >= 480 || (i8 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void u() {
        boolean z7 = true;
        boolean z8 = !TextUtils.isEmpty(this.f10366i);
        if (this.f10367j != null && (!this.f10365h.A() || (!this.f10371n && !this.f10372o))) {
            z7 = false;
        }
        boolean z9 = z8 & z7;
        setText(z9 ? this.f10366i : null);
        CharSequence contentDescription = this.f10365h.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z9 ? null : this.f10365h.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f10365h.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            P.a(this, z9 ? null : this.f10365h.getTitle());
        } else {
            P.a(this, tooltipText);
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Resources resources = context.getResources();
        this.f10371n = t();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.i.f17937t, i8, 0);
        this.f10373p = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.i.f17941u, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f10375r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f10374q = -1;
        setSaveEnabled(false);
    }
}
