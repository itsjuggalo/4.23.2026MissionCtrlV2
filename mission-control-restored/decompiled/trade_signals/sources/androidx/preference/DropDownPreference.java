package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import s0.AbstractC2683c;

/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final Context f12041U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public final ArrayAdapter f12042V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public Spinner f12043W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f12044X;

    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i8, long j8) {
            if (i8 >= 0) {
                String string = DropDownPreference.this.c0()[i8].toString();
                if (string.equals(DropDownPreference.this.d0()) || !DropDownPreference.this.a(string)) {
                    return;
                }
                DropDownPreference.this.f0(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC2683c.f22945c);
    }

    @Override // androidx.preference.Preference
    public void L() {
        super.L();
        ArrayAdapter arrayAdapter = this.f12042V;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void N() {
        this.f12043W.performClick();
    }

    public ArrayAdapter g0() {
        return new ArrayAdapter(this.f12041U, R.layout.simple_spinner_dropdown_item);
    }

    public final void h0() {
        this.f12042V.clear();
        if (a0() != null) {
            for (CharSequence charSequence : a0()) {
                this.f12042V.add(charSequence.toString());
            }
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.f12044X = new a();
        this.f12041U = context;
        this.f12042V = g0();
        h0();
    }
}
