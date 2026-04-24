package j0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class e implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyListener f19929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f19930b;

    public static class a {
        public boolean a(Editable editable, int i8, KeyEvent keyEvent) {
            return androidx.emoji2.text.c.g(editable, i8, keyEvent);
        }
    }

    public e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i8) {
        this.f19929a.clearMetaKeyState(view, editable, i8);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f19929a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i8, KeyEvent keyEvent) {
        return this.f19930b.a(editable, i8, keyEvent) || this.f19929a.onKeyDown(view, editable, i8, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f19929a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i8, KeyEvent keyEvent) {
        return this.f19929a.onKeyUp(view, editable, i8, keyEvent);
    }

    public e(KeyListener keyListener, a aVar) {
        this.f19929a = keyListener;
        this.f19930b = aVar;
    }
}
