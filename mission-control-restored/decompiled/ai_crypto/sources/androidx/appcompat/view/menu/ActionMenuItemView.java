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
import h.AbstractC1664i;
import o.InterfaceC2281c;
import p.AbstractViewOnTouchListenerC2337F;
import p.C2358t;
import p.W;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends C2358t implements h.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f6472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f6473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f6474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d.b f6475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AbstractViewOnTouchListenerC2337F f6476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f6477m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6478n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6479o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6480p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6481q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6482r;

    public class a extends AbstractViewOnTouchListenerC2337F {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // p.AbstractViewOnTouchListenerC2337F
        public InterfaceC2281c b() {
            b bVar = ActionMenuItemView.this.f6477m;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // p.AbstractViewOnTouchListenerC2337F
        public boolean c() {
            InterfaceC2281c interfaceC2281cB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            d.b bVar = actionMenuItemView.f6475k;
            return bVar != null && bVar.a(actionMenuItemView.f6472h) && (interfaceC2281cB = b()) != null && interfaceC2281cB.f();
        }
    }

    public static abstract class b {
        public abstract InterfaceC2281c a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return r();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return r() && this.f6472h.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean c() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void d(e eVar, int i7) {
        this.f6472h = eVar;
        setIcon(eVar.getIcon());
        setTitle(eVar.h(this));
        setId(eVar.getItemId());
        setVisibility(eVar.isVisible() ? 0 : 8);
        setEnabled(eVar.isEnabled());
        if (eVar.hasSubMenu() && this.f6476l == null) {
            this.f6476l = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.h.a
    public e getItemData() {
        return this.f6472h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b bVar = this.f6475k;
        if (bVar != null) {
            bVar.a(this.f6472h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f6478n = s();
        t();
    }

    @Override // p.C2358t, android.widget.TextView, android.view.View
    public void onMeasure(int i7, int i8) {
        int i9;
        boolean zR = r();
        if (zR && (i9 = this.f6481q) >= 0) {
            super.setPadding(i9, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i7, i8);
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f6480p) : this.f6480p;
        if (mode != 1073741824 && this.f6480p > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i8);
        }
        if (zR || this.f6474j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f6474j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractViewOnTouchListenerC2337F abstractViewOnTouchListenerC2337F;
        if (this.f6472h.hasSubMenu() && (abstractViewOnTouchListenerC2337F = this.f6476l) != null && abstractViewOnTouchListenerC2337F.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean r() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean s() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i7 = configuration.screenWidthDp;
        return i7 >= 480 || (i7 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public void setCheckable(boolean z7) {
    }

    public void setChecked(boolean z7) {
    }

    public void setExpandedFormat(boolean z7) {
        if (this.f6479o != z7) {
            this.f6479o = z7;
            e eVar = this.f6472h;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f6474j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i7 = this.f6482r;
            if (intrinsicWidth > i7) {
                intrinsicHeight = (int) (intrinsicHeight * (i7 / intrinsicWidth));
                intrinsicWidth = i7;
            }
            if (intrinsicHeight > i7) {
                intrinsicWidth = (int) (intrinsicWidth * (i7 / intrinsicHeight));
            } else {
                i7 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i7);
        }
        setCompoundDrawables(drawable, null, null, null);
        t();
    }

    public void setItemInvoker(d.b bVar) {
        this.f6475k = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i7, int i8, int i9, int i10) {
        this.f6481q = i7;
        super.setPadding(i7, i8, i9, i10);
    }

    public void setPopupCallback(b bVar) {
        this.f6477m = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f6473i = charSequence;
        t();
    }

    public final void t() {
        boolean z7 = true;
        boolean z8 = !TextUtils.isEmpty(this.f6473i);
        if (this.f6474j != null && (!this.f6472h.A() || (!this.f6478n && !this.f6479o))) {
            z7 = false;
        }
        boolean z9 = z8 & z7;
        setText(z9 ? this.f6473i : null);
        CharSequence contentDescription = this.f6472h.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z9 ? null : this.f6472h.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f6472h.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            W.a(this, z9 ? null : this.f6472h.getTitle());
        } else {
            W.a(this, tooltipText);
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        Resources resources = context.getResources();
        this.f6478n = s();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1664i.f14662t, i7, 0);
        this.f6480p = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC1664i.f14666u, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f6482r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f6481q = -1;
        setSaveEnabled(false);
    }
}
