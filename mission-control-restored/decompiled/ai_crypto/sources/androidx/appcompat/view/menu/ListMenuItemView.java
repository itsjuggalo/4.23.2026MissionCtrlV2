package androidx.appcompat.view.menu;

import Q.N;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.h;
import h.AbstractC1656a;
import h.AbstractC1660e;
import h.AbstractC1661f;
import h.AbstractC1664i;
import p.S;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements h.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f6487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f6488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f6489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f6490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CheckBox f6491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f6492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f6493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f6494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f6495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f6496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6497k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f6498l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f6500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6501o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayoutInflater f6502p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6503q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1656a.f14349p);
    }

    private LayoutInflater getInflater() {
        if (this.f6502p == null) {
            this.f6502p = LayoutInflater.from(getContext());
        }
        return this.f6502p;
    }

    private void setSubMenuArrowVisible(boolean z7) {
        ImageView imageView = this.f6493g;
        if (imageView != null) {
            imageView.setVisibility(z7 ? 0 : 8);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f6494h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f6494h.getLayoutParams();
        rect.top += this.f6494h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b(View view, int i7) {
        LinearLayout linearLayout = this.f6495i;
        if (linearLayout != null) {
            linearLayout.addView(view, i7);
        } else {
            addView(view, i7);
        }
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void d(e eVar, int i7) {
        this.f6487a = eVar;
        setVisibility(eVar.isVisible() ? 0 : 8);
        setTitle(eVar.h(this));
        setCheckable(eVar.isCheckable());
        h(eVar.z(), eVar.e());
        setIcon(eVar.getIcon());
        setEnabled(eVar.isEnabled());
        setSubMenuArrowVisible(eVar.hasSubMenu());
        setContentDescription(eVar.getContentDescription());
    }

    public final void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(AbstractC1661f.f14452f, (ViewGroup) this, false);
        this.f6491e = checkBox;
        a(checkBox);
    }

    public final void f() {
        ImageView imageView = (ImageView) getInflater().inflate(AbstractC1661f.f14453g, (ViewGroup) this, false);
        this.f6488b = imageView;
        b(imageView, 0);
    }

    public final void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(AbstractC1661f.f14454h, (ViewGroup) this, false);
        this.f6489c = radioButton;
        a(radioButton);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public e getItemData() {
        return this.f6487a;
    }

    public void h(boolean z7, char c7) {
        int i7 = (z7 && this.f6487a.z()) ? 0 : 8;
        if (i7 == 0) {
            this.f6492f.setText(this.f6487a.f());
        }
        if (this.f6492f.getVisibility() != i7) {
            this.f6492f.setVisibility(i7);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        N.p0(this, this.f6496j);
        TextView textView = (TextView) findViewById(AbstractC1660e.f14419A);
        this.f6490d = textView;
        int i7 = this.f6497k;
        if (i7 != -1) {
            textView.setTextAppearance(this.f6498l, i7);
        }
        this.f6492f = (TextView) findViewById(AbstractC1660e.f14442v);
        ImageView imageView = (ImageView) findViewById(AbstractC1660e.f14445y);
        this.f6493g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f6500n);
        }
        this.f6494h = (ImageView) findViewById(AbstractC1660e.f14432l);
        this.f6495i = (LinearLayout) findViewById(AbstractC1660e.f14428h);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        if (this.f6488b != null && this.f6499m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f6488b.getLayoutParams();
            int i9 = layoutParams.height;
            if (i9 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i9;
            }
        }
        super.onMeasure(i7, i8);
    }

    public void setCheckable(boolean z7) {
        CompoundButton compoundButton;
        View view;
        if (!z7 && this.f6489c == null && this.f6491e == null) {
            return;
        }
        if (this.f6487a.l()) {
            if (this.f6489c == null) {
                g();
            }
            compoundButton = this.f6489c;
            view = this.f6491e;
        } else {
            if (this.f6491e == null) {
                e();
            }
            compoundButton = this.f6491e;
            view = this.f6489c;
        }
        if (z7) {
            compoundButton.setChecked(this.f6487a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f6491e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f6489c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z7) {
        CompoundButton compoundButton;
        if (this.f6487a.l()) {
            if (this.f6489c == null) {
                g();
            }
            compoundButton = this.f6489c;
        } else {
            if (this.f6491e == null) {
                e();
            }
            compoundButton = this.f6491e;
        }
        compoundButton.setChecked(z7);
    }

    public void setForceShowIcon(boolean z7) {
        this.f6503q = z7;
        this.f6499m = z7;
    }

    public void setGroupDividerEnabled(boolean z7) {
        ImageView imageView = this.f6494h;
        if (imageView != null) {
            imageView.setVisibility((this.f6501o || !z7) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z7 = this.f6487a.y() || this.f6503q;
        if (z7 || this.f6499m) {
            ImageView imageView = this.f6488b;
            if (imageView == null && drawable == null && !this.f6499m) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f6499m) {
                this.f6488b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f6488b;
            if (!z7) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f6488b.getVisibility() != 0) {
                this.f6488b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f6490d.getVisibility() != 8) {
                this.f6490d.setVisibility(8);
            }
        } else {
            this.f6490d.setText(charSequence);
            if (this.f6490d.getVisibility() != 0) {
                this.f6490d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet);
        S sT = S.t(getContext(), attributeSet, AbstractC1664i.f14644o1, i7, 0);
        this.f6496j = sT.g(AbstractC1664i.f14652q1);
        this.f6497k = sT.m(AbstractC1664i.f14648p1, -1);
        this.f6499m = sT.a(AbstractC1664i.f14656r1, false);
        this.f6498l = context;
        this.f6500n = sT.g(AbstractC1664i.f14660s1);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, AbstractC1656a.f14347n, 0);
        this.f6501o = typedArrayObtainStyledAttributes.hasValue(0);
        sT.u();
        typedArrayObtainStyledAttributes.recycle();
    }
}
