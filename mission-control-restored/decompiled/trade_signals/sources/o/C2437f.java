package o;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import j0.C2197a;

/* JADX INFO: renamed from: o.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2437f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f21833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2197a f21834b;

    public C2437f(EditText editText) {
        this.f21833a = editText;
        this.f21834b = new C2197a(editText, false);
    }

    public KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f21834b.a(keyListener) : keyListener;
    }

    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    public void c(AttributeSet attributeSet, int i8) {
        TypedArray typedArrayObtainStyledAttributes = this.f21833a.getContext().obtainStyledAttributes(attributeSet, g.i.f17837S, i8, 0);
        try {
            boolean z7 = typedArrayObtainStyledAttributes.hasValue(g.i.f17886g0) ? typedArrayObtainStyledAttributes.getBoolean(g.i.f17886g0, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z7);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f21834b.b(inputConnection, editorInfo);
    }

    public void e(boolean z7) {
        this.f21834b.c(z7);
    }
}
