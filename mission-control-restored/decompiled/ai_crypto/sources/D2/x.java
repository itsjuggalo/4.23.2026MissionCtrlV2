package D2;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class x extends s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f1178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f1179g;

    public x(com.google.android.material.textfield.a aVar, int i7) {
        super(aVar);
        this.f1177e = n2.d.f19168a;
        this.f1179g = new View.OnClickListener() { // from class: D2.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1176a.y(view);
            }
        };
        if (i7 != 0) {
            this.f1177e = i7;
        }
    }

    public static boolean x(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText = this.f1178f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (w()) {
            this.f1178f.setTransformationMethod(null);
        } else {
            this.f1178f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            this.f1178f.setSelection(selectionEnd);
        }
        r();
    }

    @Override // D2.s
    public void b(CharSequence charSequence, int i7, int i8, int i9) {
        r();
    }

    @Override // D2.s
    public int c() {
        return n2.h.f19247p;
    }

    @Override // D2.s
    public int d() {
        return this.f1177e;
    }

    @Override // D2.s
    public View.OnClickListener f() {
        return this.f1179g;
    }

    @Override // D2.s
    public boolean l() {
        return true;
    }

    @Override // D2.s
    public boolean m() {
        return !w();
    }

    @Override // D2.s
    public void n(EditText editText) {
        this.f1178f = editText;
        r();
    }

    @Override // D2.s
    public void s() {
        if (x(this.f1178f)) {
            this.f1178f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // D2.s
    public void u() {
        EditText editText = this.f1178f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public final boolean w() {
        EditText editText = this.f1178f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
