package u4;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class Z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f10371c = Logger.getLogger(Z.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1226h f10372d = new C1226h(8);
    public static final W1.c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f10373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10374b;

    static {
        W1.c cVar = W1.e.f3348c;
        if (cVar.f3350b != null) {
            cVar = new W1.c(cVar.f3349a, (Character) null);
        }
        e = cVar;
    }

    public final void a(W w6) {
        if (this.f10374b == 0) {
            return;
        }
        int i = 0;
        int i6 = 0;
        while (true) {
            int i7 = this.f10374b;
            if (i >= i7) {
                Arrays.fill(this.f10373a, i6 * 2, i7 * 2, (Object) null);
                this.f10374b = i6;
                return;
            }
            if (!Arrays.equals(w6.f10369b, e(i))) {
                byte[] bArrE = e(i);
                Object[] objArr = this.f10373a;
                int i8 = i6 * 2;
                objArr[i8] = bArrE;
                Object obj = objArr[(i * 2) + 1];
                if (objArr instanceof byte[][]) {
                    b(objArr != null ? objArr.length : 0);
                }
                this.f10373a[i8 + 1] = obj;
                i6++;
            }
            i++;
        }
    }

    public final void b(int i) {
        Object[] objArr = new Object[i];
        int i6 = this.f10374b;
        if (i6 != 0) {
            System.arraycopy(this.f10373a, 0, objArr, 0, i6 * 2);
        }
        this.f10373a = objArr;
    }

    public final Object c(W w6) {
        for (int i = this.f10374b - 1; i >= 0; i--) {
            if (Arrays.equals(w6.f10369b, e(i))) {
                Object obj = this.f10373a[(i * 2) + 1];
                if (obj instanceof byte[]) {
                    return w6.a((byte[]) obj);
                }
                obj.getClass();
                throw new ClassCastException();
            }
        }
        return null;
    }

    public final void d(Z z6) {
        int i = z6.f10374b;
        if (i == 0) {
            return;
        }
        Object[] objArr = this.f10373a;
        int length = objArr != null ? objArr.length : 0;
        int i6 = this.f10374b;
        int i7 = length - (i6 * 2);
        if (i6 == 0 || i7 < i * 2) {
            b((i * 2) + (i6 * 2));
        }
        System.arraycopy(z6.f10373a, 0, this.f10373a, this.f10374b * 2, z6.f10374b * 2);
        this.f10374b += z6.f10374b;
    }

    public final byte[] e(int i) {
        return (byte[]) this.f10373a[i * 2];
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(u4.W r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.lang.String r0 = "key"
            s3.D.j(r5, r0)
            java.lang.String r0 = "value"
            s3.D.j(r6, r0)
            int r0 = r4.f10374b
            int r1 = r0 * 2
            if (r1 == 0) goto L19
            java.lang.Object[] r2 = r4.f10373a
            if (r2 == 0) goto L16
            int r2 = r2.length
            goto L17
        L16:
            r2 = 0
        L17:
            if (r1 != r2) goto L24
        L19:
            int r0 = r0 * 4
            r1 = 8
            int r0 = java.lang.Math.max(r0, r1)
            r4.b(r0)
        L24:
            int r0 = r4.f10374b
            java.lang.Object[] r1 = r4.f10373a
            int r2 = r0 * 2
            byte[] r3 = r5.f10369b
            r1[r2] = r3
            byte[] r5 = r5.b(r6)
            java.lang.Object[] r6 = r4.f10373a
            int r0 = r0 * 2
            int r0 = r0 + 1
            r6[r0] = r5
            int r5 = r4.f10374b
            int r5 = r5 + 1
            r4.f10374b = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.Z.f(u4.W, java.lang.Object):void");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i = 0; i < this.f10374b; i++) {
            if (i != 0) {
                sb.append(',');
            }
            byte[] bArrE = e(i);
            Charset charset = U1.d.f3106a;
            String str = new String(bArrE, charset);
            sb.append(str);
            sb.append('=');
            if (str.endsWith("-bin")) {
                Object obj = this.f10373a[(i * 2) + 1];
                if (!(obj instanceof byte[])) {
                    a3.d.r(obj);
                    throw null;
                }
                sb.append(e.c((byte[]) obj));
            } else {
                Object obj2 = this.f10373a[(i * 2) + 1];
                if (!(obj2 instanceof byte[])) {
                    a3.d.r(obj2);
                    throw null;
                }
                sb.append(new String((byte[]) obj2, charset));
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
