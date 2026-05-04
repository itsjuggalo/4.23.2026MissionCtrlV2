package u7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f22268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22270c;

    public g(String str, String str2, byte[] bArr) {
        this.f22269b = str;
        this.f22270c = str2;
        this.f22268a = bArr;
    }

    @Override // u7.k0
    public String a() {
        return this.f22270c;
    }

    @Override // u7.k0
    public InputStream b() {
        if (e()) {
            return null;
        }
        return new ByteArrayInputStream(this.f22268a);
    }

    @Override // u7.k0
    public f0.d.b c() {
        byte[] bArrD = d();
        if (bArrD == null) {
            return null;
        }
        return f0.d.b.a().b(bArrD).c(this.f22269b).a();
    }

    public final byte[] d() {
        if (e()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.f22268a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final boolean e() {
        byte[] bArr = this.f22268a;
        return bArr == null || bArr.length == 0;
    }
}
