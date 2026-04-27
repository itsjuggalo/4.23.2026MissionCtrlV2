package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.common.api.a;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.editing.m;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class l extends BaseInputConnection implements m.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f16646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final U4.u f16648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final U4.z f16649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f16650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EditorInfo f16651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ExtractedTextRequest f16652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CursorAnchorInfo.Builder f16654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ExtractedText f16655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public InputMethodManager f16656k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Layout f16657l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C1995a f16658m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f16659n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f16660o;

    public interface a {
        boolean a(KeyEvent keyEvent);
    }

    public l(View view, int i7, U4.z zVar, U4.u uVar, a aVar, m mVar, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.f16653h = false;
        this.f16655j = new ExtractedText();
        this.f16660o = 0;
        this.f16646a = view;
        this.f16647b = i7;
        this.f16649d = zVar;
        this.f16648c = uVar;
        this.f16650e = mVar;
        mVar.a(this);
        this.f16651f = editorInfo;
        this.f16659n = aVar;
        this.f16658m = new C1995a(flutterJNI);
        this.f16657l = new DynamicLayout(mVar, new TextPaint(), a.e.API_PRIORITY_OTHER, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f16656k = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    @Override // io.flutter.plugin.editing.m.b
    public void a(boolean z7, boolean z8, boolean z9) {
        this.f16656k.updateSelection(this.f16646a, this.f16650e.i(), this.f16650e.h(), this.f16650e.g(), this.f16650e.f());
        ExtractedTextRequest extractedTextRequest = this.f16652g;
        if (extractedTextRequest != null) {
            this.f16656k.updateExtractedText(this.f16646a, extractedTextRequest.token, d(extractedTextRequest));
        }
        if (this.f16653h) {
            this.f16656k.updateCursorAnchorInfo(this.f16646a, c());
        }
    }

    public final boolean b(int i7) {
        if (i7 == 16908319) {
            setSelection(0, this.f16650e.length());
            return true;
        }
        if (i7 == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.f16650e);
            int selectionEnd = Selection.getSelectionEnd(this.f16650e);
            if (selectionStart != selectionEnd) {
                int iMin = Math.min(selectionStart, selectionEnd);
                int iMax = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.f16646a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f16650e.subSequence(iMin, iMax)));
                this.f16650e.delete(iMin, iMax);
                setSelection(iMin, iMin);
            }
            return true;
        }
        if (i7 == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.f16650e);
            int selectionEnd2 = Selection.getSelectionEnd(this.f16650e);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.f16646a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f16650e.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        }
        if (i7 != 16908322) {
            return false;
        }
        ClipData primaryClip = ((ClipboardManager) this.f16646a.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip != null) {
            CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(this.f16646a.getContext());
            int iMax2 = Math.max(0, Selection.getSelectionStart(this.f16650e));
            int iMax3 = Math.max(0, Selection.getSelectionEnd(this.f16650e));
            int iMin2 = Math.min(iMax2, iMax3);
            int iMax4 = Math.max(iMax2, iMax3);
            if (iMin2 != iMax4) {
                this.f16650e.delete(iMin2, iMax4);
            }
            this.f16650e.insert(iMin2, charSequenceCoerceToText);
            int length = iMin2 + charSequenceCoerceToText.length();
            setSelection(length, length);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.f16650e.b();
        this.f16660o++;
        return super.beginBatchEdit();
    }

    public final CursorAnchorInfo c() {
        CursorAnchorInfo.Builder builder = this.f16654i;
        if (builder == null) {
            this.f16654i = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.f16654i.setSelectionRange(this.f16650e.i(), this.f16650e.h());
        int iG = this.f16650e.g();
        int iF = this.f16650e.f();
        if (iG < 0 || iF <= iG) {
            this.f16654i.setComposingText(-1, "");
        } else {
            this.f16654i.setComposingText(iG, this.f16650e.toString().subSequence(iG, iF));
        }
        return this.f16654i.build();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i7) {
        return super.clearMetaKeyStates(i7);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public void closeConnection() {
        super.closeConnection();
        this.f16650e.l(this);
        while (this.f16660o > 0) {
            endBatchEdit();
            this.f16660o--;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i7, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i7 & 1) != 0) {
            try {
                inputContentInfo.requestPermission();
                if (inputContentInfo.getDescription().getMimeTypeCount() > 0) {
                    inputContentInfo.requestPermission();
                    Uri contentUri = inputContentInfo.getContentUri();
                    String mimeType = inputContentInfo.getDescription().getMimeType(0);
                    Context context = this.f16646a.getContext();
                    if (contentUri != null) {
                        try {
                            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(contentUri);
                            if (inputStreamOpenInputStream != null) {
                                byte[] bArrH = h(inputStreamOpenInputStream, 65536);
                                HashMap map = new HashMap();
                                map.put("mimeType", mimeType);
                                map.put("data", bArrH);
                                map.put("uri", contentUri.toString());
                                this.f16649d.b(this.f16647b, map);
                                inputContentInfo.releasePermission();
                                return true;
                            }
                        } catch (FileNotFoundException unused) {
                            inputContentInfo.releasePermission();
                            return false;
                        }
                    }
                    inputContentInfo.releasePermission();
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i7) {
        return super.commitText(charSequence, i7);
    }

    public final ExtractedText d(ExtractedTextRequest extractedTextRequest) {
        ExtractedText extractedText = this.f16655j;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.selectionStart = this.f16650e.i();
        this.f16655j.selectionEnd = this.f16650e.h();
        this.f16655j.text = (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) ? this.f16650e.toString() : this.f16650e;
        return this.f16655j;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i7, int i8) {
        if (this.f16650e.i() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i7, i8);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i7, int i8) {
        return super.deleteSurroundingTextInCodePoints(i7, i8);
    }

    public final boolean e(boolean z7, boolean z8) {
        int selectionStart = Selection.getSelectionStart(this.f16650e);
        int selectionEnd = Selection.getSelectionEnd(this.f16650e);
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        int iMax = z7 ? Math.max(this.f16658m.b(this.f16650e, selectionEnd), 0) : Math.min(this.f16658m.a(this.f16650e, selectionEnd), this.f16650e.length());
        if (selectionStart != selectionEnd || z8) {
            setSelection(selectionStart, iMax);
            return true;
        }
        setSelection(iMax, iMax);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        boolean zEndBatchEdit = super.endBatchEdit();
        this.f16660o--;
        this.f16650e.d();
        return zEndBatchEdit;
    }

    public boolean f(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 21) {
                return e(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 22) {
                return e(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 19) {
                return g(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 20) {
                return g(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                EditorInfo editorInfo = this.f16651f;
                if ((editorInfo.inputType & 131072) == 0) {
                    performEditorAction(editorInfo.imeOptions & 255);
                    return true;
                }
            }
            int selectionStart = Selection.getSelectionStart(this.f16650e);
            int selectionEnd = Selection.getSelectionEnd(this.f16650e);
            int unicodeChar = keyEvent.getUnicodeChar();
            if (selectionStart >= 0 && selectionEnd >= 0 && unicodeChar != 0) {
                int iMin = Math.min(selectionStart, selectionEnd);
                int iMax = Math.max(selectionStart, selectionEnd);
                beginBatchEdit();
                if (iMin != iMax) {
                    this.f16650e.delete(iMin, iMax);
                }
                this.f16650e.insert(iMin, (CharSequence) String.valueOf((char) unicodeChar));
                int i7 = iMin + 1;
                setSelection(i7, i7);
                endBatchEdit();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    public final boolean g(boolean z7, boolean z8) {
        int selectionStart = Selection.getSelectionStart(this.f16650e);
        int selectionEnd = Selection.getSelectionEnd(this.f16650e);
        boolean z9 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z8) {
            z9 = true;
        }
        beginBatchEdit();
        if (z9) {
            if (z7) {
                Selection.moveUp(this.f16650e, this.f16657l);
            } else {
                Selection.moveDown(this.f16650e, this.f16657l);
            }
            int selectionStart2 = Selection.getSelectionStart(this.f16650e);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z7) {
                Selection.extendUp(this.f16650e, this.f16657l);
            } else {
                Selection.extendDown(this.f16650e, this.f16657l);
            }
            setSelection(Selection.getSelectionStart(this.f16650e), Selection.getSelectionEnd(this.f16650e));
        }
        endBatchEdit();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        return this.f16650e;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i7) {
        boolean z7 = (i7 & 1) != 0;
        if (z7 == (this.f16652g == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z7 ? "on" : "off");
            J4.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f16652g = z7 ? extractedTextRequest : null;
        return d(extractedTextRequest);
    }

    public final byte[] h(InputStream inputStream, int i7) {
        int i8;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i7];
        while (true) {
            try {
                i8 = inputStream.read(bArr);
            } catch (IOException unused) {
                i8 = -1;
            }
            if (i8 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i8);
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i7) {
        beginBatchEdit();
        boolean zB = b(i7);
        endBatchEdit();
        return zB;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i7) {
        if (i7 == 0) {
            this.f16649d.o(this.f16647b);
        } else if (i7 == 1) {
            this.f16649d.g(this.f16647b);
        } else if (i7 == 2) {
            this.f16649d.f(this.f16647b);
        } else if (i7 == 3) {
            this.f16649d.l(this.f16647b);
        } else if (i7 == 4) {
            this.f16649d.m(this.f16647b);
        } else if (i7 == 5) {
            this.f16649d.h(this.f16647b);
        } else if (i7 != 7) {
            this.f16649d.e(this.f16647b);
        } else {
            this.f16649d.j(this.f16647b);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.f16649d.i(this.f16647b, str, bundle);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i7) {
        if ((i7 & 1) != 0) {
            this.f16656k.updateCursorAnchorInfo(this.f16646a, c());
        }
        boolean z7 = (i7 & 2) != 0;
        if (z7 != this.f16653h) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z7 ? "on" : "off");
            J4.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f16653h = z7;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.f16659n.a(keyEvent);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i7, int i8) {
        return super.setComposingRegion(i7, i8);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i7) {
        beginBatchEdit();
        boolean zCommitText = charSequence.length() == 0 ? super.commitText(charSequence, i7) : super.setComposingText(charSequence, i7);
        endBatchEdit();
        return zCommitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i7, int i8) {
        beginBatchEdit();
        boolean selection = super.setSelection(i7, i8);
        endBatchEdit();
        return selection;
    }

    public l(View view, int i7, U4.z zVar, U4.u uVar, a aVar, m mVar, EditorInfo editorInfo) {
        this(view, i7, zVar, uVar, aVar, mVar, editorInfo, new FlutterJNI());
    }
}
