package j0;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.google.android.gms.common.api.a;

/* JADX INFO: renamed from: j0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2041a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f17337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17338b = a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17339c = 0;

    /* JADX INFO: renamed from: j0.a$a, reason: collision with other inner class name */
    public static class C0263a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditText f17340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f17341b;

        public C0263a(EditText editText, boolean z7) {
            this.f17340a = editText;
            g gVar = new g(editText, z7);
            this.f17341b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(C2042b.getInstance());
        }

        @Override // j0.C2041a.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // j0.C2041a.b
        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f17340a, inputConnection, editorInfo);
        }

        @Override // j0.C2041a.b
        public void c(boolean z7) {
            this.f17341b.c(z7);
        }
    }

    /* JADX INFO: renamed from: j0.a$b */
    public static class b {
        public abstract KeyListener a(KeyListener keyListener);

        public abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        public abstract void c(boolean z7);
    }

    public C2041a(EditText editText, boolean z7) {
        P.f.h(editText, "editText cannot be null");
        this.f17337a = new C0263a(editText, z7);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f17337a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f17337a.b(inputConnection, editorInfo);
    }

    public void c(boolean z7) {
        this.f17337a.c(z7);
    }
}
