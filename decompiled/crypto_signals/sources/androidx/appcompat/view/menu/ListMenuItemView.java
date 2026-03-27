package androidx.appcompat.view.menu;

import D.C;
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
import com.cryptosignals.ap.android.R;
import f.d;
import h.AbstractC0616a;
import java.lang.reflect.Field;
import l.j;
import l.q;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements q, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f4215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f4216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f4217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f4218d;
    public CheckBox e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f4219f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f4220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f4221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f4222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Drawable f4223n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f4224o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f4225p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4226q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Drawable f4227r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f4228s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LayoutInflater f4229t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f4230u;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d dVarQ = d.Q(getContext(), attributeSet, AbstractC0616a.f6584n, R.attr.listMenuViewStyle);
        this.f4223n = dVarQ.G(5);
        TypedArray typedArray = (TypedArray) dVarQ.f6382b;
        this.f4224o = typedArray.getResourceId(1, -1);
        this.f4226q = typedArray.getBoolean(7, false);
        this.f4225p = context;
        this.f4227r = dVarQ.G(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f4228s = typedArrayObtainStyledAttributes.hasValue(0);
        dVarQ.S();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f4229t == null) {
            this.f4229t = LayoutInflater.from(getContext());
        }
        return this.f4229t;
    }

    private void setSubMenuArrowVisible(boolean z6) {
        ImageView imageView = this.f4220k;
        if (imageView != null) {
            imageView.setVisibility(z6 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f4221l;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4221l.getLayoutParams();
        rect.top = this.f4221l.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    @Override // l.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(l.j r11) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.b(l.j):void");
    }

    @Override // l.q
    public j getItemData() {
        return this.f4215a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Field field = C.f194a;
        setBackground(this.f4223n);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f4218d = textView;
        int i = this.f4224o;
        if (i != -1) {
            textView.setTextAppearance(this.f4225p, i);
        }
        this.f4219f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f4220k = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f4227r);
        }
        this.f4221l = (ImageView) findViewById(R.id.group_divider);
        this.f4222m = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        if (this.f4216b != null && this.f4226q) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f4216b.getLayoutParams();
            int i7 = layoutParams.height;
            if (i7 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i7;
            }
        }
        super.onMeasure(i, i6);
    }

    public void setCheckable(boolean z6) {
        CompoundButton compoundButton;
        View view;
        if (!z6 && this.f4217c == null && this.e == null) {
            return;
        }
        if ((this.f4215a.f8023x & 4) != 0) {
            if (this.f4217c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f4217c = radioButton;
                LinearLayout linearLayout = this.f4222m;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f4217c;
            view = this.e;
        } else {
            if (this.e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.e = checkBox;
                LinearLayout linearLayout2 = this.f4222m;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.e;
            view = this.f4217c;
        }
        if (z6) {
            compoundButton.setChecked(this.f4215a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f4217c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z6) {
        CompoundButton compoundButton;
        if ((this.f4215a.f8023x & 4) != 0) {
            if (this.f4217c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f4217c = radioButton;
                LinearLayout linearLayout = this.f4222m;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f4217c;
        } else {
            if (this.e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.e = checkBox;
                LinearLayout linearLayout2 = this.f4222m;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z6);
    }

    public void setForceShowIcon(boolean z6) {
        this.f4230u = z6;
        this.f4226q = z6;
    }

    public void setGroupDividerEnabled(boolean z6) {
        ImageView imageView = this.f4221l;
        if (imageView != null) {
            imageView.setVisibility((this.f4228s || !z6) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f4215a.f8013n.getClass();
        boolean z6 = this.f4230u;
        if (z6 || this.f4226q) {
            ImageView imageView = this.f4216b;
            if (imageView == null && drawable == null && !this.f4226q) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f4216b = imageView2;
                LinearLayout linearLayout = this.f4222m;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f4226q) {
                this.f4216b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f4216b;
            if (!z6) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f4216b.getVisibility() != 0) {
                this.f4216b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f4218d.getVisibility() != 8) {
                this.f4218d.setVisibility(8);
            }
        } else {
            this.f4218d.setText(charSequence);
            if (this.f4218d.getVisibility() != 0) {
                this.f4218d.setVisibility(0);
            }
        }
    }
}
