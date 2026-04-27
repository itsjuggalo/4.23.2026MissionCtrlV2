package androidx.preference;

import K.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import s0.AbstractC2683c;
import s0.g;

/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final a f12033I;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (CheckBoxPreference.this.a(Boolean.valueOf(z7))) {
                CheckBoxPreference.this.a0(z7);
            } else {
                compoundButton.setChecked(!z7);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, AbstractC2683c.f22943a, R.attr.checkBoxPreferenceStyle));
    }

    @Override // androidx.preference.Preference
    public void S(View view) {
        super.S(view);
        g0(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f0(View view) {
        boolean z7 = view instanceof CompoundButton;
        if (z7) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f12119D);
        }
        if (z7) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f12033I);
        }
    }

    public final void g0(View view) {
        if (((AccessibilityManager) g().getSystemService("accessibility")).isEnabled()) {
            f0(view.findViewById(R.id.checkbox));
            e0(view.findViewById(R.id.summary));
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.f12033I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f23011b, i8, i9);
        d0(i.f(typedArrayObtainStyledAttributes, g.f23027h, g.f23014c));
        c0(i.f(typedArrayObtainStyledAttributes, g.f23025g, g.f23017d));
        b0(i.b(typedArrayObtainStyledAttributes, g.f23023f, g.f23020e, false));
        typedArrayObtainStyledAttributes.recycle();
    }
}
