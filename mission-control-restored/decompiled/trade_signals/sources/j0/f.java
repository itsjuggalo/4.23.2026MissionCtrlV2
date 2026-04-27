package j0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f19931a;

    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f19932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f19933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19934c = true;

        public a(TextView textView) {
            this.f19932a = textView;
            this.f19933b = new d(textView);
        }

        @Override // j0.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f19934c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // j0.f.b
        public boolean b() {
            return this.f19934c;
        }

        @Override // j0.f.b
        public void c(boolean z7) {
            if (z7) {
                l();
            }
        }

        @Override // j0.f.b
        public void d(boolean z7) {
            this.f19934c = z7;
            l();
            k();
        }

        @Override // j0.f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f19934c ? m(transformationMethod) : j(transformationMethod);
        }

        public final InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f19933b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f19933b;
            return inputFilterArr2;
        }

        public final SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i8 = 0; i8 < inputFilterArr.length; i8++) {
                InputFilter inputFilter = inputFilterArr[i8];
                if (inputFilter instanceof d) {
                    sparseArray.put(i8, inputFilter);
                }
            }
            return sparseArray;
        }

        public final InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray sparseArrayG = g(inputFilterArr);
            if (sparseArrayG.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayG.size()];
            int i8 = 0;
            for (int i9 = 0; i9 < length; i9++) {
                if (sparseArrayG.indexOfKey(i9) < 0) {
                    inputFilterArr2[i8] = inputFilterArr[i9];
                    i8++;
                }
            }
            return inputFilterArr2;
        }

        public void i(boolean z7) {
            this.f19934c = z7;
        }

        public final TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        public final void k() {
            this.f19932a.setFilters(a(this.f19932a.getFilters()));
        }

        public void l() {
            this.f19932a.setTransformationMethod(e(this.f19932a.getTransformationMethod()));
        }

        public final TransformationMethod m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }
    }

    public static class b {
        public abstract InputFilter[] a(InputFilter[] inputFilterArr);

        public abstract boolean b();

        public abstract void c(boolean z7);

        public abstract void d(boolean z7);

        public abstract TransformationMethod e(TransformationMethod transformationMethod);
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f19935a;

        public c(TextView textView) {
            this.f19935a = new a(textView);
        }

        @Override // j0.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f19935a.a(inputFilterArr);
        }

        @Override // j0.f.b
        public boolean b() {
            return this.f19935a.b();
        }

        @Override // j0.f.b
        public void c(boolean z7) {
            if (f()) {
                return;
            }
            this.f19935a.c(z7);
        }

        @Override // j0.f.b
        public void d(boolean z7) {
            if (f()) {
                this.f19935a.i(z7);
            } else {
                this.f19935a.d(z7);
            }
        }

        @Override // j0.f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f19935a.e(transformationMethod);
        }

        public final boolean f() {
            return !androidx.emoji2.text.c.i();
        }
    }

    public f(TextView textView, boolean z7) {
        S.g.e(textView, "textView cannot be null");
        this.f19931a = !z7 ? new c(textView) : new a(textView);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f19931a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f19931a.b();
    }

    public void c(boolean z7) {
        this.f19931a.c(z7);
    }

    public void d(boolean z7) {
        this.f19931a.d(z7);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f19931a.e(transformationMethod);
    }
}
