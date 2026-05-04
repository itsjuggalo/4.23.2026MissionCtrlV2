package s1;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f19929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19930b = a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19931c = 0;

    /* JADX INFO: renamed from: s1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0347a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditText f19932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f19933b;

        public C0347a(EditText editText, boolean z10) {
            this.f19932a = editText;
            g gVar = new g(editText, z10);
            this.f19933b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(s1.b.getInstance());
        }

        @Override // s1.a.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // s1.a.b
        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f19932a, inputConnection, editorInfo);
        }

        @Override // s1.a.b
        public void c(boolean z10) {
            this.f19933b.c(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {
        public abstract KeyListener a(KeyListener keyListener);

        public abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        public abstract void c(boolean z10);
    }

    public a(EditText editText, boolean z10) {
        s0.f.e(editText, "editText cannot be null");
        this.f19929a = new C0347a(editText, z10);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f19929a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f19929a.b(inputConnection, editorInfo);
    }

    public void c(boolean z10) {
        this.f19929a.c(z10);
    }
}
