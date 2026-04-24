package h3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: h3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1693g implements InterfaceC1686Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14815c;

    public C1693g(String str, String str2, byte[] bArr) {
        this.f14814b = str;
        this.f14815c = str2;
        this.f14813a = bArr;
    }

    @Override // h3.InterfaceC1686Q
    public String a() {
        return this.f14815c;
    }

    @Override // h3.InterfaceC1686Q
    public InputStream b() {
        if (e()) {
            return null;
        }
        return new ByteArrayInputStream(this.f14813a);
    }

    @Override // h3.InterfaceC1686Q
    public AbstractC2074F.d.b c() {
        byte[] bArrD = d();
        if (bArrD == null) {
            return null;
        }
        return AbstractC2074F.d.b.a().b(bArrD).c(this.f14814b).a();
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
                    gZIPOutputStream.write(this.f14813a);
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
        byte[] bArr = this.f14813a;
        return bArr == null || bArr.length == 0;
    }
}
