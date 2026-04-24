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
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionMenuView;
import n.InterfaceC1612c;
import o.C1655v;
import o.J;
import o.c0;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends C1655v implements h.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f6322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f6323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f6324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d.b f6325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public J f6326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f6327k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6328l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6329m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6330n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6331o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6332p;

    public class a extends J {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // o.J
        public InterfaceC1612c b() {
            b bVar = ActionMenuItemView.this.f6327k;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // o.J
        public boolean c() {
            InterfaceC1612c interfaceC1612cB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            d.b bVar = actionMenuItemView.f6325i;
            return bVar != null && bVar.a(actionMenuItemView.f6322f) && (interfaceC1612cB = b()) != null && interfaceC1612cB.e();
        }
    }

    public static abstract class b {
        public abstract InterfaceC1612c a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f() && this.f6322f.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean c() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void d(e eVar, int i4) {
        this.f6322f = eVar;
        setIcon(eVar.getIcon());
        setTitle(eVar.h(this));
        setId(eVar.getItemId());
        setVisibility(eVar.isVisible() ? 0 : 8);
        setEnabled(eVar.isEnabled());
        if (eVar.hasSubMenu() && this.f6326j == null) {
            this.f6326j = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i4 = configuration.screenWidthDp;
        int i5 = configuration.screenHeightDp;
        if (i4 < 480) {
            return (i4 >= 640 && i5 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public e getItemData() {
        return this.f6322f;
    }

    public final void h() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f6323g);
        if (this.f6324h != null && (!this.f6322f.A() || (!this.f6328l && !this.f6329m))) {
            z4 = false;
        }
        boolean z6 = z5 & z4;
        setText(z6 ? this.f6323g : null);
        CharSequence contentDescription = this.f6322f.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z6 ? null : this.f6322f.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f6322f.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            c0.a(this, z6 ? null : this.f6322f.getTitle());
        } else {
            c0.a(this, tooltipText);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b bVar = this.f6325i;
        if (bVar != null) {
            bVar.a(this.f6322f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f6328l = g();
        h();
    }

    @Override // o.C1655v, android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        int i6;
        boolean zF = f();
        if (zF && (i6 = this.f6331o) >= 0) {
            super.setPadding(i6, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f6330n) : this.f6330n;
        if (mode != 1073741824 && this.f6330n > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i5);
        }
        if (zF || this.f6324h == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f6324h.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        J j4;
        if (this.f6322f.hasSubMenu() && (j4 = this.f6326j) != null && j4.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z4) {
    }

    public void setChecked(boolean z4) {
    }

    public void setExpandedFormat(boolean z4) {
        if (this.f6329m != z4) {
            this.f6329m = z4;
            e eVar = this.f6322f;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f6324h = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i4 = this.f6332p;
            if (intrinsicWidth > i4) {
                intrinsicHeight = (int) (intrinsicHeight * (i4 / intrinsicWidth));
                intrinsicWidth = i4;
            }
            if (intrinsicHeight > i4) {
                intrinsicWidth = (int) (intrinsicWidth * (i4 / intrinsicHeight));
            } else {
                i4 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i4);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(d.b bVar) {
        this.f6325i = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        this.f6331o = i4;
        super.setPadding(i4, i5, i6, i7);
    }

    public void setPopupCallback(b bVar) {
        this.f6327k = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f6323g = charSequence;
        h();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Resources resources = context.getResources();
        this.f6328l = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.i.f11868t, i4, 0);
        this.f6330n = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.i.f11872u, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f6332p = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f6331o = -1;
        setSaveEnabled(false);
    }
}
