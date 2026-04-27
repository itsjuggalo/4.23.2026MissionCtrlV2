package j0;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class c extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f17345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f17346b;

    public static class a {
        public boolean a(InputConnection inputConnection, Editable editable, int i7, int i8, boolean z7) {
            return androidx.emoji2.text.c.e(inputConnection, editable, i7, i8, z7);
        }

        public void b(EditorInfo editorInfo) {
            if (androidx.emoji2.text.c.h()) {
                androidx.emoji2.text.c.b().u(editorInfo);
            }
        }
    }

    public c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    public final Editable a() {
        return this.f17345a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i7, int i8) {
        return this.f17346b.a(this, a(), i7, i8, false) || super.deleteSurroundingText(i7, i8);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i7, int i8) {
        return this.f17346b.a(this, a(), i7, i8, true) || super.deleteSurroundingTextInCodePoints(i7, i8);
    }

    public c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, a aVar) {
        super(inputConnection, false);
        this.f17345a = textView;
        this.f17346b = aVar;
        aVar.b(editorInfo);
    }
}
