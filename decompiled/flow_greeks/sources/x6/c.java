package x6;

import java.security.GeneralSecurityException;
import w6.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b.EnumC0412b f24236b = b.EnumC0412b.f23675a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y6.a f24237a;

    public c(byte[] bArr) {
        if (!f24236b.a()) {
            throw new IllegalStateException(new GeneralSecurityException("Can not use Ed25519 in FIPS-mode."));
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException(String.format("Given public key's length is not %s.", 32));
        }
        this.f24237a = y6.a.a(bArr);
    }

    public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length != 64) {
            throw new GeneralSecurityException(String.format("The length of the signature is not %s.", 64));
        }
        if (!a.s(bArr2, bArr, this.f24237a.c())) {
            throw new GeneralSecurityException("Signature check failed.");
        }
    }
}
