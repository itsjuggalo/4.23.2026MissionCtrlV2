package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import h0.AbstractC1273c;
import h0.AbstractC1277g;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f7801D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f7802E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f7803F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f7804G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f7805H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public SeekBar f7806I;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public TextView f7807O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f7808P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f7809Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f7810R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final SeekBar.OnSeekBarChangeListener f7811S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final View.OnKeyListener f7812T;

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z4) {
            if (z4) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.f7810R || !seekBarPreference.f7805H) {
                    seekBarPreference.N(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.O(i4 + seekBarPreference2.f7802E);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f7805H = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f7805H = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f7802E != seekBarPreference.f7801D) {
                seekBarPreference.N(seekBar);
            }
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i4, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.f7808P && (i4 == 21 || i4 == 22)) || i4 == 23 || i4 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.f7806I;
            if (seekBar != null) {
                return seekBar.onKeyDown(i4, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f7811S = new a();
        this.f7812T = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f11989C0, i4, i5);
        this.f7802E = typedArrayObtainStyledAttributes.getInt(AbstractC1277g.f11995F0, 0);
        K(typedArrayObtainStyledAttributes.getInt(AbstractC1277g.f11991D0, 100));
        L(typedArrayObtainStyledAttributes.getInt(AbstractC1277g.f11997G0, 0));
        this.f7808P = typedArrayObtainStyledAttributes.getBoolean(AbstractC1277g.f11993E0, true);
        this.f7809Q = typedArrayObtainStyledAttributes.getBoolean(AbstractC1277g.f11999H0, false);
        this.f7810R = typedArrayObtainStyledAttributes.getBoolean(AbstractC1277g.f12001I0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public Object A(TypedArray typedArray, int i4) {
        return Integer.valueOf(typedArray.getInt(i4, 0));
    }

    public final void K(int i4) {
        int i5 = this.f7802E;
        if (i4 < i5) {
            i4 = i5;
        }
        if (i4 != this.f7803F) {
            this.f7803F = i4;
            w();
        }
    }

    public final void L(int i4) {
        if (i4 != this.f7804G) {
            this.f7804G = Math.min(this.f7803F - this.f7802E, Math.abs(i4));
            w();
        }
    }

    public final void M(int i4, boolean z4) {
        int i5 = this.f7802E;
        if (i4 < i5) {
            i4 = i5;
        }
        int i6 = this.f7803F;
        if (i4 > i6) {
            i4 = i6;
        }
        if (i4 != this.f7801D) {
            this.f7801D = i4;
            O(i4);
            F(i4);
            if (z4) {
                w();
            }
        }
    }

    public void N(SeekBar seekBar) {
        int progress = this.f7802E + seekBar.getProgress();
        if (progress != this.f7801D) {
            if (a(Integer.valueOf(progress))) {
                M(progress, false);
            } else {
                seekBar.setProgress(this.f7801D - this.f7802E);
                O(this.f7801D);
            }
        }
    }

    public void O(int i4) {
        TextView textView = this.f7807O;
        if (textView != null) {
            textView.setText(String.valueOf(i4));
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1273c.f11978h);
    }
}
