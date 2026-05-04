package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import d2.c;
import d2.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public SeekBar I;
    public TextView Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public final SeekBar.OnSeekBarChangeListener U;
    public final View.OnKeyListener V;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.T || !seekBarPreference.H) {
                    seekBarPreference.c0(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.d0(i10 + seekBarPreference2.E);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.H = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.H = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.E != seekBarPreference.D) {
                seekBarPreference.c0(seekBar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.R && (i10 == 21 || i10 == 22)) || i10 == 23 || i10 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.I;
            if (seekBar != null) {
                return seekBar.onKeyDown(i10, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.U = new a();
        this.V = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.C0, i10, i11);
        this.E = typedArrayObtainStyledAttributes.getInt(g.F0, 0);
        Z(typedArrayObtainStyledAttributes.getInt(g.D0, 100));
        a0(typedArrayObtainStyledAttributes.getInt(g.G0, 0));
        this.R = typedArrayObtainStyledAttributes.getBoolean(g.E0, true);
        this.S = typedArrayObtainStyledAttributes.getBoolean(g.H0, false);
        this.T = typedArrayObtainStyledAttributes.getBoolean(g.I0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public Object L(TypedArray typedArray, int i10) {
        return Integer.valueOf(typedArray.getInt(i10, 0));
    }

    public final void Z(int i10) {
        int i11 = this.E;
        if (i10 < i11) {
            i10 = i11;
        }
        if (i10 != this.F) {
            this.F = i10;
            E();
        }
    }

    public final void a0(int i10) {
        if (i10 != this.G) {
            this.G = Math.min(this.F - this.E, Math.abs(i10));
            E();
        }
    }

    public final void b0(int i10, boolean z10) {
        int i11 = this.E;
        if (i10 < i11) {
            i10 = i11;
        }
        int i12 = this.F;
        if (i10 > i12) {
            i10 = i12;
        }
        if (i10 != this.D) {
            this.D = i10;
            d0(i10);
            U(i10);
            if (z10) {
                E();
            }
        }
    }

    public void c0(SeekBar seekBar) {
        int progress = this.E + seekBar.getProgress();
        if (progress != this.D) {
            if (a(Integer.valueOf(progress))) {
                b0(progress, false);
            } else {
                seekBar.setProgress(this.D - this.E);
                d0(this.D);
            }
        }
    }

    public void d0(int i10) {
        TextView textView = this.Q;
        if (textView != null) {
            textView.setText(String.valueOf(i10));
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f7513h);
    }
}
