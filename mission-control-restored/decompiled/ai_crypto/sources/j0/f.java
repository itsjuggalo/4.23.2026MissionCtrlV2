package j0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f17353a;

    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f17354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f17355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17356c = true;

        public a(TextView textView) {
            this.f17354a = textView;
            this.f17355b = new d(textView);
        }

        @Override // j0.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f17356c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // j0.f.b
        public boolean b() {
            return this.f17356c;
        }

        @Override // j0.f.b
        public void c(boolean z7) {
            if (z7) {
                l();
            }
        }

        @Override // j0.f.b
        public void d(boolean z7) {
            this.f17356c = z7;
            l();
            k();
        }

        @Override // j0.f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f17356c ? m(transformationMethod) : j(transformationMethod);
        }

        public final InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f17355b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f17355b;
            return inputFilterArr2;
        }

        public final SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i7 = 0; i7 < inputFilterArr.length; i7++) {
                InputFilter inputFilter = inputFilterArr[i7];
                if (inputFilter instanceof d) {
                    sparseArray.put(i7, inputFilter);
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
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                if (sparseArrayG.indexOfKey(i8) < 0) {
                    inputFilterArr2[i7] = inputFilterArr[i8];
                    i7++;
                }
            }
            return inputFilterArr2;
        }

        public void i(boolean z7) {
            this.f17356c = z7;
        }

        public final TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        public final void k() {
            this.f17354a.setFilters(a(this.f17354a.getFilters()));
        }

        public void l() {
            this.f17354a.setTransformationMethod(e(this.f17354a.getTransformationMethod()));
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
        public final a f17357a;

        public c(TextView textView) {
            this.f17357a = new a(textView);
        }

        @Override // j0.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f17357a.a(inputFilterArr);
        }

        @Override // j0.f.b
        public boolean b() {
            return this.f17357a.b();
        }

        @Override // j0.f.b
        public void c(boolean z7) {
            if (f()) {
                return;
            }
            this.f17357a.c(z7);
        }

        @Override // j0.f.b
        public void d(boolean z7) {
            if (f()) {
                this.f17357a.i(z7);
            } else {
                this.f17357a.d(z7);
            }
        }

        @Override // j0.f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f17357a.e(transformationMethod);
        }

        public final boolean f() {
            return !androidx.emoji2.text.c.h();
        }
    }

    public f(TextView textView, boolean z7) {
        P.f.h(textView, "textView cannot be null");
        if (z7) {
            this.f17353a = new a(textView);
        } else {
            this.f17353a = new c(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f17353a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f17353a.b();
    }

    public void c(boolean z7) {
        this.f17353a.c(z7);
    }

    public void d(boolean z7) {
        this.f17353a.d(z7);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f17353a.e(transformationMethod);
    }
}
