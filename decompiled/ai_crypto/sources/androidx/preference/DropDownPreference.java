package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import x0.c;

/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final Context f7854T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final ArrayAdapter f7855U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public Spinner f7856V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f7857W;

    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i7, long j7) {
            if (i7 >= 0) {
                String string = DropDownPreference.this.M()[i7].toString();
                if (string.equals(DropDownPreference.this.N()) || !DropDownPreference.this.a(string)) {
                    return;
                }
                DropDownPreference.this.P(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f25150c);
    }

    public ArrayAdapter Q() {
        return new ArrayAdapter(this.f7854T, R.layout.simple_spinner_dropdown_item);
    }

    public final void R() {
        this.f7855U.clear();
        if (K() != null) {
            for (CharSequence charSequence : K()) {
                this.f7855U.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public void v() {
        super.v();
        ArrayAdapter arrayAdapter = this.f7855U;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void x() {
        this.f7856V.performClick();
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f7857W = new a();
        this.f7854T = context;
        this.f7855U = Q();
        R();
    }
}
