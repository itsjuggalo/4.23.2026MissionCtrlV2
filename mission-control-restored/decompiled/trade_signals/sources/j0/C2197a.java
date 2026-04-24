package j0;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX INFO: renamed from: j0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2197a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f19915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19916b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19917c = 0;

    /* JADX INFO: renamed from: j0.a$a, reason: collision with other inner class name */
    public static class C0324a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditText f19918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f19919b;

        public C0324a(EditText editText, boolean z7) {
            this.f19918a = editText;
            g gVar = new g(editText, z7);
            this.f19919b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(j0.b.getInstance());
        }

        @Override // j0.C2197a.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // j0.C2197a.b
        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f19918a, inputConnection, editorInfo);
        }

        @Override // j0.C2197a.b
        public void c(boolean z7) {
            this.f19919b.c(z7);
        }
    }

    /* JADX INFO: renamed from: j0.a$b */
    public static class b {
        public abstract KeyListener a(KeyListener keyListener);

        public abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        public abstract void c(boolean z7);
    }

    public C2197a(EditText editText, boolean z7) {
        S.g.e(editText, "editText cannot be null");
        this.f19915a = new C0324a(editText, z7);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f19915a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f19915a.b(inputConnection, editorInfo);
    }

    public void c(boolean z7) {
        this.f19915a.c(z7);
    }
}
