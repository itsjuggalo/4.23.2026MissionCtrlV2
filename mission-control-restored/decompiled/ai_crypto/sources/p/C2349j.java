package p;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import h.AbstractC1664i;
import j0.C2041a;

/* JADX INFO: renamed from: p.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2349j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f21382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2041a f21383b;

    public C2349j(EditText editText) {
        this.f21382a = editText;
        this.f21383b = new C2041a(editText, false);
    }

    public KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f21383b.a(keyListener) : keyListener;
    }

    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    public void c(AttributeSet attributeSet, int i7) {
        TypedArray typedArrayObtainStyledAttributes = this.f21382a.getContext().obtainStyledAttributes(attributeSet, AbstractC1664i.f14548S, i7, 0);
        try {
            boolean z7 = typedArrayObtainStyledAttributes.hasValue(AbstractC1664i.f14611g0) ? typedArrayObtainStyledAttributes.getBoolean(AbstractC1664i.f14611g0, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z7);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f21383b.b(inputConnection, editorInfo);
    }

    public void e(boolean z7) {
        this.f21383b.c(z7);
    }
}
