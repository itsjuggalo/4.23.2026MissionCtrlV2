package y2;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
import z2.AbstractC2884f;
import z2.C2882d;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f25627c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C2882d f25630f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f25625a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2884f f25626b = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25628d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference f25629e = new WeakReference(null);

    public class a extends AbstractC2884f {
        public a() {
        }

        @Override // z2.AbstractC2884f
        public void a(int i7) {
            i.this.f25628d = true;
            b bVar = (b) i.this.f25629e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // z2.AbstractC2884f
        public void b(Typeface typeface, boolean z7) {
            if (z7) {
                return;
            }
            i.this.f25628d = true;
            b bVar = (b) i.this.f25629e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public i(b bVar) {
        g(bVar);
    }

    public final float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f25625a.measureText(charSequence, 0, charSequence.length());
    }

    public C2882d d() {
        return this.f25630f;
    }

    public TextPaint e() {
        return this.f25625a;
    }

    public float f(String str) {
        if (!this.f25628d) {
            return this.f25627c;
        }
        float fC = c(str);
        this.f25627c = fC;
        this.f25628d = false;
        return fC;
    }

    public void g(b bVar) {
        this.f25629e = new WeakReference(bVar);
    }

    public void h(C2882d c2882d, Context context) {
        if (this.f25630f != c2882d) {
            this.f25630f = c2882d;
            if (c2882d != null) {
                c2882d.o(context, this.f25625a, this.f25626b);
                b bVar = (b) this.f25629e.get();
                if (bVar != null) {
                    this.f25625a.drawableState = bVar.getState();
                }
                c2882d.n(context, this.f25625a, this.f25626b);
                this.f25628d = true;
            }
            b bVar2 = (b) this.f25629e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z7) {
        this.f25628d = z7;
    }

    public void j(Context context) {
        this.f25630f.n(context, this.f25625a, this.f25626b);
    }
}
