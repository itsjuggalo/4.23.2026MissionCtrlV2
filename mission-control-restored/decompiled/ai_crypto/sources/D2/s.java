package D2;

import R.AbstractC0687c;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f1145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.material.textfield.a f1146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f1147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f1148d;

    public s(com.google.android.material.textfield.a aVar) {
        this.f1145a = aVar.f11750a;
        this.f1146b = aVar;
        this.f1147c = aVar.getContext();
        this.f1148d = aVar.p();
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public AbstractC0687c.a h() {
        return null;
    }

    public boolean i(int i7) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public final void r() {
        this.f1146b.I(false);
    }

    public boolean t() {
        return false;
    }

    public void s() {
    }

    public void u() {
    }

    public void a(Editable editable) {
    }

    public void n(EditText editText) {
    }

    public void q(boolean z7) {
    }

    public void o(View view, R.x xVar) {
    }

    public void p(View view, AccessibilityEvent accessibilityEvent) {
    }

    public void b(CharSequence charSequence, int i7, int i8, int i9) {
    }
}
