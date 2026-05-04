package androidx.appcompat.view.menu;

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
import o.j0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements h.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CheckBox f969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f977m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f978n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f979o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayoutInflater f980p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f981q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a.f9673o);
    }

    private LayoutInflater getInflater() {
        if (this.f980p == null) {
            this.f980p = LayoutInflater.from(getContext());
        }
        return this.f980p;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f971g;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f972h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f972h.getLayoutParams();
        rect.top += this.f972h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b(View view, int i10) {
        LinearLayout linearLayout = this.f973i;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void d(e eVar, int i10) {
        this.f965a = eVar;
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
        CheckBox checkBox = (CheckBox) getInflater().inflate(g.f.f9741f, (ViewGroup) this, false);
        this.f969e = checkBox;
        a(checkBox);
    }

    public final void f() {
        ImageView imageView = (ImageView) getInflater().inflate(g.f.f9742g, (ViewGroup) this, false);
        this.f966b = imageView;
        b(imageView, 0);
    }

    public final void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(g.f.f9743h, (ViewGroup) this, false);
        this.f967c = radioButton;
        a(radioButton);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public e getItemData() {
        return this.f965a;
    }

    public void h(boolean z10, char c10) {
        int i10 = (z10 && this.f965a.z()) ? 0 : 8;
        if (i10 == 0) {
            this.f970f.setText(this.f965a.f());
        }
        if (this.f970f.getVisibility() != i10) {
            this.f970f.setVisibility(i10);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f974j);
        TextView textView = (TextView) findViewById(g.e.f9734q);
        this.f968d = textView;
        int i10 = this.f975k;
        if (i10 != -1) {
            textView.setTextAppearance(this.f976l, i10);
        }
        this.f970f = (TextView) findViewById(g.e.f9730m);
        ImageView imageView = (ImageView) findViewById(g.e.f9733p);
        this.f971g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f978n);
        }
        this.f972h = (ImageView) findViewById(g.e.f9728k);
        this.f973i = (LinearLayout) findViewById(g.e.f9725h);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f966b != null && this.f977m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f966b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.f967c == null && this.f969e == null) {
            return;
        }
        if (this.f965a.l()) {
            if (this.f967c == null) {
                g();
            }
            compoundButton = this.f967c;
            view = this.f969e;
        } else {
            if (this.f969e == null) {
                e();
            }
            compoundButton = this.f969e;
            view = this.f967c;
        }
        if (z10) {
            compoundButton.setChecked(this.f965a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f969e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f967c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f965a.l()) {
            if (this.f967c == null) {
                g();
            }
            compoundButton = this.f967c;
        } else {
            if (this.f969e == null) {
                e();
            }
            compoundButton = this.f969e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f981q = z10;
        this.f977m = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f972h;
        if (imageView != null) {
            imageView.setVisibility((this.f979o || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10 = this.f965a.y() || this.f981q;
        if (z10 || this.f977m) {
            ImageView imageView = this.f966b;
            if (imageView == null && drawable == null && !this.f977m) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f977m) {
                this.f966b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f966b;
            if (!z10) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f966b.getVisibility() != 0) {
                this.f966b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f968d.getVisibility() != 8) {
                this.f968d.setVisibility(8);
            }
        } else {
            this.f968d.setText(charSequence);
            if (this.f968d.getVisibility() != 0) {
                this.f968d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        j0 j0VarS = j0.s(getContext(), attributeSet, g.i.f9804k1, i10, 0);
        this.f974j = j0VarS.f(g.i.f9812m1);
        this.f975k = j0VarS.l(g.i.f9808l1, -1);
        this.f977m = j0VarS.a(g.i.f9816n1, false);
        this.f976l = context;
        this.f978n = j0VarS.f(g.i.f9820o1);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, g.a.f9672n, 0);
        this.f979o = typedArrayObtainStyledAttributes.hasValue(0);
        j0VarS.u();
        typedArrayObtainStyledAttributes.recycle();
    }
}
