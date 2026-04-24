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
import g.AbstractC1764a;
import g.AbstractC1768e;
import g.AbstractC1769f;
import o.L;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements h.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f10380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f10381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f10382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f10383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CheckBox f10384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f10385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f10386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f10387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f10388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f10389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10390k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f10391l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10392m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f10393n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10394o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayoutInflater f10395p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10396q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1764a.f17664o);
    }

    private LayoutInflater getInflater() {
        if (this.f10395p == null) {
            this.f10395p = LayoutInflater.from(getContext());
        }
        return this.f10395p;
    }

    private void setSubMenuArrowVisible(boolean z7) {
        ImageView imageView = this.f10386g;
        if (imageView != null) {
            imageView.setVisibility(z7 ? 0 : 8);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f10387h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10387h.getLayoutParams();
        rect.top += this.f10387h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b(View view, int i8) {
        LinearLayout linearLayout = this.f10388i;
        if (linearLayout != null) {
            linearLayout.addView(view, i8);
        } else {
            addView(view, i8);
        }
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void d(e eVar, int i8) {
        this.f10380a = eVar;
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
        CheckBox checkBox = (CheckBox) getInflater().inflate(AbstractC1769f.f17751f, (ViewGroup) this, false);
        this.f10384e = checkBox;
        a(checkBox);
    }

    public final void f() {
        ImageView imageView = (ImageView) getInflater().inflate(AbstractC1769f.f17752g, (ViewGroup) this, false);
        this.f10381b = imageView;
        b(imageView, 0);
    }

    public final void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(AbstractC1769f.f17753h, (ViewGroup) this, false);
        this.f10382c = radioButton;
        a(radioButton);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public e getItemData() {
        return this.f10380a;
    }

    public void h(boolean z7, char c8) {
        int i8 = (z7 && this.f10380a.z()) ? 0 : 8;
        if (i8 == 0) {
            this.f10385f.setText(this.f10380a.f());
        }
        if (this.f10385f.getVisibility() != i8) {
            this.f10385f.setVisibility(i8);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f10389j);
        TextView textView = (TextView) findViewById(AbstractC1768e.f17744q);
        this.f10383d = textView;
        int i8 = this.f10390k;
        if (i8 != -1) {
            textView.setTextAppearance(this.f10391l, i8);
        }
        this.f10385f = (TextView) findViewById(AbstractC1768e.f17740m);
        ImageView imageView = (ImageView) findViewById(AbstractC1768e.f17743p);
        this.f10386g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f10393n);
        }
        this.f10387h = (ImageView) findViewById(AbstractC1768e.f17738k);
        this.f10388i = (LinearLayout) findViewById(AbstractC1768e.f17735h);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        if (this.f10381b != null && this.f10392m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f10381b.getLayoutParams();
            int i10 = layoutParams.height;
            if (i10 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i10;
            }
        }
        super.onMeasure(i8, i9);
    }

    public void setCheckable(boolean z7) {
        CompoundButton compoundButton;
        View view;
        if (!z7 && this.f10382c == null && this.f10384e == null) {
            return;
        }
        if (this.f10380a.l()) {
            if (this.f10382c == null) {
                g();
            }
            compoundButton = this.f10382c;
            view = this.f10384e;
        } else {
            if (this.f10384e == null) {
                e();
            }
            compoundButton = this.f10384e;
            view = this.f10382c;
        }
        if (z7) {
            compoundButton.setChecked(this.f10380a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f10384e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f10382c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z7) {
        CompoundButton compoundButton;
        if (this.f10380a.l()) {
            if (this.f10382c == null) {
                g();
            }
            compoundButton = this.f10382c;
        } else {
            if (this.f10384e == null) {
                e();
            }
            compoundButton = this.f10384e;
        }
        compoundButton.setChecked(z7);
    }

    public void setForceShowIcon(boolean z7) {
        this.f10396q = z7;
        this.f10392m = z7;
    }

    public void setGroupDividerEnabled(boolean z7) {
        ImageView imageView = this.f10387h;
        if (imageView != null) {
            imageView.setVisibility((this.f10394o || !z7) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z7 = this.f10380a.y() || this.f10396q;
        if (z7 || this.f10392m) {
            ImageView imageView = this.f10381b;
            if (imageView == null && drawable == null && !this.f10392m) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f10392m) {
                this.f10381b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f10381b;
            if (!z7) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f10381b.getVisibility() != 0) {
                this.f10381b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i8;
        TextView textView;
        if (charSequence != null) {
            this.f10383d.setText(charSequence);
            if (this.f10383d.getVisibility() == 0) {
                return;
            }
            textView = this.f10383d;
            i8 = 0;
        } else {
            i8 = 8;
            if (this.f10383d.getVisibility() == 8) {
                return;
            } else {
                textView = this.f10383d;
            }
        }
        textView.setVisibility(i8);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet);
        L lS = L.s(getContext(), attributeSet, g.i.f17903k1, i8, 0);
        this.f10389j = lS.f(g.i.f17911m1);
        this.f10390k = lS.l(g.i.f17907l1, -1);
        this.f10392m = lS.a(g.i.f17915n1, false);
        this.f10391l = context;
        this.f10393n = lS.f(g.i.f17919o1);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, AbstractC1764a.f17663n, 0);
        this.f10394o = typedArrayObtainStyledAttributes.hasValue(0);
        lS.u();
        typedArrayObtainStyledAttributes.recycle();
    }
}
