package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import h0.AbstractC1273c;

/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final Context f7745T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final ArrayAdapter f7746U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public Spinner f7747V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f7748W;

    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i4, long j4) {
            if (i4 >= 0) {
                String string = DropDownPreference.this.N()[i4].toString();
                if (string.equals(DropDownPreference.this.O()) || !DropDownPreference.this.a(string)) {
                    return;
                }
                DropDownPreference.this.Q(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1273c.f11973c);
    }

    public ArrayAdapter R() {
        return new ArrayAdapter(this.f7745T, R.layout.simple_spinner_dropdown_item);
    }

    public final void S() {
        this.f7746U.clear();
        if (L() != null) {
            for (CharSequence charSequence : L()) {
                this.f7746U.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public void w() {
        super.w();
        ArrayAdapter arrayAdapter = this.f7746U;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void y() {
        this.f7747V.performClick();
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f7748W = new a();
        this.f7745T = context;
        this.f7746U = R();
        S();
    }
}
