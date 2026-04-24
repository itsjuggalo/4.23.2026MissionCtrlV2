package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import h0.AbstractC1273c;
import h0.AbstractC1277g;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final a f7737I;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
            if (CheckBoxPreference.this.a(Boolean.valueOf(z4))) {
                CheckBoxPreference.this.L(z4);
            } else {
                compoundButton.setChecked(!z4);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    @Override // androidx.preference.Preference
    public void D(View view) {
        super.D(view);
        R(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q(View view) {
        boolean z4 = view instanceof CompoundButton;
        if (z4) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f7823D);
        }
        if (z4) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f7737I);
        }
    }

    public final void R(View view) {
        if (((AccessibilityManager) g().getSystemService("accessibility")).isEnabled()) {
            Q(view.findViewById(R.id.checkbox));
            P(view.findViewById(R.id.summary));
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f7737I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f12039b, i4, i5);
        O(AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12055h, AbstractC1277g.f12042c));
        N(AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12053g, AbstractC1277g.f12045d));
        M(AbstractC1934i.b(typedArrayObtainStyledAttributes, AbstractC1277g.f12051f, AbstractC1277g.f12048e, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1934i.a(context, AbstractC1273c.f11971a, R.attr.checkBoxPreferenceStyle));
    }
}
