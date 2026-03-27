package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FlutterMutatorsStack {
    private List<a> mutators = new ArrayList();
    private Matrix finalMatrix = new Matrix();
    private List<Path> finalClippingPaths = new ArrayList();
    private float finalOpacity = 1.0f;

    public enum b {
        CLIP_RECT,
        CLIP_RRECT,
        CLIP_PATH,
        TRANSFORM,
        OPACITY
    }

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }

    public float getFinalOpacity() {
        return this.finalOpacity;
    }

    public List<a> getMutators() {
        return this.mutators;
    }

    public void pushClipPath(Path path) {
        this.mutators.add(new a(path));
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRRect(int i7, int i8, int i9, int i10, float[] fArr) {
        Rect rect = new Rect(i7, i8, i9, i10);
        this.mutators.add(new a(rect, fArr));
        Path path = new Path();
        path.addRoundRect(new RectF(rect), fArr, Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRect(int i7, int i8, int i9, int i10) {
        Rect rect = new Rect(i7, i8, i9, i10);
        this.mutators.add(new a(rect));
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushOpacity(float f7) {
        this.mutators.add(new a(f7));
        this.finalOpacity *= f7;
    }

    public void pushTransform(float[] fArr) {
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        a aVar = new a(matrix);
        this.mutators.add(aVar);
        this.finalMatrix.preConcat(aVar.a());
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Matrix f16533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Rect f16534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Path f16535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float[] f16536d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f16537e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f16538f;

        public a(Rect rect) {
            this.f16537e = 1.0f;
            this.f16538f = b.CLIP_RECT;
            this.f16534b = rect;
        }

        public Matrix a() {
            return this.f16533a;
        }

        public a(Rect rect, float[] fArr) {
            this.f16537e = 1.0f;
            this.f16538f = b.CLIP_RRECT;
            this.f16534b = rect;
            this.f16536d = fArr;
        }

        public a(Path path) {
            this.f16537e = 1.0f;
            this.f16538f = b.CLIP_PATH;
            this.f16535c = path;
        }

        public a(Matrix matrix) {
            this.f16537e = 1.0f;
            this.f16538f = b.TRANSFORM;
            this.f16533a = matrix;
        }

        public a(float f7) {
            this.f16537e = 1.0f;
            this.f16538f = b.OPACITY;
            this.f16537e = f7;
        }
    }
}
