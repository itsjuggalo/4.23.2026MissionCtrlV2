package j0;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class c extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f19923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f19924b;

    public static class a {
        public boolean a(InputConnection inputConnection, Editable editable, int i8, int i9, boolean z7) {
            return androidx.emoji2.text.c.f(inputConnection, editable, i8, i9, z7);
        }

        public void b(EditorInfo editorInfo) {
            if (androidx.emoji2.text.c.i()) {
                androidx.emoji2.text.c.c().v(editorInfo);
            }
        }
    }

    public c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    public final Editable a() {
        return this.f19923a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i8, int i9) {
        return this.f19924b.a(this, a(), i8, i9, false) || super.deleteSurroundingText(i8, i9);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i8, int i9) {
        return this.f19924b.a(this, a(), i8, i9, true) || super.deleteSurroundingTextInCodePoints(i8, i9);
    }

    public c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, a aVar) {
        super(inputConnection, false);
        this.f19923a = textView;
        this.f19924b = aVar;
        aVar.b(editorInfo);
    }
}
