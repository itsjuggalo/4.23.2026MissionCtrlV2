package o0;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.revenuecat.purchases.common.Constants;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: renamed from: o0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2288g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float[] f20000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float[] f20001i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20008g;

    static {
        float[] fArr = new float[16];
        f20000h = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        f20001i = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.translateM(fArr2, 0, 0.0f, 1.0f, 0.0f);
        Matrix.scaleM(fArr2, 0, 1.0f, -1.0f, 1.0f);
    }

    public C2288g(int i7) {
        this.f20002a = i7;
        if (i7 == 0) {
            this.f20008g = 3553;
            this.f20003b = c("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else {
            if (i7 != 1) {
                throw new RuntimeException("Unhandled type " + i7);
            }
            this.f20008g = 36197;
            this.f20003b = c("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        }
        int i8 = this.f20003b;
        if (i8 == 0) {
            throw new RuntimeException("Unable to create program");
        }
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(i8, "aPosition");
        this.f20006e = iGlGetAttribLocation;
        b(iGlGetAttribLocation, "aPosition");
        int iGlGetAttribLocation2 = GLES20.glGetAttribLocation(this.f20003b, "aTextureCoord");
        this.f20007f = iGlGetAttribLocation2;
        b(iGlGetAttribLocation2, "aTextureCoord");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f20003b, "uMVPMatrix");
        this.f20004c = iGlGetUniformLocation;
        b(iGlGetUniformLocation, "uMVPMatrix");
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f20003b, "uTexMatrix");
        this.f20005d = iGlGetUniformLocation2;
        b(iGlGetUniformLocation2, "uTexMatrix");
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

    public static void b(int i7, String str) {
        if (i7 >= 0) {
            return;
        }
        throw new RuntimeException("Unable to locate '" + str + "' in program");
    }

    public static int c(String str, String str2) {
        int iF;
        int iF2 = f(35633, str);
        if (iF2 == 0 || (iF = f(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (iGlCreateProgram == 0) {
            Log.e("Texture2dProgram", "Could not create program");
        }
        GLES20.glAttachShader(iGlCreateProgram, iF2);
        a("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iF);
        a("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        Log.e("Texture2dProgram", "Could not link program: ");
        Log.e("Texture2dProgram", GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public static int f(int i7, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i7);
        a("glCreateShader type=" + i7);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        Log.e("Texture2dProgram", "Could not compile shader " + i7 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(iGlCreateShader));
        Log.e("Texture2dProgram", sb.toString());
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public int d() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        a("glGenTextures");
        int i7 = iArr[0];
        GLES20.glBindTexture(this.f20008g, i7);
        a("glBindTexture " + i7);
        GLES20.glTexParameterf(this.f20008g, 10241, 9728.0f);
        int i8 = this.f20008g;
        GLES20.glTexParameterf(i8, 10240, i8 != 3553 ? 9729.0f : 9728.0f);
        GLES20.glTexParameteri(this.f20008g, 10242, 33071);
        GLES20.glTexParameteri(this.f20008g, 10243, 33071);
        a("glTexParameter");
        return i7;
    }

    public void e(float[] fArr, FloatBuffer floatBuffer, int i7, int i8, int i9, int i10, float[] fArr2, FloatBuffer floatBuffer2, int i11, int i12) {
        a("draw start");
        GLES20.glUseProgram(this.f20003b);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f20008g, i11);
        GLES20.glUniformMatrix4fv(this.f20004c, 1, false, fArr, 0);
        a("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.f20005d, 1, false, fArr2, 0);
        a("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f20006e);
        a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f20006e, i9, 5126, false, i10, (Buffer) floatBuffer);
        a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f20007f);
        a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f20007f, 2, 5126, false, i12, (Buffer) floatBuffer2);
        a("glVertexAttribPointer");
        GLES20.glDrawArrays(5, i7, i8);
        a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f20006e);
        GLES20.glDisableVertexAttribArray(this.f20007f);
        GLES20.glBindTexture(this.f20008g, 0);
        GLES20.glUseProgram(0);
    }

    public void g(int i7, Bitmap bitmap) {
        GLES20.glBindTexture(this.f20008g, i7);
        GLUtils.texImage2D(this.f20008g, 0, bitmap, 0);
    }

    public void h() {
        Log.d("Texture2dProgram", "deleting program " + this.f20003b);
        GLES20.glDeleteProgram(this.f20003b);
        this.f20003b = -1;
    }
}
