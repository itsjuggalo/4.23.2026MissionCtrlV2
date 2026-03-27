package S2;

import V2.F;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: S2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0901h implements M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f7544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7546c;

    public C0901h(String str, String str2, byte[] bArr) {
        this.f7545b = str;
        this.f7546c = str2;
        this.f7544a = bArr;
    }

    @Override // S2.M
    public String a() {
        return this.f7546c;
    }

    @Override // S2.M
    public InputStream b() {
        if (e()) {
            return null;
        }
        return new ByteArrayInputStream(this.f7544a);
    }

    @Override // S2.M
    public F.d.b c() {
        byte[] bArrD = d();
        if (bArrD == null) {
            return null;
        }
        return F.d.b.a().b(bArrD).c(this.f7545b).a();
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
                    gZIPOutputStream.write(this.f7544a);
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
        byte[] bArr = this.f7544a;
        return bArr == null || bArr.length == 0;
    }
}
