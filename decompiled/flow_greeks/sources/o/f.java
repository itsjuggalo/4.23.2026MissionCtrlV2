package o;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f17254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.a f17255b;

    public f(EditText editText) {
        this.f17254a = editText;
        this.f17255b = new s1.a(editText, false);
    }

    public KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f17255b.a(keyListener) : keyListener;
    }

    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    public void c(AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f17254a.getContext().obtainStyledAttributes(attributeSet, g.i.S, i10, 0);
        try {
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(g.i.f9787g0) ? typedArrayObtainStyledAttributes.getBoolean(g.i.f9787g0, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f17255b.b(inputConnection, editorInfo);
    }

    public void e(boolean z10) {
        this.f17255b.c(z10);
    }
}
