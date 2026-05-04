package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import d2.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    public final Context V;
    public final ArrayAdapter W;
    public Spinner X;
    public final AdapterView.OnItemSelectedListener Y;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f7508c);
    }

    @Override // androidx.preference.Preference
    public void E() {
        super.E();
        ArrayAdapter arrayAdapter = this.W;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void H() {
        this.X.performClick();
    }

    public ArrayAdapter g0() {
        return new ArrayAdapter(this.V, R.layout.simple_spinner_dropdown_item);
    }

    public final void h0() {
        this.W.clear();
        if (a0() != null) {
            for (CharSequence charSequence : a0()) {
                this.W.add(charSequence.toString());
            }
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.Y = new a();
        this.V = context;
        this.W = g0();
        h0();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
            if (i10 >= 0) {
                String string = DropDownPreference.this.c0()[i10].toString();
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
}
