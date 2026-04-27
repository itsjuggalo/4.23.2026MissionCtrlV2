package b0;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: b0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0378g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float[] f4860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float[] f4861h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4865d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4866f;

    static {
        float[] fArr = new float[16];
        f4860g = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        f4861h = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.translateM(fArr2, 0, 0.0f, 1.0f, 0.0f);
        Matrix.scaleM(fArr2, 0, 1.0f, -1.0f, 1.0f);
    }

    public static void a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        String str2 = str + ": glError 0x" + Integer.toHexString(iGlGetError);
        Log.e("Texture2dProgram", str2);
        throw new RuntimeException(str2);
    }

    public static void b(int i, String str) {
        if (i < 0) {
            throw new RuntimeException(AbstractC1024h.c("Unable to locate '", str, "' in program"));
        }
    }

    public static int c(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        a("glCreateShader type=" + i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        Log.e("Texture2dProgram", "Could not compile shader " + i + ":");
        StringBuilder sb = new StringBuilder(" ");
        sb.append(GLES20.glGetShaderInfoLog(iGlCreateShader));
        Log.e("Texture2dProgram", sb.toString());
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }
}
