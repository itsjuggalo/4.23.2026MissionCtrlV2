package androidx.preference;

import H.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import x0.c;
import x0.g;

/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final a f7846I;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (CheckBoxPreference.this.a(Boolean.valueOf(z7))) {
                CheckBoxPreference.this.K(z7);
            } else {
                compoundButton.setChecked(!z7);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    @Override // androidx.preference.Preference
    public void C(View view) {
        super.C(view);
        Q(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P(View view) {
        boolean z7 = view instanceof CompoundButton;
        if (z7) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f7932D);
        }
        if (z7) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f7846I);
        }
    }

    public final void Q(View view) {
        if (((AccessibilityManager) c().getSystemService("accessibility")).isEnabled()) {
            P(view.findViewById(R.id.checkbox));
            O(view.findViewById(R.id.summary));
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f7846I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f25216b, i7, i8);
        N(i.f(typedArrayObtainStyledAttributes, g.f25232h, g.f25219c));
        M(i.f(typedArrayObtainStyledAttributes, g.f25230g, g.f25222d));
        L(i.b(typedArrayObtainStyledAttributes, g.f25228f, g.f25225e, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f25148a, R.attr.checkBoxPreferenceStyle));
    }
}
