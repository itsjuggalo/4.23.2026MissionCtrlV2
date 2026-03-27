package g2;

import f2.AbstractC1246b;
import h2.C1281a;
import java.security.GeneralSecurityException;

/* JADX INFO: renamed from: g2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1266c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1246b.EnumC0193b f11946b = AbstractC1246b.EnumC0193b.f11537a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1281a f11947a;

    public C1266c(byte[] bArr) {
        if (!f11946b.a()) {
            throw new IllegalStateException(new GeneralSecurityException("Can not use Ed25519 in FIPS-mode."));
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException(String.format("Given public key's length is not %s.", 32));
        }
        this.f11947a = C1281a.a(bArr);
    }

    public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length != 64) {
            throw new GeneralSecurityException(String.format("The length of the signature is not %s.", 64));
        }
        if (!AbstractC1264a.s(bArr2, bArr, this.f11947a.c())) {
            throw new GeneralSecurityException("Signature check failed.");
        }
    }
}
