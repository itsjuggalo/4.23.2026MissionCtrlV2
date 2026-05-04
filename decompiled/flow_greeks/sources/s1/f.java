package s1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f19945a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f19946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f19947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19948c = true;

        public a(TextView textView) {
            this.f19946a = textView;
            this.f19947b = new d(textView);
        }

        @Override // s1.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f19948c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // s1.f.b
        public boolean b() {
            return this.f19948c;
        }

        @Override // s1.f.b
        public void c(boolean z10) {
            if (z10) {
                l();
            }
        }

        @Override // s1.f.b
        public void d(boolean z10) {
            this.f19948c = z10;
            l();
            k();
        }

        @Override // s1.f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f19948c ? m(transformationMethod) : j(transformationMethod);
        }

        public final InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f19947b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f19947b;
            return inputFilterArr2;
        }

        public final SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                InputFilter inputFilter = inputFilterArr[i10];
                if (inputFilter instanceof d) {
                    sparseArray.put(i10, inputFilter);
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
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (sparseArrayG.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }

        public void i(boolean z10) {
            this.f19948c = z10;
        }

        public final TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        public final void k() {
            this.f19946a.setFilters(a(this.f19946a.getFilters()));
        }

        public void l() {
            this.f19946a.setTransformationMethod(e(this.f19946a.getTransformationMethod()));
        }

        public final TransformationMethod m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {
        public abstract InputFilter[] a(InputFilter[] inputFilterArr);

        public abstract boolean b();

        public abstract void c(boolean z10);

        public abstract void d(boolean z10);

        public abstract TransformationMethod e(TransformationMethod transformationMethod);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f19949a;

        public c(TextView textView) {
            this.f19949a = new a(textView);
        }

        @Override // s1.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f19949a.a(inputFilterArr);
        }

        @Override // s1.f.b
        public boolean b() {
            return this.f19949a.b();
        }

        @Override // s1.f.b
        public void c(boolean z10) {
            if (f()) {
                return;
            }
            this.f19949a.c(z10);
        }

        @Override // s1.f.b
        public void d(boolean z10) {
            if (f()) {
                this.f19949a.i(z10);
            } else {
                this.f19949a.d(z10);
            }
        }

        @Override // s1.f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f19949a.e(transformationMethod);
        }

        public final boolean f() {
            return !androidx.emoji2.text.c.i();
        }
    }

    public f(TextView textView, boolean z10) {
        s0.f.e(textView, "textView cannot be null");
        if (z10) {
            this.f19945a = new a(textView);
        } else {
            this.f19945a = new c(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f19945a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f19945a.b();
    }

    public void c(boolean z10) {
        this.f19945a.c(z10);
    }

    public void d(boolean z10) {
        this.f19945a.d(z10);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f19945a.e(transformationMethod);
    }
}
