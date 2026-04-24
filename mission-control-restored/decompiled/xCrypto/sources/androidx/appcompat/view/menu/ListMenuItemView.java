package androidx.appcompat.view.menu;

import H.E;
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
import g.AbstractC1248a;
import g.AbstractC1252e;
import g.AbstractC1253f;
import o.a0;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements h.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f6337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f6338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f6339c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f6340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CheckBox f6341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f6342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f6343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f6344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f6345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f6346k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6347l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Context f6348m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6349n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f6350o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6351p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6352q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LayoutInflater f6353r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6354s;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1248a.f11556o);
    }

    private LayoutInflater getInflater() {
        if (this.f6353r == null) {
            this.f6353r = LayoutInflater.from(getContext());
        }
        return this.f6353r;
    }

    private void setSubMenuArrowVisible(boolean z4) {
        ImageView imageView = this.f6343h;
        if (imageView != null) {
            imageView.setVisibility(z4 ? 0 : 8);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f6344i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f6344i.getLayoutParams();
        rect.top += this.f6344i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b(View view, int i4) {
        LinearLayout linearLayout = this.f6345j;
        if (linearLayout != null) {
            linearLayout.addView(view, i4);
        } else {
            addView(view, i4);
        }
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void d(e eVar, int i4) {
        this.f6337a = eVar;
        this.f6352q = i4;
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
        CheckBox checkBox = (CheckBox) getInflater().inflate(AbstractC1253f.f11657f, (ViewGroup) this, false);
        this.f6341f = checkBox;
        a(checkBox);
    }

    public final void f() {
        ImageView imageView = (ImageView) getInflater().inflate(AbstractC1253f.f11658g, (ViewGroup) this, false);
        this.f6338b = imageView;
        b(imageView, 0);
    }

    public final void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(AbstractC1253f.f11659h, (ViewGroup) this, false);
        this.f6339c = radioButton;
        a(radioButton);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public e getItemData() {
        return this.f6337a;
    }

    public void h(boolean z4, char c4) {
        int i4 = (z4 && this.f6337a.z()) ? 0 : 8;
        if (i4 == 0) {
            this.f6342g.setText(this.f6337a.f());
        }
        if (this.f6342g.getVisibility() != i4) {
            this.f6342g.setVisibility(i4);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        E.I(this, this.f6346k);
        TextView textView = (TextView) findViewById(AbstractC1252e.f11624A);
        this.f6340e = textView;
        int i4 = this.f6347l;
        if (i4 != -1) {
            textView.setTextAppearance(this.f6348m, i4);
        }
        this.f6342g = (TextView) findViewById(AbstractC1252e.f11647v);
        ImageView imageView = (ImageView) findViewById(AbstractC1252e.f11650y);
        this.f6343h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f6350o);
        }
        this.f6344i = (ImageView) findViewById(AbstractC1252e.f11637l);
        this.f6345j = (LinearLayout) findViewById(AbstractC1252e.f11633h);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        if (this.f6338b != null && this.f6349n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f6338b.getLayoutParams();
            int i6 = layoutParams.height;
            if (i6 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i6;
            }
        }
        super.onMeasure(i4, i5);
    }

    public void setCheckable(boolean z4) {
        CompoundButton compoundButton;
        View view;
        if (!z4 && this.f6339c == null && this.f6341f == null) {
            return;
        }
        if (this.f6337a.l()) {
            if (this.f6339c == null) {
                g();
            }
            compoundButton = this.f6339c;
            view = this.f6341f;
        } else {
            if (this.f6341f == null) {
                e();
            }
            compoundButton = this.f6341f;
            view = this.f6339c;
        }
        if (z4) {
            compoundButton.setChecked(this.f6337a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f6341f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f6339c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z4) {
        CompoundButton compoundButton;
        if (this.f6337a.l()) {
            if (this.f6339c == null) {
                g();
            }
            compoundButton = this.f6339c;
        } else {
            if (this.f6341f == null) {
                e();
            }
            compoundButton = this.f6341f;
        }
        compoundButton.setChecked(z4);
    }

    public void setForceShowIcon(boolean z4) {
        this.f6354s = z4;
        this.f6349n = z4;
    }

    public void setGroupDividerEnabled(boolean z4) {
        ImageView imageView = this.f6344i;
        if (imageView != null) {
            imageView.setVisibility((this.f6351p || !z4) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z4 = this.f6337a.y() || this.f6354s;
        if (z4 || this.f6349n) {
            ImageView imageView = this.f6338b;
            if (imageView == null && drawable == null && !this.f6349n) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f6349n) {
                this.f6338b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f6338b;
            if (!z4) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f6338b.getVisibility() != 0) {
                this.f6338b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f6340e.getVisibility() != 8) {
                this.f6340e.setVisibility(8);
            }
        } else {
            this.f6340e.setText(charSequence);
            if (this.f6340e.getVisibility() != 0) {
                this.f6340e.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet);
        a0 a0VarR = a0.r(getContext(), attributeSet, g.i.f11858q1, i4, 0);
        this.f6346k = a0VarR.f(g.i.f11866s1);
        this.f6347l = a0VarR.l(g.i.f11862r1, -1);
        this.f6349n = a0VarR.a(g.i.f11870t1, false);
        this.f6348m = context;
        this.f6350o = a0VarR.f(g.i.f11874u1);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, AbstractC1248a.f11555n, 0);
        this.f6351p = typedArrayObtainStyledAttributes.hasValue(0);
        a0VarR.s();
        typedArrayObtainStyledAttributes.recycle();
    }
}
